package com.sina.weibo.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sina.weibo.http.ImageItem;
import com.sina.weibo.model.Paging;
import com.sina.weibo.model.SimpleStatus;
import com.sina.weibo.model.Status;
import com.sina.weibo.model.StatusWapper;
import com.sina.weibo.model.WeiboException;

public class TimelineTest {

	public static String token;
	public static String wid;
	public static String wids;

	@Before
	public void prepared() {
		token = "2.00TaAMACdcZIJC1694b41295JLRojB";
		wid = "3658805823088157";
		wids = "3658805823088157,3367321181575224,3648558105935644";
	}

	@Test
	public void testgetRepostTimeline_数据检索超出最大范围时返回正确的JSON() throws WeiboException {
		Timeline tm = new Timeline();
		Paging page = new Paging(11, 200);
		StatusWapper status = tm.getRepostTimeline(wid, page, token);
		assertEquals(0, status.getStatuses().size());
	}

	@Test
	public void testTimelineShowBatch_新增批量获取微博接口() throws WeiboException {
		Timeline tm = new Timeline();
		tm.client.setToken(token);
		List<Status> status = tm.showBatch(wids, 0);
		//			System.out.println(status);
		assertEquals(3, status.size());
		assertTrue(wids.contains(status.get(0).getId()));
		assertTrue(status.get(0).getAttitudesCount() > 0);
	}

	@Test
	public void testUploadStatus_异常没有过度包装() throws IOException {
		try (BufferedInputStream in = new BufferedInputStream(this.getClass().getClassLoader()
				.getResourceAsStream("thinkpad_t430s.jpg"));) {
			int picSize = in.available();
			byte[] picContent = new byte[picSize];
			in.read(picContent);
			ImageItem pic = new ImageItem("pic", picContent);
			String s = java.net.URLEncoder.encode("微博内容。。。", "utf-8");
			Timeline tl = new Timeline();
			String token = "2.00SlDQsDdcZIJC94e5308f67sRL13E"; // 无效的token
			tl.uploadStatus(s, pic, token);
			fail();
		} catch (WeiboException e) {
			assertEquals(21332, e.getErrorCode());
			assertEquals("invalid_access_token", e.getError());
		}
	}

	@Test
	public void testShowStatus_增加赞字段() throws WeiboException {
		Timeline tm = new Timeline();
		tm.client.setToken(token);
		Status status = tm.showStatus(wid);
		assertTrue(status.getAttitudesCount() > 0);
	}

	@Test
	public void testShowBatchStatus_增加批量获取微博转评数接口() throws WeiboException {
		Timeline tm = new Timeline();
		tm.client.setToken(token);
		List<SimpleStatus> statuses = tm.showBatchStatus(wids);
		assertTrue(wids.contains(statuses.get(0).getId()));
		assertTrue(statuses.get(0).getRepostsCount() > 0);
		assertTrue(statuses.get(0).getCommentsCount() > 0);
		assertTrue(statuses.get(0).getAttitudesCount() > 0);
	}

}

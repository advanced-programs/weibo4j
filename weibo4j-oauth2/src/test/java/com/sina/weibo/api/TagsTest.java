package com.sina.weibo.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.sina.weibo.model.TagWapper;
import com.sina.weibo.model.WeiboException;

public class TagsTest {

	@Test
	public void testGetTagsBatch_返回为TagWapperList() throws WeiboException {
		Tags tm = new Tags();
		List<TagWapper> tags = null;
		String uids = "1427995647,1649155730,1862087393";
		tags = tm.getTagsBatch(uids, "2.00TaAMACdcZIJC1694b41295JLRojB");
		//			for (int j = 0; j < tags.size(); j++) {
		//				for (int i = 0; i < tags.get(j).getTags().size(); i++) {
		//					System.out.println(tags.get(j).getTags().get(i).getValue());
		//				}
		//			}
		assertEquals(3, tags.size());
		assertTrue(uids.contains(tags.get(0).getId()));
	}

}

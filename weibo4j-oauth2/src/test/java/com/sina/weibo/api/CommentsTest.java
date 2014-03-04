package com.sina.weibo.api;

import org.junit.Test;

import com.sina.weibo.model.CommentWapper;
import com.sina.weibo.model.Paging;
import com.sina.weibo.model.WeiboException;

public class CommentsTest {

	private static final String[] TOKENS = { "2.00OKXevBdcZIJCee8ff5f68dtzKiEB", "2.00zalRJCdcZIJC50a6e10602tN_MzC",
			"2.00O7rrHDdcZIJC569baaa588V3CnkC", "2.00Wtjb9CdcZIJC9f2481289ekNqW1D", "2.00hkxorBdcZIJCb01daafc8aDnDcjC",
			"2.00ZFfw9DdcZIJC24c2bd2ad0KFW3OB", };

	@Test
	public void testGetCommentMentionsAll() throws WeiboException {
		Comments comments = new Comments();
		CommentWapper result = comments.getCommentMentions(TOKENS[0]);
		System.out.println(result.getTotalNumber());
	}

	@Test
	public void testGetCommentMentions() throws WeiboException {
		Comments comments = new Comments();
		CommentWapper result = comments.getCommentMentions(new Paging(1,200), 0, 0, TOKENS[0]);
		System.out.println(result.getTotalNumber());
	}

}

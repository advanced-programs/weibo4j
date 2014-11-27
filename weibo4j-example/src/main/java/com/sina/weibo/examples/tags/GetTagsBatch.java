package com.sina.weibo.examples.tags;

import java.util.List;

import com.sina.weibo.api.Tags;
import com.sina.weibo.model.TagWapper;
import com.sina.weibo.model.WeiboException;

public class GetTagsBatch {

	public static void main(String[] args) {
		//		String access_token = args[0];
		Tags tm = new Tags();
		//		tm.client.setToken(access_token);
		List<TagWapper> tags = null;
		String uids = args[1];
		try {
			;
			tags = tm.getTagsBatch(uids, "");
			System.out.println(tags.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}

package com.sina.weibo.examples.timeline;

import com.sina.weibo.api.Timeline;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.json.JSONArray;
import com.sina.weibo.model.WeiboException;


public class GetCommentsWeekly {
	public static void main(String[] args) {
		String access_token = args[0];
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			JSONArray status = tm.getCommentsWeekly();
			Log.logInfo(status.toString());

		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}

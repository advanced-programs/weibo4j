package com.sina.weibo.examples.timeline;

import com.sina.weibo.api.Timeline;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.WeiboException;

public class QueryMid {

	public static void main(String[] args) {
		//		String access_token = args[0];
		String id = args[1];
		Timeline tm = new Timeline();
		//		tm.client.setToken(access_token);
		try {
			JSONObject mid = tm.QueryMid(1, id, "");
			Log.logInfo(mid.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

package com.sina.weibo.examples.timeline;

import com.sina.weibo.api.Timeline;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.WeiboException;


public class QueryId {

	public static void main(String[] args) {
		String access_token = args[0];
		String mid =  args[1];
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			JSONObject id = tm.QueryId( mid, 1,1);
				Log.logInfo(String.valueOf(id));			
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}

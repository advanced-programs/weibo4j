package com.sina.weibo.examples.trends;

import com.sina.weibo.api.Trend;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.WeiboException;


public class IsFollow {

	public static void main(String[] args) {
		String access_token = args[0];
		String trend_name = args[1];
		Trend tm = new Trend();
		tm.client.setToken(access_token);
		try {
			JSONObject result = tm.isFollow(trend_name);
			Log.logInfo(String.valueOf(result));
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

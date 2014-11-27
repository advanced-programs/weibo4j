package com.sina.weibo.examples.trends;

import com.sina.weibo.api.Trend;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.WeiboException;


public class TrendDestroy {

	public static void main(String[] args){
		String access_token = args[0];
		Trend tm = new Trend();
		tm.client.setToken(access_token);
		int trendId = Integer.parseInt(args[1]);
		try {
			JSONObject result = tm.trendsDestroy(trendId);
			Log.logInfo(String.valueOf(result));
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

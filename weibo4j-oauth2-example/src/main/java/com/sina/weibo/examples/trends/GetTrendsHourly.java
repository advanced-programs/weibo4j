package com.sina.weibo.examples.trends;

import java.util.List;

import com.sina.weibo.api.Trend;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Trends;
import com.sina.weibo.model.WeiboException;


public class GetTrendsHourly {

	public static void main(String[] args) {
		String access_token = args[0];
		Trend tm = new Trend();
		tm.client.setToken(access_token);
		List<Trends> trends = null;
		try {
			trends = tm.getTrendsHourly();
			for(Trends ts : trends){
				Log.logInfo(ts.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

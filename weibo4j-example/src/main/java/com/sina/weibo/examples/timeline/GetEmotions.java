package com.sina.weibo.examples.timeline;

import java.util.List;

import com.sina.weibo.api.Timeline;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Emotion;
import com.sina.weibo.model.WeiboException;

public class GetEmotions {

	public static void main(String[] args) {
		//		String access_token = args[0];
		Timeline tm = new Timeline();
		//		tm.client.setToken(access_token);
		try {
			List<Emotion> emotions = tm.getEmotions("");
			for (Emotion e : emotions) {
				Log.logInfo(e.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

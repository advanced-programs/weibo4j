package com.sina.weibo.examples.timeline;

import com.sina.weibo.api.Timeline;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Status;
import com.sina.weibo.model.StatusWapper;
import com.sina.weibo.model.WeiboException;

public class GetUserTimeline {

	public static void main(String[] args) {
		//		String access_token = args[0];
		Timeline tm = new Timeline();
		//		tm.client.setToken(access_token);
		try {
			StatusWapper status = tm.getUserTimeline("");
			for (Status s : status.getStatuses()) {
				Log.logInfo(s.toString());
			}
			System.out.println(status.getNextCursor());
			System.out.println(status.getPreviousCursor());
			System.out.println(status.getTotalNumber());
			System.out.println(status.getHasvisible());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}

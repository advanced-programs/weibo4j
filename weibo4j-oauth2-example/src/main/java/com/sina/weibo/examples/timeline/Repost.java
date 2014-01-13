package com.sina.weibo.examples.timeline;

import com.sina.weibo.api.Timeline;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Status;
import com.sina.weibo.model.WeiboException;


public class Repost {

	public static void main(String[] args) {
		String access_token = args[0];
		String id =  args[1];
		Timeline tm = new Timeline();
		tm.setToken(access_token);
		try {
			//			Status status = tm.Repost(id);
			//			Status status = tm.Repost(id, "[哈哈]", 1);

			id = "3633289778934606";
			String content = "上帝啊！你的代码就如群星般闪耀～～ //@神勇无敌小密探: +1";
			int iscomment = 0;

			Status status = tm.Repost(id, content, iscomment);
			Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

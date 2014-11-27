package com.sina.weibo.examples.friendships;

import com.sina.weibo.api.Friendships;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.WeiboException;

public class GetFriendsIds {

	public static void main(String[] args) {
		String uid = args[1];
		Friendships fm = new Friendships();
		//		fm.client.setToken(access_token);
		try {
			String[] ids = fm.getFriendsIdsByUid(uid, "");
			for (String s : ids) {
				Log.logInfo(s);
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

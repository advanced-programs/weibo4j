package com.sina.weibo.examples.friendships;

import com.sina.weibo.api.Friendships;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.WeiboException;


public class GetFriendsBilateralIds {

	public static void main(String[] args) {
		String access_token = args[0];
		String uid = args[1];
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		try {
			String[] ids = fm.getFriendsBilateralIds(uid);
			for(String s : ids){
				Log.logInfo(s);
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}



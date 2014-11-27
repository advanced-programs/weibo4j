package com.sina.weibo.examples.friendships;

import com.sina.weibo.api.Friendships;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.User;
import com.sina.weibo.model.WeiboException;

public class CreateFriendships {

	public static void main(String[] args) {
		String uid = args[1];
		Friendships fm = new Friendships();
		//		fm.client.setToken(access_token);
		try {
			User user = fm.createFriendshipsById(uid, "");
			Log.logInfo(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}

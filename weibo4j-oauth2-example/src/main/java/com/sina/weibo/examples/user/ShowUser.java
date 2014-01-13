package com.sina.weibo.examples.user;

import com.sina.weibo.api.Users;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.User;
import com.sina.weibo.model.WeiboException;


public class ShowUser {

	public static void main(String[] args) {
		String access_token = args[0];
		String uid = args[1];
		Users um = new Users();
		um.client.setToken(access_token);
		try {
			User user = um.showUserById(uid);
			Log.logInfo(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

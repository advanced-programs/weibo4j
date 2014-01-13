package com.sina.weibo.examples.user;

import com.sina.weibo.api.Users;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.json.JSONArray;
import com.sina.weibo.model.WeiboException;


public class UserCount {

	public static void main(String[] args) {
		String access_token = args[0];
		String uids =  args[1];
		Users um = new Users();
		um.client.setToken(access_token);
		try {
			JSONArray user = um.getUserCount(uids);
			Log.logInfo(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

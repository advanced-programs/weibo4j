package com.sina.weibo.examples.friendships;

import com.sina.weibo.api.Friendships;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.User;
import com.sina.weibo.model.WeiboException;

public class DestroyFriendshipsDestroyById {

	public static void main(String[] args) {
		String uid = args[1];
		Friendships fm = new Friendships();
		//		fm.client.setToken(access_token);
		try {
			User fv = fm.destroyFriendshipsDestroyById(uid, "");
			Log.logInfo(fv.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

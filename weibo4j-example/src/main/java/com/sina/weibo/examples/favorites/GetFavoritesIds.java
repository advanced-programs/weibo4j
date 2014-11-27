package com.sina.weibo.examples.favorites;

import com.sina.weibo.api.Favorite;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.WeiboException;


public class GetFavoritesIds {

	public static void main(String[] args) {
		String access_token =args[0];
		Favorite fm = new Favorite();
		fm.client.setToken(access_token);
		try {
			JSONObject ids = fm.getFavoritesIds();
			Log.logInfo(ids.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}

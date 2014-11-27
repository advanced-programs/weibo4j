package com.sina.weibo.examples.favorites;

import com.sina.weibo.api.Favorite;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Favorites;
import com.sina.weibo.model.WeiboException;


public class DestroyFavorites {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String access_token = args[0];
		Favorite fm = new Favorite();
		fm.client.setToken(access_token);
		String id = args[1];
		try {
			Favorites favors =fm.destroyFavorites(id);
			Log.logInfo(favors.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

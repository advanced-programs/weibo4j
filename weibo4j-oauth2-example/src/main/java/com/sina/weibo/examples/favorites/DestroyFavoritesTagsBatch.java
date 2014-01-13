package com.sina.weibo.examples.favorites;

import com.sina.weibo.api.Favorite;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.WeiboException;


public class DestroyFavoritesTagsBatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String access_token = args[0];
		Favorite fm = new Favorite();
		fm.client.setToken(access_token);
		boolean result = false;
		String ids = args[1];
		try {
			result = fm.destroyFavoritesTagsBatch(ids);
			Log.logInfo(String.valueOf(result));
		} catch (WeiboException e) {

			e.printStackTrace();
		}
	}

}
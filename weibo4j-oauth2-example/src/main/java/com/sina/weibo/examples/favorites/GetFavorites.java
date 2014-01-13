package com.sina.weibo.examples.favorites;

import java.util.List;

import com.sina.weibo.api.Favorite;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Favorites;
import com.sina.weibo.model.WeiboException;


public class GetFavorites {

	public static void main(String[] args) {
		String access_token = args[0];
		Favorite fm = new Favorite();
		fm.client.setToken(access_token);
		try {
			List<Favorites> favors = fm.getFavorites();
			for(Favorites s : favors){
				Log.logInfo(s.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

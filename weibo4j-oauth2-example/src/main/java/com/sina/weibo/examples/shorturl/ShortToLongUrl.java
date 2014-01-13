package com.sina.weibo.examples.shorturl;

import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.WeiboException;

public class ShortToLongUrl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String access_token = args[0];
		String url = args[1];
		com.sina.weibo.api.ShortUrl su = new com.sina.weibo.api.ShortUrl();
		su.client.setToken(access_token);
		try {
			JSONObject jo = su.shortToLongUrl(url);
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}


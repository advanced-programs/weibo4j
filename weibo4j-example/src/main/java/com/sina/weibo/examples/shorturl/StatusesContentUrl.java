package com.sina.weibo.examples.shorturl;

import com.sina.weibo.api.ShortUrl;
import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.WeiboException;


public class StatusesContentUrl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String access_token = args[0];
		String url = args[1];
		ShortUrl su = new ShortUrl();
		su.client.setToken(access_token);
		try {
			JSONObject jo = su.statusesContentUrl(url);
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

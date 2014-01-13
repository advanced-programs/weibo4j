package com.sina.weibo.examples.publicservice;

import com.sina.weibo.api.PublicService;
import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.WeiboException;


public class GetTimeZone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {;
		String access_token = args[0];
		PublicService ps = new PublicService();
		ps.client.setToken(access_token);
		try {
			JSONObject	jo = ps.getTomeZone();
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
	}

}

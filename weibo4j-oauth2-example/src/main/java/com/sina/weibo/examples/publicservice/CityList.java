package com.sina.weibo.examples.publicservice;

import com.sina.weibo.api.PublicService;
import com.sina.weibo.json.JSONArray;
import com.sina.weibo.model.WeiboException;


public class CityList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String access_token =args[0];
		String province = args[1];
		PublicService ps = new PublicService();
		ps.client.setToken(access_token);
		JSONArray jo;
		try {
			jo = ps.cityList(province);
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
	}

}
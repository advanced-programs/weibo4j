package com.sina.weibo.examples.remind;

import com.sina.weibo.api.Reminds;
import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.WeiboException;


public class Remind {

	public static void main(String[] args) {
		String access_token = args[0];
		Reminds rm = new Reminds();
		rm.client.setToken(access_token);
		try {
			JSONObject jo = rm.getUnreadCountOfRemind();
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
	}

}

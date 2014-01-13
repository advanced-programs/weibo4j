package com.sina.weibo.examples.account;

import com.sina.weibo.api.Account;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.RateLimitStatus;
import com.sina.weibo.model.WeiboException;


public class GetAccountRateLimitStatus {

	public static void main(String[] args) {
		String access_token =args[0];
		Account am = new Account();
		am.client.setToken(access_token);
		try {
            RateLimitStatus json = am.getAccountRateLimitStatus();
			Log.logInfo(json.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

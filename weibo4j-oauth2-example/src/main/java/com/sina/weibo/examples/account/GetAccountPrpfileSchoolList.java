package com.sina.weibo.examples.account;

import java.util.List;

import com.sina.weibo.api.Account;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.School;
import com.sina.weibo.model.WeiboException;


public class GetAccountPrpfileSchoolList {

	public static void main(String[] args) {
		String access_token = args[0];// 输入授权后的AccessToken
		Account am = new Account();
		am.client.setToken(access_token);
		try {
			List<School> schools = am.getAccountPrpfileSchoolList();
			for (School school : schools) {
				Log.logInfo(school.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

package com.sina.weibo.examples.search;

import com.sina.weibo.api.Search;
import com.sina.weibo.model.WeiboException;


public class searchSuggestionsUsers {

	public static void main(String[] args) {
		String access_token=args[0];
		Search search = new Search();
		search.client.setToken(access_token);
		try {
			search.searchSuggestionsUsers(args[1]);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

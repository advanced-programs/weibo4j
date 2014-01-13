package com.sina.weibo.examples.place;

import com.sina.weibo.model.WeiboException;

public class Place {

	public static void main(String[] args) {
		com.sina.weibo.api.Place wp = new com.sina.weibo.api.Place();
		wp.client.setToken(args[1]);
		try {
			wp.poisUsersList(args[0]);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

package com.sina.weibo.api;

import com.sina.weibo.http.HttpClient;

public class Weibo implements java.io.Serializable {

	private static final long serialVersionUID = 4282616848978535016L;

	public HttpClient client = new HttpClient();

	/***
	 * 此设置token的方式是线程不安全的，最好将新浪的sdk方法改造成发送是传递token
	 * @param token
	 */
	@Deprecated
	public void setToken(String token) {
		client.setToken(token);
	}

}
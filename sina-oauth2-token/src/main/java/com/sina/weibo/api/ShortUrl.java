package com.sina.weibo.api;

import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.PostParameter;
import com.sina.weibo.model.WeiboException;
import com.sina.weibo.util.WeiboConfig;

public class ShortUrl extends Weibo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取短链接的总点击数
	 * 
	 * 
	 */
	public JSONObject clicksOfUrl(String url_short) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "short_url/clicks.json",
				new PostParameter[] { new PostParameter("url_short", url_short) }).asJSONObject();
	}

	/**
	 * 获取短链接在微博上的微博评论数 
	 * 
	 * 
	 */
	public JSONObject commentCountOfUrl(String url_short) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "short_url/comment/counts.json",
				new PostParameter[] { new PostParameter("url_short", url_short) }).asJSONObject();
	}

	/**
	 * 获取包含指定单个短链接的最新微博评论 
	 * 
	 */
	public JSONObject commentsContentUrl(String url_short) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "short_url/comment/comments.json",
				new PostParameter[] { new PostParameter("url_short", url_short) }).asJSONObject();
	}

	/**
	 * 
	 * 获取一个短链接点击的地区来源和数量 
	 * 
	 */
	public JSONObject locationsOfUrl(String url_short) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "short_url/locations.json",
				new PostParameter[] { new PostParameter("url_short", url_short) }).asJSONObject();
	}

	/**  
	 * 长链接转为短链接
	 *
	 *
	 */
	public JSONObject longToShortUrl(String url_long) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "short_url/shorten.json",
				new PostParameter[] { new PostParameter("url_long", url_long) }).asJSONObject();
	}

	/**
	 * 获取一个短链接点击的referer来源和数量 
	 * 
	 * 
	 */
	public JSONObject referersOfUrl(String url_short) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "short_url/referers.json",
				new PostParameter[] { new PostParameter("url_short", url_short) }).asJSONObject();
	}

	/**
	 * 获取短链接在微博上的微博分享数 
	 * 
	 * 
	 * 
	 */
	public JSONObject shareCountsOfUrl(String url_short) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "short_url/share/counts.json",
				new PostParameter[] { new PostParameter("url_short", url_short) }).asJSONObject();
	}

	/**
	 * 短链接转为长链接
	 * 
	 */
	public JSONObject shortToLongUrl(String url_short) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "short_url/expand.json",
				new PostParameter[] { new PostParameter("url_short", url_short) }).asJSONObject();
	}

	/**
	 * 获取包含指定单个短链接的最新微博内容 
	 * 
	 * 
	 */
	public JSONObject statusesContentUrl(String url_short) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "short_url/share/statuses.json",
				new PostParameter[] { new PostParameter("url_short", url_short) }).asJSONObject();
	}
}

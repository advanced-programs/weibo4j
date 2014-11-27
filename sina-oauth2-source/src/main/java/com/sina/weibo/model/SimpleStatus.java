package com.sina.weibo.model;

import java.util.ArrayList;
import java.util.List;

import com.sina.weibo.http.Response;
import com.sina.weibo.json.JSONArray;
import com.sina.weibo.json.JSONException;
import com.sina.weibo.json.JSONObject;

public class SimpleStatus extends WeiboResponse implements java.io.Serializable {

	private static final long serialVersionUID = -3448467570052106505L;

	private String id;
	private int commentsCount;
	private int repostsCount;
	private int attitudesCount;

	public static List<SimpleStatus> constructSimpleStatus(Response res) throws WeiboException {
		try {
			JSONArray list = res.asJSONArray();
			List<SimpleStatus> statuses = new ArrayList<SimpleStatus>(list.length());
			for (int i = 0; i < list.length(); i++) {
				statuses.add(new SimpleStatus(list.getJSONObject(i)));
			}
			return statuses;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		} catch (WeiboException te) {
			throw te;
		}
	}

	public SimpleStatus(JSONObject json) throws WeiboException, JSONException {
		constructJson(json);
	}

	private void constructJson(JSONObject json) throws WeiboException {
		try {
			id = json.getString("id");
			repostsCount = json.getInt("reposts");
			commentsCount = json.getInt("comments");
			attitudesCount = json.getInt("attitudes");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(), je);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public int getRepostsCount() {
		return repostsCount;
	}

	public void setRepostsCount(int repostsCount) {
		this.repostsCount = repostsCount;
	}

	public int getAttitudesCount() {
		return attitudesCount;
	}

	public void setAttitudesCount(int attitudesCount) {
		this.attitudesCount = attitudesCount;
	}

}

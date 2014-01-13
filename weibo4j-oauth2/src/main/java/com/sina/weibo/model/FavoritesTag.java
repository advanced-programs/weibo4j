package com.sina.weibo.model;

import java.util.ArrayList;
import java.util.List;

import com.sina.weibo.http.Response;
import com.sina.weibo.json.JSONArray;
import com.sina.weibo.json.JSONException;
import com.sina.weibo.json.JSONObject;

/**
 * @author sinaWeibo
 * 
 */
public class FavoritesTag extends WeiboResponse implements java.io.Serializable {

	private static final long serialVersionUID = 2177657076940291492L;

	public static List<FavoritesTag> constructTag(Response res) throws WeiboException {
		try {
			JSONArray list = res.asJSONObject().getJSONArray("tags");
			int size = list.length();
			List<FavoritesTag> tags = new ArrayList<FavoritesTag>(size);
			for (int i = 0; i < size; i++) {
				tags.add(new FavoritesTag(list.getJSONObject(i)));
			}
			return tags;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		} catch (WeiboException te) {
			throw te;
		}
	}

	public static List<FavoritesTag> constructTags(Response res) throws WeiboException {
		try {
			JSONArray list = res.asJSONArray();
			int size = list.length();
			List<FavoritesTag> tags = new ArrayList<FavoritesTag>(size);
			for (int i = 0; i < size; i++) {
				tags.add(new FavoritesTag(list.getJSONObject(i)));
			}
			return tags;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		} catch (WeiboException te) {
			throw te;
		}
	}

	private String id; //标签id

	private String tag; //标签

	private int count; //该标签下收藏的微博数

	public FavoritesTag(JSONObject json) throws WeiboException, JSONException {
		id = json.getString("id");
		tag = json.getString("tag");
		if (!json.isNull("count")) {
			count = json.getInt("count");
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoritesTag other = (FavoritesTag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public int getCount() {
		return count;
	}

	public String getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "FavoritesTag [id=" + id + ", tag=" + tag + ", count=" + count + "]";
	}

}

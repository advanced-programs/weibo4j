package com.sina.weibo.model;

import com.sina.weibo.json.JSONException;
import com.sina.weibo.json.JSONObject;

public class Visible {
	private int type;
	private int list_id;

	public Visible(JSONObject json) throws JSONException {
		this.type = json.getInt("type");
		this.list_id = json.getInt("list_id");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visible other = (Visible) obj;
		if (list_id != other.list_id)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public int getList_id() {
		return list_id;
	}

	public int getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + list_id;
		result = prime * result + type;
		return result;
	}

	public void setList_id(int list_id) {
		this.list_id = list_id;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Visible [type=" + type + ", list_id=" + list_id + "]";
	}

}

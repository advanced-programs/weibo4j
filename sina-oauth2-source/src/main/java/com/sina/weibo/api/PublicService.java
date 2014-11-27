package com.sina.weibo.api;

import com.sina.weibo.json.JSONArray;
import com.sina.weibo.json.JSONObject;
import com.sina.weibo.model.PostParameter;
import com.sina.weibo.model.WeiboException;
import com.sina.weibo.util.WeiboConfig;

public class PublicService extends Weibo {

	private static final long serialVersionUID = 1L;

	/**
	 * 获取城市列表 
	 * 
	 * 
	 */
	public JSONArray cityList(String province) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",
				new PostParameter[] { new PostParameter("province", province) }).asJSONArray();
	}

	public JSONArray cityList(String province, String language) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",
						new PostParameter[] { new PostParameter("province", province),
								new PostParameter("language", language) }).asJSONArray();
	}

	public JSONArray cityList(String province, String capital, String language) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "common/get_city.json",
				new PostParameter[] { new PostParameter("province", province), new PostParameter("capital", capital),
						new PostParameter("language", language) }).asJSONArray();
	}

	public JSONArray cityListOfCapital(String province, String capital) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",
				new PostParameter[] { new PostParameter("province", province), new PostParameter("capital", capital) })
				.asJSONArray();
	}

	/**
	 * 获取国家列表 
	 * 
	 * 
	 */
	public JSONArray countryList() throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_country.json").asJSONArray();
	}

	public JSONArray countryList(String language) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_country.json",
				new PostParameter[] { new PostParameter("language", language) }).asJSONArray();
	}

	public JSONArray countryList(String capital, String language) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_country.json",
				new PostParameter[] { new PostParameter("capital", capital), new PostParameter("language", language) })
				.asJSONArray();
	}

	public JSONArray countryListOfCapital(String capital) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_country.json",
				new PostParameter[] { new PostParameter("capital", capital) }).asJSONArray();
	}

	/**
	 * 通过地址编码获取地址名称 
	 * 
	 * 
	 */
	public JSONArray getLocationByCode(String codes) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/code_to_location.json",
				new PostParameter[] { new PostParameter("codes", codes) }).asJSONArray();
	}

	/**
	 * 获取时区配置表 
	 * 
	 */
	public JSONObject getTomeZone() throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_timezone.json").asJSONObject();
	}

	/**
	 * 获取省份列表 
	 * 
	 * 
	 */
	public JSONArray provinceList(String country) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_province.json",
				new PostParameter[] { new PostParameter("country", country) }).asJSONArray();
	}

	public JSONArray provinceList(String country, String language) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_province.json",
				new PostParameter[] { new PostParameter("country", country), new PostParameter("language", language) })
				.asJSONArray();
	}

	public JSONArray provinceList(String country, String capital, String language) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "common/get_province.json",
				new PostParameter[] { new PostParameter("country", country), new PostParameter("capital", capital),
						new PostParameter("language", language) }).asJSONArray();
	}

	public JSONArray provinceListOfCapital(String country, String capital) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "common/get_province.json",
				new PostParameter[] { new PostParameter("country", country), new PostParameter("capital", capital) })
				.asJSONArray();
	}

}

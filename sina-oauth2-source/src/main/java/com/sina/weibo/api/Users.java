package com.sina.weibo.api;

import com.sina.weibo.json.JSONArray;
import com.sina.weibo.model.PostParameter;
import com.sina.weibo.model.User;
import com.sina.weibo.model.WeiboException;
import com.sina.weibo.util.WeiboConfig;

public class Users extends Weibo {

	private static final long serialVersionUID = 4742830953302255953L;

	/**
	 * 批量获取用户的粉丝数、关注数、微博数
	 *
	 * @param uids
	 *            需要获取数据的用户UID，多个之间用逗号分隔，最多不超过100个
	 * @return jsonobject
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/users/domain_show">users/domain_show</a>
	 * @since JDK 1.5
	 */
	public JSONArray getUserCount(String uids, String accessToken) throws WeiboException {
		return client.get(WeiboConfig.getValue("baseURL") + "users/counts.json",
						new PostParameter[] { new PostParameter("access_token", accessToken),
								new PostParameter("uids", uids) }, false).asJSONArray();
	}

	/**
	 * 通过个性化域名获取用户资料以及用户最新的一条微博
	 *
	 * @param domain
	 *            需要查询的个性化域名。
	 * @return User
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a
	 *      href="http://open.weibo.com/wiki/2/users/domain_show">users/domain_show</a>
	 * @since JDK 1.5
	 */
	public User showUserByDomain(String domain, String accessToken) throws WeiboException {
		return new User(client.get(WeiboConfig.getValue("baseURL") + "users/domain_show.json",
				new PostParameter[] { new PostParameter("access_token", accessToken),
						new PostParameter("domain", domain) }, false).asJSONObject());
	}

	/*----------------------------用户接口----------------------------------------*/
	/**
	 * 根据用户ID获取用户信息
	 *
	 * @param uid
	 *            需要查询的用户ID
	 * @return User
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/users/show">users/show</a>
	 * @since JDK 1.5
	 */
	public User showUserById(String uid, String accessToken) throws WeiboException {
		return new User(client.get(WeiboConfig.getValue("baseURL") + "users/show.json",
				new PostParameter[] { new PostParameter("access_token", accessToken), new PostParameter("uid", uid) },
				false).asJSONObject());
	}

	/**
	 * 根据用户ID获取用户信息
	 *
	 * @param screen_name
	 *            用户昵称
	 * @return User
	 * @throws WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see <a href="http://open.weibo.com/wiki/2/users/show">users/show</a>
	 * @since JDK 1.5
	 */
	public User showUserByScreenName(String screen_name, String accessToken) throws WeiboException {
		return new User(client.get(WeiboConfig.getValue("baseURL") + "users/show.json",
				new PostParameter[] { new PostParameter("access_token", accessToken),
						new PostParameter("screen_name", screen_name) }, false).asJSONObject());
	}
}

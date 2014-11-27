package com.sina.weibo.examples.comment;

import com.sina.weibo.api.Comments;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Comment;
import com.sina.weibo.model.WeiboException;


public class DestroyComment {

	public static void main(String[] args) {
		String access_token = args[0];
		String cid = args[1];
		Comments cm = new Comments();
		cm.client.setToken(access_token);
		try {
			Comment com = cm.destroyComment(cid);
			Log.logInfo(com.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

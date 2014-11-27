package com.sina.weibo.examples.comment;

import com.sina.weibo.api.Comments;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Comment;
import com.sina.weibo.model.WeiboException;


public class ReplyComment {

	public static void main(String[] args) {
		String access_token = args[0];
		String comments =args[1];
		String id = args[2];
		String cid =args[3];
		Comments cm = new Comments();
		cm.client.setToken(access_token);
		try {
			Comment com = cm.replyComment(cid, id, comments);
			Log.logInfo(com.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

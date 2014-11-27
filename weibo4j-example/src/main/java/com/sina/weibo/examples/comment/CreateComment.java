package com.sina.weibo.examples.comment;

import com.sina.weibo.api.Comments;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Comment;
import com.sina.weibo.model.WeiboException;

public class CreateComment {

	public static void main(String[] args) {
		String id = args[1];
		Comments cm = new Comments();
		//		cm.setToken(access_token);
		try {
			String comments = "[哈哈]";
			Comment comment = cm.createComment(comments, id, "");
			Log.logInfo(comment.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

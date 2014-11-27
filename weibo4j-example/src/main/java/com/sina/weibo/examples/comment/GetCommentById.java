package com.sina.weibo.examples.comment;

import com.sina.weibo.api.Comments;
import com.sina.weibo.examples.oauth2.Log;
import com.sina.weibo.model.Comment;
import com.sina.weibo.model.CommentWapper;
import com.sina.weibo.model.WeiboException;


public class GetCommentById {

	public static void main(String[] args) {
		String access_token = "2.00RQs9XC0gdCQY15dd6eda18QiojdE";
		String id = args[1];
		Comments cm =new Comments();
		cm.client.setToken(access_token);
		try {
			CommentWapper comment = cm.getCommentById(id);
			for(Comment c : comment.getComments()){
				Log.logInfo(c.toString());
			}
			System.out.println(comment.getTotalNumber());
			System.out.println(comment.getNextCursor());
			System.out.println(comment.getNextCursor());
			System.out.println(comment.getHasvisible());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}

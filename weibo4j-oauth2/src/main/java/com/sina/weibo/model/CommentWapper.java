package com.sina.weibo.model;

import java.util.List;

public class CommentWapper {
	private List<Comment> comments;

	private long previousCursor;

	private long nextCursor;

	private long totalNumber;

	private String hasvisible;

	public CommentWapper(List<Comment> comments, long previousCursor, long nextCursor, long totalNumber,
			String hasvisible) {
		this.comments = comments;
		this.previousCursor = previousCursor;
		this.nextCursor = nextCursor;
		this.totalNumber = totalNumber;
		this.hasvisible = hasvisible;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public String getHasvisible() {
		return hasvisible;
	}

	public long getNextCursor() {
		return nextCursor;
	}

	public long getPreviousCursor() {
		return previousCursor;
	}

	public long getTotalNumber() {
		return totalNumber;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setHasvisible(String hasvisible) {
		this.hasvisible = hasvisible;
	}

	public void setNextCursor(long nextCursor) {
		this.nextCursor = nextCursor;
	}

	public void setPreviousCursor(long previousCursor) {
		this.previousCursor = previousCursor;
	}

	public void setTotalNumber(long totalNumber) {
		this.totalNumber = totalNumber;
	}

}

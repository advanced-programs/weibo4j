package com.sina.weibo.model;

import java.util.List;

public class StatusWapper {

	private List<Status> statuses;

	private long previousCursor;

	private long nextCursor;

	private long totalNumber;

	private String hasvisible;

	public StatusWapper(List<Status> statuses, long previousCursor, long nextCursor, long totalNumber, String hasvisible) {
		this.statuses = statuses;
		this.previousCursor = previousCursor;
		this.nextCursor = nextCursor;
		this.totalNumber = totalNumber;
		this.hasvisible = hasvisible;
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

	public List<Status> getStatuses() {
		return statuses;
	}

	public long getTotalNumber() {
		return totalNumber;
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

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public void setTotalNumber(long totalNumber) {
		this.totalNumber = totalNumber;
	}

}

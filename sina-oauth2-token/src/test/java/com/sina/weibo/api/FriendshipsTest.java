package com.sina.weibo.api;

import static org.junit.Assert.assertTrue;

import com.sina.weibo.model.WeiboException;

public class FriendshipsTest {

	private final Friendships fm = new Friendships();

	public void testGetFollowersIdsByIdStringIntegerIntegerString() throws WeiboException {
		String[] followersIds = fm.getFollowersIdsById("1761179351", 5000, 0, "2.00SlDQsDdcZIJC94e5308f67sRL13D");
		assertTrue(followersIds.length > 4000);
	}

	public void testGetFriendsIdsByUidStringIntegerIntegerString() throws WeiboException {
		String[] friendsIds = fm.getFriendsIdsByUid("1761179351", 5000, 0, "2.00SlDQsDdcZIJC94e5308f67sRL13D");
		assertTrue(friendsIds.length > 50);
	}

}

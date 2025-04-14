package com.example.TwitterSpringBoot.Util;

import com.example.TwitterSpringBoot.Model.User;

public class UserUtil {

	public static final boolean isReqUser(User reqUser, User user) {
		return reqUser.getId().equals(user.getId());
	}
	
	public static final boolean isFollowedByReqUser(User reqUser, User user) {
		return reqUser.getFollowings().contains(user);
	}
}

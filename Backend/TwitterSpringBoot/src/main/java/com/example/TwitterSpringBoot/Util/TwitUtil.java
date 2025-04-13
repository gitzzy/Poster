package com.example.TwitterSpringBoot.Util;

import com.example.TwitterSpringBoot.Model.Like;
import com.example.TwitterSpringBoot.Model.Twit;
import com.example.TwitterSpringBoot.Model.User;

public class TwitUtil {

	public final static boolean isLikedByReqUser(User reqUser, Twit twit) {
	  for(Like like : twit.getLikes()) {
		  if (like.getUser().getId().equals(reqUser.getId())) {
			return true;
		}
	  }
	  return false;
	}
	
	public final static boolean isRetwitedByReqUser(User reqUser, Twit twit) {
		for(User user : twit.getRetwitUser()) {
			if (user.getId().equals(reqUser.getId())) {
				return true;
			}
		}
		 return false;
	}
}

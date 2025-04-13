package com.example.TwitterSpringBoot.Service;

import java.util.List;

import com.example.TwitterSpringBoot.Exception.TwitException;
import com.example.TwitterSpringBoot.Exception.UserException;
import com.example.TwitterSpringBoot.Model.Like;
import com.example.TwitterSpringBoot.Model.User;

public interface LikeService {
	
 public Like likeTwit(Long twitId, User user) throws TwitException, UserException;
 
 public List<Like> getAllLikes(Long twitId)throws TwitException;
 
 
}

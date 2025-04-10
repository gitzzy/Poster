package com.example.TwitterSpringBoot.Service;

import java.util.List;

import com.example.TwitterSpringBoot.Exception.TwitException;
import com.example.TwitterSpringBoot.Exception.UserException;
import com.example.TwitterSpringBoot.Model.Twit;
import com.example.TwitterSpringBoot.Model.User;
import com.example.TwitterSpringBoot.Request.TwitReplyRequest;

public interface TwitService {

	public Twit createTwit(Twit req, User user)throws Exception;
	
	public List<Twit> findAllTwit();
	
	public Twit retwit(Long twitId, User user)throws UserException, TwitException;
	
	public Twit findById(Long twitId)throws TwitException;
	
	public void deleteTwitById(Long twitId, Long userId)throws TwitException, UserException;
	
	public Twit removeFromRetwit(Long twitId, User user)throws TwitException, UserException;
	
	public Twit createReply(TwitReplyRequest req, User user)throws TwitException;
	
	public List<Twit> getUserTwit(User user);
	
	public List<Twit> findByLikesCotainsUser(User user);
	
}

package com.example.TwitterSpringBoot.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TwitterSpringBoot.Exception.TwitException;
import com.example.TwitterSpringBoot.Exception.UserException;
import com.example.TwitterSpringBoot.Model.Twit;
import com.example.TwitterSpringBoot.Model.User;
import com.example.TwitterSpringBoot.Repository.TwitRepository;
import com.example.TwitterSpringBoot.Request.TwitReplyRequest;

@Service
public class TwitServiceImplementation implements TwitService{

	@Autowired
	private TwitRepository twitRepository;

	@Override
	public Twit createTwit(Twit req, User user) throws TwitException {
		
		Twit replyFor  = findById(req.getId());
		
		Twit twit = new Twit();
		twit.setContent(req.getContent());
		twit.setCreatedAt(LocalDateTime.now());
		twit.setImage(req.getImage());
		twit.setUser(user);
		twit.setReply(true);
		twit.setTwit(false);
		
		twit.setReplyFor(replyFor);
		
		Twit savedReply = twitRepository.save(twit);
		
		twit.getReplyTwits().add(savedReply);
		twitRepository.save(replyFor);
		
		return replyFor;
		
		
	}

	@Override
	public List<Twit> findAllTwit() {
	    return twitRepository.findAllByIsTwitTrueOrderByCreatedAtDesc();
	}

	@Override
	public Twit retwit(Long twitId, User user) throws UserException, TwitException {
	    Twit twit = findById(twitId);
	    if(twit.getRetwitUser().contains(user)) {
	    	twit.getRetwitUser().remove(user);
	    }else {
	    	twit.getRetwitUser().add(user);
	    }
	    return twitRepository.save(twit);
	}

	@Override
	public Twit findById(Long twitId) throws TwitException {
		Twit twit = twitRepository.findById(twitId)
				.orElseThrow(() -> new TwitException("Twit Not find by Id" +twitId));
	        return twit;
	}

	@Override
	public void deleteTwitById(Long twitId, Long userId) throws TwitException, UserException {
		Twit twit = findById(twitId);
		
		if (userId.equals(twit.getUser().getId())) {
			throw new UserException("You can't delete another user's twit");
		}
		twitRepository.deleteById(twit.getId());
		
	}

	@Override
	public Twit removeFromRetwit(Long twitId, User user) throws TwitException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Twit createReply(TwitReplyRequest req, User user) throws TwitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Twit> getUserTwit(User user) {
		return twitRepository.findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(user, user.getId());
	}

	@Override
	public List<Twit> findByLikesCotainsUser(User user) {
		return twitRepository.findByLikesUser_id(user.getId());
	}

	
	
}

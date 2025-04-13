package com.example.TwitterSpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TwitterSpringBoot.Dto.TwitDto;
import com.example.TwitterSpringBoot.Exception.TwitException;
import com.example.TwitterSpringBoot.Exception.UserException;
import com.example.TwitterSpringBoot.Mapper.TwitDtoMapper;
import com.example.TwitterSpringBoot.Model.Twit;
import com.example.TwitterSpringBoot.Model.User;
import com.example.TwitterSpringBoot.Request.TwitReplyRequest;
import com.example.TwitterSpringBoot.Service.TwitService;
import com.example.TwitterSpringBoot.Service.UserService;

@RestController
@RequestMapping("/api/twits")
public class TwitController {

	@Autowired
	private TwitService twitService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<TwitDto> createTwit(@RequestBody Twit req,
			@RequestHeader("Authorization") String jwt)throws UserException, TwitException{
		
		User user = userService.findUserProfileByJwt(jwt);
		
		Twit twit = twitService.createTwit(req, user);
		
		TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);
		
		return new ResponseEntity<>(twitDto, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/reply")
	public ResponseEntity<TwitDto> replyTwit(@RequestBody TwitReplyRequest req,
			@RequestHeader("Authorization") String jwt)throws UserException, TwitException{
		
		User user = userService.findUserProfileByJwt(jwt);
		
		Twit twit = twitService.createReply(req, user);
		
		TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);
		
		return new ResponseEntity<>(twitDto, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{twitId}/retwit")
	public ResponseEntity<TwitDto> retwit(@PathVariable Long twitId,
			@RequestHeader("Authorization") String jwt)throws UserException, TwitException{
		
		User user = userService.findUserProfileByJwt(jwt);
		
		Twit twit = twitService.retwit(twitId, user);
		
		TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);
		
		return new ResponseEntity<>(twitDto, HttpStatus.OK);
		
	}
	
	@GetMapping("/{twitId}")
	public ResponseEntity<TwitDto> findTwitById(@PathVariable Long twitId,
			@RequestHeader("Authorization") String jwt)throws UserException, TwitException{
		
		User user = userService.findUserProfileByJwt(jwt);
		
		Twit twit = twitService.findById(twitId);
		
		TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);
		
		return new ResponseEntity<>(twitDto, HttpStatus.OK);
		
	}
}

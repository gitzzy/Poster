package com.example.TwitterSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TwitterSpringBoot.Dto.LikeDto;
import com.example.TwitterSpringBoot.Exception.TwitException;
import com.example.TwitterSpringBoot.Exception.UserException;
import com.example.TwitterSpringBoot.Mapper.LikeDtoMapper;
import com.example.TwitterSpringBoot.Model.Like;
import com.example.TwitterSpringBoot.Model.User;
import com.example.TwitterSpringBoot.Service.LikeService;
import com.example.TwitterSpringBoot.Service.UserService;

@RestController
@RequestMapping("/api")
public class LikeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/{twitId}/likes")
	public ResponseEntity<LikeDto> likeTwit(@PathVariable long twitId,
		@RequestHeader("Authorization")String jwt)throws UserException, TwitException{
			User user = userService.findUserProfileByJwt(jwt);
			Like like = likeService.likeTwit(twitId, user);
			
			LikeDto likeDto = LikeDtoMapper.toLikeDto(like, user);
			
			return new ResponseEntity<LikeDto>(likeDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/twit/{twitId}")
	public ResponseEntity<List<LikeDto>> getAllLikes(@PathVariable long twitId,
		@RequestHeader("Authorization")String jwt)throws UserException, TwitException{
			User user = userService.findUserProfileByJwt(jwt);
			List<Like> likes = likeService.getAllLikes(twitId);
			
			List<LikeDto> likeDtos = LikeDtoMapper.toLikeDtos(likes, user);
			
			return new ResponseEntity<>(likeDtos, HttpStatus.OK);
	}
	
}

package com.example.TwitterSpringBoot.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.TwitterSpringBoot.Dto.LikeDto;
import com.example.TwitterSpringBoot.Dto.TwitDto;
import com.example.TwitterSpringBoot.Dto.UserDto;
import com.example.TwitterSpringBoot.Model.Like;
import com.example.TwitterSpringBoot.Model.User;

public class LikeDtoMapper {
 public static LikeDto toLikeDto(Like like, User reqUser) {
	 UserDto user = UserDtoMapper.toUserDto(like.getUser());
	 UserDto req = UserDtoMapper.toUserDto(reqUser);
	 TwitDto twit = TwitDtoMapper.toTwitDto(like.getTwit(), reqUser);
	 
	 LikeDto likeDto = new LikeDto();
	 
	 likeDto.setId(like.getId());
	 likeDto.setTwitDto(twit);
	 likeDto.setUserDto(user);
	 
	 return likeDto;
	 
 } 
 
 public static List<LikeDto> toLikeDtos(List<Like> likes, User reqUser){
	 List<LikeDto> likeDtos = new ArrayList<LikeDto>();
	 
	 for(Like like:likes) {
		 UserDto user = UserDtoMapper.toUserDto(like.getUser());
		 TwitDto twit = TwitDtoMapper.toTwitDto(like.getTwit(), reqUser);
		 
		 LikeDto likeDto = new LikeDto();
		 
		 likeDto.setId(like.getId());
		 likeDto.setTwitDto(twit);
		 likeDto.setUserDto(user);
		 
		 likeDtos.add(likeDto);
	 }
	   return likeDtos;
  }
}

package com.example.TwitterSpringBoot.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.TwitterSpringBoot.Dto.TwitDto;
import com.example.TwitterSpringBoot.Dto.UserDto;
import com.example.TwitterSpringBoot.Model.Twit;
import com.example.TwitterSpringBoot.Model.User;
import com.example.TwitterSpringBoot.Util.TwitUtil;

public class TwitDtoMapper {
	
public static TwitDto toTwitDto(Twit twit, User reqUser) {
	UserDto user = UserDtoMapper.toUserDto(twit.getUser());
	
	boolean isLiked = TwitUtil.isLikedByReqUser(reqUser,twit);
	boolean isRetwited = TwitUtil.isRetwitedByReqUser(reqUser, twit);
	
	List<Long> retwitUserId = new ArrayList<Long>();
	
	for(User user1 : twit.getRetwitUser()) {
		retwitUserId.add(user1.getId());
	}
	TwitDto twitDto = new TwitDto();
	twitDto.setId(twit.getId());
	twitDto.setContent(twit.getContent());
	twitDto.setCreatedAt(twit.getCreatedAt());
	twitDto.setImage(twit.getImage());
	twitDto.setTotalLikes(twit.getLikes().size());
	twitDto.setTotalReplies(twit.getReplyTwits().size());
	twitDto.setTotalRetwits(twit.getRetwitUser().size());
	twitDto.setUser(user);
	twitDto.setLiked(isLiked);
	twitDto.setRetwit(isRetwited);
	twitDto.setRetwitUserId(retwitUserId);
	twitDto.setReplyTwits(toTwitDtos(twit.getReplyTwits(), reqUser));
	twitDto.setVideo(twit.getVideo());
	
	return twitDto;
}

  public static List<TwitDto> toTwitDtos(List<Twit> twits, User reqUser){
	  List<TwitDto> twitDtos = new ArrayList<TwitDto>();
	  
	 for(Twit twit : twits) {
		 TwitDto twitDto = toReplyTwitDto(twit, reqUser);
		 twitDtos.add(twitDto);
	 }
	 return twitDtos;
  }
  
  public static TwitDto toReplyTwitDto(Twit twit, User reqUser) {
		UserDto user = UserDtoMapper.toUserDto(twit.getUser());
		
		boolean isLiked = TwitUtil.isLikedByReqUser(reqUser,twit);
		boolean isRetwited = TwitUtil.isRetwitedByReqUser(reqUser, twit);
		
		List<Long> retwitUserId = new ArrayList<Long>();
		
		for(User user1 : twit.getRetwitUser()) {
			retwitUserId.add(user1.getId());
		}
		TwitDto twitDto = new TwitDto();
		twitDto.setId(twit.getId());
		twitDto.setContent(twit.getContent());
		twitDto.setCreatedAt(twit.getCreatedAt());
		twitDto.setImage(twit.getImage());
		twitDto.setTotalLikes(twit.getLikes().size());
		twitDto.setTotalReplies(twit.getReplyTwits().size());
		twitDto.setTotalRetwits(twit.getRetwitUser().size());
		twitDto.setUser(user);
		twitDto.setLiked(isLiked);
		twitDto.setRetwit(isRetwited);
		twitDto.setRetwitUserId(retwitUserId);
		twitDto.setVideo(twit.getVideo());
		
		return twitDto;
  }
}

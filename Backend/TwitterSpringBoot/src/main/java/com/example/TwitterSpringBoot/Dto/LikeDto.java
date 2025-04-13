package com.example.TwitterSpringBoot.Dto;

import lombok.Data;

@Data
public class LikeDto {

	private long id;
	private UserDto userDto;
	private TwitDto twitDto;
}

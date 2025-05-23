package com.example.TwitterSpringBoot.Request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TwitReplyRequest {

	private String content;
	private Long twitId;
	private LocalDateTime createdAt;
	private String image;
	
}

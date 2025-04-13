package com.example.TwitterSpringBoot.Dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserDto {

	private long id;
	private String fullName;
	private String email;
	private String image;
	private String Location;
	private String website;
	private String birthDate;
	private String mobile;
	private String backgroundImage;
	private String bio;
	private boolean req_user;
	private boolean login_with_google;
	private List<UserDto> followers = new ArrayList<UserDto>();
	private List<UserDto> followings = new ArrayList<UserDto>();
	private boolean followed;
	private boolean isVerified;
	
}

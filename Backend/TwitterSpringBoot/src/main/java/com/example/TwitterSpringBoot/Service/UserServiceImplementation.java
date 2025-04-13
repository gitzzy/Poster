package com.example.TwitterSpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TwitterSpringBoot.Configuration.JwtProvider;
import com.example.TwitterSpringBoot.Exception.UserException;
import com.example.TwitterSpringBoot.Model.User;
import com.example.TwitterSpringBoot.Repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User findUserById(Long userId) throws UserException {
	  User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found with user id" +userId));
	  return user;
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email = jwtProvider.getEmailFromToken(jwt);
		User user = userRepository.findByEmail(email);
		if (user==null) {
			throw new UserException("User Not found with email" +email);
		}
		return user;
	}

	@Override
	public User updateUser(Long userId, User user) throws UserException {
		User req = findUserById(userId);
		
		if (req.getFullName ()!= null) {
			user.setFullName(req.getFullName());
		}
		if (req.getImage()!=null) {
			user.setImage(req.getImage());
		}
		
		if (req.getBackgroundImage()!=null) {
			user.setBackgroundImage(req.getBackgroundImage());
		}
		
		if (req.getBirthDate()!=null) {
			user.setBirthDate(req.getBirthDate());
		}
		
		if (req.getBio()!=null) {
			user.setBio(req.getBio());
		}
		
		if (user.getWebsite()!=null) {
			user.setWebsite(req.getWebsite());
		}
		return userRepository.save(user);
	}

	@Override
	public User followUser(Long userId, User user) throws UserException {
		User followToUser = findUserById(userId);
		
		if (user.getFollowings().contains(followToUser)&&followToUser.getFollowers().contains(user)) {
			user.getFollowings().remove(followToUser);
			followToUser.getFollowers().remove(user);
		}else {
			user.getFollowings().add(followToUser);
			followToUser.getFollowers().add(user);
		}
		userRepository.save(followToUser);
		userRepository.save(user);
		
		return followToUser;
	}

	@Override
	public List<User> searchUser(String query) {
		return userRepository.searchUser(query);
	}

}

package com.example.TwitterSpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TwitterSpringBoot.Configuration.JwtProvider;
import com.example.TwitterSpringBoot.Exception.UserException;
import com.example.TwitterSpringBoot.Model.User;
import com.example.TwitterSpringBoot.Model.Verification;
import com.example.TwitterSpringBoot.Repository.UserRepository;
import com.example.TwitterSpringBoot.Service.CustomeUserDetailsServiceImplementation;

@RestController
@RequestMapping("/auth")
public class AuthController {
   
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private CustomeUserDetailsServiceImplementation customeUserDetails;
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
		
		System.out.println("User" +user);
		
		String name = user.getFullName();
		String birthDate = user.getBirthDate();
		String email = user.getEmail();
		String password = user.getPassword();
		
		User isEmailExist = userRepository.findByEmail(email);
		
		if(isEmailExist != null) {
			throw new UserException("Email already user with another account");
		}
		
		User createdUser = new User();
		createdUser.setFullName(name);
		createdUser.setBirthDate(birthDate);
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setVerification(new Verification());
		
		User savedUser = userRepository.save(createdUser);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtProvider.generateToken(authentication);
		
		AuthResponse res = new  AuthResponse(token, true);
		
		return new ResponseEntity<AuthResponse>(res, HttpStatus.CREATED);
			
	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> signin(@RequestBody User user){
		String username = user.getEmail();
		String password = user.getPassword();
		
		Authentication authentication  = authhenticate(username,password);
		
		String token = jwtProvider.generateToken(authentication);
		
		AuthResponse res = new  AuthResponse(token, true);
		
		return new ResponseEntity<AuthResponse>(res, HttpStatus.OK);
	}
	
	private Authentication authhenticate(String username, String password) {
		UserDetails userDetails =  customeUserDetails.loadUserByUsername(username);
		
		if(userDetails == null) {
			throw new BadCredentialsException("Invalid username...");
		}
		
		if(!passwordEncoder.matches(password,userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid username or password");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
		
	}
}

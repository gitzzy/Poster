package com.example.TwitterSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.TwitterSpringBoot.Model.Twit;
import com.example.TwitterSpringBoot.Model.User;

public interface TwitRepository extends JpaRepository<Twit, Long> {

	
	List<Twit> findAllByIsTwitTrueOrderByCreatedAtDesc();
	
	List<Twit> findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(User user, Long userId);
	
	List<Twit> findByLikesContainingOrderByCreatedAtDesc(User user);
	
	@Query("SELECT t FROM Twit t Join t.likes I where I.userId = :userID")
	List<Twit> findByLikesUser_id(Long UserId);
}

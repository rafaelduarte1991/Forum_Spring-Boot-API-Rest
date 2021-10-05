package com.forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.forum.model.ForumUser;

public interface UserRepository extends JpaRepository<ForumUser, Long>{
	
	Optional<ForumUser> findByEmail(String email);
}

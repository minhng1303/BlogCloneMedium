package com.hanu.mediumclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanu.mediumclone.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
}

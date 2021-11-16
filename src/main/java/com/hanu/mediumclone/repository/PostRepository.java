package com.hanu.mediumclone.repository;

import com.hanu.mediumclone.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

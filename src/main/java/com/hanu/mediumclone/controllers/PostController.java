package com.hanu.mediumclone.controllers;

import java.util.List;

import javax.validation.Valid;

import com.hanu.mediumclone.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanu.mediumclone.models.Post;

@RestController
@RequestMapping(value = "/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Post> findAll() {
		return postService.findAll();
	}
	
	@PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody @Valid Post post) {
		Post createdPost = postService.createPost(post);
		return new ResponseEntity<>(createdPost, HttpStatus.OK);
    }

}

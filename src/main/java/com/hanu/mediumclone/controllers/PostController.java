package com.hanu.mediumclone.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanu.mediumclone.models.Post;
import com.hanu.mediumclone.services.PostService;

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
    public Post createPost(@RequestBody @Valid Post post) {
		return post;
    }

}

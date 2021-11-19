package com.hanu.mediumclone.services;

import com.hanu.mediumclone.models.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post createPost(Post post);
}

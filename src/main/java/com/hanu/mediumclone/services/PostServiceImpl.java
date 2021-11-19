package com.hanu.mediumclone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanu.mediumclone.models.Post;
import com.hanu.mediumclone.repository.PostRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.transaction.Transactional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional
    @Override
    public Post createPost(Post post) {
        Post createdPost = postRepository.save(post);
        return createdPost;
    }
}

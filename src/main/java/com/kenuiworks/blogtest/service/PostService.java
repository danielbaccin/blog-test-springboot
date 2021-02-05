package com.kenuiworks.blogtest.service;

import com.kenuiworks.blogtest.model.Post;

import java.util.List;

/**
 * Created by daniel on 01/02/21.
 */
public interface PostService {

    public List<Post> findAll();
    public Post findById(Long id);
    public Post save(Post post);
}

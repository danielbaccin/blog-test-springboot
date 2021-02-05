package com.kenuiworks.blogtest.service.impl;

import com.kenuiworks.blogtest.model.Post;
import com.kenuiworks.blogtest.repository.PostRepository;
import com.kenuiworks.blogtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by daniel on 01/02/21.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }
}

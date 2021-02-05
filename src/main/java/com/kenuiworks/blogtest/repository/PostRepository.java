package com.kenuiworks.blogtest.repository;

import com.kenuiworks.blogtest.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by daniel on 01/02/21.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}

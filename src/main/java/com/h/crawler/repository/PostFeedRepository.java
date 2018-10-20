package com.h.crawler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.h.crawler.model.Post;

@Repository
public interface PostFeedRepository extends CrudRepository<Post, Long>{
	
}

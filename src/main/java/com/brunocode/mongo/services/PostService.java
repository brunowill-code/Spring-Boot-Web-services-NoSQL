package com.brunocode.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.brunocode.mongo.domain.Post;
import com.brunocode.mongo.repository.PostRepository;
import com.brunocode.mongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
    private MongoTemplate mongoTemplate;

	@Autowired
	private PostRepository postRepository;
	
	
	public Post findById(String id) {
		Optional<Post> Post = postRepository.findById(id);
		return Post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTile(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
}

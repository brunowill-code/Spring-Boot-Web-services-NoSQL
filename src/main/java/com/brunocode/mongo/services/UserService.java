package com.brunocode.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.brunocode.mongo.domain.User;
import com.brunocode.mongo.repository.UserRepository;
import com.brunocode.mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
    private MongoTemplate mongoTemplate;

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}

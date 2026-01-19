package com.brunocode.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.brunocode.mongo.domain.User;
import com.brunocode.mongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private MongoTemplate mongoTemplate;

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		
		System.out.println("========== MONGO CONNECTION ==========");
        System.out.println("Database: " + mongoTemplate.getDb().getName());
        System.out.println("=====================================");
		
		List<User> list = userRepository.findAll();
	    System.out.println(list.size());
		return userRepository.findAll();
	}
	
}

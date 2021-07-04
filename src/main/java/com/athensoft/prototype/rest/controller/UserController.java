package com.athensoft.prototype.rest.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.prototype.rest.entity.User;
import com.athensoft.prototype.rest.dao.UserRepository;
import com.athensoft.prototype.rest.service.UserService;



@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public ResponseEntity<CollectionModel<EntityModel<User>>> getUserListAll() {
		return userService.getUserListAll();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<EntityModel<User>> getUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
		LOGGER.info("create user:" + user);
        return userService.createUser(user);
    }
	
	@PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
		LOGGER.info("update user:" + user);
        return userService.updateUser(user);
    }
	
	@DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable int userId) {
		LOGGER.info("delete user by user id " + userId);
        return userService.deleteUserById(userId);
    }
	
	@DeleteMapping("/users")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
		LOGGER.info("delete user:" + user);
        return userService.deleteUser(user);
    }
	

}

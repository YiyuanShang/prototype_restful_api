package com.athensoft.prototype.rest.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.athensoft.prototype.error.exceptions.UserAlreadyExistsException;
import com.athensoft.prototype.error.exceptions.UserNotFoundException;
import com.athensoft.prototype.rest.entity.User;
import com.athensoft.prototype.rest.controller.UserController;
import com.athensoft.prototype.rest.dao.UserRepository;
import com.athensoft.prototype.rest.utils.UserModelAssembler;

@Service
public class UserService {
	private final UserRepository repo;
	
	private final UserModelAssembler assembler;

	public UserService(UserRepository repo, UserModelAssembler assembler) {
		this.repo = repo;
		this.assembler = assembler;
	}

	public ResponseEntity<CollectionModel<EntityModel<User>>> getUserListAll() {
		List<EntityModel<User>> users = repo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());

		CollectionModel<EntityModel<User>> collectionModel = CollectionModel.of(users, 
				linkTo(methodOn(UserController.class).getUserListAll()).withSelfRel());
		
		return ResponseEntity.ok(collectionModel);
	}

	public ResponseEntity<EntityModel<User>> getUserById(int userId) {
		User user = repo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException());
		
		return ResponseEntity.ok(
				this.assembler.toModel(user));
	}

	public ResponseEntity<User> createUser(User user) {
		if (repo.existsById(user.getUserId())) {
			throw new UserAlreadyExistsException();
		}
		return new ResponseEntity<>(repo.save(user), HttpStatus.CREATED);
	}

	public ResponseEntity<User> saveUser(User user) {
		return ResponseEntity.ok(repo.save(user));
	}

	public ResponseEntity<User> updateUser(User user) {
		if (!repo.existsById(user.getUserId())) {
			throw new UserNotFoundException();
		}
		return ResponseEntity.ok(repo.save(user));
	}

	public ResponseEntity<User> deleteUserById(int userId) {
		if (!repo.existsById(userId)) {
			throw new UserNotFoundException();
		}
		User user = repo.findById(userId).get();
		repo.deleteById(userId);
		return ResponseEntity.ok(user);
	}

	public ResponseEntity<User> deleteUser(User user) {
		if (!repo.existsById(user.getUserId())) {
			throw new UserNotFoundException();
		}
		repo.delete(user);
		return ResponseEntity.ok(user);
	}

}

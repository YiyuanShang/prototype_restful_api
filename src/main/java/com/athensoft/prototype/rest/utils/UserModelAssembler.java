package com.athensoft.prototype.rest.utils;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.athensoft.prototype.rest.entity.User;
import com.athensoft.prototype.rest.controller.UserController;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

	@Override
	public EntityModel<User> toModel(User user) {

		return EntityModel.of(user, 
				linkTo(methodOn(UserController.class).getUserById(user.getUserId())).withSelfRel(),
				linkTo(methodOn(UserController.class).getUserListAll()).withRel("users"));
	}
}


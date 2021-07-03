package com.athensoft.prototype.rest.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athensoft.prototype.rest.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

package com.imarticus.tutorial.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imarticus.tutorial.dtos.User;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
	

	List<User> findAll();
	void deleteById(Long id);
	Optional<User> findById(Long id);
	Optional<User> findByUsername(String email);
	
	
	

}

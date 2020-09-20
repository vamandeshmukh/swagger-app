package com.imarticus.tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarticus.tutorial.dao.UserDao;
import com.imarticus.tutorial.dtos.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;


	public User addUser(User user) {
		return userDao.save(user);
	}
	
	public User findByUserName(String email) {

		Optional<User> user= userDao.findByUsername(email);
		if(user.isPresent())
			return user.get();
		else
			return null;
		
	}
	

	public List<User> getAllusers() {
		return userDao.findAll();
	}

	public User getUserById(Long id) {
		
		return userDao.findById(id).get();
	}
	public User updateUser(Long id, User user) {

		Optional<User> repUser = userDao.findById(id);

		if (repUser.isPresent()) {

			User userToBeUpdated = repUser.get();
			userToBeUpdated.setPassword(user.getPassword());
		

			return userDao.save(userToBeUpdated);

		}

		return null;
	}

	public String removeUser(Long userId) {

		userDao.deleteById(userId);
		return "User deleted Sucessfully";
	}



}

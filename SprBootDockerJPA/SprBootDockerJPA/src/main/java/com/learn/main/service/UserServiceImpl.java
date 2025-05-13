package com.learn.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.main.entity.User;
import com.learn.main.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public boolean saveUser(User user) {
		
		boolean status;
		try {
			userRepo.save(user);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}

	@Override
	public User find(int id) {
		Optional<User> optional = userRepo.findById(id);
		if(!optional.isEmpty()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> user_list = userRepo.findAll();
		return user_list;
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			userRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(int id, String email) {
		User user = find(id);
		if (user != null) {
			user.setEmail(email);
			userRepo.save(user);
			return true;
		}
		return false;
	}
}

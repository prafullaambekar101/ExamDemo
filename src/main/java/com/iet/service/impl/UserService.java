package com.iet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iet.bean.User;
import com.iet.dao.UserDAO;
@Service
public class UserService implements com.iet.service.UserService {
	@Autowired UserDAO userDAO;
	@Override
	public User add(User user) {
		return userDAO.save(user);
	}

}

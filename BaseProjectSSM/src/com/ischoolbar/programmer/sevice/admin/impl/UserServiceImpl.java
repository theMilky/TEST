package com.ischoolbar.programmer.sevice.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.admin.UserDao;
import com.ischoolbar.programmer.entity.admin.User;
import com.ischoolbar.programmer.sevice.admin.UserService;
/**
 * user”√ªßserviceImpl
 * @author Cxs
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao UserDao;
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return UserDao.findByUsername(username);
	}

}

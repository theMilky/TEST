package com.ischoolbar.programmer.sevice.admin;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.admin.User;

/**
 * user”√ªßservice
 * @author Cxs
 *
 */
@Service
public interface UserService {
	public User findByUsername(String username);

}

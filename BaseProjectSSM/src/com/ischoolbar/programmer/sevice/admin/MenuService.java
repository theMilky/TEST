package com.ischoolbar.programmer.sevice.admin;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.admin.Menu;

/**
 * �˵�����service
 * @author Cxs
 *
 */
@Service
public interface MenuService {
	public int add(Menu menu);
}

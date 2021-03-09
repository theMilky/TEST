package com.ischoolbar.programmer.sevice.admin.impl;
/**
 * 菜单管理是实现类
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.admin.MenuDao;
import com.ischoolbar.programmer.entity.admin.Menu;
import com.ischoolbar.programmer.sevice.admin.MenuService;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao MenuDao;
	
	@Override
	public int add(Menu menu) {
		// TODO Auto-generated method stub
		return MenuDao.add(menu);
	}

}

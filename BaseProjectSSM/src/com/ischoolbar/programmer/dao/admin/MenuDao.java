package com.ischoolbar.programmer.dao.admin;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.admin.Menu;

/**
 * �˵�����Dao
 * @author Cxs
 *
 */
@Repository
public interface MenuDao {
	public int add(Menu menu);
}

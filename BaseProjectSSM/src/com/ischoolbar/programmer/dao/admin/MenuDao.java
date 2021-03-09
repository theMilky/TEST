package com.ischoolbar.programmer.dao.admin;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.admin.Menu;

/**
 * ≤Àµ•π‹¿ÌDao
 * @author Cxs
 *
 */
@Repository
public interface MenuDao {
	public int add(Menu menu);
}

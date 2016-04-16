package com.hzih.compare.dao.impl;

import cn.collin.commons.dao.MyDaoSupport;
import com.hzih.compare.dao.PermissionDao;
import com.hzih.compare.domain.Permission;

public class PermissionDaoImpl extends MyDaoSupport implements PermissionDao {

	@Override
	public void setEntityClass() {
		this.entityClass = Permission.class;
	}

}

package com.hzih.compare.dao.impl;

import cn.collin.commons.dao.MyDaoSupport;
import cn.collin.commons.domain.PageResult;
import com.hzih.compare.dao.IdentityQueryLogDao;
import com.hzih.compare.domain.IdentityQueryLog;

import java.util.ArrayList;
import java.util.List;


public class IdentityQueryLogDaoImpl extends MyDaoSupport implements IdentityQueryLogDao {

	@Override
	public void setEntityClass() {
		this.entityClass = IdentityQueryLog.class;
	}


	@Override
	public PageResult listByPage(String idCard, int pageIndex, int limit) {
		StringBuilder sb = new StringBuilder("from IdentityQueryLog where 1=1 ");
		List paramsList = new ArrayList();
		if (idCard != null && idCard.length() > 0) {
			sb.append(" and idCard like ?");
			paramsList.add("%" + idCard + "%");
		}
		sb.append(" order by id desc");
		String countHql = "select count(*) " + sb.toString();

		PageResult ps = this.findByPage(sb.toString(), countHql, paramsList.toArray(),
				pageIndex, limit);
		return ps;
	}

	@Override
	public void save(IdentityQueryLog identityQueryLog) {
		getHibernateTemplate().save(identityQueryLog);
	}
}

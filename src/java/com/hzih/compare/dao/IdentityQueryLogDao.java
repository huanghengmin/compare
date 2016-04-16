package com.hzih.compare.dao;

import cn.collin.commons.dao.BaseDao;
import cn.collin.commons.domain.PageResult;
import com.hzih.compare.domain.IdentityQueryLog;


public interface IdentityQueryLogDao extends BaseDao {

	PageResult listByPage(String idCard, int pageIndex, int limit);

	public void save(IdentityQueryLog identityQueryLog);
}

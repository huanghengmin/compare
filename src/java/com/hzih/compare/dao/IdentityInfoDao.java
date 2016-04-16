package com.hzih.compare.dao;

import cn.collin.commons.dao.BaseDao;
import cn.collin.commons.domain.PageResult;
import com.hzih.compare.domain.IdentityInfo;

import java.util.List;

public interface IdentityInfoDao extends BaseDao {
	PageResult listByPage(String idCard, int pageIndex, int limit);

	public List<IdentityInfo> list(int status) ;

	public IdentityInfo exist(String idCard) ;

	public boolean save(IdentityInfo identityInfo);

	public boolean modifyAll();
}

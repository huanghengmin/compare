package com.hzih.compare.dao;

import cn.collin.commons.dao.BaseDao;
import com.hzih.compare.domain.Role;

public interface RoleDao extends BaseDao {

    public Role findByName(String name) throws Exception;
}

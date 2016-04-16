package com.hzih.compare.dao.impl;

import cn.collin.commons.dao.MyDaoSupport;
import cn.collin.commons.domain.PageResult;
import com.hzih.compare.dao.IdentityInfoDao;
import com.hzih.compare.domain.IdentityInfo;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class IdentityInfoDaoImpl extends MyDaoSupport implements IdentityInfoDao {

	@Override
	public void setEntityClass() {
		this.entityClass = IdentityInfo.class;
	}


	@Override
	public PageResult listByPage(String idCard, int pageIndex, int limit) {
		StringBuilder sb = new StringBuilder("from IdentityInfo where 1=1 ");
		List paramsList = new ArrayList();
		if (idCard != null && idCard.length() > 0) {
			sb.append(" and idCard like ?");
			paramsList.add("%" + idCard + "%");
		}
		sb.append(" order by idCard desc");
		String countHql = "select count(*) " + sb.toString();

		PageResult ps = this.findByPage(sb.toString(), countHql, paramsList.toArray(),
				pageIndex, limit);
		return ps;
	}

	@Override
	public List<IdentityInfo> list(int status) {
		List<IdentityInfo> identityInfos = null;
		String hql = " from IdentityInfo s where s.status="+status;
		Session session = super.getSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		identityInfos = (List<IdentityInfo>) query.list();
		session.getTransaction().commit();
		session.close();
		return identityInfos;
	}

	@Override
	public IdentityInfo exist(String idCard) {
		String hql="from IdentityInfo i where i.idCard ='"+idCard+"'";
		List<IdentityInfo> identityInfos  = super.getHibernateTemplate().find(hql);
		if(identityInfos.size()>0&&identityInfos!=null){
			return identityInfos.get(0);
		}else {
			return null;
		}
	}

	@Override
	public boolean save(IdentityInfo identityInfo) {
		getHibernateTemplate().save(identityInfo);
		return false;
	}

	@Override
	public boolean modifyAll() {
		boolean flag =false;
		String s="update IdentityInfo i set i.status= "+0+" where i.status=1";
		Session session = super.getSession();
		try{
			session.beginTransaction();
			Query query=session.createQuery(s);
			query.executeUpdate();
			session.getTransaction().commit();
			flag=true;
		} catch (Exception e){

		} finally {
			session.close();
		}
		return flag;
	}
}

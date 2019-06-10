package cn.itcast.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IForumDao;
import cn.itcast.oa.domain.Forum;

@Repository
public class ForumDaoImpl  extends BaseDaoImpl<Forum> implements IForumDao{

	/*
	 * 重写这个方法，按照position来排序
	 * @see cn.itcast.oa.base.BaseDaoImpl#findAll()
	 */
	@Override
	public List<Forum> findAll() {
	String hql="FROM Forum f ORDER BY f.position";
	return this.getSession().createQuery(hql).list();
	}
	
	
	}

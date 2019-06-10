package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IForumManageDao;
import cn.itcast.oa.dao.impl.ForumManageDaoImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.IForumManageService;

@Service
@Transactional
public class ForumManageSerivceImpl  implements  IForumManageService{
	
	@Resource
	private IForumManageDao forumManageDao;
	/**
	 * 查询板块列表
	 */
	@Override
	public List<Forum> findAll() {
		// TODO Auto-generated method stub
		return forumManageDao.findAll();
	}

	/**
	 * 根据id删除
	 */
	@Override
	public void delete(Forum model) {
		forumManageDao.delete(model.getId());
		
	}
	/**
	 * 保存的板块
	 */
	@Override
	public void save(Forum model) {
		forumManageDao.save(model);
		
	}
	/**
	 * 根据id查询板块
	 */
	@Override
	public Forum getById(Long id) {
		
		return forumManageDao.getById(id);
	}
	/**
	 * 根据id修改板块信息
	 */
	@Override
	public void update(Forum model) {
		forumManageDao.update(model);
		
	}

	@Override
	public void moveUp(Long id) {
	forumManageDao.moveUp(id);
		
	}

	@Override
	public void moveDown(Long id) {
		forumManageDao.moveDown(id);
		
	}

	}

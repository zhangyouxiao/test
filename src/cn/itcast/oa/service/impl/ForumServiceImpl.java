package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IForumDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.IForumService;
@Service
@Transactional
public class ForumServiceImpl implements IForumService {
	@Resource
	private IForumDao  forumDao;
	@Override
	public List<Forum> findAll() {
		// TODO Auto-generated method stub
		return forumDao.findAll();
	}
	@Override
	public Forum getById(Long id) {
		// TODO Auto-generated method stub
		return forumDao.getById(id);
	}

}

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
	 * ��ѯ����б�
	 */
	@Override
	public List<Forum> findAll() {
		// TODO Auto-generated method stub
		return forumManageDao.findAll();
	}

	/**
	 * ����idɾ��
	 */
	@Override
	public void delete(Forum model) {
		forumManageDao.delete(model.getId());
		
	}
	/**
	 * ����İ��
	 */
	@Override
	public void save(Forum model) {
		forumManageDao.save(model);
		
	}
	/**
	 * ����id��ѯ���
	 */
	@Override
	public Forum getById(Long id) {
		
		return forumManageDao.getById(id);
	}
	/**
	 * ����id�޸İ����Ϣ
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

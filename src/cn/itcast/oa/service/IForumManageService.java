package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Forum;

public interface  IForumManageService  {

	List<Forum> findAll();

	public void delete(Forum model);

	void save(Forum model);

	Forum getById(Long  id);

	void update(Forum model);

	void moveUp(Long id);

	void moveDown(Long id);

	

}

package cn.itcast.oa.dao;

import cn.itcast.oa.base.IBaseDao;
import cn.itcast.oa.domain.Book;
import cn.itcast.oa.domain.Forum;

public interface IForumManageDao extends IBaseDao<Forum>{

	void moveUp(Long id);

	void moveDown(Long id);

}

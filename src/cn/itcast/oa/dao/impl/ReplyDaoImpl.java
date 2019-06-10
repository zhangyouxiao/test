package cn.itcast.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IReplyDao;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
@Repository
public class ReplyDaoImpl  extends BaseDaoImpl<Reply> implements IReplyDao{

	@Override
	public List<Reply> getBytopic(Topic topic) {
		String hql="FROM Reply r WHERE r.topic=? ORDER BY r.postTime";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, topic);
		
		return query.list();
	}

}

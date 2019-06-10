package cn.itcast.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.ITopicDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
@Repository
@SuppressWarnings("unchecked")
public class TopicDaoImpl  extends  BaseDaoImpl<Topic> implements  ITopicDao{
	/**s
	 *ИљОн
	 */
	@Override
	public List<Topic> findTopicByoforum(Forum model) {
		String hql="FROM Topic t WHERE t.forum= ? ";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
				
		return query.list();
	}

}

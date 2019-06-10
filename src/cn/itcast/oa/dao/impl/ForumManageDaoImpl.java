package cn.itcast.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IBookDao;
import cn.itcast.oa.dao.IForumManageDao;
import cn.itcast.oa.domain.Book;
import cn.itcast.oa.domain.Forum;
@Repository
public class ForumManageDaoImpl extends BaseDaoImpl<Forum> implements IForumManageDao {
		
	//需要重写一下父类save()的方法，是position的值等于id的值
	@Override
		public void save(Forum entity) {
			super.save(entity);//执行完这个操作，是临时数据编程持久数据
			entity.setPosition(entity.getId().intValue());//调用该方法可以将long转换成int类型
	
		}
	
	//改造findAll()的方法
	@Override
	public List<Forum> findAll() {
		String hql="from Forum f order by f.position";
		return this.getSession().createQuery(hql).list();
	}

	@Override
	public void moveUp(Long id) {
		Forum forum1 = getById(id);
		int p1 = forum1.getPosition();
		String hql="FROM Forum f WHERE  f.position<? ORDER BY f.position  DESC";
		 Query query = this.getSession().createQuery(hql);
		 query.setParameter(0, p1);
		 query.setFirstResult(0);//表示分页查询
		 query.setMaxResults(1);//查询一个
		 Forum forum2 = (Forum) query.uniqueResult();
		 //让两个的位置互换
		 forum1.setPosition(forum2.getPosition());
		 forum2.setPosition(p1);
		
	}

	@Override
	public void moveDown(Long id) {
		Forum forum1 = getById(id);
		int p1 = forum1.getPosition();
		String hql="FROM Forum f WHERE f.position > ? ORDER BY f.position";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, p1);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Forum forum2 = (Forum) query.uniqueResult();
		forum1.setPosition(forum2.getPosition());
		forum2.setPosition(p1);
		
		
		
	}

}

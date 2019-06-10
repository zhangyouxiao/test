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
		
	//��Ҫ��дһ�¸���save()�ķ�������position��ֵ����id��ֵ
	@Override
		public void save(Forum entity) {
			super.save(entity);//ִ�����������������ʱ���ݱ�̳־�����
			entity.setPosition(entity.getId().intValue());//���ø÷������Խ�longת����int����
	
		}
	
	//����findAll()�ķ���
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
		 query.setFirstResult(0);//��ʾ��ҳ��ѯ
		 query.setMaxResults(1);//��ѯһ��
		 Forum forum2 = (Forum) query.uniqueResult();
		 //��������λ�û���
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

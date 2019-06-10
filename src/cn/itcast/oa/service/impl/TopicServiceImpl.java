package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.ITopicDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.ITopicService;
@Service
@Transactional
public class TopicServiceImpl   implements ITopicService  {
	@Resource
	private ITopicDao  topicDao;

	@Override
	public List<Topic> findTopicByoforum(Forum model) {
		
		return topicDao.findTopicByoforum(model);
	}

	@Override
	public void save(Topic model) {
		topicDao.save(model);//�����Ѿ�����Ϊ�־ö���
		Forum forum = model.getForum();  //�õ��˰��Ķ���
		//ͨ�����Ķ���û���һ�����⣬������������������1��������ʵ���˰���е�����Ķ�̬����
		forum.setTopicCount(forum.getTopicCount()+1);
		//���µ�����ҲҲҪ��1��
		forum.setActicleCount(forum.getActicleCount()+1);
		//���ð�����һ������,ÿһ��model�������һ�����⣬ÿ���һ�����⣬�͸������һ������
		forum.setLastTopic(model);
		
	}

	@Override
	public Topic getById(Long id) {
	return	topicDao.getById(id);
		
	}

}

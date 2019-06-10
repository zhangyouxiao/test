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
		topicDao.save(model);//数据已经保存为持久对象
		Forum forum = model.getForum();  //得到了板块的对象
		//通过板块的对象，没添加一个主题，板块的主题的数量都会加1；这样就实现了板块中的主题的动态跟新
		forum.setTopicCount(forum.getTopicCount()+1);
		//文章的数量也也要加1；
		forum.setActicleCount(forum.getActicleCount()+1);
		//设置板块最后一个主题,每一个model都是最后一个主题，每添加一个主题，就跟新最后一个主题
		forum.setLastTopic(model);
		
	}

	@Override
	public Topic getById(Long id) {
	return	topicDao.getById(id);
		
	}

}

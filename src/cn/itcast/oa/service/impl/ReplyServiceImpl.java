package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IReplyDao;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.IReplyService;

@Service
@Transactional
public class ReplyServiceImpl  implements IReplyService{
	@Resource
	private IReplyDao replyDao;
	
	@Override
	public void save(Reply model) {
		replyDao.save(model);
		Forum forum = model.getTopic().getForum();
		forum.setActicleCount(forum.getActicleCount()+1);//板块的文章的数量，包括主题个回复的数量
		Topic topic=model.getTopic();
		topic.setReplyCount(topic.getReplyCount()+1);//设置主题的的回复数量
		topic.setLastUpdateTime(topic.getPostTime());//设置主题最后的更新时间
		topic.setLastReply(model);//设置主题的最后回复
	}

	@Override
	public List<Reply> getBytopic(Topic topic) {
		
		return replyDao.getBytopic(topic);
	}

}

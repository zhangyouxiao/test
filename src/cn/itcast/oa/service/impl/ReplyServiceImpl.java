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
		forum.setActicleCount(forum.getActicleCount()+1);//�������µ�����������������ظ�������
		Topic topic=model.getTopic();
		topic.setReplyCount(topic.getReplyCount()+1);//��������ĵĻظ�����
		topic.setLastUpdateTime(topic.getPostTime());//�����������ĸ���ʱ��
		topic.setLastReply(model);//������������ظ�
	}

	@Override
	public List<Reply> getBytopic(Topic topic) {
		
		return replyDao.getBytopic(topic);
	}

}

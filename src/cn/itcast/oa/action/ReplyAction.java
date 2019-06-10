package cn.itcast.oa.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {
	private  Long topicId;
	/**
	 * ��ת���ظ�ҳ��
	 */
	public String addUI() {
		Topic topic = topicService.getById(topicId);
		getValueStack().push(topic);
		return "addUI";
	}
	
	public String add() {
		//����ID������
		Topic topic = topicService.getById(topicId);
		//��������
		model.setTopic(topic);
		//Ĭ�ϵ�
		model.setDeleted(0);
		//���ûظ���Ϊ����ǰ���û�
		model.setAuthor(getUser());
		model.setPostTime(new Date());
		model.setIpAddress(getIpddress());
		replyService.save(model);
		return "toreplylist";
	}

	//����������get ��set�ĵķ���
	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
	
	

}

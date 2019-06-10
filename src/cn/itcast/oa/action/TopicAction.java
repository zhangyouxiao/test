package cn.itcast.oa.action;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

/**
 * �������
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class TopicAction  extends BaseAction<Topic>{
	private Long forumId;//���ǰ��id
	/**
	 * ��תҳ��
	 */
	public String addUI() {
		//����id��ѯ���
		Forum forum = forumService.getById(forumId);
		getValueStack().push(forum);
		return "addUI";
	}
	/*
	 * ������ȥ���һ������Ĳ���
	 */
	public String add() {
		Forum forum = forumService.getById(forumId);
		model.setForum(forum);
		model.setPostTime(new Date());
		model.setLastUpdateTime(model.getPostTime());
		//��ȡ��¼���û�
		model.setAuthor(getUser());
		//��ȡ�ͻ��˵�IP��ַ
		model.setIpAddress(getIpddress());//ip��ַ������baseAction��
		model.setReplyCount(0);//��ʼ��������û�лظ���
		model.setType(0);//��ʼ������������ͨ������
		model.setLastReply(null); //Ĭ����û�лظ���
		topicService.save(model);
		
		//��ת���������
		return "toTopicList";
	}
	
	/**
	 * ��ʾ�������⣬Ҳ���ǻظ��б�
	 * @return
	 */
	public String show() {
		//����id��ѯ���������Ϣ
		Topic topic=topicService.getById(model.getId());
		getValueStack().push(topic);
		//���������ѯ��Ӧ��reply
		List<Reply>replylist=replyService.getBytopic(model);
		getValueStack().set("relpylist", replylist);
		
		return "show";
	}
	//��������
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
	
}

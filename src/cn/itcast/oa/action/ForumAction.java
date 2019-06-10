package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

/**
 * ���������
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class ForumAction  extends  BaseAction<Forum>{
/**
 * ��ѯ����б�
 */
	public String list() {
		List<Forum>list=forumService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	/*
	 * ��ѯ�����б�(�������)
	 */
	public String  show() {
		//����idֵ��ѯ������
		Forum forum=forumService.getById(model.getId());
		getValueStack().push(forum);
		List<Topic>topicList=topicService.findTopicByoforum(model);
		getValueStack().set("topicList", topicList);
		return "forumshow";
	}
	
	
}

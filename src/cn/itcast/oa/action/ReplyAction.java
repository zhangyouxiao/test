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
	 * 跳转到回复页面
	 */
	public String addUI() {
		Topic topic = topicService.getById(topicId);
		getValueStack().push(topic);
		return "addUI";
	}
	
	public String add() {
		//根据ID查出相关
		Topic topic = topicService.getById(topicId);
		//关联主题
		model.setTopic(topic);
		//默认的
		model.setDeleted(0);
		//设置回复人为当当前的用户
		model.setAuthor(getUser());
		model.setPostTime(new Date());
		model.setIpAddress(getIpddress());
		replyService.save(model);
		return "toreplylist";
	}

	//属性驱动的get 和set的的方法
	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
	
	

}

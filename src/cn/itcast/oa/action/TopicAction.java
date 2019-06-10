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
 * 主题操作
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class TopicAction  extends BaseAction<Topic>{
	private Long forumId;//这是板块id
	/**
	 * 跳转页面
	 */
	public String addUI() {
		//根据id查询板块
		Forum forum = forumService.getById(forumId);
		getValueStack().push(forum);
		return "addUI";
	}
	/*
	 * 真正的去添加一个主题的操作
	 */
	public String add() {
		Forum forum = forumService.getById(forumId);
		model.setForum(forum);
		model.setPostTime(new Date());
		model.setLastUpdateTime(model.getPostTime());
		//获取登录的用户
		model.setAuthor(getUser());
		//获取客户端的IP地址
		model.setIpAddress(getIpddress());//ip地址定义在baseAction中
		model.setReplyCount(0);//开始的新帖是没有回复的
		model.setType(0);//开始发的帖都是普通的帖子
		model.setLastReply(null); //默认是没有回复的
		topicService.save(model);
		
		//跳转到主题表上
		return "toTopicList";
	}
	
	/**
	 * 显示单个主题，也就是回复列表
	 * @return
	 */
	public String show() {
		//根据id查询主题相关信息
		Topic topic=topicService.getById(model.getId());
		getValueStack().push(topic);
		//根据主题查询对应的reply
		List<Reply>replylist=replyService.getBytopic(model);
		getValueStack().set("relpylist", replylist);
		
		return "show";
	}
	//属性驱动
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
	
}

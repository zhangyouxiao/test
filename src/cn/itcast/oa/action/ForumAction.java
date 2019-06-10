package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

/**
 * 参与板块操作
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class ForumAction  extends  BaseAction<Forum>{
/**
 * 查询板块列表
 */
	public String list() {
		List<Forum>list=forumService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	/*
	 * 查询主题列表(单个板块)
	 */
	public String  show() {
		//根据id值查询板块对象
		Forum forum=forumService.getById(model.getId());
		getValueStack().push(forum);
		List<Topic>topicList=topicService.findTopicByoforum(model);
		getValueStack().set("topicList", topicList);
		return "forumshow";
	}
	
	
}

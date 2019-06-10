package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
/**
 * 板块管理action
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class ForumManageAction extends  BaseAction<Forum> {
	/**
	 * 查询板块列表
	 */
	public String list() {
		List<Forum>list=forumManageService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	/**
	 * 根据id来删除板块
	 * 
	 */
	public String delete() {
		forumManageService.delete(model);
		return "toList";
	}
	/**
	 * 跳转到添加板块的页面
	 * 这个直接跳转就可以了
	 * 
	 */
	public String addUI() {
		return  "addUI";
	}
	/*
	 * 添加板块
	 */
	public String add() {
		forumManageService.save(model);
		return "toList";
		
	}
	/**
	 * 跳转到修改的页面
	 */
	public String editUI() {
		Forum  forum= forumManageService.getById(model.getId());
		//保存数据用于回显
		getValueStack().push(forum);
		return "editUI";
	}
	/**
	 * 实现修改
	 */
	public String edit() {
		//先查询，在修改
		Forum forum=forumManageService.getById(model.getId());
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		
		//根据idlai修改板快的信息
		forumManageService.update(forum);
		return "toList";
	}
	
	
	/**
	 * 实现板块上移
	 */
	public String moveUp() {
		forumManageService.moveUp(model.getId());
		return "toList";
	}
	/**
	 * 实现板块下移
	 */
	public String moveDown() {
		forumManageService.moveDown(model.getId());
	return "toList";
	}
	
	
	}

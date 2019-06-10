package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
/**
 * ������action
 * @author Lenovo
 *
 */
@Controller
@Scope("prototype")
public class ForumManageAction extends  BaseAction<Forum> {
	/**
	 * ��ѯ����б�
	 */
	public String list() {
		List<Forum>list=forumManageService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	/**
	 * ����id��ɾ�����
	 * 
	 */
	public String delete() {
		forumManageService.delete(model);
		return "toList";
	}
	/**
	 * ��ת����Ӱ���ҳ��
	 * ���ֱ����ת�Ϳ�����
	 * 
	 */
	public String addUI() {
		return  "addUI";
	}
	/*
	 * ��Ӱ��
	 */
	public String add() {
		forumManageService.save(model);
		return "toList";
		
	}
	/**
	 * ��ת���޸ĵ�ҳ��
	 */
	public String editUI() {
		Forum  forum= forumManageService.getById(model.getId());
		//�����������ڻ���
		getValueStack().push(forum);
		return "editUI";
	}
	/**
	 * ʵ���޸�
	 */
	public String edit() {
		//�Ȳ�ѯ�����޸�
		Forum forum=forumManageService.getById(model.getId());
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		
		//����idlai�޸İ�����Ϣ
		forumManageService.update(forum);
		return "toList";
	}
	
	
	/**
	 * ʵ�ְ������
	 */
	public String moveUp() {
		forumManageService.moveUp(model.getId());
		return "toList";
	}
	/**
	 * ʵ�ְ������
	 */
	public String moveDown() {
		forumManageService.moveDown(model.getId());
	return "toList";
	}
	
	
	}

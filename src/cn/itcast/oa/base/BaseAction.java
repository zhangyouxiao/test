package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.IBookService;
import cn.itcast.oa.service.IDepartmentService;
import cn.itcast.oa.service.IForumManageService;
import cn.itcast.oa.service.IForumService;
import cn.itcast.oa.service.IPrivilegeService;
import cn.itcast.oa.service.IReplyService;
import cn.itcast.oa.service.IRoleService;
import cn.itcast.oa.service.ITopicService;
import cn.itcast.oa.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 通用父类Action
 * @author zhaoqx
 *
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	@Resource
	protected IBookService bookService;
	@Resource
	protected IRoleService roleService;
	@Resource
	protected IDepartmentService departmentService;
	@Resource
	protected IUserService userService;
	@Resource
	protected IPrivilegeService privilegeService;
	@Resource
	protected IForumManageService  forumManageService;
	@Resource
	protected  IForumService  forumService;
	@Resource 
	protected ITopicService  topicService;
	@Resource 
	protected IReplyService  replyService;
	
	//在构造方法中获得model类型
	public BaseAction(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();//父类Action类型
		Type[] types = type.getActualTypeArguments();
		Class<T> clazz = (Class<T>) types[0];
		try {
			model = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	protected T model;

	public T getModel() {
		return model;
	}
	
	/**
	 * 获得值栈
	 * @return
	 */
	protected ValueStack getValueStack(){
		return ActionContext.getContext().getValueStack();
	}
	
	/**
	 * 获取客户的IP地址
	 */
	public  String getIpddress() {
		//这是request提供的一种用来获取客户端的IP地址的方法
		return ServletActionContext.getRequest().getRemoteAddr();
	}
	/**
	 * 获取当前登录的用户
	 * 
	 */
	public User getUser() {
		//因为在登陆的时候，将用户信息保存在在session里面，创建的属性名为loginUser
		return (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	}
	
}

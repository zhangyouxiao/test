package cn.itcast.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 主题实体类
 * @author Lenovo
 *
 */
public class Topic  extends Acticle {
	private String title;//表题
	private  Date lastUpdateTime;//最新的根新时间
	private Integer type;//主题的类型,0表示普通帖，1，表示精华帖，2表示置顶帖
	private Forum forum; //主题对应的版块
	private Set<Reply>replys=new HashSet();//一个主题有多个回复一对多的关系
	private int  replyCount;//回复的数量
	private Reply lastReply;//最后一个回复
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public Set<Reply> getReplys() {
		return replys;
	}
	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	
	

}

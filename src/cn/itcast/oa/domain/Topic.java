package cn.itcast.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ����ʵ����
 * @author Lenovo
 *
 */
public class Topic  extends Acticle {
	private String title;//����
	private  Date lastUpdateTime;//���µĸ���ʱ��
	private Integer type;//���������,0��ʾ��ͨ����1����ʾ��������2��ʾ�ö���
	private Forum forum; //�����Ӧ�İ��
	private Set<Reply>replys=new HashSet();//һ�������ж���ظ�һ�Զ�Ĺ�ϵ
	private int  replyCount;//�ظ�������
	private Reply lastReply;//���һ���ظ�
	
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

package cn.itcast.oa.domain;

import java.util.Date;

/**
 * ����ʵ��
 * @author Lenovo
 *
 */
public class Acticle {
	private Long id;
	private String content;//����
	private  Date postTime; //�����ʱ��
	private User author;//����
	private String ipAddress;//ip��ַ
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
}

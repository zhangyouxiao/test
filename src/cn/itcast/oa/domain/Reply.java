package cn.itcast.oa.domain;

import java.util.Date;

/**
 * �ظ�ʵ����
 * @author Lenovo
 *
 */
public class Reply extends  Acticle{
	private Topic topic;//��ĳһ��������лظ�
	private int deleted;//ɾ����־Ϊ1��ʾ�Ѿ�ɾ����0��ʾ��ûɾ��
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
	

}

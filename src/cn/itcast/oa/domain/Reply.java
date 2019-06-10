package cn.itcast.oa.domain;

import java.util.Date;

/**
 * 回复实体类
 * @author Lenovo
 *
 */
public class Reply extends  Acticle{
	private Topic topic;//对某一个主题进行回复
	private int deleted;//删除标志为1表示已经删除，0表示还没删除
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

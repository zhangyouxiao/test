package cn.itcast.oa.domain;
/**
 *��̳���ʵ��
 * @author Lenovo
 *
 */

import java.util.HashSet;
import java.util.Set;

public class Forum {
	private Long  id;
	private String name;
	private String description;
	//������¼��̳��λ��
	private int position;
	//��ǰ�������ļ���
	private Set<Topic>topics=new HashSet<>();
	private int topicCount;  //��ʾ�Ѱ������������
	private int acticleCount;
	private Topic lastTopic;//��¼���һ������
	
	
	public Topic getLastTopic() {
		return lastTopic;
	}
	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}
	public Set<Topic> getTopics() {
		return topics;
	}
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	public int getTopicCount() {
		return topicCount;
	}
	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}
	public int getActicleCount() {
		return acticleCount;
	}
	public void setActicleCount(int acticleCount) {
		this.acticleCount = acticleCount;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	

}

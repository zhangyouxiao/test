package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

public interface ITopicService {

	List<Topic> findTopicByoforum(Forum model);

	void save(Topic model);

	Topic getById(Long id);

}

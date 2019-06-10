package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

public interface IReplyService{

	void save(Reply model);

	List<Reply> getBytopic(Topic topic);

}

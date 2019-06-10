package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Forum;

/**
 * °å¿é
 * @author Lenovo
 *
 */
public interface IForumService {

	List<Forum> findAll();

	Forum getById(Long id);

}

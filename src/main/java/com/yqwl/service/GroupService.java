package com.yqwl.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.yqwl.pojo.Group;

public interface GroupService {
	/**
	 * 
	 * @Title: getById
	 * @description 根据主键查询单条数据
	 * @param id
	 * @return
	 * @throws Exception
	 * Group
	 * @author likai
	 * @createDate 2019年2月15日 下午5:45:44
	 */
	Group getById(Long id) throws Exception;
	/**
	 * 
	 * @Title: listAll
	 * @description 分页查询所有
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception
	 * Map<String,Object>
	 * @author likai
	 * @createDate 2019年2月15日 下午5:46:03
	 */
	Map<String, Object> listAll(Integer page, Integer limit) throws Exception;
	/**
	 * 
	 * @Title: insert
	 * @description 新增
	 * @param group
	 * @param main_img
	 * @param group_img
	 * @return
	 * @throws Exception
	 * int
	 * @author likai
	 * @createDate 2019年2月15日 下午5:46:18
	 */
	int insert(Group group) throws Exception;
	/**
	 * 
	 * @Title: update
	 * @description 修改
	 * @param group
	 * @return
	 * @throws Exception
	 * int
	 * @author likai
	 * @createDate 2019年2月15日 下午5:46:27
	 */
	int update(Group group) throws Exception;
	/**
	 * 
	 * @Title: delete
	 * @description 删除
	 * @param id
	 * @return
	 * @throws Exception
	 * int
	 * @author likai
	 * @createDate 2019年2月15日 下午5:46:36
	 */
	int delete(Long id) throws Exception;
	/**
	 * 
	 * @Title: listByHomePage
	 * @description 首页推荐团队成员
	 * @return
	 * List<Group>
	 * @author likai
	 * @createDate 2019年2月17日 上午9:32:29
	 */
	List<Group> listByHomePage() throws Exception;
	/**
	 * 
	 * @Title: listByGroupPage
	 * @description 团队页面显示
	 * @return
	 * @throws Exception
	 * List<Group>
	 * @author likai
	 * @createDate 2019年2月17日 上午9:54:11
	 */
	List<Group> listByGroupPage() throws Exception;

}

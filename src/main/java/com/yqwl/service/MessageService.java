package com.yqwl.service;


import java.util.Map;
import com.yqwl.pojo.Message;

public interface MessageService {
	/**
	 * 
	 * @Title: listAll
	 * @description: 分页查询所有留言
	 *
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception    
	 * @return Map<String,Object>   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午10:14:32
	 */
	Map<String, Object> listAll(Integer page, Integer limit) throws Exception;
	/**
	 * 
	 * @Title: insert
	 * @description: 插入留言
	 *
	 * @param message
	 * @return
	 * @throws Exception    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午10:16:17
	 */
	int insert(Message message) throws Exception;
	/**
	 * 
	 * @Title: update
	 * @description:修改留言 
	 *
	 * @param message
	 * @return
	 * @throws Exception    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午10:16:35
	 */
	int update(Message message) throws Exception;
	/**
	 * 
	 * @Title: getById
	 * @description: 根据id查询留言
	 *
	 * @param id
	 * @return
	 * @throws Exception    
	 * @return Message   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午10:16:50
	 */
	Message getById(Long id) throws Exception;
	/**
	 * 
	 * @Title: listAllCount
	 * @description: 查询所有留言
	 *
	 * @return
	 * @throws Exception    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年3月1日-下午5:33:24
	 */
	int listAllCount()  throws Exception;
}

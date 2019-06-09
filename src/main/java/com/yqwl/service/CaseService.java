package com.yqwl.service;


import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.yqwl.pojo.Case;



/**
 * 
 *
 * @ClassName: CaseService
 *
 * @description 案例管理Service
 *
 * @author HanMeng
 * @createDate 2019年2月15日-上午9:44:08
 */
public interface CaseService {
	/**
	 * 
	 * @Title: insert
	 * @description: 插入案例
	 *
	 * @param record
	 * @return
	 * @throws Exception    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月15日-上午10:07:18
	 */
	int insert(Case record)throws Exception;

	/**
	 * 
	 * @Title: update
	 * @description: 案例修改
	 *
	 * @param record
	 * @param main_img
	 * @param case_img
	 * @return
	 * @throws Exception    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月15日-下午5:43:08
	 */
	int update(Case record)throws Exception;
	/**
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * @description: 修改上下架
	 *
	 * @param record
	 * @return    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月15日-上午10:13:24
	 */
	//int updateCaseStatus(Case record,Integer status)throws Exception;
	/**
	 * 
	 * @Title: deleteByPrimaryKey
	 * @description: 删除案例
	 *
	 * @param id
	 * @return    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月15日-上午10:13:54
	 */
	int deleteByPrimaryKey(Long id)throws Exception;
	/**
	 * 
	 * @Title: getById
	 * @description: 根据id查询
	 *
	 * @param id
	 * @return
	 * @throws Exception    
	 * @return Case   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月15日-下午5:57:10
	 */
	Case getById(Long id) throws Exception;

	/**
	 * 
	 * @Title: listAll
	 * @description: 分页查询所有
	 *
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception    
	 * @return Map<String,Object>   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午10:05:13
	 */
	Map<String, Object> listAll(Integer page, Integer limit) throws Exception;
	/**
	 * 
	 * @Title: listNewsByType
	 * @description:根据类型查询案例--前台显示用 
	 *
	 * @param type
	 * @param limit
	 * @return    
	 * @return List<Case>   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午4:57:56
	 */
	List<Case> listByCaseType(String type) throws Exception;
}

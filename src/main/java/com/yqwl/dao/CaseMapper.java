package com.yqwl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Case;


public interface CaseMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_case
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_case
	 * @mbggenerated
	 */
	int insert(Case record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_case
	 * @mbggenerated
	 */
	int insertSelective(Case record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_case
	 * @mbggenerated
	 */
	Case selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_case
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Case record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_case
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Case record);

	/**
	 * 
	 * @Title: listAll
	 * @description: 查询所有
	 *
	 * @param beginPageIndex
	 * @param limit
	 * @return    
	 * @return List<Case>   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午9:28:48
	 */
	List<Case> listAll(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
	/**
	 * 
	 * @Title: listAllCount
	 * @description: 查询案例总数
	 *
	 * @return    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午9:29:06
	 */
	int listAllCount();
	/**
	 * 
	 * @Title: listCaseByType
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
	List<Case> listCaseByType(@Param("type")String type);

}
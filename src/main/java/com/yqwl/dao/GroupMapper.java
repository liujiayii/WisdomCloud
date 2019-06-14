package com.yqwl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Group;

public interface GroupMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group
	 * @mbggenerated
	 */
	int insert(Group record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group
	 * @mbggenerated
	 */
	int insertSelective(Group record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group
	 * @mbggenerated
	 */
	Group selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Group record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Group record);

	List<Group> listAll(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);

	int listAllCount();

	List<Group> listByHomePage();

	List<Group> listByGroupPage();
}
package com.yqwl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Group;
import com.yqwl.pojo.Img;

public interface ImgMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_img
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_img
	 * @mbggenerated
	 */
	int insert(Img record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_img
	 * @mbggenerated
	 */
	int insertSelective(Img record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_img
	 * @mbggenerated
	 */
	Img selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_img
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Img record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_img
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Img record);

	Integer listAllCount();

	List<Img> listAll(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit") Integer limit);

	Img getByPlace(String place);

    List<Img> listAllImageForMain();
}
package com.yqwl.dao;

import com.yqwl.pojo.Column;

public interface ColumnMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_column
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_column
     *
     * @mbggenerated
     */
    int insert(Column record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_column
     *
     * @mbggenerated
     */
    int insertSelective(Column record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_column
     *
     * @mbggenerated
     */
    Column selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_column
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Column record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_column
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Column record);
}
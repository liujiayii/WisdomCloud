package com.yqwl.dao;

import java.math.BigInteger;
import java.util.List;

import com.yqwl.pojo.Information;

public interface InformationMapper {
	/**
	 * 
	     * @Title: 
	     * @description 根据id查找相对应的公司信息 
	     * @param  公司信息id
	     * @return   公司信息
	     * @author chenshuxian
	     * @createDate 2019年3月29日
	 */
	Information getInformationById(BigInteger informationId);
	/**
	 * 
	     * @Title: 
	     * @description 修改公司信息 
	     * @param  公司信息
	     * @return    
	     * @author chenshuxian
	     * @createDate 2019年3月29日
	 */
	Integer updateInformation(Information information);
	/**
	 * 
	     * @Title: 
	     * @description 添加公司信息
	     * @param  公司信息
	     * @return  成功执行的条数
	     * @author chenshuxian
	     * @createDate 2019年3月29日
	 */
	Integer insertInformation(Information information);
	
	/**
	 * 
	     * @Title: 
	     * @description 根据id删除公司信息 
	     * @param  公司信息
	     * @return    成功执行的条数
	     * @author chenshuxian
	     * @createDate 2019年3月29日
	 */
	Integer delInformation(BigInteger informationId);
	/**
	 * 
	     * @Title: 
	     * @description 获得公司信息
	     * @param  
	     * @return    公司信息
	     * @author chenshuxian
	     * @createDate 2019年3月29日
	 */
	List<Information> getInformation();
}

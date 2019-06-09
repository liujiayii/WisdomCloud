package com.yqwl.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Wanted;

/**
 * 
 *
 * @ClassName: WantedService
 * @description 招聘信息表的增删改查方法接口
 *
 * @author dujiawei
 * @createDate 2019年3月28日
 */
public interface WantedService {

	/**
	 * @Title: listWanted
	 * @description 招聘信息列表
	 * @param  page ,limit
	 * @return Map<String, Object>    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
    public Map<String, Object> listWanted(Integer page ,Integer limit) throws Exception;
	
    /**
     * @Title: countWanted
     * @description 招聘信息的数据条数
     * @return int    
     * @author dujiawei
     * @createDate 2019年3月28日
     */
	public int countWanted() throws Exception;
	
	/**
	 * @Title: saveWanted
	 * @description 新增招聘信息
	 * @param  wanted
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int saveWanted(Wanted wanted) throws Exception;
	
	/**
	 * @Title: updateWanted
	 * @description 修改招聘信息
	 * @param  wanted
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int updateWanted(Wanted wanted) throws Exception;
	
	/**
	 * @Title: changeWantedState
	 * @description 修改招聘信息状态
	 * @param  wanted
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int changeWantedState(Wanted wanted) throws Exception;
	
	/**
	 * @Title: removeWanted
	 * @description 删除招聘信息（硬删除）
	 * @param  id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int removeWanted(@Param("id") BigInteger id) throws Exception;
	
	/**
	 * @Title: getWantedById
	 * @description 通过id查询招聘信息
	 * @param  wanted
	 * @return Wanted    
	 *
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public Wanted getWantedById(Wanted wanted);
	
	/**
	 * @Title: showListWanted
	 * @description 官网显示的招聘信息(状态为上架的)
	 * @return List<Wanted>    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public List<Wanted> showListWanted();
	
	/**
	 * @Title: getWantedByjob
	 * @description 通过职位名称查询招聘信息
	 * @param  wanted
	 * @return List<Wanted>    
	 * @author dujiawei
	 * @createDate 2019年3月29日
	 */
	public List<Wanted> getWantedByjob(Wanted wanted);
}

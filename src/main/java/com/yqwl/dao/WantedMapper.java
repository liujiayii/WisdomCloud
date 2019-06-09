package com.yqwl.dao;

import java.math.BigInteger;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Wanted;

/**
 * 
 *
 * @ClassName: WantedMapper
 * @description 招聘信息表的增删改查方法接口
 *
 * @author dujiawei
 * @createDate 2019年3月28日
 */
public interface WantedMapper {
	
	/**
	 * @Title: listWanted
	 * @description 招聘信息列表
	 * @param  beginPageIndex ,limit
	 * @return List<Wanted>  
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
    List<Wanted> listWanted(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
    /**
     * @Title: countWanted
     * @description 招聘信息的数据条数
     * @return int    
     * @author dujiawei
     * @createDate 2019年3月28日
     */
	public int countWanted();
	
	/**
	 * @Title: saveWanted
	 * @description 新增招聘信息
	 * @param  wanted
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int saveWanted(Wanted wanted);
	
	/**
	 * @Title: updateWanted
	 * @description 修改招聘信息
	 * @param  wanted
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int updateWanted(Wanted wanted);
	
	/**
	 * @Title: changeWantedState
	 * @description 修改招聘信息状态
	 * @param  wanted
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int changeWantedState(Wanted wanted);
	
	/**
	 * @Title: removeWanted
	 * @description 删除招聘信息（硬删除）
	 * @param  id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int removeWanted(@Param("id") BigInteger id);
	
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

package com.yqwl.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Welfare;

/**
 * 
 *
 * @ClassName: WelfareService
 * @description 公司福利的增删改查方法
 *
 * @author dujiawei
 * @createDate 2019年3月28日
 */
public interface WelfareService {
	
	/**
	 * @Title: listWelfare
	 * @description 公司福利列表
	 * @param  page ,limit
	 * @return Map<String, Object> 
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public Map<String, Object> listWelfare(Integer page ,Integer limit) throws Exception;
    /**
     * @Title: countWelfare
     * @description 公司福利的数据条数
     * @return int    
     * @author dujiawei
     * @createDate 2019年3月28日
     */
	public int countWelfare() throws Exception;
	
	/**
	 * @Title: saveWelfare
	 * @description 新增公司福利信息
	 * @param  welfare
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int saveWelfare(Welfare welfare) throws Exception;
	
	/**
	 * @Title: updateWelfare
	 * @description 修改公司福利信息
	 * @param  welfare
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int updateWelfare(Welfare welfare) throws Exception;
	
	/**
	 * @Title: changeWelfareState
	 * @description 修改公司福利信息状态
	 * @param  welfare
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int changeWelfareState(Welfare welfare) throws Exception;
	
	/**
	 * @Title: removeWelfare
	 * @description 删除公司福利信息（硬删除）
	 * @param  id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int removeWelfare(@Param("id") BigInteger id) throws Exception;
	
	/**
	 * @Title: getWelfareById
	 * @description 通过id查询公司福利信息
	 * @param  welfare
	 * @return Welfare    
	 *
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public Welfare getWelfareById(Welfare welfare) throws Exception;
	
	/**
	 * @Title: showListWelfare
	 * @description 官网显示的公司福利信息(状态为上架的)
	 * @return List<Welfare>    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public List<Welfare> showListWelfare() throws Exception;

}

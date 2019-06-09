package com.yqwl.dao;

import java.math.BigInteger;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.yqwl.pojo.Welfare;

/**
 * 
 *
 * @ClassName: WelfareMapper
 * @description 公司福利的增删改查方法接口
 *
 * @author dujiawei
 * @createDate 2019年3月28日
 */
public interface WelfareMapper {
	
	/**
	 * @Title: listWelfare
	 * @description 公司福利列表
	 * @param  beginPageIndex ,limit
	 * @return List<Welfare>  
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
    List<Welfare> listWelfare(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
    /**
     * @Title: countWelfare
     * @description 公司福利的数据条数
     * @return int    
     * @author dujiawei
     * @createDate 2019年3月28日
     */
	public int countWelfare();
	
	/**
	 * @Title: saveWelfare
	 * @description 新增公司福利信息
	 * @param  welfare
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int saveWelfare(Welfare welfare);
	
	/**
	 * @Title: updateWelfare
	 * @description 修改公司福利信息
	 * @param  welfare
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int updateWelfare(Welfare welfare);
	
	/**
	 * @Title: changeWelfareState
	 * @description 修改公司福利信息状态
	 * @param  welfare
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int changeWelfareState(Welfare welfare);
	
	/**
	 * @Title: removeWelfare
	 * @description 删除公司福利信息（硬删除）
	 * @param  id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public int removeWelfare(@Param("id") BigInteger id);
	
	/**
	 * @Title: getWelfareById
	 * @description 通过id查询公司福利信息
	 * @param  welfare
	 * @return Welfare    
	 *
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public Welfare getWelfareById(Welfare welfare);
	
	/**
	 * @Title: showListWelfare
	 * @description 官网显示的公司福利信息(状态为上架的)
	 * @return List<Welfare>    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	public List<Welfare> showListWelfare();

}

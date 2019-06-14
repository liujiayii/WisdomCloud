package com.yqwl.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Trade;

/**
 *
 * @ClassName: TradeMapper
 * @description 行业的查询，新增，删除等方法
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
public interface TradeMapper {
	
	/**
	 * @Title: listTrade
	 * @description (后台)分页查询所有的行业
	 * @param @param beginPageIndex
	 * @param @param limit
	 * @return List<Trade>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	List<Trade> listTrade(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
    
	/**
	 * @Title: countTrade
	 * @description 所有行业的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int countTrade();
	
	/**
	 * @Title: saveTrade
	 * @description (后台)增加一条行业
	 * @param @param trade
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int saveTrade(Trade trade);
	
	/**
	 * @Title: removeTrade
	 * @description (后台)删除一条行业
	 * @param @param id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int removeTrade(@Param("id") BigInteger id);
	
	/**
	 * @Title: getTradeById
	 * @description (后台)通过id查询对应的行业
	 * @param @param trade
	 * @return Trade    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public Trade getTradeById(Trade trade);
	
	/**
	 * @Title: showAllTrade
	 * @description (前台)显示所有的行业
	 * @return List<Trade>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public List<Trade> showAllTrade();

}

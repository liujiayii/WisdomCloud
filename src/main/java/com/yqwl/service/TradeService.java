package com.yqwl.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.yqwl.pojo.Trade;

/**
 *
 * @ClassName: TradeService
 * @description 行业的查询，新增，删除等方法
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
public interface TradeService {
	
	/**
	 * @Title: listTrade
	 * @description (后台)分页查询所有的行业
	 * @param @param page
	 * @param @param limit
	 * @param @throws Exception   
	 * @return Map<String, Object>   
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	Map<String, Object> listTrade(Integer page ,Integer limit) throws Exception;
    
	/**
	 * @Title: countTrade
	 * @description 所有行业的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int countTrade() throws Exception;
	
	/**
	 * @Title: saveTrade
	 * @description (后台)增加一条行业
	 * @param @param trade
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int saveTrade(Trade trade) throws Exception;
	
	/**
	 * @Title: removeTrade
	 * @description (后台)删除一条行业
	 * @param @param id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int removeTrade(@Param("id") BigInteger id) throws Exception;
	
	/**
	 * @Title: getTradeById
	 * @description (后台)通过id查询对应的行业
	 * @param @param trade
	 * @return Trade    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public Trade getTradeById(Trade trade) throws Exception;
	
	/**
	 * @Title: showAllTrade
	 * @description (前台)显示所有的行业
	 * @return List<Trade>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public List<Trade> showAllTrade() throws Exception;

}

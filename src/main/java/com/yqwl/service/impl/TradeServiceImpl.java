package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yqwl.dao.TradeMapper;
import com.yqwl.pojo.Trade;
import com.yqwl.service.TradeService;

/**
 *
 * @ClassName: TradeServiceImpl
 * @description 行业表的Service实现层
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class TradeServiceImpl implements TradeService {
	
	@Resource
	private TradeMapper tradeMapper;

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
	@Override
	public Map<String, Object> listTrade(Integer page, Integer limit) throws Exception {
		// TODO Auto-generated method stub
		int tradeCount = tradeMapper.countTrade();
		int beginPageIndex = ((page - 1) * limit);
		List<Trade> tradeList = tradeMapper.listTrade(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", tradeCount);  //行业数量
		map.put("list", tradeList);  //行业列表
		
		return map;
	}

	/**
	 * @Title: countTrade
	 * @description 所有行业的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int countTrade() throws Exception {
		// TODO Auto-generated method stub
		return tradeMapper.countTrade();
	}

	/**
	 * @Title: saveTrade
	 * @description (后台)增加一条行业
	 * @param @param trade
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int saveTrade(Trade trade) throws Exception {
		// TODO Auto-generated method stub
		return tradeMapper.saveTrade(trade);
	}

	/**
	 * @Title: removeTrade
	 * @description (后台)删除一条行业
	 * @param @param id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int removeTrade(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		return tradeMapper.removeTrade(id);
	}

	/**
	 * @Title: getTradeById
	 * @description (后台)通过id查询对应的行业
	 * @param @param trade
	 * @return Trade    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public Trade getTradeById(Trade trade) throws Exception {
		// TODO Auto-generated method stub
		return tradeMapper.getTradeById(trade);
	}

	/**
	 * @Title: showAllTrade
	 * @description (前台)显示所有的行业
	 * @return List<Trade>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public List<Trade> showAllTrade() throws Exception {
		// TODO Auto-generated method stub
		return tradeMapper.showAllTrade();
	}

}

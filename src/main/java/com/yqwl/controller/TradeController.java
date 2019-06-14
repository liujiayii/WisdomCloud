package com.yqwl.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Trade;
import com.yqwl.pojo.User;
import com.yqwl.service.TradeService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("trade")
@Scope("prototype")
public class TradeController {
	
	@Resource
	private TradeService tradeService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @Title: TZlistTrade
	 * @description 跳转行业列表页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String TZlistTrade() {
		
		return "views/back/mouldTrade/trade";
	}
	
	/**
	 * @Title: listTrade
	 * @description (后台)分页查询所有的行业
	 * @param @param page, limit
	 * @return String    
	 *
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "listTrade", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listTrade(Integer page, Integer limit) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> trades = tradeService.listTrade(page, limit);
			if (trades.size() != 0) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, trades);
			}
			code = 1;
			msg = "查询失败";
			
			return FastJsonUtil.getResponseJson(code, msg, null);
			
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	/**
	 * @Title: add
	 * @description 跳转到新增行业页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@RequestMapping("/add")
	public String TZsaveTrade() {
		
		return "views/back/mouldTrade/addTrade";
	}
	
	/**
	 * @Title: saveTrade
	 * @description 增加一个行业
	 * @param @param trade, session
	 * @return String    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "saveTrade", method = RequestMethod.POST)
	public String saveTrade(@RequestBody Trade trade, HttpSession session) throws Exception {
		int code = 0;
		String msg = null;
		List<Trade> allTrade = tradeService.showAllTrade();  //查询所有的行业
		if(allTrade.size() > 0) {
			for(int i = 0; i < allTrade.size(); i++) {
				if(allTrade.get(i).getTradeName().equals(trade.getTradeName())){  //判断新增的行业名称是否已存在
					code = 1;
					msg = "该行业已存在，新增行业失败";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
			}
		}
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = tradeService.saveTrade(trade);
				if (num != 0) {
					code = 0;
					msg = "新增行业成功";
					
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "该行业已存在，新增行业失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
				
			} else {
				code = 2;
				msg = "您没有登录账号！";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	/**
	 * @Title: removeTrade
	 * @description (后台)删除一条行业
	 * @param @param id, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "removeTrade", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String removeTrade(BigInteger id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = tradeService.removeTrade(id);
				if (num != 0) {
					code = 0;
					msg = "删除行业成功";
					
					return FastJsonUtil.getResponseJson(code, msg, num);
				}
				code = 1;
				msg = "删除行业失败";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			} else {
				code = 2;
				msg = "未登录";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	/**
	 * @Title: showAllTrade
	 * @description (前台)显示所有的行业
	 * @return Object    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "showAllTrade", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Object showAllTrade() throws Exception {
		List<Trade> tradeList = tradeService.showAllTrade();
		
		Map<String , Object> result = new HashMap<String , Object>();		
		result.put("code", 0);
		result.put("msg", "Success");
		JSONArray array = JSONArray.fromObject(tradeList);
		result.put("data", array);
		
		return result;
	}

}

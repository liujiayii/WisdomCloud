package com.yqwl.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.IpUtils;
import com.yqwl.pojo.Amount;
import com.yqwl.pojo.User;
import com.yqwl.service.AmountService;
import com.yqwl.vo.StatisticsVo;
import com.yqwl.vo.TotalVo;

@Controller
@Scope("prototype")
@RequestMapping("amount")
public class AmountController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private AmountService amountService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String list() {
		return "views/back/Index/index";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "addVisit", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String addVisit(HttpServletRequest request) {
		int code = 0;
		String msg = null;
		try {
				String ip = IpUtils.getIpAddr(request);
				int i = amountService.addVisit(ip);
				if (i != 0) {
					code = 0;
					msg = "记录成功";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "记录失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	@ResponseBody
	@RequestMapping(value = "total", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String total(HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				TotalVo result = amountService.total();
				if (result != null) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = 1;
				msg = "查询失败";
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
	
	@ResponseBody
	@RequestMapping(value = "statistics", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String statistics(HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				List<StatisticsVo> result = amountService.statistics();
				if (result != null) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = 1;
				msg = "查询失败";
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
	
	@ResponseBody
	@RequestMapping(value = "listAllByData", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAllByDate(int dateType,HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				Map<String, Object> result = amountService.listAllByDate(dateType);
				if (result.get("data") != null) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = 1;
				msg = "查询失败";
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
}

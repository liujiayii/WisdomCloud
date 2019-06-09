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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.User;
import com.yqwl.pojo.Welfare;
import com.yqwl.service.WelfareService;
import net.sf.json.JSONArray;

/**
 * 
 *
 * @ClassName: WelfareController
 * @description 公司福利表的Controller层
 *
 * @author dujiawei
 * @createDate 2019年3月28日
 */
@Controller
@RequestMapping("welfare")
@Scope("prototype")
public class WelfareController {
	
	@Resource
	private WelfareService welfareService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @Title: list
	 * @description 跳转公司福利信息列表页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String TZlistWelfare() {
		
		return "views/back/WelfareManagement/WelfareShowed";
	}
	
	/**
	 * @Title: listWelfare
	 * @description 公司福利信息列表
	 * @param  page, limit
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "listWelfare", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listWelfare(Integer page, Integer limit) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> welfares = welfareService.listWelfare(page, limit);
			if (welfares.size() != 0) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, welfares);
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
	 * @Title: getWelfareById
	 * @description 通过id查询对应的公司福利信息，并跳转到修改公司福利信息页面
	 * @param  model, welfare
	 * @return String    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年3月28日
	 */
	@RequestMapping("/getWelfareById")
	public String getWelfareById(Model model ,Welfare welfare) throws Exception {
		Welfare w = welfareService.getWelfareById(welfare);
		model.addAttribute("welfare",w);
		
		return "views/back/WelfareManagement/updateWelfare";
	}
	
	/**
	 * @Title: add
	 * @description 跳转到新增公司福利信息页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@RequestMapping("/add")
	public String TZsaveWelfare() {
		
		return "views/back/WelfareManagement/addWelfare";
	}
	
	/**
	 * @Title: saveWelfare
	 * @description 增加招聘信息
	 * @param  welfare, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "saveWelfare", method = RequestMethod.POST)
	public String saveWelfare(@RequestBody Welfare welfare, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = welfareService.saveWelfare(welfare);
				if (i != 0) {
					code = 0;
					msg = "新增公司福利信息成功";
					
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "新增公司福利信息失败";
				
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
	 * @Title: updateWelfare
	 * @description 修改招聘信息
	 * @param  welfare, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "updateWelfare", method = RequestMethod.POST)
	public String updateWelfare(@RequestBody Welfare welfare, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = welfareService.updateWelfare(welfare);
				if (i != 0) {
					code = 0;
					msg = "修改公司福利信息成功";
					
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "修改公司福利信息失败";
				
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
	 * @Title: changeWelfareState
	 * @description 修改公司福利信息状态(上下架)
	 * @param  welfare, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "changeWelfareState", method = RequestMethod.POST)
	public String changeWelfareState(@RequestBody Welfare welfare, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = welfareService.changeWelfareState(welfare);
				if (i != 0) {
					code = 0;
					msg = "修改公司福利信息状态成功";
					
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "修改公司福利信息状态失败";
				
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
	 * @Title: removeWelfare
	 * @description 删除招聘信息
	 * @param  id, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "removeWelfare", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String removeWelfare(BigInteger id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = welfareService.removeWelfare(id);
				if (i != 0) {
					code = 0;
					msg = "删除公司福利信息成功";
					
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "删除公司福利信息失败";
				
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
	 * @Title: showListWelfare
	 * @description 官网显示的招聘信息(状态为上架的)
	 * @return Object    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "showListWelfare", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public Object showListWelfare() throws Exception {
		List<Welfare> welfareList = welfareService.showListWelfare();
		
		Map<String , Object> result = new HashMap<String , Object>();		
		result.put("code", 0);
		result.put("msg", "Success");
		JSONArray array = JSONArray.fromObject(welfareList);
		result.put("data", array);
		
		return result;
	}

}

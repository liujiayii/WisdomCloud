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
import com.yqwl.pojo.Wanted;
import com.yqwl.service.WantedService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("wanted")
@Scope("prototype")
public class WantedController {
	
	@Resource
	private WantedService wantedService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @Title: TZlistWanted
	 * @description 跳转招聘信息列表页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String TZlistWanted() {
		
		return "views/back/WantedManagement/WantedShowed";
	}
	
	/**
	 * @Title: listWanted
	 * @description 招聘信息列表
	 * @param @param page, limit
	 * @return String    
	 *
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "listWanted", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listWanted(Integer page, Integer limit) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> news = wantedService.listWanted(page, limit);
			if (news.size() != 0) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, news);
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
	 * @Title: getWantedById
	 * @description 通过id查询对应的招聘信息，并跳转到修改招聘信息页面
	 * @param @param model, wanted
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@RequestMapping("/getWantedById")
	public String getWantedById(Model model ,Wanted wanted) {
		Wanted w = wantedService.getWantedById(wanted);
		System.out.println(wanted);
		model.addAttribute("wanted",w);
		
		return "views/back/WantedManagement/updateWanted";
	}
	
	/**
	 * @Title: add
	 * @description 跳转到新增招聘信息页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@RequestMapping("/add")
	public String TZsaveWanted() {
		
		return "views/back/WantedManagement/addWanted";
	}
	
	/**
	 * @Title: saveWanted
	 * @description 增加招聘信息
	 * @param @param wanted, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "saveWanted", method = RequestMethod.POST)
	public String saveWanted(@RequestBody Wanted wanted, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = wantedService.saveWanted(wanted);
				if (i != 0) {
					code = 0;
					msg = "新增招聘信息成功";
					
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "新增招聘信息失败";
				
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
	 * @Title: updateWanted
	 * @description 修改招聘信息
	 * @param @param wanted, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "updateWanted", method = RequestMethod.POST)
	public String updateWanted(@RequestBody Wanted wanted, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = wantedService.updateWanted(wanted);
				if (i != 0) {
					code = 0;
					msg = "修改招聘信息成功";
					
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "修改招聘信息失败";
				
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
	 * @Title: changeWantedState
	 * @description 修改招聘信息状态(上下架)
	 * @param @param wanted, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "changeWantedState", method = RequestMethod.POST)
	public String changeWantedState(@RequestBody Wanted wanted, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = wantedService.changeWantedState(wanted);
				if (i != 0) {
					code = 0;
					msg = "修改招聘信息状态成功";
					
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "修改招聘信息状态失败";
				
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
	 * @Title: removeWanted
	 * @description 删除招聘信息
	 * @param @param id, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "removeWanted", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String removeWanted(BigInteger id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = wantedService.removeWanted(id);
				if (i != 0) {
					code = 0;
					msg = "删除招聘信息成功";
					
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "删除招聘信息失败";
				
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
	 * @Title: showListWanted
	 * @description 官网显示的招聘信息(状态为上架的)
	 * @return Object    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@ResponseBody
	@RequestMapping(value = "showListWanted", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public Object showListWanted() {
		List<Wanted> wantedList = wantedService.showListWanted();
		
		Map<String , Object> result = new HashMap<String , Object>();		
		result.put("code", 0);
		result.put("msg", "Success");
		JSONArray array = JSONArray.fromObject(wantedList);
		result.put("data", array);
		
		return result;
	}
	
	/**
	 * @Title: getWantedByjob
	 * @description 通过职位名称查询招聘信息
	 * @param  wanted
	 * @return Object    
	 * @author dujiawei
	 * @createDate 2019年3月29日
	 */
	@ResponseBody
	@RequestMapping(value = "getWantedByjob", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public Object getWantedByjob(@RequestBody Wanted wanted) {
		List<Wanted> wantedList = wantedService.getWantedByjob(wanted);
		
		Map<String , Object> result = new HashMap<String , Object>();		
		result.put("code", 0);
		result.put("msg", "Success");
		JSONArray array = JSONArray.fromObject(wantedList);
		result.put("data", array);
		
		return result;
	}
	

}

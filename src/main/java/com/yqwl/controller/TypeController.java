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
import com.yqwl.pojo.Type;
import com.yqwl.pojo.User;
import com.yqwl.service.TypeService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("type")
@Scope("prototype")
public class TypeController {
	
	@Resource
	private TypeService typeService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @Title: TZlistType
	 * @description 跳转类型列表页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String TZlistType() {
		
		return "views/back/mouldSort/sort";
	}
	
	/**
	 * @Title: listType
	 * @description (后台)分页查询所有的类型
	 * @param @param page, limit
	 * @return String    
	 *
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	@ResponseBody
	@RequestMapping(value = "listType", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listType(Integer page, Integer limit) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> types = typeService.listType(page, limit);
			if (types.size() != 0) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, types);
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
	 * @description 跳转到新增类型页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	@RequestMapping("/add")
	public String TZsaveType() {
		
		return "views/back/mouldSort/addSort";
	}
	
	/**
	 * @Title: saveType
	 * @description 增加一个类型
	 * @param @param type, session
	 * @return String    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@ResponseBody
	@RequestMapping(value = "saveType", method = RequestMethod.POST)
	public String saveType(@RequestBody Type type, HttpSession session) throws Exception {
		int code = 0;
		String msg = null;
		List<Type> allType = typeService.showAllType();  //查询所有的类型
		if(allType.size() > 0) {
			for(int i = 0; i < allType.size(); i++) {
				if(allType.get(i).getTypeName().equals(type.getTypeName())){  //判断新增的类型是否已存在
					code = 1;
					msg = "该类型已存在，新增类型失败";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
			}
		}
		
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = typeService.saveType(type);
				if (num != 0) {
					code = 0;
					msg = "新增类型成功";
					
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "该类型已存在，新增类型失败";
				
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
	 * @Title: removeType
	 * @description (后台)删除一条类型
	 * @param @param id, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	@ResponseBody
	@RequestMapping(value = "removeType", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String removeType(BigInteger id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = typeService.removeType(id);
				if (num != 0) {
					code = 0;
					msg = "删除类型成功";
					
					return FastJsonUtil.getResponseJson(code, msg, num);
				}
				code = 1;
				msg = "删除类型失败";
				
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
	 * @Title: showAllType
	 * @description (前台)显示所有的类型
	 * @return Object    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@ResponseBody
	@RequestMapping(value = "showAllType", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Object showAllType() throws Exception {
		List<Type> typeList = typeService.showAllType();
		
		Map<String , Object> result = new HashMap<String , Object>();		
		result.put("code", 0);
		result.put("msg", "Success");
		JSONArray array = JSONArray.fromObject(typeList);
		result.put("data", array);
		
		return result;
	}

}

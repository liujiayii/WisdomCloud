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
import com.yqwl.pojo.Color;
import com.yqwl.pojo.User;
import com.yqwl.service.ColorService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("color")
@Scope("prototype")
public class ColorController {
	
	@Resource
	private ColorService colorService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @Title: TZlistColor
	 * @description 跳转色系列表页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String TZlistColor() {
		
		return "views/back/mouldColor/color";
	}
	
	/**
	 * @Title: listColor
	 * @description (后台)分页查询所有的色系
	 * @param @param page, limit
	 * @return String    
	 *
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	@ResponseBody
	@RequestMapping(value = "listColor", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listColor(Integer page, Integer limit) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> colors = colorService.listColor(page, limit);
			if (colors.size() != 0) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, colors);
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
	 * @description 跳转到新增色系页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	@RequestMapping("/add")
	public String TZsaveColor() {
		
		return "views/back/mouldColor/addColor";
	}
	
	/**
	 * @Title: saveColor
	 * @description 新增一条色系
	 * @param @param color, session
	 * @return String    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@ResponseBody
	@RequestMapping(value = "saveColor", method = RequestMethod.POST)
	public String saveColor(@RequestBody Color color, HttpSession session) throws Exception {
		int code = 0;
		String msg = null;
		List<Color> allColor = colorService.showAllColor();  //查询所有的色系
		if(allColor.size() > 0) {
			for(int i = 0; i < allColor.size(); i++) {
				if(allColor.get(i).getColorName().equals(color.getColorName())){  //判断新增的色系是否已存在
					code = 1;
					msg = "该色系已存在，新增色系失败";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
			}
		}
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = colorService.saveColor(color);
				if (num != 0) {
					code = 0;
					msg = "新增色系成功";
					
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "该色系已存在，新增色系失败";
				
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
	 * @Title: removeColor
	 * @description (后台)删除一条色系
	 * @param @param id, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	@ResponseBody
	@RequestMapping(value = "removeColor", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String removeColor(BigInteger id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = colorService.removeColor(id);
				if (num != 0) {
					code = 0;
					msg = "删除色系成功";
					
					return FastJsonUtil.getResponseJson(code, msg, num);
				}
				code = 1;
				msg = "删除色系失败";
				
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
	 * @Title: showAllColor
	 * @description (前台)显示所有的色系
	 * @return Object    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@ResponseBody
	@RequestMapping(value = "showAllColor", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Object showAllColor() throws Exception {
		List<Color> colorList = colorService.showAllColor();
		
		Map<String , Object> result = new HashMap<String , Object>();		
		result.put("code", 0);
		result.put("msg", "Success");
		JSONArray array = JSONArray.fromObject(colorList);
		result.put("data", array);
		
		return result;
	}

}

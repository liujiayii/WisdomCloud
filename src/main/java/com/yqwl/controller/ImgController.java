package com.yqwl.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Img;
import com.yqwl.pojo.User;
import com.yqwl.service.ImgService;

@Controller
@RequestMapping("picture")
@Scope("prototype")
public class ImgController {
	@Resource
	private ImgService imgService;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String list() {
		return "views/back/ImageManagement/ImageManagement";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String update() {
		return "views/back/ImageManagement/updateImageManagement";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String add() {
		return "views/back/ImageManagement/addImageManagement";
	}

	/**
	 * 
	 * @Title: getById
	 * @description 用一句话描述这个方法的作用
	 * @param id
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年2月15日 下午2:29:51
	 */
	@ResponseBody
	@RequestMapping(value = "getById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getById(Long id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {

			Img img = imgService.getById(id);
			if (img != null) {
				code = 0;
				msg = "查询成功";
				return FastJsonUtil.getResponseJson(code, msg, img);
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
	 * 
	 * @Title: listAll
	 * @description 分页查询所有
	 * @param page
	 * @param limit
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年2月19日 上午11:34:09
	 */
	@ResponseBody
	@RequestMapping(value = "listAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAll(Integer page, Integer limit, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> img = imgService.listAll(page, limit);
			if (img.get("list") != null) {
				code = 0;
				msg = "查询成功";
				return FastJsonUtil.getResponseJson(code, msg, img);
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
	 * 
	 * @Title: insert
	 * @description 新增图片
	 * @param img
	 * @param file
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年2月19日 上午11:34:40
	 */
	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public Map<String, Object>  insert(@RequestBody Img img, HttpSession session) {
	    Map<String, Object> map = new HashMap<>();
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				int i = imgService.insert(img);
				if (i != 0) {
				    map.put("code", 0);
				    map.put("msg", "新增成功");
					return map;
				}
				map.put("code", 1);
                map.put("msg", "新增失败");
                return map;
			} else {
			    map.put("code", 2);
                map.put("msg", "未登录");
                return map;
			}
		} catch (Exception e) {
		    map.put("code", -1);
            map.put("msg", "系统异常");
            return map;
		}
	}

	/**
	 * 
	 * @Title: update
	 * @description 修改图片
	 * @param img
	 * @param file
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年2月19日 上午11:34:49
	 */
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody Img img, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				int i = imgService.update(img);
				if (i != 0) {
					code = 0;
					msg = "修改成功";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "修改失败";
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
	 * 
	 * @Title: delete
	 * @description 删除图片
	 * @param id
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年2月19日 上午11:35:05
	 */
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String delete(Long id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				int i = imgService.delete(id);
				if (i != 0) {
					code = 0;
					msg = "删除成功";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "删除失败";
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
	 * 。
	 * 
	 * @Title: getByPlace
	 * @description 根据位置查询图片
	 * @param Place
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年2月19日 上午11:35:16
	 */
	@ResponseBody
	@RequestMapping(value = "getByPlace", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getByPlace(String Place, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			Img img = imgService.getByPlace(Place);
			if (img != null) {
				code = 0;
				msg = "查询成功";
				return FastJsonUtil.getResponseJson(code, msg, img);
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
}

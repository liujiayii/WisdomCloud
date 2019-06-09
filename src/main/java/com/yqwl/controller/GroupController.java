package com.yqwl.controller;

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
import com.yqwl.pojo.Group;
import com.yqwl.pojo.User;
import com.yqwl.service.GroupService;

/**
 * 
 * @ClassName: GroupController
 * @description 团队控制器
 * @author likai
 * @createDate 2019年2月15日 下午2:29:55
 */
@Controller
@RequestMapping("group")
@Scope("prototype")
public class GroupController {
	@Resource
	private GroupService groupService;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String list() {
		return "views/back/TeamManagement/TeamShowed";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String update() {
		return "views/back/TeamManagement/updateTeamShowed";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String add() {
		return "views/back/TeamManagement/addTeamShowed";
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
			Group group = groupService.getById(id);
			if (group != null) {
				code = 0;
				msg = "查询成功";
				return FastJsonUtil.getResponseJson(code, msg, group);
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

	@ResponseBody
	@RequestMapping(value = "listAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAll(Integer page, Integer limit, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> group = groupService.listAll(page, limit);
			if (group.get("list") != null) {
				code = 0;
				msg = "查询成功";
				return FastJsonUtil.getResponseJson(code, msg, group);
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

	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@RequestBody Group group, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				int i = groupService.insert(group);
				if (i != 0) {
					code = 0;
					msg = "新增成功";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "新增失败";
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
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody Group group, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				int i = groupService.update(group);
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

	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String delete(Long id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				int i = groupService.delete(id);
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

	@ResponseBody
	@RequestMapping(value = "listByHomePage", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listByHomePage(HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			List<Group> group = groupService.listByHomePage();
			if (group.size() != 0) {
				code = 0;
				msg = "查询成功";
				return FastJsonUtil.getResponseJson(code, msg, group);
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

	@ResponseBody
	@RequestMapping(value = "listByGroupPage", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listByGroupPage(HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			List<Group> group = groupService.listByGroupPage();
			if (group.size() != 0) {
				code = 0;
				msg = "查询成功";
				return FastJsonUtil.getResponseJson(code, msg, group);
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

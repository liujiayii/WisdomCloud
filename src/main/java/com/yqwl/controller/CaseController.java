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
import com.yqwl.pojo.Case;
import com.yqwl.pojo.User;
import com.yqwl.service.CaseService;

/**
 * 
 *
 * @ClassName: CaseController
 *
 * @description 案例控制器
 *
 * @author HanMeng
 * @createDate 2019年2月17日-下午1:24:47
 */

@Controller
@RequestMapping("/case")
@Scope("prototype")
public class CaseController {
	@Resource
	private CaseService caseService;

	private final Logger logger = LoggerFactory.getLogger(getClass());
	//前台跳转案例
	@RequestMapping(value = "case", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String cases() {
		return "views/front/case/case";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String list() {
		return "views/back/CaseManagement/CaseManagement";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String add() {
		return "views/back/CaseManagement/addCaseManagement";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String update() {
		return "views/back/CaseManagement/updateCaseManagement";
	}
	/**
	 * 
	 * @Title: addCase
	 * @description:增加案例
	 *
	 * @param cases
	 * @param main_img
	 * @param case_img
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月17日-下午1:20:31
	 */
	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String addCase(@RequestBody Case cases, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = caseService.insert(cases);
				if (i != 0) {
					code = 0;
					msg = "新增案例成功";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "新增案例失败";
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
	 * 
	 * @Title: update
	 * @description: 修改案例
	 *
	 * @param cases
	 * @param main_img
	 * @param case_img
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月17日-下午1:25:38
	 */
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody Case cases, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = caseService.update(cases);
				if (i != 0) {
					code = 0;
					msg = "修改案例成功";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "修改案例失败";
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
	 * @description: 根据主键删除案例
	 *
	 * @param id
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月17日-下午1:25:50
	 */
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String update(Long id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = caseService.deleteByPrimaryKey(id);
				if (i != 0) {
					code = 0;
					msg = "删除案例成功";
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "删除案例失败";
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
	 * @Title: getById
	 * @description: 根据id查询
	 *
	 * @param id
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月17日-下午1:34:05
	 */
	@ResponseBody
	@RequestMapping(value = "getById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getById(Long id) {
		int code = 0;
		String msg = null;
		try {
			
				Case cases = caseService.getById(id);
				if (cases != null) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, cases);
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
	 * @description: 分页查询所有案例
	 *
	 * @param page
	 * @param limit
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午10:09:18
	 */
	@ResponseBody
	@RequestMapping(value = "listAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAll(Integer page, Integer limit, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
		
				Map<String, Object> cases = caseService.listAll(page, limit);
				if (cases.size() != 0) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, cases);
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
	 * @Title: listByNewsType
	 * @description: 根据案例类型查询
	 *
	 * @param limit
	 * @param type
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午5:14:40
	 */
	@ResponseBody
	@RequestMapping(value = "listCaseByType", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listCaseByType(String type, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
		
				List<Case> caseList = caseService.listByCaseType(type);
				if (caseList != null) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, caseList);
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

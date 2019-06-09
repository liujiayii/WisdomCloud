package com.yqwl.controller;

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
import com.yqwl.pojo.Message;
import com.yqwl.pojo.User;
import com.yqwl.service.MessageService;

/**
 * 
 *
 * @ClassName: MessageController
 *
 * @description 留言控制器
 *
 * @author HanMeng
 * @createDate 2019年2月17日-下午3:32:38
 */
@Controller
@RequestMapping("message")
@Scope("prototype")
public class MessageController {

	@Resource
	private MessageService messageService;

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String list() {
		return "views/back/DataManagement/DataManagement";
	}

	
	/**
	 * 
	 * @Title: listAll
	 * @description: 查询所有留言加分页
	 *
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月17日-下午3:32:33
	 */
	@ResponseBody
	@RequestMapping(value = "listAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAll(Integer page, Integer limit, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				Map<String, Object> message = messageService.listAll(page, limit);
				if (message.size() != 0) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, message);
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

	/**
	 * 
	 * @Title: insert
	 * @description: 插入留言
	 *
	 * @param message
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月17日-下午3:36:02
	 */
	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@RequestBody Message message) {
		int code = 0;
		String msg = null;
		try {			
		        message.setStatus(0);
				int i = messageService.insert(message);
				if (i != 0) {
					code = 0;
					msg = "新增成功";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "新增失败";
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
	 * @Title: update
	 * @description:更改留言状态
	 *
	 * @param message
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月17日-下午3:36:17
	 */
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestBody Message message, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				int i = messageService.update(message);
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
	 * @Title: listAllCount
	 * @description: 查询留言次数
	 *
	 * @param session
	 * @return    
	 * @return String   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月28日-下午5:23:39
	 */
	@ResponseBody
	@RequestMapping(value = "listAllCount", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAllCount( HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				int i = messageService.listAllCount();
				if (i >  -1) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, i);
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

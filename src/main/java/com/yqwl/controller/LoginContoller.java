package com.yqwl.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.verifyCode.utils.Captcha;
import com.yqwl.common.verifyCode.utils.SpecCaptcha;
import com.yqwl.pojo.User;
import com.yqwl.service.UserService;

/**
 * 
 * @ClassName: LoginContoller
 * @description 后台登陆控制器
 * @author likai
 * @createDate 2019年2月15日 上午10:00:54
 */
@Controller
@RequestMapping("login")
@Scope("prototype")
public class LoginContoller {
	@Resource
	private UserService userService;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	
	@RequestMapping(value = "supervisor", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String get() {
		return "views/back/logo/index";
	}
	/**
	 * 
	 * @Title: login
	 * @description 后台登陆
	 * @param account
	 * @param password
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年2月15日 上午11:10:19
	 */
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String login(@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "verifyCode", required = true) String verifyCode, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			if (verifyCode == null || !verifyCode.equalsIgnoreCase((String) session.getAttribute("verifyCode"))) {
				code = 1;
				msg = "验证码错误";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			User user = userService.login(account, password);
			if (user == null) {
				code = 1;
				msg = "账号或密码错误";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			session.setAttribute("login_user", user);
			code = 0;
			msg = "登陆成功";
			return FastJsonUtil.getResponseJson(code, msg, user);
		} catch (Exception e) {
			code = -1;
			msg = "登陆失败";
			logger.error(e.getMessage(), e);
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: logout
	 * @description 后台登出
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年2月15日 上午11:10:29
	 */
	@ResponseBody
	@RequestMapping(value = "logout", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String logout(HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			session.invalidate();
			code = 0;
			msg = "退出成功";
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -1;
			msg = "退出失败";
			logger.error(e.getMessage(), e);
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}

	/**
	 * 生成验证码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "getCode")
	public void validateCode(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		if(session.getAttribute("verifyCode") != null){
			session.removeAttribute("verifyCode");
		}
		// 禁止图像缓存
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		Captcha captcha = new SpecCaptcha(165, 70, 5);// png格式验证码
		ServletOutputStream out = response.getOutputStream();
		BufferedImage bi = captcha.out(out);
		// 获取验证码字符串放到session中，用于登录时取出来验证
		String verifyCode = captcha.text();
		session.setAttribute("verifyCode", verifyCode);
		logger.info("本次登陆验证码："+verifyCode);
		// 将图像输出到 servlet的输出流中
		ImageIO.write(bi, "png", out);
		try {
			out.flush();
		} finally {
			out.close();
		}

	}

}

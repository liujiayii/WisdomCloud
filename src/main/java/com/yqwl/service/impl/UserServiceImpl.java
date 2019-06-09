package com.yqwl.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.common.utils.DesUtil;
import com.yqwl.common.utils.MD5Encrypt;
import com.yqwl.dao.UserMapper;
import com.yqwl.pojo.User;
import com.yqwl.service.UserService;

@Service("userService")
@Transactional(rollbackFor = { Exception.class })
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public User login(String account, String password) throws Exception {
		// 验证帐号密码
		User user = verify(account, password);
		if (user != null) {
			user.setTime(new Date());
			userMapper.updateByPrimaryKeySelective(user);
		}
		return user;
	}
	/**
	 * 
	 * @Title: verify
	 * @description 验证账号密码
	 * @param account
	 * @param password
	 * @return
	 * User
	 * @author likai
	 * @createDate 2019年2月15日 上午11:10:53
	 */
	private User verify(String account, String password) {
		String DESPwd = DesUtil.encode("hanmeng1", password);
		String MD5Pwd = MD5Encrypt.MD5Encode(DESPwd);
		return userMapper.selectByAccountAndPassword(account,MD5Pwd);
	}
}

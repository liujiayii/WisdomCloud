package com.yqwl.service;

import com.yqwl.pojo.User;

public interface UserService {
	/**
	 * 
	 * @Title: login
	 * @description 登陆
	 * @param account
	 * @param password
	 * @return
	 * @throws Exception
	 * User
	 * @author likai
	 * @createDate 2019年2月15日 上午11:10:40
	 */
	User login(String account, String password) throws Exception;

}

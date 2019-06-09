package com.yqwl.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.yqwl.pojo.Partner;

public interface PartnerService {

	/**
	 * @description 查询全部合作伙伴
	 * @param
	 * @return 合作伙伴列表
	 * @author chenshuxian
	 * @createDate 2019年3月27日
	 */
	Map<String,Object> listPartner(Integer page, Integer limit);

	/**
	 * 
	 * @description 添加合作伙伴
	 * @param 合作伙伴实体类
	 * @return 成功执行条数
	 * @author chenshuxian
	 * @createDate 2019年3月27日
	 */
	Map<String,Object> insertPartner(Partner partner);

	/**
	 * 
	 * @description 修改合作伙伴
	 * @param 合作伙伴实体类
	 * @return 成功执行条数
	 * @author chenshuxian
	 * @createDate 2019年3月27日
	 */
	Map<String,Object> updatePartner(Partner partner);

	/**
	 * 
	 * @description 根据id删除合作伙伴
	 * @param 合作伙伴id
	 * @return 成功执行条数
	 * @author chenshuxian
	 * @createDate 2019年3月27日
	 */
	Integer deletePartner(BigInteger partnerId);
	/**
	 * 
	     * @Title: 
	     * @description 根据姓名或者id获得合作伙伴
	     * @param  
	     * @return    
	     * @author 
	     * @createDate
	 */
	Partner getPartnerByName(Partner partner);
	/**
	 * 
	     * @Title: 
	     * @description 根据合作伙伴id获得合作伙伴信息 
	     * @param 
	     * @return 合作伙伴实体类
	     * @author chenshuxian
	     * @createDate 2019年3月27日
	 */
	Partner getPartnerById(Partner partner);
}

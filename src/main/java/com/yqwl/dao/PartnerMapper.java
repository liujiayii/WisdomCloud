package com.yqwl.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Partner;

public interface PartnerMapper {
	
	/**
	     * @description 查询全部合作伙伴
	     * @param  
	     * @return  合作伙伴列表
	     * @author chenshuxian
	     * @createDate 2019年3月27日
	 */
	List<Partner> listPartner(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
	/**
	 * 
	     * @description 添加合作伙伴
	     * @param  合作伙伴实体类
	     * @return  成功执行条数
	     * @author chenshuxian
	     * @createDate 2019年3月27日
	 */
	Integer insertPartner(Partner partner);
	/**
	 * 
	     * @description 修改合作伙伴
	     * @param  合作伙伴实体类
	     * @return  成功执行条数
	     * @author chenshuxian
	     * @createDate 2019年3月27日
	 */
	Integer updatePartner(Partner partner);
	/**
	 * 
	     * @description 根据id删除合作伙伴
	     * @param  合作伙伴id
	     * @return  成功执行条数
	     * @author  chenshuxian
	     * @createDate 2019年3月27日
	 */
	Integer deletePartner(BigInteger partnerId);
	/**
	 * 
	     * @Title: 
	     * @description 根据合作伙伴名称或者id获得合作伙伴信息 用来（判重）
	     * @param 合作伙伴姓名必传 id可传可不传
	     * @return 合作伙伴实体类
	     * @author chenshuxian
	     * @createDate 2019年3月27日
	 */
	Partner getPartnerByName(Partner partner);
	/**
	 *
	     * @description 获得所有合作伙伴条数
	     * @param  
	     * @return  
	     * @author chenshuxian
	     * @createDate 2019年3月27日
	 */
	Integer getAllPartnerCount();
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

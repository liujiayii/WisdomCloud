package com.yqwl.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.yqwl.pojo.News;
import com.yqwl.pojo.NewsImg;
import com.yqwl.vo.NewsVo;

public interface NewsService {
	/**
	 * 
	 * @Title: deleteByPrimaryKey
	 * @description: 根据主键删除新闻
	 *
	 * @param id
	 * @return    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午1:53:45
	 */
	int deleteByPrimaryKey(Long id) throws Exception ;
	/**
	 * 
	 * @Title: insert
	 * @description: 插入新闻
	 *
	 * @param news
	 * @return
	 * @throws Exception    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午1:59:13
	 */
	int insert(News news) throws Exception;
	/**
	 * 
	 * @Title: update
	 * @description: 修改咨讯 
	 *
	 * @param news
	 * @return
	 * @throws Exception    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午3:22:12
	 */
	int update(News news) throws Exception;
	/**
	 * 
	 * @Title: listAll
	 * @description: 查询所有加分页
	 *
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception    
	 * @return Map<String,Object>   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午3:22:45
	 */
	Map<String, Object> listAll(Integer page, Integer limit) throws Exception;
	/**
	 * 
	 * @Title: getById
	 * @description: 根据主键查询
	 *
	 * @param id
	 * @return
	 * @throws Exception    
	 * @return NewsVo   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午3:23:23
	 */
	NewsVo getById(Long id) throws Exception;
	/**
	 * 
	 * @Title: addNewsImg
	 * @description: 添加咨讯图片
	 *
	 * @param files

	 * @param id
	 * @return
	 * @throws Exception    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午3:27:30
	 */
	int addNewsImg(NewsImg newsImg) throws Exception;
	/**
	 * 
	 * @Title: deleteNewsImg
	 * @description: 删除咨讯图片
	 *
	 * @param id
	 * @return
	 * @throws Exception    
	 * @return int   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午3:27:53
	 */
	int deleteNewsImg(Long id) throws Exception;
	
	/**
	 * 
	     * @Title: 
	     * @description 获得企业动态
	     * @param  栏目
	     * @return    
	     * @author chenshuxian
	     * @createDate 2019年4月1日
	 */
	Map<String,Object> getBusinessMovement(@Param("type")String type,@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
    
	/**
     * @Title: updateStatus
     * @description 修改新闻咨询的上下架
     *
     * @param @param news
     * @param @return
     * @param @throws Exception   
     * @return int    
     *
     * @author liujunkai
     * @createDate 2019年4月16日
     */
    int updateStatus(News news) throws Exception;
}

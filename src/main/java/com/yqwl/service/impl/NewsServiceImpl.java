package com.yqwl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yqwl.common.utils.UpdateFile;
import com.yqwl.dao.NewsImgMapper;
import com.yqwl.dao.NewsMapper;
import com.yqwl.pojo.News;
import com.yqwl.pojo.NewsImg;
import com.yqwl.service.NewsService;
import com.yqwl.vo.NewsVo;

@Service("newsService")
@Transactional(rollbackFor = { Exception.class })
public class NewsServiceImpl implements  NewsService{
	@Resource
	private NewsMapper newsMapper;
	@Resource
	private NewsImgMapper newsImgMapper;
	@Override
	public int deleteByPrimaryKey(Long id) throws Exception {
		return newsMapper.deleteByPrimaryKey(id);
			
	}

	@Override
	public int insert(News news) throws Exception {
		return newsMapper.insert(news);
		
	}

	@Override
	public int update(News news) throws Exception {
		return newsMapper.updateByPrimaryKeyWithBLOBs(news);
	
	}
	
	@Override
	public int updateStatus(News news) throws Exception {
	    return newsMapper.updateByPrimaryKeySelective(news);
	}
	
	/**
	 * 
	
	  * @Title: NewsServiceImpl.java
	
	  * @Package com.yqwl.service.impl
	
	  * @Description: 查询所有加分页
	
	  * @author HanMeng
	
	  * @date 2019年2月18日-下午2:43:52
	 */
	@Override
	public Map<String, Object> listAll(Integer page, Integer limit) throws Exception {
		int resultCount = newsMapper.listAllCount();
		int beginPageIndex = ((page - 1) * limit);
		List<News> result = newsMapper.listAll(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", resultCount);
		map.put("list", result);
		return map;
		
	}
	/**
	 * 
	
	  * @Title: NewsServiceImpl.java
	
	  * @Package com.yqwl.service.impl
	
	  * @Description: 根据主键查询
	
	  * @author HanMeng
	
	  * @date 2019年2月18日-下午2:44:28
	 */
	@Override
	public NewsVo getById(Long id) throws Exception {
		News news = newsMapper.selectByPrimaryKey(id);
		NewsVo newsVo = new NewsVo();
		BeanUtils.copyProperties(news,newsVo);
		List<NewsImg> newsImg = newsImgMapper.getByNewsId(id);
		newsVo.setNewsImgs(newsImg);
		return newsVo;
		
	}

	@Override
	public int addNewsImg(NewsImg newsImg) throws Exception {
	
		return newsImgMapper.insertSelective(newsImg);
		
	}

	@Override
	public int deleteNewsImg(Long id) throws Exception {
		int i = 0;
		NewsImg newsImg  = newsImgMapper.selectByPrimaryKey(id);
		Map<String,Object> map = UpdateFile.deleatFile(newsImg.getUrl());
		int code = (int) map.get("code");
		if (code == 0) {
			i = newsImgMapper.deleteByPrimaryKey(id);
		}
		return i;
		
	}

	

	@Override
	public Map<String,Object> getBusinessMovement(String type, Integer page, Integer limit) {
	
		int resultCount = newsMapper.getNewsCount();
		int beginPageIndex = ((page - 1) * limit);
		List<News> result = newsMapper.getBusinessMovement(type, beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", resultCount);
		map.put("list", result);
		return map;
	}

	
}

package com.yqwl.vo;

import java.util.List;

import com.yqwl.pojo.News;
import com.yqwl.pojo.NewsImg;

public class NewsVo extends News {
	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	private List<NewsImg> newsImgs;
	public List<NewsImg> getNewsImgs() {
		return newsImgs;
	}
	public void setNewsImgs(List<NewsImg> newsImgs) {
		this.newsImgs = newsImgs;
	}
	
}

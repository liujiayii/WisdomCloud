package com.yqwl.service;

import java.util.List;
import java.util.Map;


import com.yqwl.pojo.Img;

public interface ImgService {

	Img getById(Long id) throws Exception;

	Map<String, Object> listAll(Integer page, Integer limit) throws Exception;

	int insert(Img img) throws Exception;

	int update(Img img) throws Exception;

	int delete(Long id) throws Exception;

	Img getByPlace(String place) throws Exception;

    List<Img> listAllImageForMain();

}

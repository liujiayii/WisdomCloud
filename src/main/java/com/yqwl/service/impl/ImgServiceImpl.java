package com.yqwl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yqwl.common.utils.UpdateFile;
import com.yqwl.dao.ImgMapper;
import com.yqwl.pojo.Group;
import com.yqwl.pojo.Img;
import com.yqwl.service.ImgService;

@Service("imgService")
@Transactional(rollbackFor = { Exception.class })
public class ImgServiceImpl implements ImgService {
	@Resource
	private ImgMapper ImgMapper;

	@Override
	public Img getById(Long id) throws Exception {
		return ImgMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> listAll(Integer page, Integer limit) throws Exception {
		Integer resultCount = ImgMapper.listAllCount();
		Integer beginPageIndex = ((page - 1) * limit);
		List<Img> result = ImgMapper.listAll(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", resultCount);
		map.put("list", result);
		return map;
	}

	@Override
	public int insert(Img img) throws Exception {
		return ImgMapper.insertSelective(img);
	}

	@Override
	public int update(Img img) throws Exception {
		return ImgMapper.updateByPrimaryKeySelective(img);
	}

	@Override
	public int delete(Long id) throws Exception {
		return ImgMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Img getByPlace(String place) throws Exception {
		return ImgMapper.getByPlace(place);
	}

    @Override
    public List<Img> listAllImageForMain() {
        return ImgMapper.listAllImageForMain();
    }

}

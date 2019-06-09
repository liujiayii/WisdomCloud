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
import com.yqwl.dao.GroupMapper;
import com.yqwl.pojo.Group;
import com.yqwl.service.GroupService;

@Service("groupService")
@Transactional(rollbackFor = { Exception.class })
public class GroupServiceImpl implements GroupService {

	@Resource
	private GroupMapper groupMapper;

	@Override
	public Group getById(Long id) throws Exception {
		return groupMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(Group group) throws Exception {
		group.setTime(new Date());
		return groupMapper.insertSelective(group);
	}

	@Override
	public int update(Group group) throws Exception {
		return groupMapper.updateByPrimaryKeySelective(group);
	}

	@Override
	public int delete(Long id) throws Exception {
		return groupMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> listAll(Integer page, Integer limit) throws Exception {
		Integer resultCount = groupMapper.listAllCount();
		Integer beginPageIndex = ((page - 1) * limit);
		List<Group> result = groupMapper.listAll(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", resultCount);
		map.put("list", result);
		return map;
	}

	@Override
	public List<Group> listByHomePage() throws Exception {
		return groupMapper.listByHomePage();
	}

	@Override
	public List<Group> listByGroupPage() throws Exception {
		
		return groupMapper.listByGroupPage();
	}

}

package com.yqwl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yqwl.dao.MessageMapper;
import com.yqwl.pojo.Message;
import com.yqwl.service.MessageService;

@Service("messageService")
@Transactional(rollbackFor = { Exception.class })
public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageMapper messageMapper;

	@Override
	public Map<String, Object> listAll(Integer page, Integer limit) throws Exception {
		Integer resultCount = messageMapper.listAllCount();
		Integer beginPageIndex = ((page - 1) * limit);
		List<Message> result = messageMapper.listAll(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", resultCount);
		map.put("list", result);
		return map;
	}

	@Override
	public int insert(Message message) throws Exception {
		return messageMapper.insertSelective(message);

	}

	@Override
	public int update(Message message) throws Exception {
		return messageMapper.updateByPrimaryKeySelective(message);

	}

	@Override
	public Message getById(Long id) throws Exception {
		return messageMapper.selectByPrimaryKey(id);

	}

	@Override
	public int listAllCount() throws Exception {
		return messageMapper.listAllCount();
		
		
	}
}

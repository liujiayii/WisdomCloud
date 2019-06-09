package com.yqwl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.yqwl.common.utils.UpdateFile;
import com.yqwl.dao.CaseMapper;
import com.yqwl.pojo.Case;
import com.yqwl.service.CaseService;

@Service("caseService")
@Transactional(rollbackFor = { Exception.class })
public class CaseServiceImpl implements CaseService {

	@Resource
	private CaseMapper caseMapper;

	/**
	 * 
	 * 
	 * @Title: CaseServiceImpl.java
	 * 
	 * @Package com.yqwl.service.impl
	 * 
	 * @Description: 插入案例数据
	 * 
	 * @author HanMeng
	 * 
	 * @date 2019年2月15日-下午2:09:01
	 */
	@Override
	public int insert(Case record) throws Exception {
		
		return caseMapper.insertSelective(record);

	}

	/**
	 * 
	 * 
	 * @Title: CaseServiceImpl.java
	 * 
	 * @Package com.yqwl.service.impl
	 * 
	 * @Description: 根据主键修改
	 * 
	 * @author HanMeng
	 * 
	 * @date 2019年2月15日-下午2:08:54
	 */
	@Override
	public int update(Case record) throws Exception {
		
		return caseMapper.updateByPrimaryKeySelective(record);

	}


	/**
	 * 
	 * 
	 * @Title: CaseServiceImpl.java
	 * 
	 * @Package com.yqwl.service.impl
	 * 
	 * @Description: 根据主键删除
	 * 
	 * @author HanMeng
	 * 
	 * @date 2019年2月15日-下午2:18:53
	 */
	@Override
	public int deleteByPrimaryKey(Long id) throws Exception {
		return caseMapper.deleteByPrimaryKey(id);

	}
	/**
	 * 
	
	  * @Title: CaseServiceImpl.java
	
	  * @Package com.yqwl.service.impl
	
	  * @Description: 根据主键查找
	
	  * @author HanMeng
	
	  * @date 2019年2月15日-下午6:02:05
	 */
	@Override
	public Case getById(Long id) throws Exception {
		return caseMapper.selectByPrimaryKey(id);
		
	}
	/**
	 * 
	
	  * @Title: CaseServiceImpl.java
	
	  * @Package com.yqwl.service.impl
	
	  * @Description: 查询所有
	
	  * @author HanMeng
	
	  * @date 2019年2月15日-下午6:02:34
	 */
	@Override
	public Map<String, Object> listAll(Integer page, Integer limit) throws Exception {
		Integer resultCount = caseMapper.listAllCount();
		Integer beginPageIndex = ((page - 1) * limit);
		List<Case> result = caseMapper.listAll(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", resultCount);
		map.put("list", result);
		return map;
	}
	/**
	 * 
	
	  * @Title: CaseServiceImpl.java
	
	  * @Package com.yqwl.service.impl
	
	  * @Description: 根据案例类型查询案例
	
	  * @author HanMeng
	
	  * @date 2019年2月18日-下午5:04:22
	 */
	@Override
	public List<Case> listByCaseType(String type) throws Exception {
		
		return caseMapper.listCaseByType(type);
		
		
	}

	

}

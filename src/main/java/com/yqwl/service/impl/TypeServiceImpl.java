package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yqwl.dao.TypeMapper;
import com.yqwl.pojo.Type;
import com.yqwl.service.TypeService;

/**
 *
 * @ClassName: TypeServiceImpl
 * @description 类型表的Service实现层
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class TypeServiceImpl implements TypeService {
	
	@Resource
	private TypeMapper typeMapper;

	/**
	 * @Title: listType
	 * @description (后台)分页查询所有的类型
	 * @param  page ,limit
	 * @return Map<String, Object>    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public Map<String, Object> listType(Integer page, Integer limit) throws Exception {
		// TODO Auto-generated method stub
		int typeCount = typeMapper.countType();
		int beginPageIndex = ((page - 1) * limit);
		List<Type> typeList = typeMapper.listType(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", typeCount);  //类型数量
		map.put("list", typeList);  //类型列表
		
		return map;
	}

	/**
	 * @Title: countType
	 * @description 所有类型的数量
	 * @return int 
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public int countType() throws Exception {
		// TODO Auto-generated method stub
		return typeMapper.countType();
	}

	/**
	 * @Title: saveType
	 * @description (后台)增加一条类型
	 * @param  type
	 * @return int  
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public int saveType(Type type) throws Exception {
		// TODO Auto-generated method stub
		return typeMapper.saveType(type);
	}

	/**
	 * @Title: removeType
	 * @description (后台)删除一条类型
	 * @param  id
	 * @return int  
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public int removeType(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		return typeMapper.removeType(id);
	}

	/**
	 * @Title: getTypeById
	 * @description (后台)通过id查询对应的类型
	 * @param  type
	 * @return int  
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public Type getTypeById(Type type) throws Exception {
		// TODO Auto-generated method stub
		return typeMapper.getTypeById(type);
	}

	/**
	 * @Title: showAllType
	 * @description (前台)显示所有的类型
	 * @return List<Type>  
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public List<Type> showAllType() throws Exception {
		// TODO Auto-generated method stub
		return typeMapper.showAllType();
	}

}

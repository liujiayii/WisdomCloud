package com.yqwl.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.yqwl.pojo.Type;

/**
 *
 * @ClassName: TypeService
 * @description 类型的查询，新增，删除等方法
 *
 * @author dujiawei
 * @createDate 2019年6月6日
 */
public interface TypeService {
	
	/**
	 * @Title: listType
	 * @description (后台)分页查询所有的类型
	 * @param @param page
	 * @param @param limit
	 * @param @throws Exception   
	 * @return Map<String,Object>    
	 *
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	Map<String, Object> listType(Integer page ,Integer limit) throws Exception;
    
	/**
	 * @Title: countType
	 * @description 所有类型的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int countType() throws Exception;
	
	/**
	 * @Title: saveType
	 * @description (后台)增加一条类型
	 * @param @param type
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int saveType(Type type) throws Exception;
	
	/**
	 * @Title: removeType
	 * @description (后台)删除一条类型
	 * @param @param id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int removeType(@Param("id") BigInteger id) throws Exception;
	
	/**
	 * @Title: getTypeById
	 * @description (后台)通过id查询对应的类型
	 * @param @param type
	 * @return Type    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public Type getTypeById(Type type) throws Exception;
	
	/**
	 * @Title: showAllType
	 * @description (前台)显示所有的类型
	 * @return List<Type>    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public List<Type> showAllType() throws Exception;

}

package com.yqwl.dao;

import java.math.BigInteger;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.yqwl.pojo.Type;

/**
 *
 * @ClassName: TypeMapper
 * @description 类型的查询，新增，删除等方法
 *
 * @author dujiawei
 * @createDate 2019年6月6日
 */
public interface TypeMapper {
	
	/**
	 * @Title: listType
	 * @description (后台)分页查询所有的类型
	 * @param @param beginPageIndex
	 * @param @param limit
	 * @return List<Type>    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	List<Type> listType(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
    
	/**
	 * @Title: countType
	 * @description 所有类型的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int countType();
	
	/**
	 * @Title: saveType
	 * @description (后台)增加一条类型
	 * @param @param type
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int saveType(Type type);
	
	/**
	 * @Title: removeType
	 * @description (后台)删除一条类型
	 * @param @param id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int removeType(@Param("id") BigInteger id);
	
	/**
	 * @Title: getTypeById
	 * @description (后台)通过id查询对应的类型
	 * @param @param type
	 * @return Type    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public Type getTypeById(Type type);
	
	/**
	 * @Title: showAllType
	 * @description (前台)显示所有的类型
	 * @return List<Type>    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public List<Type> showAllType();

}

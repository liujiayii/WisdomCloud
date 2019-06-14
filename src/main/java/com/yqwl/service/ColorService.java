package com.yqwl.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.yqwl.pojo.Color;

/**
 * 
 *
 * @ClassName: ColorService
 * @description 色系的查询，新增，删除等方法
 *
 * @author dujiawei
 * @createDate 2019年6月6日
 */
public interface ColorService {
	
	/**
	 * @Title: listColor
	 * @description (后台)分页查询所有的色系
	 * @param @param page
	 * @param @param limit
	 * @param @throws Exception   
	 * @return Map<String,Object>    
	 *
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	Map<String, Object> listColor(Integer page ,Integer limit) throws Exception;
    
	/**
	 * @Title: countColor
	 * @description 所有色系的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int countColor() throws Exception;
	
	/**
	 * @Title: saveColor
	 * @description (后台)增加一条色系
	 * @param @param color
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int saveColor(Color color) throws Exception;
	
	/**
	 * @Title: removeColor
	 * @description (后台)删除一条色系
	 * @param @param id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int removeColor(@Param("id") BigInteger id) throws Exception;
	
	/**
	 * @Title: getColorById
	 * @description (后台)通过id查询对应的色系
	 * @param @param color
	 * @return Wanted    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public Color getColorById(Color color) throws Exception;
	
	/**
	 * @Title: showAllColor
	 * @description (前台)显示所有的色系
	 * @return List<Color>    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public List<Color> showAllColor() throws Exception;

}

package com.yqwl.dao;

import java.math.BigInteger;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.yqwl.pojo.Color;

/**
 *
 * @ClassName: ColorMapper
 * @description 色系的查询，新增，删除等方法
 *
 * @author dujiawei
 * @createDate 2019年6月6日
 */
public interface ColorMapper {
	
	/**
	 * @Title: listColor
	 * @description (后台)分页查询所有的色系
	 * @param @param beginPageIndex
	 * @param @param limit
	 * @return List<Color>    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	List<Color> listColor(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
    
	/**
	 * @Title: countColor
	 * @description 所有色系的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int countColor();
	
	/**
	 * @Title: saveColor
	 * @description (后台)增加一条色系
	 * @param @param color
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int saveColor(Color color);
	
	/**
	 * @Title: removeColor
	 * @description (后台)删除一条色系
	 * @param @param id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public int removeColor(@Param("id") BigInteger id);
	
	/**
	 * @Title: getColorById
	 * @description (后台)通过id查询对应的色系
	 * @param @param color
	 * @return Color    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public Color getColorById(Color color);
	
	/**
	 * @Title: showAllColor
	 * @description (前台)显示所有的色系
	 * @return List<Color>    
	 * @author dujiawei
	 * @createDate 2019年6月6日
	 */
	public List<Color> showAllColor();

}

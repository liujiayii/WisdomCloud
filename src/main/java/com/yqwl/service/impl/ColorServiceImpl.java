package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yqwl.dao.ColorMapper;
import com.yqwl.pojo.Color;
import com.yqwl.service.ColorService;

/**
 *
 * @ClassName: ColorServiceImpl
 * @description 色系表的Service实现层
 *
 * @author dujiawei
 * @createDate 2019年6月6日
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class ColorServiceImpl implements ColorService {
	
	@Resource
	private ColorMapper colorMapper;

	/**
	 * @Title: listColor
	 * @description (后台)分页查询所有的色系
	 * @param  page ,limit
	 * @return Map<String, Object>    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public Map<String, Object> listColor(Integer page, Integer limit) throws Exception {
		// TODO Auto-generated method stub
		int colorCount = colorMapper.countColor();
		int beginPageIndex = ((page - 1) * limit);
		List<Color> colorList = colorMapper.listColor(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", colorCount);  //色系数量
		map.put("list", colorList);  //色系列表
		
		return map;
	}

	/**
	 * @Title: countColor
	 * @description 所有色系的数量
	 * @return int 
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public int countColor() throws Exception {
		// TODO Auto-generated method stub
		return colorMapper.countColor();
	}

	/**
	 * @Title: saveColor
	 * @description (后台)增加一条色系
	 * @param  color
	 * @return int  
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public int saveColor(Color color) throws Exception {
		// TODO Auto-generated method stub
		return colorMapper.saveColor(color);
	}

	/**
	 * @Title: removeColor
	 * @description (后台)删除一条色系
	 * @param  id
	 * @return int  
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public int removeColor(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		return colorMapper.removeColor(id);
	}

	/**
	 * @Title: getColorById
	 * @description (后台)通过id查询对应的色系
	 * @param  color
	 * @return int  
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public Color getColorById(Color color) throws Exception {
		// TODO Auto-generated method stub
		return colorMapper.getColorById(color);
	}

	/**
	 * @Title: showAllColor
	 * @description (前台)显示所有的色系
	 * @return List<Color>  
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月6日
	 */
	@Override
	public List<Color> showAllColor() throws Exception {
		// TODO Auto-generated method stub
		return colorMapper.showAllColor();
	}

}

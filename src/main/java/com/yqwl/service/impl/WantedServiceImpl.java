package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yqwl.dao.WantedMapper;
import com.yqwl.pojo.Wanted;
import com.yqwl.service.WantedService;
/**
 * 
 *
 * @ClassName: WantedServiceImpl
 * @description 招聘信息表的Service实现层
 *
 * @author dujiawei
 * @createDate 2019年3月28日
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class WantedServiceImpl implements WantedService {

	@Resource
	private WantedMapper wantedMapper;
	
	/**
	 * @Title: listWanted
	 * @description 招聘信息列表
	 * @param  page ,limit
	 * @return Map<String, Object>    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年3月28日
	 */
	@Override
	public Map<String, Object> listWanted(Integer page, Integer limit) throws Exception {
		// TODO Auto-generated method stub
		int resultCount = wantedMapper.countWanted();
		int beginPageIndex = ((page - 1) * limit);
		List<Wanted> result = wantedMapper.listWanted(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", resultCount);  //数量
		map.put("list", result);
		
		return map;
	}

	/**
     * @Title: countWanted
     * @description 招聘信息的数据条数
     * @return int    
     * @author dujiawei
     * @createDate 2019年3月28日
     */
	@Override
	public int countWanted() throws Exception {
		// TODO Auto-generated method stub
		return wantedMapper.countWanted();
	}

	/**
	 * @Title: saveWanted
	 * @description 新增招聘信息
	 * @param  wanted
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@Override
	public int saveWanted(Wanted wanted) throws Exception {
		// TODO Auto-generated method stub
		return wantedMapper.saveWanted(wanted);
	}

	/**
	 * @Title: updateWanted
	 * @description 修改招聘信息
	 * @param  wanted
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@Override
	public int updateWanted(Wanted wanted) throws Exception {
		// TODO Auto-generated method stub
		return wantedMapper.updateWanted(wanted);
	}

	/**
	 * @Title: changeWantedState
	 * @description 修改招聘信息状态
	 * @param  wanted
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@Override
	public int changeWantedState(Wanted wanted) throws Exception {
		// TODO Auto-generated method stub
		return wantedMapper.changeWantedState(wanted);
	}

	/**
	 * @Title: removeWanted
	 * @description 删除招聘信息（硬删除）
	 * @param  id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@Override
	public int removeWanted(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		return wantedMapper.removeWanted(id);
	}

	/**
	 * @Title: getWantedById
	 * @description 通过id查询招聘信息
	 * @param  wanted
	 * @return Wanted    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@Override
	public Wanted getWantedById(Wanted wanted) {
		// TODO Auto-generated method stub
		return wantedMapper.getWantedById(wanted);
	}

	/**
	 * @Title: showListWanted
	 * @description 官网显示的招聘信息(状态为上架的)
	 * @return List<Wanted>    
	 * @author dujiawei
	 * @createDate 2019年3月28日
	 */
	@Override
	public List<Wanted> showListWanted() {
		// TODO Auto-generated method stub
		return wantedMapper.showListWanted();
	}

	/**
	 * @Title: getWantedByjob
	 * @description 通过职位名称查询招聘信息
	 * @param  wanted
	 * @return List<Wanted>   
	 * @author dujiawei
	 * @createDate 2019年3月29日
	 */
	@Override
	public List<Wanted> getWantedByjob(Wanted wanted) {
		// TODO Auto-generated method stub
		return wantedMapper.getWantedByjob(wanted);
	}

}

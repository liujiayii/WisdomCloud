package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yqwl.dao.WelfareMapper;
import com.yqwl.pojo.Welfare;
import com.yqwl.service.WelfareService;

/**
 * 
 *
 * @ClassName: WelfareServiceImpl
 * @description 公司福利表的Service实现层
 *
 * @author dujiawei
 * @createDate 2019年3月28日
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class WelfareServiceImpl implements WelfareService {

	@Resource
	private WelfareMapper welfareMapper;
	
	@Override
	public Map<String, Object> listWelfare(Integer page, Integer limit) throws Exception {
		// TODO Auto-generated method stub
		int resultCount = welfareMapper.countWelfare();
		int beginPageIndex = ((page - 1) * limit);
		List<Welfare> result = welfareMapper.listWelfare(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", resultCount);  //数量
		map.put("list", result);
		
		return map;
	}

	@Override
	public int countWelfare() throws Exception {
		// TODO Auto-generated method stub
		return welfareMapper.countWelfare();
	}

	@Override
	public int saveWelfare(Welfare welfare) throws Exception {
		// TODO Auto-generated method stub
		return welfareMapper.saveWelfare(welfare);
	}

	@Override
	public int updateWelfare(Welfare welfare) throws Exception {
		// TODO Auto-generated method stub
		return welfareMapper.updateWelfare(welfare);
	}

	@Override
	public int changeWelfareState(Welfare welfare) throws Exception {
		// TODO Auto-generated method stub
		return welfareMapper.changeWelfareState(welfare);
	}

	@Override
	public int removeWelfare(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		return welfareMapper.removeWelfare(id);
	}

	@Override
	public Welfare getWelfareById(Welfare welfare) throws Exception {
		// TODO Auto-generated method stub
		return welfareMapper.getWelfareById(welfare);
	}

	@Override
	public List<Welfare> showListWelfare() throws Exception {
		// TODO Auto-generated method stub
		return welfareMapper.showListWelfare();
	}

}

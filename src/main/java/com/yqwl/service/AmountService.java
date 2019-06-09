package com.yqwl.service;

import java.util.List;
import java.util.Map;

import com.yqwl.vo.StatisticsVo;
import com.yqwl.vo.TotalVo;

public interface AmountService {

	int addVisit(String ip) throws Exception;

	TotalVo total() throws Exception;

	Map<String, Object> listAllByDate(int dateType) throws Exception;

	List<StatisticsVo> statistics() throws Exception;

}

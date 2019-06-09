package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yqwl.dao.InformationMapper;
import com.yqwl.pojo.Information;
import com.yqwl.service.InformationService;
@Service
public class InformationServiceImpl implements InformationService {
	@Resource
	private InformationMapper informationMapper;
	@Override
	public Information getInformationById(BigInteger informationId) {
		
		return informationMapper.getInformationById(informationId);
	}

	@Override
	public Integer updateInformation(Information information) {
		
		return informationMapper.updateInformation(information);
	}

	@Override
	public Integer insertInformation(Information information) {
		
		return informationMapper.insertInformation(information);
	}

	@Override
	public Integer delInformation(BigInteger informationId) {
		
		return informationMapper.delInformation(informationId);
	}

	@Override
	public List<Information> getInformation() {
		
		return informationMapper.getInformation();
	}

}

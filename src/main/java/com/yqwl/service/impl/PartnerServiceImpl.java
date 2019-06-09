package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yqwl.dao.PartnerMapper;
import com.yqwl.pojo.Partner;
import com.yqwl.service.PartnerService;
@Service
public class PartnerServiceImpl implements PartnerService {

	@Resource
	private PartnerMapper partnerMapper;
	@Override
	public Map<String,Object> listPartner(Integer page, Integer limit) {
		Map<String,Object> map = new HashMap<>();
		if(page != null && !page.equals("")) {
			Integer count = partnerMapper.getAllPartnerCount();
			Integer beginPageIndex = ((page - 1) * limit);
			List<Partner> listPartner = partnerMapper.listPartner(beginPageIndex,limit);
			map.put("count", count);
			map.put("listPartner", listPartner);
		} else {
			List<Partner> listPartner = partnerMapper.listPartner(page,limit);
			map.put("listPartner", listPartner);
		}
		
		
		return map;
	}

	@Override
	public Map<String,Object> insertPartner(Partner partner) {
		
		Map<String,Object> map = new HashMap<>();
		//判重
		Partner p = partnerMapper.getPartnerByName(partner);
		if(p!=null && !p.equals("")){
			map.put("code", 0);
			map.put("msg", "添加失败，合作伙伴重复");
		}else{
			partnerMapper.insertPartner(partner);
			map.put("code", 1);
			map.put("msg", "添加成功");
		}
		return map;
	}

	@Override
	public Map<String,Object> updatePartner(Partner partner) {
		Map<String,Object> map = new HashMap<>();
		System.out.println(partner);
		//判重
		Partner p = partnerMapper.getPartnerByName(partner);
		if(p!=null && !p.equals("")){
			map.put("code", 0);
			map.put("msg", "添加失败，合作伙伴重复");
		}else{
			partnerMapper.updatePartner(partner);
			map.put("code", 1);
			map.put("msg", "添加成功");
		}
		return map;
	}

	@Override
	public Integer deletePartner(BigInteger partnerId) {
		
		return partnerMapper.deletePartner(partnerId);
	}

	@Override
	public Partner getPartnerByName(Partner partner) {
		
		return partnerMapper.getPartnerByName(partner);
	}

	@Override
	public Partner getPartnerById(Partner partner) {
		
		return partnerMapper.getPartnerById(partner);
	}

}

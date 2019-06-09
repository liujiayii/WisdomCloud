package com.yqwl.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.pojo.Partner;
import com.yqwl.pojo.User;
import com.yqwl.service.PartnerService;

@Controller
@RequestMapping("/partner")
@Scope("prototype")
public class PartnerController {
	@Resource
	private PartnerService partnerService;
	
	@RequestMapping("/list")
	public String list(){
		
		return "views/back/PartnerManagement/PartnerManagement";
	}
	@RequestMapping("/listAll")
	@ResponseBody
	public Map<String,Object> listPartner(Integer page,Integer limit){
		Map<String,Object> map= partnerService.listPartner(page, limit);
		map.put("code", 1);
		map.put("msg", "成功");
		return map;
	}
	@RequestMapping("/add")
	public String savePartner(){
		return "views/back/PartnerManagement/addPartnerManagement";
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Map<String,Object> insertPartner(@RequestBody Partner partner,HttpSession session){
		User admin = (User) session.getAttribute("login_user");
		if(admin!=null && !admin.equals("")){
			Map<String,Object> map = partnerService.insertPartner(partner);
			return map;
		}else{
			Map<String,Object> map = new HashMap<>();
			map.put("code", 0);
			map.put("msg", "您还没有登陆");
			return map;
		}
		
		
	}
	@RequestMapping("/create")
	public String createPartner(Partner partner,Model model){
		Partner p = partnerService.getPartnerById(partner);
		model.addAttribute("partner", p);
		return "views/back/PartnerManagement/updatePartnerManagement";
	}
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> updatePartner(@RequestBody Partner partner,HttpSession session){
		User admin = (User) session.getAttribute("login_user");
		if(admin!=null && !admin.equals("")){
			Map<String,Object> map = partnerService.updatePartner(partner);
			return map;
		}else{
			Map<String,Object> map = new HashMap<>();
			map.put("code", 0);
			map.put("msg", "您还没有登陆");
			return map;
		}
	
		
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> deletePartner(BigInteger partnerId,HttpSession session){
		System.out.println(partnerId);
		Map<String,Object> map = new HashMap<>();
		
		User admin = (User) session.getAttribute("login_user");
		if(admin != null && !admin.equals("")){
			Integer row = partnerService.deletePartner(partnerId);
			if(row == 0){
				map.put("code", 0);
				map.put("msg", "删除失败，请联系管理员");
			}else{
				map.put("code", 1);
				map.put("msg", "删除成功");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "您还没有登陆");
		}
		
		
		return map;
	}
}

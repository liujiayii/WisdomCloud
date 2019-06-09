package com.yqwl.controller;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.pojo.Information;
import com.yqwl.pojo.User;
import com.yqwl.service.InformationService;

@Controller
@RequestMapping("/information")
public class InformationController {
	@Autowired
	private InformationService informationService;
	@RequestMapping("/list")
	public String listInformation(Model model){
		List<Information> information = informationService.getInformation();
		model.addAttribute("information", information);
		return "views/back/PlatformManagement/updatePlatformManagement";
	}
	/*@RequestMapping("/listAll")
	@ResponseBody
	public Map<String,Object> showListInformation(){
		Map<String,Object> map = new HashMap<>();
		try {
			List<Information> information = informationService.getInformation();
			map.put("code", 1);
			map.put("msg", "成功");
			map.put("data", information);
		} catch (Exception e) {
			map.put("code", 0);
			map.put("msg", "失败");
		}
		
		return map;
		
	}*/
	/*@RequestMapping("/add")
	public String showAddInformation(){
		return "";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Map<String,Object> addInformation(HttpSession session,@RequestBody Information information){
		Map<String,Object> map = new HashMap<>();
		User admin = (User) session.getAttribute("login_user");
		if(admin!=null && !admin.equals("")){
			Integer row = informationService.insertInformation(information);
			if(row>0){
				map.put("code", 1);
				map.put("msg", "添加成功");
			}else{
				map.put("code", 0);
				map.put("msg", "未知错误，请联系管理员");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "您还没有登陆");
			
		}
		return map;
	}*/
	/*@RequestMapping("/create")
	public String showUpdateInformation(BigInteger informationId,Model model){
		Information i = informationService.getInformationById(informationId);
		model.addAttribute("information", i);
		return "views/back/PlatformManagement/updatePlatformManagement";
	}
	*/
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> updateInformation(@RequestBody Information information,HttpSession session){
		//System.out.println(information);
		Map<String,Object> map = new HashMap<>();
		User admin = (User) session.getAttribute("login_user");
		if(admin!=null && !admin.equals("")){
			Integer row = informationService.updateInformation(information);
			if(row>0){
				map.put("code", 1);
				map.put("msg", "修改成功");
			}else{
				map.put("code", 0);
				map.put("msg", "未知错误，请联系管理员");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "您还没有登陆");
			
		}
		
		return map;
	}
	/*@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delInformation(BigInteger informationId,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		User admin = (User) session.getAttribute("login_user");
		if(admin!=null && !admin.equals("")){
			Integer row = informationService.delInformation(informationId);
			if(row>0){
				map.put("code", 1);
				map.put("msg", "删除成功");
			}else{
				map.put("code", 0);
				map.put("msg", "未知错误，请联系管理员");
			}
		}else{
			map.put("code", 0);
			map.put("msg", "您还没有登陆");
			
		}
		
		return map;
	}*/
}

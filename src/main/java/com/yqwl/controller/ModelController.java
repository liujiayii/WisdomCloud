package com.yqwl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Color;
import com.yqwl.pojo.Trade;
import com.yqwl.pojo.Type;
import com.yqwl.pojo.User;
import com.yqwl.service.ColorService;
import com.yqwl.service.ModelService;
import com.yqwl.service.TradeService;
import com.yqwl.service.TypeService;
import com.yqwl.vo.ModelAndBannerVo;
import net.sf.json.JSONArray;

/**
 *
 * @ClassName: ModelController
 * @description 
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
@Controller
@RequestMapping("model")
@Scope("prototype")
public class ModelController {
	
	@Resource
	private ModelService modelService;
	@Resource
	private ColorService colorService;
	@Resource
	private TradeService tradeService;
	@Resource
	private TypeService typeService;
	
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @Title: TZlistModel
	 * @description 跳转模版列表页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String TZlistModel() {
		
		return "views/back/mould/mould";
	}
	
	/**
	 * @Title: listModel
	 * @description (后台)分页查询所有的模版
	 * @param @param page
	 * @param @param limit
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "listModel", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listModel(Integer page, Integer limit) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> models = modelService.listModel(page, limit);
			if (models.size() != 0) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, models);
			}
			code = 1;
			msg = "查询失败";
			
			return FastJsonUtil.getResponseJson(code, msg, null);
			
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	/**
	 * @Title: add
	 * @description 跳转到新增模版页面
	 * @return String    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月9日
	 */
	@RequestMapping("/add")
	public String TZsaveModel(Model model) throws Exception {
		List<Color> allColor = colorService.showAllColor(); //所有的色系
		List<Trade> allTrade = tradeService.showAllTrade(); //所有的行业
		List<Type> allType = typeService.showAllType(); //所有的分类
		model.addAttribute("allColor",allColor);
		model.addAttribute("allTrade",allTrade);
		model.addAttribute("allType",allType);
		
		return "views/back/mould/addMould";
	}
	
	/**
	 * @Title: saveModel
	 * @description (后台)增加一条模版
	 * @param @param modelAndBannerVo
	 * @param @param session
	 * @return String    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "saveModel", method = RequestMethod.POST)
	public String saveModel(@RequestBody ModelAndBannerVo modelAndBannerVo, HttpSession session) throws Exception {
		int code = 0;
		String msg = null;
		List<ModelAndBannerVo> allModel = modelService.showAllModel();  //查询所有的模版
		if(allModel.size() > 0) {
			for(int i = 0; i < allModel.size(); i++) {
				if(allModel.get(i).getModelName().equals(modelAndBannerVo.getModelName())){  //判断新增的模版名称是否已存在
					code = 1;
					msg = "该模版名称已存在，新增模版失败";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
			}
			
		}
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = modelService.saveModel(modelAndBannerVo);
				if (num != 0) {
					code = 0;
					msg = "新增模版成功";
					
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "该模版名称已存在，新增模版失败";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			} else {
				code = 2;
				msg = "您没有登录账号！";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	/**
	 * @Title: TZupdateModel
	 * @description 跳转到修改模版信息页面
	 * @param @param model
	 * @param @param modelAndBannerVo
	 * @param @throws Exception   
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月12日
	 */
	@RequestMapping("/TZupdateModel")
	public String TZupdateModel(Model model ,ModelAndBannerVo modelAndBannerVo) throws Exception {
		ModelAndBannerVo w = modelService.getModelById(modelAndBannerVo);  //传过去的信息
		List<Color> allColor = colorService.showAllColor(); //所有的色系
		List<Trade> allTrade = tradeService.showAllTrade(); //所有的行业
		List<Type> allType = typeService.showAllType(); //所有的分类
		model.addAttribute("allColor",allColor);
		model.addAttribute("allTrade",allTrade);
		model.addAttribute("allType",allType);
		model.addAttribute("model",w);
		
		return "views/back/mould/updateMould";
	}
	
	
	/**
	 * @Title: getModelById
	 * @description 通过id查询对应的模版信息
	 * @param  model, modelAndBannerVo
	 * @return String    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping("/getModelById")
	public String getModelById(Model model ,ModelAndBannerVo modelAndBannerVo) throws Exception {
		int code = 0;
		String msg = null;
		try {
			ModelAndBannerVo models = modelService.getModelById(modelAndBannerVo);
			if (models != null) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, models);
			}
			code = 1;
			msg = "查询失败";
			
			return FastJsonUtil.getResponseJson(code, msg, null);
			
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	/**
	 *
	 * @Title: TZbannerImg
	 * @description 跳转轮播图页面
	 * @param @throws Exception   
	 * @author dujiawei
	 * @createDate 2019年6月12日
	 */
	@RequestMapping("/TZbannerImg")
	public String TZbannerImg() throws Exception {
		
		return "views/back/mould/updateSlide";
	}
	
	/**
	 * @Title: updateModel
	 * @description (后台)修改一条模版
	 * @param @param modelAndBannerVo
	 * @param @param session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "updateModel", method = RequestMethod.POST)
	public String updateModel(@RequestBody ModelAndBannerVo modelAndBannerVo, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = modelService.updateModel(modelAndBannerVo);
				if (i != 0) {
					code = 0;
					msg = "修改模版信息成功";
					
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "修改模版信息失败";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			} else {
				code = 2;
				msg = "未登录";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	/**
	 * @Title: removeModel
	 * @description (后台)删除一条模版（上下架）
	 * @param @param modelAndBannerVo
	 * @param @param session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月10日
	 */
	@ResponseBody
	@RequestMapping(value = "removeModel", method = RequestMethod.POST)
	public String removeModel(@RequestBody ModelAndBannerVo modelAndBannerVo, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = modelService.removeModel(modelAndBannerVo);
				if (i != 0) {
					code = 0;
					msg = "修改模版状态成功";
					
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "修改模版状态失败";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			} else {
				code = 2;
				msg = "未登录";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	/**
	 * @Title: listModelByOption
	 * @description 根据筛选条件查询对应的模版
	 * @param @param page
	 * @param @param limit
	 * @param @param modelAndBannerVo
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "listModelByOption", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listModelByOption(Integer page, Integer limit, ModelAndBannerVo modelAndBannerVo) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> models = modelService.listModelByOption(page, limit, modelAndBannerVo);
			if (models.size() != 0) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, models);
			}
			code = 1;
			msg = "查询失败";
			
			return FastJsonUtil.getResponseJson(code, msg, null);
			
		} catch (Exception e) {
			code = -1;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	
	/**
	 * @Title: showAllModel
	 * @description (前台)显示所有的模版（无分页）
	 * @param @throws Exception   
	 * @return Object    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "showAllModel", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public Object showAllModel() throws Exception {
		List<ModelAndBannerVo> modelList = modelService.showAllModel();
		
		Map<String , Object> result = new HashMap<String , Object>();		
		result.put("code", 0);
		result.put("msg", "Success");
		JSONArray array = JSONArray.fromObject(modelList);
		result.put("data", array);
		
		return result;
	}

}

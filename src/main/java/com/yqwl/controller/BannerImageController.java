package com.yqwl.controller;

import java.math.BigInteger;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.BannerImage;
import com.yqwl.pojo.User;
import com.yqwl.service.BannerImageService;
import net.sf.json.JSONArray;


/**
 *
 * @ClassName: BannerImageController
 * @description 模版轮播图的控制层
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
@Controller
@RequestMapping("bannerImage")
@Scope("prototype")
public class BannerImageController {
	
	@Resource
	private BannerImageService bannerImageService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @Title: TZlistBannerImage
	 * @description 跳转轮播图列表页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String TZlistBannerImage() {
		
		return "views/back/BannerImageManagement/BannerImageShowed";
	}
	
	/**
	 * @Title: listBannerImage
	 * @description (后台)分页查询所有的轮播图
	 * @param @param page, limit
	 * @return String    
	 *
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "listBannerImage", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listBannerImage(Integer page, Integer limit) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> bannerImages = bannerImageService.listBannerImage(page, limit);
			if (bannerImages.size() != 0) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, bannerImages);
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
	 * @description 跳转到新增轮播图页面
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@RequestMapping("/add")
	public String TZsaveBannerImage() {
		
		return "views/back/BannerImageManagement/addBannerImage";
	}
	
	/**
	 * @Title: saveBannerImage
	 * @description 增加一个轮播图
	 * @param @param bannerImage, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "saveBannerImage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String saveBannerImage(BannerImage bannerImage, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = bannerImageService.saveBannerImage(bannerImage);
				if (num != 0) {
					code = 0;
					msg = "新增轮播图成功";
					
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "该轮播图已存在，新增轮播图失败";
				
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
	 * @Title: removeBannerImage
	 * @description (后台)删除一条轮播图
	 * @param @param id, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "removeBannerImage", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String removeBannerImage(BigInteger id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = bannerImageService.removeBannerImage(id);
				if (num != 0) {
					code = 0;
					msg = "删除轮播图成功";
					
					return FastJsonUtil.getResponseJson(code, msg, num);
				}
				code = 1;
				msg = "删除轮播图失败";
				
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
	 *
	 * @Title: getBannerImageById
	 * @description 通过id查询对应的轮播图信息
	 * @param @param model
	 * @param @param bannerImage
	 * @param @throws Exception   
	 * @return String    
	 *
	 * @author dujiawei
	 * @createDate 2019年6月12日
	 */
	@ResponseBody
	@RequestMapping("/getBannerImageById")
	public String getBannerImageById(Model model ,BannerImage bannerImage) throws Exception {
		int code = 0;
		String msg = null;
		try {
			BannerImage images = bannerImageService.getBannerImageById(bannerImage);
			if (images != null) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, images);
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
	 * @Title: removeBannerImage
	 * @description (后台)修改一条轮播图
	 * @param @param bannerImage, session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "updateBannerImage", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String updateBannerImage(BannerImage bannerImage, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int num = bannerImageService.updateBannerImage(bannerImage);
				if (num != 0) {
					code = 0;
					msg = "修改轮播图成功";
					
					return FastJsonUtil.getResponseJson(code, msg, num);
				}
				code = 1;
				msg = "修改轮播图失败";
				
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
	 * @Title: showAllBannerImage
	 * @description (前台)显示所有的轮播图
	 * @return Object    
	 * @author dujiawei
	 * @throws Exception 
	 * @createDate 2019年6月9日
	 */
	@ResponseBody
	@RequestMapping(value = "showAllBannerImage", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public Object showAllBannerImage() throws Exception {
		List<BannerImage> bannerImageList = bannerImageService.showAllBannerImage();
		
		Map<String , Object> result = new HashMap<String , Object>();		
		result.put("code", 0);
		result.put("msg", "Success");
		JSONArray array = JSONArray.fromObject(bannerImageList);
		result.put("data", array);
		
		return result;
	}
	
	/**
	 * @Title: listBannerImageByModelId
	 * @description 根据模版id查询对应的轮播图
	 * @param @param bannerImage
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月10日
	 */
	@ResponseBody
	@RequestMapping(value = "listBannerImageByModelId", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listBannerImageByModelId(BannerImage bannerImage) {
		int code = 0;
		String msg = null;
		try {
			Map<String, Object> bannerImages = bannerImageService.listBannerImageByModelId(bannerImage);
			if (bannerImages.size() != 0) {
				code = 0;
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, bannerImages);
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

}

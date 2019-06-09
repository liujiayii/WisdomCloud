package com.yqwl.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.News;
import com.yqwl.pojo.NewsImg;
import com.yqwl.pojo.User;
import com.yqwl.service.NewsService;

@Controller
@RequestMapping("news")
@Scope("prototype")
public class NewsController {
	@Resource
	private NewsService newsService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String list() {
		
		return "views/back/NewsManagement/CompanyManagement";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String add() {
		return "views/back/NewsManagement/addNewsManagement";
	}
	/**
	 * 
	 * @Title: addNews
	 * @description: 插入新闻咨讯
	 *
	 * @param news
	 * @param session
	 * @return    
	 * @return String   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午3:56:16
	 */
	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String addNews(@RequestBody News news, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
			    
			    int i = newsService.insert(news);
				if (i != 0) {
					code = 0;
					msg = "新增咨讯成功";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "新增咨讯失败";
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
	 * 
	 * @Title: addGoodsImg
	 * @description: 添加新闻咨讯图片
	 *
	 * @param file
	 * @param id
	 * @param session
	 * @return    
	 * @return String   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午3:56:34
	 */
	@ResponseBody
	@RequestMapping(value = "addNewsImg", method = RequestMethod.POST)
	public String addNewsImg(@RequestBody NewsImg newsImg,  HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = newsService.addNewsImg(newsImg);
				if (i != 0) {
					code = 0;
					msg = "新增成功";
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "新增失败";
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
	 * @Title: deleteNewsImg
	 * @description: 删除咨讯图片
	 *
	 * @param id
	 * @param session
	 * @return    
	 * @return String   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午3:58:36
	 */
	@ResponseBody
	@RequestMapping(value = "deleteNewsImg", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String deleteNewsImg(Long id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = newsService.deleteNewsImg(id);
				if (i != 0) {
					code = 0;
					msg = "删除成功";
					return FastJsonUtil.getResponseJson(code, msg, null);
				}
				code = 1;
				msg = "删除失败";
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
	 * @Title: updates
	 * @description 用一句话描述这个方法的作用
	 *
	 * @param @return   
	 * @return String    
	 *
	 * @author 姓名全拼
	 * @createDate 2019年4月15日
	 */
	@RequestMapping(value = "updates", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
    public String update(Long id,Model model) {
	    try {
            News news = newsService.getById(id);
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
            String str = sdf.format(news.getTime());
            model.addAttribute("time", str);
            model.addAttribute("news", news);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "views/back/NewsManagement/updateNewsManagement";
    }

	/**
	 * 
	 * @Title: update
	 * @description: 修改咨讯
	 *
	 * @param news
	 * @param session
	 * @return    
	 * @return String   
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-下午3:58:49
	 */
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(@RequestBody News news, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = newsService.update(news);
				if (i != 0) {
					code = 0;
					msg = "修改案例成功";
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "修改案例失败";
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
     * @Title: updates
     * @description: 修改咨讯
     *
     * @param news
     * @param session
     * @return    
     * @return String   
     *
     * @author HanMeng
     * @createDate 2019年2月18日-下午3:58:49
     */
    @ResponseBody
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    public String updateStatus(@RequestBody News news, HttpSession session) {
        int code = 0;
        String msg = null;
        try {
            User admin = (User) session.getAttribute("login_user");
            if (admin != null) {
                int i = newsService.updateStatus(news);
                if (i != 0) {
                    code = 0;
                    msg = "修改案例成功";
                    return FastJsonUtil.getResponseJson(code, msg, i);
                }
                code = 1;
                msg = "修改案例失败";
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
	 * @Title: delete
	 * @description: 根据主键删除咨讯
	 *
	 * @param id
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月17日-下午1:25:50
	 */
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String update(Long id, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User admin = (User) session.getAttribute("login_user");
			if (admin != null) {
				int i = newsService.deleteByPrimaryKey(id);
				if (i != 0) {
					code = 0;
					msg = "删除咨讯成功";
					return FastJsonUtil.getResponseJson(code, msg, i);
				}
				code = 1;
				msg = "删除咨讯失败";
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
	 * @Title: getById
	 * @description: 根据id查询咨讯
	 *
	 * @param id
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月17日-下午1:34:05
	 */
	@ResponseBody
	@RequestMapping(value = "getById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getById(Long id) {
		int code = 0;
		String msg = null;
		try {
			
				News news = newsService.getById(id);
				System.out.println(news);
				if (news != null) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, news);
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
	 * @Title: listAll
	 * @description: 分页查询所有咨讯
	 *
	 * @param page
	 * @param limit
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午10:09:18
	 */
	@ResponseBody
	@RequestMapping(value = "listAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAll(Integer page, Integer limit) {
		int code = 0;
		String msg = null;
		try {
		
				Map<String, Object> news = newsService.listAll(page, limit);
				if (news.size() != 0) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, news);
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
	 * @Title: listAll
	 * @description: 分页查询所有咨讯
	 *
	 * @param page
	 * @param limit
	 * @param session
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年2月18日-上午10:09:18
	 */
	@ResponseBody
	@RequestMapping(value = "listMovement", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getBusinessMovement(Integer page, Integer limit) {
		int code = 0;
		String msg = null;
		try {
		
				Map<String, Object> news = newsService.getBusinessMovement("企业动态", page, limit);
				//System.out.println(news.get("list"));
				if (news.size() != 0) {
					code = 0;
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, news);
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

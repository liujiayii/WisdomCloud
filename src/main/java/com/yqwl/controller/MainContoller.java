package com.yqwl.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.UpdateFile;
import com.yqwl.dao.WantedMapper;
import com.yqwl.dao.WelfareMapper;
import com.yqwl.pojo.Img;
import com.yqwl.pojo.Information;
import com.yqwl.pojo.News;
import com.yqwl.pojo.Text;
import com.yqwl.pojo.User;
import com.yqwl.pojo.Wanted;
import com.yqwl.pojo.Welfare;
import com.yqwl.service.ImgService;
import com.yqwl.service.InformationService;
import com.yqwl.service.NewsService;
import com.yqwl.service.PartnerService;
import com.yqwl.service.TextService;

@Controller
@RequestMapping("main")
@Scope("prototype")
public class MainContoller {

	@Autowired
	private TextService textService;
	@Autowired
	private InformationService informationService;
	@Resource
	private PartnerService partnerService;

	@Resource
	private NewsService newService; // 新闻咨询方法层

	@Autowired
	private ImgService imgService;

	@Resource
	private WelfareMapper welfareMapper;
	@Resource
	private WantedMapper wantedMapper;

	// 关于我们
	@RequestMapping(value = "about", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String about(Model model) {
		/*
		 * List<Text> listAllText = textService.listAllTextForMain(); if
		 * (listAllText.size()>0) { for (int i = 0; i < listAllText.size(); i++) { Text
		 * text = listAllText.get(i); if (text.getTextNumber()==1030)
		 * {model.addAttribute("s1030",text.getTextInfo());} if
		 * (text.getTextNumber()==1031)
		 * {model.addAttribute("s1031",text.getTextInfo());} if
		 * (text.getTextNumber()==1032)
		 * {model.addAttribute("s1032",text.getTextInfo());} } }
		 */
		return "views/front/about/about";
	}
	
	// 模版
	@RequestMapping(value = "model", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String model() {
		return "views/front/mould/mould";
	}

	// 案例
	@RequestMapping("mould")
	public String mould() {
		System.out.println("123");
		return "views/front/mould/mould";
	}

	// 优势
	@RequestMapping(value = "advantage", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String advantage() {
		return "views/front/advantage/advantage";
	}

	// 联系我们
	@RequestMapping(value = "contactUs", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String contactUs() {

		return "views/front/contactUs/contactUs";
	}

	// 招聘
	@RequestMapping(value = "employeePage")
	public String employeePage(Model model) {
		List<Wanted> wantedList = wantedMapper.listWanted(0, 100);
		model.addAttribute("wantedList", wantedList);
		List<Welfare> result = welfareMapper.listWelfare(0, 20);
		model.addAttribute("welfareList", result);
		return "views/front/recruit/recruit";
	}

	// 主页
	@RequestMapping(value = "index", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String index(Model model, HttpSession session) {
		// 遍历图片管理信息
		List<Img> listImage = imgService.listAllImageForMain();
		if (listImage.size() > 0) {
			for (int i = 0; i < listImage.size(); i++) {
				Img img = listImage.get(i);
				if (img.getImageNumber() == 2001) {
					session.setAttribute("s2001", img.getImgUrl());
				}
				if (img.getImageNumber() == 2002) {
					session.setAttribute("s2002", img.getImgUrl());
				}
				if (img.getImageNumber() == 2003) {
					session.setAttribute("s2003", img.getImgUrl());
				}

				if (img.getImageNumber() == 2004) {
					session.setAttribute("s2004", img.getImgUrl());
				}
				if (img.getImageNumber() == 2005) {
					session.setAttribute("s2005", img.getImgUrl());
				}
				if (img.getImageNumber() == 2006) {
					session.setAttribute("s2006", img.getImgUrl());
				}
				if (img.getImageNumber() == 2007) {
					session.setAttribute("s2007", img.getImgUrl());
				}
				if (img.getImageNumber() == 2008) {
					session.setAttribute("s2008", img.getImgUrl());
				}

				if (img.getImageNumber() == 2009) {
					session.setAttribute("s2009", img.getImgUrl());
				}
				if (img.getImageNumber() == 2010) {
					session.setAttribute("s2010", img.getImgUrl());
				}
				if (img.getImageNumber() == 2011) {
					session.setAttribute("s2011", img.getImgUrl());
				}
				if (img.getImageNumber() == 2012) {
					session.setAttribute("s2012", img.getImgUrl());
				}

				if (img.getImageNumber() == 2013) {
					session.setAttribute("s2013", img.getImgUrl());
				}
				if (img.getImageNumber() == 2014) {
					session.setAttribute("s2014", img.getImgUrl());
				}
				if (img.getImageNumber() == 2015) {
					session.setAttribute("s2015", img.getImgUrl());
				}

				if (img.getImageNumber() == 2016) {
					session.setAttribute("s2016", img.getImgUrl());
				}
				if (img.getImageNumber() == 2017) {
					session.setAttribute("s2017", img.getImgUrl());
				}
				if (img.getImageNumber() == 2018) {
					session.setAttribute("s2018", img.getImgUrl());
				}

				if (img.getImageNumber() == 2019) {
					session.setAttribute("s2019", img.getImgUrl());
				}
				if (img.getImageNumber() == 2020) {
					session.setAttribute("s2020", img.getImgUrl());
				}

				if (img.getImageNumber() == 2021) {
					session.setAttribute("s2021", img.getImgUrl());
				}
				if (img.getImageNumber() == 2022) {
					session.setAttribute("s2022", img.getImgUrl());
				}
				if (img.getImageNumber() == 2023) {
					session.setAttribute("s2023", img.getImgUrl());
				}
				if (img.getImageNumber() == 2024) {
					session.setAttribute("s2024", img.getImgUrl());
				}
				if (img.getImageNumber() == 2025) {
					session.setAttribute("s2025", img.getImgUrl());
				}

				if (img.getImageNumber() == 2026) {
					session.setAttribute("s2026", img.getImgUrl());
				}
				if (img.getImageNumber() == 2027) {
					session.setAttribute("s2027", img.getImgUrl());
				}

				if (img.getImageNumber() == 2028) {
					session.setAttribute("s2028", img.getImgUrl());
				}
				if (img.getImageNumber() == 2029) {
					session.setAttribute("s2029", img.getImgUrl());
				}
				if (img.getImageNumber() == 2030) {
					session.setAttribute("s2030", img.getImgUrl());
				}
				if (img.getImageNumber() == 2031) {
					session.setAttribute("s2031", img.getImgUrl());
				}
				if (img.getImageNumber() == 2032) {
					session.setAttribute("s2032", img.getImgUrl());
				}

				if (img.getImageNumber() == 2033) {
					session.setAttribute("s2033", img.getImgUrl());
				}
				if (img.getImageNumber() == 2034) {
					session.setAttribute("s2034", img.getImgUrl());
				}
				if (img.getImageNumber() == 2035) {
					session.setAttribute("s2035", img.getImgUrl());
				}
				if (img.getImageNumber() == 2036) {
					session.setAttribute("s2036", img.getImgUrl());
				}
				if (img.getImageNumber() == 2037) {
					session.setAttribute("s2037", img.getImgUrl());
				}

				if (img.getImageNumber() == 2038) {
					session.setAttribute("s2038", img.getImgUrl());
				}

			}
		}

		// 遍历文字管理信息
		List<Text> listAllText = textService.listAllTextForMain();
		if (listAllText.size() > 0) {
			for (int i = 0; i < listAllText.size(); i++) {
				Text text = listAllText.get(i);
				if (text.getTextNumber() == 101) {
					session.setAttribute("s101", text.getTextInfo());
				}

				if (text.getTextNumber() == 1001) {
					session.setAttribute("s1001", text.getTextInfo());
				}
				if (text.getTextNumber() == 1002) {
					session.setAttribute("s1002", text.getTextInfo());
				}

				if (text.getTextNumber() == 1003) {
					session.setAttribute("s1003", text.getTextInfo());
				}
				if (text.getTextNumber() == 1004) {
					session.setAttribute("s1004", text.getTextInfo());
				}
				if (text.getTextNumber() == 1005) {
					session.setAttribute("s1005", text.getTextInfo());
				}
				if (text.getTextNumber() == 1006) {
					session.setAttribute("s1006", text.getTextInfo());
				}
				if (text.getTextNumber() == 1007) {
					session.setAttribute("s1007", text.getTextInfo());
				}
				if (text.getTextNumber() == 1008) {
					session.setAttribute("s1008", text.getTextInfo());
				}
				if (text.getTextNumber() == 1009) {
					session.setAttribute("s1009", text.getTextInfo());
				}
				if (text.getTextNumber() == 1010) {
					session.setAttribute("s1010", text.getTextInfo());
				}
				if (text.getTextNumber() == 1011) {
					session.setAttribute("s1011", text.getTextInfo());
				}
				if (text.getTextNumber() == 1012) {
					session.setAttribute("s1012", text.getTextInfo());
				}

				if (text.getTextNumber() == 1013) {
					session.setAttribute("s1013", text.getTextInfo());
				}
				if (text.getTextNumber() == 1014) {
					session.setAttribute("s1014", text.getTextInfo());
				}
				if (text.getTextNumber() == 1015) {
					session.setAttribute("s1015", text.getTextInfo());
				}
				if (text.getTextNumber() == 1016) {
					session.setAttribute("s1016", text.getTextInfo());
				}
				if (text.getTextNumber() == 1017) {
					session.setAttribute("s1017", text.getTextInfo());
				}
				if (text.getTextNumber() == 1018) {
					session.setAttribute("s1018", text.getTextInfo());
				}
				if (text.getTextNumber() == 1019) {
					session.setAttribute("s1019", text.getTextInfo());
				}
				if (text.getTextNumber() == 1020) {
					session.setAttribute("s1020", text.getTextInfo());
				}

				if (text.getTextNumber() == 1021) {
					session.setAttribute("s1021", text.getTextInfo());
				}
				if (text.getTextNumber() == 1022) {
					session.setAttribute("s1022", text.getTextInfo());
				}
				if (text.getTextNumber() == 1023) {
					session.setAttribute("s1023", text.getTextInfo());
				}
				if (text.getTextNumber() == 1024) {
					session.setAttribute("s1024", text.getTextInfo());
				}
				if (text.getTextNumber() == 1025) {
					session.setAttribute("s1025", text.getTextInfo());
				}
				if (text.getTextNumber() == 1026) {
					session.setAttribute("s1026", text.getTextInfo());
				}
				if (text.getTextNumber() == 1027) {
					session.setAttribute("s1027", text.getTextInfo());
				}
				if (text.getTextNumber() == 1028) {
					session.setAttribute("s1028", text.getTextInfo());
				}
				if (text.getTextNumber() == 1029) {
					session.setAttribute("s1029", text.getTextInfo());
				}

				if (text.getTextNumber() == 1030) {
					session.setAttribute("s1030", text.getTextInfo());
				}
				if (text.getTextNumber() == 1031) {
					session.setAttribute("s1031", text.getTextInfo());
				}
				if (text.getTextNumber() == 1032) {
					session.setAttribute("s1032", text.getTextInfo());
				}

				if (text.getTextNumber() == 1033) {
					session.setAttribute("s1033", text.getTextInfo());
				}

				if (text.getTextNumber() == 1034) {
					session.setAttribute("s1034", text.getTextInfo());
				}
				if (text.getTextNumber() == 1035) {
					session.setAttribute("s1035", text.getTextInfo());
				}
				if (text.getTextNumber() == 1036) {
					session.setAttribute("s1036", text.getTextInfo());
				}

				if (text.getTextNumber() == 1037) {
					session.setAttribute("s1037", text.getTextInfo());
				}
				if (text.getTextNumber() == 1038) {
					session.setAttribute("s1038", text.getTextInfo());
				}
				if (text.getTextNumber() == 1039) {
					session.setAttribute("s1039", text.getTextInfo());
				}
				if (text.getTextNumber() == 1040) {
					session.setAttribute("s1040", text.getTextInfo());
				}
				if (text.getTextNumber() == 1041) {
					session.setAttribute("s1041", text.getTextInfo());
				}
				if (text.getTextNumber() == 1042) {
					session.setAttribute("s1042", text.getTextInfo());
				}
				if (text.getTextNumber() == 1043) {
					session.setAttribute("s1043", text.getTextInfo());
				}
				if (text.getTextNumber() == 1044) {
					session.setAttribute("s1044", text.getTextInfo());
				}
				if (text.getTextNumber() == 1045) {
					session.setAttribute("s1045", text.getTextInfo());
				}
				if (text.getTextNumber() == 1046) {
					session.setAttribute("s1046", text.getTextInfo());
				}
				if (text.getTextNumber() == 1047) {
					session.setAttribute("s1047", text.getTextInfo());
				}
				if (text.getTextNumber() == 1048) {
					session.setAttribute("s1048", text.getTextInfo());
				}
				if (text.getTextNumber() == 1049) {
					session.setAttribute("s1049", text.getTextInfo());
				}
				if (text.getTextNumber() == 1050) {
					session.setAttribute("s1050", text.getTextInfo());
				}
			}
		}

		Map<String, Object> partners = partnerService.listPartner(null, null);
		List<Information> listInformation = informationService.getInformation();
		session.setAttribute("information", listInformation.get(0));

		model.addAttribute("listPartner", partners.get("listPartner"));

		return "views/front/index/index";
	}

	// 新闻咨讯
	@RequestMapping(value = "newsInfo", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String newsInfo(Model model, Long id) {
		try {
			News news = newService.getById(id);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str = sdf.format(news.getTime());
			model.addAttribute("time", str);
			model.addAttribute("news", news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "views/front/index/newsInfo";
	}

	// 企业动态
	@RequestMapping(value = "businessMovement", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String businessMovement(Model model, Long id) {
		try {
			News news = newService.getById(id);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str = sdf.format(news.getTime());
			model.addAttribute("time", str);
			model.addAttribute("news", news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "views/front/about/newsInfo";
	}

	// 团队
	@RequestMapping(value = "team", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String team() {
		return "views/front/team/team";
	}

	@RequestMapping(value = "footer", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String footer() {
		return "views/back/Inheritance/footer";
	}

	@RequestMapping(value = "nav", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String nav() {
		return "views/back/Inheritance/nav";
	}

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseBody
	@RequestMapping(value = "addImg", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String addImg(MultipartFile file, HttpServletRequest request, HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			User user = (User) session.getAttribute("login_user");
			if (user != null) {
				String url = UpdateFile.update(file);
				code = 0;
				msg = "上传成功";
				return FastJsonUtil.getResponseJson(code, msg, url);
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

}

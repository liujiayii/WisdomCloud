/**
 *
 * @Title: FreemarkController.java
 * @Package com.yqwl.controller
 * @Description: TODO)
 * @author zhoujiaxin
 * @date 2019年4月20日
 */

package com.yqwl.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.dao.NewsMapper;
import com.yqwl.dao.WantedMapper;
import com.yqwl.dao.WelfareMapper;
import com.yqwl.pojo.Img;
import com.yqwl.pojo.Information;
import com.yqwl.pojo.News;
import com.yqwl.pojo.Text;
import com.yqwl.pojo.Wanted;
import com.yqwl.pojo.Welfare;
import com.yqwl.service.ImgService;
import com.yqwl.service.InformationService;
import com.yqwl.service.NewsService;
import com.yqwl.service.PartnerService;
import com.yqwl.service.StaticPageService;
import com.yqwl.service.TextService;

/**
 * 
 * @Description 
 *    
 * @author zhoujiaxin  
 * @createDate 2019年4月20日  
 */
@Controller
public class FreemarkController {
    
    @Autowired
    private StaticPageService staticPageService;
    @Autowired
    private TextService textService;
    @Autowired
    private InformationService informationService;
    @Resource
    private PartnerService partnerService;
    @Resource
    private NewsService newService; //新闻咨询方法层
    @Autowired
    private ImgService imgService;
    @Resource
    private WelfareMapper welfareMapper;
    @Resource
    private WantedMapper wantedMapper;
    @Resource
    private NewsMapper newsMapper;
    
    /**
     * @Title: staticAllPage
     * @description 一键生成静态化页面
     * @param @return  
     * @return Map<String,Object>    
     * @author zhoujiaxin
     * @createDate 2019年4月20日
     */
    @ResponseBody
    @RequestMapping("/staticAllPage")
    public Map<String, Object> staticAllPage() {
        Map<String, Object> map = new HashMap<>();
        // 01、静态化首页
        // 遍历图片管理信息
        List<Img> listImage = imgService.listAllImageForMain();
        if (listImage.size()>0) {
            for (int i = 0; i < listImage.size(); i++) {
                Img img = listImage.get(i);
                if (img.getImageNumber()==2001) {map.put("s2001",img.getImgUrl());}
                if (img.getImageNumber()==2002) {map.put("s2002",img.getImgUrl());}
                if (img.getImageNumber()==2003) {map.put("s2003",img.getImgUrl());}
                                                 
                if (img.getImageNumber()==2004) {map.put("s2004",img.getImgUrl());}
                if (img.getImageNumber()==2005) {map.put("s2005",img.getImgUrl());}
                if (img.getImageNumber()==2006) {map.put("s2006",img.getImgUrl());}
                if (img.getImageNumber()==2007) {map.put("s2007",img.getImgUrl());}
                if (img.getImageNumber()==2008) {map.put("s2008",img.getImgUrl());}
                                                 
                if (img.getImageNumber()==2009) {map.put("s2009",img.getImgUrl());}
                if (img.getImageNumber()==2010) {map.put("s2010",img.getImgUrl());}
                if (img.getImageNumber()==2011) {map.put("s2011",img.getImgUrl());}
                if (img.getImageNumber()==2012) {map.put("s2012",img.getImgUrl());}
                                                 
                if (img.getImageNumber()==2013) {map.put("s2013",img.getImgUrl());}
                if (img.getImageNumber()==2014) {map.put("s2014",img.getImgUrl());}
                if (img.getImageNumber()==2015) {map.put("s2015",img.getImgUrl());}
                                                 
                
                if (img.getImageNumber()==2016) {map.put("s2016",img.getImgUrl());}
                if (img.getImageNumber()==2017) {map.put("s2017",img.getImgUrl());}
                if (img.getImageNumber()==2018) {map.put("s2018",img.getImgUrl());}
                                                 
                if (img.getImageNumber()==2019) {map.put("s2019",img.getImgUrl());}
                if (img.getImageNumber()==2020) {map.put("s2020",img.getImgUrl());}
                                                 
                if (img.getImageNumber()==2021) {map.put("s2021",img.getImgUrl());}
                if (img.getImageNumber()==2022) {map.put("s2022",img.getImgUrl());}
                if (img.getImageNumber()==2023) {map.put("s2023",img.getImgUrl());}
                if (img.getImageNumber()==2024) {map.put("s2024",img.getImgUrl());}
                if (img.getImageNumber()==2025) {map.put("s2025",img.getImgUrl());}
                                                 
                if (img.getImageNumber()==2026) {map.put("s2026",img.getImgUrl());}
                if (img.getImageNumber()==2027) {map.put("s2027",img.getImgUrl());}
                                                 
                if (img.getImageNumber()==2028) {map.put("s2028",img.getImgUrl());}
                if (img.getImageNumber()==2029) {map.put("s2029",img.getImgUrl());}
                if (img.getImageNumber()==2030) {map.put("s2030",img.getImgUrl());}
                if (img.getImageNumber()==2031) {map.put("s2031",img.getImgUrl());}
                if (img.getImageNumber()==2032) {map.put("s2032",img.getImgUrl());}
                                                 
                if (img.getImageNumber()==2033) {map.put("s2033",img.getImgUrl());}
                if (img.getImageNumber()==2034) {map.put("s2034",img.getImgUrl());}
                if (img.getImageNumber()==2035) {map.put("s2035",img.getImgUrl());}
                if (img.getImageNumber()==2036) {map.put("s2036",img.getImgUrl());}
                if (img.getImageNumber()==2037) {map.put("s2037",img.getImgUrl());}
                                                 
                if (img.getImageNumber()==2038) {map.put("s2038",img.getImgUrl());}
                
                //员工风采添加三张图
                if (img.getImageNumber()==2039) {map.put("s2039",img.getImgUrl());}
                if (img.getImageNumber()==2040) {map.put("s2040",img.getImgUrl());}
                if (img.getImageNumber()==2044) {map.put("s2044",img.getImgUrl());}
                //办公环境添加三张图
                if (img.getImageNumber()==2041) {map.put("s2041",img.getImgUrl());}
                if (img.getImageNumber()==2042) {map.put("s2042",img.getImgUrl());}
                if (img.getImageNumber()==2043) {map.put("s2043",img.getImgUrl());}
            }
        }
        
        // 遍历文字管理信息
        List<Text> listAllText = textService.listAllTextForMain();
        if (listAllText.size()>0) {
            for (int i = 0; i < listAllText.size(); i++) {
                Text text = listAllText.get(i);
                if (text.getTextNumber()==101)  {map.put("s101",text.getTextInfo());}
                                                 
                if (text.getTextNumber()==1001) {map.put("s1001",text.getTextInfo());}
                if (text.getTextNumber()==1002) {map.put("s1002",text.getTextInfo());}
                                                 
                if (text.getTextNumber()==1003) {map.put("s1003",text.getTextInfo());}
                if (text.getTextNumber()==1004) {map.put("s1004",text.getTextInfo());}
                if (text.getTextNumber()==1005) {map.put("s1005",text.getTextInfo());}
                if (text.getTextNumber()==1006) {map.put("s1006",text.getTextInfo());}
                if (text.getTextNumber()==1007) {map.put("s1007",text.getTextInfo());}
                if (text.getTextNumber()==1008) {map.put("s1008",text.getTextInfo());}
                if (text.getTextNumber()==1009) {map.put("s1009",text.getTextInfo());}
                if (text.getTextNumber()==1010) {map.put("s1010",text.getTextInfo());}
                if (text.getTextNumber()==1011) {map.put("s1011",text.getTextInfo());}
                if (text.getTextNumber()==1012) {map.put("s1012",text.getTextInfo());}
                                                 
                if (text.getTextNumber()==1013) {map.put("s1013",text.getTextInfo());}
                if (text.getTextNumber()==1014) {map.put("s1014",text.getTextInfo());}
                if (text.getTextNumber()==1015) {map.put("s1015",text.getTextInfo());}
                if (text.getTextNumber()==1016) {map.put("s1016",text.getTextInfo());}
                if (text.getTextNumber()==1017) {map.put("s1017",text.getTextInfo());}
                if (text.getTextNumber()==1018) {map.put("s1018",text.getTextInfo());}
                if (text.getTextNumber()==1019) {map.put("s1019",text.getTextInfo());}
                if (text.getTextNumber()==1020) {map.put("s1020",text.getTextInfo());}
                                                 
                if (text.getTextNumber()==1021) {map.put("s1021",text.getTextInfo());}
                if (text.getTextNumber()==1022) {map.put("s1022",text.getTextInfo());}
                if (text.getTextNumber()==1023) {map.put("s1023",text.getTextInfo());}
                if (text.getTextNumber()==1024) {map.put("s1024",text.getTextInfo());}
                if (text.getTextNumber()==1025) {map.put("s1025",text.getTextInfo());}
                if (text.getTextNumber()==1026) {map.put("s1026",text.getTextInfo());}
                if (text.getTextNumber()==1027) {map.put("s1027",text.getTextInfo());}
                if (text.getTextNumber()==1028) {map.put("s1028",text.getTextInfo());}
                if (text.getTextNumber()==1029) {map.put("s1029",text.getTextInfo());}
                                                 
                if (text.getTextNumber()==1030) {map.put("s1030",text.getTextInfo());}
                if (text.getTextNumber()==1031) {map.put("s1031",text.getTextInfo());}
                if (text.getTextNumber()==1032) {map.put("s1032",text.getTextInfo());}
                                                
                if (text.getTextNumber()==1033) {map.put("s1033",text.getTextInfo());}
                                                
                if (text.getTextNumber()==1034) {map.put("s1034",text.getTextInfo());}
                if (text.getTextNumber()==1035) {map.put("s1035",text.getTextInfo());}
                if (text.getTextNumber()==1036) {map.put("s1036",text.getTextInfo());}
                                                 
                if (text.getTextNumber()==1037) {map.put("s1037",text.getTextInfo());}
                if (text.getTextNumber()==1038) {map.put("s1038",text.getTextInfo());}
                if (text.getTextNumber()==1039) {map.put("s1039",text.getTextInfo());}
                if (text.getTextNumber()==1040) {map.put("s1040",text.getTextInfo());}
                if (text.getTextNumber()==1041) {map.put("s1041",text.getTextInfo());}
                if (text.getTextNumber()==1042) {map.put("s1042",text.getTextInfo());}
                if (text.getTextNumber()==1043) {map.put("s1043",text.getTextInfo());}
                if (text.getTextNumber()==1044) {map.put("s1044",text.getTextInfo());}
                if (text.getTextNumber()==1045) {map.put("s1045",text.getTextInfo());}
                if (text.getTextNumber()==1046) {map.put("s1046",text.getTextInfo());}
                if (text.getTextNumber()==1047) {map.put("s1047",text.getTextInfo());}
                if (text.getTextNumber()==1048) {map.put("s1048",text.getTextInfo());}
                if (text.getTextNumber()==1049) {map.put("s1049",text.getTextInfo());}
                if (text.getTextNumber()==1050) {map.put("s1050",text.getTextInfo());}
            }
        }

        Map<String,Object> partners = partnerService.listPartner(null, null);
        List<Information> listInformation = informationService.getInformation();
        map.put("information", listInformation.get(0));
        
        map.put("listPartner", partners.get("listPartner"));
        
        staticPageService.indexStatic(map, "index", "front/index/index");
        
        // 02、静态化关于我们页面
        staticPageService.indexStatic(map, "about", "front/about/about");
        // 03、静态化案例页面
        staticPageService.indexStatic(map, "case", "front/case/case");
        // 04、静态化优势页面
        staticPageService.indexStatic(map, "advantage", "front/advantage/advantage");
        // 05、静态化团队页面
        staticPageService.indexStatic(map, "team", "front/team/team");
        // 07、静态化联系我们页面
        staticPageService.indexStatic(map, "contactUs", "front/contactUs/contactUs");
        
        // 09、静态化模版页面
        staticPageService.indexStatic(map, "mould", "front/mould/mould");
        
        // 06、静态化招聘页面
        List<Wanted> wantedList = wantedMapper.listWanted(0, 100);
        map.put("wantedList", wantedList);
        List<Welfare> result = welfareMapper.listWelfare(0, 20);
        map.put("welfareList", result);
        staticPageService.indexStatic(map, "employeePage", "front/recruit/recruit");
        
        // 08、静态化新闻详情页面
        List<News> newsList = newsMapper.listAll(0, 500);
        if (newsList.size()>0) {
            for(int i = 0 ;i<newsList.size();i++){
                map.put("news", newsList.get(i));
                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
                String str = sdf.format(newsList.get(i).getTime());
                map.put("time", str);
                staticPageService.indexStatic(map, "news"+newsList.get(i).getId(), "front/index/newsInfo");
            }
        }
        
        Map<String, Object> map2 = new HashMap<>();
        map2.put("code", 1);
        return map2;
    }
}

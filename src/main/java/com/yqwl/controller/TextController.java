/**
 *
 * @Title: TextController.java
 * @Package com.yqwl.controller
 * @Description: TODO)
 * @author zhoujiaxin
 * @date 2019年3月28日
 */

package com.yqwl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.common.utils.Constants;
import com.yqwl.pojo.Text;
import com.yqwl.service.TextService;

/**
 * 
 * @Description 文字管理
 *    
 * @author zhoujiaxin  
 * @createDate 2019年3月28日  
 */
@Controller
public class TextController {
    @Autowired
    private TextService textService;
    
    // 转跳到列表页面
    @RequestMapping("ztTextList")
    public String ztTextList() {
        return "views/back/FontManagement/FontManagement";
    }

    
    // 转跳到添加界面
    @RequestMapping("ztTextAdd")
    public String add() {
        return "views/back/FontManagement/addFontManagement";
    }
    
    // 添加文字
    @RequestMapping("/saveOneText")
    @ResponseBody
    private Map<String, Object> saveOneText(Model model , Text text){
        Map<String, Object> map = new HashMap<>();
        int result = textService.saveOneText(text);
        if (result==1) {
            map.put("code", 0);
            map.put("msg", "新增成功");
            return map;
        }else{
            map.put("code", 1);
            map.put("msg", "新增失败");
            return map;
        }
    }
    
    // 查询所有文字
    @ResponseBody
    @RequestMapping("/listAllText")
    private Map<String, Object> listAllText(Model model ,Integer page, Integer limit){
        Map<String, Object> map = new HashMap<>();
        page = (page-1)*limit;
        List<Text> textList = textService.listAllText(page,limit);
        int count = textService.listAllCount();
            map.put("data", textList);
            map.put("count", count);
            map.put("code", 0);
            map.put("msg", "成功");
            return map;
    }
    
    // 转跳到修改页面
    @RequestMapping("/selectTextById")
    private String selectTextById(Model model,Text text ){
        Text text2 = textService.selectTextById(text);
        model.addAttribute("text",text2);
            return "views/back/FontManagement/updateFontManagement";
    }
    
    // 跟新文字信息
    @RequestMapping("/updateText")
    @ResponseBody
    private Map<String, Object> updateText(Model model , Text text){
        Map<String, Object> map = new HashMap<>();
        int result = textService.updateText(text);
        if (result==1) {
            map.put("code", 0);
            map.put("msg", "更新成功");
            return map;
        }else{
            map.put("code", 1);
            map.put("msg", "更新失败");
            return map;
        }
    }
    
}

/**
 *
 * @Title: TextServiceImpl.java
 * @Package com.yqwl.service.impl
 * @Description: TODO)
 * @author zhoujiaxin
 * @date 2019年3月28日
 */

package com.yqwl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yqwl.dao.TextMapper;
import com.yqwl.pojo.Text;
import com.yqwl.service.TextService;

/**
 * 
 * @Description 
 *    
 * @author zhoujiaxin  
 * @createDate 2019年3月28日  
 */
@Service
public class TextServiceImpl implements TextService{
    
    @Resource
    private TextMapper textMapper;

    @Override
    public int saveOneText(Text text) {
        // TODO Auto-generated method stub
        return textMapper.saveOneText(text);
    }

    @Override
    public List<Text> listAllText(Integer page, Integer limit) {
        return textMapper.listAllText(page,limit);
    }

    @Override
    public int listAllCount() {
        return textMapper.listAllCount();
    }

    @Override
    public Text selectTextById(Text text) {
        return textMapper.selectTextById(text);
    }

    @Override
    public int updateText(Text text) {
        return textMapper.updateText(text);
    }

    @Override
    public List<Text> listAllTextForMain() {
        return textMapper.listAllTextForMain();
    }

}

/**
 *
 * @Title: TextMapper.java
 * @Package com.yqwl.dao
 * @Description: TODO)
 * @author zhoujiaxin
 * @date 2019年3月28日
 */

package com.yqwl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Text;

/**
 * 
 * @Description 
 *    
 * @author zhoujiaxin  
 * @createDate 2019年3月28日  
 */
public interface TextMapper {

    /**
     *
     * @Title: saveOneText
     * @description 
     * @param @param text
     * @param @return  
     * @return int    
     * @author zhoujiaxin
     * @createDate 2019年3月28日
     */
    int saveOneText(Text text);

    /**
     * @Title: listAllText
     * @description 
     * @param @return  
     * @return List<Text>    
     * @author zhoujiaxin
     * @createDate 2019年3月28日
     */
    

    /**
     * @Title: listAllCount
     * @description 
     * @param @return  
     * @return int    
     * @author zhoujiaxin
     * @createDate 2019年3月28日
     */
    int listAllCount();

    /**
     * @Title: selectTextById
     * @description 
     * @param @param text
     * @param @return  
     * @return Text    
     * @author zhoujiaxin
     * @createDate 2019年3月28日
     */
    Text selectTextById(Text text);

    /**
     * @Title: updateText
     * @description 
     * @param @param text
     * @param @return  
     * @return int    
     * @author zhoujiaxin
     * @createDate 2019年3月28日
     */
    int updateText(Text text);

    /**
     * @Title: listAllTextForMain
     * @description 
     * @param @return  
     * @return List<Text>    
     * @author zhoujiaxin
     * @createDate 2019年3月28日
     */
    List<Text> listAllTextForMain();

    /**
     * @Title: listAllText
     * @description 
     * @param @param page
     * @param @param limit
     * @param @return  
     * @return List<Text>    
     * @author zhoujiaxin
     * @createDate 2019年3月28日
     */
    List<Text> listAllText(@Param("page")Integer page,@Param("limit") Integer limit);
    

}

/**
 *
 * @Title: StaticPageService.java
 * @Package com.yqwl.service
 * @Description: TODO)
 * @author zhoujiaxin
 * @date 2019年4月20日
 */

package com.yqwl.service;

import java.util.Map;

/**
 * 
 * @Description 静态页面业务层
 *    
 * @author zhoujiaxin  
 * @createDate 2019年4月20日  
 */
public interface StaticPageService {
    
    void indexStatic(Map<String, Object> map,String resultName,String templateName);

}

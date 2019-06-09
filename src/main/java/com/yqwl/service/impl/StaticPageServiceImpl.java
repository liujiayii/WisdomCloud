/**
 *
 * @Title: StaticPageServiceImpl.java
 * @Package com.yqwl.service.impl
 * @Description: TODO)
 * @author zhoujiaxin
 * @date 2019年4月20日
 */

package com.yqwl.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.yqwl.service.StaticPageService;

import freemarker.template.Configuration;
import freemarker.template.Template;



/**
 * 
 * @Description 静态页面业务层
 *    
 * @author zhoujiaxin  
 * @createDate 2019年4月20日  
 */
public class StaticPageServiceImpl implements StaticPageService ,ServletContextAware{
    
    private ServletContext servletContext;
    
    private Configuration configuration;
    
    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer){
        this.configuration = freeMarkerConfigurer.getConfiguration();
    }
    
    @Override
    public void indexStatic(Map<String, Object> map,String resultName,String templateName){
        // 输出流
        Writer out = null;
        try {
            // 读进来 UTF-8
            Template template = configuration.getTemplate(templateName+".html");
            // 获取路径
            String path = getPath("/"+resultName+".html");
            File f = new File(path);
            File parentFile = f.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            // 输出流
            out = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
            template.process(map, out);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    public String getPath(String path){
        return servletContext.getRealPath(path);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

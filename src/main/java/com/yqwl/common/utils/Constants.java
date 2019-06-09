package com.yqwl.common.utils;

import java.nio.charset.Charset;

/**
 * 常量定义
 */
public class Constants {
    /** 编码UTF-8 */
    public static final String CHARSET_UTF = "UTF-8";
    /** 编码GB2312 */
	public static final Charset GB2312 = Charset.forName("GB2312");
    /**字符编码UTF-8*/
    public static final Charset UTF8 = Charset.forName("UTF-8");
    /**字符编码ISO-8859-1*/
    public static final Charset ISO8859 = Charset.forName("ISO-8859-1");
    /**状态*/
    public static final String STATUS = "status";
    /** 提示消息 */
    public static final String MSG = "msg";
    /** 错误消息 */
    public static final String ERR = "err";
    /** 数据内容 */
    public static final String DATA = "data";

    public static final String Login_User = "loginUser";
    
    /** 日期格式*/
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    /** 时间格式*/
    public static final String TIME_PATTERN = "HH:mm:ss";
    /** 24小时制日期时间格式*/
    public static final String DATETIME_PATTERN_24H = "yyyy-MM-dd HH:mm:ss";
    /** html类型响应头信息*/
    public static final String HTML_PRODUCE_TYPE = "text/html;charset=UTF-8"; 
    /** json类型响应头信息*/
    public static final String JSON_PRODUCE_TYPE = "application/json;charset=UTF-8";
    

}

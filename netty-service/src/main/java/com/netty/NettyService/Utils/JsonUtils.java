package com.netty.NettyService.Utils;


import com.alibaba.fastjson.JSON;

/**
 * Json工具类，数据格式转换
 */
public class JsonUtils {

    /**
     * 对象转换为Json字符串
     * @param obj
     * @return
     */
    public static String Obj2JsonStr(Object obj){
        String json = JSON.toJSONString(obj);
        return json;
    }

    /**
     * Json字符串转换成java对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T str2Object(String json,Class<T> clazz){
        return JSON.parseObject(json,clazz);
    }

}

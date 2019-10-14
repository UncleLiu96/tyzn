package com.rke.utils;

import com.alibaba.fastjson.JSONObject;
import com.common.Utils.http.HttpUtils;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/28 0028 15:29
 * @desc TODO 门禁API
 */
public class EntranceGuardAPI {

    private static final String APPID="201967";//接口ID,身份标识
    private static final String APPSECRET="078964a21d208ee0295cfa6b09513213";//应用钥匙，用于获取token
    private static final String SIGNKEY="b0fbfb1027480ed85b8182cf20841572";//用于签名过程
    private static final String URL="https://test.ztitt.com/api";

    /**
     * 获取token
     * {
     * 	errcode:0,
     * 	errms:"xxx",
     * 	data:
     *        {
     * 		token:"xxx",
     * 		timeout:”xxxxx” ,
     * 		districkname:”xxxxx”
     *
     *    }
     * }
     * @return
     */
    public static JSONObject getEntranceGuardToken(){
        String s = HttpUtils.sendGet(URL, "f=100021&appid=" + APPID + "&appsecret=" + APPSECRET);

        return JSONObject.parseObject(s);
    }

    /**
     *
     * @param params post/get提交的参数
     * @param signKey
     * @return
     */
    public static String checkSignature(String params, String signKey) {
        // 规则：MD5（MD5（字符串（字典排序（数据）））+密钥字符）

        return "";
    }


    public static void main(String[] args) {
        System.out.println(getEntranceGuardToken().toJSONString());
    }
}

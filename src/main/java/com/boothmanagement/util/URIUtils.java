package com.boothmanagement.util;

/**
 * com.gxa.com.boothmanagement.util.URIUtils
 * User: hly
 * Date: 2024/11/27 10:42
 * motto:   逆水行舟不进则退
 * Description:  URL路径工具
 * Version: v1.0
 */
public class URIUtils {
    /**
     * 截取路径最后一个地址,如果没有斜巷返回null
     * @param url
     * @return
     */
    public   static  String   getSuffixURL(String url){
        int index=url.lastIndexOf("/");
        if(index==-1){
            url.lastIndexOf("\\");
        }
       return index==-1?null:url.substring(index+1);
    }
}

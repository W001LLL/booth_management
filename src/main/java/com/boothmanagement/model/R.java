package com.boothmanagement.model;

import lombok.Data;

/**
 * com.gxa.utils.R
 * User: huangly
 * Date: 2024/11/25 11:46
 * motto:   逆水行舟不进则退
 * Description:  最简单的结果集类
 * Version: v1.0
 */
@Data
public class R<T> {
    private Integer  code;
    private String msg;
    private  Long   count;
    private  T  data;

    public  static  R  ok(){
        R r = new R();
        r.code=0;
        r.msg="成功";
        return  r;
    }
    public  static  R  setData(Object  obj){
        R r = new R();
        r.code=0;
        r.msg="成功";
        r.data=obj;
        return  r;
    }
    public static  <T> R  ok(String   msg){
        R r = new R();
        r.code=0;
        r.msg=msg;
        return  r;
    }

    public static  <T> R  ok(T  data){
        R r = new R();
        r.code=0;
        r.msg="成功";
        r.data=data;
        return  r;
    }
    public static  <T> R  ok(T  data,Long  count){
        R r = new R();
        r.code=0;
        r.msg="成功";
        r.data=data;
        r.count=count;
        return  r;
    }
    public static  <T> R  ok(String msg,T  data){
        R r = new R();
        r.code=0;
        r.msg=msg;
        r.data=data;
        return  r;
    }
    public static  <T> R  ok(String msg,T  data,Long  count){
        R r = new R();
        r.code=0;
        r.msg=msg;
        r.data=data;
        r.count=count;
        return  r;
    }

    public static R  error(){
        R r = new R();
        r.code=-1;
        r.msg="失败";
        return  r;
    }

    public static  R  error(String   msg){
        R r = new R();
        r.code=-1;
        r.msg=msg;
        return  r;
    }


}

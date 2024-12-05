package com.boothmanagement.servlet.base;

import com.alibaba.fastjson.JSON;
import com.boothmanagement.model.R;
import com.boothmanagement.util.URIUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * until
 * User: Wzq
 * Date: 2024/11/29 9:58
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------请求已进入BaseServlet中的service方法........");
        req.setCharacterEncoding("UTF-8");
        String requestURL = req.getRequestURI();
        String methodName = URIUtils.getSuffixURL(requestURL);
        if(methodName!=null){
            Class c = this.getClass();
            try{
                Method method = c.getDeclaredMethod(methodName,HttpServletRequest.class);
                Object value = method.invoke(this, req);
                //(r:路径——重定向，f:路径——转发),继承BaseServlet的类中的方法的返回值为String类型
                // 则判断其是否以f:开头，是则转发，否则重定向
                if(value instanceof String){
                    String url = value.toString();
                    if(url.startsWith("f:")){
                        req.getRequestDispatcher(url.replace("f:", "")).forward(req,resp);
                    }else{
                        resp.sendRedirect(url);
                    }
                    //如果继承BaseServlet的类中的方法的返回值是一个result结果集，则返回一个JSON格式的字符串给前端
                }else if(value instanceof R){
                    resp.setContentType("application/json;charset=UTF-8");
                    String jsonResult = JSON.toJSONString(value);
                    System.out.println("-----返回结果(JSON格式)："+jsonResult);
                    PrintWriter respWriter = resp.getWriter();
                    respWriter.write(jsonResult);
                    respWriter.close();
                    //如果继承BaseServlet的类中的方法的返回值是一个文件类型，则返回文件
                }else if(value instanceof File){
                    File file = (File) value;
                    String fileName = file.getName();
                    resp.setContentType("application/octet-stream");//设置响应头类型，传输流
                    resp.setHeader("Content-Disposition", "attachment;filename="+fileName);//设置响应头，文件名
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));//输入流
                    BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());//输出流 前端
                    int i;
                    while ((i=bis.read())!=-1){
                        bos.write(i);
                    }
                    bos.flush();
                    bos.close();
                    bis.close();
                    //如果继承BaseServlet的类中的方法的返回值是一个HSSFWorkbook，则返回一个excel文件
                }else if(value instanceof HSSFWorkbook){
                   String fileName =  System.currentTimeMillis()+ ".xls";
                   resp.setHeader("Content-Disposition", "attachment;filename="+fileName);
                   resp.setContentType("application/vnd.ms-excel");
                   HSSFWorkbook hssfWorkbook = (HSSFWorkbook) value;
                   hssfWorkbook.write(resp.getOutputStream());
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                System.out.println("-----该方法不存在！");
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
                System.err.println("-----没有权限调用该方法！.....");
            }
        }
    }
}

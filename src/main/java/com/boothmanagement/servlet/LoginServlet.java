package com.boothmanagement.servlet;

import com.boothmanagement.model.R;
import com.boothmanagement.pojo.Admin;
import com.boothmanagement.pojo.vo.TokenVo;
import com.boothmanagement.service.impl.AdminServiceImpl;
import com.boothmanagement.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * com.boothmanagement.servlet
 * User: Wzq
 * Date: 2024/11/30 11:32
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
@WebServlet("/user/*")
public class LoginServlet extends BaseServlet {
    public R login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
//        UserServiceImpl = new UserServiceImpl();
//        User user = userServiceImpl.login(username, password);
        AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
        Admin admin = adminServiceImpl.loginAdmin(username, password);
        String id = request.getSession().getId();
        String token = id;
        TokenVo tokenVo = new TokenVo();
        tokenVo.setToken(token);
        request.getSession().setAttribute("token",token);
        request.getSession().setAttribute("admin",admin);
        System.out.println("token："+token);
        return admin!=null?R.ok("登录成功",tokenVo):R.error("登录失败");
    }
}

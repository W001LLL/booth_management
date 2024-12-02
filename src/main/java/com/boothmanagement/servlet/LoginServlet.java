package com.boothmanagement.servlet;

import com.boothmanagement.model.R;
import com.boothmanagement.pojo.User;
import com.boothmanagement.service.impl.UserServiceImpl;
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
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        User user = userServiceImpl.login(username, password);
        return user!=null?R.ok("登录成功",user):R.error("登录失败");
    }
}

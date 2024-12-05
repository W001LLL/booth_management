package com.boothmanagement.servlet;

import com.boothmanagement.model.R;
import com.boothmanagement.pojo.User;
import com.boothmanagement.service.impl.TestServiceImpl;
import com.boothmanagement.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@WebServlet("/tests/*")
public class TestServlet extends BaseServlet {
    public R test(HttpServletRequest request) {
        TestServiceImpl testService = new TestServiceImpl();
        List<User> userList = testService.test();
        return userList != null ? R.ok("查询成功", userList) : R.error("查询失败");
    }
}

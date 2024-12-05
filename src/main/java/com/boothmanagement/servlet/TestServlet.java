package com.boothmanagement.servlet;

import com.boothmanagement.model.R;
import com.boothmanagement.pojo.User;
import com.boothmanagement.pojo.dto.UserQueryPage;
import com.boothmanagement.service.TestService;
import com.boothmanagement.service.impl.TestServiceImpl;
import com.boothmanagement.servlet.base.BaseServlet;
import com.boothmanagement.util.MyFormatUtils;
import com.boothmanagement.util.WebParameterUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/tests/*")
public class TestServlet extends BaseServlet {
    public R test(HttpServletRequest request) {
        System.out.println("-----------------------------------------------------");
        String userUsername = request.getParameter("userUsername");
        String userPhone = request.getParameter("userPhone");
        System.out.println("userUsername = " + userUsername);
        System.out.println("userPhone = " + userPhone);
        Map<String, String[]> parameterMap = request.getParameterMap();
        UserQueryPage userQueryPage = new UserQueryPage();
        try {
            BeanUtils.copyProperties(userQueryPage,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException  e) {
            System.out.println("请求的参数与属性拷贝不成功");
        }
        TestService testService = new TestServiceImpl();
        R r = testService.test(userQueryPage);
        return r;
    }
    public R testDelete(HttpServletRequest request) {
        TestServiceImpl testService = new TestServiceImpl();
        Integer id = MyFormatUtils.toInteger(request.getParameter("userId"));
        System.out.println("id = " + id);
        return id != null ? R.ok("删除成功", testService.testDelete(id)) : R.error("删除失败");
    }
    public R testUpdate(HttpServletRequest request) {
        User user = WebParameterUtils.receiveJsonToPojo(request, User.class);
        System.out.println("user = " + user);
        TestService testService = new TestServiceImpl();
        return user != null ? R.ok("修改成功", testService.testUpdate(user)) : R.error("修改失败");
    }
}

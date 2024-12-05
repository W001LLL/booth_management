package com.boothmanagement.service.impl;

import com.boothmanagement.dao.TestDao;
import com.boothmanagement.dao.impl.TestDaoImpl;
import com.boothmanagement.model.R;
import com.boothmanagement.pojo.User;
import com.boothmanagement.pojo.dto.UserQueryPage;
import com.boothmanagement.service.TestService;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * com.boothmanagement.service.impl
 * User: Wzq
 * Date: 2024/12/03 9:08
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public class TestServiceImpl implements TestService {


    private TestDao testDao = new TestDaoImpl();

    @Override
    public R test(UserQueryPage userQueryPage) {
        User user = new User();
        try {
            BeanUtils.copyProperties(user,userQueryPage);
        } catch (IllegalAccessException | InvocationTargetException  e) {
            System.out.println("请求的参数与属性拷贝不成功");
        }
        Long count =testDao.testCount(user);
        List<User> list =null;
        if(count>0){
            list = testDao.test(userQueryPage);
        }
        return R.ok(list,count);
    }

    @Override
    public int testDelete(int id) {
        return testDao.testDelete(id);
    }

    @Override
    public int testUpdate(User user) {
        return testDao.testUpdate(user);
    }
}


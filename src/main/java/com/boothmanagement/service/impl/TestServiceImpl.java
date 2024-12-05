package com.boothmanagement.service.impl;

import com.boothmanagement.dao.TestDao;
import com.boothmanagement.dao.impl.TestDaoImpl;
import com.boothmanagement.pojo.User;
import com.boothmanagement.service.TestService;

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
    public List<User> test() {
        return testDao.test();
    }
}


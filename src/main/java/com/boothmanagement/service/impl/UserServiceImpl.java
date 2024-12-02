package com.boothmanagement.service.impl;

import com.boothmanagement.dao.UserDao;
import com.boothmanagement.dao.impl.UserDaoImpl;
import com.boothmanagement.pojo.User;
import com.boothmanagement.service.UserService;

/**
 * com.boothmanagement.service.impl
 * User: Wzq
 * Date: 2024/11/30 11:43
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}

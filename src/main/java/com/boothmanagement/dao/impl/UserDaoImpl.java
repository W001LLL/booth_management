package com.boothmanagement.dao.impl;

import com.boothmanagement.dao.UserDao;
import com.boothmanagement.jdbc.basic.BasicDAO;
import com.boothmanagement.pojo.User;

/**
 * com.boothmanagement.dao.impl
 * User: Wzq
 * Date: 2024/11/30 11:44
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public class UserDaoImpl extends BasicDAO<User> implements UserDao {
    @Override
    public User login(String name, String password) {
        String sql = "select user_username AS userUsername,user_password AS userPassword " +
                " from user where user_username=? and user_password=? ";
        return querySingle(sql,User.class,name,password);
    }
}

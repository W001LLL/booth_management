package com.boothmanagement.dao.impl;

import com.boothmanagement.dao.TestDao;
import com.boothmanagement.jdbc.basic.BasicDAO;
import com.boothmanagement.pojo.User;

import java.util.List;

/**
 * com.boothmanagement.dao.impl
 * User: Wzq
 * Date: 2024/12/03 9:10
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public class TestDaoImpl extends BasicDAO<User> implements TestDao {
    @Override
    public List<User> test() {
        String sql = "SELECT user_id AS userId, user_username AS userUsername, user_password AS userPassword, " +
                "user_phone AS userPhone, user_email AS userEmail, user_role AS userRole FROM user";
        return queryMulti(sql, User.class);
    }

}

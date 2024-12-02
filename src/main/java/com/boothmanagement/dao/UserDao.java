package com.boothmanagement.dao;

import com.boothmanagement.pojo.User;

/**
 * com.boothmanagement.dao
 * User: Wzq
 * Date: 2024/11/30 11:44
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public interface UserDao {
    /**
     * 登录
     * @param name 用户名
     * @param password 密码
     * @return
     */
    User login(String name, String password);
}

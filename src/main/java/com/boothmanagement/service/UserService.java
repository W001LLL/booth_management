package com.boothmanagement.service;

import com.boothmanagement.pojo.User;

/**
 * com.boothmanagement.service
 * User: Wzq
 * Date: 2024/11/30 11:39
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public interface UserService {
    /**
     *登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User login(String username, String password);
}

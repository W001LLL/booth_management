package com.boothmanagement.service;

import com.boothmanagement.pojo.Admin;

/**
 * com.boothmanagement.service
 * User: Wzq
 * Date: 2024/12/12 16:36
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public interface AdminService {
    Admin loginAdmin(String name, String password);
}

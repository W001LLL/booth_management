package com.boothmanagement.dao;

import com.boothmanagement.pojo.Admin;

/**
 * com.boothmanagement.dao
 * User: Wzq
 * Date: 2024/12/12 16:35
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public interface AdminDao {
    Admin loginAdmin(String name, String password);
}

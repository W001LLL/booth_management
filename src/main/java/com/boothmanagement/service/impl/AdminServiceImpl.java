package com.boothmanagement.service.impl;

import com.boothmanagement.dao.AdminDao;
import com.boothmanagement.dao.impl.AdminDaoImpl;
import com.boothmanagement.pojo.Admin;
import com.boothmanagement.service.AdminService;

/**
 * com.boothmanagement.service.impl
 * User: Wzq
 * Date: 2024/12/12 16:37
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin loginAdmin(String name, String password) {
        return adminDao.loginAdmin(name,password);
    }
}

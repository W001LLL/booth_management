package com.boothmanagement.dao.impl;

import com.boothmanagement.dao.AdminDao;
import com.boothmanagement.jdbc.basic.BasicDAO;
import com.boothmanagement.pojo.Admin;

/**
 * com.boothmanagement.dao.impl
 * User: Wzq
 * Date: 2024/12/12 16:35
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public class AdminDaoImpl extends BasicDAO<Admin> implements AdminDao {
    @Override
    public Admin loginAdmin(String name, String password) {
        String sql = "select admin_username AS adminUsername,admin_password AS adminPassword,admin_phone AS adminPhone,roles AS roles " +
                " from admin where admin_username=? and admin_password=? " ;
        Admin admin = querySingle(sql, Admin.class, name, password);
        System.out.println(admin.toString());
        return querySingle(sql,Admin.class,name,password);
    }
}

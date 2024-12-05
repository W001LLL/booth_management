package com.boothmanagement.dao.impl;

import com.boothmanagement.dao.TestDao;
import com.boothmanagement.jdbc.basic.BasicDAO;
import com.boothmanagement.pojo.User;
import com.boothmanagement.pojo.dto.UserQueryPage;
import com.boothmanagement.util.MyFormatUtils;

import java.util.ArrayList;
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
    public List<User> test(UserQueryPage userQueryPage) {
        StringBuffer sql =new StringBuffer("select user_id AS userId,user_username AS userUsername,user_password AS userPassword,user_phone AS userPhone,user_email AS userEmail,user_role AS userRole from user where 1=1");
        List<Object> parameters = new ArrayList<>();
        if(!MyFormatUtils.isBank(userQueryPage.getUserUsername())){
            parameters.add(userQueryPage.getUserUsername());
            sql.append(" and user_username like concat('%',?,'%')");
        }
        if(!MyFormatUtils.isBank(userQueryPage.getUserPhone())){
            parameters.add(userQueryPage.getUserPhone());
            sql.append(" and user_phone like concat('%',?,'%')");
        }
        sql.append(" order by user_id desc " );
        sql.append(" limit "+(userQueryPage.getPage()-1)*userQueryPage.getLimit()+","+userQueryPage.getLimit());
        System.out.println("sql = " + sql);
        System.out.println("parameters = " + parameters);
        return queryMulti(sql.toString(),User.class,parameters.toArray());
    }

    @Override
    public int testDelete(int id){
        String sql="delete from user where user_id=?";
        return update(sql,id);
    }

    @Override
    public int testUpdate(User user) {
        String sql="update user set user_username=?,user_phone=?,user_email=?where user_id=?";
        return update(sql,user.getUserUsername(), user.getUserPhone(),
                user.getUserEmail(),user.getUserId());
    }

    @Override
    public long testCount(User user) {
        StringBuffer sql =new StringBuffer("select count(*) from user where 1=1 ");
        List<Object>  parameters=new ArrayList<>();
        if(!MyFormatUtils.isBank(user.getUserUsername())){
            parameters.add(user.getUserUsername());
            sql.append(" and  user_username like  concat('%',?,'%')");
        }
        if(!MyFormatUtils.isBank(user.getUserPhone())){
            parameters.add(user.getUserPhone());
            sql.append(" and user_phone like concat('%',?,'%')");
        }
        System.out.println("sql:"+sql);
        System.out.println("参数:"+parameters);
        return (long) queryScalar(sql.toString(),parameters.toArray());
    }
}

package com.boothmanagement.jdbc.basic;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Wzq
 * Date: 2024/11/29 20:05
 * motto:   相与笑春风
 * Description:
 * Version: V1.0
 */
public class BasicDAO<T> {
    private QueryRunner qr=new QueryRunner();

    /**
     * 通用的dml 增删改，任意表可用
     * @param sql 要执行的sql语句
     * @param parameters 传入的要执行的参数
     * @return  返回一个int值，是否受影响
     */
    public int update(String sql,Object...parameters){
        Connection connection = null;
        try {
            connection = JDBCDruidUtil.getConnection();
            return qr.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        } finally {
            JDBCDruidUtil.close(null, null, connection);
        }
    }

    /**
     * 查询返回多行多条的数据，所有表型可用
     * @param sql 要执行的sql语句
     * @param clazz 要进行操作封装数据的实体类
     * @param parameters 传入的要执行的参数
     * @return 返回一个List集合，多行多列的数据
     */
    public List<T> queryMulti(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCDruidUtil.getConnection();
            return qr.query(connection,sql,new BeanListHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidUtil.close(null, null, connection);
        }
    }

    /**
     * 返回单行单列的数据，所有表可用
     * @param sql 要执行的sql语句
     * @param clazz 要进行操作封装数据的实体类
     * @param parameters 传入的要执行的参数
     * @return 返回一个实体类
     */
    public T querySingle(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCDruidUtil.getConnection();
            return qr.query(connection,sql,new BeanHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidUtil.close(null, null, connection);
        }
    }

    /**
     * 返回单个数据，指定查询的列的数据，所有表可用---比如我查询id为1 的学生的名字是什么，返回一个xxx
     * @param sql 要执行的sql语句
     * @param parameters 要执行的参数
     * @return 返回一个Object对象
     */
    public Object queryScalar(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCDruidUtil.getConnection();
            return qr.query(connection,sql,new ScalarHandler<>(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCDruidUtil.close(null, null, connection);
        }
    }
}

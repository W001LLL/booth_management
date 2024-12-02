package com.boothmanagement.jdbc.basic;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * User: Wzq
 * Date: 2024/11/29 13:47
 * motto:   相与笑春风
 * Description: JDBC工具类，基于Druid连接池
 * Version: V1.0
 */
public class JDBCDruidUtil {
    private static DataSource ds; // 静态变量用于保存连接池

    static {
        try {
            Properties properties = new Properties();
            // 使用类加载器获取配置文件路径
            System.out.println(JDBCDruidUtil.class.getClassLoader().getResource("druid.properties"));
            properties.load(JDBCDruidUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
            System.out.println("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载配置文件失败");
        }
    }


    // 获取数据库连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = ds.getConnection();  // 从连接池中获取连接
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        return connection;
    }

    // 关闭资源并将连接放回连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("关闭 ResultSet 失败");
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();  // 连接会被自动放回连接池
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("关闭 Statement 或 Connection 失败");
            }
        }
    }
}

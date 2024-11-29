package com.boothmanagement.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.baidu.t2.PreparedStatement
 * User: hly
 * Date: 2024/11/06 16:04
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class JDBCUtilsMy {
    //配置信息
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/second_hand";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    //对象
    //连接对象
    private static Connection connection;
    //执行对象
    private static PreparedStatement preparedStatement;
    //结果集
    private static int  rows;   //insert   update  delete
    //
    private static ResultSet resultSet;  //select

    //  1.加载驱动 (驱动只加载一次) static
    static {
        try {
            Class.forName(DRIVER);
            System.out.println("数据库驱动加载成功！");
        } catch (ClassNotFoundException e) {
            System.err.println("数据库驱动加载失败！");
            e.printStackTrace();
        }
    }
    /**
     * 2.获得连接对象
     * @return
     */
    public static Connection  openConnection(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("====url路径错误,用户名或者密码错误==========");
            e.printStackTrace();
        }
        return  connection;
    }
    /**
     * 3.创建执行对象
     */
    public static Statement   getStatement(String sql){
        try {
            //判断连接对象是否有值  有值但是被关闭
            if(connection==null ||  connection.isClosed());
            openConnection();
            preparedStatement=connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.err.println("=====没有权限========");
            e.printStackTrace();
        }
        return  preparedStatement;
    }

    //  4.执行sql并获得结果集  update(insert update delete)   query(select)

    /**
     * 修改(insert update delete0
     * @param sql  占位符
     * @return
     */
    public static int   update(String sql, Object[] params){
        //执行对象
        try {
            if(preparedStatement==null  ||  preparedStatement.isClosed())
                getStatement(sql);
            //填空
            if(params!=null && params.length>0){
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            rows = preparedStatement.executeUpdate();//执行创建执行对象的时候就已经编译了Sql  执行
        } catch (SQLException e) {
            System.err.println("sql语法错误:"+sql);
            e.printStackTrace();
        }finally {
            close();
        }
        return  rows;
    }

    public static List<Map<String,Object>> select(String sql){
        return select(sql,null);
    }
    /**
     *  查询(select)
     * @param sql
     * @return
     */
    public static List<Map<String,Object>> select(String sql, Object[] params){
        //定义容器 装入结果集 装入所有查询的表的结果集
        List<Map<String,Object>>  mapList=new ArrayList<>();
        //执行对象
        try {
            if(preparedStatement==null  ||  preparedStatement.isClosed())
                getStatement(sql);
            //填空
            if(params!=null && params.length>0){
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();//执行创建执行对象的时候就已经编译了Sql  执行
            //解析结果集
            //获得表的字段内容信息
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获得总共有多少列
            int columnCount = metaData.getColumnCount();
            //循环所有的行数据
            while(resultSet.next()){
                //装入这一行的数据
                HashMap<String,Object>  rowData=new HashMap<>();
                //循环所有列
                for (int i =1; i <= columnCount; i++) {
                    //获得列明
                    String columnName = metaData.getColumnName(i);
                    //获得列值
                    Object  columnValue=resultSet.getObject(columnName);
                    //保存这一列的数据
                    rowData.put(columnName,columnValue);
                }
                //保存这一行的数据
                mapList.add(rowData);
            }

        } catch (SQLException e) {
            System.err.println("sql语法错误:"+sql);
            e.printStackTrace();
        }finally {
            close();
        }
        return  mapList;
    }
    public static List<Map<String,Object>> select2(String sql){
            // 定义容器，存储结果集
        List<Map<String, Object>> mapList = new ArrayList<>();
        try {
            // 检查并初始化 `preparedStatement`
            if (preparedStatement == null || preparedStatement.isClosed()) {
                getStatement(sql);
            }
            // 执行 SQL 查询
            resultSet = preparedStatement.executeQuery();
            // 解析结果集
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount(); // 获取列数
            while (resultSet.next()) {
                Map<String, Object> rowData = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i); // 列名
                    Object columnValue = resultSet.getObject(columnName); // 列值
                    rowData.put(columnName, columnValue);
                }
                mapList.add(rowData);
            }
        } catch (SQLException e) {
            System.err.println("SQL 执行错误: " + sql);
            e.printStackTrace();
        } finally {
            close(); // 关闭资源
        }
        return mapList;
    }
    /**
     * 5.释放资源
     */
    public static void  close(){
        if(resultSet!=null ){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


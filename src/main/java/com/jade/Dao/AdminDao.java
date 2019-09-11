package com.jade.Dao;

import com.jade.bean.Admin;

import java.sql.SQLException;

public interface AdminDao {

//    /*增加管理员*/
//    public int adminAdd(Admin admin) throws SQLException;
//
//    /*删除管理员*/
//    public int adminDelete(int aid) throws SQLException;
//
//    /*修改管理员*/
//    public int adminAlter(int aid,Admin admin) throws SQLException;

    /*检查账号*/
    public int adminCheck(Admin admin) throws SQLException;

    /*查询账号*/
//    public Admin adminQuery(int id) throws SQLException;
}

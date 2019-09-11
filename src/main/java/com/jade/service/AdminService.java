package com.jade.service;

import com.jade.bean.Admin;

import java.sql.SQLException;

public interface AdminService {

//    /* 增加管理员 */
//    public boolean adminAdd(Admin admin) throws SQLException;
//
//    /* 删除管理员 */
//    public boolean adminDelete(int aid) throws SQLException;
//
//    /* 修改管理员 */
//    public boolean adminAlter(int aid, Admin admin) throws SQLException;
//
      /* 检查账号 */
    public int adminCheck(Admin admin) throws SQLException;

    /*查询账号信息*/
//    public Admin adminQuery(int id) throws SQLException;

}

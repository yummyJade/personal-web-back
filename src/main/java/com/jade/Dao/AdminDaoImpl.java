package com.jade.Dao;

import com.jade.bean.Admin;
import com.jade.sql.sqlTool;
import com.jade.util.MD5Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

public class AdminDaoImpl implements AdminDao {

//    private QueryRunner qr;
    public AdminDaoImpl() {
//        this.qr = new QueryRunner(MyDataSource.getDataSource());

    }

    //核对管理员信息
    public int adminCheck(Admin admin) throws SQLException{
        Statement st ;
        ResultSet rs;
        Connection con = null;
        Vector<HashMap<String,String>> vector = new Vector<>();

        con = sqlTool.connect(con);
        st = con.createStatement();
        String sql = "SELECT id FROM admin where username = '"+ admin.getUsername() +"'and password = '"+ MD5Util.MD5(admin.getPassword())
                +"'";
        rs = st.executeQuery(sql);
        int admin_id = -1;
        while(rs.next()) {
//            HashMap<String, String> hashMap = new HashMap<>();
//            hashMap.put("id", rs.getString("id"));
//
//            vector.add(hashMap);
//                rs.close();
//                con.close();
          admin_id = Integer.parseInt(rs.getString("id"));
          System.out.println("succeed get admin");

        }
        return admin_id;
    }

//    @Override
//    public int adminCheck(Admin admin) throws SQLException {
//
//
//        int user_id = -1;
//        String sql = "select a_id id from admin where a_name=? and a_passwd=?";
////        Admin user = qr.query(sql, new BeanHandler<Admin>(Admin.class),admin.getName(),admin.getPasswd());
////        if (null != user) {
////            user_id = user.getId();
////        }
////        return user_id;
//    }

}


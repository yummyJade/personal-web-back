package com.jade.service;

import com.jade.Dao.AdminDao;
import com.jade.Dao.AdminDaoImpl;
import com.jade.bean.Admin;
import com.jade.service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;
    public AdminServiceImpl() {
        this.adminDao = new AdminDaoImpl();

    }
    @Override
    public int adminCheck(Admin admin) throws SQLException {
        int user_id;
        user_id = adminDao.adminCheck(admin);
        return user_id;
    }

}

package com.jade.controller;


import com.jade.bean.Admin;
import com.jade.bean.BaseResponse;
import com.jade.bean.StatusCode;
import com.jade.service.AdminService;
import com.jade.service.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@ResponseBody
@Controller
@RequestMapping(value = "/admin",method = RequestMethod.POST)
public class AdminController {
    private AdminService adminService;
    public  AdminController() {
        this.adminService = new AdminServiceImpl();
    }
    /*账户登录校验*/
    @RequestMapping(value = "/login",method= {RequestMethod.POST})
    public BaseResponse adminCheck(Admin admin, HttpSession session, HttpServletRequest request ) {
        try {
            int temp = adminService.adminCheck(admin);
            if(temp != -1){
                session.setAttribute("username", admin.getUsername());
                session.setAttribute("aid", temp);
                BaseResponse response=new BaseResponse(StatusCode.Success);
                response.setMsg("success");
//                response.setData(vector);
                return response;
//                return "./index.jsp";
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        BaseResponse response=new BaseResponse(StatusCode.Fail);
        response.setMsg("用户名或者密码错误！");
//        return "forward:/login.jsp";
        return response;





//        request.setAttribute("error_msg", "用户名或者密码错误！");
//        return "forward:/login.jsp";
    }
}

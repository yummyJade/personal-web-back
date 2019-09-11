package com.jade.controller;

import com.jade.bean.BaseResponse;
import com.jade.bean.PageObject;
import com.jade.bean.StatusCode;
import com.jade.bean.TripArticle;
import com.jade.sql.sqlTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@ResponseBody
@CrossOrigin
@Controller
@RequestMapping(value = "/tripArticle")
public class TripArticleController {

//    @RequestMapping("/add")
//    public ModelAndView article() {
//        TripArticle tripArticle = new TripArticle();
//        return new ModelAndView("tripArticle").addObject("tripArticle");
//    }


    //文章列表
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public BaseResponse getTripArticleList(HttpServletRequest request) throws Exception{
        Vector<HashMap<String,String>> vector = new Vector<>();
        Vector<HashMap<String,String>> currentVector = new Vector<>();
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        PageObject pageObject = new PageObject(currentPage,limit,vector);


        if(sqlTool.getTripArticle(vector)){
            currentVector = pageObject.queryPage();
            BaseResponse response=new BaseResponse(StatusCode.Success);
            response.setMsg("success");
            response.setCount(vector.size());
            response.setData(currentVector);
            return response;
        }else {
            BaseResponse response=new BaseResponse(StatusCode.Fail);
            return response;
        }
    }
    //文章列表，通过点击筛选出来的地区
    @RequestMapping(value = "listByDist",method = RequestMethod.GET)
    public BaseResponse getTripArticleListByMap(TripArticle tripArticle) throws Exception{
        Vector<HashMap<String,String>> vector = new Vector<>();
        if(sqlTool.getTripArticleByDist(vector,tripArticle)){

            BaseResponse response=new BaseResponse(StatusCode.Success);
            response.setMsg("success");
            response.setData(vector);
            response.setCount(vector.size());
            return response;
        }else {
            BaseResponse response=new BaseResponse(StatusCode.Fail);
            return response;
        }
    }
    //某个id的文章
    @RequestMapping(value = "content",method = RequestMethod.GET)
    public BaseResponse getTripArticleList(TripArticle tripArticle) throws Exception{
        Vector<HashMap<String,String>> vector = new Vector<>();
        if(sqlTool.getTripArticleById(vector,tripArticle)){

            BaseResponse response=new BaseResponse(StatusCode.Success);
            response.setMsg("success");
//            response.setCount(vector.size());
            response.setData(vector);
            return response;
        }else {
            BaseResponse response=new BaseResponse(StatusCode.Fail);
            return response;
        }
    }
    //添加文章
    @RequestMapping(value = "/add",method = RequestMethod.POST)


    public BaseResponse addTripArticle(TripArticle tripArticle) throws Exception{
        //存入数据库

        if(sqlTool.addTripArticle(tripArticle)){
            BaseResponse response=new BaseResponse(StatusCode.Success);
            return response;

        }else{
            BaseResponse response=new BaseResponse(StatusCode.Fail);
            return response;
        }
//        @ModelAttribute("tripArticle")
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("title",tripArticle.getTitle());
//        mv.addObject("articleContent",tripArticle.getContent());
//        mv.setViewName("result");
//在这里不用返回模型，实际上大概只需要一个json串
//        User user=new User();
//        user.setId(123);
//        user.setName("张三");


//        response.setData(user);



    }





}

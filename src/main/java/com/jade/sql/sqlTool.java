package com.jade.sql;



import com.jade.Dao.AdminDaoImpl;
import com.jade.bean.Admin;
import com.jade.bean.StatusCode;
import com.jade.bean.TripArticle;
import com.jade.util.MD5Util;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class sqlTool {
    //声明Connection对象
    static Connection con;
    //驱动程序名
    private static String driver = "com.mysql.cj.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    private static String url = "jdbc:mysql://localhost:3306/mywebsite?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false";
    //MySQL配置时的用户名
    private static String user = "yuyuan";
    //MySQL配置时的密码
    private static String password = "yuyuan46";
    //返回结果集
    static private Resultset rs;
    //执行sql语句
    static private Statement st;

    public static void connect(){
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //带con参数的
    public static Connection connect(Connection con){
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database22!");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;

    }

    //tripArticle

    //增加旅游文章
    public static boolean addTripArticle(TripArticle tripArticle){
        PreparedStatement psql;

        //预处理添加数据？？
        try {
            connect();
            psql = con.prepareStatement("insert into trip_article(title,content,continent,province,citys,headimg)"
                    + "values(?,?,?,?,?,?)");
            psql.setString(1,tripArticle.getTitle());
            psql.setString(2,tripArticle.getContent());
            psql.setInt(3,tripArticle.getContinent());
            psql.setInt(4,tripArticle.getProvince());
            psql.setInt(5,tripArticle.getCitys());
            psql.setString(6,tripArticle.getHeadimg());
            psql.executeUpdate();
            psql.close();
            con.close();

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("add a triparticle");
            return true;
        }
    }

    //获取所有的旅行文章
    public static boolean getTripArticle(Vector<HashMap<String,String>> vector){

//        Statement st ;
        ResultSet rs;
//        Vector<HashMap<String,String>> vector = new Vector<>();

        try {
            connect();
            st = con.createStatement();
            String sql = "SELECT * FROM trip_article";
            rs = st.executeQuery(sql);
            while(rs.next()){
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("id",rs.getString("id"));
                hashMap.put("title",rs.getString("title"));
                hashMap.put("continent",rs.getString("continent"));
                hashMap.put("province",rs.getString("province"));
                hashMap.put("citys",rs.getString("citys"));
                hashMap.put("content",rs.getString("content"));
                hashMap.put("headimg",rs.getString("headimg"));
                vector.add(hashMap);

            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("succeed get tripArticleList");
            return true;
        }

    }
    //获取所有满足条件（即某个地点）的旅行文章
    public static boolean getTripArticleByDist(Vector<HashMap<String,String>> vector,TripArticle tripArticle){

//        Statement st ;
        ResultSet rs;
        String sql;
//        Vector<HashMap<String,String>> vector = new Vector<>();

        try {
            connect();
            st = con.createStatement();

            if(tripArticle.getContinent() == 0){
               sql  = "SELECT * FROM trip_article"+ " where continent='"+tripArticle.getContinent()+"';";
            }else{
                sql = "SELECT * FROM trip_article"+ " where continent='"+tripArticle.getContinent()+"' and province='"+
                        tripArticle.getProvince()+"';";
            }

            System.out.println(sql);

            rs = st.executeQuery(sql);
            while(rs.next()){
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("id",rs.getString("id"));
                hashMap.put("title",rs.getString("title"));
                hashMap.put("continent",rs.getString("continent"));
                hashMap.put("province",rs.getString("province"));
                hashMap.put("citys",rs.getString("citys"));
                hashMap.put("content",rs.getString("content"));
                hashMap.put("headimg",rs.getString("headimg"));
                vector.add(hashMap);

            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("succeed get tripArticleList");
            return true;
        }

    }
    //获取某篇旅行文章
    public static boolean getTripArticleById(Vector<HashMap<String,String>> vector,TripArticle tripArticle){

//        Statement st ;
        ResultSet rs;
//        Vector<HashMap<String,String>> vector = new Vector<>();

        try {
            connect();
            st = con.createStatement();
            String sql = "SELECT * FROM trip_article "+" where id='" + tripArticle.getId() + "'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("id",rs.getString("id"));
                hashMap.put("title",rs.getString("title"));
                hashMap.put("continent",rs.getString("continent"));
                hashMap.put("province",rs.getString("province"));
                hashMap.put("citys",rs.getString("citys"));
                hashMap.put("content",rs.getString("content"));
                vector.add(hashMap);

            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("succeed get tripArticleList");
            return true;
        }

    }
    //核对管理员信息
    public static Vector<HashMap<String,String>> getAllUser(){
        Statement st ;
        ResultSet rs;
        Vector<HashMap<String,String>> vector = new Vector<>();

        try {
            connect();
            st = con.createStatement();
            String sql = "SELECT * FROM srdp_user";
            rs = st.executeQuery(sql);
            while(rs.next()){
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("username",rs.getString("userName"));
                hashMap.put("userpwd",rs.getString("userPwd"));
                vector.add(hashMap);
//                rs.close();
//                con.close();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("succeed get data");
            return vector;
        }


    }
    //核对管理员信息
    public static int adminCheck(Admin admin) throws SQLException{
        Statement st ;
        ResultSet rs;
//        Connection con = null;
        Vector<HashMap<String,String>> vector = new Vector<>();

        sqlTool.connect();
        st = con.createStatement();
        String sql = "SELECT * FROM admin where username = '"+ admin.getUsername() +"'and password = '"+ MD5Util.MD5(admin.getPassword())
                +"'";
        System.out.println("000000");
        rs = st.executeQuery(sql);
        System.out.println("ra"+rs);
        int admin_id = -1;
        while(rs.next()) {
//            HashMap<String, String> hashMap = new HashMap<>();
//            hashMap.put("id", rs.getString("id"));
//
//            vector.add(hashMap);
//                rs.close();
//                con.close();
            admin_id = Integer.parseInt(rs.getString("id"));
            System.out.println("id"+admin_id);

        }
        return admin_id;
    }



    public static void main(String[] args) {

        Admin admin = new Admin();
        admin.setUsername("chen");
        admin.setPassword(MD5Util.MD5("chen"));
        try {
            adminCheck(admin);
        }catch (Exception e){

        }

    }


}

<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2019/9/7
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/layui/css/layui.css">
<html>
<head>
    <title>Title</title>
</head>
<style>

    .loginBtn{
        width: 100%;
    }
    .mainer-top h2{
        text-align: center;
        margin-bottom: 50px;
    }


</style>
<body class="layui-layout-body" style="display: flex; align-items: center;justify-content: center">
    <%--<%@ include file="common/header.jsp" %>--%>
    <%--<%@ include file="common/sidebar.jsp" %>--%>
    <div class="mainer" style="width: 300px;">
        <div class="mainer-top">
            <h2>yuyuan博客的后台管理系统</h2>

        </div>
        <form class="layui-form"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->

            <div class="layui-form-item">
                <%--<i class="layui-icon layui-icon-username layui-icon"></i>--%>
            <%--<div class="layui-input-block">--%>
                    <input type="text" name="username" placeholder="请输入账号" lay-filter="required" class="layui-input">
                <%--</div>--%>
            </div>
            <div class="layui-form-item">
                <%--<i class="layui-icon layui-icon-password layui-icon"></i>--%>
                <input type="password" name="password" placeholder="请输入密码" lay-filter="required" class="layui-input">

            </div>
            <%--<div class="layui-form-item">--%>
                <%--<div class="layui-row">--%>
                    <%--<div class="layui-col-xs7">--%>
                        <%--<label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>--%>
                        <%--<input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">--%>
                    <%--</div>--%>
                    <%--<div class="layui-col-xs5">--%>
                        <%--<div style="margin-left: 10px;">--%>
                            <%--<img src="https://www.oschina.net/action/user/captcha" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="login" >立即提交</button>
            </div>


        </form>

    </div>

    <%--<%@ include file="common/footer.jsp"%>--%>

</body>
<script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/layui/layui.js"></script>
<script>
    layui.use('form', function(){
        let form = layui.form;
        form.on('submit(login)', function(data){
            $.ajax({
                url: '/myPersonalWebsite_war_exploded/admin/login',
                type: 'post',
                data:data.field,
                dataType:'json',
                success: function (res) {

                    if (res.msg == "success") {
                        location.href = "./index.jsp"
                    }else {
                        layer.msg(info.msg);
                    }

                }
            });

            // console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
            // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
            // console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });

        //各种基于事件的操作，下面会有进一步介绍
    });
</script>
</html>

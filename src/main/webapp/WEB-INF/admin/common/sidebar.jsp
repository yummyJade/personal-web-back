<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2019/8/29
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/layui/css/layui.css">
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">个人博客</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">列表</a></dd>
                    <dd><a href="javascript:;">增加</a></dd>
                    <dd><a href="javascript:;">列表三</a></dd>
                    <dd><a href="">超链接</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">个人旅行</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/admin/tripArticle/list.jsp">列表</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/admin/tripArticle/addTripArticle.jsp">增加</a></dd>
                    <dd><a href="">超链接</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">云市场</a></li>
            <li class="layui-nav-item"><a href="">发布商品</a></li>
        </ul>
    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/layui/layui.js"></script>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
</script>
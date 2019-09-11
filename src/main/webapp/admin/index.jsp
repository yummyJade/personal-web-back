<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2019/8/29
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章列表</title>
</head>
<body>

<div class="container">
    <%@ include file="./common/header.jsp" %>
    <%@ include file="./common/sidebar.jsp" %>
    <div class="layui-body">
        <table id="tripArticleList" lay-filter="tripArticle"></table>
    </div>

    <%@ include file="./common/footer.jsp"%>
</div>
<%--</div>--%>
<script src="${ pageContext.request.contextPath}/statics/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/layui/layui.js"></script>
<%--<script>--%>
    <%--//JavaScript代码区域--%>
    <%--layui.use('element', function(){--%>
        <%--var element = layui.element;--%>

    <%--});--%>
<%--</script>--%>
</body>
</html>
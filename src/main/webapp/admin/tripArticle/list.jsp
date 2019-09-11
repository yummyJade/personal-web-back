<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2019/9/2
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章列表</title>
</head>
<body>

    <div class="container">
        <%@ include file="../common/header.jsp" %>
        <%@ include file="../common/sidebar.jsp" %>
        <div class="layui-body">
            <table id="tripArticleList" lay-filter="tripArticle"></table>
        </div>

        <%@ include file="../common/footer.jsp"%>
    </div>
    <script>
        layui.use('table', function(){
            let table = layui.table;

            //第一个实例
            table.render({
                elem: '#tripArticleList'
                ,height: 312
                ,url: '/myPersonalWebsite_war_exploded/tripArticle/list' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                    ,{field: 'title', title: '标题', width:177}
                    ,{field: 'content', title: '内容', width:177}
                    ,{field: 'continent', title: '洲', width:80, sort: true}
                    ,{field: 'province', title: '省', width: 80}
                    ,{field: 'citys', title: '城市', width: 80}

                ]]
            });

            //监听行单击事件
            table.on('row(tripArticle)', function(obj){
                console.log(obj.tr) //得到当前行元素对象
                console.log(obj.data) //得到当前行数据
                //obj.del(); //删除当前行
                //obj.update(fields) //修改当前行数据
            });

            //监听行双击事件
            table.on('rowDouble(tripArticle)', function(obj){
                //obj 同上
            });

        });


    </script>
</body>

</html>

<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2019/8/28
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加文章</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/style.css">

</head>
<body class="layui-layout-body">
    <%@ include file="../common/header.jsp" %>
    <%@ include file="../common/sidebar.jsp" %>



    <div class="layui-body">
        <!-- 内容主体区域 -->
        <form class="layui-form"  method="post" id="myForm" enctype="multipart/form-data">
            <div class="layui-form-item">
                <label class="layui-form-label">标题</label>
                <div class="layui-input-block">
                    <input type="text" name="title" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">设置封面</label>
                <div class="layui-input-inline uploadHeadImage">
                    <div class="layui-upload-drag" id="headImg" >
                        <i class="layui-icon"></i>
                        <p>点击上传图片，或将图片拖拽到此处</p>
                    </div>
                    <input type="hidden" name="headimg" class="headImgInput">
                </div>
                <div class="layui-input-inline">
                    <div class="layui-upload-list">
                        <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo1">
                        <p id="demoText"></p>
                    </div>
                </div>
            </div>



            <div class="layui-form-item">
                <label class="layui-form-label">洲/国</label>
                <div class="layui-input-block">
                    <select class="district continent" name="continent" lay-filter="continent" value="0">

                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">国家/省</label>
                <div class="layui-input-block">
                    <select class="district province" name="province" lay-filter="province" value="0">

                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">城市</label>
                <div class="layui-input-block">
                    <select class="district citys" name="citys" lay-filter="citys" value="0">

                    </select>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">内容</label>
                <div class="layui-input-block">
                    <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="content"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
    <%--<form method="post" action="/myPersonalWebsite_war_exploded/tripArticle/add">--%>
        <%--姓名:<input name="title">--%>
        <%--<br>--%>
        <%--年龄:<input name="id">--%>
        <%--<br>--%>
        <%--<input type="submit" value="提交">--%>
    <%--</form>--%>
    <%@ include file="../common/footer.jsp"%>

    <%--引入city模块--%>
    <script src="${pageContext.request.contextPath}/statics/js/Citys.js"></script>

<script>
    //三级联动插入数据
    // $(function () {

        // })
    let str = "";
    let contiArr = _CITY_;
    //添加几大洲的内容
    for (let i = 0, m = contiArr.length; i < m; i++) {

        str += `<option value="` + i + `">` + contiArr[i]["CountryName"] + `</option>`

    }
    // city[i]["CountryId"]

    $('.continent').append(str);

    layui.use(["jquery", "upload", "form", "layer", "element"], function () {
        // let upload = layui.upload;
        //
        // //执行实例
        // let uploadInst = upload.render({
        //     elem: '#headImg' //绑定元素
        //     ,url: '/upload/' //上传接口
        //     ,done: function(res){
        //         //上传完毕回调
        //     }
        //     ,error: function(){
        //         //请求异常回调
        //     }
        // });

        let $ = layui.$,
            element = layui.element,
            layer = layui.layer,
            upload = layui.upload,
            form = layui.form;

        element.init();
    })


    layui.use(['form', 'layedit', 'laydate', "upload"], function() {
        let form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , upload = layui.upload;

        //上传图片,必须放在 创建一个编辑器前面
        layedit.set({
            uploadImage: {
                url: '${pageContext.request.contextPath}/uploadFile' //接口url
                ,type: 'post' //默认post
            }
        });
        //创建一个编辑器
        let editIndex = layedit.build('content',{
                height:400
            }
        );
        //拖拽上传
        let uploadInst = upload.render({
            elem: '#headImg'
            , url: '${pageContext.request.contextPath}/uploadHeadImg'
            ,type: 'post' //默认post
            // , size: 500
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传成功
                if(res.code == 0){
                    // console.log(res.data.src);
                    $(".headImgInput").val(res.data.src);
                    //do something （比如将res返回的图片链接保存到表单的隐藏域）
                }else {
                    return layer.msg('上传失败');
                }

            }
            , error: function () {
                //演示失败状态，并实现重传

            }
        });
        //提交时把值同步到文本域中
        // form.verify({
        //     //content富文本域中的lay-verify值
        //     content: function(value) {
        //         return layedit.sync(index);
        //     }
        // });
        //三级联动
        let proArr
        let index1;
        form.on('select(continent)', function(data){

            $('.province option').detach();
            proArr  = contiArr[data.value].Province;
            index1 = data.value;
            let str2 = "";
            for (let i = 0, m = proArr.length; i < m; i++) {
                str2 += `<option value="` + i + `">` + proArr[i]["ProvinceName"] + `</option>`

            }

            $('.province').append(str2);
            form.render();

        })
        form.on('select(province)',function (data) {

            $('.citys option').detach();
            let cityArr = proArr[data.value].City;
            let str3 = "";

            if(index1 != 0){
                for (let i = 0, m = cityArr.length; i < m; i++) {
                    str3 += `<option value="` + i + `">` + cityArr[i]["Name"] + `</option>`;
                }
            }else {
                for (let i = 0, m = cityArr.length; i < m; i++) {
                    str3 += `<option value="` + i + `">` + cityArr[i]["CityName"] + `</option>`;

                }
            }
            // CityName

            $('.citys').append(str3);
            form.render();

        })
         form.verify({
            content:function () {
                layedit.sync(editIndex,uploadInst);
            }
        });










        //
        // form.on('submit(formDemo)', function(data){
        //     console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
        //     console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        //     console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        //     return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        // });

        $(window).on('load', function () {
            form.on('submit(formDemo)', function (data) {
                console.log(data)
                // return false;
                $.ajax({
                    url:'/myPersonalWebsite_war_exploded/tripArticle/add',
                    method:'post',
                    data:data.field,
                    dataType:'json',
                    success: function (res){
                    if (res.msg == "success") {
                        //应该增加一个弹窗类似的东西
                        // return false;
                        layer.msg("发表成功！");
                        layer.alert(res.msg, function (index) {
                            location.href = res.url;
                        })
                    } else {
                        layer.msg(res.msg);

                    }
                }
            })

            });
        });
    });



</script>


</body>
</html>



<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <!-- 引入layui -->
  <link rel="stylesheet" href="layui/css/layui.css">
  <script type="text/javascript" src="layui/layui.js"></script>
  <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>

</head>
<style type="text/css">
  .container {
    width: 420px;
    height: 320px;
    min-height: 320px;
    max-height: 320px;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    margin: auto;
    padding: 20px;
    z-index: 130;
    border-radius: 8px;
    background-color: #fff;
    box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
    font-size: 16px;
  }

  .close {
    background-color: white;
    border: none;
    font-size: 18px;
    margin-left: 410px;
    margin-top: -10px;
  }

  .layui-input {
    border-radius: 5px;
    width: 300px;
    height: 40px;
    font-size: 15px;
  }

  .layui-form-item {
    margin-left: -20px;
  }

  #logoid {
    margin-top: -16px;
    padding-left: 150px;
    padding-bottom: 15px;
  }

  .layui-btn {
    margin-left: -50px;
    border-radius: 5px;
    width: 350px;
    height: 40px;
    font-size: 15px;
  }

  .verity {
    width: 120px;
  }

  .font-set {
    font-size: 13px;
    text-decoration: none;
    margin-left: 120px;
  }

  a:hover {
    text-decoration: underline;
  }
</style>

<body>

<form class="layui-form" method="post">
  <div class="container">
    <button class="close" title="关闭">X</button>

    <fieldset class="layui-elem-field layui-field-title"
              style="margin-top: 20px;">
      <legend>蓝桥雇员管理系统用户注册</legend>
    </fieldset>


    <div class="layui-form-item">
      <label class="layui-form-label">用户名</label>
      <div class="layui-input-block">
        <input type="text" name="username" id="username" required lay-verify="required"
               placeholder="请输入用户名" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">密 &nbsp;&nbsp;码</label>
      <div class="layui-input-inline">
        <input type="password" name="password"  id="password" required
               lay-verify="required" placeholder="请输入密码" autocomplete="off"
               class="layui-input">
      </div>

    </div>
    <!-- 验证码  后续时间充足实现 -->
    <!-- <div class="layui-form-item">
        <label class="layui-form-label">验证码</label>
        <div class="layui-input-inline">
            <input type="text" name="title" required lay-verify="required"
                placeholder="请输入验证码" autocomplete="off" class="layui-input verity">
        </div>



    </div> -->
    <!-- 身份按钮 -->
    <%--        <div class="layui-form-item">--%>
    <%--            <label class="layui-form-label">身 &nbsp;&nbsp;份</label>--%>
    <%--            <div class="layui-input-block">--%>
    <%--                <input type="radio" name="role" value="学生" title="学生" checked="checked">--%>
    <%--                <input type="radio" name="role" value="管理员" title="管理员">--%>
    <%--                <input type="radio" name="role" value="超级管理员" title="超级管理员" >--%>
    <%--            </div>--%>
    <%--        </div>--%>

    <div class="layui-form-item">
      <div class="layui-input-block">
        <button  class="layui-btn" id="reg" lay-filter="btnSubmit" lay-submit type="button">注册</button>
      </div>
    </div>
    <div class="layui-input-block">
      <a href="index.jsp">已有账号？前往登陆</a>
    </div>

  </div>
</form>
<script type="text/javascript" src="layui/layui.js"></script>
<script>
  layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

    $(function (){
      $("#username").blur(function () {
        var username = $("#username").val();
        //$.get(请求路径，传递参数，回调函数，返回数据的类型)
        $.get("test?action=findOne",{"username":username},function (date) {
          if (date==='true'){
            alert("该用户名已存在！")
          }
        });
      })
      $("#reg").on("click", function() {
        var username = $("#username").val();
        var password = $("#password").val();
        $.post("test?action=reg", {"username": username, "password": password}, function(date) {
          console.log(date)
          if (date==='true') {
            alert("注册成功！");
            window.location.href = 'index.jsp';
          }else {
            alert("注册失败！");
          }
          return false;
        });
      });
    })


  });
</script>

</html>
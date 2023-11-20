<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="/js/jquery-3.6.0.min.js"></script>
</head>
<body>
    <form method="post">
        账号<input id="username">
        <a id="tishi"></a>
        <input type="button" value="登陆" id="login_get">
        <input type="button" value="登陆post" id="login_post">
        <input type="button" value="登陆load" id="login_load">
    </form>
    <script>
        $(function (){
            //get
            $("#login_get").on("click",function (){
                var username = $("#username").val();
                $.get("test?action=login",{"username":username},function (data){
                    if (data=="true"){
                        $("#tishi").html("账号存在")
                    }else {
                        $("#tishi").html("账号不存在")
                    }
                    return false;
                })
            })
            //post
            $("#login_post").on("click",function (){
                var username = $("#username").val();
                $.post("test?action=login",{"username":username},function (data){
                    if (data=="true"){
                        $("#tishi").html("账号存在")
                    }else {
                        $("#tishi").html("账号不存在")
                    }
                    return false;
                })
            })

            //load
            $("#login_load").click(function (){
                var username = $("#username").val();
                $("#tishi").load("test?action=login",{"username":username},function (data){
                    if (data=="true"){
                        $(this).html("账号存在")
                    }else {
                        $(this).html("账号不存在")
                    }
                    return false;
                })
            })
        })
    </script>
</body>
</html>
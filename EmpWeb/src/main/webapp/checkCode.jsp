<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.6.0.min.js"></script>
</head>
<body>
    <img src="<%=request.getContextPath()%>test?action=codeImgProduct" id="codeImg" alt="验证码加载中...">
    <a>看不清?点击图片刷新</a>
    <input id="codetest">
    <input type="button" id="btn" value="提交">
    <script>
        $(function (){
            $("#codeImg").on("click",function (){
                //获取时间
                let time = new Date().getTime();
                $(this).attr("src","<%=request.getContextPath()%>test?action=codeImgProduct&d="+time)
            })
            $("#btn").on("click",function (){
                var ct = $("#codetest").val();
                $.get("test?action=yanzhen",function (code){
                    if (ct==code){
                        alert("验证成功")
                    }else {
                        alert("验证码错误")
                    }
                })
            })
        })
    </script>
</body>
</html>

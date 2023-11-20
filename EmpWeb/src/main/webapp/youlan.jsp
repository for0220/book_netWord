<%--
  Created by IntelliJ IDEA.
  User: 02
  Date: 2023/11/16
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <script src="/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<input type="text" id="phone">
<input type="button" id="btn" value="发送短信">

<input type="text" id="yanzen">
<input type="button" id="btn2" value="验证短信">
<script>
  $(function (){
    $("#btn").on("click",function (){
      var phone = $("#phone").val();
      $.get("http://youlanjihua.com/youlanApi/v1/phonecode/send.php?secret={r0omrel5}&phone="+phone,
              function (data) {

              })
    })

    $("#btn2").on("click",function (){
      var yanzhen = $("#yanzen").val();
      $.get("http://youlanjihua.com/youlanApi/v1/phonecode/validate.php?secret=r0omrel5&requestId="+id+"&code="+yanzhen,
              function (msg) {
                alert(msg)
              })
    })
  })
</script>
</body>
</html>
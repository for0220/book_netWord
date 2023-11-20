<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>reg</title>
    <link rel="stylesheet"  type="text/css"  href="css/index.css"/>
</head>
<body>
   <div id="reg">
       <form action="reg" method="post">
           账号:<input name="user" type="text"><br>
           密码:<input name="psd" type="password"><br>
           <input type="submit" value="注册">
           <input type="reset" value="重置">
          <a href="login.jsp">已有账号，点击登陆</a>
       </form>

   </div>
</body>
</html>
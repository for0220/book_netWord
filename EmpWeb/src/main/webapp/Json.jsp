
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="/js/jquery-3.6.0.min.js"></script>
    <title>Title</title>
</head>
<body>
      <button id="btn">获取</button>
      <table  border="1">
          <tr id="table_tr">
                <td>id</td>
                <td>userName</td>
                <td>password</td>
          </tr>
      </table>
  <script>
      $(function (){
        $("#btn").on("click",function (){
          $.get("test?action=jsonServlet",function (data){
                let json_data = $.parseJSON(data);

                $.each(json_data,function (k,v){
                    $("#table_tr").after("<tr>"+
                    "<td>"+json_data[k].id+"</td>"+
                    "<td>"+json_data[k].userName+"</td>"+
                    "<td>"+json_data[k].password+"</td>"+
                "</tr>")
                })
          })
        })
      })

  </script>
</body>
</html>

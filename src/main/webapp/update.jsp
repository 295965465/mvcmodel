<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>修改页面</title>
    
	

  </head>
  
  <body>
    <form action="<%=path%>/userController/updateUser.do" method="post" style="text-align:center" >
    <input type="hidden" name="userid" value="${byuser.id}">
   账号：<input type="text" name="username" value="${byuser.name}"></input><br>
   密码 ：<input type="text" name="userpwd" value="${byuser.pwd}" /><br>
   <input type="submit" value="确定" />
   </form> <br>
  </body>
</html>

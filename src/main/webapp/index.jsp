<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dewell-UPS</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.4.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.4.5/themes/icon.css">
	<script type="text/javascript" src="<%=path%>/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="<%=path%>/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
	<script language="JavaScript">
		function myrefresh()
		{
			window.location.reload();
		}
		setTimeout('myrefresh()',10000*30); //指定1秒刷新一次
	</script>
	<script>
		$(function(){

			$("#datagrid").datagrid({

				url:'<%=path%>/userController/showLog.do',
				pagination:false,
				rownumbers:false,
				fitColumns:true,

				striped:false,
				nowrap: false,
				striped: false,
				collapsible: false,
				idField: 'id',
				remoteSort: false,
				columns:[[
					{field:'date',title:'Date',width:10},
					{field:'time',title:'time',width:10},
					{field:'vmin',title:'Vmin',width:9},
					{field:'vmax',title:'Vmax',width:9},
					{field:'vout',title:'Vout',width:9},
					{field:'lout',title:'lout',width:9},
					{field:'wout',title:'%Wout',width:9},
					{field:'freq',title:'Freq',width:9},
					{field:'cap',title:'%Cap',width:9},
					{field:'tupsC',title:'TupsC',width:9},
					{field:'vaout',title:'%Vaout',width:9},
					{field:'wout',title:'%Wout',width:9}

			]]





			});
		})
	</script>
</head>
<body>
	 <%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(d);
	%>

	 <h1>UPS-logs:<%=now%></h1>
	 <div id="datagrid" style="text-align:center;"> </div>
</body>
</html>
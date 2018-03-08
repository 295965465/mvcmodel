<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<%@ page import="com.dewell.cw.core.CWStaticParam"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/datatable-static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/datatable-static/datatables/datatables.min.css"/>

<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/datatable-static/datatables/DataTables-1.10.16/css/dataTables.jqueryui.css"/>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/datatable-static/bootstrap-select/dist/css/bootstrap-select.css">


<script type="text/javascript" src="<%= request.getContextPath()%>/jquery-easyui-1.4.5/jquery.easyui.min.js/jquery.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/datatable-static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/datatable-static/datatables/datatables.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/datatable-static/datatables/DataTables-1.10.16/js/dataTables.jqueryui.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/datatable-static/js/handlebars-v4.0.11.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/datatable-static/bootstrap-select/dist/js/bootstrap-select.js"></script>
<!--定义操作列按钮模板-->
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="btn btn-{{this.type}} btn-sm" onclick="{{this.fn}}" id="{{this.id}}">{{this.name}}</button>
    {{/each}}
</script>
</head>
<body>
</body>
</html>
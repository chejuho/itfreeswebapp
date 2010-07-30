<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="common.util.Util"%>
<html>
<script language="javascript">
	function start_index() {
		<%String actionName = (String)session.getAttribute("action");
		if(!Util.isEmpty(actionName)){
			%>window.location.href='<%=actionName%>';<%	
		} else {
			%>window.location.href="Index";<%	
		}
		%>
	}
</script>
<body  onload="start_index()">
</body>
</html>

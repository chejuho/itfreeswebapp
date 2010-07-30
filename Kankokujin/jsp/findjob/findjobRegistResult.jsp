<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="findjob.bean.FindjobSearchBean"%>
<%
	request.setCharacterEncoding("UTF-8");
	FindjobSearchBean findjobSearchBean = (FindjobSearchBean) request.getAttribute("FindjobSearchBean");
%>
<html>
<script language="javascript">
	function start_index() {
		document.list.action="FindjobSearch?re=9";
		document.list.submit(); 
		return true;
	}
</script>
<body  onload="start_index()">
	<form name="list" method="post" style="margin:0">
			<input type="hidden" name="user_id" value="<%=findjobSearchBean.getUser_id()%>">      						  
   			<input type="hidden" name="search" value="<%=findjobSearchBean.getSearch()%>">      			      			
   			<input type="hidden" name="search_range" value="<%=findjobSearchBean.getSearch_range()%>">      			      			
   			<input type="hidden" name="pageNum" value="<%=findjobSearchBean.getPageNum()%>">    
			<input type="hidden" name="pageSize" value="<%=findjobSearchBean.getPageSize()%>">          			      					 				      			  			  			      			
   			<input type="hidden" name="before" value="<%=findjobSearchBean.getBefore()%>">      			  			      			      						
	</form>
</body>
</html>

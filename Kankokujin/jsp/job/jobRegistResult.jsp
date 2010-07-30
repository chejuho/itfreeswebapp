<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="job.bean.JobSearchBean"%>
<%
	request.setCharacterEncoding("UTF-8");
JobSearchBean jobSearchBean = (JobSearchBean) request.getAttribute("JobSearchBean");
%>
<html>
<script language="javascript">
	function start_index() {
		document.list.action="JobSearch?re=9";
		document.list.submit(); 
		return true;
	}
</script>
<body  onload="start_index()">
	<form name="list" method="post" style="margin:0">
			<input type="hidden" name="user_id" value="<%=jobSearchBean.getUser_id()%>">      						  
	      	<input type="hidden" name="search_cate_code_1" value="<%=jobSearchBean.getCate_code_1()%>">
			<input type="hidden" name="search_cate_code_2" value="<%=jobSearchBean.getCate_code_2()%>">       		
			<input type="hidden" name="search_sex" value="<%=jobSearchBean.getSex()%>">          			      					 										
			<input type="hidden" name="pageNum" value="<%=jobSearchBean.getPageNum()%>"> 
			<input type="hidden" name="pageSize" value="<%=jobSearchBean.getPageSize()%>">          			      					 				
   			<input type="hidden" name="search" value="<%=jobSearchBean.getSearch()%>">      			      			
   			<input type="hidden" name="search_range" value="<%=jobSearchBean.getSearch_range()%>">      			      			
   			<input type="hidden" name="before" value="<%=jobSearchBean.getBefore()%>">  
	</form>
</body>
</html>

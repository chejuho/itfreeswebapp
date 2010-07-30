<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="gourmet.bean.GourmetSearchBean"%>
<%
	request.setCharacterEncoding("UTF-8");
	GourmetSearchBean gourmetSearchBean = (GourmetSearchBean) request.getAttribute("GourmetSearchBean");
%>
<html>
<script language="javascript">
	function start_index() {
		document.list.action="GourmetSearch?re=9";
		document.list.submit(); 
		return true;
	}
</script>
<body  onload="start_index()">
	<form name="list" method="post" style="margin:0">
			<input type="hidden" name="user_id" value="<%=gourmetSearchBean.getUser_id()%>">      						  
	      	<input type="hidden" name="search_cate_code_1" value="<%=gourmetSearchBean.getCate_code_1()%>">
			<input type="hidden" name="search_cate_code_2" value="<%=gourmetSearchBean.getCate_code_2()%>">       		
   			<input type="hidden" name="search_line_code" value="<%=gourmetSearchBean.getLine_code()%>">      			
   			<input type="hidden" name="search_station_code" value="<%=gourmetSearchBean.getStation_code()%>">      			      			
   			<input type="hidden" name="search_area_code_1" value="<%=gourmetSearchBean.getArea_code_1()%>">      			      			      			
   			<input type="hidden" name="search_area_code_2" value="<%=gourmetSearchBean.getArea_code_2()%>">      			      						
			<input type="hidden" name="pageNum" value="<%=gourmetSearchBean.getPageNum()%>"> 
			<input type="hidden" name="pageSize" value="<%=gourmetSearchBean.getPageSize()%>">          			      					 				
   			<input type="hidden" name="search" value="<%=gourmetSearchBean.getSearch()%>">      			      			
   			<input type="hidden" name="search_range" value="<%=gourmetSearchBean.getSearch_range()%>">      			      			
   			<input type="hidden" name="before" value="<%=gourmetSearchBean.getBefore()%>">  
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="store.bean.StoreSearchBean"%>
<%@page import="common.constant.Const"%>
<%
	request.setCharacterEncoding("UTF-8");
	StoreSearchBean storeSearchBean = (StoreSearchBean) request.getAttribute("StoreSearchBean");
%>
<html>
<script language="javascript">
	function start_index() {
		document.list.action="StoreSearch?re=9";
		document.list.submit(); 
		return true;
	}
</script>
<body  onload="start_index()">
	<form name="list" method="post" style="margin:0">
				<input type="hidden" name="user_id" value="<%=storeSearchBean.getUser_id()%>">      			
			    <input type="hidden" name="search_cate_code_1" value="<%=storeSearchBean.getCate_code_1()%>">
      			<input type="hidden" name="search_cate_code_2" value="<%=storeSearchBean.getCate_code_2()%>">
      			<input type="hidden" name="pageSize" value="<%=storeSearchBean.getPageSize()%>">      			
      			<input type="hidden" name="pageNum" value="<%=storeSearchBean.getPageNum()%>">      			  			      			      			
      			<input type="hidden" name="search_line_code" value="<%=storeSearchBean.getLine_code()%>">      			
      			<input type="hidden" name="search_station_code" value="<%=storeSearchBean.getStation_code()%>">      			      			
      			<input type="hidden" name="search_area_code_1" value="<%=storeSearchBean.getArea_code_1()%>">      			      			      			
      			<input type="hidden" name="search_area_code_2" value="<%=storeSearchBean.getArea_code_2()%>">      			      			
      			<input type="hidden" name="search" value="<%=storeSearchBean.getSearch()%>">      			      			
      			<input type="hidden" name="decodedSearch" value="<%=storeSearchBean.getDecodedSearch()%>">      			      			
      			<input type="hidden" name="search_range" value="<%=storeSearchBean.getSearch_range()%>">      			      			
      			<input type="hidden" name="before" value="<%=storeSearchBean.getBefore()%>">    
	</form>
</body>
</html>

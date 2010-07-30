<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="buysell.bean.BuySellSearchBean"%>
<%@page import="common.constant.Const"%>
<%
	request.setCharacterEncoding("UTF-8");
	BuySellSearchBean buySellSearchBean = (BuySellSearchBean) request.getAttribute("BuySellSearchBean");
%>
<html>
<script language="javascript">
	function start_index() {
		document.list.action="BuySellList?re=9";
		document.list.submit(); 
		return true;
	}
</script>
<body  onload="start_index()">
	<form name="list" method="post" style="margin:0">
		<input type="hidden" name="user_id" value="<%=buySellSearchBean.getUser_id()%>">      	
      	<input type="hidden" name="search_cate_code_1" value="<%=buySellSearchBean.getCate_code_1()%>">		
      	<input type="hidden" name="search_cate_code_2" value="<%=buySellSearchBean.getCate_code_2()%>">		      	
		<input type="hidden" name="search_pro_status" value="<%=buySellSearchBean.getPro_status()%>">      			
		<input type="hidden" name="search_free_price" value="<%=buySellSearchBean.getFree_price()%>">      			      			      			
		<input type="hidden" name="search_member_sort" value="<%=buySellSearchBean.getMember_sort()%>">      			      			      			
		<input type="hidden" name="search_free_price" value="<%=buySellSearchBean.getFree_price()%>">      			      			      			
		<input type="hidden" name="search_sold_out" value="<%=buySellSearchBean.getSold_out()%>">      			      			
		<input type="hidden" name="search_send_method" value="<%=buySellSearchBean.getSend_method()%>">      			      			      			
		<input type="hidden" name="search_range" value="<%=buySellSearchBean.getSearch_range()%>">      			      			      			
		<input type="hidden" name="search" value="<%=buySellSearchBean.getSearch()%>">      			      			
		<input type="hidden" name="decodedSearch" value="<%=buySellSearchBean.getDecodedSearch()%>">      			      			
		<input type="hidden" name="pageNum" value="<%=buySellSearchBean.getPageNum()%>">      			  			      			
		<input type="hidden" name="pageSize" value="<%=buySellSearchBean.getPageSize()%>">      			  			      			      			
		<input type="hidden" name="before" value="<%=buySellSearchBean.getBefore()%>">      			  			      			      						      	
 		<input type="hidden" name="list_view" value="<%=buySellSearchBean.getList_view()%>">       			        			      			 						
	</form>
</body>
</html>

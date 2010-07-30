<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="roomsell.bean.RoomSearchBean"%>
<%
	request.setCharacterEncoding("UTF-8");
	RoomSearchBean roomSearchBean = (RoomSearchBean) request.getAttribute("RoomSearchBean");
%>
<html>
<script language="javascript">
	function start_index() {
		document.list.action="RoomSellList?re=9";
		document.list.submit(); 
		return true;
	}
</script>
<body  onload="start_index()">
	<form name="list" method="post" style="margin:0">
				<input type="hidden" name="cate_code_1" value="<%=roomSearchBean.getCate_code_1()%>">				
				<input type="hidden" name="user_id" value="<%=roomSearchBean.getUser_id()%>">      				
      			<input type="hidden" name="search_line_code" value="<%=roomSearchBean.getLine_code()%>">      			
      			<input type="hidden" name="search_station_code" value="<%=roomSearchBean.getStation_code()%>">      			      			
      			<input type="hidden" name="search_area_code_1" value="<%=roomSearchBean.getArea_code_1()%>">      			      			      			
      			<input type="hidden" name="search_area_code_2" value="<%=roomSearchBean.getArea_code_2()%>">      			      			
				<input type="hidden" name="pageSize" value="<%=roomSearchBean.getPageSize()%>">          			      					 				      			
      			<input type="hidden" name="pageNum" value="<%=roomSearchBean.getPageNum()%>">      			  			      			
      			<input type="hidden" name="before" value="<%=roomSearchBean.getBefore()%>">      			  			      			      						
      			<input type="hidden" name="room_fee_from" value="<%=roomSearchBean.getRoom_fee_from()%>">       			      			      			      			
      			<input type="hidden" name="room_fee_to" value="<%=roomSearchBean.getRoom_fee_to()%>">       			      			      			      			
      			<input type="hidden" name="room_sort_0" value="<%=roomSearchBean.getRoom_sort()[0]%>">       			      			      			      			
      			<input type="hidden" name="room_sort_1" value="<%=roomSearchBean.getRoom_sort()[1]%>">           			      			      			      			
      			<input type="hidden" name="room_sort_2" value="<%=roomSearchBean.getRoom_sort()[2]%>">           			      			      			      			
      			<input type="hidden" name="room_sort_3" value="<%=roomSearchBean.getRoom_sort()[3]%>">           			      			      			      			
      			<input type="hidden" name="room_sort_4" value="<%=roomSearchBean.getRoom_sort()[4]%>">            			      			      			      			
      			<input type="hidden" name="room_sort_5" value="<%=roomSearchBean.getRoom_sort()[5]%>">            			      			      			      			
      			<input type="hidden" name="room_sort_6" value="<%=roomSearchBean.getRoom_sort()[6]%>">            			      			      			      			
      			<input type="hidden" name="room_sort_7" value="<%=roomSearchBean.getRoom_sort()[7]%>">          			      			      			      			
      			<input type="hidden" name="room_sort_8" value="<%=roomSearchBean.getRoom_sort()[8]%>">         			      			      			      			
      			<input type="hidden" name="room_sort_9" value="<%=roomSearchBean.getRoom_sort()[9]%>">        			      			      			      			
      			<input type="hidden" name="room_sort_10" value="<%=roomSearchBean.getRoom_sort()[10]%>">        			      			      			      			
      			<input type="hidden" name="search_sex" value="<%=roomSearchBean.getSex()%>"> 
      			<input type="hidden" name="search_room_type" value="<%=roomSearchBean.getRoom_type()%>"> 
      			<input type="hidden" name="search_regist_date" value="<%=roomSearchBean.getRegist_date()%>"> 
      			<input type="hidden" name="search_build_sort" value="<%=roomSearchBean.getBuild_sort()%>">       			      			      			      			
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page session ="true" %>
<% request.setCharacterEncoding("UTF-8");%>

<%@ page import="dbhandler.RoomSellHandler" %>


<%
	RoomSellHandler hsh = new RoomSellHandler();

	int user_id = Integer.parseInt(request.getParameter("id"));
	boolean result=hsh.delete(user_id);
	if (result){
	 
	%>
		<script language="javascript">
			location.href="roomSellList.jsp";
		</script>
	<%} else {%>
		<script language="javascript">
			alert("fail to delete room sell info");
			location.href="roomSellList.jsp";
		</script>
	<%}
%>

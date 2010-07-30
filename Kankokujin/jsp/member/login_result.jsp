<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="common.util.Util, common.bean.MemberBean"%>
<html>
<script language="javascript">
	function start_index() {
		<%String actionName = (String)session.getAttribute("action");
		MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
		if(!Util.isEmpty(actionName)){
			actionName = actionName.replaceAll("&user_id=", "&user_id="+memberBean.getUserid());				
			%>window.location.href='<%=actionName%>';<%				
		} else {
			%>window.location.href="Index";<%	
		}%>
	}
</script>
<body  onload="start_index()">
</body>
</html>

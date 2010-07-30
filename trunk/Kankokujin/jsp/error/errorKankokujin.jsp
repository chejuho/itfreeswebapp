<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ page import="common.util.Util"%>	
<%
 response.setStatus(HttpServletResponse.SC_OK);
 request.setCharacterEncoding("UTF-8");
 String message = (String)Util.changeNullStr(session.getAttribute("Message"));
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>KankokujinError</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<!-- スタイルシート追加 START▼ -->
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
<!-- ▲END スタイルシート追加 -->
</head>

<body> 
<%=message%>
<table border="0" cellpadding="0" cellspacing="0" width="960" align="center">

<!----- top메뉴 ------>
		<tr valign="top">
			<td colspan="3">
				<jsp:include page="../include/top.jsp" flush="true"/>
			</td>
		</tr>
<!----- top메뉴 ------>
 		<tr>
 			<td align="center">管理者にお問い合わせください。</td>
 		</tr>
 		<tr>
 			<td align="center">(<%=exception.getMessage() %>)</td>
 		</tr>
 </table>
</body>
</html>
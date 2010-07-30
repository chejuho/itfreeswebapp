<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr" %>
<%@page import="common.constant.Const"%>
<%
request.setCharacterEncoding("euc-kr");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><%=Const.PAGE_MAIN_TITLE%></title>
<meta http-equiv="Content-type" content="text/html; charset=euc-kr">
<script language="javascript" src="./include/js/mypot.js"></script>
<script language="javascript" src="/Share/Function.js"></script>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="../include/css/kankokujin.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style3 {font-size: 12px}
.text {
	line-height: 8px;
}
-->
</style>
</head>

<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center">

<!----- top메뉴 ------>
<tr valign="top">
	<td colspan="5">
	<jsp:include page="../include/top.jsp" flush="true"/>
			</td>
</tr>
<!----- top메뉴 ------>


<!----- 콘텐츠 영역 ----->
<tr>
	
	<!-- 좌측메뉴 -->
	<td width="197" valign="top">
	<jsp:include page="../include/left.jsp" flush="true"/>
        </td>
	<!-- 좌측메뉴 -->


	<!-- 콘텐츠간 간격 -->
	<td width="10">&nbsp;</td>
	<!-- 콘텐츠간 간격 -->


	<!-- 메인 바디 -->
	<td valign="top">
	
	<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
	
    </td>
	<!-- 메인 바디 -->


	<!-- 콘텐츠간 간격 -->
	<td width="10">&nbsp;</td>
	<!-- 콘텐츠간 간격 -->


	<!-- 우측콘텐츠 -->
	
	<td width="186" valign="top">
	<jsp:include page="../include/right.jsp" flush="true"/>
      <!-- 포토플레이어 -->      <!----- 스폐셜 ----->	</td>
	<!-- 우측콘텐츠 -->
</tr>

<!----- 콘텐츠 영역 ----->


<tr height="40">
	<td colspan="5"></td>
</tr>


<!----- Footer 영역 ----->

<tr valign="top">
	<td colspan="5">
		<jsp:include page="../include/footer.jsp" flush="true"/>
</td>
</tr>
<!----- Footer 영역 ----->
</table>
</body>
</html>
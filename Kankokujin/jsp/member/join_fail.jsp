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

<!----- top�޴� ------>
<tr valign="top">
	<td colspan="5">
	<jsp:include page="../include/top.jsp" flush="true"/>
			</td>
</tr>
<!----- top�޴� ------>


<!----- ������ ���� ----->
<tr>
	
	<!-- �����޴� -->
	<td width="197" valign="top">
	<jsp:include page="../include/left.jsp" flush="true"/>
        </td>
	<!-- �����޴� -->


	<!-- �������� ���� -->
	<td width="10">&nbsp;</td>
	<!-- �������� ���� -->


	<!-- ���� �ٵ� -->
	<td valign="top">
	
	<!-- ���⿡ ���� ���� �ٵ� �ҽ��ڵ��� ���ּ���. -->
	
    </td>
	<!-- ���� �ٵ� -->


	<!-- �������� ���� -->
	<td width="10">&nbsp;</td>
	<!-- �������� ���� -->


	<!-- ���������� -->
	
	<td width="186" valign="top">
	<jsp:include page="../include/right.jsp" flush="true"/>
      <!-- �����÷��̾� -->      <!----- ����� ----->	</td>
	<!-- ���������� -->
</tr>

<!----- ������ ���� ----->


<tr height="40">
	<td colspan="5"></td>
</tr>


<!----- Footer ���� ----->

<tr valign="top">
	<td colspan="5">
		<jsp:include page="../include/footer.jsp" flush="true"/>
</td>
</tr>
<!----- Footer ���� ----->
</table>
</body>
</html>
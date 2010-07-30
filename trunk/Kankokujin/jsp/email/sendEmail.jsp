<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="common.bean.MemberBean"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%

MemberBean member = (MemberBean) session.getAttribute("memberInfo");
String toId = (String)request.getAttribute("toId");
String toName = (String)request.getAttribute("toName");
%>

<html>
<title>캉코쿠진닷컴</title>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
window.focus();

	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function sendMail(ff){	
	
		if(isNull(ff.subject)) {
				alert("제목을 입력해 주세요.");
				return false;
			}
		if(isNull(ff.contents)) {
				alert("내용을 입력해 주세요.");
				return false;
			}			
		
		if(confirm("메일을 전송하시겠습니까?")){							
			ff.action="SendMail";
			ff.submit(); 
			window.close();
			return true;
			}
	}
//-->
</script>
</head>
<body>
<form name="ff"method="post">
<table cellpadding="6" cellspacing="0" border="0" bgcolor="#ffffff">
	<tr>
		<td colsapn="2" width="100">■메일보내기</td>
	</tr>
	<tr>
		<td width="20%" bgcolor="#f0f0f0" align="center">받는이</td>
		<td width="80%"><%=toName %></td>
	</tr>
	<tr>
		<td height="1" colspan="2" bgcolor="#e1e1e1"></td>
	</tr>
	<tr>
		<td bgcolor="#f0f0f0" align="center">제목</td>
		<td>
			<input name="subject" type="text" size="70" value=""style="width: 540px" />
			<input name="fromId" type="hidden" size="70" value="<%=member.getUserid() %>"style="width: 540px" />
			<input name="toId" type="hidden" size="70" value="<%=toId %>"style="width: 540px" /></td>
	</tr>
	<tr>
		<td height="1" colspan="2" bgcolor="#e1e1e1"></td>
	</tr>
	<tr>
		<td bgcolor="#f0f0f0" align="center">내용</td>
		<td><textarea name="contents" rows="17" cols="60" style="width: 540px"></textarea>
		</td>
	</tr>
</table>
<table cellpadding="6" cellspacing="0" border="0" bgcolor="#ffffff" width="100%">
	<tr align="right">
		<td><img src="jsp/images/common/btn_cs_ok.gif" onclick='return sendMail(ff)'>
		<img src="jsp/images/common/btn_cs_cancel.gif" onclick='window.close()'">
		</td>
	</tr>
</table>
</form>
</body>
</html>
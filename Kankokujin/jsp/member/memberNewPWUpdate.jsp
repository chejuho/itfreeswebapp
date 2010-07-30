<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
request.setCharacterEncoding("UTF-8");


	String userid= (String)request.getAttribute("userid");
	String password = (String)request.getAttribute("password");

	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><c:out value="비밀번호변경"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
window.onload=messageCheck;
	/** ERROR메세지 처리  */
	 function messageCheck() {
		var message = document.getElementById("msg").value;
		if (message) {
			if (message == 'WAR0007'){
				
				alert("<fmt:message key="WAR0007" bundle="${message}"/>");
		
			} 
		}
	}
	function sellcheck(f) {
	if(f.newPassword.value==""){
		alert("새비밀번호를 입력하세요.");
		f.newPassword.focus();
		return;
	}
	if(f.rePassword.value==""){
		alert("새비밀번호확인을 입력하세요.");
		f.rePassword.focus();
		return;
	}
	if(f.newPassword.value != f.rePassword.value) {
		alert("비밀번호가 일치하지 않습니다.");
		return;
   	}
   	if(f.newPassword.value.length < 4) {
		alert("비밀번호를 4자리 이상으로 입력하세요.");
		return;
   	}
   	if(f.newPassword.value.length > 12) {
		alert("비밀번호를 12자리 이하로 입력하세요.");
		return;
   	}
   	if(!pwdcheck(f.newPassword.value)) {
		alert("비밀번호에 영문,숫자 이외의 문자가 있으면 안됩니다!");
		return;
	}
		f.action="MemberNewPWUpdate";
		f.submit(); 
	             

	}
	
//-->
</script>
</head>

<body style="margin:0 0 0 0">
	<table>
	<jsp:include page="../include/top.jsp" flush="true" />
	<tr>
		<td height="20">&nbsp;</td>
	</tr>
	<tr>
		<td>
			<form name="wf" method="post">	
			<input type="hidden" id="msg" name = "msg" value="<c:out value="${Message}"/>" />
			<input type="hidden" name="userid" value="${userid}">
			<input type="hidden" name="tmppassword" value="${password}">
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top"><img src="jsp/images/new/9_title.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#ebebeb" style="padding:11px 11px 11px 11px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td width="27%" bgcolor="#f7f7f7" class="table-title-text">새 비밀번호</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text"><input type="password" name="newPassword" id="textfield2"  style="width:150px;"/>&nbsp;&nbsp;(4~12 영문, 숫자 가능)</td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">새 비밀번호 확인</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text"><input type="password" name="rePassword" id="textfield3"  style="width:150px;"/>&nbsp;&nbsp;(4~12 영문, 숫자 가능)</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" valign="top">
					<a href="javascript:sellcheck(wf);"><img src="jsp/images/new/ok_b.gif" width="117" height="36" /></a>&nbsp;</td>
			</tr>
			</table>
			</form>
		</td>
	</tr>
	<tr>
		<td height="50">&nbsp;</td>
	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
</body>
</html>

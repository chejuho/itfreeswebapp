<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<script type="text/javascript">
<!--
window.onload=messageCheck;
	/** ERROR메세지 처리  */
	 function messageCheck() {
		var message = document.getElementById("msg").value;
		if (message) {
			if (message == 'WAR0005'){
				
				alert("<fmt:message key="WAR0005" bundle="${message}"/>");
		
			} 
			if (message == 'WAR0004'){
				
				alert("<fmt:message key="WAR0004" bundle="${message}"/>");
		
			} 
		}
		
	}
	function sellcheck(f) {
		if(f.password.value==""){
			alert("비밀번호를 입력하세요.");
			f.password.focus();
			return false;
	   	}else{
		   	if(confirm("탈퇴하시겠습니까?")){
			   f.action="MemberDelete";
			   f.submit(); 
			}
	   	}
	}
//-->
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="common.util.Util"%>
<html>
<head>
<title><c:out value="회원탈퇴"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">

</head>

<body style="margin:0 0 0 0">
	<table>
	<jsp:include page="../include/top.jsp" flush="true" />
	<tr>
		<td height="20">&nbsp;</td>
	</tr>
	<tr>
		<td>
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<input type="hidden" id="msg" name = "msg" value="<c:out value="${Message}"/>" />
			<form name="wf" method="post">
			<tr>
				<td valign="top"><img src="jsp/images/new/memdelete_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<table border="0" cellspacing="0" cellpadding="0" width="100%" align="center" height="20">
					<tbody>
					<tr>
						<td width="3%" align="left" valign="top"><img src="jsp/images/new/memdelete_icon1.gif"  align=""width="19" height="16" /></td>
						<td width="9%" align="left" valign="top"><strong class="red-text-w">주의사항</strong></td>
						<td width="88%" align="left" valign="top">탈퇴하신 후에 해당 아이디와 이메일 주소로는 재가입이 불가능합니다.<br />
							또한 등록하셨던 모든글들은 삭제 처리되므로 이점 유의   하시기 바랍니다.
						</td>
					</tr>
					</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td height="8" valign="top"></td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#ebebeb" style="padding:11px 11px 11px 11px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td width="27%" bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>아이디</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${memberInfo.userid}"/></td>
								<input type="hidden" name="userid" value="<c:out value="${memberInfo.userid}"/>" >
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>비밀번호</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="password" name="password" style="width:150px;"/></td>
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
					<a href="javascript:sellcheck(wf)"><img src="jsp/images/new/ok_b.gif" width="117" height="36" /></a>&nbsp;
					<a href="MemberDetail"><img src="jsp/images/new/cancel_b.gif" width="118" height="36" /></a></td>
			</tr>
			</form>
			</table>
		</td>
	</tr>
	<tr>
		<td height="50">&nbsp;</td>
	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
</body>
</html>

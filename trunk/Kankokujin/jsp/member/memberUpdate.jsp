<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.constant.Const"%>
<%@page import="common.util.Util"%>
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
		ED = /^[0-9]{1,4}/;	
		if(f.password.value==""){
			alert("비밀번호를 입력하세요.");
			f.password.focus();
			return;
	   	}else if(f.newPassword.value != f.rePassword.value) {
			alert("새 비밀번호가 일치하지 않습니다.");
			return;
		}else if(f.name.value==""){
			alert("닉네임을 입력하세요.");
			f.name.focus();
			return;
		} else if(!isNickNameCheck(f.name)) {
			alert("닉네임이 형식에 맞지 않습니다.");
			return;
		} else if(!isNull(f.telephone1) || !isNull(f.telephone2) || !isNull(f.telephone3)) {
	
			if(!ED.test(f.telephone1.value) || !ED.test(f.telephone2.value) ||!ED.test(f.telephone3.value)){
				alert("전화번호1이 전화번호 형식에 맞지 않습니다. ");
				return;
			}
		} 
		if(!isNull(f.mobile1) || !isNull(f.mobile2) || !isNull(f.mobile3)) {
	
			if(!ED.test(f.mobile1.value) || !ED.test(f.mobile2.value) ||!ED.test(f.mobile3.value)){
				alert("전화번호2가 전화번호 형식에 맞지 않습니다. ");
				return;
			}			
	   	}
	   f.action="MemberUpdate";
	   f.submit(); 
	}
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function isIdShort(obj) {
		var str = obj.value;
		if(str.length < 4 || str.length > 12) {
			return false;
		}
		return true;		
	}
//-->
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><c:out value="회원정보수정"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
				<td valign="top"><img src="jsp/images/new/memupgrade_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">※ 필수항목 (<span class="red-text-w">*</span>표시) 만 입력해도 가능합니다. <br />
				&nbsp;&nbsp;&nbsp; 선택항목을 입력하면 보다 편리한 서비스를 이용하실 수 있습니다.</td>
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
								<td width="27%" bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span> 아이디</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${memberInfo.userid}"/></td>
								<input type="hidden" name="userid" value="<c:out value="${memberInfo.userid}"/>" >
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span> 현재비밀번호</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text"><input type="password" name="password" style="width:150px;"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">새비밀번호</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text"><input type="password" name="newPassword" style="width:150px;"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">새비밀번호확인</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text"><input type="password" name="rePassword" style="width:150px;" /></td>
							</tr>

							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>닉네임</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="name" value="<c:out value="${memberInfo.name}"/>" maxlength="20" style="width:280px;"/>&nbsp;&nbsp;(2~20자한글, 영문, 숫자 가능)</td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">전화번호1</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="telephone1" type="text" value="<c:out value="${memberInfo.telephone1}"/>" maxlength="4" class="idForm" style="width:50px;" />
									-
									<input name="telephone2" type="text" value="<c:out value="${memberInfo.telephone2}"/>" maxlength="4" class="idForm" style="width:50px;" />
									-
									<input name="telephone3" type="text" value="<c:out value="${memberInfo.telephone3}"/>" maxlength="4" class="idForm" style="width:50px;" /></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">전화번호2</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="mobile1" type="text" value="<c:out value="${memberInfo.mobile1}"/>" maxlength="4" class="idForm" style="width:50px;" />
									-
									<input name="mobile2" type="text" value="<c:out value="${memberInfo.mobile2}"/>" maxlength="4" class="idForm" style="width:50px;" />
									-
									<input name="mobile3" type="text" value="<c:out value="${memberInfo.mobile3}"/>" maxlength="4" class="idForm" style="width:50px;" /></td>
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

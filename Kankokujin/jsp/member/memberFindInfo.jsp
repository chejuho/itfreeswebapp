<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.constant.Const"%>
<%@page import="common.util.Util"%>
<%@page import="common.bean.MemberBean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><c:out value="아이디/비밀번호 찾기"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script language="javascript">
    /** ERROR메세지 처리  */
	 function messageCheck() {
		var message = document.getElementById("msg").value;
		if (message) {
			if (message == 'MSG0009'){
				
				alert("<fmt:message key="MSG0009" bundle="${message}"/>");
		
			} else if (message == 'MSG0010'){
					
				alert("<fmt:message key="MSG0010" bundle="${message}"/>");
			
			} else if (message == 'MSG0014'){
					
				alert("<fmt:message key="MSG0014" bundle="${message}"/>");
			
			} else if (message == 'ERR0008'){
					
				alert("<fmt:message key="ERR0008" bundle="${message}"/>");
			
			}
		}
	}
	
	function submitSearchID(frm1) {
		if(frm1.username.value==""){
			alert("이름을 입력하세요.");
			frm1.username.focus();
			return;
		}else if(frm1.email1.value==""){
			alert("메일주소1을 입력하세요.");
			frm1.email1.focus();
			return;
		}else if(frm1.email2.value==""){
			alert("메일주소2을 입력하세요.");
			frm1.email2.focus();
			return;
		}else if(!isEmail(frm1.email2)) {
			alert("이메일 주소가 적절하지 않습니다.");
			frm1.email2.focus();
			return;
	   	}
		frm1.action="MemberFindInfo";
		frm1.submit(); 	   	  
	}
	
	function submitSearchPW(frm2) {
		if(frm2.userid.value==""){
			alert("아이디를 입력하세요.");
			frm2.userid.focus();
			return;
		}else if(frm2.email1.value==""){
			alert("메일주소1을 입력하세요.");
			frm2.email1.focus();
			return;
		}else if(frm2.email2.value==""){
			alert("메일주소2을 입력하세요.");
			frm2.email2.focus();
			return;
		}else if(!isEmail(frm2.email2)) {
			alert("이메일 주소가 적절하지 않습니다.");
			frm2.email2.focus();
			return;
	   	}
		frm2.action="MemberFindInfo";
		frm2.submit(); 	   	  
	}

	   	
	function isEmail(obj) {
		var str = obj.value;
		
		if(str == "")
			return false;
				
		var i = str.indexOf(".");
		if(i<0)
			return false;
			
		return true;	
	}
window.onload=messageCheck;
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
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<input type="hidden" id="msg" name = "msg" value="<c:out value="${Message}"/>" /> 
			<tr>
				<td valign="top"><img src="jsp/images/new/memfindinfo_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td height="88" valign="middle" background="jsp/images/new/memfindinfo_box_bg.gif" class="memfindinfo-text1"  style="padding-left:70px;">
					비밀번호 찾기는 받으시는 메일에 따라서 수신이 안되는 경우도 있습니다.<br />
  					메일을 받을수 없는 회원님들은 문의하기로 관리자에게 문의해 주세요.  <br />
  				</td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top"><img src="jsp/images/new/memfindinfo_s_tit1.gif" width="736" height="36" /></td>
			</tr>
			<tr>
				<td height="1" valign="top"></td>
			</tr>
			<tr>
				<td height="60" valign="middle" bgcolor="#ddf3fe" style="padding-left:20px;">
					<span class="blue-text-w"><strong>&raquo; </strong></span>
					<span class="red-text-w"><strong>아이디</strong></span><strong class="blue-text-w">를 분실하셨나요?</strong><br />
					<span class="blue-text-w"><strong>&raquo;</strong></span><strong> 닉네임</strong>과 <strong>이메일주소</strong>를 정확하게 입력해 주세요. </td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<form name="frm1" method="post">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#ebebeb" style="padding:11px 11px 11px 11px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td width="27%" bgcolor="#f7f7f7" class="table-title-text">닉네임</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="username" value="<c:out value="${IDBean.name}"/>" id="textfield3"  style="width:150px;"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">이메일주소</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" valign="top">
											<input type="text" name="email1" value="<c:out value="${IDBean.email1}"/>" id="textfield8" style="width:150px;" />
											@
											<input type="text" name="email2" value="<c:out value="${IDBean.email2}"/>" id="textfield9" style="width:150px;"/></td>
									</tr>
									<tr>
										<td valign="bottom">- 회원등록시 기입하셨던 이메일 주소로 아이디를 발송해 드립니다. </td>
									</tr>
									</table>
								</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
					</form>
				</td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" valign="top"><a href="javascript:submitSearchID(frm1)"><img src="jsp/images/new/ok_b.gif" width="117" height="36" /></a></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top"><img src="jsp/images/new/memfindinfo_s_tit2.gif" width="736" height="36" /></td>
			</tr>
			<tr>
				<td height="1" valign="top"></td>
			</tr>
			<tr>
				<td height="60" align="left" valign="middle" bgcolor="#ddf3fe" style="padding-left:20px;">
					<span class="blue-text-w"><strong>&raquo; </strong></span>
					<span class="red-text-w"><strong>비밀번호</strong></span><strong class="blue-text-w">를 분실하셨나요?</strong><br />
					<span class="blue-text-w"><strong>&raquo;</strong></span><strong> 아이디</strong>과 <strong>이메일주소</strong>를 정확하게 입력해 주세요. </td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<form name="frm2" method="post">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#ebebeb" style="padding:11px 11px 11px 11px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td width="27%" bgcolor="#f7f7f7" class="table-title-text">아이디</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
								<input type="text" name="userid" value="<c:out value="${PWBean.userid}"/>" id="textfield2"  style="width:150px;"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">이메일주소</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" valign="top">
											<input type="text" name="email1" value="<c:out value="${PWBean.email1}"/>" id="textfield4" style="width:150px;" />
							    			@
							  				<input type="text" name="email2" value="<c:out value="${PWBean.email2}"/>" id="textfield5" style="width:150px;"/></td>
									</tr>
									<tr>
										<td valign="bottom">- 회원등록시 기입하셨던 이메일 주소로 임시비밀번호를 발송해 드립니다. </td>
									</tr>
									</table>
								</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
					</form>
				</td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" valign="top">
					<a href="javascript:submitSearchPW(frm2)"><img src="jsp/images/new/ok_b.gif" width="117" height="36" /></a></td>
			</tr>
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
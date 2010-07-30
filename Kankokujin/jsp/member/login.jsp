<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean" %>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<html>
<head>
<title><c:out value="회원로그인"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
			if (message == 'MSG0008'){
				
				alert("<fmt:message key="MSG0008" bundle="${message}"/>");
		
			} else if (message == 'WAR0003'){
					
				alert("<fmt:message key="WAR0003" bundle="${message}"/>");
			
			} else if (message == 'WAR0004'){
					
				alert("<fmt:message key="WAR0004" bundle="${message}"/>");
			
			}
		}
	}
	function loginform_clearbg(type) {
		if (type == "id") {
			document.lf.id.style.backgroundImage = '';
		} else if (type == "pw") {
			document.lf.pw.style.backgroundImage = '';
		}
	}
	function loginform_bgChange(obj, act) {
		if ( act == 'F') {
			obj.className = 'login';
			obj.style.backgroundColor='#FFFFFF';
		} else {
			obj.className = 'login';
			obj.style.backgroundColor='#FFFFFF';	
		}			
	}
	function logout(f) {		
		f.action="MemberLogout";
		f.submit();		
	}
	function login(f) {
		if(f.id.value==""){
			alert("아이디를 입력하세요.");
			f.id.focus();
			return;
		}else if(f.pw.value==""){
			alert("비밀번호를 입력하세요.");
			f.pw.focus();
			return;
		}else{
			saveid(f);
			f.action="MemberLogin";
			f.submit();
		}
				
	}
	function Keycode(e){
		var result;
		if(window.event) {		
	    	result = window.event.keyCode;
	    } else if(e) {
			result = e.which;
		}
		return result;
	}
	function saveid(form) {
		var expdate = new Date();
		if (form.checksaveid.checked) {
			expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30);
		} else {
			expdate.setTime(expdate.getTime() - 1);
			
		}
		setCookie("saveid", form.id.value, expdate);
	}
	function getid(form) {
		lf.checksaveid.checked = ((form.id.value = getCookie("saveid")) != "");
	}

window.onload=messageCheck;
</script>
</head>
<body style="margin:0 0 0 0" onload="getid(document.lf)">
	<table>
	<jsp:include page="../include/top.jsp" flush="true" />
	<tr>
		<td height="20">&nbsp;</td>
	</tr>
	<tr>
		<td>
			<form name="lf" method="post">
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<input type="hidden" id="msg" name = "msg" value="<c:out value="${Message}"/>" />
			<tr>
				<td valign="top"><img src="jsp/images/new/loginopen_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td height="30" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" valign="top">
					<table width="620" height="310" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="center" valign="top" background="jsp/images/new/loginopen_box_bg.gif">
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="61%" height="96">&nbsp;</td>
							</tr>
							<tr>
								<td height="162" align="center">
									<table width="60%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="19%" height="29" align="left"><strong>아이디</strong></td>
										<td width="48%" align="left">
											<input type="text" name="id" id="textfield2" class="idForm" style="width:150;height:20" onkeydown="if(Keycode(event) ==13) login(lf);"
												onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');" tabindex="1" />
										</td>
										<td width="33%" rowspan="2" align="left">
											<a href="javascript:login(lf)" ><img src="jsp/images/new/loginopen_login_b.gif" border="0" tabindex="3"></a>
										</td>
											<!--<a href="javascript:login(lf)"><img src="jsp/images/new/loginopen_login_b.gif" width="112" height="55" tabindex="3" /></a>-->
									</tr>
									<tr>
										<td align="left"><strong>비밀번호</strong></td>
										<td align="left">
											<input type="password" name="pw" id="textfield3"  style="width:150;height:20" size="20" onkeydown="if(Keycode(event) ==13) login(lf);"
												onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');" tabindex="2" />
										</td>
									</tr>
									<tr>
										<td width="19%" height="19" align="left"></td>
										<td colspan="2" align="left"><input type="checkbox" name="checksaveid" onClick="saveid(this.form)">아이디 저장 &nbsp;</td>
									</tr>
									<tr>
										<td colspan="3" align="left">&nbsp;</td>
									</tr>
									<tr>
									<td colspan="3" align="center">
										<a href="MemberRegistOpen" target="_self"><img src="jsp/images/new/loginopen_regist_b.gif" width="118" height="25" border="0" /></a>&nbsp;
										<a href="MemberFindInfoOpen" target="_self"><img src="jsp/images/new/loginopen_idpw_b.gif" width="158" height="25" border="0" /></a></td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="51" align="center">
									<strong>KANKOKUJIN.COM 아이디가 없으신 분</strong>은 <span class="red-text-w"><strong>등록하기</strong></span>/ 
									<strong class="red-text-w">내글보기</strong>를 이용하실 수 없습니다.</td>
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
		<td height="50">&nbsp;</td>
	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
</body>
</html>

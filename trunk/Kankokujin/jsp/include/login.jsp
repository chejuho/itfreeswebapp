<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean" %>
<%@page import="common.util.Util"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<%
request.setCharacterEncoding("UTF-8");
String message = (String)Util.changeNullStr(request.getAttribute("Message"));
%>
<%if(!Util.isEmpty(message)){ %>
<script language="javascript">
	<%	if ("MSG0008".equals(message)) {
	%>
		alert("<fmt:message key="MSG0008" bundle="${message}"/>");
	<%
		}else if ("WAR0003".equals(message)) {
	%>
		alert("<fmt:message key="WAR0003" bundle="${message}"/>");
	<%
		}else if ("WAR0004".equals(message)) {
	%>
		alert("<fmt:message key="WAR0004" bundle="${message}"/>");
	<%
		}
	%>
</script>
<%} %>
<script type="text/javascript">
<!--
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
	function logout() {		
		document.lf.action="MemberLogout";
		document.lf.submit();		
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
	
//-->
</script>
<form name="lf" method="post" style="margin:0">
	<c:if test="${empty memberInfo}">
		<!-- LOGIN START -->
		<table id="Table_" width="224" height="134" border="0" cellpadding="0" cellspacing="0">
	    <tr>
			<td colspan="3"><img src="jsp/images/new/login_01.gif" width="224" height="9" alt="" /></td>
		</tr>
		<tr>
			<td><img src="jsp/images/new/login_02.gif" width="8" height="118" alt="" /></td>
			<td width="208" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="jsp/images/new/main_login_tit.gif" width="208" height="30" /></td>
	 				</tr>
	         	<tr>
					<td height="62" align="center">
   						<table width="96%" border="0" cellspacing="0" cellpadding="0">
 						<tr>
   							<td width="26%" height="25" align="left">아이디</td>
   							<td width="43%">
   								<input type="text" name="id" id="textfield2" class="idForm" style="width:80px;" onkeydown="if(Keycode(event) ==13) login(lf);"
   									onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');"  tabindex="1" />
   							</td>
   							<td width="31%">
   								<a href="javascript:login(lf)" ><img src="jsp/images/new/img_userbox_login.gif" align="absmiddle" height="25" width="60" border="0" tabindex="3"></a>
   							<!--<a href="javascript:login(lf)" target="_self" tabindex="3" >
   								<img src="jsp/images/new/login_b.gif" width="62" height="42" border="0" /></a>-->
   							</td>
 						</tr>
 						<tr>
  							<td height="25" align="left">비밀번호</td>
   							<td>
	   							<input type="password" name="pw" id="textfield3"  style="width:80px;" onkeydown="if(Keycode(event) ==13) login(lf);"
	   									onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');" 
	   									onMouseDown="javascript:MouseUp1=true;" onKeyDown="javascript:KeyUp1=true;" tabindex="2" />
   							</td>
   							<td align="left"><input type="checkbox" name="checksaveid" onClick="saveid(this.form)">ID저장</td>
   						</tr>
   						</table>
	           		</td>
	           	</tr>
 				<tr>
   					<td height="1" bgcolor="#CCCCCC"></td>
 				</tr>
				<tr>
	                <td align="center"  style="padding-top:5px;">
	                	<span class="orange-text"><strong>&raquo; 
	                		<a href="MemberRegistOpen" target="_self" class="login-link1" tabindex="4" >회원가입</a></strong></span> &nbsp;&nbsp;
	                		<a href="MemberFindInfoOpen" class="login-link2" tabindex="5" >아이디/비밀번호찾기</a>
	                </td>
				</tr>
	   					</table>
	   				</td>
	   				<td><img src="jsp/images/new/login_04.gif" width="8" height="118" alt="" /></td>
	 			</tr>
		<tr>
			<td colspan="3"><img src="jsp/images/new/login_05.gif" width="224" height="7" alt="" /></td>
		</tr>
		</table>
	</c:if>
	<c:if test="${!empty memberInfo}">
		<table id="Table_" width="224" height="134" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="3"><img src="jsp/images/new/login_01.gif" width="224" height="9" alt="" /></td>
		</tr>
		<tr>
			<td><img src="jsp/images/new/login_02.gif" width="8" height="125" alt="" /></td>
		    <td width="208" valign="top">
		    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		      	<tr>
		        	<td height="30" align="center" background="jsp/images/new/lougout_bg.gif" class="top-text">
		        		<strong><img src="jsp/images/new/logout_icon1.gif" align="absmiddle" width="16" height="18" /> Kankokujin.com입니다.</strong>
		        	</td>
		      	</tr>
		      	<tr>
		        	<td height="85" align="center"><strong><c:out value="${util:cutLongName(10,memberInfo.name)}" /></strong>님 <br />
		          		기분좋은 하루 되세요.<br />
		          		<a href="javascript:logout()"><img src="jsp/images/new/logout_b.gif" width="82" height="24" /></a>
		          	</td>
		        </tr>
		    	</table>
		    </td>
		    <td><img src="jsp/images/new/login_04.gif" width="8" height="125" alt="" /></td>
		  </tr>
		  <tr>
			<td colspan="3"><img src="jsp/images/new/login_05.gif" width="224" height="7" alt="" /></td>
		  </tr>
		</table>
		<input type="hidden" name="checksaveid">
	</c:if>
</form>
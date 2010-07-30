<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.bean.MemberBean" %>
<%@page import="common.util.Util"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
			f.action="AdminLogin";
			f.submit();
		}
				
	}
//-->
</script>
 <%
 	MemberBean member = (MemberBean) session.getAttribute("memberInfo"); 
	String session_id = null;
	if(member != null){
	    session_id = member.getName();
	}
   
 %>
<form name="lf" method="post">
<table width="197" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="jsp/images/common/img_userbox_top.gif"></td>
          </tr>
          <tr>
<%if(member==null){ %>
            <td background="jsp/images/common/img_userbox_bg.gif">
            <table width="173" border="0" align="center" cellpadding="0" cellspacing="0">               
                <tr style="padding-top:9">
                  <td width="5">&nbsp;</td>
                  <td width="100"><input name="id" type="text" class="login" style="background:url(images/common/img_userbox_id.gif) no-repeat; background-Color:#ffffff;width:88;height:20" onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');" onMouseDown="javascript:MouseUp1=true;" onKeyDown="javascript:KeyUp1=true;" value="" size="15" tabindex="1"></td>
                  <td width="68" rowspan="2"><img src="jsp/images/common/img_userbox_login.gif" alt="" align="absmiddle" onclick="login(lf)" tabindex="3"></td>
                </tr>
                <tr style="padding-top:2">
                  <td>&nbsp;</td>
                  <td><input name="pw" type="password" class="login" style="background:url(images/common/img_userbox_ps.gif) no-repeat; background-Color:#ffffff;width:88;height:20" onFocus="loginform_clearbg('pw');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B')" onMouseDown="javascript:MouseUp1=true;" onKeyDown="javascript:KeyUp1=true;" value="" size="15" tabindex="2"></td>
                </tr>
                <tr>
                  <td colspan="3">
                  <table width="173" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26"><a href="MemberRegistOpen"><img src="jsp/images/common/img_userbox_join.gif" alt="" width="60" height="20"></a></td>
                        <td width="147"><a href="MemberFindInfoOpen"><img src="jsp/images/common/img_userbox_search.gif" width="110" height="21"></a></td>
                      </tr>
                  </table>
                  </td>
                </tr>
            </table></td>
<%}else{%>
            
            <td background="jsp/images/common/img_userbox_bg.gif">
            <table width="173" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr style="padding-top:9">
                  <td>&nbsp;</td>
                  <td width="167" class="text_11 style="padding-left:5" align="center">
                  <font class="smallfont"><b><%=session_id %></b>님 <br>기분좋은 하루 되세요.</font></td>
              </tr>
              <tr>
	            <td colspan="1">
                <td align="center" valign="top"><img src="jsp/images/common/btn_logout.gif" width="52" height="17" onclick="logout(lf)"></td>
              </tr> 
              <tr>
	            <td colspan="1">              
                <td align="center" height="23"><a href="AdminMain" >管理者画面</a></td>
              </tr>               
              
            </table></td>
<%} %>
          </tr>
          <tr>
            <td><img src="jsp/images/common/img_userbox_bottom.gif" alt="" width="197" height="16"></td>
          </tr>
        </table>
</form>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="common.util.Util"%>

<%
request.setCharacterEncoding("UTF-8");
String message = (String)Util.changeNullStr(request.getAttribute("Message"));
%>
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
			//f.action="MemberLogin";
			//f.submit();
		}	
		window.opener.location.href = "MemberLogin?id=" + f.id.value + "&pw=" + f.pw.value;
		//window.opener.location.href=window.opener.location.href; 
		<%String actionName = (String)session.getAttribute("action");%>
		
		window.opener.location.href='<%=actionName%>';
		window.close();
	}
	
	function openMemberRegist() {
	
		window.opener.location.href = "MemberRegistOpen";
		window.close();
	
	}
	function openMemberFindInfo() {
	
		window.opener.location.href = "MemberFindInfoOpen";
		window.close();
	
	}
//-->
</script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
<form name="lf" method="post">
<table width="197" border="0" cellspacing="0" cellpadding="0" align="center">
          <tr>
            <td><img src="jsp/images/common/img_userbox_top.gif"></td>
          </tr>
          <tr>
            <td background="jsp/images/common/img_userbox_bg.gif">
            <table width="173" border="0" align="center" cellpadding="0" cellspacing="0">
                <%if(!Util.isEmpty(message)){ %>
                <tr style="padding-top:9">
                  <td width="5">&nbsp;</td>
                  <td width="100%"colspan="2">&nbsp;<font color="red"><%=message %></font></td>
                </tr>
                <%} %>
                <tr style="padding-top:9">
                  <td width="5">&nbsp;</td>
                  <td width="100"><input name="id" type="text" class="login" style="background:url(images/common/img_userbox_id.gif) no-repeat; background-Color:#ffffff;width:88;height:20" tabindex="1" onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');" onMouseDown="javascript:MouseUp1=true;" onKeyDown="javascript:KeyUp1=true;" value="" size="15"></td>
                  <td width="68" rowspan="2">

                  <input name="" type="image" src="jsp/images/common/img_userbox_login.gif" alt="" align="absmiddle" onclick="login(lf)" tabindex="3">
                  </td>
                </tr>
                <tr style="padding-top:2">
                  <td>&nbsp;</td>
                  <td><input name="pw" type="password" class="login" style="background:url(images/common/img_userbox_ps.gif) no-repeat; background-Color:#ffffff;width:88;height:20" tabindex=2 onFocus="loginform_clearbg('pw');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B')" onMouseDown="javascript:MouseUp1=true;" onKeyDown="javascript:KeyUp1=true;" value="" size="15"></td>
                </tr>
                <tr>
                  <td colspan="3">
                  <table width="173" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26"><img src="jsp/images/common/img_userbox_join.gif" alt="" width="60" height="20" onclick="openMemberRegist()"></td>
                        <td width="147"><img src="jsp/images/common/img_userbox_search.gif" width="110" height="21" onclick="openMemberFindInfo()"></td>
                      </tr>
                  </table>
                  </td>
                </tr>
            </table></td>

          </tr>
          <tr>
            <td><img src="jsp/images/common/img_userbox_bottom.gif" alt="" width="197" height="16"></td>
          </tr>
        </table>
</form>
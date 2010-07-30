<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="common.util.Util, common.bean.MemberBean"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
request.setCharacterEncoding("UTF-8");
	 String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	 MemberBean memberBean = (MemberBean)request.getAttribute("MemberBean");
		
	if(!Util.isEmpty(message)){
%>
		<script language="javascript">
		<%if ("MSG0008".equals(message)) {%>
			alert("<fmt:message key="MSG0008" bundle="${message}"/>");
		<%
			}else if ("MSG0009".equals(message)) {%>
			alert("<fmt:message key="MSG0009" bundle="${message}"/>");
		<%
			}else if ("WAR0006".equals(message)) {%>
			alert("<fmt:message key="WAR0006" bundle="${message}"/>");
			<%
			}	
			
		%>
		</script>

	<%} %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><%=Const.PAGE_MAIN_TITLE%></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
<!--
.style3 {font-size: 12px}
.text {
	line-height: 8px;
}
-->
</style>
<script type="text/javascript">
<!--

	function sellcheck(f) {
		if(f.userid.value==""){
			alert("아이디를 입력하세요.");
			f.userid.focus();
			return false;
		}else if(f.password.value==""){
			alert("비밀번호를 입력하세요.");
			f.password.focus();
			return false;
		}else if(f.registnum.value==""){
			alert("인증번호를 입력하세요.");
			f.registnum.focus();
			return false;
		}else{
		   f.action="RegistKankokujin";
		   f.submit(); 
	   	}

	}
	
//-->
</script>
</head>

<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950"
	align="center">

	<!----- top메뉴 ------>
	<tr valign="top">
		<td colspan="5"><jsp:include page="../include/top.jsp"
			flush="true" /></td>
	</tr>
	<!----- top메뉴 ------>


	<!----- 콘텐츠 영역 ----->
	<tr>

		<!-- 메인 바디 -->
		<td valign="top">
		<form name="wf" method="post">	
		<br><br>	
		<table width="680" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
                <td><img src="jsp/images/common/one_point_square.gif" /><img src="jsp/images/common/titile_confir.gif"></td>
              </tr>
              <tr>
    			<td><img src="jsp/images/common/logo_line.gif" /></td>
 			</tr>
		</table>
		 <br><br>
			 <table border="0" cellpadding="0" cellspacing="0" width="654" id="ta_in" radius="3" align="center">
			<tr><td><font class="text_11">회원정보가 정상적으로 등록되었습니다.<p>
			인증과정을 거쳐 주시기 바랍니다.</td>
			</tr>
			</table>
			<br><br><br>		
		<table border="0" cellpadding="0" cellspacing="0" width="680"
			height="20" align="center">
 			<tr><td><img src="jsp/images/common/one_point.gif"><img src="jsp/images/common/uesr_confir.gif"></td>
			</tr>
			<tr><td>&nbsp;</td>
			</tr>
          <tr><td>
				사용자인증 등록을 하셔야 가입완료되어 모든 서비스를 이용하실 수 있습니다.</td>
			</tr>
		</table>

		<table width="550" border="1" align="left" cellpadding="0"
			cellspacing="0" bordercolor="#CDE6F8" rules="rows"
			style="border-collapse:collapse;" style="margin-left:65">
			<col width="100" bgcolor="#E5F3FC">
			<col width="450" style="padding-left:17" >
			<tr height="35">
				<td style="padding-left:17"><span class="style5">아이디</span></td>
				<td><span class="style3"><input type="text"
					name="userid" size="12" maxlength="20" class="write" value="<%=memberBean.getUserid()%>"></span></td>
			</tr>
			<tr height="35">
				<td style="padding-left:17"><span class="style5">비밀번호</span></td>
				<td><span class="style3"><input type="password"
					name="password" size="14" maxlength="20" class="write" value="<%=memberBean.getPassword()%>"></span></td>
			</tr>
			<tr height="35">
				<td style="padding-left:17"><span class="style5">인증번호</span></td>
				<td><span class="style3"><input type="password"
					name="registnum" size="14" maxlength="20" class="write" value="<%=memberBean.getRegistnum()%>"></span></td>
			</tr>
		</table>
		</tr>
		<tr><td>
		<table width="680" border="0" align="center" cellpadding="0"
			cellspacing="0" align="center">
			<tr style="padding-top:15">
				<td align="center"><img src="jsp/images/common/btn_cs_ok.gif"
					alt="" onclick="sellcheck(wf)"></td>
			</tr>
		</table>
	
		</form>
		<!-- 메인 바디 -->
		
	

		
	</tr>

	<!----- 콘텐츠 영역 ----->


	<tr height="40">
		<td colspan="5"></td>
	</tr>


	<!----- Footer 영역 ----->

	<tr valign="top">
		<td colspan="5"><jsp:include page="../include/footer.jsp"
			flush="true" /></td>
	</tr>
	<!----- Footer 영역 ----->
</table>
</body>
</html>

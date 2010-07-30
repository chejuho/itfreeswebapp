<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="common.constant.Const"%>
<%@page import="common.bean.MemberBean"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><%=Const.PAGE_MAIN_TITLE%></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
</head>

<%
MemberBean member = (MemberBean) session.getAttribute("memberInfo");
if (member ==null){
	member = new MemberBean();
}
%>

<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950"
	align="center">

	<!----- top메뉴 ------>
	<tr valign="top">
		<td colspan="5"><jsp:include page="../include/top.jsp"
			flush="true" /></td>
	</tr>
	<!----- top메뉴 ------>

	<tr>
		<!-- 메인 바디 -->
		<td valign="top">

		<table border="0" cellpadding="0" cellspacing="0" width="680" align="center">

			<tr valign="top">
				<td><!---- 가입완료 ---->
				<br><br>
			<table width="680" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
			
                <td><img src="jsp/images/common/one_point_square.gif" /><img src="jsp/images/common/logo_end.gif"></td>
              </tr>
              <tr>
    			<td><img src="jsp/images/common/logo_line.gif" /></td>
 			</tr>
		</table>
				<!---- 가입완료 ----></td>
			</tr>
			<tr height="10">
				<td></td>
			</tr>
			<tr>
				<td align="center"><!---- 14세 회원가입 완료 ---->
				<table border="0" cellpadding="0" cellspacing="0" width="680"
					id="ta_out" radius="3" rborder="#FBF9F4" rbgcolor="#FBF9F4" align="center">
					<tr style="padding:10">
						<td>
						<table border="0" cellpadding="0" cellspacing="0" width="654"
							id="ta_in" radius="3" rborder="#EDE8DA" rbgcolor="#FFFFFF">
							<tr>
								<td align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="515">
									<tr valign="top">
										<td><img src="jsp/images/common/img_mem_ment07.gif"></td>
									</tr>
									<tr valign="top">
										<td style="padding:15 0 10 0"><strong><%=member.getName()%></strong>님<br>
										<font class="text_11">캉코쿠진닷컴에 오신 것을 환영합니다.<p>
										 회원인증이 정상적으로 완료 되었으므로 모든 서비스의 이용이 가능합니다.</td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>

				<!---- 14세 회원가입 완료 ----></td>
			</tr>
			<tr>
				<td align="center" style="padding-top:15"><a href="Index"><img src="jsp/images/common/btn_cs_ok.gif" alt=""></a></td>
			</tr>
		</table><br><br><br><br>
		</td>
		<!-- 메인 바디 -->	
		<!----- Footer 영역 ----->

	<tr valign="top">
		<td colspan="5"><jsp:include page="../include/footer.jsp"
			flush="true" /></td>
	</tr>
	<!----- Footer 영역 ----->
</body>
</html>

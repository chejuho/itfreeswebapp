<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.constant.Const"%>
<%@page import="common.bean.MemberBean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><c:out value="회원가입완료"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">

<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-weight: bold;
	color: #FF9900;
}
.style2 {
	font-size: 14px;
	font-weight: bold;
}
.style3 {
	font-size: 12px;
	font-weight: bold;
	line-height:18px;
}
.style4 {color: #3366FF}
-->
</style>
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
  <tr>
    <td valign="top"><img src="jsp/images/new/10_title.gif" width="736" height="82" /></td>
  </tr>
  <tr>
    <td valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td ><table width="736" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/bg.gif" height="225">
          <tr>
            <td width="267">&nbsp;</td>
            <td width="469"><p class="style1">회원가입이 완료되었습니다.</p>
                    <p class="style2"><c:out value="${MemberBean.name}"/></p>
              <p class="style3"><span class="style4">Kankokujin.com</span>에 오신것을 환영합니다.<br />
                회원인증이 정상적으로 완료되었으므로 모든 서비스의 이용이 가능합니다. </p></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="center" valign="top"><a href="Index"><img src="jsp/images/new/ok_b.gif" width="117" height="36" /></a>&nbsp;</td>
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

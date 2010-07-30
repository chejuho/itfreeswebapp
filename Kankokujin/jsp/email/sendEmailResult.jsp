<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.constant.Const"%>
<%@ page import="common.bean.MemberBean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<html>
<head>
<title><c:out value="메일 보내기완료"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
</head>

<body topmargin="0" leftmargin="0">
<table width="500"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><img src="jsp/images/new/7_title.gif" width="565" height="56" /></td>
  </tr>
  <tr>
    <td height="40" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="center" valign="top">
    	<img src="jsp/images/new/7_pic.gif" width="76"  align="absmiddle"height="75" />&nbsp;&nbsp;
    	<c:if test="${menuBean['mailsendResult'] == 'SUCCESS' }">
				<strong>메일이 성공적으로 발송되었습니다.</strong>
		</c:if>
		<c:if test="${menuBean['mailsendResult'] == 'FLASE' }">
			<strong>메일발송이 실패하였습니다.</strong>
		</c:if></td>
  </tr>
  <tr>
    <td valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="center" valign="top">
    <a href="" onclick="window.close();"><img src="jsp/images/new/7_ok.gif" width="73" height="22" /></a></td>
  </tr>
</table>
</body>
</html>
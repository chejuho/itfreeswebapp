<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<html>
<head>
<title><c:out value="메뉴별 등록하기"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
			<tr>
				<td colspan="2" valign="top"><img src="jsp/images/new/topregist_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td colspan="2" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td width="368" align="left" valign="top">
					<a href="BuySellRegistOpen?before=search&f=search&before_cate_code_1=C10100"><img src="jsp/images/new/topregist_b1.gif" width="364" height="90" /></a></td>
				<td width="368" align="right" valign="top">
					<a href="BuySellRegistOpen?before=search&f=search&&before_cate_code_1=C10200"><img src="jsp/images/new/topregist_b2.gif" width="363" height="90" /></a></td>
			</tr>
			<tr>
				<td colspan="2" valign="top">&nbsp;</td>
			</tr> 	
			<tr>
				<td>
					<a href="StoreRegistOpen?before=search&f=search" target="_self"><img src="jsp/images/new/topregist_b3.gif" width="364" height="90" border="0" /></a></td>
				<td align="right">
					<a href="GourmetRegistOpen?before=search&f=search"><img src="jsp/images/new/topregist_b4.gif" width="363" height="90" /></a></td>
			</tr>
			<tr>
				<td colspan="2" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<a href="RoomSellRegistOpen?cate_code_1=C10001&before=search&f=search"><img src="jsp/images/new/topregist_b5.gif" width="364" height="90" /></a></td>
				<td align="right">
					<a href="RoomSellRegistOpen?cate_code_1=C10002&before=search&f=search"><img src="jsp/images/new/topregist_b6.gif" width="363" height="90" /></a></td>
			</tr>
			<tr>
				<td colspan="2" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<a href="HouseSellRegistOpen?before=search&f=search"><img src="jsp/images/new/topregist_b7.gif" width="364" height="90" /></a></td>
				<td align="right" valign="top">
					<a href="FindjobRegistOpen?before=search&f=search"><img src="jsp/images/new/topregist_b8.gif" width="363" height="89" /></a></td>
			</tr>
			<tr>
				<td colspan="2" valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<a href="JobRegistOpen?before=search&f=search&cate_code_1=C10100"><img src="jsp/images/new/topregist_b9.gif" width="364" height="90" /></a></td>
				<td align="right" valign="top">
					<a href="JobRegistOpen?before=search&f=search&cate_code_1=C10200"><img src="jsp/images/new/topregist_b10.gif" width="363" height="90" /></a></td>
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
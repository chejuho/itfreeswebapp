<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="common.util.Util"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<script type="text/javascript">
	function submitUpdate() {
		   location.href="MemberUpdateOpen";
	   	}     
	   	
	function submitDelete() {
	
		   location.href="MemberDeleteOpen";
	   	}          
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><c:out value="회원정보"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
				<td valign="top"><img src="jsp/images/new/memdetail_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#ebebeb" style="padding:11px 11px 11px 11px;">
						<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td width="27%" bgcolor="#f7f7f7" class="table-title-text">아이디</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${memberInfo.userid}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">이메일주소</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${memberInfo.email1}"/>@<c:out value="${memberInfo.email2}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">닉네임</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${memberInfo.name}"/></td>
							</tr>
							<tr>	
								<td bgcolor="#f7f7f7" class="table-title-text">전화번호1</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty memberInfo.telephone1}">
										<c:out value="${memberInfo.telephone1}"/><c:out value="-"/>
										<c:out value="${memberInfo.telephone2}"/><c:out value="-"/>
										<c:out value="${memberInfo.telephone3}"/>
									</c:if>&nbsp;</td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">전화번호2</td>
								<td width="73%" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty memberInfo.mobile1}">
										<c:out value="${memberInfo.mobile1}"/><c:out value="-"/>
										<c:out value="${memberInfo.mobile2}"/><c:out value="-"/>
										<c:out value="${memberInfo.mobile3}"/>
									</c:if>&nbsp;</td>
							</tr>
						</table>
						</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" valign="top">
					<a href="javascript:submitUpdate()"><img src="jsp/images/new/memupgrade_ok_b.gif" width="130" height="33" border="0" /></a>&nbsp;
					<a href="javascript:submitDelete()"><img src="jsp/images/new/memupgrade_cancel_b.gif" width="130" height="33" border="0" /></a></td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="common.bean.MemberBean, common.util.EnDecoding"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="flashPageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="${LocaleInfo}"/>
<fmt:setBundle basename="aFlashcard" var="message"/>

<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<head>
<title>${iboardBean.title}&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script type="text/javascript">
	function ok(ff) {
		if(isNull(ff.pass_word)) {
			alert("<fmt:message key="aFlashcardDelete.msg.pwd_err" bundle="${message}"/>");
			return;
		}
		if(!window.opener || window.opener.closed){ // メインウィンドウの存在をチェック
			window.alert('<fmt:message key="aFlashcardDelete.msg.no_mainwindow_err" bundle="${message}"/>'); // 存在しない場合は警告ダイアログを表示
		} else{
			var url = "usergroupdelete";
			window.opener.document.list.pass_word.value = ff.pass_word.value; 
			window.opener.document.list.delUserId.value = ff.user_id.value; 
			window.opener.document.list.delGroupId.value = ff.group_id.value; 
			window.opener.document.list.action=url;
			window.opener.document.list.submit(); 
			window.close();
		}
		return true;
	}
	
</script>
</head>

<body style="margin:0 0 0 0"> 
	<form name="lf" method="post" style="margin:0">
	<input type="hidden" name="user_id" value="${user_id}">
	<input type="hidden" name="group_id" value="${group_id}">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
     	<tr>
   			<td height="1" bgcolor="#CCCCCC"></td>
 		</tr>
 		<tr>
 			<td height="62" align="center">
 				<fmt:message key="aFlashcardDelete.label.head" bundle="${message}"/>
 			</td>
     	<tr>
			<td height="62" align="center">
   			<table width="96%" border="0" cellspacing="0" cellpadding="0">
 				<tr>
   					<td width="26%" height="25" align="left"><fmt:message key="aFlashcardDelete.label.pwd" bundle="${message}"/></td>
   					<td width="43%">
   						<input type="password" name="pass_word" id="textfield2" class="idForm" />
   					</td>
   					<td width="31%">
   						<a href="javascript:ok(lf)" ><img src="<fmt:message key="aFlashcardDelete.image.ok" bundle="${message}"/>" align="absmiddle" height="35" width="80" border="0" tabindex="3"></a>
   					</td>
 				</tr>
   			</table>
       		</td>
       	</tr>
 		<tr>
   			<td height="1" bgcolor="#CCCCCC"></td>
 		</tr>
 		</table>
 		</form>
</body>
</html>
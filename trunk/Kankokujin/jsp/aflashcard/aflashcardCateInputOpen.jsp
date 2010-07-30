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
<title>aFlashcard&nbsp;::&nbsp;<fmt:message key="categoryNameInputOpen.title" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script type="text/javascript">
	Event.observe(window, 'load', errorInit);
	/** ERROR메세지 처리  */
	 function errorInit() {
	 	if (document.lf.msg.value == "LOGIN_ERROR") {
	 		alert("<fmt:message key="categoryNameInputOpen.msg.login_err" bundle="${message}"/>");
	 		window.close();
	 	}
	 	
	 
	}
	function ok(ff) {
		if(isNull(ff.categoryName)) {
			alert("<fmt:message key="categoryNameInputOpen.msg.no_inputCategoryName_err" bundle="${message}"/>");
			return;
		}
		if(!window.opener || window.opener.closed){ // メインウィンドウの存在をチェック
			window.alert('<fmt:message key="categoryNameInputOpen.msg.no_mainwindow_err" bundle="${message}"/>'); // 存在しない場合は警告ダイアログを表示
		} else{
			var url = "";
			if (ff.sign.value == 'reg') {
				url="categoryregist";
			}
			if (ff.sign.value == 'edit') {
				url="categoryedit";	
			}
			window.opener.document.list.editCategoryName.value = ff.categoryName.value; // 存在する場合はページを切りかえる
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
	<input type="hidden" name="id" value="${id}">
	<input type="hidden" name="sign" value="${sign}">
	<input type="hidden" name="msg" value="${Msg}">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
     	<tr>
   			<td height="1" bgcolor="#CCCCCC"></td>
 		</tr>
 		<tr>
 			<td height="62" align="center">
 				<fmt:message key="categoryNameInputOpen.label.nameInput" bundle="${message}"/>
 			</td>
     	<tr>
			<td height="62" align="center">
   			<table width="96%" border="0" cellspacing="0" cellpadding="0">
 				<tr>
   					<td width="26%" height="25" align="left"><fmt:message key="categoryNameInputOpen.label.name" bundle="${message}"/></td>
   					<td width="43%">
   						<input type="input" name="categoryName" value= "${categoryName}" id="textfield2" style="width:150px;" />
   					</td>
   					<td width="31%">
   						<a href="javascript:ok(lf)" ><img src="jsp/images/new/ok_b.gif" align="absmiddle"  border="0" tabindex="3"></a>
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
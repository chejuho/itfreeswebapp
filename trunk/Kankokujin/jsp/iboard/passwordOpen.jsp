<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="common.bean.MemberBean, common.util.EnDecoding"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<head>
<title>${iboardBean.title}&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script type="text/javascript">
	function ok(ff) {
		if(isNull(ff.pass_word)) {
			alert("패스워드를 입력해 주세요.");
			return;
		}
		if(!window.opener || window.opener.closed){ // メインウィンドウの存在をチェック
			window.alert('メインウィンドウがありません'); // 存在しない場合は警告ダイアログを表示
		} else{
			var url = "";
			if (ff.sign.value == 'del') {
				url="IBoardDelete";
			}
			if (ff.sign.value == 'edit') {
				url="IBoardUpdateOpen";	
			}
			window.opener.document.wf.pass_word.value = ff.pass_word.value; // 存在する場合はページを切りかえる
			window.opener.document.wf.id.value = ff.id.value; // 存在する場合はページを切りかえる
			window.opener.document.wf.action=url;
			window.opener.document.wf.submit(); 
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
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
     	<tr>
   			<td height="1" bgcolor="#CCCCCC"></td>
 		</tr>
 		<tr>
 			<td height="62" align="center">
 				<c:if test="${sign == 'del'}">
 					게시판내용을 삭제하시려면 비밀번호를 입력해주세요.
 				</c:if>
 				<c:if test="${sign == 'edit'}">
 					게시판내용을 수정하시려면 비밀번호를 입력해주세요.
 				</c:if>
 			</td>
     	<tr>
			<td height="62" align="center">
   			<table width="96%" border="0" cellspacing="0" cellpadding="0">
 				<tr>
   					<td width="26%" height="25" align="left">비밀번호:</td>
   					<td width="43%">
   						<input type="password" name="pass_word" id="textfield2" class="idForm" />
   					</td>
   					<td width="31%">
   						<a href="javascript:ok(lf)" ><img src="jsp/images/new/ok_b.gif" align="absmiddle" height="35" width="80" border="0" tabindex="3"></a>
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
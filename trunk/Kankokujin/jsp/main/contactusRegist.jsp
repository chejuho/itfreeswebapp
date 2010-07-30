<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="common.util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<html>
<head>
<title><c:out value="문의하기"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--

	function sellcheck(f) {
		ID = /^[A-Za-z0-9]+$/;
		ED = /^[0-9]{1,4}/;
		if(f.name.value==""){
			alert("이름을 입력하세요.");
			f.name.focus();
			return;			
		} 		
		if(f.email1.value==""){
			alert("이메일을 입력하세요.");
			f.email1.focus();
			return;
		} else if(f.email2.value==""){
			alert("이메일을 입력하세요.");
			f.email2.focus();
			return;		
		} 
		
		if(!isEmail(f.email1.value + "@"+ f.email2.value)) {
			alert("이메일이 형식에 맞지 않습니다.");
			return;
		} 
		if(!isNull(f.telephone1) || !isNull(f.telephone2) || !isNull(f.telephone3)) {
	
			if(!ED.test(f.telephone1.value) || !ED.test(f.telephone2.value) ||!ED.test(f.telephone3.value)){
				alert("전화번호1이 전화번호 형식에 맞지 않습니다. ");
				return;
			}
		} 
		if(!isNull(f.mobile1) || !isNull(f.mobile2) || !isNull(f.mobile3)) {
	
			if(!ED.test(f.mobile1.value) || !ED.test(f.mobile2.value) ||!ED.test(f.mobile3.value)){
				alert("전화번호2가 전화번호 형식에 맞지 않습니다. ");
				return;
			}
		} 
		if(f.title.value==""){
			alert("제목을 입력하세요.");
			f.title.focus();
			return;			
		} 
		if(f.detail_info.value==""){
			alert("내용을 입력하세요.");
			f.detail_info.focus();
			return;			
		} 				
		f.action="ContactusRegist";
		f.submit(); 
	}
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}	
	function isEmail(obj) {
	    var format = /^[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+)*@[0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*$/;
		/^(file|gopher|news|nntp|telnet|https?|ftps?|sftp):\/\/([a-z0-9-]+\.)+[a-z0-9]{2,4}.*$/	    
		if (obj.search(format) != -1){
			return true;		
		}else {
			return false;		
		}	
	}
//-->
</script>
</head>

<body style="margin:0 0 0 0">
	<table>
	<jsp:include page="../include/top.jsp" flush="true" />
	<tr>
		<td height="20">&nbsp;</td>
	</tr>
	<tr>
		<td>
			<form name="wf" method="post">
			<table width="736" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top"><img src="jsp/images/new/contact_tit.gif" width="736" height="82" /></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">※ 문의사항,불편사항 및 기타의견을 적어주시면 관리자가 확인한후 메일이나 연락처로 연락드리겠습니다.</td>
			</tr>
			<tr>
				<td height="8" valign="top"></td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#ebebeb" style="padding:11px 11px 11px 11px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td width="22%" bgcolor="#f7f7f7" class="table-title-text">이 름</td>
								<td width="79%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="name" value="<c:out value="${memberInfo.name}"/>"  style="width:150px;" /></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text"><span class="red-text-w">*</span>이메일</td>
								<td width="79%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="email1" value="<c:out value="${memberInfo.email1}"/>" style="width:150px;" />
									@
									<input type="text" name="email2" value="<c:out value="${memberInfo.email2}"/>" style="width:150px;"/></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">전화번호1</td>
								<td width="79%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="telephone1" type="text" value="<c:out value="${memberInfo.telephone1}"/>" style="width:50px;" />
									-
									<input name="telephone2" type="text" value="<c:out value="${memberInfo.telephone2}"/>" style="width:50px;" />
									-
									<input name="telephone3" type="text" value="<c:out value="${memberInfo.telephone3}"/>" style="width:50px;" /></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">전화번호2</td>
								<td width="79%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="mobile1" type="text" value="<c:out value="${memberInfo.mobile1}"/>" style="width:50px;" />
									-
									<input name="mobile2" type="text" value="<c:out value="${memberInfo.mobile2}"/>" style="width:50px;" />
									-
									<input name="mobile3" type="text" value="<c:out value="${memberInfo.mobile3}"/>" style="width:50px;" /></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">제 목</td>
								<td width="79%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="title" id="textfield8"  style="width:530px;" /></td>
							</tr>
							<tr>
								<td bgcolor="#f7f7f7" class="table-title-text">내 용</td>
								<td width="79%" bgcolor="#FFFFFF" class="table-cont-text">
									<textarea name="detail_info" id="textarea" cols="45" rows="5" style="width:530px;height:200px;"></textarea></td>
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
				<td align="center" valign="top"><a href="javascript:sellcheck(wf)"><img src="jsp/images/new/contact_b.gif" width="119" height="37" /></a></td>
			</tr>
			</table>
			</form>
		</td>
	</tr>
	<tr>
		<td height="50">&nbsp;</td>
	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
</body>
</html>
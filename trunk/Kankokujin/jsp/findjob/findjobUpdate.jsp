<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="findjob.bean.FindjobBean, findjob.bean.FindjobSearchBean"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	request.setCharacterEncoding("UTF-8");
	FindjobBean findjobBean = (FindjobBean) request.getAttribute("FindjobBean");
	FindjobSearchBean findjobSearchBean = (FindjobSearchBean) request.getAttribute("FindjobSearchBean");
	
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title><c:out value="구직 수정화면"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
	function radioCheck(value){
 		if(value == "1" ) {
		 	document.wf.area_fast.disabled=false;
		 	document.wf.area_code_1.disabled=true;
		 	document.wf.area_code_2.disabled=true;
	 	}else if(value == "2" ){
 			document.wf.area_fast.disabled=true;
			document.wf.area_code_1.disabled=false;
			document.wf.area_code_2.disabled=false;
		}
	}
	function isNumber(obj) {
		var str = obj.value;
		if(str.length == 0)
			return false;
	
		for(var i=0; i < str.length; i++) {
			if(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
				return false;
		}
		return true;
	}
	function updateCheck(ff) {
		
		ID = /^[0-9]{1,4}/;
		if(isNull(ff.title)) {
			alert("글제목을 입력해 주세요.");
			return false;
		}
						
		if(!isNull(ff.email) && !isEmail(ff.email.value)) {
			alert("예)itfrees@itfrees.com형식으로 입력해주세요.");
			return false;
		}
	
		if(isNull(ff.tel_no1_1) || isNull(ff.tel_no1_2) || isNull(ff.tel_no1_3)) {
			alert("전화번호1을 입력해 주세요.");
			return;
		} 
		if(!telephoneNoCheck(ff.tel_no1_1, ff.tel_no1_2, ff.tel_no1_3)) {
			alert("전화번호1이 전화번호 형식에 맞지 않습니다. ");
			return;
		}
		if(!telephoneNoCheck(ff.tel_no2_1, ff.tel_no2_2, ff.tel_no2_3)) {
			alert("전화번호2가 전화번호 형식에 맞지 않습니다. ");
			return;
		}
		
		//ff.action="FindjobUpdate?id="+ff.id+"&cate_code_1=" +ff.cate_code_1+"&cate_code_2=" +ff.cate_code_2;
		ff.action="FindjobUpdate";
		ff.submit(); 
		return true;
		
	}	
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function isEmail(obj) {
	    var format = /^[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+)*@[0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*$/;
		if (obj.search(format) != -1){
			return true;		
		}else {
			return false;		
		}	
	}
	function isValidFormat(obj,format) {
		if(obj.value.search(format) != -1) {
			return true;
		}
		return false;
	}	
	function isPhoneNumber(obj) {
		if(obj.value == "") {
			return true;
		}
		var format = /^(\d+)-(\d+)-(\d+)$/;
		return isValidFormat(obj,format);
	}
	function reloadCheck(ff){																		
		ff.action="FindjobUpdateOpen";
		ff.submit(); 
		return true;
	}
	function reloadSearch(ff) {
		ff.action="FindjobUpdateOpen?cate_code_2=C20000";
		ff.submit(); 
		return true;
	}
	function backDetailPage() {
		document.wf.action="FindjobDetail";
		document.wf.submit(); 
		return true;
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
		<td height="35">
			<form name="wf" method="post" enctype="multipart/form-data">
			<input type="hidden" name="user_id"	value="<%=findjobSearchBean.getUser_id()%>">
			<input type="hidden" name="id"	value="<%=findjobBean.getId()%>">			
  			<input type="hidden" name="search" value="<%=findjobSearchBean.getSearch()%>">      			      			
  			<input type="hidden" name="search_range" value="<%=findjobSearchBean.getSearch_range()%>">      			      			
  			<input type="hidden" name="pageNum" value="<%=findjobSearchBean.getPageNum()%>">    
			<input type="hidden" name="pageSize" value="<%=findjobSearchBean.getPageSize()%>">          			      					 				      			  			  			      			
  			<input type="hidden" name="before" value="<%=findjobSearchBean.getBefore()%>">      			  			      			      						
  			<input type="hidden" name="all_search" value="<%=findjobSearchBean.getAll_search()%>"> 
  			<input type="hidden" name="all_search_range" value="<%=findjobSearchBean.getAll_search_range()%>"> 
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><!--이미지수정예정 -->
				<td valign="top" width="736" height="82"><img src="jsp/images/new/findjob_edit_title.gif"/></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					※ 필수항목 (<span class="red-text-w">*</span>표시) 만 입력해도 가능합니다. 선택항목을 입력하면 보다 편리한 정보로 검색되실 수 있습니다. <br />
				</td>
			</tr>
			<tr>
				<td height="8" valign="top"></td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td bgcolor="#EBF2E6" style="padding:11px 11px 11px 11px;">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d6d5d5">
							<tr>
								<td width="22%" bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>글제목</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="title" id="textfield2"  style="width:400px;" value="${FindjobBean.title}" maxlength="42"/></td>
							</tr>
							<tr>
								<td width="22%" bgcolor="#f9faf0" class="table-title-text">희망고용형태</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name='work_sort'>
										<option value='0' <%= findjobBean.getWork_sort_selected(0)%>>상관없음</option>
										<option value='1' <%= findjobBean.getWork_sort_selected(1)%>>사원</option>
										<option value='2' <%= findjobBean.getWork_sort_selected(2)%>>아르바이트</option>						
									</select>
								</td>
							</tr>
							<tr>
								<td width="22%" bgcolor="#f9faf0" class="table-title-text">출생년도</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="birthday" id="textfield2"  style="width:230px;" value="${FindjobBean.birthday}" maxlength="12"/>ex)1986년</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">성별</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<select name='sex'>
										<option value='0' <%=findjobBean.getSex_selected(0)%>>남녀무관</option>
										<option value='1' <%=findjobBean.getSex_selected(1)%>>남</option>
										<option value='2' <%=findjobBean.getSex_selected(2)%>>여</option>						
									</select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이메일</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="email" id="textfield8" class="idForm" align="absmiddle" style="width:240px;" value="${FindjobBean.email}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>전화번호1</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no1_1" type="text" id="textfield9"  class="idForm" maxlength="4" style="width:50px;" value="${FindjobBean.tel_no1_1}" />-
									<input name="tel_no1_2" type="text" id="textfield10" class="idForm" maxlength="4" style="width:50px;" value="${FindjobBean.tel_no1_2}" />-
									<input name="tel_no1_3" type="text" id="textfield11" class="idForm" maxlength="4" style="width:50px;" value="${FindjobBean.tel_no1_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전화번호2</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no2_1" type="text" id="textfield12" class="idForm" maxlength="4" style="width:50px;" value="${FindjobBean.tel_no2_1}" />-
									<input name="tel_no2_2" type="text" id="textfield13" class="idForm" maxlength="4" style="width:50px;" value="${FindjobBean.tel_no2_2}" />-
									<input name="tel_no2_3" type="text" id="textfield14" class="idForm" maxlength="4" style="width:50px;" value="${FindjobBean.tel_no2_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">상세정보</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<textarea name="detail_info" id="textarea" cols="45" rows="5" style="width:530px;height:300px;">${FindjobBean.detail_info}</textarea></td>
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
					<a href="javascript:updateCheck(wf);"><img src="jsp/images/new/btn_edit_ok.gif" /></a>&nbsp;
					<a href="javascript:backDetailPage();"><img src="jsp/images/new/btn_back_page.gif" /></a></td>
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
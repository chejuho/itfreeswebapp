<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="store.bean.StoreBean, store.bean.StoreSearchBean"%>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	request.setCharacterEncoding("UTF-8");
	StoreBean storeBean = (StoreBean) request.getAttribute("StoreBean");
	StoreSearchBean storeSearchBean = (StoreSearchBean) request.getAttribute("StoreSearchBean");
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title><c:out value="업체찾기 수정화면"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
		if(isNull(ff.store_name_k) && isNull(ff.store_name_j)) {
			alert("업체명을 입력해 주세요.");
			return;
		}
		if(ff.cate_code_1.value =="C10000") {
			alert("대분류를 선택해 주세요.");
			return;
		} 		
		if(ff.cate_code_2.value.substring(4, 6)=="00") {
			alert("소분류를 선택해 주세요.");
			return;
		} 		
		if(ff.area_code_1.value !="00" && ff.area_code_2.value.substring(2, 4)=="00") {
			alert("지역상세정보를 선택해 주세요.");
			return;
		} 	
		if(ff.line_code.value !="00" && ff.station_code.value.substring(2, 4)=="00") {
			alert("역 정보를 선택해 주세요.");
			return;
		} 			
		if(!isNull(ff.url) && !isURL(ff.url.value)) {
			alert("홈페이지 형식으로 입력해주세요.");
			return;
		}			
		if(!isNull(ff.email) && !isEmail(ff.email.value)) {
			alert("예)itfrees@itfrees.com형식으로 입력해주세요.");
			return;
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
		if(!telephoneNoCheck(ff.fax_no_1, ff.fax_no_2, ff.fax_no_3)) {
			alert("FAX번호가 FAX번호 형식에 맞지 않습니다. ");
			return;
		}
		if(!uploadImageCheck(ff.photo_name1, 1)) {
			return;
		}
		if(!uploadImageCheck(ff.photo_name2, 2)) {
			return;
		}
		if(!uploadImageCheck(ff.photo_name3, 3)) {
			return;
		}
		if(!uploadImageCheck(ff.photo_name4, 4)) {
			return;
		}
		if(!uploadImageCheck(ff.photo_name5, 5)) {
			return;
		}
																					
		
		//ff.action="StoreUpdate?id="+ff.id+"&cate_code_1=" +ff.cate_code_1+"&cate_code_2=" +ff.cate_code_2;
		ff.action="StoreUpdate";
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
	function isURL(obj) {
		var format = /^([a-z0-9-]+\.)+[a-z0-9]{2,4}.*$/	    
		if (obj.match(format)){
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
		ff.action="StoreUpdateOpen";
		ff.submit(); 
		return true;
	}
	function reloadSearch(ff) {
		ff.action="StoreUpdateOpen?cate_code_2=-";
		ff.submit(); 
		return true;
	}
	function deletePhoto(index) {
		document.wf.action="StoreUpdateOpen?del="+index;
		document.wf.submit(); 
		return true;
	}	
	function backDetailPage() {
		document.wf.action="StoreDetail";
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
			<input type="hidden" name="user_id" value="<%=storeSearchBean.getUser_id()%>">      			
			<input type="hidden" name="id"	value="<%=storeBean.getId()%>">			
		    <input type="hidden" name="search_cate_code_1" value="<%=storeSearchBean.getCate_code_1()%>">
  			<input type="hidden" name="search_cate_code_2" value="<%=storeSearchBean.getCate_code_2()%>">
  			<input type="hidden" name="pageSize" value="<%=storeSearchBean.getPageSize()%>">      			
  			<input type="hidden" name="pageNum" value="<%=storeSearchBean.getPageNum()%>">      			  			      			      			
  			<input type="hidden" name="search_line_code" value="<%=storeSearchBean.getLine_code()%>">      			
  			<input type="hidden" name="search_station_code" value="<%=storeSearchBean.getStation_code()%>">      			      			
  			<input type="hidden" name="search_area_code_1" value="<%=storeSearchBean.getArea_code_1()%>">      			      			      			
  			<input type="hidden" name="search_area_code_2" value="<%=storeSearchBean.getArea_code_2()%>">      			      			
  			<input type="hidden" name="search" value="<%=storeSearchBean.getSearch()%>">      			      			
  			<input type="hidden" name="decodedSearch" value="<%=storeSearchBean.getDecodedSearch()%>">      			      			
  			<input type="hidden" name="search_range" value="<%=storeSearchBean.getSearch_range()%>">      			      			
  			<input type="hidden" name="before" value="<%=storeSearchBean.getBefore()%>">    
  			<input type="hidden" name="all_search" value="<%=storeSearchBean.getAll_search()%>"> 
  			<input type="hidden" name="all_search_range" value="<%=storeSearchBean.getAll_search_range()%>">  
  			<input type="hidden" name="image1" value="<%=storeBean.getPhoto_name1()%>"> 
  			<input type="hidden" name="image2" value="<%=storeBean.getPhoto_name2()%>"> 
  			<input type="hidden" name="image3" value="<%=storeBean.getPhoto_name3()%>"> 
  			<input type="hidden" name="image4" value="<%=storeBean.getPhoto_name4()%>"> 
  			<input type="hidden" name="image5" value="<%=storeBean.getPhoto_name5()%>"> 	
 																			   				
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top" width="736" height="82"><img src="jsp/images/new/store_edit_title.gif"/></td>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					※ 필수항목 (<span class="red-text-w">*</span>표시) 만 입력해도 가능합니다. 선택항목을 입력하면 보다 편리한 정보로 검색되실 수   있습니다. <br />
					※ 일본어명, 한글명 둘 중 하나만 입력 하셔도 등록이 가능합니다. 
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
								<td width="22%" bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>업체명(한글)</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="store_name_k" id="textfield2"  style="width:240px;" value="${StoreBean.store_name_k}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>업체명(일본어)</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="store_name_j" id="textfield3"  style="width:240px;" value="${StoreBean.store_name_j}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">어필 포인트</td>
								 <td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td><input type="text" name="appeal_point" id="textfield4"  style="width:380px;" value="${StoreBean.appeal_point}"/></td>
									</tr>
									<tr>
										<td height="25" valign="bottom"> 간단하게 업체의 소개를 해주세요! </td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">검색어</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="search_word" id="textfield5" style="width:380px;" value="${StoreBean.search_word}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>대분류</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="cate_code_1" id="select2" onchange='return reloadSearch(wf)'>
										${StoreBean.cate_1Tag}
									</select></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>소분류</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="cate_code_2" id="select3">
										${StoreBean.cate_2Tag}
									</select></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">지역정보</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											<select name="area_code_1" id="select4" onchange='reloadCheck(wf)'>
												${StoreBean.area_1Tag}
											</select>
											<select name="area_code_2" id="select5">
												${StoreBean.area_2Tag}
											</select>
										</td>
									</tr>
									<tr>
										<td height="30" align="left" valign="bottom">나머지주소 
										<input type="text" name="area_code_3" id="textfield6"   align="absbottom" style="width:380px;" value="${StoreBean.area_code_3}" /></td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">노선정보</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="line_code" id="select6" onchange='return reloadCheck(wf)'>
										${StoreBean.lineTag}
									</select>
									<select name="station_code" id="select7">
										${StoreBean.stationTag}
									  </select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">홈페이지</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									http://<input type="text" name="url" id="textfield7" class="idForm"  align="absmiddle" style="width:240px;" value="${StoreBean.url}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이메일</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="email" id="textfield8" class="idForm" align="absmiddle" style="width:240px;" value="${StoreBean.email}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>전화번호1</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no1_1" type="text" id="textfield9"  class="idForm" maxlength="4" style="width:50px;" value="${StoreBean.tel_no1_1}" />-
									<input name="tel_no1_2" type="text" id="textfield10" class="idForm" maxlength="4" style="width:50px;" value="${StoreBean.tel_no1_2}" />-
									<input name="tel_no1_3" type="text" id="textfield11" class="idForm" maxlength="4" style="width:50px;" value="${StoreBean.tel_no1_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전화번호2</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no2_1" type="text" id="textfield12" class="idForm" maxlength="4" style="width:50px;" value="${StoreBean.tel_no2_1}" />-
									<input name="tel_no2_2" type="text" id="textfield13" class="idForm" maxlength="4" style="width:50px;" value="${StoreBean.tel_no2_2}" />-
									<input name="tel_no2_3" type="text" id="textfield14" class="idForm" maxlength="4" style="width:50px;" value="${StoreBean.tel_no2_3}" /></td>
							</tr>
							<tr>
							<td bgcolor="#f9faf0" class="table-title-text">팩스</td>
							<td bgcolor="#FFFFFF" class="table-cont-text">
									<input name="fax_no_1" type="text" id="textfield15" class="idForm" maxlength="4" style="width:50px;" value="${StoreBean.fax_no_1}" />-
									<input name="fax_no_2" type="text" id="textfield16" class="idForm" maxlength="4" style="width:50px;" value="${StoreBean.fax_no_2}" />-
									<input name="fax_no_3" type="text" id="textfield17" class="idForm" maxlength="4" style="width:50px;" value="${StoreBean.fax_no_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">영업시간</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="work_time" id="textfield18"   align="absmiddle" style="width:240px;" value="${StoreBean.work_time}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">휴무일</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="rest_day" id="textfield19"   align="absmiddle" style="width:240px;" value="${StoreBean.rest_day}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이미지</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30">
											<c:if test="${!empty StoreBean.photo_path1}">
												<img src="<%=storeBean.getPhoto_path1()%>" align="absmiddle" alt="" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name1" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 1)" />
											<a href="javascript:deletePhoto(1);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty StoreBean.photo_path2}">
												<img src="<%=storeBean.getPhoto_path2()%>" align="absmiddle" alt="" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name2" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 2)" />
											<a href="javascript:deletePhoto(2);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty StoreBean.photo_path3}">
												<img src="<%=storeBean.getPhoto_path3()%>" align="absmiddle" alt="" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name3" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 3)" />
											<a href="javascript:deletePhoto(3);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty StoreBean.photo_path4}">
												<img src="<%=storeBean.getPhoto_path4()%>" align="absmiddle" alt="" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name4" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 4)" />
											<a href="javascript:deletePhoto(4);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty StoreBean.photo_path5}">
												<img src="<%=storeBean.getPhoto_path5()%>" align="absmiddle" alt="" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name5" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 5)" />
											<a href="javascript:deletePhoto(5);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30"><strong class="red-text-w">※</strong>JPEG GIF이외의 확장자,2M이상의 이미지파일은 등록이 되지 않습니다. </td>
									</tr>									
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">상세정보</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<textarea name="detail_info" id="textarea" cols="45" rows="5" style="width:530px;height:300px;">${StoreBean.detail_info}</textarea></td>
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
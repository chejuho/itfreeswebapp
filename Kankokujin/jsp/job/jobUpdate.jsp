<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="job.bean.JobBean, job.bean.JobSearchBean"%>
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
	JobBean jobBean = (JobBean) request.getAttribute("JobBean");
	JobSearchBean jobSearchBean = (JobSearchBean) request.getAttribute("JobSearchBean");
	
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<c:if test="${JobBean.cate_code_1 == 'C10100'}">
	<title><c:out value="사원구인 수정화면"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
</c:if>
<c:if test="${JobBean.cate_code_1 == 'C10200'}">
	<title><c:out value="알바구인 수정화면"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
</c:if>
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
		if(isNull(ff.company_name_k)) {
			alert("회사명을 입력해 주세요.");
			return;
		}
		if(ff.cate_code_2.value.substring(4, 6)=="00") {
			alert("업종을 선택해 주세요.");
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

		ff.action="JobUpdate";
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
		ff.action="JobUpdateOpen";
		ff.submit(); 
		return true;
	}
	function reloadSearch(ff) {
		ff.action="JobUpdateOpen?cate_code_2=C20000";
		ff.submit(); 
		return true;
	}
	function deletePhoto(index) {
		document.wf.action="JobUpdateOpen?del="+index;
		document.wf.submit(); 
		return true;
	}	
	function backDetailPage() {
		document.wf.action="JobDetail";
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
			<input type="hidden" name="user_id" value="<%=jobSearchBean.getUser_id()%>">      						  
	      	<input type="hidden" name="search_cate_code_1" value="<%=jobSearchBean.getCate_code_1()%>">
			<input type="hidden" name="search_cate_code_2" value="<%=jobSearchBean.getCate_code_2()%>">       		
			<input type="hidden" name="search_sex" value="<%=jobSearchBean.getSex()%>">          			      					 										
			<input type="hidden" name="pageNum" value="<%=jobSearchBean.getPageNum()%>"> 
			<input type="hidden" name="pageSize" value="<%=jobSearchBean.getPageSize()%>">          			      					 				
   			<input type="hidden" name="search" value="<%=jobSearchBean.getSearch()%>">      			      			
   			<input type="hidden" name="search_range" value="<%=jobSearchBean.getSearch_range()%>">      			      			
   			<input type="hidden" name="before" value="<%=jobSearchBean.getBefore()%>">  			
		    <input type="hidden" name="cate_code_1" value="<%=jobBean.getCate_code_1()%>">			    				   			
			<input type="hidden" name="id"	value="<%=jobBean.getId()%>">			
   			<input type="hidden" name="image1" value="<%=jobBean.getPhoto_name1()%>"> 
   			<input type="hidden" name="image2" value="<%=jobBean.getPhoto_name2()%>"> 
   			<input type="hidden" name="image3" value="<%=jobBean.getPhoto_name3()%>"> 
   			<input type="hidden" name="image4" value="<%=jobBean.getPhoto_name4()%>"> 
   			<input type="hidden" name="image5" value="<%=jobBean.getPhoto_name5()%>">
   			<input type="hidden" name="all_search" value="<%=jobSearchBean.getAll_search()%>"> 
   			<input type="hidden" name="all_search_range" value="<%=jobSearchBean.getAll_search_range()%>">       	
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><!--이미지수정예정 -->
				<!--사원-->
				<c:if test="${JobBean.cate_code_1 == 'C10100'}">
					<td valign="top" width="736" height="82"><img src="jsp/images/new/edit_title_staff_job.gif"/></td>
				</c:if>
				<!--알바-->
				<c:if test="${JobBean.cate_code_1 == 'C10200'}">
					<td valign="top" width="736" height="82"><img src="jsp/images/new/edit_title_arbeit_job.gif"/></td>
				</c:if>
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
									<input type="text" name="title" id="textfield2"  style="width:400px;" value="${JobBean.title}" maxlength="42"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>회사명</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="company_name_k" id="textfield3"  style="width:240px;" value="${JobBean.company_name_k}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>업종</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="cate_code_2" id="select3">
										${JobBean.cate_2Tag}
									</select></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">지역정보</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											<select name="area_code_1" id="select4" onchange='return reloadCheck(wf)'>
												${JobBean.area_1Tag}
											</select>
											<select name="area_code_2" id="select5">
												${JobBean.area_2Tag}
											</select>
										</td>
									</tr>
									<tr>
										<td height="30" align="left" valign="bottom">나머지주소 
										<input type="text" name="area_code_3" id="textfield6"   align="absbottom" style="width:380px;" value="${JobBean.area_code_3}" /></td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">노선정보</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="line_code" id="select6" onchange='return reloadCheck(wf)'>
										${JobBean.lineTag}
									</select>
									<select name="station_code" id="select7">
										${JobBean.stationTag}
									  </select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">홈페이지</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									http://<input type="text" name="url" id="textfield7"   align="absmiddle" style="width:240px;" value="${JobBean.url}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이메일</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="email" id="textfield8"   align="absmiddle" style="width:240px;" value="${JobBean.email}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>전화번호1</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no1_1" type="text" id="textfield9"  maxlength="4" style="width:50px;" value="${JobBean.tel_no1_1}" />-
									<input name="tel_no1_2" type="text" id="textfield10" maxlength="4" style="width:50px;" value="${JobBean.tel_no1_2}" />-
									<input name="tel_no1_3" type="text" id="textfield11" maxlength="4" style="width:50px;" value="${JobBean.tel_no1_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전화번호2</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no2_1" type="text" id="textfield12" maxlength="4" style="width:50px;" value="${JobBean.tel_no2_1}" />-
									<input name="tel_no2_2" type="text" id="textfield13" maxlength="4" style="width:50px;" value="${JobBean.tel_no2_2}" />-
									<input name="tel_no2_3" type="text" id="textfield14" maxlength="4" style="width:50px;" value="${JobBean.tel_no2_3}" /></td>
							</tr>
							<tr>
								<td width="22%" bgcolor="#f9faf0" class="table-title-text">담당자명</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="charge" id="textfield2"  style="width:400px;" value="${JobBean.charge}" maxlength="20"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">성별</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<select name='sex'>
										<option value='0' <%=jobBean.getSex_selected(0)%>>남녀무관</option>
										<option value='1' <%=jobBean.getSex_selected(1)%>>남</option>
										<option value='2' <%=jobBean.getSex_selected(2)%>>여</option>						
									</select>
								</td>
							</tr>
							<tr>
								<td width="22%" bgcolor="#f9faf0" class="table-title-text">급여조건</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="pay" id="textfield2"  style="width:250px;" value="${JobBean.pay}" maxlength="30"/></td>
							</tr>
							<tr>
								<td width="22%" bgcolor="#f9faf0" class="table-title-text">근무시간</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="work_time" id="textfield2"  style="width:250px;" value="${JobBean.work_time}" maxlength="30"/>ex)9:00~18:00</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이미지</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30">
											<c:if test="${!empty JobBean.photo_path1}">
												<img src="${JobBean.photo_path1}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name1" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 1)" />
											<a href="javascript:deletePhoto(1);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty JobBean.photo_path2}">
												<img src="${JobBean.photo_path2}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name2" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 2)" />
											<a href="javascript:deletePhoto(2);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty JobBean.photo_path3}">
												<img src="${JobBean.photo_path3}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name3" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 3)" />
											<a href="javascript:deletePhoto(3);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty JobBean.photo_path4}">
												<img src="${JobBean.photo_path4}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name4" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 4)" />
											<a href="javascript:deletePhoto(4);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty JobBean.photo_path5}">
												<img src="${JobBean.photo_path5}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name5" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 5)" />
											<a href="javascript:deletePhoto(5);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
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
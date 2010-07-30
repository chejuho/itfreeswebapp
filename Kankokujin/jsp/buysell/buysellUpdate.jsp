<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean"%>
<%@ page import="buysell.bean.BuySellBean, buysell.bean.BuySellSearchBean"%>
<%@page import="common.constant.Const"%>
<%@page import="common.util.Util"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<% 
	request.setCharacterEncoding("UTF-8");
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
	BuySellSearchBean buySellSearchBean = (BuySellSearchBean) request.getAttribute("BuySellSearchBean");
	BuySellBean buySellBean = (BuySellBean) request.getAttribute("BuySellBean");	
	if (member == null) {
%>
<script language="javascript">
				alert("로그인을 해주세요.");
				location.href="";
			</script>
<%
}
%>


<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
	<title><c:out value="물건사기 수정화면"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
</c:if>
<c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
	<title><c:out value="물건팔기 수정화면"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
	function sellRadioCheck(value){
 		if(value == "1" ) {
		 	document.wf.free_price.disabled=false;
		 	document.wf.price.disabled=true;
		 	document.wf.price.value=0;		 	
		 	document.wf.price_unit.disabled=true;
	 	}else if(value == "0" ){
 			document.wf.free_price.disabled=true;
			document.wf.price.disabled=false;
			document.wf.price_unit.disabled=false;
		}
	}
	function buyRadioCheck(value){
 		if(value == "1" ) {
		 	document.wf.free_price.disabled=false;
		 	document.wf.price.disabled=true;
		 	document.wf.price.value=0;		 	
		}else if(value == "0" ){
 			document.wf.free_price.disabled=true;
			document.wf.price.disabled=false;
		}
	}
	function isValidFormat(obj,format) {
	
		if(obj.value.search(format) != -1) {
			return true;
		}
		return false;
	}
	function isNumber(obj) {
		var str = obj.value;
		if(str.length == 0){
		
			return false;
		}
		for(var i=0; i < str.length; i++) {
			if(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
				return false;
		}
		return true;
	}
	function isPhoneNumber(obj) {
		if(obj.value == "") {
			return true;
		}
		var format = /^(\d+)-(\d+)-(\d+)$/;
		return isValidFormat(obj,format);
	}	
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}

	function buyUpdateCheck(ff) {
		ID = /^[0-9]{1,4}/;
		if(isNull(ff.title)) {
			alert("글제목을 입력해 주세요.");
			return;
		}
		
		if(ff.cate_code_2.value.substring(4, 6)=="00") {		
			alert("분류를 선택해주세요.");
			return;
		}		
		if(!isNull(ff.email) && !isEmail(ff.email.value)) {
			alert("예)itfrees@itfrees.com형식으로 입력해주세요.");
			return;
		}		
		if(!telephoneNoCheck(ff.tel_no1_1, ff.tel_no1_2, ff.tel_no1_3)) {
			alert("전화번호1이 전화번호 형식에 맞지 않습니다. ");
			return;
		} 
		if(!telephoneNoCheck(ff.tel_no2_1, ff.tel_no2_2, ff.tel_no2_3)) {
			alert("전화번호2이 전화번호 형식에 맞지 않습니다. ");
			return;
		}  

		ff.action="BuySellUpdate";
		ff.submit(); 
		return true;
	}		
	function sellUpdateCheck(ff) {
		ID = /^[0-9]{1,4}/;
		if(isNull(ff.title)) {
			alert("글제목을 입력해 주세요.");
			return false;
		}	
		if(ff.cate_code_2.value.substring(4, 6)=="00") {
			alert("분류를 선택해주세요.");
			return false;
		}
		if(!isNull(ff.price) && !isNumber(ff.price)) {
			alert("가격은 숫자로 입력해주세요.");
			return false;
		}		
		if(!isNull(ff.email) && !isEmail(ff.email.value)) {
			alert("예)itfrees@itfrees.com형식으로 입력해주세요.");
			return false;
		}				
		if(!telephoneNoCheck(ff.tel_no1_1, ff.tel_no1_2, ff.tel_no1_3)) {
			alert("전화번호1이 전화번호 형식에 맞지 않습니다. ");
			return;
		} 
		if(!telephoneNoCheck(ff.tel_no2_1, ff.tel_no2_2, ff.tel_no2_3)) {
			alert("전화번호2이 전화번호 형식에 맞지 않습니다. ");
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

		ff.action="BuySellUpdate";
		ff.submit(); 
		return true;
	}		
	function isNumber(obj) {
		var str = obj.value;
		if(str.length == 0){
		
			return false;
		}
		for(var i=0; i < str.length; i++) {
			if(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
				return false;
		}
		return true;
	}	
	function isEmail(obj) {
	    var format = /^[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+)*@[0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*$/;
		if (obj.search(format) != -1){
			return true;		
		}else {
			return false;		
		}	
	}
	function backDetailPage() {
		document.wf.action="BuySellDetail";
		document.wf.submit(); 
		return true;
	}	
	function deletePhoto(index) {
		document.wf.action="BuySellUpdateOpen?del="+index;
		document.wf.submit(); 
		return true;
	}	
	function reloadUpdate(ff) {
		
		ff.action="BuySellUpdateOpen";
		ff.submit(); 
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
   			<input type="hidden" name="cate_code_1"	value="<%=buySellBean.getCate_code_1()%>">
			<input type="hidden" name="user_id"	value="<%=buySellSearchBean.getUser_id()%>">
			<input type="hidden" name="id"	value="<%=buySellBean.getId()%>">			
		    <input type="hidden" name="search_cate_code_1" value="<%=buySellSearchBean.getCate_code_1()%>">
  			<input type="hidden" name="search_cate_code_2" value="<%=buySellSearchBean.getCate_code_2()%>">
  			<input type="hidden" name="search_pro_status" value="<%=buySellSearchBean.getPro_status()%>">      			
  			<input type="hidden" name="search_free_price" value="<%=buySellSearchBean.getFree_price()%>">      			      			      			
  			<input type="hidden" name="search_member_sort" value="<%=buySellSearchBean.getMember_sort()%>">      			      			      			
  			<input type="hidden" name="search_sold_out" value="<%=buySellSearchBean.getSold_out()%>">      			      			
  			<input type="hidden" name="search_send_method" value="<%=buySellSearchBean.getSend_method()%>">      			      			      			
  			<input type="hidden" name="search_range" value="<%=buySellSearchBean.getSearch_range()%>">      			      			      			
  			<input type="hidden" name="search" value="<%=buySellSearchBean.getSearch()%>">      			      			
  			<input type="hidden" name="pageNum" value="<%=buySellSearchBean.getPageNum()%>">      			  			      			
  			<input type="hidden" name="pageSize" value="<%=buySellSearchBean.getPageSize()%>">      			  			      			      			
  			<input type="hidden" name="before" value="<%=buySellSearchBean.getBefore()%>">   
   			<input type="hidden" name="list_view" value="<%=buySellSearchBean.getList_view()%>">   
			<input type="hidden" name="all_search" value="<%=buySellSearchBean.getAll_search()%>"> 
  			<input type="hidden" name="all_search_range" value="<%=buySellSearchBean.getAll_search_range()%>">   																			   				
  			<input type="hidden" name="image1" value="<%=buySellBean.getPhoto_name1()%>"> 
  			<input type="hidden" name="image2" value="<%=buySellBean.getPhoto_name2()%>"> 
  			<input type="hidden" name="image3" value="<%=buySellBean.getPhoto_name3()%>"> 
  			<input type="hidden" name="image4" value="<%=buySellBean.getPhoto_name4()%>"> 
  			<input type="hidden" name="image5" value="<%=buySellBean.getPhoto_name5()%>">     
 		
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<!--물건사기-->
			<c:if test="${BuySellBean.cate_code_1 == 'C10100'}">  
			<tr><!--등록이미지 수정예정 -->
				<td valign="top" width="736" height="82"><img src="jsp/images/new/buy_edit_title.gif"/></td>
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
								<td width="22%" bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>글제목</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
								<input type="text" name="title" id="textfield2" style="width:440px;" value="${BuySellBean.title}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>분류</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="cate_code_2" id="select2">
										${BuySellBean.cate_2Tag}
										<option>선택해주세요</option>
									</select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">제품상태</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="pro_status">
									<option value='0' <%= buySellBean.getPro_status()%>>선택해주세요</option>								
									<option value='1' <%= buySellBean.getPro_status_used() %>>중고</option>
									<option value='2' <%= buySellBean.getPro_status_almonew()%>>신제품</option>						
								</select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">희망거래가격</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="radio" name="free_price" value="0" onclick="buyRadioCheck(0)" <%if("0".equals(buySellBean.getFree_price())){%>checked<%}%>>
									<input type="text" name="price" id="textfield5"  style="width:180px;" value="${BuySellBean.price}"/>
									<input type="radio" name="free_price" value="1" onClick="buyRadioCheck(1)" <%if("1".equals(buySellBean.getFree_price())){%>checked<%}%>>무료
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">배송방식</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name='send_method'>
									<option value='0' <%= buySellBean.getSend_no_matter() %>>직거래 or 택배</option>
									<option value='1' <%= buySellBean.getSend_direct()%>>직거래</option>
									<option value='2' <%= buySellBean.getSend_post()%>>택배</option>						
								</select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">희망거래장소</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="sell_place" id="textfield5"  style="width:240px;" value="${BuySellBean.sell_place}"/>(예: JR야마노테센 오오쿠보역)
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이메일</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="email" id="textfield8" class="idForm" align="absmiddle" style="width:240px;" value="${BuySellBean.email}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전화번호1</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no1_1" type="text" id="textfield9"  class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no1_1}" />-
									<input name="tel_no1_2" type="text" id="textfield10" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no1_2}" />-
									<input name="tel_no1_3" type="text" id="textfield11" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no1_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전화번호2</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no2_1" type="text" id="textfield12" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no2_1}" />-
									<input name="tel_no2_2" type="text" id="textfield13" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no2_2}" />-
									<input name="tel_no2_3" type="text" id="textfield14" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no2_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">상세정보</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<textarea name="detail_info" id="textarea" cols="45" rows="5" style="width:530px;height:300px;">${BuySellBean.detail_info}</textarea></td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
					</form>
				</td>
			</tr>
			</c:if>
			<!--물건팔기-->
			<c:if test="${BuySellBean.cate_code_1 == 'C10200'}">  
			<tr><!--등록이미지 수정예정 -->
				<td valign="top" width="736" height="82"><img src="jsp/images/new/sell_edit_title.gif"/></td>
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
								<td width="22%" bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>글제목</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
								<input type="text" name="title" id="textfield2"  style="width:440px;" value="${BuySellBean.title}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>분류</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="cate_code_2" id="select2">
										${BuySellBean.cate_2Tag}
									</select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">제품상태</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="pro_status">
									<option value='0' <%= buySellBean.getPro_status()%>>선택해주세요</option>								
									<option value='1' <%= buySellBean.getPro_status_used() %>>중고</option>
									<option value='2' <%= buySellBean.getPro_status_almonew()%>>신제품</option>						
								</select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">판매자구분</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="member_sort">
									<option value='1' <%= buySellBean.getMember_ama()%>>개인회원</option>								
									<option value='2' <%= buySellBean.getMember_pro() %>>업자회원</option>				
								</select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">가격</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="radio" name="free_price" value="0" onclick="sellRadioCheck(0)" <%if("0".equals(buySellBean.getFree_price())){%>checked<%}%>>
									<input type="text" name="price" id="textfield5"  style="width:180px;" value="${BuySellBean.price}" />
									 <select name="price_unit">
										<option value="0">엔</option>
										<option value="1">원</option>
									</select>(통화단위)<input type="radio" name="free_price" value="1" onclick="sellRadioCheck(1)" <%if("1".equals(buySellBean.getFree_price())){%>checked<%}%>>무료
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">배송방식</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name='send_method'>
									<option value='0' <%= buySellBean.getSend_no_matter() %>>직거래 or 택배</option>
									<option value='1' <%= buySellBean.getSend_direct()%>>직거래</option>
									<option value='2' <%= buySellBean.getSend_post()%>>택배</option>						
								</select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">희망거래장소</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="sell_place" id="textfield5"  style="width:240px;" value="${BuySellBean.sell_place}"/>(예: JR야마노테센 오오쿠보역)
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이메일</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="email" id="textfield8" class="idForm" align="absmiddle" style="width:240px;" value="${BuySellBean.email}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전화번호1</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no1_1" type="text" id="textfield9"  class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no1_1}" />-
									<input name="tel_no1_2" type="text" id="textfield10" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no1_2}" />-
									<input name="tel_no1_3" type="text" id="textfield11" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no1_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전화번호2</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no2_1" type="text" id="textfield12" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no2_1}" />-
									<input name="tel_no2_2" type="text" id="textfield13" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no2_2}" />-
									<input name="tel_no2_3" type="text" id="textfield14" class="idForm" maxlength="4" style="width:50px;" value="${BuySellBean.tel_no2_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이미지</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30">
											<c:if test="${!empty BuySellBean.photo_path1}">
												<img src="${BuySellBean.photo_path1}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name1" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 1)" />
											<a href="javascript:deletePhoto(1);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty BuySellBean.photo_path2}">
												<img src="${BuySellBean.photo_path2}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name2" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 2)" />
											<a href="javascript:deletePhoto(2);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty BuySellBean.photo_path3}">
												<img src="${BuySellBean.photo_path3}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name3" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 3)" />
											<a href="javascript:deletePhoto(3);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty BuySellBean.photo_path4}">
												<img src="${BuySellBean.photo_path4}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name4" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 4)" />
											<a href="javascript:deletePhoto(4);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty BuySellBean.photo_path5}">
												<img src="${BuySellBean.photo_path5}" alt="" align="absmiddle" width="30" height="30">
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
									<textarea name="detail_info" id="textarea" cols="45" rows="5" style="width:530px;height:300px;">${BuySellBean.detail_info}</textarea></td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
					</form>
				</td>
			</tr>
			</c:if>			
			<tr>
				<td align="center" valign="top">
					<!--물건사기-->
					<c:if test="${BuySellBean.cate_code_1 == 'C10100'}">
						<!--등록버튼 -->
						<a href="javascript:buyUpdateCheck(wf);"><img src="jsp/images/new/btn_edit_ok.gif" /></a>&nbsp;
					</c:if>
					<!--물건팔기-->					
					<c:if test="${BuySellBean.cate_code_1 == 'C10200'}">
						<!--등록버튼 -->
						<a href="javascript:sellUpdateCheck(wf);"><img src="jsp/images/new/btn_edit_ok.gif" /></a>&nbsp;
					</c:if>
					<a href="javascript:backDetailPage();"><img src="jsp/images/new/btn_back_page.gif" /></a></td>
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
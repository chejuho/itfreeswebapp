<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="housesell.bean.HouseBean, housesell.bean.HouseSearchBean"%>
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
HouseBean houseBean = (HouseBean) request.getAttribute("HouseBean");
HouseSearchBean houseSearchBean = (HouseSearchBean) request.getAttribute("HouseSearchBean");
%>

<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title><c:out value="부동산 수정화면"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
	function radioCheckDock(value){
 		if(value == "1" ) {
		 	document.wf.come_dock_year.disabled=true;
		 	document.wf.come_dock_month.disabled=true;
	 	}else if(value == "2" ){
 			document.wf.come_dock_year.disabled=false;
			document.wf.come_dock_month.disabled=false;
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
	function modifycheck(ff) {
		ID = /^[0-9]{1,4}/;
		if(isNull(ff.title)) {
			alert("제목을 입력해 주세요.");
			return;
		}
		if(!isNull(ff.build_year) && !isNumber(ff.build_year)) {
			alert("건축년도(년)은 숫자로 입력해주세요.");
			return;
		}	
	
		if(!isNull(ff.build_month) && !isNumber(ff.build_month)) {
			alert("건축년도(월)은 숫자로 입력해주세요.");
			return;
		}	
		if(!isNull(ff.all_stairs) && !isNumber(ff.all_stairs)) {
			alert("전체층수는 숫자로 입력해주세요.");
			return;
		}
		
		if(!isNull(ff.stairs) && !isNumber(ff.stairs)) {
			alert("층은 숫자로 입력해주세요.");
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
		if(!isNull(ff.walk_time) && !isNumber(ff.walk_time)) {
			alert("도보시간은 숫자로 입력해주세요.");
			return;
		}	
		if(!isNull(ff.come_dock_year) && !isNumber(ff.come_dock_year)) {
			alert("입거가능일(년)은 숫자로 입력해주세요.");
			return;
		}

		if(!isNull(ff.come_dock_month) && !isNumber(ff.come_dock_month)) {
			alert("입거가능일(월)은 숫자로 입력해주세요.");
			return;
		}				
		if(!isNull(ff.house_fee) && !isNumSosu(ff.house_fee)) {
			
			alert("야칭은 숫자로 입력해주세요.");
			return;
		}

		if(!isNull(ff.manage_fee) && !isNumSosu(ff.manage_fee)) {
			alert("관리비/기타은 숫자로 입력해주세요.");
			return;
		}
		
		if(!isNull(ff.deposit) && !isNumSosu(ff.deposit)) {
			alert("시끼낑은 숫자로 입력해주세요.");
			return;
		}
		if(!isNull(ff.reikin) && !isNumSosu(ff.reikin)) {
			alert("레이낑은 숫자로 입력해주세요.");
			return;
		}	
		if(!isNull(ff.guaranty_money) && !isNumSosu(ff.guaranty_money)) {
			alert("보증금은 숫자로 입력해주세요.");
			return;
		}	

		if(!isNull(ff.dimension) && !isNumSosu(ff.dimension)) {
			alert("전용면적은 숫자로 입력해주세요.");
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
		ff.action="HouseSellUpdate?";
		ff.submit(); 
		return true;
		
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
		ff.action="HouseSellUpdateOpen";
		ff.submit(); 
		return true;
	}	
	function containsCharsOnly(input,chars) {
	    for (var inx = 0; inx < input.value.length; inx++) {

	       if (chars.indexOf(input.value.charAt(inx)) == -1){
	           return false;
	       } else {
	           
	       }
	    }
	    return true;
	}
	function isNumComma(input) {
		
	    var chars = ",0123456789";
	    return containsCharsOnly(input,chars);
	}	
	function isNumSosu(input) {
	    var chars = ".0123456789";
	    return containsCharsOnly(input,chars);
	}
	function backDetailPage() {
		document.wf.action="HouseSellDetail";
		document.wf.submit(); 
		return true;
	}	
	function deletePhoto(index) {
		document.wf.action="HouseSellUpdateOpen?del="+index;
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
			<input type="hidden" name="id" value="<%=houseBean.getId() %>">
			<input type="hidden" name="image1" value="<%=houseBean.getPhoto_name1()%>"> 
   			<input type="hidden" name="image2" value="<%=houseBean.getPhoto_name2()%>"> 
   			<input type="hidden" name="image3" value="<%=houseBean.getPhoto_name3()%>"> 
   			<input type="hidden" name="image4" value="<%=houseBean.getPhoto_name4()%>"> 
   			<input type="hidden" name="image5" value="<%=houseBean.getPhoto_name5()%>"> 
   			<input type="hidden" name="before" value="<%=houseSearchBean.getBefore()%>">      						
			<input type="hidden" name="user_id" value="<%=houseSearchBean.getUser_id()%>">      						
  			<input type="hidden" name="pageSize" value="<%=houseSearchBean.getPageSize()%>">      			
  			<input type="hidden" name="pageNum" value="<%=houseSearchBean.getPageNum()%>">      			  			      			      							
			<input type="hidden" name="search_area_code_1" value="<%=houseSearchBean.getArea_code_1()%>">      										
			<input type="hidden" name="search_area_code_2" value="<%=houseSearchBean.getArea_code_2()%>">      														
			<input type="hidden" name="search_line_code" value="<%=houseSearchBean.getLine_code()%>">      						
			<input type="hidden" name="search_station_code" value="<%=houseSearchBean.getStation_code()%>">      										
			<input type="hidden" name="search_walk_time" value="<%=houseSearchBean.getWalk_time()%>">      						
			<input type="hidden" name="search_regist_date" value="<%=houseSearchBean.getRegist_date()%>">      										
			<input type="hidden" name="search_build_year" value="<%=houseSearchBean.getBuild_year()%>">      						
			<input type="hidden" name="search_flg_tadami" value="<%=houseSearchBean.getFlg_tadami()%>">      										
			<input type="hidden" name="search_toilet" value="<%=houseSearchBean.getToilet()%>">      														
			<input type="hidden" name="house_fee_from" value="<%=houseSearchBean.getHouse_fee(0)%>">      														
			<input type="hidden" name="house_fee_to" value="<%=houseSearchBean.getHouse_fee(1)%>">      														
			<input type="hidden" name="dimension_1" value="<%=houseSearchBean.getDimension(0)%>">      														
			<input type="hidden" name="dimension_2" value="<%=houseSearchBean.getDimension(1)%>">      														
			<input type="hidden" name="madori_0" value="<%=houseSearchBean.getMadori(0)%>">      														
			<input type="hidden" name="madori_1" value="<%=houseSearchBean.getMadori(1)%>">      														
			<input type="hidden" name="madori_2" value="<%=houseSearchBean.getMadori(2)%>">      														
			<input type="hidden" name="madori_3" value="<%=houseSearchBean.getMadori(3)%>">      														
			<input type="hidden" name="madori_4" value="<%=houseSearchBean.getMadori(4)%>">      														
			<input type="hidden" name="madori_5" value="<%=houseSearchBean.getMadori(5)%>">      														
			<input type="hidden" name="madori_6" value="<%=houseSearchBean.getMadori(6)%>">      														
			<input type="hidden" name="madori_7" value="<%=houseSearchBean.getMadori(7)%>">      														
			<input type="hidden" name="madori_8" value="<%=houseSearchBean.getMadori(8)%>">      																						
			<input type="hidden" name="madori_9" value="<%=houseSearchBean.getMadori(9)%>">      														
			<input type="hidden" name="madori_10" value="<%=houseSearchBean.getMadori(10)%>">      														
			<input type="hidden" name="madori_11" value="<%=houseSearchBean.getMadori(11)%>">      														
			<input type="hidden" name="house_sort_0" value="<%=houseSearchBean.getHouse_sort(0)%>">      														
			<input type="hidden" name="house_sort_1" value="<%=houseSearchBean.getHouse_sort(1)%>">      														
			<input type="hidden" name="house_sort_2" value="<%=houseSearchBean.getHouse_sort(2)%>">      														
			<input type="hidden" name="house_sort_3" value="<%=houseSearchBean.getHouse_sort(3)%>">      														
			<input type="hidden" name="house_sort_4" value="<%=houseSearchBean.getHouse_sort(4)%>">      																														
			<input type="hidden" name="house_sort_5" value="<%=houseSearchBean.getHouse_sort(5)%>">      														
			<input type="hidden" name="house_sort_6" value="<%=houseSearchBean.getHouse_sort(6)%>">      														
			<input type="hidden" name="house_sort_7" value="<%=houseSearchBean.getHouse_sort(7)%>">      														
			<input type="hidden" name="house_option_0" value="<%=houseSearchBean.getHouse_option(0)%>">      														
			<input type="hidden" name="house_option_1" value="<%=houseSearchBean.getHouse_option(1)%>">      														
			<input type="hidden" name="house_option_2" value="<%=houseSearchBean.getHouse_option(2)%>">      														
			<input type="hidden" name="house_option_3" value="<%=houseSearchBean.getHouse_option(3)%>">
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top" width="736" height="82"><img src="jsp/images/new/housesell_edit_title.gif"/></td>
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
									<input type="text" name="title" id="textfield2"  style="width:400px;" value="${HouseBean.title}" maxlength="42"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">집물건명</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="house_name" id="textfield3"  style="width:200px;" value="${HouseBean.house_name}" maxlength="20"/>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">건축년도</td>
								 <td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="build_year" id="textfield3"  style="width:55px;" value="${HouseBean.build_year}" maxlength="4"/>년
									<input type="text" name="build_month" id="textfield3"  style="width:40px;" value="${HouseBean.build_month}" maxlength="2"/>월</td>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">건물층수</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="all_stairs" id="textfield3"  style="width:45px;" value="${HouseBean.all_stairs}" maxlength="3"/>층 건물에
									<input type="text" name="stairs" id="textfield3"  style="width:40px;" value="${HouseBean.stairs}" maxlength="3"/>층(예.5층건물에 3층)</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">건물종류</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input value="0" type="radio" name="house_sort" <%=houseBean.getHouse_sort_checked(0)%> />아파트
									<input value="1" type="radio" name="house_sort" <%=houseBean.getHouse_sort_checked(1)%> />맨션
									<input value="2" type="radio" name="house_sort" <%=houseBean.getHouse_sort_checked(2)%> />개인주택
									<input value="3" type="radio" name="house_sort" <%=houseBean.getHouse_sort_checked(3)%> />주차장<br />
									<input value="4" type="radio" name="house_sort" <%=houseBean.getHouse_sort_checked(4)%> />점포
									<input value="5" type="radio" name="house_sort" <%=houseBean.getHouse_sort_checked(5)%> />사무실
									<input value="6" type="radio" name="house_sort" <%=houseBean.getHouse_sort_checked(6)%> />토지
									<input value="7" type="radio" name="house_sort" <%=houseBean.getHouse_sort_checked(7)%> />기타
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">지역정보</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											<select name="area_code_1" id="select4" onchange='return reloadCheck(wf)'>
												${HouseBean.area_1Tag}
											</select>
											<select name="area_code_2" id="select5">
												${HouseBean.area_2Tag}
											</select>
										</td>
									</tr>
									<tr>
										<td height="30" align="left" valign="bottom">나머지주소 
										<input type="text" name="area_code_3" id="textfield6"   align="absbottom" style="width:380px;" value="${HouseBean.area_code_3}" /></td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">노선정보</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="line_code" id="select6" onchange='return reloadCheck(wf)'>
										${HouseBean.lineTag}
									</select>
									<select name="station_code" id="select7">
										${HouseBean.stationTag}
									</select> 역에서 도보 <input type="text" name="walk_time" id="textfield3"  style="width:45px;" value="${HouseBean.walk_time}" maxlength="2"/>분
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">입거가능일</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input value="0" type="radio" name="come_dock" <%=houseBean.getCome_dockChecked(0)%> onclick="radioCheckDock(1)" />즉시&nbsp;&nbsp;&nbsp;
									<input value="1" type="radio" name="come_dock" <%=houseBean.getCome_dockChecked(1)%> onclick="radioCheckDock(2)" />지정일&nbsp;
									<input type="text" name="come_dock_year" id="textfield7" align="absmiddle" style="width:50px;" value="${HouseBean.come_dock_year}" <%=houseBean.getCome_dock_disabled()%> maxlength="4"/>년(2008)
									<input type="text" name="come_dock_month" id="textfield7" align="absmiddle" style="width:50px;" value="${HouseBean.come_dock_month}" <%=houseBean.getCome_dock_disabled()%> maxlength="2"/>월(07)
									
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">야칭</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="house_fee" id="textfield7"   align="absmiddle" style="width:55px;" value="${HouseBean.house_fee[0]}" maxlength="5"/>
									&nbsp;만엔&nbsp;&nbsp;(야칭은 3.0의 형식으로 소수점 단위로 입력해주세요.)
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">관리비/기타</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="manage_fee" id="textfield7"   align="absmiddle" style="width:55px;" value="${HouseBean.manage_fee}" maxlength="5"/>
									&nbsp;만엔&nbsp; / 시끼낑
									<input type="text" name="deposit" id="textfield7"   align="absmiddle" style="width:50px;" value="${HouseBean.deposit}" maxlength="4"/>
									&nbsp;개월분 / 레이낑
									<input type="text" name="reikin" id="textfield7"   align="absmiddle" style="width:50px;" value="${HouseBean.reikin}" maxlength="4"/>
									&nbsp;개월분/ 보증금
									<input type="text" name="guaranty_money" id="textfield7"   align="absmiddle" style="width:50px;" value="${HouseBean.guaranty_money}" maxlength="4"/>
									&nbsp;개월분
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전용면적</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="dimension" id="textfield7"   align="absmiddle" style="width:50px;" value="${HouseBean.dimension[0]}" maxlength="5"/>&nbsp;&nbsp;m2
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">마도리</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input value="0" type="radio" name="madori" <%=houseBean.getMadori_checked(0)%> />1R
									<input value="1" type="radio" name="madori" <%=houseBean.getMadori_checked(1)%> />1K
									<input value="2" type="radio" name="madori" <%=houseBean.getMadori_checked(2)%> />1DK
									<input value="3" type="radio" name="madori" <%=houseBean.getMadori_checked(3)%> />1LDK
									<input value="4" type="radio" name="madori" <%=houseBean.getMadori_checked(4)%> />2K
									<input value="5" type="radio" name="madori" <%=houseBean.getMadori_checked(5)%> />2DK 
									<input value="6" type="radio" name="madori" <%=houseBean.getMadori_checked(6)%> />2LDK<br />
									<input value="7" type="radio" name="madori" <%=houseBean.getMadori_checked(7)%> />3DK
									<input value="8" type="radio" name="madori" <%=houseBean.getMadori_checked(8)%> />3LDK
									<input value="9" type="radio" name="madori" <%=houseBean.getMadori_checked(9)%> />4DK
									<input value="10" type="radio" name="madori" <%=houseBean.getMadori_checked(10)%> />4LDK
									<input value="11" type="radio" name="madori" <%=houseBean.getMadori_checked(11)%> />기타<br />
									마도리내역
									<input type="text" name="madori_info" id="textfield7"   align="absmiddle" style="width:350px;" value="${HouseBean.madori_info}" maxlength="50"/><br />
									( ex : 일식6조 양식6조 화장실 샤워및욕조 주차장 베란다 )
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">방구조</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input value="0" type="radio" name="flg_tadami" <%=houseBean.getFlgTadamiChecked()[0]%> />타다미
									<input value="1" type="radio" name="flg_tadami" <%=houseBean.getFlgTadamiChecked()[1]%> />플로링
									<input value="2" type="radio" name="flg_tadami" <%=houseBean.getFlgTadamiChecked()[2]%> />타다미 + 플로링
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">화장실/목욕탕</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input value="0" type="radio" name="toilet" <%=houseBean.getToilet_checked(0)%> />화장실 욕조별도
									<input value="1" type="radio" name="toilet" <%=houseBean.getToilet_checked(1)%> />화장실 욕조동일
									<input value="2" type="radio" name="toilet" <%=houseBean.getToilet_checked(2)%> />샤워만
									<input value="2" type="radio" name="toilet" <%=houseBean.getToilet_checked(3)%> />화장실만
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">방위</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<select name="point_compass" id="select4" >
										<option <%=houseBean.getPoint_compass_selected()[0]%> value="0">선택해주세요</option>
										<option <%=houseBean.getPoint_compass_selected()[1]%> value="1">동향</option>
										<option <%=houseBean.getPoint_compass_selected()[2]%> value="2">서향</option>
										<option <%=houseBean.getPoint_compass_selected()[3]%> value="3">남향</option>
										<option <%=houseBean.getPoint_compass_selected()[4]%> value="4">북향</option>
									</select>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">조건</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input type="checkbox" name="option_0" <%=houseBean.getHouse_option_checked(0)%> />2인입거가능 &nbsp;
									<input type="checkbox" name="option_1" <%=houseBean.getHouse_option_checked(1)%> />가족입거가능&nbsp;
									<input type="checkbox" name="option_2" <%=houseBean.getHouse_option_checked(2)%> />애완동물가능
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이메일</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="email" id="textfield8" class="idForm" align="absmiddle" style="width:240px;" value="${HouseBean.email}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>전화번호1</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no1_1" type="text" id="textfield9"  class="idForm" maxlength="4" style="width:50px;" value="${HouseBean.tel_no1_1}" />-
									<input name="tel_no1_2" type="text" id="textfield10" class="idForm" maxlength="4" style="width:50px;" value="${HouseBean.tel_no1_2}" />-
									<input name="tel_no1_3" type="text" id="textfield11" class="idForm" maxlength="4" style="width:50px;" value="${HouseBean.tel_no1_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전화번호2</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no2_1" type="text" id="textfield12" class="idForm" maxlength="4" style="width:50px;" value="${HouseBean.tel_no2_1}" />-
									<input name="tel_no2_2" type="text" id="textfield13" class="idForm" maxlength="4" style="width:50px;" value="${HouseBean.tel_no2_2}" />-
									<input name="tel_no2_3" type="text" id="textfield14" class="idForm" maxlength="4" style="width:50px;" value="${HouseBean.tel_no2_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">도면</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30">
											<c:if test="${!empty HouseBean.photo_path1}">
												<img src="${HouseBean.photo_path1}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name1" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 1)" />
											<a href="javascript:deletePhoto(1);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									</table>
								</td>
							</tr>
							
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이미지</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30">
											<c:if test="${!empty HouseBean.photo_path2}">
												<img src="${HouseBean.photo_path2}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name2" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 2)" />
											<a href="javascript:deletePhoto(2);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty HouseBean.photo_path3}">
												<img src="${HouseBean.photo_path3}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name3" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 3)" />
											<a href="javascript:deletePhoto(3);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty HouseBean.photo_path4}">
												<img src="${HouseBean.photo_path4}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name4" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 4)" />
											<a href="javascript:deletePhoto(4);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty HouseBean.photo_path5}">
												<img src="${HouseBean.photo_path5}" alt="" align="absmiddle" width="30" height="30">
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
									<textarea name="detail_info" id="textarea" cols="45" rows="5" style="width:530px;height:300px;">${HouseBean.detail_info}</textarea></td>
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
					<a href="javascript:modifycheck(wf);"><img src="jsp/images/new/btn_edit_ok.gif" /></a>&nbsp;
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
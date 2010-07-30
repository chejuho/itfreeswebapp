<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="roomsell.bean.RoomBean, roomsell.bean.RoomSearchBean"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<%
	request.setCharacterEncoding("UTF-8");
	RoomBean roomBean = (RoomBean)request.getAttribute("RoomBean");
	RoomSearchBean roomSearchBean = (RoomSearchBean)request.getAttribute("RoomSearchBean");
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
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
<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
	<title><c:out value="호텔/민박 등록화면"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
</c:if>
<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
	<title><c:out value="기숙사/룸메이트 등록화면"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
		
	function radioCheckDock(value){
 		if(value == "1" ) {
		 	document.wf.come_dock_year.disabled=true;
		 	document.wf.come_dock_month.disabled=true;
	 	}else if(value == "2" ){
 			document.wf.come_dock_year.disabled=false;
			document.wf.come_dock_month.disabled=false;
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
		if(str.length == 0)
			return false;
	
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
	function sellcheck(ff) {
		ID = /^[0-9]{1,4}/;
		if(isNull(ff.title)) {
			alert("글제목을 입력해 주세요.");
			return;
		}

		if(!(document.wf.room_sort[0].checked || document.wf.room_sort[1].checked || 
			document.wf.room_sort[2].checked || document.wf.room_sort[3].checked || 
			document.wf.room_sort[4].checked || document.wf.room_sort[5].checked || 
			document.wf.room_sort[6].checked || document.wf.room_sort[7].checked || 
			document.wf.room_sort[8].checked || document.wf.room_sort[9].checked || 
			document.wf.room_sort[10].checked)) {
			alert("종별을 선택해 주세요.");
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
		if(!isNull(ff.room_fee) && !isNumSosu(ff.room_fee)) {
			
			alert("요금은 숫자로 입력해주세요.");
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
		ff.action="RoomSellRegist";
		ff.submit(); 
		return true;
	}			
	function reloadRegist() {
		document.wf.action="RoomSellRegistOpen";
		document.wf.submit(); 
		return true;
	}	
	function deletePhoto(index) {
		document.wf.action="RoomSellRegistOpen?del="+index;
		document.wf.submit(); 
		return true;
	}	
	function isNumSosu(input) {
	    var chars = ".0123456789";
	    return containsCharsOnly(input,chars);
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
	function backSearch() {

		document.wf.action="RoomSellList?f=b";
		document.wf.submit(); 
		return true;
	}		
//-->
</script>
<body style="margin:0 0 0 0"> 
	<table>
	<jsp:include page="../include/top.jsp" flush="true" />
	<tr>
		<td height="20">&nbsp;</td>
	</tr>
	<tr>
		<td height="35">
			<form name="wf" method="post" enctype="multipart/form-data">
			<input type="hidden" name="cate_code_1" value="<%=roomSearchBean.getCate_code_1()%>">				
			<input type="hidden" name="user_id" value="<%=roomSearchBean.getUser_id()%>">      				
			<input type="hidden" name="pageSize" value="<%=roomSearchBean.getPageSize()%>">          			      					 				      			
  			<input type="hidden" name="pageNum" value="<%=roomSearchBean.getPageNum()%>">      			  			      			
  			<input type="hidden" name="before" value="<%=roomSearchBean.getBefore()%>">      			  			      			      						
  			<input type="hidden" name="room_fee_from" value="<%=roomSearchBean.getRoom_fee_from()%>">       			      			      			      			
  			<input type="hidden" name="room_fee_to" value="<%=roomSearchBean.getRoom_fee_to()%>">       			      			      			      			
  			<input type="hidden" name="room_sort_0" value="<%=roomSearchBean.getRoom_sort()[0]%>">       			      			      			      			
  			<input type="hidden" name="room_sort_1" value="<%=roomSearchBean.getRoom_sort()[1]%>">           			      			      			      			
  			<input type="hidden" name="room_sort_2" value="<%=roomSearchBean.getRoom_sort()[2]%>">           			      			      			      			
  			<input type="hidden" name="room_sort_3" value="<%=roomSearchBean.getRoom_sort()[3]%>">           			      			      			      			
  			<input type="hidden" name="room_sort_4" value="<%=roomSearchBean.getRoom_sort()[4]%>">            			      			      			      			
  			<input type="hidden" name="room_sort_5" value="<%=roomSearchBean.getRoom_sort()[5]%>">            			      			      			      			
  			<input type="hidden" name="room_sort_6" value="<%=roomSearchBean.getRoom_sort()[6]%>">            			      			      			      			
  			<input type="hidden" name="room_sort_7" value="<%=roomSearchBean.getRoom_sort()[7]%>">          			      			      			      			
  			<input type="hidden" name="room_sort_8" value="<%=roomSearchBean.getRoom_sort()[8]%>">         			      			      			      			
  			<input type="hidden" name="room_sort_9" value="<%=roomSearchBean.getRoom_sort()[9]%>">        			      			      			      			
  			<input type="hidden" name="room_sort_10" value="<%=roomSearchBean.getRoom_sort()[10]%>">        			      			      			      			
  			<input type="hidden" name="search_line_code" value="<%=roomSearchBean.getLine_code()%>">       			      			      			      			      			      			      			      			      			
  			<input type="hidden" name="search_station_code" value="<%=roomSearchBean.getStation_code()%>"> 
  			<input type="hidden" name="search_sex" value="<%=roomSearchBean.getSex()%>"> 
  			<input type="hidden" name="search_area_code_1" value="<%=roomSearchBean.getArea_code_1()%>"> 
  			<input type="hidden" name="search_area_code_2" value="<%=roomSearchBean.getArea_code_2()%>"> 
  			<input type="hidden" name="search_room_type" value="<%=roomSearchBean.getRoom_type()%>"> 
  			<input type="hidden" name="search_regist_date" value="<%=roomSearchBean.getRegist_date()%>"> 
  			<input type="hidden" name="search_build_sort" value="<%=roomSearchBean.getBuild_sort()%>">       			      			      			      					      			      			      			
  			<input type="hidden" name="image1" value="<%=roomBean.getPhoto_name1()%>"> 
  			<input type="hidden" name="image2" value="<%=roomBean.getPhoto_name2()%>"> 
  			<input type="hidden" name="image3" value="<%=roomBean.getPhoto_name3()%>"> 
  			<input type="hidden" name="image4" value="<%=roomBean.getPhoto_name4()%>"> 
  			<input type="hidden" name="image5" value="<%=roomBean.getPhoto_name5()%>">  
			<table width="736"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><!--이미지수정예정 -->
				<!--호텔/민박-->
				<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
					<td valign="top" width="736" height="82"><img src="jsp/images/new/hotel_regist_title.gif"/></td>
				</c:if>
				<!--기숙사/룸메이트-->
				<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
					<td valign="top" width="736" height="82"><img src="jsp/images/new/roomate_regist_title.gif" /></td>
				</c:if>
			</tr>
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">
					※ 필수항목 (<span class="red-text-w">*</span>표시) 만 입력해도 가능합니다. 선택항목을 입력하면 보다 편리한 정보로 검색되실 수   있습니다.
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
									<input type="text" name="title" id="textfield2"  style="width:400px;" value="${RoomBean.title}" maxlength="42"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>종별</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
								<!--호텔/민박-->
								<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
									<input type="radio" name="room_sort" value="0" <%=roomBean.getRoom_sort_checked("0")%> style=display:none>                    
									<input type="radio" name="room_sort" value="1" <%=roomBean.getRoom_sort_checked("1")%> style=display:none>                    
									<input type="radio" name="room_sort" value="2" <%=roomBean.getRoom_sort_checked("2")%> style=display:none>                   
									<input type="radio" name="room_sort" value="5" <%=roomBean.getRoom_sort_checked("5")%> style=display:none>                 
									<input type="radio" name="room_sort" value="3" <%=roomBean.getRoom_sort_checked("3")%> style=display:none>
									<input type="radio" name="room_sort" value="4" <%=roomBean.getRoom_sort_checked("4")%> style=display:none>
									<input type="radio" name="room_sort" value="6" <%=roomBean.getRoom_sort_checked("6")%> style=display:none> 
			                  		<input type="radio" name="room_sort" value="8" <%=roomBean.getRoom_sort_checked("8")%>>민박                     
		                 	 		<input type="radio" name="room_sort" value="9" <%=roomBean.getRoom_sort_checked("9")%>>비지니스호텔                    
		                  			<input type="radio" name="room_sort" value="10" <%=roomBean.getRoom_sort_checked("10")%>>호텔   
		                  			<input type="radio" name="room_sort" value="7" <%=roomBean.getRoom_sort_checked("7")%>>게스트하우스	
								</c:if>
								<!--기숙사/룸메이트-->
								<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
									<input type="radio" name="room_sort" value="0" <%=roomBean.getRoom_sort_checked("0")%>>일반기숙사                     
									<input type="radio" name="room_sort" value="1" <%=roomBean.getRoom_sort_checked("1")%>>원룸형기숙사                    
									<input type="radio" name="room_sort" value="2" <%=roomBean.getRoom_sort_checked("2")%>>맨션형기숙사                   
									<input type="radio" name="room_sort" value="5" <%=roomBean.getRoom_sort_checked("5")%>>고급기숙사<br>                   
									<input type="radio" name="room_sort" value="3" <%=roomBean.getRoom_sort_checked("3")%>>룸메이트
									<input type="radio" name="room_sort" value="4" <%=roomBean.getRoom_sort_checked("4")%>>홈스테이
									<input type="radio" name="room_sort" value="6" <%=roomBean.getRoom_sort_checked("6")%>>먼슬리맨션  					
									<input type="radio" name="room_sort" value="8" <%=roomBean.getRoom_sort_checked("8")%> style=display:none>                     
									<input type="radio" name="room_sort" value="9" <%=roomBean.getRoom_sort_checked("9")%> style=display:none>                    
									<input type="radio" name="room_sort" value="10" <%=roomBean.getRoom_sort_checked("10")%> style=display:none>   
									<input type="radio" name="room_sort" value="7" <%=roomBean.getRoom_sort_checked("7")%> style=display:none>		
								</c:if>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">방물건명</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="room_name" id="textfield7"   align="absmiddle" style="width:220px;" value="${RoomBean.room_name}" maxlength="20"/></td>
							</tr>
							<!--기숙사/룸메이트-->
							<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">건물종류</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="radio" name="build_sort" value="0" <%=roomBean.getBuild_sort_checked("0")%>>아파트(목조)
                  					<input type="radio" name="build_sort" value="1" <%=roomBean.getBuild_sort_checked("1")%>>맨션
                  				</td>
							</tr>
							</c:if>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">지역정보</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											<select name="area_code_1" id="select4" onchange='return reloadRegist()'>
												${RoomBean.area_1Tag}
											</select>
											<select name="area_code_2" id="select5">
												${RoomBean.area_2Tag}
											</select>
										</td>
									</tr>
									<tr>
										<td height="30" align="left" valign="bottom">나머지주소 
										<input type="text" name="area_code_3" id="textfield6"   align="absbottom" style="width:380px;" value="${RoomBean.area_code_3}" /></td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">노선정보</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<select name="line_code" id="select6" onchange='return reloadRegist()'>
										${RoomBean.lineTag}
									</select>
									<select name="station_code" id="select7">
										${RoomBean.stationTag}
									  </select> 역에서 도보 <input type="text" name="walk_time" id="textfield3"  style="width:45px;" value="${RoomBean.walk_time}" maxlength="2"/>분
								</td>
							</tr>
							
							<!--호텔/민박-->
							<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">요금</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="room_fee" type="text" id="textfield9"  maxlength="7" style="width:100px;" value="${RoomBean.room_fee}" />&nbsp;엔
                  				</td>
                  			</tr>
							</c:if>
							<!--기숙사/룸메이트-->
							<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text" rowspan="2">야칭</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="room_fee" id="textfield7"   align="absmiddle" style="width:75px;" value="${RoomBean.room_fee}" maxlength="5"/>
									&nbsp;만엔&nbsp; / 시끼낑&nbsp;&nbsp;(야칭은 3.0의 형식으로 소수점 단위로 입력해주세요.) <br>
									<input type="radio" name="fee_unit" value="0" <%=roomBean.getFee_unit_checked("0")%>>
									1개월(공과금 포함)
									<input type="radio" name="fee_unit" value="0" <%=roomBean.getFee_unit_checked("1")%>>
									1개월(공과금 미포함)
									<input type="radio" name="fee_unit" value="0" <%=roomBean.getFee_unit_checked("2")%>>
									1일<br>
                  				</td>
                  			</tr>
                  			<tr>
                  				<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
                  					시설비
									<input type="text" name="equipment_fee" id="textfield7" align="absmiddle" style="width:55px;" value="${RoomBean.manage_fee}" maxlength="6"/>
									&nbsp;엔&nbsp;/보증금
									<input type="text" name="deposit_fee" id="textfield7" align="absmiddle" style="width:50px;" value="${RoomBean.deposit_fee}" maxlength="6"/>
									&nbsp;엔 /입실료
									<input type="text" name="entrance_fee" id="textfield7" align="absmiddle" style="width:50px;" value="${RoomBean.entrance_fee}" maxlength="6"/>
									&nbsp;엔
                  				</td>
							</tr>
							</c:if>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">방타입</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input value="0" type="radio" name="room_type" <%=roomBean.getRoom_type_checked("0")%> />1인실
									<input value="1" type="radio" name="room_type" <%=roomBean.getRoom_type_checked("1")%> />2인실
									<input value="2" type="radio" name="room_type" <%=roomBean.getRoom_type_checked("2")%> />다인실
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">성별</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input value="0" type="radio" name="sex" <%=roomBean.getSex_checked("0")%> />남
									<input value="1" type="radio" name="sex" <%=roomBean.getSex_checked("1")%> />여
									<input value="2" type="radio" name="sex" <%=roomBean.getSex_checked("2")%> />구분없음
								</td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">홈페이지</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									http://<input type="text" name="url" id="textfield7" class="idForm" align="absmiddle" style="width:240px;" value="${RoomBean.url}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이메일</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input type="text" name="email" id="textfield8" class="idForm" align="absmiddle" style="width:240px;" value="${RoomBean.email}"/></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text"><span class="red-text-w">*</span>전화번호1</td>
								<td width="78%" bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no1_1" type="text" id="textfield9"  class="idForm" maxlength="4" style="width:50px;" value="${RoomBean.tel_no1_1}" />-
									<input name="tel_no1_2" type="text" id="textfield10" class="idForm" maxlength="4" style="width:50px;" value="${RoomBean.tel_no1_2}" />-
									<input name="tel_no1_3" type="text" id="textfield11" class="idForm" maxlength="4" style="width:50px;" value="${RoomBean.tel_no1_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">전화번호2</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<input name="tel_no2_1" type="text" id="textfield12" class="idForm" maxlength="4" style="width:50px;" value="${RoomBean.tel_no2_1}" />-
									<input name="tel_no2_2" type="text" id="textfield13" class="idForm" maxlength="4" style="width:50px;" value="${RoomBean.tel_no2_2}" />-
									<input name="tel_no2_3" type="text" id="textfield14" class="idForm" maxlength="4" style="width:50px;" value="${RoomBean.tel_no2_3}" /></td>
							</tr>
							<tr>
								<td bgcolor="#f9faf0" class="table-title-text">이미지</td>
								<td bgcolor="#FFFFFF" class="table-cont-text">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30">
											<c:if test="${!empty RoomBean.photo_path1}">
												<img src="${RoomBean.photo_path2}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name1" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 1)" />
											<a href="javascript:deletePhoto(1);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty RoomBean.photo_path2}">
												<img src="${RoomBean.photo_path2}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name2" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 2)" />
											<a href="javascript:deletePhoto(2);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty RoomBean.photo_path3}">
												<img src="${RoomBean.photo_path3}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name3" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 3)" />
											<a href="javascript:deletePhoto(3);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty RoomBean.photo_path4}">
												<img src="${RoomBean.photo_path4}" alt="" align="absmiddle" width="30" height="30">
											</c:if>		
										  	<input type="file" name="photo_name4" id="fileField"  style="width:300px;" onChange="uploadImageCheck(this, 4)" />
											<a href="javascript:deletePhoto(4);"><img src="jsp/images/new/file-delete_b.gif"  align="absmiddle" width="40" height="22" /></a>
										</td>
									</tr>
									<tr>
										<td height="30">
											<c:if test="${!empty RoomBean.photo_path5}">
												<img src="${RoomBean.photo_path5}" alt="" align="absmiddle" width="30" height="30">
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
									<textarea name="detail_info" id="textarea" cols="45" rows="5" style="width:530px;height:300px;">${RoomBean.detail_info}</textarea></td>
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
					<a href="javascript:sellcheck(wf);"><img src="jsp/images/new/storeregist_up_b.gif" width="117" height="35" /></a>&nbsp;
					<a href="javascript:backSearch();"><img src="jsp/images/new/storeregist_list_b.gif" width="136" height="35" /></a></td>
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
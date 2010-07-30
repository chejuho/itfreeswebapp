<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="housesell.bean.HouseBean, housesell.bean.HouseSearchBean"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	HouseBean houseBean = (HouseBean) request.getAttribute("HouseBean");
	HouseSearchBean houseSearchBean = (HouseSearchBean) request.getAttribute("HouseSearchBean");

%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title>${HouseBean.title}&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
	function goDirectTopMenu(topMenu) {
	 	//var topMenu =	document.getElementById("topMenu").value;
	 	if (topMenu == '1') {
	 		document.wf.action="BuySellList?re=9&search_cate_code_1=C10100";
	 	}
	 	if (topMenu == '2') {
	 		document.wf.action="BuySellList?re=9&search_cate_code_1=C10200";
	 	}
	 	if (topMenu == '3') {
	 		document.wf.action="StoreSearch?re=9";
	 	}
	 	if (topMenu == '4') {
	 		document.wf.action="GourmetSearch?re=9";
	 	}
	 	if (topMenu == '5') {
	 		document.wf.action="RoomSellList?re=9&cate_code_1=C10001";
	 	}
	 	if (topMenu == '6') {
	 		document.wf.action="RoomSellList?re=9&cate_code_1=C10002";
	 	}
	 	if (topMenu == '7') {
	 		document.wf.action="HouseSellList?re=9";
	 	}
	 	if (topMenu == '8') {
	 		document.getElementById("search_cate_code_1").value = "";
	 		document.wf.action="JobSearch?re=9";
	 	}
	 	if (topMenu == '9') {
	 		document.wf.action="FindjobSearch?re=9";
	 	}
		document.wf.submit(); 
		return true;
	}
	function deleteCheck(id){
	
		if(confirm("삭제하시겠습니까?")){
			document.wf.action="HouseSellDelete?id="+id;
			document.wf.submit(); 
			return true;
		}
	}
	function setImage(position){
		document.getElementById("disp").src = position;
		return false;
	}
	function openUpdate(id){
		document.wf.action="HouseSellUpdateOpen?id=" + id;
		document.wf.submit(); 
		return true;
	}	
	function backSearchPage() {
		document.wf.action="HouseSellList?re=9&modoru=ok";
		document.wf.submit(); 
		return true;
	}
	function backMyWrite() {
		document.wf.action="MyWrite?sort=7&modoru=ok";
		document.wf.submit(); 
		return true;
	}	
	function goSearchPage() {
		document.wf.action="HouseSellList?re=9";
		document.wf.submit(); 
		return true;
	}
		
	function mailOpenDetail(id,name) {
		mailOpen(id, name, '5');
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
		<td>
			<form name="wf" method="post">
			<input type="hidden" name="user_id" value="<%=houseSearchBean.getUser_id()%>">      						
   			<input type="hidden" name="before" value="<%=houseSearchBean.getBefore()%>">      										
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
			
  			<input type="hidden" name="photo1" value="${HouseBean.photo_path1}">  
  			<input type="hidden" name="photo2" value="${HouseBean.photo_path2}">  
  			<input type="hidden" name="photo3" value="${HouseBean.photo_path3}">  
  			<input type="hidden" name="photo4" value="${HouseBean.photo_path4}">  
  			<input type="hidden" name="photo5" value="${HouseBean.photo_path5}">
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" height="40" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="5%"><a href="Index"><img src="jsp/images/new/home_icon.gif" width="16" height="16" align="absmiddle"/>Home</a></td>
						<td width="61%" style="padding-top:3px;"> 
							 &nbsp;&gt;&nbsp;<a href="javascript:goDirectTopMenu('7');">부동산</a>
							<!--&gt;
							<select name="topMenu" id="topMenu" onchange="return goDirectTopMenu();">
		                    	<option value="1">물건사기</option>
		                    	<option value="2">물건팔기</option>
			                    <option value="3">업체찾기</option>
			                    <option value="4">음식점</option>
		                    	<option value="5">호텔/민박</option>
			                    <option value="6">기숙사/룸메이트</option>
			                    <option value="7" selected="selected">부동산</option>
			                    <option value="8">구인</option>
			                    <option value="9">구직</option>
							</select>-->
						</td>
						<td width="37%" align="right" style="padding-top:3px;">
							<!--목록버튼 -->
							<c:if test="${HouseSearchBean.before == 'search'}">
		              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>	
							<c:if test="${HouseSearchBean.before == 'mysearch'}">
							 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
							</c:if>
							<c:if test="${HouseSearchBean.before == 'my_write'}">
							 	<a href="javascript:backMyWrite();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
							</c:if>
							<!--전의페이지가 메인화면일경우 -->
							<c:if test="${HouseSearchBean.before == 'new_write'}">
          						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>								
							<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
							<c:if test="${HouseBean.user_id == memberInfo.userid}">
								<a href="javascript:openUpdate('${HouseBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
								<a href="javascript:deleteCheck('${HouseBean.id}');"><img src="jsp/images/new/btn_delete.gif"></a>
							</c:if>
						</td>
					</tr>
					</table>	
				</td>
			</tr>
			<tr>
				<td height="1" bgcolor="#d9d9d9"></td>
			</tr>
			<tr>
				<td height="14"></td>
			</tr>
			<tr>
				<td>
					<table id="Table_" width="950" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="67" colspan="3" align="center" background="jsp/images/new/search_content_boxbg.gif">
							<table width="96%" border="0" cellspacing="1" cellpadding="0">
					  		<tr>
								<td align="left">${util:getNewImage(HouseBean.update_dateTime)}<span class="detail-page">${HouseBean.title}</span></td>
								<td>&nbsp;</td>
								<td align="right">등록일: <c:out value="${HouseBean.updateDateFull}"/></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="20" background="jsp/images/new/search_box_left.gif"><img src="jsp/images/new/search_box_left.gif" width="20" height="90" alt="" /></td>
						<td width="910" align="center" style="padding-top:10px;"><table width="895" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="895" valign="top">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d9d9d9">
							</table>
						</td>
  					</tr>
					<tr>
						<td valign="top">
							<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d9d9d9">
							<tr>
								<td width="142" align="left" bgcolor="#ececec" class="table-title-text">집물건명</td>
								<td width="341" align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${HouseBean.house_name}"/></td>
								<td align="left" bgcolor="#ececec" class="table-title-text">건축년도</td>
								<td width="276" align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty HouseBean.build_year and RoomBean.build_year != '0'}">
										<c:out value="${HouseBean.build_year}년"/>
									</c:if>
									<c:if test="${!empty HouseBean.build_month and RoomBean.build_month != '0'}">
										<c:out value="${HouseBean.build_month}월"/>
									</c:if>&nbsp;<br />
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">건물층수</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text"> 
									<c:if test="${!empty HouseBean.all_stairs and RoomBean.all_stairs != '0'}">
										<c:out value="${HouseBean.all_stairs}"/>층건물에
									</c:if>
									<c:if test="${!empty HouseBean.stairs and RoomBean.stairs != '0'}">
										<c:out value="${HouseBean.stairs}"/>층
									</c:if>&nbsp;<br />
								</td>
								<td width="131" align="left" bgcolor="#ececec" class="table-title-text">건물종류</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HouseBean.house_sort == '0'}">
										아파트
									</c:if>
									<c:if test="${HouseBean.house_sort == '1'}">
										맨션
									</c:if>
									<c:if test="${HouseBean.house_sort == '2'}">
										개인주택
					            	</c:if>
									<c:if test="${HouseBean.house_sort == '3'}">
										주차장
									</c:if>
					            	<c:if test="${HouseBean.house_sort == '4'}">
										점포
					            	</c:if>
					            	<c:if test="${HouseBean.house_sort == '5'}">
										사무실
					            	</c:if>
					            	<c:if test="${HouseBean.house_sort == '6'}">
										토지
					            	</c:if>
					            	<c:if test="${HouseBean.house_sort == '7'}">
										기타
					            	</c:if>&nbsp;
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">지역정보</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HouseBean.area_fast}"/>
		                          	<c:out value="${HouseBean.area_name_1}"/>
		                          	<c:out value="${HouseBean.area_name_2}"/>
		                          	<c:out value="${HouseBean.area_code_3}"/>&nbsp;<br /></td>
								<td width="131" align="left" bgcolor="#ececec" class="table-title-text">노선정보</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HouseBean.lineInfo}"/>
									<c:if test="${!empty HouseBean.walk_time}">
										/도보<c:out value="${HouseBean.walk_time}"/>분
									</c:if>&nbsp;<br /></td>
							</tr>
							<tr>
								<td colspan="2" rowspan="13" align="center" valign="middle" bgcolor="#FFFFFF"  >
									<table width="482" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td colspan="2" height="366" align="center"><img src="${HouseBean.photo_path1}" id="disp" /></td>
									</tr>
									<tr>
										<td height="6" colspan="2"></td>
									</tr>
									<tr>
										<td width="392" align="right">
											<img src="${HouseBean.photo_path1}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HouseBean.photo_path1}')"/>&nbsp;
											<img src="${HouseBean.photo_path2}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HouseBean.photo_path2}')"/>&nbsp;
											<img src="${HouseBean.photo_path3}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HouseBean.photo_path3}')"/>&nbsp;
											<img src="${HouseBean.photo_path4}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HouseBean.photo_path4}')"/>&nbsp;
											<img src="${HouseBean.photo_path5}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${HouseBean.photo_path5}')"/>
										</td>
										<td width="89" align="right" valign="top"><a href="javascript:popup();"><img src="jsp/images/new/large_b.gif" width="61" height="16" /></a></td>
									</tr>
									</table>
								</td>
								<td align="left" bgcolor="#ececec" class="table-title-text"><strong>입거가능일<br /></strong></td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HouseBean.come_dock == '0'}">
										즉시
									</c:if>
									<c:if test="${HouseBean.come_dock == '1'}">
										<c:out value="${HouseBean.come_dock_year}년${HouseBean.come_dock_month}월"/>
									</c:if>&nbsp;<br /></td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">야칭</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty HouseBean.house_fee[0] and HouseBean.house_fee[0] != '0'}">
										<c:out value="${HouseBean.house_fee[0]}만엔"/><br>
									</c:if>
									<c:if test="${!empty HouseBean.manage_fee and HouseBean.manage_fee != '0'}">
										관리비/기타<c:out value="${HouseBean.manage_fee}만엔"/>	
									</c:if>
									<c:if test="${!empty HouseBean.deposit and HouseBean.deposit != '0'}">
										시끼낑<c:out value="${HouseBean.deposit}개월분"/><br>
									</c:if>
									<c:if test="${!empty HouseBean.reikin and HouseBean.reikin != '0'}">
										레이낑<c:out value="${HouseBean.reikin}개월분"/>
									</c:if>
									<c:if test="${!empty HouseBean.guaranty_money and HouseBean.guaranty_money != '0'}">
										보증금<c:out value="${HouseBean.guaranty_money}개월분"/>
									</c:if>&nbsp;<br /></td>								
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">전용면적</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${!empty HouseBean.dimension[0] and HouseBean.dimension[0] != '0'}">
										<c:out value="${HouseBean.dimension[0]}m2"/>
									</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">마도리</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HouseBean.madori == '0'}">
										1R
									</c:if>
									<c:if test="${HouseBean.madori == '1'}">
										1K
									</c:if>
									<c:if test="${HouseBean.madori == '2'}">
										1DK
					            	</c:if>
									<c:if test="${HouseBean.madori == '3'}">
										1LDK
									</c:if>
					            	<c:if test="${HouseBean.madori == '4'}">
										2K
					            	</c:if>
					            	<c:if test="${HouseBean.madori == '5'}">
										2DK
					            	</c:if>
					            	<c:if test="${HouseBean.madori == '6'}">
										2LDK
					            	</c:if>
					            	<c:if test="${HouseBean.madori == '7'}">
										3DK
					            	</c:if>
					            	<c:if test="${HouseBean.madori == '8'}">
										3LDK
					            	</c:if>
					            	<c:if test="${HouseBean.madori == '9'}">
										4DK
					            	</c:if>
					            	<c:if test="${HouseBean.madori == '10'}">
										4LDK
					            	</c:if>
					            	<c:if test="${HouseBean.madori == '11'}">
										기타
					            	</c:if><br><c:out value="${HouseBean.madori_info}"/>&nbsp;
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">방구조</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HouseBean.flg_tadami == '0'}">
										타다미
									</c:if>
									<c:if test="${HouseBean.flg_tadami == '1'}">
										플로링
									</c:if>
									<c:if test="${HouseBean.flg_tadami == '2'}">
										타다미 + 플로링
					            	</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">화장실/목욕탕</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HouseBean.toilet == '0'}">
										화장실 욕조별도
									</c:if>
									<c:if test="${HouseBean.toilet == '1'}">
										화장실 욕조동일
									</c:if>
									<c:if test="${HouseBean.toilet == '2'}">
										샤워만
					            	</c:if>
					            	<c:if test="${HouseBean.toilet == '3'}">
										화장실만
					            	</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">방위</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HouseBean.point_compass == '1'}">
										동향
									</c:if>
									<c:if test="${HouseBean.point_compass == '2'}">
										서향
									</c:if>
									<c:if test="${HouseBean.point_compass == '3'}">
										남향	
					            	</c:if>
					            	<c:if test="${HouseBean.point_compass == '4'}">
										북향
					            	</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">조건</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:if test="${HouseBean.house_option[0] == '1'}">
										2인입거가능
									</c:if>
									<c:if test="${HouseBean.house_option[1] == '1'}">
										 가족입거가능
									</c:if>
									<c:if test="${HouseBean.house_option[2] == '1'}">
										 애완동물가능
					            	</c:if>&nbsp;								
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">이메일</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<a href="" onclick="mailOpenDetail('${HouseBean.id}','${HouseBean.user_name}'); return false;">메일보내기</a>
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">전화번호1</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HouseBean.tel_no1_fname}"/>&nbsp;	
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">전화번호2</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HouseBean.tel_no2_fname}"/>&nbsp;
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">등록자</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HouseBean.user_name}"/>&nbsp;
								</td>
							</tr>
							<tr>
								<td align="left" bgcolor="#ececec" class="table-title-text">조회수</td>
								<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
									<c:out value="${HouseBean.read_count}"/>&nbsp;
								</td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="30" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" >
							<table width="40%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="3%"><img src="jsp/images/new/search_conttit_icon.gif" width="7" height="14" /></td>
								<td width="97%" style="padding-top:2px;"><span class="style10">상세정보</span></td>
							</tr>
							</table>
						</td>
					</tr>	
					<tr>
						<td height="2" align="left" valign="top" bgcolor="#d9d9d9"></td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top">
							${HouseBean.detail_info}&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top">
						문의처 <br>
						화사이름:${HouseBean.company_name}<br>
						면허번호:${HouseBean.license_no}<br>
						주소:${HouseBean.company_address}<br>
						전화번호:${HouseBean.company_telno}
						&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td align="left" valign="top">&nbsp;</td>
					</tr>
					</table>
		</td>
			<td width="20"   background="jsp/images/new/search_box_right.gif"><img src="jsp/images/new/search_box_right.gif" width="20" height="90" alt="" /></td>
			  </tr>
			  <tr>
			<td colspan="3"><img src="jsp/images/new/search_box_under.gif" width="950" height="17" alt="" /></td>
			  </tr>
			</table>
				</td>
			</tr>
			<tr>
				<td height="40" align="right">
					<!--목록버튼 -->
					<c:if test="${HouseSearchBean.before == 'search'}">
              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
					</c:if>	
					<c:if test="${HouseSearchBean.before == 'mysearch'}">
					 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
					</c:if>
					<c:if test="${HouseSearchBean.before == 'my_write'}">
					 	<a href="javascript:backMyWrite();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
					</c:if>
					<c:if test="${HouseSearchBean.before == 'new_write'}">
  						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
					</c:if>						
					<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
					<c:if test="${HouseBean.user_id == memberInfo.userid}">
						<a href="javascript:openUpdate('${HouseBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
						<a href="javascript:deleteCheck('${HouseBean.id},wf');"><img src="jsp/images/new/btn_delete.gif"></a>
					</c:if>
				</td>
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
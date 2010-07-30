<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="housesell.bean.HouseBean, housesell.bean.HouseSearchBean,housesell.bean.HouseSellSortBean" %>
<%@ page import="common.bean.PageBean" %>
<%@ page import="common.util.Util"%>
<%@ page import="java.util.List,java.util.Iterator" %>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
request.setCharacterEncoding("UTF-8");
PageBean pageBean = (PageBean)session.getAttribute("PageBean");
HouseSellSortBean sortBean = (HouseSellSortBean)session.getAttribute("HouseSellSortBean");
HouseSearchBean houseSearchBean = (HouseSearchBean)request.getAttribute("HouseSearchBean");
if (houseSearchBean == null) {
	houseSearchBean = new HouseSearchBean();
}

List houseBeanList = (List)request.getAttribute("HouseBeanList");
String message = (String)Util.changeNullStr(request.getAttribute("Message"));

String pageType = pageBean.getPageType();
MemberBean member = new MemberBean();
member.setUserid("-");
if(session.getAttribute("memberInfo")!=null){
	member = (MemberBean) session.getAttribute("memberInfo");	
}
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<head>
<title><c:out value="부동산"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
	window.onload=messageCheck;
	/** ERROR메세지 처리  */
	 function messageCheck() {
		var message = document.getElementById("msg").value;
		if (message) {
			if (message == 'WAR0004') {
				alert("<fmt:message key="WAR0004" bundle="${message}"/>");
				window.open('PopLogin', 'notice', 'width=230, height=160');	
			} else if ("MSG0018".equals(message)){
				alert("<fmt:message key="MSG0018" bundle="${message}"/>");
			}
		}
	}
	function reloadPage(obj) {
		document.list.action="HouseSellList?pageNum="+obj;
		document.list.submit(); 
		return true;
	}
	function submitHouseSell(ff) {
		ff.action="HouseSellList?re=9";
		ff.submit(); 
		return true;
	}	
	function reloadAreaLineSearch(obj) {
		if(obj == 0){
			document.list.action="HouseSellList?re=0";
		} else if (obj == 1){
			document.list.action="HouseSellList?re=1";
		}
		
		document.list.submit(); 
		return true;
	}	
	function sellsearch(ff) {
		ff.action="HouseSellList?re=9";
		ff.submit(); 
		return true;
	}
	function changeAddressSort() {
		
		var address_up = document.list.address_up.value;
		list.action="HouseSellList?re=9&address_up="+ address_up;
		list.submit(); 

		return true;
	}
	
	function changeLineSort() {

		var line_up = document.list.line_up.value;
		list.action="HouseSellList?re=9&line_up="+ line_up;
		list.submit(); 

		return true;
	}
	
	function changeWalkSort() {

		var walk_up = document.list.walk_up.value;
		list.action="HouseSellList?re=9&walk_up="+ walk_up;
		list.submit(); 

		return true;
	}
	
	function changeHouseFeeSort() {

		var houseFee_up = document.list.houseFee_up.value;
		list.action="HouseSellList?re=9&houseFee_up="+ houseFee_up;
		list.submit(); 

		return true;
	}
	
	function changeManageFeeSort() {

		var manageFee_up = document.list.manageFee_up.value;
		list.action="HouseSellList?re=9&manageFee_up="+ manageFee_up;
		list.submit(); 

		return true;
	}

	function changeDepositSort() {
		var deposit_up = document.list.deposit_up.value;
		list.action="HouseSellList?re=9&deposit_up="+ deposit_up;
		list.submit(); 

		return true;
	}
	function changeReikinSort() {
		var reikin_up = document.list.reikin_up.value;
		list.action="HouseSellList?re=9&reikin_up="+ reikin_up;
		list.submit(); 

		return true;
	}
	function changeGuarantySort() {
		var guaranty_up = document.list.guaranty_up.value;
		list.action="HouseSellList?re=9&guaranty_up="+ guaranty_up;
		list.submit(); 

		return true;
	}
	function changeMadoriSort() {
		var madori_up = document.list.madori_up.value;
		list.action="HouseSellList?re=9&madori_up="+ madori_up;
		list.submit(); 

		return true;
	}
	function changeDimensionSort() {
		var dimension_up = document.list.dimension_up.value;
		list.action="HouseSellList?re=9&dimension_up="+ dimension_up;
		list.submit(); 

		return true;
	}
	
	function changeHouseSort() {
		var houseSort_up = document.list.houseSort_up.value;
		list.action="HouseSellList?re=9&houseSort_up="+ houseSort_up;
		list.submit(); 

		return true;
	}
	function changeBuildDateSort() {
		var buildDate_up = document.list.buildDate_up.value;
		list.action="HouseSellList?re=9&buildDate_up="+ buildDate_up;
		list.submit(); 

		return true;
	}
	function changeuserIdSort() {
		var userId_up = document.list.userId_up.value;
		list.action="HouseSellList?re=9&userId_up="+ userId_up;
		list.submit(); 

		return true;
	}
	function changeregistDateSort() {
		var registDate_up = document.list.registDate_up.value;
		list.action="HouseSellList?re=9&registDate_up="+ registDate_up;
		list.submit(); 

		return true;
	}
	
	function registInterest(ff) {
		ff.action="HouseSellInterestRegist";
		ff.submit(); 
		return true;
	}
	
	function interestListOpen(list) {
		list.action="HouseSellInterestList";
		list.submit()
		return true;
	}
	function submitHouseSell(ff) {
		ff.action="HouseSellList?re=9";
		ff.submit(); 
		return true;
	}	
	function registOpen(ff) {
		ff.action="HouseSellRegistOpen?before=search&f=search";
		ff.submit(); 
		return true;
	}	
	function my_write(user_id) {
		if(user_id == "-"){
			document.list.action="HouseSellList?re=9&user_id=-";
		} else if(user_id == "_"){
			document.list.action="HouseSellList?re=9&user_id=";
		} else {
			document.list.action="HouseSellList?re=9&user_id=" + user_id;
		}		
		document.list.submit(); 
		return true;
	}
	function reloadSearch(ff) {
		
		ff.action="HouseSellList?re=9";
		ff.submit(); 
		return true;
	}	
	function openDetailPage(id) {

		document.list.action="HouseSellDetail?before=search&id=" + id;
		document.list.submit(); 
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
			<form name="list" method="post" style="margin:0">
			<input type="hidden" id="msg" name = "msg" value="<c:out value="${Message}"/>" />
			<input type="hidden" name="user_id" value="<%=houseSearchBean.getUser_id()%>"/>      						
			<input type="hidden" name="sendaddress" value="3"/>
			<input type="hidden" name="pageType" value="<%=pageType %>"/>
			<input type="hidden" name="before_pageNum" value="<%=houseSearchBean.getPageNum()%>"/> 
			<input type="hidden" name="before_pageSize" value="<%=houseSearchBean.getPageSize()%>"/>    
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td><img src="jsp/images/new/search_tit1.gif" width="118" height="24" /></td>
			</tr>
			<tr>
				<td height="6"></td>
			</tr>
			<tr>
				<td>
					<table id="Table_" width="950" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="63" colspan="3" background="jsp/images/new/realestate_box_tit.gif">
							<table width="94%"    border="0" align="center" cellpadding="0" cellspacing="1">
							<tr>
								<td width="13%" >&nbsp;</td>
								<td width="76%" ><span class="search-num1">(${PageBean.maxCount})</span></td>
								<td width="11%" align="right" ><a href="HouseSellList?re=9"><img src="jsp/images/new/search_return_b.gif" width="94" height="22" /></a></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td background="jsp/images/new/search_box_left.gif" ><img src="jsp/images/new/search_box_left.gif" width="20" height="30" alt="" /></td>
						<td width="910" align="center" valign="middle" style="padding:10px 8px 8px 8px;">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="29%" align="left" ><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w">야칭</strong></td>
								<td width="29%" align="left" ><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w">지역상세명</strong></td>
								<td width="42%" align="left" ><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><span class="blue-text-w"><strong>노선정보</strong></span></td>
							</tr>
							<tr>
								<td height="30" align="left" >
									<select name="house_fee_from" id="select3" onchange='return submitHouseSell(list)'>
										<option value="100">제한없음</option>
										${HouseSearchBean.house_fee1Tag}
									</select>
									만엔~
									<select name="house_fee_to" id="select4" >
										<option value="100">제한없음</option>
										${HouseSearchBean.house_fee2Tag}
									</select>
									만엔
								</td>
								<td align="left" >
									<select name="search_area_code_1" id="select7" onchange="return reloadAreaLineSearch('0');">
										${HouseSearchBean.area_1Tag}
									</select>
									<select name="search_area_code_2" id="select8">
										${HouseSearchBean.area_2Tag}
									</select>
								</td>
								<td align="left" >
									<select name="search_line_code" id="select5" onchange="return reloadAreaLineSearch('1');">
										${HouseSearchBean.lineTag}
									</select>센
									<select name="search_station_code" id="select6">
										${HouseSearchBean.stationTag}
									</select>역
								</td>
							</tr>
							<tr>
								<td height="23" colspan="3" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							<tr>
								<td align="left" valign="top">
									<img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">최신정보</strong></td>
								<td align="left">
									<img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<span class="blue-text-w"><strong>전용면적</strong></span></td>
								<td align="left">
									<img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">마도리</strong></td>
							</tr>
							<tr>
								<td align="left" valign="top">
									<input value="0" type="radio" name="search_regist_date" <%=houseSearchBean.getRegist_date_selected("0")%> />하루 이내
									<input value="1" type="radio" name="search_regist_date" <%=houseSearchBean.getRegist_date_selected("1")%> />1주일 이내
									<input value="2" type="radio" name="search_regist_date" <%=houseSearchBean.getRegist_date_selected("2")%>  />1달 이내<br />
									<input value="3" type="radio" name="search_regist_date" <%=houseSearchBean.getRegist_date_selected("3")%> />지정안함
								</td>
								<td align="left" valign="top">
									<select name="dimension_1" id="select9">
										<option value="1000">제한없음</option>
										${HouseSearchBean.dimension1Tag}
									</select>m2~
									<select name="dimension_2" id="select10">
										<option value="1000">제한없음</option>
										${HouseSearchBean.dimension2Tag}
									</select>m2
								</td>
								<td align="left">
									<input value="0" type="checkbox" name="madori_0" <%=houseSearchBean.getMadori_checked(0)%> />1R
									<input value="1" type="checkbox" name="madori_1" <%=houseSearchBean.getMadori_checked(1)%> />1K
									<input value="2" type="checkbox" name="madori_2" <%=houseSearchBean.getMadori_checked(2)%> />1DK
									<input value="3" type="checkbox" name="madori_3" <%=houseSearchBean.getMadori_checked(3)%> />1LDK
									<input value="4" type="checkbox" name="madori_4" <%=houseSearchBean.getMadori_checked(4)%> />2K
									<input value="5" type="checkbox" name="madori_5" <%=houseSearchBean.getMadori_checked(5)%> />2DK <br />
									<input value="6" type="checkbox" name="madori_6" <%=houseSearchBean.getMadori_checked(6)%> />2LDK
									<input value="7" type="checkbox" name="madori_7" <%=houseSearchBean.getMadori_checked(7)%> />3DK
									<input value="8" type="checkbox" name="madori_8" <%=houseSearchBean.getMadori_checked(8)%> />3LDK
									<input value="9" type="checkbox" name="madori_9" <%=houseSearchBean.getMadori_checked(9)%> />4DK
									<input value="10" type="checkbox" name="madori_10" <%=houseSearchBean.getMadori_checked(10)%> />4LDK
									<input value="11" type="checkbox" name="madori_11" <%=houseSearchBean.getMadori_checked(11)%> />기타
								</td>
							</tr>
							<tr>
								<td height="23" colspan="3" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							<tr>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w">건축년도</strong></td>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w">화장실/목욕탕</strong></td>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w">건물종류</strong></td>
							</tr>
							<tr>
								<td align="left">
									<input value="0" type="radio" name="search_build_year" <%=houseSearchBean.getBuild_year_checked("0")%> />신축
									<input value="1" type="radio" name="search_build_year" <%=houseSearchBean.getBuild_year_checked("1")%> />3년이내
									<input value="2" type="radio" name="search_build_year" <%=houseSearchBean.getBuild_year_checked("2")%> />5년이내
									<input value="3" type="radio" name="search_build_year" <%=houseSearchBean.getBuild_year_checked("3")%> />10년이내 <br />
									<input value="4" type="radio" name="search_build_year" <%=houseSearchBean.getBuild_year_checked("4")%> />지정안함</td>
								<td align="left" valign="top">
									<input value="0" type="radio" name="search_toilet" <%=houseSearchBean.getToilet_checked(0)%> />화장실 욕조별도
									<input value="1" type="radio" name="search_toilet" <%=houseSearchBean.getToilet_checked(1)%> />  지정안함</td>
								<td align="left">
									<input value="0" type="checkbox" name="house_sort_0" <%=houseSearchBean.getHouse_sort_checked(0)%> />아파트
									<input value="1" type="checkbox" name="house_sort_1" <%=houseSearchBean.getHouse_sort_checked(1)%> />맨션
									<input value="2" type="checkbox" name="house_sort_2" <%=houseSearchBean.getHouse_sort_checked(2)%> />개인주택
									<input value="3" type="checkbox" name="house_sort_3" <%=houseSearchBean.getHouse_sort_checked(3)%> />주차장
									<input value="4" type="checkbox" name="house_sort_4" <%=houseSearchBean.getHouse_sort_checked(4)%> />점포<br />
									<input value="5" type="checkbox" name="house_sort_5" <%=houseSearchBean.getHouse_sort_checked(5)%> />사무실
									<input value="6" type="checkbox" name="house_sort_6" <%=houseSearchBean.getHouse_sort_checked(6)%> />토지
									<input value="7" type="checkbox" name="house_sort_7" <%=houseSearchBean.getHouse_sort_checked(7)%> />기타</td>
							</tr>
							<tr>
								<td height="23" colspan="3" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							<tr>
								<td align="left" valign="top"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w">도보시간</strong></td>
								<td align="left" valign="top"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><span class="blue-text-w"><strong>방구조</strong></span></td>
								<td align="left" valign="top"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><span class="blue-text-w"><strong>입거조건</strong></span></td>
							</tr>
							<tr>
								<td align="left" valign="top">
									<input value="0" type="radio" name="search_walk_time" <%=houseSearchBean.getWalk_time_checked("0")%> />5분이내
									<input value="1" type="radio" name="search_walk_time" <%=houseSearchBean.getWalk_time_checked("1")%> />10분이내
									<input value="2" type="radio" name="search_walk_time" <%=houseSearchBean.getWalk_time_checked("2")%> />15분이내 <br />
									<input value="3" type="radio" name="search_walk_time" <%=houseSearchBean.getWalk_time_checked("3")%> />지정안함 </td>
								<td align="left" valign="top">
									<input value="0" type="radio" name="search_flg_tadami" <%=houseSearchBean.getFlg_tadami_checked("0")%> />타다미포함
									<input value="1" type="radio" name="search_flg_tadami" <%=houseSearchBean.getFlg_tadami_checked("1")%> />플로링만
									<input value="2" type="radio" name="search_flg_tadami" <%=houseSearchBean.getFlg_tadami_checked("2")%> />지정안함 </td>
								<td align="left" valign="top">
									<input value="1" type="checkbox" name="house_option_0" <%=houseSearchBean.getHouse_option_checked(0)%> />2층이상
									<input value="1" type="checkbox" name="house_option_1" <%=houseSearchBean.getHouse_option_checked(1)%> />2명입거가능
									<input value="1" type="checkbox" name="house_option_2" <%=houseSearchBean.getHouse_option_checked(2)%> />가족가능 <br />
									<input value="1" type="checkbox" name="house_option_3" <%=houseSearchBean.getHouse_option_checked(3)%> />애완동물가능 </td>
							</tr>
							<tr>
								<td height="10" colspan="3" align="center"></td>
							</tr>
							<tr>
								<td height="1" colspan="3" align="center" bgcolor="#CCCCCC"></td>
							</tr>
							<tr>
								<td height="10" colspan="3" align="center"></td>
							</tr>
							<tr>
								<td colspan="3" align="center">
									<!-- 검색버튼 -->
									<a href="javascript:sellsearch(list)"><img src="jsp/images/new/search_b.gif" width="107" height="35" /></a></td>
							</tr>
							</table>
						</td>
						<td background="jsp/images/new/search_box_right.gif"><img src="jsp/images/new/search_box_right.gif" width="20" height="30" alt="" /></td>
					</tr>
					<tr>
						<td colspan="3"><img src="jsp/images/new/search_box_under.gif" width="950" height="14" alt="" /></td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="40">&nbsp;</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="13%">
							<c:if test="${empty HouseSearchBean.user_id}">
								<img src="jsp/images/new/search_tit2.gif" width="118" height="23" />
							</c:if>	
							<c:if test="${!empty HouseSearchBean.user_id}">
								<img src="jsp/images/new/mywrite_title.gif" width="118" height="23" />
							</c:if>	
						</td>
						<td width="56%">&nbsp;</td>
						<td width="31%" align="right">
							<select name="pageSize" id="select2" onchange='return submitHouseSell(list)'>
								<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10개씩보기</option>
								<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20개씩보기</option>
								<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50개씩보기</option>
								<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100개씩보기</option>
							</select>
							<c:if test="${empty HouseSearchBean.user_id}">
								<!--ID가 없으면 내글보기표시 -->
								<c:if test="${empty memberInfo.userid}">
		              			<a href="javascript:my_write('-');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>	
		              			<c:if test="${!empty memberInfo.userid}">
		              			<a href="javascript:my_write('${memberInfo.userid}');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>
							</c:if>		              			
							<c:if test="${!empty HouseSearchBean.user_id}">
							<!--ID가 있으면 목록표시 목록이미지 현재 무 -->
							<a href="javascript:my_write('_');">
								<img src="jsp/images/new/btn_list.gif" align="absmiddle" /></a>&nbsp;							
							</c:if>
							<!--등록 -->
							<a href="javascript:registOpen(list);"><img src="jsp/images/new/resigter_b.gif" align="absmiddle" width="58" height="22" /></a>
						</td>
					</tr>
					<tr>
						<td height="6" colspan="3"></td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						
						<c:if test="${!adviserSign}">
						<!--일반모드의 경우-->
							<td height="41" colspan="9" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
						</c:if>
						
						<c:if test="${adviserSign}">
						<!--관리자유저모드의 경우-->
							<td height="41" colspan="11" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
						</c:if>
						
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="6%" align="center" class="board-title-text"><span class="style8">번호</span></td>
								<c:if test="${adviserSign}">
								<!--관리자유저모드의 경우-->
								<td width="14%" align="center" class="board-title-text"><span class="style8">정보취득원</span></td>
								</c:if>
								<td width="8%" align="center" class="board-title-text"><span class="style8">이미지</span></td>
								<td width="20%" align="center" class="board-title-text">
									<span class="style8">지역</span>
									<a href="javascript:changeAddressSort();"><img src="<%=sortBean.getAddress_image() %>"></a>
									<input type="hidden" id="address_up"  value="<%=sortBean.getAddress_up() %>"/>
									<br>
									<span class="style8">노선정보</span>
									<a href="javascript:changeLineSort();"><img src="<%=sortBean.getLine_image() %>"></a>
									<input type="hidden" id = "line_up" value="<%=sortBean.getLine_up() %>"/>
								</td>
								<td width="5%" align="center" class="board-title-text">
									<span class="style8">도보</span>
									<a href="javascript:changeWalkSort();"><img src="<%=sortBean.getWalk_image()%>"></a>
									<input type="hidden" id = "walk_up" value="<%=sortBean.getWalk_up() %>"/>
								</td>
								<td width="7%" align="center" class="board-title-text">
									<span class="style8">야찡</span>
									<a href="javascript:changeHouseFeeSort();"><img src="<%=sortBean.getHouseFee_image() %>"></a>
									<input type="hidden" id = "houseFee_up" value="<%=sortBean.getHouseFee_up() %>"/>
									<br>
									<span class="style8">/관리비</span>
									<a href="javascript:changeManageFeeSort();"><img src="<%=sortBean.getManageFee_image() %>"></a>
									<input type="hidden" id = "manageFee_up" value="<%=sortBean.getManageFee_up() %>"/>
								</td>
								<td width="7%" align="center" class="board-title-text">
									<span class="style8">레이킹</span>
									<a href="javascript:changeReikinSort();"><img src="<%=sortBean.getReikin_image() %>"></a>
									<input type="hidden" id = "reikin_up" value="<%=sortBean.getReikin_up() %>"/>
								</td>
								<td width="14%" align="center" class="board-title-text">
									<span class="style8">시끼낑　보증금</span>
									<a href="javascript:changeDepositSort();"><img src="<%=sortBean.getDeposit_image() %>"></a>
									<input type="hidden" id = "deposit_up" value="<%=sortBean.getDeposit_up() %>"/>
								<td width="8%" align="center" class="board-title-text">
									<span class="style8">마도리</span>
									<a href="javascript:changeMadoriSort();"><img src="<%=sortBean.getMadori_image() %>"></a>
									<input type="hidden" id = "madori_up" value="<%=sortBean.getMadori_up() %>"/>
									<br>
									<span class="style8">/전용면적</span>
									<a href="javascript:changeDimensionSort();"><img src="<%=sortBean.getDimension_image() %>"></a>
									<input type="hidden" id = "dimension_up" value="<%=sortBean.getDimension_up() %>"/>
								</td>
									
								<td width="8%" align="center" class="board-title-text">
									<span class="style8">건물종류</span>
									<a href="javascript:changeHouseSort();"><img src="<%=sortBean.getHouseSort_image() %>"></a>
									<input type="hidden" id = "houseSort_up" value="<%=sortBean.getHouseSort_up() %>"/>
									<br>
									<span class="style8">/건축년도</span>
								<a href="javascript:changeBuildDateSort();"><img src="<%=sortBean.getBuildDate_image() %>"></a>
								<input type="hidden" id = "buildDate_up" value="<%=sortBean.getBuildDate_up() %>"/>
								</td>
								
							</tr>
							</table>
						</td>
					</tr>
					<c:choose>
					<c:when test="${!empty HouseBeanList}">
						<c:forEach var="HouseBean" items="${HouseBeanList}" >
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								${HouseBean.id}&nbsp;
							</td>
							
							<c:if test="${adviserSign}">
							<!--관리자유저모드의 경우-->
							<td width="14%" align="center" class="board-title-text">
								<a href="javascript:;" onclick="window.open('${HouseBean.detail_url}', 'winName', 'left=0,top=0,width = 1024, height=1200,scrollbars=1,resizable=1').focus()">
								<span class="style8">${HouseBean.info_site}</span>
								</a>&nbsp;
							</td>
							</c:if>
							
							<!--이미지 -->
							<td width="8%" align="center">
								<a href="javascript:openDetailPage('${HouseBean.id}');"><img src="${HouseBean.thumbNail_path}" ></a>
								&nbsp;
							</td>
							<!-- 글제목 -->

							
							<!--지역/노선정보 -->
							<td width="20%" align="center">
								<c:out value="${HouseBean.area_fast}${HouseBean.area_name_1}${HouseBean.area_name_2}"/><br><c:out value="${HouseBean.lineInfo}"/>&nbsp;
							</td>
							<!--도보-->
							<td width="5%" align="center">
								<c:if test="${!empty HouseBean.walk_time and HouseBean.walk_time != '0'}">
									<c:out value="${HouseBean.walk_time}분"/>
								</c:if>&nbsp;
							</td>
							<!--야찡/관리비-->
							<td width="7%" align="center">
								<c:if test="${!empty HouseBean.house_fee[0] and HouseBean.house_fee[0] != '0'}">
									<c:out value="${HouseBean.house_fee[0]}만엔"/><br>
								</c:if>
								<c:if test="${!empty HouseBean.manage_fee and HouseBean.manage_fee != '0'}">
									<c:out value="${HouseBean.manage_fee}만엔"/>	
								</c:if>&nbsp;
							</td>
							<!--레이킹-->
							<td width="7%" align="center">
								<c:if test="${!empty HouseBean.reikin and HouseBean.reikin != '0'}">
									<c:out value="${HouseBean.reikin}개월분"/>
								</c:if>&nbsp;
							</td>
							<!--시끼낑/보증금 -->
							<td width="14%" align="center">
								<c:if test="${!empty HouseBean.guaranty_money and HouseBean.guaranty_money != '0'}">
									<c:out value="${HouseBean.guaranty_money}개월분"/>
								</c:if>
								<c:if test="${!empty HouseBean.deposit and HouseBean.deposit != '0'}">
									<c:out value="${HouseBean.deposit}개월분"/>
								</c:if>
								&nbsp;
							</td>
							<!--마도리/전용면적 -->
							<td width="8%" align="center">
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
				            	</c:if>
				            	<br>
				            	<c:if test="${!empty HouseBean.dimension[0] and HouseBean.dimension[0] != '0'}">
									<c:out value="${HouseBean.dimension[0]}m2"/>
								</c:if>&nbsp;
							</td>
							<!--건물종류/건축년도 -->
							<td width="8%" align="center">
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
				            	</c:if>
                				<br>
                				<c:if test="${!empty HouseBean.build_year and HouseBean.build_year != '0'}">
									<c:out value="${HouseBean.build_year}년"/>
								</c:if>
								<c:if test="${!empty HouseBean.build_month and HouseBean.build_month != '0'}">
									<c:out value="${HouseBean.build_month}월"/>
								</c:if>
								&nbsp;
							</td>
						</tr>
						<tr align="center" bgcolor="#CCCCCC">
							
							<c:if test="${!adviserSign}">
							<!--일반모드의 경우-->
								<td height="1" colspan="10" ></td>
							</c:if>
							
							<c:if test="${adviserSign}">
							<!--관리자유저모드의 경우-->
								<td height="1" colspan="11" ></td>
							</c:if>
						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td width="100%" align="center">
								<c:out value="해당 검색 리스트가 없습니다."/>
							</td>
						</tr>
					</c:otherwise>
					</c:choose>
					</table>
				</td>
			</tr>
			<c:if test="${!empty PageBean}">
			<tr>
	        	<td height="2" align="center" bgcolor="#CCCCCC"></td>
	      	</tr>	
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
			<tr>
				<!--건수표시 -->
				<c:if test="${0 != PageBean.maxCount}">
					<td align="center" style="color:#33333;font-size:12px;">검색결과 :
					<span class="orange-text"><strong>${PageBean.maxCount}</strong></span>건중 
		        	<span class="blue-text-w"><strong>${PageBean.startCount}~${PageBean.endCount}</strong></span>건을표시하고 있습니다.</td> 
				</c:if>
			</tr>		
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
			<tr>
				<td align="center">
					<myTags:pageHandle />
				</td>
			</tr>
			</c:if>
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

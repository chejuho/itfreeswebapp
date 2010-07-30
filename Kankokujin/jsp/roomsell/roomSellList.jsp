<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="roomsell.bean.RoomBean, roomsell.bean.RoomSearchBean"%>
<%@ page import="java.util.List, java.util.Iterator"%>
<%@ page import="common.bean.PageBean" %>
<%@ page import="common.bean.MemberBean"%>
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
	
	PageBean pageBean = (PageBean)session.getAttribute("PageBean");
	List roomBeanList = (List) request.getAttribute("RoomBeanList");
	RoomSearchBean roomSearchBean = (RoomSearchBean) request.getAttribute("RoomSearchBean");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	MemberBean member = new MemberBean();
	member.setUserid("-");
	if(session.getAttribute("memberInfo")!=null){
		member = (MemberBean) session.getAttribute("memberInfo");	
	}
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
	<title><c:out value="호텔/민박"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
</c:if>
<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
	<title><c:out value="기숙사/룸메이트"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
</c:if>


<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript" charset="utf-8"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
	var clickedUserid;
	var clickedId;
	var clickedName;
	var popupMenuList = new Array();
	window.onload=init;
	
	/** ERROR메세지 처리  */
	 function init() {
		var message = document.getElementById("msg").value;
		if (message) {
			if (message == 'WAR0004'){
				alert("<fmt:message key="WAR0004" bundle="${message}"/>");
				window.open('PopLogin', 'notice', 'width=230, height=160');	
			}
		}
		/** PopupMenu生成*/
		for (var i = 1; i < 11; i++) {
			var name = "link" + i;
			if ($(name)) {
				popupMenuList.push(new PopupMenu($(name), $("popup")));
			}
		}
	}
	function reloadPage(obj) {
		document.list.action="RoomSellList?pageNum="+obj;
		document.list.submit(); 
		return true;
	}
	function reloadAreaLineSearch(obj) {
		if(obj == "0"){
			document.list.action="RoomSellList?re=0";
		} else if (obj == "1"){
			document.list.action="RoomSellList?re=1";
		}
		
		document.list.submit(); 
		return true;
	}
	function reloadSearch() {
		document.list.action="RoomSellList?re=9";
		document.list.submit(); 
		return true;
	}	
	function my_write(user_id, cate_code_1) {

		if(user_id == "-"){
			document.list.action="RoomSellList?re=9&user_id=-";
		} else if(user_id == "_"){
			document.list.action="RoomSellList?re=9&user_id=";
		} else {
			document.list.action="RoomSellList?re=9&user_id=" + user_id;
		}		
		
		document.list.submit(); 
		return true;
	}
	function openDetailPage(id) {

		document.list.action="RoomSellDetail?before=search&id=" + id;
		document.list.submit(); 
		return true;
	}	
	function pageResize(ff) {
		ff.action="RoomSellList?re=9";
		ff.submit(); 
		return true;
	}	
	function roomSearch() {
		document.list.action="RoomSellList?re=9";
		document.list.submit(); 
		return true;
	}

	function registOpen(ff) {
		ff.action="RoomSellRegistOpen?before=search&f=search";
		ff.submit(); 
		return true;
	}
	/* POPUPメニューオープン時必要な値を設定*/
	function popupMenuOpen(userid, id, name) {			
		clickedUserid = userid;
		clickedId = id;
		clickedName = name;
	}
	function makewriteLook() {
		document.list.action="RoomSellList?re=9&user_id=" + clickedUserid;
		document.list.submit(); 
		return true;
	}
	
	function mailOpenAction() {
		mailOpen01(clickedId, clickedName, '4');
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
			<input type="hidden" name="user_id" value="${RoomSearchBean.user_id}"/>     				
			<input type="hidden" name="cate_code_1" value="${RoomSearchBean.cate_code_1}"/>
			<input type="hidden" name="before_pageNum" value="${RoomSearchBean.pageNum}"/>
			<input type="hidden" name="before_pageSize" value="${RoomSearchBean.pageSize}"/>
			<!--로그인 체크때문-->
			<c:if test="${!empty memberInfo}">
				<input type="hidden" id="loginSign" value="true">
			</c:if>
			<c:if test="${empty memberInfo}">
				<input type="hidden" id="loginSign" value="false">
			</c:if>
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0"/>
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
						<!--호텔/민박-->
						<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
						<td height="63" colspan="3" background="jsp/images/new/hotel_box_tit.gif">
							<table width="94%" border="0" align="center" cellpadding="0" cellspacing="1">
							<tr>
								<td width="13%" >&nbsp;</td>
								<td width="76%" ><span class="search-num1">(${PageBean.maxCount})</span></td>
								<td width="11%" align="right" >
									<a href="RoomSellList?re=9&cate_code_1=<%=roomSearchBean.getCate_code_1()%>"><img src="jsp/images/new/search_return_b.gif" width="94" height="22" /></a></td>
							</tr>
							</table>
						</td>
						</c:if>
						<!--기숙사/룸메이트-->
						<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
						 <td height="63" colspan="3" background="jsp/images/new/roomate_box_tit.gif">
						 <table width="94%" border="0" align="center" cellpadding="0" cellspacing="1">
							<tr>
								<td width="20%" >&nbsp;</td>
								<td width="69%" ><span class="search-num1">(${PageBean.maxCount})</span></td>
								<td width="11%" align="right" >
									<a href="RoomSellList?re=9&cate_code_1=<%=roomSearchBean.getCate_code_1()%>"><img src="jsp/images/new/search_return_b.gif" width="94" height="22" /></a></td>
							</tr>
							</table>
						</td>
						</c:if>
							
					</tr>
					<tr>
						<td background="jsp/images/new/search_box_left.gif" ><img src="jsp/images/new/search_box_left.gif" width="20" height="30" alt="" /></td>
						<td width="910" align="center" valign="middle" style="padding:10px 8px 8px 8px;">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<!--호텔/민박-->
							<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
							<tr>
								<td width="12%" align="left" ><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">요금</strong></td>
								<td width="41%" align="left" valign="top" >
									<select name="room_fee_from" id="select3" onchange='return reloadSearch()'>
										<option value="100">제한없음</option>
										${RoomSearchBean.room_fee1Tag}
									</select>엔~ 
									<select name="room_fee_to" id="select4">
										<option value="100">제한없음</option>
										${RoomSearchBean.room_fee2Tag}
									</select>엔
								</td>
								<td width="9%" align="left" ><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">종별</strong></td>
								<td width="38%" align="left" >
									<input value="8" type="checkbox" name="room_sort_8" <%=roomSearchBean.getRoom_sort_checked("8")%> />민박
									<input value="9" type="checkbox" name="room_sort_9" <%=roomSearchBean.getRoom_sort_checked("9")%> />비지니스호텔
									<input value="10" type="checkbox" name="room_sort_10" <%=roomSearchBean.getRoom_sort_checked("10")%> />호텔
									<input value="7" type="checkbox" name="room_sort_7" <%=roomSearchBean.getRoom_sort_checked("7")%> />게스트하우스
								</td>
							</tr>
							</c:if>
							<!--기숙사/룸메이트-->
							<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
							<tr>
								<td width="12%" align="left" valign="top" ><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">야칭</strong></td>
								<td width="41%" align="left" valign="top" >
									<select name="room_fee_from" id="select3" onchange='return reloadSearch()'>
										<option value="100">제한없음</option>
										${RoomSearchBean.house_fee1Tag}
									</select>만엔~ 
									<select name="room_fee_to" id="select4">
										<option value="100">제한없음</option>
										${RoomSearchBean.house_fee2Tag}
									</select>만엔
								</td>
								<td width="9%" align="left" ><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">종별</strong></td>
								<td width="38%" align="left" >
									<input value="0" type="checkbox" name="room_sort_0" <%=roomSearchBean.getRoom_sort_checked("0")%> />일반기숙사
									<input value="1" type="checkbox" name="room_sort_1" <%=roomSearchBean.getRoom_sort_checked("1")%> />원룸형기숙사
									<input value="2" type="checkbox" name="room_sort_2" <%=roomSearchBean.getRoom_sort_checked("2")%> />맨션형기숙사<br />
									<input value="3" type="checkbox" name="room_sort_3" <%=roomSearchBean.getRoom_sort_checked("3")%> />룸메이트
									<input value="4" type="checkbox" name="room_sort_4" <%=roomSearchBean.getRoom_sort_checked("4")%> />홈스테이
									<input value="5" type="checkbox" name="room_sort_5" <%=roomSearchBean.getRoom_sort_checked("5")%> />고급기숙사
									<input value="6" type="checkbox" name="room_sort_6" <%=roomSearchBean.getRoom_sort_checked("6")%> />먼슬리맨션 
								</td>
							</tr>
							</c:if>
							<tr>
								<td height="23" colspan="4" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							<tr>
								<td align="left" valign="top"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">노선정보</strong></td>
								<td align="left" valign="top">
									<select name="search_line_code" id="select5" onchange="return reloadAreaLineSearch('1');">
										${RoomSearchBean.lineTag}
									</select>센 
									<select name="search_station_code" id="select6">
										${RoomSearchBean.stationTag}
										<option>역명</option>
									</select>역</td>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">성별</strong></td>
								<td align="left">
									<input value="0" type="radio" name="search_sex" <%=roomSearchBean.getSex_checked("0")%> />남
									<input value="1" type="radio" name="search_sex" <%=roomSearchBean.getSex_checked("1")%> />여
									<input value="2" type="radio" name="search_sex" <%=roomSearchBean.getSex_checked("2")%> />지정안함	
								</td>
							</tr>
							<tr>
								<td height="23" colspan="4" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							<tr>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">상세지역설정</strong></td>
								<td align="left">
									<select name="search_area_code_1" id="select7" onchange="return reloadAreaLineSearch('0');">
										${RoomSearchBean.area_1Tag}
									</select>
									<select name="search_area_code_2" id="select8">
										${RoomSearchBean.area_2Tag}
							  		</select>
							  	</td>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">방타입</strong></td>
								<td align="left">
									<input value="0" type="radio" name="search_room_type" <%=roomSearchBean.getRoom_type_checked("0")%> />1인실
									<input value="1" type="radio" name="search_room_type" <%=roomSearchBean.getRoom_type_checked("1")%> />2인실
									<input value="2" type="radio" name="search_room_type" <%=roomSearchBean.getRoom_type_checked("2")%> />다인실
									<input value="3" type="radio" name="search_room_type" <%=roomSearchBean.getRoom_type_checked("3")%> />지정안함
								</td>
							</tr>
							<tr>
								<td height="23" colspan="4" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							<tr>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">최신정보</strong></td>
								<td align="left" valign="top">
									<input value="0" type="radio" name="search_regist_date" <%=roomSearchBean.getRegist_date_selected("0")%> />하루 이내
									<input value="1" type="radio" name="search_regist_date" <%=roomSearchBean.getRegist_date_selected("1")%> />1주일 이내
									<input value="2" type="radio" name="search_regist_date" <%=roomSearchBean.getRegist_date_selected("2")%> />1달 이내
									<input value="3" type="radio" name="search_regist_date" <%=roomSearchBean.getRegist_date_selected("3")%> />지정안함
								</td>
								<!--호텔/민박-->
								<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
								<td colspan="2" align="left" valign="top">&nbsp;</td>
								</c:if>
								<!--기숙사/룸메이트-->
								<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
								<td align="left" valign="top"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">건물종류</strong></td>
            					<td align="left" valign="top">
            						<input value="0" type="radio" name="search_build_sort" <%=roomSearchBean.getBuild_sort_checked("0")%> />아파트
                					<input value="1" type="radio" name="search_build_sort" <%=roomSearchBean.getBuild_sort_checked("1")%> />맨션
									<input value="2" type="radio" name="search_build_sort" <%=roomSearchBean.getBuild_sort_checked("2")%> />지정안함
								</td>
								</c:if>
							</tr>
							<tr>
								<td height="10" colspan="4" align="center"></td>
							</tr>
							<tr>
								<td height="1" colspan="4" align="center" bgcolor="#CCCCCC"></td>
							</tr>
							<tr>
								<td height="10" colspan="4" align="center"></td>
							</tr>
							<tr>
								<td colspan="4" align="center">
									<!-- 검색버튼 -->
									<a href="javascript:roomSearch()"><img src="jsp/images/new/search_b.gif" width="107" height="35" /></a></td>
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
							<c:if test="${empty RoomSearchBean.user_id}">
								<img src="jsp/images/new/search_tit2.gif" width="118" height="23" />
							</c:if>	
							<c:if test="${!empty RoomSearchBean.user_id}">
								<img src="jsp/images/new/mywrite_title.gif" width="118" height="23" />
							</c:if>	
						</td>
						<td width="56%">&nbsp;</td>
						<td width="31%" align="right">
							<select name="pageSize" id="select2" onchange='return pageResize(list)'>
								<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10개씩보기</option>
								<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20개씩보기</option>
								<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50개씩보기</option>
								<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100개씩보기</option>
							</select>
							<c:if test="${empty RoomSearchBean.user_id}">
								<!--ID가 없으면 내글보기표시 -->
								<c:if test="${empty memberInfo.userid}">
		              			<a href="javascript:my_write('-');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>	
		              			<c:if test="${!empty memberInfo.userid}">
		              			<a href="javascript:my_write('${memberInfo.userid}');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>
							</c:if>	
							<c:if test="${!empty RoomSearchBean.user_id}">
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
						<td height="41" colspan="9" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="6%" align="center" class="board-title-text"><span class="style8">번호</span></td>
								<td width="8%" align="center" class="board-title-text"><span class="style8">이미지</span></td>
								<td width="28%" align="center" class="board-title-text"><span class="style8">글제목/방물건명</span></td>
								<td width="9%" align="center" class="board-title-text"><span class="style8">종별</span></td>
								<td width="20%" align="center" class="board-title-text"><span class="style8">지역/노선정보</span></td>
								<!--호텔/민박-->
								<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
									<td width="8%" align="center" class="board-title-text"><span class="style8">요금</span></td>
								</c:if>
								<!--기숙사/룸메이트-->
								<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
									<td width="8%" align="center" class="board-title-text"><span class="style8">야칭</span></td>
								</c:if>
								<td width="7%" align="center" class="board-title-text"><span class="style8">등록자</span></td>
								<td width="7%" align="center" class="board-title-text"><span class="style8">등록일</span></td>
								<td width="7%" align="center" class="board-title-text"><span class="style8">조회수</span></td>								
							</tr>
							</table>
						</td>
					</tr>
					<c:choose>
					<c:when test="${!empty RoomBeanList}">
						<c:forEach var="RoomBean" items="${RoomBeanList}" varStatus="i">
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								${RoomBean.id}&nbsp;
							</td>
							<!--이미지 -->
							<td width="8%" align="center">
								<a href="javascript:openDetailPage('${RoomBean.id}');"><img src="${RoomBean.thumbNail_path}" ></a>
								&nbsp;
							</td>
							<!--글제목/방물건명 -->
							<td width="28%">
								<a href="javascript:openDetailPage('${RoomBean.id}');">
									${RoomBean.title}${util:getNewImage(RoomBean.update_dateTime)}<br><c:out value="${RoomBean.room_name}"/></a>&nbsp;
							</td>
							<!--종별 -->
							<td width="9%" align="center">
								<c:if test="${RoomBean.room_sort == '0'}">
									일반기숙사
								</c:if>
								<c:if test="${RoomBean.room_sort == '1'}">
									원룸형기숙사
								</c:if>
								<c:if test="${RoomBean.room_sort == '2'}">
									맨션형기숙사
				            	</c:if>
								<c:if test="${RoomBean.room_sort == '3'}">
									룸메이트
								</c:if>
				            	<c:if test="${RoomBean.room_sort == '4'}">
									홈스테이
				            	</c:if>
				            	<c:if test="${RoomBean.room_sort == '5'}">
									고급기숙사
				            	</c:if>
				            	<c:if test="${RoomBean.room_sort == '6'}">
									먼슬리맨션
				            	</c:if>
				            	<c:if test="${RoomBean.room_sort == '7'}">
									게스트하우스
				            	</c:if>
				            	<c:if test="${RoomBean.room_sort == '8'}">
									민박
				            	</c:if>
				            	<c:if test="${RoomBean.room_sort == '9'}">
									비지니스호텔
				            	</c:if>
				            	<c:if test="${RoomBean.room_sort == '10'}">
									호텔
				            	</c:if>&nbsp;
							</td>
							<!--지역/노선정보 -->
							<td width="20%" align="center">
								<c:out value="${RoomBean.area_name_1}${RoomBean.area_name_2}"/><br><c:out value="${RoomBean.lineInfo}"/>&nbsp;
							</td>
							<!--요금 /야칭-->
							<td width="8%" align="center">
								<c:out value="${RoomBean.room_fee}"/>
								<c:if test="${!empty RoomBean.room_fee and RoomBean.room_fee != '0'}">
									<!--호텔/민박-->
									<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
										엔
									</c:if>
									<!--기숙사/룸메이트-->
									<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
										만엔
									</c:if>
								</c:if>&nbsp;
							</td>
							<!--등록자 -->
							<td width="7%" align="center">
								<!--<a href="javascript:my_write('${RoomBean.user_id}');"><span style="text-decoration: underline">${RoomBean.user_name}</span>&nbsp;-->
								<span class="registUser" id="link${i.index + 1}" onclick="popupMenuOpen('${RoomBean.user_id}','${RoomBean.id}','${RoomBean.user_name}')">${RoomBean.user_name}&nbsp;</span>
							</td>
							<!--등록일 -->
							<td width="7%" align="center">
								<c:out value="${RoomBean.update_date}"/>&nbsp;
							</td>
							<!--조회수 -->
							<td width="7%" align="center">
								<c:out value="${RoomBean.read_count}"/>&nbsp;
							</td>
						</tr>
						<tr align="center" bgcolor="#CCCCCC">
							<td height="1" colspan="9" ></td>
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
			</table>
		</td>
	</tr>
	<tr>
		<td height="50">&nbsp;</td>
	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
	<div id = "popup" style = "display:none" class="popupMenu">
		<table>
			<tr><td class="board-title-text"><a href="javascript:makewriteLook();">작성글보기</a></td></tr>
			<tr><td class="board-title-text"><a href="" onclick="mailOpenAction(); return false;">메일보내기</a></td></tr>
		</table>
	</div>
</body>
</html>

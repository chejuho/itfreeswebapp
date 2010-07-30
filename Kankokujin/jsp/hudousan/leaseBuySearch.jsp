<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="hudousan.bean.HudousanSearchBean" %>
<%@ page import="hudousan.bean.HudousanSortBean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="hudousan" var="message"/>

<%
HudousanSearchBean hudousanSearchBean = (HudousanSearchBean)session.getAttribute("HudousanSearchBean");
HudousanSortBean sortBean = (HudousanSortBean)session.getAttribute("HudousanSortBean");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="TITLE.main" bundle="${message}"/></title>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">


	function makePathForSort(sort, value) {
		var leaseSign = document.getElementById("leaseSign").value;
		var mode = document.getElementById("mode").value;
		var path = "HudousanSearchAction?";
		var method;
		
		if (leaseSign == '1') {
			if (mode == 'SearchMode') {
				method = "method=leaseSearchSort";
			} 
			if (mode == 'SuggestMode') {
				method = "method=leaseSuggest";
			}
		} 
		if (leaseSign == '0') {
			if (mode == 'SearchMode') {
				method = "method=buySearchSort";
			} 
			if (mode == 'SuggestMode') {
				method = "method=buySuggest";
			}
		}
		
		var sort = sort + "=" + value;
		//alert(path + method + "&" + sort);
		return path + method + "&" + sort;
	}
	
	function makePathForPage(pageNum) {
		
		var mode = document.getElementById("mode").value;
		var leaseSign = document.getElementById("leaseSign").value;
		var path = "HudousanSearchAction?";
		var method;
		
		if (leaseSign == '1') {
			if (mode == 'SearchMode') {
				method = "method=leaseSearch";
			} 
			if (mode == 'SuggestMode') {
				method = "method=leaseSuggest";
			}
		} 
		if (leaseSign == '0') {
			if (mode == 'SearchMode') {
				method = "method=buySearch";
			} 
			if (mode == 'SuggestMode') {
				method = "method=buySuggest";
			}
		}
		var page = "pageNum="+pageNum;
		return path + method + "&" + page;
	}
	
	
	/* サーチボタンを押した時 */
	function sellsearch(searchform, leaseSign) {
		if (leaseSign == '0') {
			searchform.action="HudousanSearchAction?method=buySearch";
		}
		if (leaseSign == '1') {
			searchform.action="HudousanSearchAction?method=leaseSearch";
		}
		searchform.submit();
		return true;
	}
	
	/* 詳細画面をオープン */
	function openDetailPage(id, leaseSign) {
		
		document.search.action="HudousanDetailAction?id=" + id + "&leaseSign=" + leaseSign;
		document.search.submit(); 
		return true;
	}
	
	function reloadPage(obj) {
		document.search.action = makePathForPage(obj);
		document.search.submit(); 
		return true;
	}
	/* 地域 */
	function changeAddressSort() {
		var address_up = document.getElementById("address_up").value;
		search.action=makePathForSort("address_up", address_up);
		search.submit(); 
		return true;
	}
	/* 路線 */
	function changeLineSort() {
		var line_up = document.getElementById("line_up").value;
		search.action=makePathForSort("line_up", line_up);
		search.submit();
		return true;
	}
	/* 徒歩 */
	function changeWalkSort() {
		var walk_up = document.getElementById("walk_up").value;
		search.action=makePathForSort("walk_up", walk_up);
		search.submit(); 
		
		return true;
	}
	/* 家賃 */
	function changeHouseFeeSort() {
		var houseFee_up = document.getElementById("houseFee_up").value;
		search.action=makePathForSort("houseFee_up", houseFee_up);
		search.submit(); 
		return true;
	}
	/* 管理費 */
	function changeManageFeeSort() {
		var manageFee_up = document.getElementById("manageFee_up").value;
		search.action=makePathForSort("manageFee_up", manageFee_up);
		search.submit(); 
		return true;
	}
	/* 敷金 */
	function changeDepositSort() {
		var deposit_up = document.getElementById("deposit_up").value;
		search.action=makePathForSort("deposit_up", deposit_up);
		search.submit(); 
		return true;
	}
	/* 礼金 */
	function changeReikinSort() {
		var reikin_up = document.getElementById("reikin_up").value;
		search.action=makePathForSort("reikin_up", reikin_up);
		search.submit(); 
		return true;
	}
	/* 保証金 */
	function changeGuarantySort() {
		var guaranty_up = document.getElementById("guaranty_up").value;
		search.action=makePathForSort("guaranty_up", guaranty_up);
		search.submit(); 
		return true;
	}
	/* 間取り */
	function changeMadoriSort() {
		var madori_up = document.getElementById("madori_up").value;
		search.action=makePathForSort("madori_up", madori_up);
		search.submit(); 
		return true;
	}
	/* 面積 */
	function changeDimensionSort() {
		var dimension_up = document.getElementById("dimension_up").value;
		search.action=makePathForSort("dimension_up", dimension_up);
		search.submit(); 
		return true;
	}
	/* 種類 */
	function changeHouseSort() {
		var houseSort_up = document.getElementById("houseSort_up").value;
		search.action=makePathForSort("houseSort_up", houseSort_up);
		search.submit(); 
		return true;
	}
	/* 建築年度 */	
	function changeBuildDateSort() {
		var buildDate_up = document.getElementById("buildDate_up").value;
		search.action=makePathForSort("buildDate_up", buildDate_up);
		search.submit(); 
		return true;
	}
</script>
</head>
<body topmargin="0" leftmargin="0">
<form name="search" method="post" style="margin:0">
<input type="hidden" id="leaseSign" value="${leaseSign}"/>
<input type="hidden" id="mode" value="${mode}"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<c:import url="top.jsp" />
	
	<tr>
    	<td>
    		
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
      		<c:if test="${mode == 'SearchMode' || mode == 'SearchInitMode'}">
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
								<td width="76%" >
									<span class="search-num1">
										<c:if test="${!empty PageBean}">
											(${PageBean.maxCount})
										</c:if>
									</span>
								</td>
								<td width="11%" align="right" ><a href="HudousanSearchAction?method=leaseSearchInit"><img src="jsp/images/new/search_return_b.gif" width="94" height="22" /></a></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td background="jsp/images/new/search_box_left.gif" ><img src="jsp/images/new/search_box_left.gif" width="20" height="30" alt="" /></td>
						<td width="910" align="center" valign="middle" style="padding:10px 8px 8px 8px;">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="29%" align="left" >
									<img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w">
										<!--賃貸の場合-->
										<c:if test="${leaseSign == '1'}">
										<fmt:message key="search.label.searchCondition1" bundle="${message}"/>
										</c:if>
										<!--売買の場合-->
										<c:if test="${leaseSign == '0'}">
										<fmt:message key="search.label.searchCondition13" bundle="${message}"/>
										</c:if>
									</strong>
								</td>
								<td width="29%" align="left" >
									<img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w"><fmt:message key="search.label.searchCondition2" bundle="${message}"/></strong>
								</td>
								<td width="42%" align="left" >
									<img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<span class="blue-text-w"><strong><fmt:message key="search.label.searchCondition3" bundle="${message}"/></strong></span>
								</td>
							</tr>
							<tr>
								<td height="30" align="left" >
									<!--賃貸の場合-->
									<c:if test="${leaseSign == '1'}">
										<select name="house_fee_from" id="select3" onchange="return sellsearch(search,'${leaseSign}');">
											<option value="100">제한없음</option>
											${HudousanSearchBean.house_fee1Tag}
										</select>만엔~
										<select name="house_fee_to" id="select4" >
											<option value="100">제한없음</option>
											${HudousanSearchBean.house_fee2Tag}
										</select>
										만엔
									</c:if>
									<!--売買の場合-->
									<c:if test="${leaseSign == '0'}">
										<select name="house_fee_from" id="select3" onchange="return sellsearch(search,'${leaseSign}');">
											<option value="100">제한없음</option>
											${HudousanSearchBean.house_feeBuy1Tag}
										</select>~
										<select name="house_fee_to" id="select4" >
											<option value="100">제한없음</option>
											${HudousanSearchBean.house_feeBuy2Tag}
										</select>
									</c:if>
									
								</td>
								<td align="left" >
									<select name="search_area_code_1" id="select7" onchange="return sellsearch(search,'${leaseSign}');">
										${HudousanSearchBean.area_1Tag}
									</select>
									<select name="search_area_code_2" id="select8">
										${HudousanSearchBean.area_2Tag}
									</select>
								</td>
								<td align="left" >
									<select name="search_line_code" id="select5" onchange="return sellsearch(search,'${leaseSign}');">
										${HudousanSearchBean.lineTag}
									</select>센
									<select name="search_station_code" id="select6">
										${HudousanSearchBean.stationTag}
									</select>역
								</td>
							</tr>
							<tr>
								<td height="23" colspan="3" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							<tr>
								<td align="left" valign="top">
									<img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w"><fmt:message key="search.label.searchCondition4" bundle="${message}"/></strong></td>
								<td align="left">
									<img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<span class="blue-text-w"><strong><fmt:message key="search.label.searchCondition5" bundle="${message}"/></strong></span></td>
								<td align="left">
									<img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" />
									<strong class="blue-text-w"><fmt:message key="search.label.searchCondition6" bundle="${message}"/></strong></td>
							</tr>
							<tr>
								<td align="left" valign="top">
									<input value="0" type="radio" name="search_regist_date" <%=hudousanSearchBean.getRegist_date_selected("0")%> />하루 이내
									<input value="1" type="radio" name="search_regist_date" <%=hudousanSearchBean.getRegist_date_selected("1")%> />1주일 이내
									<input value="2" type="radio" name="search_regist_date" <%=hudousanSearchBean.getRegist_date_selected("2")%>  />1달 이내<br />
									<input value="3" type="radio" name="search_regist_date" <%=hudousanSearchBean.getRegist_date_selected("3")%> />지정안함
								</td>
								<td align="left" valign="top">
									<select name="dimension_1" id="select9">
										<option value="1000">제한없음</option>
										${HudousanSearchBean.dimension1Tag}
									</select>m2~
									<select name="dimension_2" id="select10">
										<option value="1000">제한없음</option>
										${HudousanSearchBean.dimension2Tag}
									</select>m2
								</td>
								<td align="left">
									<input value="0" type="checkbox" name="madori_0" <%=hudousanSearchBean.getMadori_checked(0)%> />1R
									<input value="1" type="checkbox" name="madori_1" <%=hudousanSearchBean.getMadori_checked(1)%> />1K
									<input value="2" type="checkbox" name="madori_2" <%=hudousanSearchBean.getMadori_checked(2)%> />1DK
									<input value="3" type="checkbox" name="madori_3" <%=hudousanSearchBean.getMadori_checked(3)%> />1LDK
									<input value="4" type="checkbox" name="madori_4" <%=hudousanSearchBean.getMadori_checked(4)%> />2K
									<input value="5" type="checkbox" name="madori_5" <%=hudousanSearchBean.getMadori_checked(5)%> />2DK <br />
									<input value="6" type="checkbox" name="madori_6" <%=hudousanSearchBean.getMadori_checked(6)%> />2LDK
									<input value="7" type="checkbox" name="madori_7" <%=hudousanSearchBean.getMadori_checked(7)%> />3DK
									<input value="8" type="checkbox" name="madori_8" <%=hudousanSearchBean.getMadori_checked(8)%> />3LDK
									<input value="9" type="checkbox" name="madori_9" <%=hudousanSearchBean.getMadori_checked(9)%> />4DK
									<input value="10" type="checkbox" name="madori_10" <%=hudousanSearchBean.getMadori_checked(10)%> />4LDK
									<input value="11" type="checkbox" name="madori_11" <%=hudousanSearchBean.getMadori_checked(11)%> />기타
								</td>
							</tr>
							<tr>
								<td height="23" colspan="3" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							<tr>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w"><fmt:message key="search.label.searchCondition7" bundle="${message}"/></strong></td>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w"><fmt:message key="search.label.searchCondition8" bundle="${message}"/></strong></td>
								<td align="left"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w"><fmt:message key="search.label.searchCondition9" bundle="${message}"/></strong></td>
							</tr>
							<tr>
								<td align="left">
									<input value="0" type="radio" name="search_build_year" <%=hudousanSearchBean.getBuild_year_checked("0")%> />신축
									<input value="1" type="radio" name="search_build_year" <%=hudousanSearchBean.getBuild_year_checked("1")%> />3년이내
									<input value="2" type="radio" name="search_build_year" <%=hudousanSearchBean.getBuild_year_checked("2")%> />5년이내
									<input value="3" type="radio" name="search_build_year" <%=hudousanSearchBean.getBuild_year_checked("3")%> />10년이내 <br />
									<input value="4" type="radio" name="search_build_year" <%=hudousanSearchBean.getBuild_year_checked("4")%> />지정안함</td>
								<td align="left" valign="top">
									<input value="0" type="radio" name="search_toilet" <%=hudousanSearchBean.getToilet_checked(0)%> />화장실 욕조별도
									<input value="1" type="radio" name="search_toilet" <%=hudousanSearchBean.getToilet_checked(1)%> />  지정안함</td>
								<td align="left">
									<input value="0" type="checkbox" name="house_sort_0" <%=hudousanSearchBean.getHouse_sort_checked(0)%> />아파트
									<input value="1" type="checkbox" name="house_sort_1" <%=hudousanSearchBean.getHouse_sort_checked(1)%> />맨션
									<input value="2" type="checkbox" name="house_sort_2" <%=hudousanSearchBean.getHouse_sort_checked(2)%> />개인주택
									<input value="3" type="checkbox" name="house_sort_3" <%=hudousanSearchBean.getHouse_sort_checked(3)%> />주차장
									<input value="4" type="checkbox" name="house_sort_4" <%=hudousanSearchBean.getHouse_sort_checked(4)%> />점포<br />
									<input value="5" type="checkbox" name="house_sort_5" <%=hudousanSearchBean.getHouse_sort_checked(5)%> />사무실
									<input value="6" type="checkbox" name="house_sort_6" <%=hudousanSearchBean.getHouse_sort_checked(6)%> />토지
									<input value="7" type="checkbox" name="house_sort_7" <%=hudousanSearchBean.getHouse_sort_checked(7)%> />기타</td>
							</tr>
							<tr>
								<td height="23" colspan="3" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							<tr>
								<td align="left" valign="top"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><strong class="blue-text-w"><fmt:message key="search.label.searchCondition10" bundle="${message}"/></strong></td>
								<td align="left" valign="top"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><span class="blue-text-w"><strong><fmt:message key="search.label.searchCondition11" bundle="${message}"/></strong></span></td>
								<td align="left" valign="top"><img src="jsp/images/new/searchbox_icon2.gif"  align="baseline" width="16" height="14" /><span class="blue-text-w"><strong><fmt:message key="search.label.searchCondition12" bundle="${message}"/></strong></span></td>
							</tr>
							<tr>
								<td align="left" valign="top">
									<input value="0" type="radio" name="search_walk_time" <%=hudousanSearchBean.getWalk_time_checked("0")%> />5분이내
									<input value="1" type="radio" name="search_walk_time" <%=hudousanSearchBean.getWalk_time_checked("1")%> />10분이내
									<input value="2" type="radio" name="search_walk_time" <%=hudousanSearchBean.getWalk_time_checked("2")%> />15분이내 <br />
									<input value="3" type="radio" name="search_walk_time" <%=hudousanSearchBean.getWalk_time_checked("3")%> />지정안함 </td>
								<td align="left" valign="top">
									<input value="0" type="radio" name="search_flg_tadami" <%=hudousanSearchBean.getFlg_tadami_checked("0")%> />타다미포함
									<input value="1" type="radio" name="search_flg_tadami" <%=hudousanSearchBean.getFlg_tadami_checked("1")%> />플로링만
									<input value="2" type="radio" name="search_flg_tadami" <%=hudousanSearchBean.getFlg_tadami_checked("2")%> />지정안함 </td>
								<td align="left" valign="top">
									<input value="1" type="checkbox" name="house_option_0" <%=hudousanSearchBean.getHouse_option_checked(0)%> />2층이상
									<input value="1" type="checkbox" name="house_option_1" <%=hudousanSearchBean.getHouse_option_checked(1)%> />2명입거가능
									<input value="1" type="checkbox" name="house_option_2" <%=hudousanSearchBean.getHouse_option_checked(2)%> />가족가능 <br />
									<input value="1" type="checkbox" name="house_option_3" <%=hudousanSearchBean.getHouse_option_checked(3)%> />애완동물가능 </td>
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
									<a href="javascript:sellsearch(search,'${leaseSign}');"><img src="jsp/images/new/search_b.gif" width="107" height="35" /></a></td>
							</tr>
							</table>
						</td>
						<td background="jsp/images/new/search_box_right.gif"><img src="jsp/images/new/search_box_right.gif" width="20" height="30" alt="" /></td>
					</tr>
					<tr>
						<td colspan="3"><img src="jsp/images/new/search_box_under.gif" width="950" height="14" alt="" /></td>
					</tr>
					</table>
					</c:if>
				</td>
			<tr>
      </tr>
      <tr>
        <td>
        	<c:if test="${mode == 'SearchMode'}">
        	<table width="100%" border="0" cellspacing="1" cellpadding="0">
          	<tr>
	            <td width="13%"><img src="jsp/images/new/search_tit2.gif" width="118" height="23" /></td>
	            <td width="56%">&nbsp;</td>
	            <td width="31%" align="right"><select name="select2" id="select2">
	                <option>10개씩보기</option>
	                <option>20개씩보기</option>
	                <option>50개씩보기</option>
	                <option>100개씩보기</option>
	              </select>
	            </td>
          	</tr>
          	<tr>
            	<td height="6" colspan="3"></td>
            </tr>
        	</table>
        	</c:if>
        </td>
      </tr>
      
      <tr>
		<td>
			<c:if test="${mode == 'SearchMode' || mode == 'SuggestMode'}">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="41" colspan="10" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
					<table width="100%" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="6%" align="center" class="board-title-text"><span class="style8">번호</span></td>
						<td width="8%" align="center" class="board-title-text"><span class="style8">이미지</span></td>
						<td width="28%" align="center" class="board-title-text"><span class="style8">글제목</span></td>
						<td width="16%" align="center" class="board-title-text">
							<span class="style8">지역</span>
							<a href="javascript:changeAddressSort();">
								<input type="image" src="<%=sortBean.getAddress_image() %>" id="address_up" value="<%=sortBean.getAddress_up() %>"/>
							</a>
							<br>
							<span class="style8">노선정보</span>
							<a href="javascript:changeLineSort();">
								<input type="image" src="<%=sortBean.getLine_image() %>" id="line_up" value="<%=sortBean.getLine_up() %>"/>
							</a>
						</td>
						<td width="5%" align="center" class="board-title-text">
							<span class="style8">도보</span>
							<a href="javascript:changeWalkSort();">
								<input type="image" src="<%=sortBean.getWalk_image() %>" id="walk_up" value="<%=sortBean.getWalk_up() %>"/>
							</a>
						</td>
						<td width="7%" align="center" class="board-title-text">
							<span class="style8">야찡</span>
							<a href="javascript:changeHouseFeeSort();">
								<input type="image" src="<%=sortBean.getHouseFee_image() %>" id="houseFee_up" value="<%=sortBean.getHouseFee_up() %>"/>
							</a>
							<br>
							<span class="style8">/관리비</span>
							<a href="javascript:changeManageFeeSort();">
								<input type="image" src="<%=sortBean.getManageFee_image() %>" id="manageFee_up" value="<%=sortBean.getManageFee_up() %>"/>
							</a>
						</td>
						<td width="7%" align="center" class="board-title-text">
							<span class="style8">시끼낑</span>
							<a href="javascript:changeDepositSort();">
								<input type="image" src="<%=sortBean.getDeposit_image() %>" id="deposit_up" value="<%=sortBean.getDeposit_up() %>"/>
							</a>
							<br>
							<span class="style8">/레이킹</span>
							<a href="javascript:changeReikinSort();">
								<input type="image" src="<%=sortBean.getReikin_image() %>" id="reikin_up" value="<%=sortBean.getReikin_up() %>"/>
							</a>
						</td>
						<td width="7%" align="center" class="board-title-text">
							<span class="style8">보증금</span>
							<a href="javascript:changeGuarantySort();">
								<input type="image" src="<%=sortBean.getGuaranty_image() %>" id="guaranty_up" value="<%=sortBean.getGuaranty_up() %>"/>
							</a>
						</td>
						<td width="8%" align="center" class="board-title-text">
							<span class="style8">마도리</span>
							<a href="javascript:changeMadoriSort();">
								<input type="image" src="<%=sortBean.getMadori_image() %>" id="madori_up" value="<%=sortBean.getMadori_up() %>"/>
							</a>
							<br>
							<span class="style8">/전용면적</span>
							<a href="javascript:changeDimensionSort();">
								<input type="image" src="<%=sortBean.getDimension_image() %>" id="dimension_up" value="<%=sortBean.getDimension_up() %>"/>
							</a>
						</td>
						<td width="8%" align="center" class="board-title-text">
							<span class="style8">건물종류</span>
							<a href="javascript:changeHouseSort();">
								<input type="image" src="<%=sortBean.getHouseSort_image() %>" id="houseSort_up" value="<%=sortBean.getHouseSort_up() %>"/>
							</a>
							<br>
							<span class="style8">/건축년도</span>
							<a href="javascript:changeBuildDateSort();">
								<input type="image" src="<%=sortBean.getBuildDate_image() %>" id="buildDate_up" value="<%=sortBean.getBuildDate_up() %>"/>
							</a>
						</td>
					</tr>
					</table>					
				</td>
				
			</tr>
			
			<c:choose>
			<c:when test="${!empty HudousanBeanList}">
				<c:forEach var="HudousanBean" items="${HudousanBeanList}" >
				<tr>
					<!--번호 -->
					<td width="6%" height="52" align="center">
						${HudousanBean.id}&nbsp;
					</td>
					<!--이미지 -->
					<td width="8%" align="center">
						<a href="javascript:openDetailPage('${HudousanBean.id}','${leaseSign}');"><img src="${HudousanBean.thumbNail_path}" ></a>
						&nbsp;
					</td>
					<!--글제목 -->
					<td width="28%">
						<a href="javascript:openDetailPage('${HudousanBean.id}','${leaseSign}');">
							<c:out value="${HudousanBean.title}"/>${util:getNewImage(HudousanBean.update_dateTime)}</a>&nbsp;
					</td>
					<!--지역/노선정보 -->
					<td width="16%" align="center">
						<c:out value="${HudousanBean.area_fast}${HudousanBean.area_name_1}${HudousanBean.area_name_2}"/><br><c:out value="${HudousanBean.lineInfo}"/>&nbsp;
					</td>
					<!--도보-->
					<td width="5%" align="center">
						<c:if test="${!empty HudousanBean.walk_time and HudousanBean.walk_time != '0'}">
							<c:out value="${HudousanBean.walk_time}분"/>
						</c:if>&nbsp;
					</td>
				<!--야찡/관리비-->
				<td width="7%" align="center">
					<c:if test="${!empty HudousanBean.house_fee[0] and HudousanBean.house_fee[0] != '0'}">
						<c:out value="${HudousanBean.house_fee[0]}만엔"/><br>
					</c:if>
					<c:if test="${!empty HudousanBean.manage_fee and HudousanBean.manage_fee != '0'}">
						<c:out value="${HudousanBean.manage_fee}만엔"/>	
					</c:if>
				</td>
				<!--시끼낑/레이킹-->
				<td width="7%" align="center">
					<c:if test="${!empty HudousanBean.deposit and HudousanBean.deposit != '0'}">
						<c:out value="${HudousanBean.deposit}개월분"/><br><c:out value="${HudousanBean.reikin}개월분"/>
					</c:if>
				</td>
				<!--보증금 -->
				<td width="7%" align="center">
					<c:if test="${!empty HudousanBean.guaranty_money and HudousanBean.guaranty_money != '0'}">
						<c:out value="${HudousanBean.guaranty_money}개월분"/>
					</c:if>
				</td>
				<!--마도리/전용면적 -->
				<td width="8%" align="center">
					<c:if test="${HudousanBean.madori == '0'}">
						1R
					</c:if>
					<c:if test="${HudousanBean.madori == '1'}">
						1K
					</c:if>
					<c:if test="${HudousanBean.madori == '2'}">
						1DK
	            	</c:if>
					<c:if test="${HudousanBean.madori == '3'}">
						1LDK
					</c:if>
	            	<c:if test="${HudousanBean.madori == '4'}">
						2K
	            	</c:if>
	            	<c:if test="${HudousanBean.madori == '5'}">
						2DK
	            	</c:if>
	            	<c:if test="${HudousanBean.madori == '6'}">
						2LDK
	            	</c:if>
	            	<c:if test="${HudousanBean.madori == '7'}">
						3DK
	            	</c:if>
	            	<c:if test="${HudousanBean.madori == '8'}">
						3LDK
	            	</c:if>
	            	<c:if test="${HudousanBean.madori == '9'}">
						4DK
	            	</c:if>
	            	<c:if test="${HudousanBean.madori == '10'}">
						4LDK
	            	</c:if>
	            	<c:if test="${HudousanBean.madori == '11'}">
						기타
	            	</c:if>
	            	<br>
	            	<c:if test="${!empty HudousanBean.dimension[0] and HudousanBean.dimension[0] != '0'}">
						<c:out value="${HudousanBean.dimension[0]}m2"/>
					</c:if>&nbsp;
				</td>
				<!--건물종류/건축년도 -->
				<td width="8%" align="center">
					<c:if test="${HudousanBean.house_sort == '0'}">
						아파트
					</c:if>
					<c:if test="${HudousanBean.house_sort == '1'}">
						맨션
					</c:if>
					<c:if test="${HudousanBean.house_sort == '2'}">
						개인주택
	            	</c:if>
					<c:if test="${HudousanBean.house_sort == '3'}">
						주차장
					</c:if>
	            	<c:if test="${HudousanBean.house_sort == '4'}">
						점포
	            	</c:if>
	            	<c:if test="${HudousanBean.house_sort == '5'}">
						사무실
	            	</c:if>
	            	<c:if test="${HudousanBean.house_sort == '6'}">
						토지
	            	</c:if>
	            	<c:if test="${HudousanBean.house_sort == '7'}">
						기타
	            	</c:if>
	            		<br>
	            	<c:if test="${!empty HudousanBean.build_year and HudousanBean.build_year != '0'}">
						<c:out value="${HudousanBean.build_year}년"/>
					</c:if>
					<c:if test="${!empty HudousanBean.build_month and HudousanBean.build_month != '0'}">
						<c:out value="${HudousanBean.build_month}월"/>
					</c:if>
					&nbsp;
				</td>
			</tr>
			<tr align="center" bgcolor="#CCCCCC">
				<td height="1" colspan="10" ></td>
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
			</c:if>
		</td>
	</tr>
	
	<tr>
	      	<td height="2" align="center" bgcolor="#CCCCCC"></td>
	    	</tr>	
	<tr>
		<td align="center">&nbsp;</td>
	</tr>
	<c:if test="${!empty PageBean}">
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
	 </table></td>
	  </tr>
	  <tr>
	    <td height="50">&nbsp;</td>
	  </tr>
</table>
</form>
</body>
</html>


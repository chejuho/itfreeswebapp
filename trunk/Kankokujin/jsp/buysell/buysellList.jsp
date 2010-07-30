<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.PageBean, category.bean.CategoryBean"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ page import="buysell.bean.BuySellBean, buysell.bean.BuySellSearchBean"%>
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
	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	List buySellBeanList = (List) request.getAttribute("BuySellBeanList");
	BuySellSearchBean buySellSearchBean = (BuySellSearchBean) request.getAttribute("BuySellSearchBean");
	List category2List = (List) request.getAttribute("Category2List");
	
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	MemberBean member = new MemberBean();
	member.setUserid("-");
	if (session.getAttribute("memberInfo")!=null){
		member = (MemberBean) session.getAttribute("memberInfo");	
	}
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
	<title><c:out value="물건사기"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
</c:if>
<c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
	<title><c:out value="물건팔기"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
</c:if>

<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript" charset="utf-8"></script>

<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">	
<script type="text/javascript">
	var clickedUserid;
	var clickedId;
	var clickedName;
	var popupMenuList = new Array();
	window.onload = function()
	{
		for (var i = 1; i < 11; i++) {
			var name = "link" + i;
			if ($(name)) {
				popupMenuList.push(new PopupMenu($(name), $("popup")));
			}
		}
	}
	/** ERROR메세지 처리  */
	 function messageCheck() {
		var message = document.getElementById("msg").value;
		if (message) {
			if (message == 'WAR0004'){
				alert("<fmt:message key="WAR0004" bundle="${message}"/>");
				window.open('PopLogin', 'notice', 'width=230, height=160');	
			}
		}
	}
	function registOpen(ff) {
		ff.action="BuySellRegistOpen?before=search&f=search";
		ff.submit(); 
		return true;
	}	
	function storePageSize(ff) {
		ff.action="BuySellList?re=9";
		ff.submit(); 
		return true;
	}
	function changeView(obj) {
		document.list.action="BuySellList?re=9&list_view="+obj;
		document.list.submit(); 
		return true;
	}

	function reloadPage(obj) {
		document.list.action="BuySellList?pageNum="+obj;
		document.list.submit(); 
		return true;
	}	
	function reloadCate_code_2(cate_code_1, cate_code_2) {
		document.list.action="BuySellList?re=9&search_cate_code_1=" + cate_code_1 + "&search_cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}
	function searchStore(cate_code_1, cate_code_2) {
		document.list.action="BuySellList?re=9&search_cate_code_1=" + cate_code_1 + "&search_cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}	
	function my_write(user_id) {
		if(user_id == "-"){
			document.list.action="BuySellList?re=9&user_id=-";
		} else if(user_id == "_"){
			document.list.action="BuySellList?re=9&user_id=";
		} else {
			document.list.action="BuySellList?re=9&user_id=" + user_id;
		}	
		document.list.submit(); 
		return true;
	}
	function openDetailPage(id) {

		document.list.action="BuySellDetail?before=search&id=" + id;
		document.list.submit(); 
		return true;
	}
	/* POPUPメニューオープン時必要な値を設定*/
	function popupMenuOpen(userid, id, name) {			
		clickedUserid = userid;
		clickedId = id;
		clickedName = name;
	}
	function makewriteLook() {
		document.list.action="BuySellList?re=9&user_id=" + clickedUserid;
		document.list.submit(); 
		return true;
	}
	
	function mailOpenAction() {
		mailOpen(clickedId, clickedName, '1');
		return true;
	}
	
	
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
			<input type="hidden" name="user_id" value="<%=buySellSearchBean.getUser_id()%>">      	
			<input type="hidden" name="before_cate_code_1" value="<%=buySellSearchBean.getCate_code_1()%>">
			<input type="hidden" name="before_cate_code_2" value="<%=buySellSearchBean.getCate_code_2()%>">       			        			      			
			<input type="hidden" name="before_list_view" value="<%=buySellSearchBean.getList_view()%>">       			        			      			 				
			<input type="hidden" name="before_pageSize" value="<%=pageBean.getPageSize()%>">       			        			      			 				 				
			<input type="hidden" name="before_pageNum" value="<%=buySellSearchBean.getPageNum()%>">
			<!--로그인 체크때문-->
			<c:if test="${!empty memberInfo}">
				<input type="hidden" id="loginSign" value="true">
			</c:if>
			<c:if test="${empty memberInfo}">
				<input type="hidden" id="loginSign" value="false">
			</c:if>
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
						<!--물건사기-->
						<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
						<td height="71" colspan="3" background="jsp/images/new/buy_box_tit.gif">
						</c:if>
						<!--물건팔기-->
						<c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
						<td height="71" colspan="3" background="jsp/images/new/sell_box_tit.gif">
						</c:if>
							<table width="90%"    border="0" align="center" cellpadding="0" cellspacing="1">
							<tr>
								<td width="17%" height="35" >&nbsp;</td>
								<!--제1카테고리-->
								<td width="83%" rowspan="2" >
									<c:forEach var="Category2" items="${Category2List}" varStatus="i">
										<!--선택된 카테고리의 경우 -->
          								<c:if test="${BuySellSearchBean.cate_code_2 == Category2.cate_code_2}">
											<span class="search-text2" onclick="return reloadCate_code_2('${BuySellSearchBean.cate_code_1}', '${Category2.cate_code_2}')"> 
												<!--카테고리명  검색건수 표시-->
												<c:out value="${Category2.cate_name_2}"/>
												<c:out value="("/>
												<c:if test="${empty Category2Count[Category2['cate_code_2']]}">
														<c:out value="0"/>
												</c:if>
												<c:if test="${!empty Category2Count[Category2['cate_code_2']]}">
														<c:out value="${Category2Count[Category2['cate_code_2']]}"/>
												</c:if>
												<c:out value=")"/>
											</span>
											<!--카테고리1이 마지막이 아닐경우 | 표시를 붙힌다-->	
											<c:if test="${!i.last}">
												<c:out value="|"/>  
											</c:if>							
										</c:if>
										<!---선택되지않은 카테고리의 경우 -->
										<c:if test="${BuySellSearchBean.cate_code_2 != Category2.cate_code_2}">
											<a href="javascript:reloadCate_code_2('${BuySellSearchBean.cate_code_1}', '${Category2.cate_code_2}')" class="search-link1">
												<!--카테고리명  검색건수 표시-->
												<c:out value="${Category2.cate_name_2}"/>
												<c:out value="("/>
													<c:if test="${empty Category2Count[Category2['cate_code_2']]}">
															<c:out value="0"/>
													</c:if>
													<c:if test="${!empty Category2Count[Category2['cate_code_2']]}">
															<c:out value="${Category2Count[Category2['cate_code_2']]}"/>
													</c:if>
												<c:out value=")"/>
											</a>
										<!--카테고리1이 마지막이 아닐경우 | 표시를 붙힌다-->	
										<c:if test="${!i.last}">
											<c:out value="|"/>  
										</c:if>				
										</c:if>	
										<!--화면에7건-->			
										<c:if test="${(i.index + 1) % 6 == 0}">
											<br>
										</c:if>
        							 </c:forEach>
								</td>
							</tr>
							<tr>
								<!--카테고리검색수-->
								<td height="25" class="search-num1" >
									<c:out value="("/>
									<c:out value="${Category2Count['categoryTotalCount']}"/>
									<c:out value=")"/></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td background="jsp/images/new/search_box_left.gif" ><img src="jsp/images/new/search_box_left.gif" width="20" height="30" alt="" /></td>
						<td width="910" align="center" valign="middle" style="padding:10px 8px 8px 8px;">
							<!--검색-->
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="89%" align="left">
									<select name="search_pro_status">
											<option selected="selected" value="0" ${BuySellSearchBean.pro_status_no_matter} >제품상태</option>
											<option value="1" ${BuySellSearchBean.pro_status_used}>중고</option>
											<option value="2" ${BuySellSearchBean.pro_status_new}>신제품</option>
									</select>
									<!--물건사기-->
									<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
										<select name="search_send_method">
											<option selected="selected" value="0" ${BuySellSearchBean.send_no_matter}>배송방식</option>
											<option value="1" ${BuySellSearchBean.send_direct}>직거래</option>
											<option value="2" ${BuySellSearchBean.send_post}>택배</option>
										</select>
										
									</c:if>
									<!--물건팔기-->
									<c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">								
										<select name="search_member_sort">
											<option selected="selected" value="0" ${BuySellSearchBean.member_no_matter}>판매자구분</option>
											<option value="1" ${BuySellSearchBean.member_ama}>개인회원</option>
											<option value="2" ${BuySellSearchBean.member_pro}>업자회원</option>
										</select>
										<select name="search_free_price">
											<option selected="selected" value="0" ${BuySellSearchBean.price_no_matter}>무료여부</option>
											<option value="1" ${BuySellSearchBean.price_free_price}>무료</option>
										</select>
										<select name="search_send_method">
											<option selected="selected" value="0" ${BuySellSearchBean.send_no_matter}>배송방식</option>
											<option value="1" ${BuySellSearchBean.send_direct}>직거래</option>
											<option value="2" ${BuySellSearchBean.send_post}>택배</option>
										</select>&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="search_sold_out" ${BuySellSearchBean.sold_out_checked} />판매완료&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</c:if>
										<select name="search_range">
											<option selected="selected" value="0" ${BuySellSearchBean.search_all}>전체검색</option>
											<option value="1" ${BuySellSearchBean.search_title}>글제목</option>
											<option value="2" ${BuySellSearchBean.search_name}>등록자</option>
											<option value="3" ${BuySellSearchBean.search_detail}>상세정보</option>
										</select>
									<input maxlength="100" name="search" value="${BuySellSearchBean.search}" />
								</td>
								<td width="11%" align="right">
									<a href="BuySellList?re=9&search_cate_code_1=${BuySellSearchBean.cate_code_1}"><img src="jsp/images/new/search_return_b.gif" width="94" height="22" /></a>
								</td>
							</tr>
							<tr>
								<td height="10" colspan="2" align="center"></td>
							</tr>
							<tr>
								<td height="1" colspan="2" align="center" bgcolor="#CCCCCC"></td>
							</tr>
							<tr>
								<td height="10" colspan="2" align="center"></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<a href="javascript:searchStore('${BuySellSearchBean.cate_code_1}', '${BuySellSearchBean.cate_code_2}')"><img src="jsp/images/new/search_b.gif" width="107" height="35" /></a>
								</td>
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
					<!--물건사기-->
					<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
						<tr>
							<td width="13%">
								<c:if test="${empty BuySellSearchBean.user_id}">
									<img src="jsp/images/new/search_tit2.gif" width="118" height="23" />
								</c:if>	
								<c:if test="${!empty BuySellSearchBean.user_id}">
									<img src="jsp/images/new/mywrite_title.gif" width="118" height="23" />
								</c:if>	
							</td>
							<td width="59%" align="right" valign="bottom">
								<img src="jsp/images/new/board_icon1.gif" align="absmiddle" width="16" height="17" />중고 
								<img src="jsp/images/new/board_icon2.gif" align="absmiddle" width="16" height="17" />신제품 
								<img src="jsp/images/new/board_icon3.gif" align="absmiddle" width="29" height="17" />무료 
								<img src="jsp/images/new/board_icon4.gif"  align="absmiddle" width="16" height="17" />직거래 
								<img src="jsp/images/new/board_icon5.gif"  align="absmiddle" width="16" height="17" />택배</td>
							<td width="28%" align="right">
								<select name="pageSize" id="pageSize" onchange='return storePageSize(list)'>
									<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10개씩보기</option>
									<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20개씩보기</option>
									<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50개씩보기</option>
									<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100개씩보기</option>
								</select>
								<!--내글보기버튼 -->
								<c:if test="${empty BuySellSearchBean.user_id}">
									<!--ID가 없으면 내글보기표시 -->
									<c:if test="${empty memberInfo.userid}">
			              			<a href="javascript:my_write('-');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" /></a>&nbsp;
			              			</c:if>	
			              			<c:if test="${!empty memberInfo.userid}">
			              			<a href="javascript:my_write('${memberInfo.userid}');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" /></a>&nbsp;
			              			</c:if>	
								</c:if>	
								<c:if test="${!empty BuySellSearchBean.user_id}">
									<!--ID가 있으면 목록표시 -->
								 	<a href="javascript:my_write('_');"><img src="jsp/images/new/btn_list.gif" align="absmiddle" /></a>							
								</c:if>	
								<!--등록버튼 -->
								<a href="javascript:registOpen(list);"><img src="jsp/images/new/resigter_b.gif" align="absmiddle" width="58" height="22" /></a>
							</td>
						</tr>
						<tr>
							<td height="6" colspan="3"></td>
						</tr>
					</c:if>
					<!--물건팔기-->
					<c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
						<tr>
							<td width="13%">&nbsp;</td>
							<td width="21%">&nbsp;</td>
							<td width="39%" align="right">
								<select name="pageSize" id="select2" onchange='return storePageSize(list)'>
									<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10개씩보기</option>
									<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20개씩보기</option>
									<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50개씩보기</option>
									<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100개씩보기</option>
								</select>
							</td>
							<td width="27%" align="right">
								<!--이미지보기버튼 -->
								<c:if test="${empty BuySellSearchBean.list_view or BuySellSearchBean.list_view == '0'}">
									<a href="javascript:changeView(1);"><img src="jsp/images/new/board_img_see.gif" border="0"  align="absmiddle" /></a>&nbsp;
								</c:if>
								<!--텍스트보기버튼 -->
								<c:if test="${BuySellSearchBean.list_view == '1'}">
									<a href="javascript:changeView(0);"><img src="jsp/images/new/board_text_see.gif" border="0"  align="absmiddle" /></a>&nbsp;
								</c:if>	
								<!--내글보기버튼 -->
								<c:if test="${empty BuySellSearchBean.user_id}">
			              			<!--ID가 없으면 내글보기표시 -->
									<c:if test="${empty memberInfo.userid}">
			              			<a href="javascript:my_write('-');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" /></a>&nbsp;
			              			</c:if>	
			              			<c:if test="${!empty memberInfo.userid}">
			              			<a href="javascript:my_write('${memberInfo.userid}');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
			              			</c:if>	
								</c:if>	
								<c:if test="${!empty BuySellSearchBean.user_id}">
									<!--ID가 있으면 목록표시 -->
								 	<a href="javascript:my_write('_');"><img src="jsp/images/new/btn_list.gif" align="absmiddle" /></a>&nbsp;						
								</c:if>	
								<!--등록버튼 -->
								<a href="javascript:registOpen(list);"><img src="jsp/images/new/resigter_b.gif" width="58" height="22" border="0" align="absmiddle" /></a>
							</td>
						</tr>
						<tr>
							<td>
								<c:if test="${empty BuySellSearchBean.user_id}">
									<img src="jsp/images/new/search_tit2.gif" width="118" height="23" />
								</c:if>	
								<c:if test="${!empty BuySellSearchBean.user_id}">
									<img src="jsp/images/new/mywrite_title.gif" width="118" height="23" />
								</c:if>	
							</td>
							<td width="21%">&nbsp;</td>
							<td colspan="2" align="right" valign="bottom">
								<img src="jsp/images/new/board_icon1.gif" align="absmiddle" width="16" height="17" />중고 
								<img src="jsp/images/new/board_icon2.gif" align="absmiddle" width="16" height="17" />신제품 
								<img src="jsp/images/new/board_icon3.gif" align="absmiddle" width="29" height="17" />무료 
								<img src="jsp/images/new/board_icon4.gif"  align="absmiddle" width="16" height="17" />직거래 
								<img src="jsp/images/new/board_icon5.gif"  align="absmiddle" width="16" height="17" />택배 
								<img src="jsp/images/new/board_icon6.gif" align="absmiddle" width="16" height="17" />판매완료 
								<img src="jsp/images/new/board_icon7.gif" align="absmiddle" width="16" height="17" />개인회원 
								<img src="jsp/images/new/board_icon8.gif" align="absmiddle" width="16" height="17" />업자회원
							</td>
          				</tr>
						<tr>
							<td height="6" colspan="4"></td>
						</tr>
					</c:if>
					</table>	
				</td>
			</tr>
			<!--물건사기-->
			<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
			<tr>
				<td>
					<!--머릿글 -->
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="41" colspan="8" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="5%" align="center" class="board-title-text">번호</td>
				                <td width="34%" align="center" class="board-title-text">글제목</td>
				                <td width="8%" align="center" class="board-title-text">가격</td>
				                <td width="12%" align="center" class="board-title-text">희망거래장소</td>
				                <td width="11%" align="center" class="board-title-text">제품상태<br />배송방식</td>
				                <td width="10%" align="center" class="board-title-text">등록일</td>
				                <td width="12%" align="center" class="board-title-text">등록자</td>
				                <td width="8%" align="center" class="board-title-text">조회수</td>
							</tr>
							</table>	
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
						<c:when test="${!empty BuySellBeanList}">
							<c:forEach var="BuySellBean" items="${BuySellBeanList}" varStatus="i">
								<tr>
									<!--번호-->
									<td width="5%" height="52" align="center">${BuySellBean.id}</td>
									<!--글제목-->
						            <td width="34%">
						            	<a href="javascript:openDetailPage('${BuySellBean.id}');">${BuySellBean.title}${util:getNewImage(BuySellBean.update_dateTime)}</a>
						            	&nbsp;
						            </td>
						            <!--가격-->
						            <td width="8%" align="center">
						            	<c:if test="${BuySellBean.free_price == '1'}">
						            		<img src="jsp/images/new/board_icon3.gif" align="middle">
						            	</c:if>
						            	<c:if test="${BuySellBean.free_price != '1' and !empty BuySellBean.price}">
						            		<c:out value="${BuySellBean.price}"/>
						            	</c:if>
						            	&nbsp;
						            </td>
						            <!--희망거래장소-->
						            <td width="12%" align="center"><c:out value="${BuySellBean.sell_place}"/>&nbsp;</td>
						            <!--제품상태/배송방식-->
						            <td width="11%" align="center">
						            	<!--중고품-->
						            	<c:if test="${BuySellBean.pro_status == '1'}">
						            		<img src="jsp/images/new/board_icon1.gif" align="middle">
						            	</c:if>
						            	<!--신제품-->
						            	<c:if test="${BuySellBean.pro_status == '2'}">
						            		<img src="jsp/images/new/board_icon2.gif" align="middle">
						            	</c:if>
						            	<!--직거래/택배-->
						            	<c:if test="${BuySellBean.send_method == '0'}">
						            		<img src="jsp/images/new/board_icon4.gif" align="middle">
						            		<img src="jsp/images/new/board_icon5.gif" align="middle">
						            	</c:if>
						            	<!--직거래-->
						            	<c:if test="${BuySellBean.send_method == '1'}">
						            		<img src="jsp/images/new/board_icon4.gif" align="middle">
						            	</c:if>
						            	<!--택배-->
						            	<c:if test="${BuySellBean.send_method == '2'}">
						            		<img src="jsp/images/new/board_icon5.gif" align="middle">
						            	</c:if>
						            	&nbsp;
						            </td>
						            <!--등록일-->
						            <td width="10%" align="center">
						            	<c:out value="${BuySellBean.update_date}"/>
						            	&nbsp;
						            </td>
						            <!--등록자-->
						            <td width="12%" align="left">
						            	<!--<a href="javascript:my_write('${BuySellBean.user_id}');"><span style="text-decoration: underline">${BuySellBean.user_name}</span>-->
						            	<span class="registUser" id="link${i.index + 1}" onclick="popupMenuOpen('${BuySellBean.user_id}','${BuySellBean.id}','${BuySellBean.user_name}')">${BuySellBean.user_name}&nbsp;</span>
						            	&nbsp;
						            </td>
						             <!--조회수-->
						            <td width="8%" align="center">
						            	<c:out value="${BuySellBean.read_count}"/>
						            	&nbsp;
						            </td>
								</tr>
								<tr align="center" bgcolor="#CCCCCC">
									<td height="1" colspan="8" ></td>
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
			</c:if>
			<!--물건사기 END-->
			<!--물건팔기 -->
			<c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
				<!--텍스트보기-->
				<c:if test="${empty BuySellSearchBean.list_view or BuySellSearchBean.list_view == '0'}">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="41" colspan="9" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
									<table width="100%" border="0" cellspacing="1" cellpadding="0">
									<tr>
										<td width="5%" align="center" class="board-title-text">번호</td>
										<td width="6%" align="center" class="board-title-text">이미지</td>
										<td width="28%" align="center" class="board-title-text">글제목</td>
										<td width="8%" align="center" class="board-title-text">가격</td>
										<td width="12%" align="center" class="board-title-text"> 희망거래장소</td>
										<td width="11%" align="center" class="board-title-text">제품상태<br />배송방식</td>
										<td width="10%" align="center" class="board-title-text">등록일</td>
										<td width="12%" align="center" class="board-title-text">등록자</td>
										<td width="8%" align="center" class="board-title-text">조회수</td>
										
									</tr>
									</table>	
								</td>
							</tr>
							<!--내용표시 -->
							<c:choose>
								<c:when test="${!empty BuySellBeanList}">
								<c:forEach var="BuySellBean" items="${BuySellBeanList}" varStatus="i">
									<tr>
										<!--번호-->
										<td width="5%" height="52" align="center">${BuySellBean.id}</td>
										<!--이미지-->
										<td width="6%" align="center">
											<a href="javascript:openDetailPage('${BuySellBean.id}');"><img src="${BuySellBean.thumbNail_path}" /></a></td>
										<!--글제목-->
							            <td width="28%">
							            	<a href="javascript:openDetailPage('${BuySellBean.id}');">${BuySellBean.title}${util:getNewImage(BuySellBean.update_dateTime)}</a>
							            	&nbsp;
							            </td>
							            <!--가격-->
							            <td width="8%" align="center">
							            	<!--무료-->
							            	<c:if test="${BuySellBean.free_price == '1'}">
							            		<img src="jsp/images/new/board_icon3.gif" align="middle">
							            	</c:if>
							            	<c:if test="${BuySellBean.free_price != '1' and !empty BuySellBean.price}">
							            		<c:out value="${BuySellBean.price}"/>
						            			<c:if test="${empty BuySellBean.price_unit or BuySellBean.price_unit == '0'}">
						            				<c:out value="엔"/>
						            			</c:if>
						            			<c:if test="${!empty BuySellBean.price_unit and BuySellBean.price_unit == '1'}">
						            				<c:out value="원"/>
						            			</c:if>
							            	</c:if>
							            	&nbsp;
							            </td>
							            <!--희망거래장소-->
							            <td width="12%" align="center"><c:out value="${BuySellBean.sell_place}"/>&nbsp;</td>
							            <!--제품상태/배송방식-->
							            <td width="11%" align="center">
							            	<!--중고품-->
							            	<c:if test="${BuySellBean.pro_status == '1'}">
							            		<img src="jsp/images/new/board_icon1.gif" align="middle">
							            	</c:if>
							            	<!--신제품-->
							            	<c:if test="${BuySellBean.pro_status == '2'}">
							            		<img src="jsp/images/new/board_icon2.gif" align="middle">
							            	</c:if>
							            	<!--직거래/택배-->
							            	<c:if test="${BuySellBean.send_method == '0'}">
							            		<img src="jsp/images/new/board_icon4.gif" align="middle">
							            		<img src="jsp/images/new/board_icon5.gif" align="middle">
							            	</c:if>
							            	<!--직거래-->
							            	<c:if test="${BuySellBean.send_method == '1'}">
							            		<img src="jsp/images/new/board_icon4.gif" align="middle">
							            	</c:if>
							            	<!--택배-->
							            	<c:if test="${BuySellBean.send_method == '2'}">
							            		<img src="jsp/images/new/board_icon5.gif" align="middle">
							            	</c:if>
							            	&nbsp;
							            </td>
							            <!--등록일-->
							            <td width="10%" align="center">
							            	<c:out value="${BuySellBean.update_date}"/>
							            	&nbsp;
							            </td>
							            <!--등록자-->
							            <td width="12%" align="left">
							            	<!--<a href="javascript:my_write('${BuySellBean.user_id}');"><span style="text-decoration: underline">${BuySellBean.user_name}</span>-->
							            	<span class="registUser" id="link${i.index + 1}" onclick="popupMenuOpen('${BuySellBean.user_id}','${BuySellBean.id}','${BuySellBean.user_name}')">${BuySellBean.user_name}&nbsp;</span>
							            	&nbsp;
							            	<!--개인-->
							            	<c:if test="${BuySellBean.member_sort == '1'}">
							            		<img src="jsp/images/new/board_icon7.gif" align="middle">
							            	</c:if>
							            	<!--업자-->
							            	<c:if test="${BuySellBean.member_sort == '2'}">
							            		<img src="jsp/images/new/board_icon8.gif" align="middle">
							            	</c:if>
							            </td>
							             <!--조회수-->
							            <td width="8%" align="center">
							            	<c:out value="${BuySellBean.read_count}"/>
							            	&nbsp;
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
				</c:if>
				<!--텍스트보기 END -->
				<!--이미지 보기 -->
				<c:if test="${BuySellSearchBean.list_view == '1'}">
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="100%" height="20" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">&nbsp;</td>
						</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="5" align="center"></td>
				</tr>
				<c:choose>
					<c:when test="${!empty BuySellBeanList}">
						<c:forEach var="BuySellBean" items="${BuySellBeanList}" varStatus="status">
						<c:if test="${status.first}">
						<!--처음이면 테이블 테그 생성  -->
						<tr>
							<td align="left">
								<table width="100%" align="left" border="0" cellspacing="0" cellpadding="0">
						  		<tr>
						</c:if>
					  			<!--표시부분 START -->
								<td align="left" width="25%">
									<table align="left" height="190" border="0" cellpadding="0" cellspacing="0">
									<tr height="190" cellspacing="0">
										<td align="center">
											<a href="javascript:openDetailPage('${BuySellBean.id}');"><img src="${BuySellBean.photo_path1}" alt="" width="230"  height="190"></a>
										</td>
									</tr>
									<tr>
										<td height="5" align="center" bgcolor="#FFFFFF"></td>
									</tr>
									<tr>
										<td align="center"">
											<strong><c:out value="${util:cutLongName(12,BuySellBean.title)}" />${util:getNewImage(BuySellBean.update_dateTime)}</strong>
										</td>
									</tr>
									<tr>
										<td align="center"">
											<span class="red-text-w"><strong>가격:
											<c:if test="${BuySellBean.free_price == '1'}">
							            		<img src="jsp/images/new/board_icon3.gif" align="middle">
							            	</c:if>
							            	<c:if test="${BuySellBean.free_price != '1' and !empty BuySellBean.price}">
							            		
							            		<c:out value="${BuySellBean.price}"/>
						            			<c:if test="${empty BuySellBean.price_unit or BuySellBean.price_unit == '0'}">
						            				<c:out value="엔"/>
						            			</c:if>
						            			<c:if test="${!empty BuySellBean.price_unit and BuySellBean.price_unit == '1'}">
						            				<c:out value="원"/>
						            			</c:if>
						            			
							            	</c:if>
							            	</strong></span><br />
										</td>
									</tr>
									<tr>
										<td align="center">
											<c:out value="${BuySellBean.sell_place}"/>
											<!--중고품-->
							            	<c:if test="${BuySellBean.pro_status == '1'}">
							            		<img src="jsp/images/new/board_icon1.gif" align="absmiddle" width="16" height="17" />
							            	</c:if>
							            	<!--신제품-->
							            	<c:if test="${BuySellBean.pro_status == '2'}">
							            		<img src="jsp/images/new/board_icon2.gif" align="absmiddle" width="16" height="17" />
							            	</c:if>
							            	<!--직거래/택배-->
							            	<c:if test="${BuySellBean.send_method == '0'}">
							            		<img src="jsp/images/new/board_icon4.gif" align="absmiddle" width="16" height="17" />
							            		<img src="jsp/images/new/board_icon5.gif" align="absmiddle" width="16" height="17" />
							            	</c:if>
							            	<!--직거래-->
							            	<c:if test="${BuySellBean.send_method == '1'}">
							            		<img src="jsp/images/new/board_icon4.gif" align="absmiddle" width="16" height="17" />
							            	</c:if>
							            	<!--택배-->
							            	<c:if test="${BuySellBean.send_method == '2'}">
							            		<img src="jsp/images/new/board_icon5.gif" align="absmiddle" width="16" height="17" />
							            	</c:if>
										</td>
									</tr>
									</table>
								</td>
						  		<!--표시부분 END -->
						<!--4의배수 and 마지막이 아닐때 개행처리   -->						  									
						<c:if test="${(status.index + 1) % 4 == 0 and !status.last}">
								</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="1" align="center" bgcolor="#CCCCCC"></td>
						</tr>
						<tr>
							<td height="5" align="center"></td>
						</tr>
						<tr>
							<td align="center">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
						  		<tr>
						</c:if>
						<!--마지막일때 개행처리   -->
						<c:if test="${status.last}">
								<c:if test="${(status.index + 1) % 4 != 0}">
									<c:forEach var="i" begin="0" end="${(status.index + 1) % 4}" step="1">
										<td align="left" width="25%">&nbsp;</td>
									</c:forEach>
								</c:if>
								</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="5" colspan="4" align="center"></td>
						</tr>
						</c:if>		
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
				</c:if>
			</c:if>
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
				<!--페이지표시 -->
				<td align="center">
					<myTags:pageHandle/>
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
 	<div id = "popup" style = "display:none" class="popupMenu">
		<table>
			<tr><td class="board-title-text"><a href="javascript:makewriteLook();">작성글보기</a></td></tr>
			<tr><td class="board-title-text"><a href="" onclick="mailOpenAction(); return false;">메일보내기</a></td></tr>
		</table>
	</div>
</body>
</html>
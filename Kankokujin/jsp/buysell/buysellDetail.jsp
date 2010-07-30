<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="common.bean.MemberBean, common.util.EnDecoding"%>
<%@ page import="buysell.bean.BuySellBean, buysell.bean.BuySellSearchBean"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	BuySellBean buySellBean = (BuySellBean) request.getAttribute("BuySellBean");
	BuySellSearchBean buySellSearchBean = (BuySellSearchBean) request.getAttribute("BuySellSearchBean");
	
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<head>
<title>${BuySellBean.title}&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
	var clickedId;
	function goDirectTopMenu(topMenu) {
	 	//var topMenu =	document.getElementById("topMenu").value;
	 	if (topMenu == '1') {
	 		document.wf.action="BuySellList?re=9&search_cate_code_1=C10100&search_cate_code_2=";
	 	}
	 	if (topMenu == '2') {
	 		document.wf.action="BuySellList?re=9&search_cate_code_1=C10200&search_cate_code_2=";
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
	
	function goDirectCategory(category1, category2) {
		//var category1 =	document.getElementById("category1").value;
     	//var category2 =	document.getElementById("category2").value;
		document.wf.action="BuySellList?re=9&search_cate_code_1=" + category1 + "&search_cate_code_2=" + category2;
		document.wf.submit(); 
		return true;
	}
	function deleteCheck(id){
	
			if(confirm("삭제하시겠습니까?")){
				document.wf.action="BuySellDelete?id="+id;
				document.wf.submit(); 
				return;
			}
	}
	function finishCheck(id, flg){
	
			if(confirm("판매완료 처리 하시겠습니까?")){
				document.wf.action="BuySellDelete?id="+id+"&flg="+flg;
				document.wf.submit(); 
				return true;
			}
	}
	//공개 비공개 판매완료　처리
	function deleteSignAction(id, flg){
		if (flg == "0") {
			if(confirm("공개로  처리 하시겠습니까?")){
				document.wf.action="BuySellDelete?id="+id+"&flg="+flg;
				document.wf.submit(); 
				return true;
			}
		}
		if (flg == "1") {
			if(confirm("삭제하시겠습니까?")){
				document.wf.action="BuySellDelete?id="+id+"&flg="+flg;
				document.wf.submit(); 
				return true;
			}
		}
		if (flg == "2") {
			if(confirm("판매완료 처리 하시겠습니까?")){
				document.wf.action="BuySellDelete?id="+id+"&flg="+flg;
				document.wf.submit(); 
				return true;
			}
		}
		if (flg == "3") {
			if(confirm("비공개로  처리 하시겠습니까?")){
				document.wf.action="BuySellDelete?id="+id+"&flg="+flg;
				document.wf.submit(); 
				return true;
			}
		}
	}	
		
	function openUpdate(id){
		document.wf.action="BuySellUpdateOpen?id=" + id;
		document.wf.submit(); 
		return true;
	}	
	function setImage(position){
		document.getElementById("disp").src = position;
		return false;
	}	
	function backSearchPage() {
		document.wf.action="BuySellList?re=9&modoru=ok";
		document.wf.submit(); 
		return true;
	}
	function backMySearchPage(ff, obj) {
		ff.submit(); 
		return true;
	}	
	function backSearchAllPage() {
		document.wf.action="AllSearch";
		document.wf.submit(); 
		return true;
	}	
	function backMyWrite(obj) {
		document.wf.action="MyWrite?sort=" + obj + "&modoru=ok";
		document.wf.submit(); 
		return true;
	}
	function goSearchPage() {
		document.wf.action="BuySellList?re=9";
		document.wf.submit(); 
		return true;
	}
	
	function mailOpenDetail(id,name) {
		mailOpen(id, name, '1');
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
			<input type="hidden" name="id"	value="<%=buySellBean.getId()%>">
			<input type="hidden" name="user_id" value="<%=buySellSearchBean.getUser_id()%>">      		    
		    <input type="hidden" name="search_cate_code_1" value="<%=buySellSearchBean.getCate_code_1()%>">
  			<input type="hidden" name="search_cate_code_2" value="<%=buySellSearchBean.getCate_code_2()%>">
  			<input type="hidden" name="search" value="<%=buySellSearchBean.getSearch()%>">      			      			
  			<input type="hidden" name="decodedSearch" value="<%=buySellSearchBean.getDecodedSearch()%>">      			      			
  			<input type="hidden" name="search_range" value="<%=buySellSearchBean.getSearch_range()%>">      			      		
			<input type="hidden" name="pageSize" value="<%=buySellSearchBean.getPageSize()%>">      			      				      			      			      			      			
  			<input type="hidden" name="pageNum" value="<%=buySellSearchBean.getPageNum()%>">      			
  			<input type="hidden" name="before" value="<%=buySellSearchBean.getBefore()%>">      			      			
  			<input type="hidden" name="list_view" value="<%=buySellSearchBean.getList_view()%>"> 
			<input type="hidden" name="search_pro_status" value="<%=buySellSearchBean.getPro_status()%>">       			
			<input type="hidden" name="search_member_sort" value="<%=buySellSearchBean.getMember_sort()%>">       			
			<input type="hidden" name="search_free_price" value="<%=buySellSearchBean.getFree_price()%>">       			
			<input type="hidden" name="search_send_method" value="<%=buySellSearchBean.getSend_method()%>">       			
			<input type="hidden" name="search_sold_out" value="<%=buySellSearchBean.getSold_out()%>">  
  			<input type="hidden" name="all_search" value="<%=EnDecoding.decoding(buySellSearchBean.getAll_search())%>"> 
  			<input type="hidden" name="all_search_range" value="<%=buySellSearchBean.getAll_search_range()%>"> 				     
  			
  			<input type="hidden" name="photo1" value="${BuySellBean.photo_path1}">  
  			<input type="hidden" name="photo2" value="${BuySellBean.photo_path2}">  
  			<input type="hidden" name="photo3" value="${BuySellBean.photo_path3}">  
  			<input type="hidden" name="photo4" value="${BuySellBean.photo_path4}">  
  			<input type="hidden" name="photo5" value="${BuySellBean.photo_path5}">
  			<!--로그인 체크때문-->
			<c:if test="${!empty memberInfo}">
				<input type="hidden" id="loginSign" value="true">
			</c:if>
			<c:if test="${empty memberInfo}">
				<input type="hidden" id="loginSign" value="false">
			</c:if>
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" height="40" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="5%"><a href="Index"><img src="jsp/images/new/home_icon.gif" width="16" height="16" align="absmiddle"/>Home</a></td>
						<td width="41%" style="padding-top:3px;"> 
							<!-- 현재위치표시-->
							<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
			                    &nbsp;&gt;&nbsp;<a href="javascript:goDirectTopMenu('1');">물건사기</a>
		                    </c:if>
		                    <c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
		                    	&nbsp;&gt;&nbsp;<a href="javascript:goDirectTopMenu('2');">물건팔기</a>
		                    </c:if>	
							&nbsp;&gt;&nbsp;<a href="javascript:goDirectCategory('${BuySellBean.cate_code_1}', '${BuySellBean.cate_code_2}');">${BuySellBean.cate_name_2}</a>
							<!--&gt;
							<select name="topMenu" id="topMenu" onchange="return goDirectTopMenu();">
								<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
			                    	<option value="1" selected="selected">물건사기</option>
			                    	<option value="2" >물건팔기</option>
			                    </c:if>
			                    <c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
			                    	 <option value="1" >물건사기</option>
			                    	 <option value="2" selected="selected">물건팔기</option>
			                    </c:if>	
			                    <option value="3">업체찾기</option>
			                    <option value="4">음식점</option>
			                    <option value="5">호텔/민박</option>
			                    <option value="6">기숙사/룸메이트</option>
			                    <option value="7">부동산</option>
			                    <option value="8">구인</option>
			                    <option value="9">구직</option>
							</select>
							<c:if test="${!empty Category2List}">&gt;
							<select name="category2" id="category2" onchange="return goDirectCategory();">
								<c:forEach var="Category2" items="${Category2List}" varStatus="i">
									<c:if test="${BuySellBean.cate_code_2 == Category2.cate_code_2}">
										<option selected value="<c:out value='${Category2.cate_code_2}'/>"><c:out value="${Category2.cate_name_2}"/></option>
									</c:if>
									<c:if test="${BuySellBean.cate_code_2 != Category2.cate_code_2}">
										<option value="<c:out value='${Category2.cate_code_2}'/>"><c:out value="${Category2.cate_name_2}"/></option>
									</c:if>	
								</c:forEach>
							</select>&nbsp;
							</c:if>-->
						</td>
						<td width="47%" align="right" style="padding-top:3px;">
							<!--물건사기-->
							<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
								<!--목록버튼 -->
								<c:if test="${BuySellSearchBean.before == 'search'}">
			              			<!--ID가 없으면 내글보기표시 -->
			              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
								</c:if>	
								<!--전의페이지가 통합검색의경우 -->
								<c:if test="${BuySellSearchBean.before == 'search_all'}">
								 	<a href="javascript:backSearchAllPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
								</c:if>
								<c:if test="${BuySellSearchBean.before == 'mysearch'}">
									<!--ID가 있으면 목록표시 -->
								 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
								</c:if>
								<!--전의페이지가 내글보기의경우 -->
								<c:if test="${BuySellSearchBean.before == 'my_write'}">
								 	<a href="javascript:backMyWrite(1);"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
								</c:if>
								<!--전의페이지가 메인화면일경우 -->
								<c:if test="${BuySellSearchBean.before == 'new_write'}">
              						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
								</c:if>									
								<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
								<c:if test="${BuySellBean.user_id == memberInfo.userid}">
									<a href="javascript:openUpdate('${BuySellBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
									<a href="javascript:deleteCheck('${BuySellBean.id}');"><img src="jsp/images/new/btn_delete.gif"></a>
								</c:if>	
							</c:if>
							<!--물건팔기-->
							<c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
								<!--목록버튼 -->
								<c:if test="${BuySellSearchBean.before == 'search'}">
			              			<!--ID가 없으면 내글보기표시 -->
			              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
								</c:if>	
								<!--전의페이지가 통합검색의경우 -->		
								<c:if test="${BuySellSearchBean.before == 'search_all'}">
									<!--ID가 있으면 목록표시 -->
								 	<a href="javascript:backSearchAllPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
								</c:if>
								<c:if test="${BuySellSearchBean.before == 'mysearch'}">
									<!--ID가 있으면 목록표시 -->
								 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
								</c:if>
								<c:if test="${BuySellSearchBean.before == 'my_write'}">
									<!--ID가 있으면 목록표시 -->
								 	<a href="javascript:backMyWrite(2);"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
								</c:if>
								<c:if test="${BuySellSearchBean.before == 'new_write'}">
              						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
								</c:if>	
								<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
								<c:if test="${BuySellBean.user_id == memberInfo.userid}">
									<a href="javascript:openUpdate('${BuySellBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
									<a href="javascript:deleteCheck('${BuySellBean.id}');"><img src="jsp/images/new/btn_delete.gif"></a>
									 <%-- 삭제플러그가0일경우 비공개 버튼 표시 , 삭제플러그가3일경우 공개 버튼 표시  --%>
									<c:if test="${BuySellBean.deleteflg == '0'}">
										 <a href="javascript:deleteSignAction(<%=buySellBean.getId()%>, '3');"><img src="jsp/images/new/close_open.gif"></a> &nbsp;
									</c:if>	
									<c:if test="${BuySellBean.deleteflg == '3'}">
										 <a href="javascript:deleteSignAction(<%=buySellBean.getId()%>, '0');"><img src="jsp/images/new/open.gif"></a> &nbsp;
									</c:if>	
									<c:if test="${BuySellBean.deleteflg == '2'}">
										 <a href="javascript:deleteSignAction(<%=buySellBean.getId()%>, '3');"><img src="jsp/images/new/close_open.gif"></a> &nbsp;
									</c:if>	
									<c:if test="${BuySellBean.deleteflg == '0'}">
										 <a href="javascript:deleteSignAction(<%=buySellBean.getId()%>, '2');"><img src="jsp/images/new/btn_end.gif"></a> &nbsp;
									</c:if>	
											
								</c:if>	
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
					<!--물건사기-->
					<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
					<table id="Table_" width="950" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="67" colspan="3" align="center" background="jsp/images/new/search_content_boxbg.gif">
							<table width="96%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td align="left">${util:getNewImage(BuySellBean.update_dateTime)}
									<span class="detail-page">${BuySellBean.title}</span></td>
								<td>&nbsp;</td>
								<td align="right">등록일: <%=Util.getUpdateDateFull(buySellBean.getUpdate_dateTime())%></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="20" background="jsp/images/new/search_box_left.gif"><img src="jsp/images/new/search_box_left.gif" width="20" height="90" alt="" /></td>
						<td width="910" align="center" style="padding-top:10px;">
							<table border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td>
									<table width="860" border="0" cellpadding="0" cellspacing="1" bgcolor="#d9d9d9">
									<tr>
										<td style="padding:8px 8px 8px 8px;">
											<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d9d9d9">
											<tr>
												<td width="15%" align="left" bgcolor="#ececec" class="table-title-text"><strong>분류<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${BuySellBean.cate_name_2}"/>&nbsp; </td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>제품상태<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<!--중고품-->
									            	<c:if test="${BuySellBean.pro_status == '1'}">
									            		중고
									            	</c:if>
									            	<!--신제품-->
									            	<c:if test="${BuySellBean.pro_status == '2'}">
									            		신제품
									            	</c:if>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>희망거래가격<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<!--무료-->
									            	<c:if test="${BuySellBean.free_price == '1'}">
									            		무료
									            	</c:if>
									            	<c:if test="${BuySellBean.free_price != '1' and !empty BuySellBean.price}">
									            		<c:out value="${BuySellBean.price}"/>
									            	</c:if>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>배송방식<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<!--직거래/택배-->
									            	<c:if test="${BuySellBean.send_method == '0'}">
									            		직거래 or 택배
									            	</c:if>
									            	<!--직거래-->
									            	<c:if test="${BuySellBean.send_method == '1'}">
									            		직거래
									            	</c:if>
									            	<!--택배-->
									            	<c:if test="${BuySellBean.send_method == '2'}">
									            		택배
									            	</c:if>&nbsp;
									            </td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>희망거래장소 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${BuySellBean.sell_place}"/>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>이메일 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<a href="" onclick="mailOpenDetail('${BuySellBean.id}','${BuySellBean.user_name}'); return false;">메일보내기</a>
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>전화번호1</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${BuySellBean.tel_no1_fname}"/>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong> 전화번호2 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${BuySellBean.tel_no2_fname}"/>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>등록자 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													 <c:out value="${BuySellBean.user_name}"/>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>등록일 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<%=Util.getUpdateDateFull(buySellBean.getUpdate_dateTime())%>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>조회수<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${BuySellBean.read_count}"/>&nbsp;
												</td>
											</tr>
											</table>
										</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="30" colspan="3" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" >
									<table width="40%" border="0" cellspacing="1" cellpadding="0">
									<tr>
										<td width="3%"><img src="jsp/images/new/search_conttit_icon.gif" width="7" height="14" /></td>
										<td width="97%" class="large-text-w" style="padding-top:2px;"><strong>상세정보</strong></td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="2" colspan="3" align="left" valign="top" bgcolor="#d9d9d9"></td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">${BuySellBean.detail_info}&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							</table>
						</td>
						<td width="20" background="jsp/images/new/search_box_right.gif"><img src="jsp/images/new/search_box_right.gif" width="20" height="90" alt="" /></td>
					</tr>
					<tr>
						<td colspan="3"><img src="jsp/images/new/search_box_under.gif" width="950" height="17" alt="" /></td>
					</tr>
					</table>
					</c:if>
					<!--물건팔기-->
					<c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
					<table id="Table_" width="950" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="67" colspan="3" align="center" background="jsp/images/new/search_content_boxbg.gif">
							<table width="96%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td align="left">${util:getNewImage(BuySellBean.update_dateTime)}
									<span class="detail-page">${BuySellBean.title}</span></td>
								<td>&nbsp;</td>
								<td align="right">등록일: <%=Util.getUpdateDateFull(buySellBean.getUpdate_dateTime())%></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="20" background="jsp/images/new/search_box_left.gif"><img src="jsp/images/new/search_box_left.gif" width="20" height="90" /></td>
						<td width="910" align="center" style="padding-top:10px;">
							<table border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td valign="top">
									<table width="482" border="0" cellspacing="1" cellpadding="0">
									<tr>
										<td colspan="2" height="366" align="center">
											<img src="${BuySellBean.photo_path1}" id="disp"/>
										</td>
									</tr>
									<tr>
										<td height="6" colspan="2"></td>
									</tr>
									<tr>
										<td width="392" align="right">
											<img src="${BuySellBean.photo_path1}" width="60" height="60" style="border:1px  solid #CCCCCC;" onMouseover="setImage('<%=buySellBean.getPhoto_path1()%>')"/>&nbsp;
											<img src="${BuySellBean.photo_path2}" width="60" height="60" style="border:1px  solid #CCCCCC;" onMouseover="setImage('<%=buySellBean.getPhoto_path2()%>')"/>&nbsp;
											<img src="${BuySellBean.photo_path3}" width="60" height="60" style="border:1px  solid #CCCCCC;" onMouseover="setImage('<%=buySellBean.getPhoto_path3()%>')"/>&nbsp;
											<img src="${BuySellBean.photo_path4}" width="60" height="60" style="border:1px  solid #CCCCCC;" onMouseover="setImage('<%=buySellBean.getPhoto_path4()%>')"/>&nbsp;
											<img src="${BuySellBean.photo_path5}" width="60" height="60" style="border:1px  solid #CCCCCC;" onMouseover="setImage('<%=buySellBean.getPhoto_path5()%>')"/>
										</td>
										<td width="89" align="right" valign="top">
											<!--크게보기-->
											<a href="javascript:popup();"><img src="jsp/images/new/large_b.gif" width="61" height="16" /></a></td>
									</tr>
									</table>
								</td>
								<td width="10">&nbsp;</td>
								<td>
									<table width="400" border="0" cellpadding="0" cellspacing="1" bgcolor="#d9d9d9">
									<tr>
										<td style="padding:8px 8px 8px 8px;">
											<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#d9d9d9">
											<tr>
												<td width="30%" align="left" bgcolor="#ececec" class="table-title-text"><strong>분류</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${BuySellBean.cate_name_2}"/> </td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong> 제품상태 </strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<!--중고품-->
									            	<c:if test="${BuySellBean.pro_status == '1'}">
									            		중고
									            	</c:if>
									            	<!--신제품-->
									            	<c:if test="${BuySellBean.pro_status == '2'}">
									            		신제품
									            	</c:if>&nbsp;
									            </td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong> 판매자구분<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<!--개인회원-->
									            	<c:if test="${BuySellBean.pro_status == '1'}">
									            		개인회원
									            	</c:if>
									            	<!--업자회원-->
									            	<c:if test="${BuySellBean.pro_status == '2'}">
									            		업자회원
									            	</c:if>
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>가격 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<!--무료-->
									            	<c:if test="${BuySellBean.free_price == '1'}">
									            		무료
									            	</c:if>
									            	<c:if test="${BuySellBean.free_price != '1' and !empty BuySellBean.price}">
									            		<c:out value="${BuySellBean.price}"/>
								            			<c:if test="${empty BuySellBean.price_unit or BuySellBean.price_unit == '0'}">
								            				<c:out value="엔"/>
								            			</c:if>
								            			<c:if test="${!empty BuySellBean.price_unit and BuySellBean.price_unit == '1'}">
								            				<c:out value="원"/>
								            			</c:if>
									            	</c:if>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>배송방식 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<!--직거래/택배-->
									            	<c:if test="${BuySellBean.send_method == '0'}">
									            		직거래 or 택배
									            	</c:if>
									            	<!--직거래-->
									            	<c:if test="${BuySellBean.send_method == '1'}">
									            		직거래
									            	</c:if>
									            	<!--택배-->
									            	<c:if test="${BuySellBean.send_method == '2'}">
									            		택배
									            	</c:if><br />
									            </td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>희망거래장소 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${BuySellBean.sell_place}"/><br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>이메일</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<a href="" onclick="mailOpenDetail('${BuySellBean.id}','${BuySellBean.user_name}'); return false;">메일보내기</a>
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong> 전화번호1 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${BuySellBean.tel_no1_fname}"/>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>전화번호2 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${BuySellBean.tel_no2_fname}"/>
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>등록자 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${BuySellBean.user_name}"/>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>등록일<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<%=Util.getUpdateDateFull(buySellBean.getUpdate_dateTime())%>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>조회수<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${BuySellBean.read_count}"/>&nbsp;
												</td>
											</tr>
											</table>
										</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="30" colspan="3" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" >
									<table width="40%" border="0" cellspacing="1" cellpadding="0">
									<tr>
										<td width="3%"><img src="jsp/images/new/search_conttit_icon.gif" width="7" height="14" /></td>
										<td width="97%" class="large-text-w" style="padding-top:2px;"><strong>상세정보</strong></td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="2" colspan="3" align="left" valign="top" bgcolor="#d9d9d9"></td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">${BuySellBean.detail_info}&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							</table>
						</td>
						<td width="20" background="jsp/images/new/search_box_right.gif"><img src="jsp/images/new/search_box_right.gif" width="20" height="90" alt="" /></td>
					</tr>
					<tr>
						<td colspan="3"><img src="jsp/images/new/search_box_under.gif" width="950" height="17" alt="" /></td>
					</tr>
					</table>
					</c:if>
				</td>
			</tr>
			<tr>
				<td height="40" align="right">
					<!--물건사기-->
					<c:if test="${BuySellSearchBean.cate_code_1 == 'C10100'}">
						<!--목록버튼 -->
						<c:if test="${BuySellSearchBean.before == 'search'}">
	              			<!--ID가 없으면 내글보기표시 -->
	              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
						</c:if>	
						<c:if test="${BuySellSearchBean.before == 'search_all'}">
							<!--ID가 있으면 목록표시 -->
						 	<a href="javascript:backSearchAllPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
						</c:if>
						<c:if test="${BuySellSearchBean.before == 'mysearch'}">
							<!--ID가 있으면 목록표시 -->
						 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91"/></a>							
						</c:if>
						<c:if test="${BuySellSearchBean.before == 'my_write'}">
							<!--ID가 있으면 목록표시 -->
						 	<a href="javascript:backMyWrite(1);"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
						</c:if>
						<c:if test="${BuySellSearchBean.before == 'new_write'}">
      						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
						</c:if>							
						<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
						<c:if test="${BuySellBean.user_id == memberInfo.userid}">
							<a href="javascript:openUpdate('${BuySellBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
							<a href="javascript:deleteCheck('${BuySellBean.id},wf');"><img src="jsp/images/new/btn_delete.gif"></a>
						</c:if>	
					</c:if>
					<!--물건팔기-->
					<c:if test="${BuySellSearchBean.cate_code_1 == 'C10200'}">
						<!--목록버튼 -->
						<c:if test="${BuySellSearchBean.before == 'search'}">
	              			<!--ID가 없으면 내글보기표시 -->
	              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
						</c:if>	
						<c:if test="${BuySellSearchBean.before == 'search_all'}">
							<!--ID가 있으면 목록표시 -->
						 	<a href="javascript:backSearchAllPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
						</c:if>
						<c:if test="${BuySellSearchBean.before == 'mysearch'}">
							<!--ID가 있으면 목록표시 -->
						 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
						</c:if>
						<c:if test="${BuySellSearchBean.before == 'my_write'}">
							<!--ID가 있으면 목록표시 -->
						 	<a href="javascript:backMyWrite(1);"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
						</c:if>
						<c:if test="${BuySellSearchBean.before == 'new_write'}">
      						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
						</c:if>							
						<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
						<c:if test="${BuySellBean.user_id == memberInfo.userid}">
							<a href="javascript:openUpdate('${BuySellBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
							<a href="javascript:deleteCheck('${BuySellBean.id},wf');"><img src="jsp/images/new/btn_delete.gif"></a>
							 <%-- 삭제플러그가0일경우 비공개 버튼 표시 , 삭제플러그가3일경우 공개 버튼 표시  --%>
							<c:if test="${BuySellBean.deleteflg == '0'}">
								 <a href="javascript:deleteSignAction(<%=buySellBean.getId()%>, '3');"><img src="jsp/images/new/close_open.gif"></a> &nbsp;
							</c:if>	
							<c:if test="${BuySellBean.deleteflg == '3'}">
								 <a href="javascript:deleteSignAction(<%=buySellBean.getId()%>, '0');"><img src="jsp/images/new/open.gif"></a> &nbsp;
							</c:if>	
							<c:if test="${BuySellBean.deleteflg == '2'}">
								 <a href="javascript:deleteSignAction(<%=buySellBean.getId()%>, '3');"><img src="jsp/images/new/close_open.gif"></a> &nbsp;
							</c:if>	
							<c:if test="${BuySellBean.deleteflg == '0'}">
								 <a href="javascript:deleteSignAction(<%=buySellBean.getId()%>, '2');"><img src="jsp/images/new/btn_end.gif"></a> &nbsp;
							</c:if>	
						</c:if>	
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
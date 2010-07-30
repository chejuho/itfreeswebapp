<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>	
<%@ page import="common.bean.PageBean, store.bean.StoreBean"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ page import="buysell.bean.BuySellBean, buysell.bean.BuySellSearchBean"%>
<%@ page import="gourmet.bean.GourmetBean, gourmet.bean.GourmetSearchBean"%>
<%@ page import="job.bean.JobBean, job.bean.JobSearchBean"%>
<%@ page import="findjob.bean.FindjobBean, findjob.bean.FindjobSearchBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@page import="common.bean.MemberBean,common.bean.SearchBean"%> 
<%@page import="common.util.Util, common.util.EnDecoding"%> 
<%@page import="common.constant.Const"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%> 
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	List buyBeanList = (List) request.getAttribute("BuyBeanList");
	List sellBeanList = (List) request.getAttribute("SellBeanList");
	List storeBeanList = (List) request.getAttribute("StoreBeanList");
	List gourmetBeanList = (List) request.getAttribute("GourmetBeanList");
	List jobBeanList = (List) request.getAttribute("JobBeanList");
	List findjobBeanList = (List) request.getAttribute("FindjobBeanList");
	SearchBean searchBean = (SearchBean) request.getAttribute("SearchBean");

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
<title><c:out value="통합검색"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
	function openDetailPage(index, id) {
		if(index == 1){
			document.list.action="BuySellDetail?before=search_all&search_cate_code_1=C10100&id=" + id;
		} else if (index == 2) {
			document.list.action="BuySellDetail?before=search_all&search_cate_code_1=C10200&id=" + id;		
		} else if (index == 3) {
			document.list.action="StoreDetail?before=search_all&id=" + id;		
		} else if (index == 4) {
			document.list.action="GourmetDetail?before=search_all&id=" + id;		
		} else if (index == 5) {
			document.list.action="GourmetDetail?before=search_all&id=" + id;		
		} else if (index == 6) {								
			document.list.action="GourmetDetail?before=search_all&id=" + id;		
		} else if (index == 7) {
			document.list.action="JobDetail?before=search_all&id=" + id;		
		} else if (index == 8) {
			document.list.action="FindjobDetail?before=search_all&id=" + id;		
		}
	
	document.list.submit(); 
	return true;
	}
	
	function moreSearch(index) {
		if(index == 1){
			document.list.action="BuySellList?re=9&before=search_all&search_cate_code_1=C10100";
		} else if (index == 2) {
			document.list.action="BuySellList?re=9&before=search_all&search_cate_code_1=C10200";		
		} else if (index == 3) {
			document.list.action="StoreSearch?re=9&before=search_all";		
		} else if (index == 4) {
			document.list.action="GourmetSearch?re=9&before=search_all";		
		} else if (index == 5) {
			document.list.action="JobSearch?re=9&before=search_all";		
		} else if (index == 6) {								
			document.list.action="FindjobSearch?re=9&before=search_all";		
		}
		document.list.submit(); 
		return true;
	}

//-->
</script>
<style type="text/css">
<!--
.style5 {color: #4184a9}
.style6 {color: #2c87ba}
-->
</style>
</head>	
	<body style="margin:0 0 0 0">
	<jsp:include page="../include/top.jsp" flush="true" />
	<!-- START -->
	<tr>
		<td height="20">&nbsp;</td>
	</tr>
	<tr>
		<td>
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<form name="list" method="post" style="margin:0">
			<input type="hidden" name="all_search" value="<%=searchBean.getAll_search()%>">
			<input type="hidden" name="all_search_range" value="<%=searchBean.getAll_search_range()%>">
			<tr>
				<td height="30">&nbsp;</td>
			</tr>
			<c:choose>
				<c:when test="${empty BuyBeanList and empty SellBeanList and empty StoreBeanList 
					and empty GourmetBeanList and empty JobBeanList and empty FindjobBeanList}">
				<tr>
					<td width="100%" align="center">
					<c:out value="해당 검색 리스트가 없습니다."/>
					</td>
				</tr>
				</c:when>
				<c:otherwise>
				<!--물건사기-->
				<c:if test="${!empty BuyBeanList}">
				<tr>
					<td align="left" valign="top"><img src="jsp/images/new/5_icon.gif"  align="absmiddle"width="16" height="22" /> <span class="large-text-w style6"><strong>물건사기</strong></span></td>
				</tr>
				<tr>
					<td height="8" valign="top"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="41" colspan="8" background="jsp/images/new/5_list_bg.gif" class="search-list-tit">
								<table width="100%" border="0" cellspacing="1" cellpadding="0">
								<tr>
									<td width="5%" align="center" class="mywrite-b_it"><span class="style8 style5">번호</span></td>
									<td width="34%" align="center" class="mywrite-b_it"><span class="style8 style5"> 글제목</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5"> 가격</span></td>
									<td width="12%" align="center" class="mywrite-b_it"><span class="style8 style5"> 희망거래장소</span></td>
									<td width="11%" align="center" class="mywrite-b_it"><span class="style8 style5"> 제품상태<br />배송방식 </span></td>
									<td width="10%" align="center" class="mywrite-b_it"><span class="style8 style5">등록일 </span></td>
									<td width="12%" align="center" class="mywrite-b_it"><span class="style8 style5">등록자</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5">조회수</span></td>
								</tr>
								</table>
							</td>
						</tr>
						<!--내용표시 -->
						<c:forEach var="BuySellBean" items="${BuyBeanList}" >
						<tr>
							<!--번호-->
							<td width="5%" height="52" align="center">${BuySellBean.id}</td>
							<!--글제목-->
				            <td width="34%">
				            	<a href="javascript:openDetailPage(1, '${BuySellBean.id}');">${BuySellBean.title}${util:getNewImage(BuySellBean.update_dateTime)}</a>
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
				            <td width="12%" align="center">
				            	<span style="text-decoration: underline">${BuySellBean.user_name}</span>
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
						</table>
					</td>
				</tr>
				<tr>
					<td height="8" align="center" valign="top"></td>
				</tr>
				<tr>
					<td align="right" valign="top"><a href="javascript:moreSearch('1');"><img src="jsp/images/new/5_b1.gif" width="127" height="23" /></a></td>
				</tr>
				<tr>
					<td align="center" valign="top">&nbsp;</td>
				</tr>
				</c:if>
				<!--물건팔기-->
				<c:if test="${!empty SellBeanList}">
				<tr>
					<td align="left" valign="top"><img src="jsp/images/new/5_icon.gif"  align="absmiddle"width="16" height="22" /> <span class="large-text-w style6"><strong>물건팔기</strong></span></td>
				</tr>
				<tr>
					<td height="8" valign="top"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="41" colspan="9" background="jsp/images/new/5_list_bg.gif" class="search-list-tit">
								<table width="100%" border="0" cellspacing="1" cellpadding="0">
								<tr>
									<td width="5%" align="center" class="mywrite-b_it"><span class="style8 style5">번호</span></td>
									<td width="6%" align="center" class="mywrite-b_it"><span class="style8 style5">이미지</span></td>
									<td width="28%" align="center" class="mywrite-b_it"><span class="style8 style5">글제목</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5">가격</span></td>
									<td width="12%" align="center" class="mywrite-b_it"><span class="style8 style5"> 희망거래장소</span></td>
									<td width="11%" align="center" class="mywrite-b_it"><span class="style8 style5">제품상태<br />배송방식</span></td>
									<td width="10%" align="center" class="mywrite-b_it"><span class="style8 style5">등록일</span></td>
									<td width="12%" align="center" class="mywrite-b_it"><span class="style8 style5">등록자</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5">조회수</span></td>
									
								</tr>
								</table>
							</td>
						</tr>
						<!--내용표시 -->
						<c:forEach var="BuySellBean" items="${SellBeanList}" >
						<tr>
							<!--번호-->
							<td width="5%" height="52" align="center">${BuySellBean.id}</td>
							<!--이미지-->
							<td width="6%" align="center">
								<a href="javascript:openDetailPage(2, '${BuySellBean.id}');"><img src="${BuySellBean.thumbNail_path}" /></a></td>
							<!--글제목-->
				            <td width="28%">
				            	<a href="javascript:openDetailPage(2, '${BuySellBean.id}');">${BuySellBean.title}${util:getNewImage(BuySellBean.update_dateTime)}</a>
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
				            <td width="12%" align="center">
				            	<span style="text-decoration: underline">${BuySellBean.user_name}</span>
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
						</table>
					</td>
				</tr>
				<tr>
					<td height="8" align="center" valign="top"></td>
				</tr>
				<tr>
					<td align="right" valign="top"><a href="javascript:moreSearch('2');"><img src="jsp/images/new/5_b2.gif" width="127" height="23" /></a></td>
				</tr>
				<tr>
					<td align="center" valign="top">&nbsp;</td>
				</tr>
				</c:if>
				
				<!--업체찾기-->
				<c:if test="${!empty StoreBeanList}">
				<tr>
					<td align="left" valign="top"><img src="jsp/images/new/5_icon.gif"  align="absmiddle"width="16" height="22" /> <span class="large-text-w style6"><strong>업체찾기</strong></span></td>
				</tr>
				<tr>
					<td height="8" valign="top"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="41" colspan="7" background="jsp/images/new/5_list_bg.gif" class="search-list-tit">
								<table width="100%" border="0" cellspacing="1" cellpadding="0">
								<tr>
									<td width="6%" align="center" class="mywrite-b_it"><span class="style8 style5">번호</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5"> 이미지</span></td>
									<td width="39%" align="center" class="mywrite-b_it"><span class="style8 style5"> 업체명</span></td>
									<td width="12%" align="center" class="mywrite-b_it"><span class="style8 style5"> 전화번호</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5"> 홈페이지 </span></td>
									<td width="17%" align="center" class="mywrite-b_it"><span class="style8 style5">지역/노선정보 </span></td>
									<td width="10%" align="center" class="mywrite-b_it"><span class="style8 style5">등록일</span></td>
									
								</tr>
								</table>
							</td>
						</tr>
						<!--내용표시 -->
						<c:forEach var="StoreBean" items="${StoreBeanList}" >
						<tr>
							 <!--번호 -->
							 <td width="6%" height="52" align="center">
							 		${StoreBean.id}
							 </td>
							 <!--이미지 -->
				             <td width="8%" align="center">
				             	<a href="javascript:openDetailPage(3, '${StoreBean.id}');"><img src="${StoreBean.thumbNail_path}" ></a>
				             </td>
				              <!--업체명 -->
				             <td width="39%" valign="center">
				             	<a href="javascript:openDetailPage(3, '${StoreBean.id}');"><c:out value="${StoreBean.store_full_name}"/>${util:getNewImage(StoreBean.update_dateTime)}</a>
								&nbsp;
				             </td>
				              <!--전화번호 -->
				             <td width="12%" align="center">
				             	<c:out value="${StoreBean.tel_no1_fname}"/>
				             	&nbsp;
				             </td>
				              <!--홈페이지 -->
				             <td width="8%" align="center">
				             	<c:if test="${!empty StoreBean.url}">
									<a href="http://${StoreBean.url}" target="_blank"><img src="jsp/images/new/homepage_b.gif" width="14" height="14"></a>
								</c:if>	
								<c:if test="${empty StoreBean.url}">
									&nbsp;
								</c:if>	
				             </td>
				              <!--지역/노선정보 -->
				             <td width="17%" align="center">
				             	<c:out value="${StoreBean.area_name_1}"/>
				             	<c:out value="${StoreBean.area_name_2}"/><br>
				             	<c:out value="${StoreBean.lineInfo}"/>
				             	&nbsp;
				             </td>
				              <!--등록일 -->
				             <td width="10%" align="center">
				             	<c:out value="${StoreBean.update_date}"/>
				             	&nbsp;
				             </td>
						</tr>
						 <tr align="center" bgcolor="#CCCCCC">
    						<td height="1" colspan="7" ></td>
 						 </tr>
						</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td height="8" align="center" valign="top"></td>
				</tr>
				<tr>
					<td align="right" valign="top"><a href="javascript:moreSearch('3');"><img src="jsp/images/new/5_b3.gif" width="127" height="23" /></a></td>
				</tr>
				<tr>
					<td align="center" valign="top">&nbsp;</td>
				</tr>
				</c:if>
				
				<!--음식점-->
				<c:if test="${!empty GourmetBeanList}">
				<tr>
					<td align="left" valign="top"><img src="jsp/images/new/5_icon.gif"  align="absmiddle"width="16" height="22" /> <span class="large-text-w style6"><strong>음식점</strong></span></td>
				</tr>
				<tr>
					<td height="8" valign="top"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="41" colspan="7" background="jsp/images/new/5_list_bg.gif" class="search-list-tit">
								<table width="100%" border="0" cellspacing="1" cellpadding="0">
								<tr>
									<td width="6%" align="center" class="mywrite-b_it"><span class="style8 style5">번호</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5"> 이미지</span></td>
									<td width="39%" align="center" class="mywrite-b_it"><span class="style8 style5">가게명</span></td>
									<td width="12%" align="center" class="mywrite-b_it"><span class="style8 style5">전화번호</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5">홈페이지</span></td>
									<td width="17%" align="center" class="mywrite-b_it"><span class="style8 style5">지역/노선정보</span></td>
									<td width="10%" align="center" class="mywrite-b_it"><span class="style8 style5">등록일</span></td>
									
								</tr>
								</table>
							</td>
						</tr>
						<!--내용표시 -->
						<c:forEach var="GourmetBean" items="${GourmetBeanList}" >
						<tr>
							 <!--번호 -->
							 <td width="6%" height="52" align="center">
							 		${GourmetBean.id}
							 </td>
							 <!--이미지 -->
				             <td width="8%" align="center">
				             	<a href="javascript:openDetailPage(4, '${GourmetBean.id}');"><img src="${GourmetBean.thumbNail_path}" ></a>
				             </td>
				              <!--가게명 -->
				             <td width="39%" valign="center">
				             	<a href="javascript:openDetailPage(4, '${GourmetBean.id}');"><c:out value="${GourmetBean.store_full_name}"/>${util:getNewImage(GourmetBean.update_dateTime)}</a>
								&nbsp;
				             </td>
				              <!--전화번호 -->
				             <td width="12%" align="center">
				             	<c:out value="${GourmetBean.tel_no1_fname}"/>
				             	&nbsp;
				             </td>
				              <!--홈페이지 -->
				             <td width="8%" align="center">
				             	<c:if test="${!empty GourmetBean.url}">
									<a href="http://${GourmetBean.url}" target="_blank"><img src="jsp/images/new/homepage_b.gif" width="14" height="14"></a>
								</c:if>	
								<c:if test="${empty GourmetBean.url}">
									&nbsp;
								</c:if>	
				             </td>
				              <!--지역/노선정보 -->
				             <td width="17%" align="center">
				             	<c:out value="${GourmetBean.area_name_1}"/>
				             	<c:out value="${GourmetBean.area_name_2}"/><br>
				             	<c:out value="${GourmetBean.lineInfo}"/>
				             	&nbsp;
				             </td>
				              <!--등록일 -->
				             <td width="10%" align="center">
				             	<c:out value="${GourmetBean.update_date}"/>
				             	&nbsp;
				             </td>
						</tr>
						 <tr align="center" bgcolor="#CCCCCC">
    						<td height="1" colspan="7" ></td>
 						 </tr>
						</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td height="8" align="center" valign="top"></td>
				</tr>
				<tr>
					<td align="right" valign="top"><a href="javascript:moreSearch('4');"><img src="jsp/images/new/5_b4.gif"/></a></td>
				</tr>
				<tr>
					<td align="center" valign="top">&nbsp;</td>
				</tr>
				</c:if>
				
				<!--구인-->
				<c:if test="${!empty JobBeanList}">
				<tr>
					<td align="left" valign="top"><img src="jsp/images/new/5_icon.gif"  align="absmiddle"width="16" height="22" /> <span class="large-text-w style6"><strong>구인</strong></span></td>
				</tr>
				<tr>
					<td height="8" valign="top"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="41" colspan="10" background="jsp/images/new/5_list_bg.gif" class="search-list-tit">
								<table width="100%" border="0" cellspacing="1" cellpadding="0">
								<tr>
									<td width="6%" align="center" class="mywrite-b_it"><span class="style8 style5">번호</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5">이미지</span></td>
									<td width="27%" align="center" class="mywrite-b_it"><span class="style8 style5">회사명</span></td>
									<td width="7%" align="center" class="mywrite-b_it"><span class="style8 style5">고용형태</span></td>																		
									<td width="13%" align="center" class="mywrite-b_it"><span class="style8 style5">업종</span></td>									
									<td width="5%" align="center" class="mywrite-b_it"><span class="style8 style5">성별</span></td>																		
									<td width="16%" align="center" class="mywrite-b_it"><span class="style8 style5">급여조건<br>/근무시간</span></td>
									<td width="7%" align="center" class="mywrite-b_it"><span class="style8 style5">등록자</span></td>
									<td width="6%" align="center" class="mywrite-b_it"><span class="style8 style5">등록일</span></td>
									<td width="5%" align="center" class="mywrite-b_it"><span class="style8 style5">조회수</span></td>
									
								</tr>
								</table>
							</td>
						</tr>
						<!--내용표시 -->
						<c:forEach var="JobBean" items="${JobBeanList}" >
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								${JobBean.id}	
							</td>
							 <!--이미지 -->
				             <td width="8%" align="center">
				             	<a href="javascript:openDetailPage(7, '${JobBean.id}');"><img src="${JobBean.thumbNail_path}" ></a>
				             </td>
				             <!--회사명 -->
							<td width="27%">
								<a href="javascript:openDetailPage(7, '${JobBean.id}');">
									<c:out value="${JobBean.company_name_k}"/><br><c:out value="${JobBean.title}"/>${util:getNewImage(JobBean.update_dateTime)}</a>&nbsp;
							</td>
				             <!--고용형태 -->							
							<td width="7%" align="center">
								<c:if test="${JobBean.cate_code_1 == 'C10100'}">
									<img src="jsp/images/new/job_sale_icon.gif" align="middle">
								</c:if>	
								<c:if test="${JobBean.cate_code_1 == 'C10200'}">
									<img src="jsp/images/new/job_alba_icon.gif" align="middle">
								</c:if>&nbsp;
							</td>
				             <!--업종 -->							
							<td width="13%" align="center">
								<c:out value="${JobBean.cate_name_2}"/>	
							</td>
				             <!--성별 -->							
							<td width="5%" align="center">
								<c:if test="${JobBean.sex == '0'}">
									<img src="jsp/images/new/job_man_icon.gif" align="middle"><img src="jsp/images/new/job_woman_icon.gif" align="middle">
								</c:if>	
								<c:if test="${JobBean.sex == '1'}">
									<img src="jsp/images/new/job_man_icon.gif" align="middle">
								</c:if>
								<c:if test="${JobBean.sex == '2'}">
									<img src="jsp/images/new/job_woman_icon.gif" align="middle">
								</c:if>&nbsp;
							</td>
				             <!--급여조건/근무시간 -->							
							<td width="16%" align="center">
								<c:out value="${JobBean.pay}"/><br><c:out value="${JobBean.work_time}"/>&nbsp;</td>
							 <!--등록자 -->							
							<td width="7%" align="center">
								<span style="text-decoration: underline">${JobBean.user_name}</span>&nbsp;
							</td>
							 <!--등록일 -->							
							<td width="6%" align="center">
								<c:out value="${JobBean.update_date}"/>&nbsp;</td>
							 <!--조회수 -->							
							<td width="5%" align="center">
								<c:out value="${JobBean.read_count}"/>&nbsp;</td>
						</tr>
						<tr align="center" bgcolor="#CCCCCC">
							<td height="1" colspan="10" ></td>
						</tr>
						</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td height="8" align="center" valign="top"></td>
				</tr>
				<tr>
					<td align="right" valign="top"><a href="javascript:moreSearch('5');"><img src="jsp/images/new/5_b8.gif"/></a></td>
				</tr>
				<tr>
					<td align="center" valign="top">&nbsp;</td>
				</tr>
				</c:if>
				
				<!--구직-->
				<c:if test="${!empty FindjobBeanList}">
				<tr>
					<td align="left" valign="top"><img src="jsp/images/new/5_icon.gif"  align="absmiddle"width="16" height="22" /> <span class="large-text-w style6"><strong>구직</strong></span></td>
				</tr>
				<tr>
					<td height="8" valign="top"></td>
				</tr>
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="41" colspan="10" background="jsp/images/new/5_list_bg.gif" class="search-list-tit">
								<table width="100%" border="0" cellspacing="1" cellpadding="0">
								<tr>
									<td width="6%" align="center" class="mywrite-b_it"><span class="style8 style5">번호</span></td>
									<td width="50%" align="center" class="mywrite-b_it"><span class="style8 style5">글제목</span></td>
									<td width="10%" align="center" class="mywrite-b_it"><span class="style8 style5">희망고용형태</span></td>
									<td width="8%" align="center" class="mywrite-b_it"><span class="style8 style5">출생년도</span></td>
									<td width="7%" align="center" class="mywrite-b_it"><span class="style8 style5">성별</span></td>
									<td width="7%" align="center" class="mywrite-b_it"><span class="style8 style5">등록자</span></td>
									<td width="7%" align="center" class="mywrite-b_it"><span class="style8 style5">등록일</span></td>
									<td width="5%" align="center" class="mywrite-b_it"><span class="style8 style5">조회수</span></td>
									
								</tr>
								</table>
							</td>
						</tr>
						<!--내용표시 -->
						<c:forEach var="FindjobBean" items="${FindjobBeanList}" >
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								${FindjobBean.id}
							</td>
							<!--글제목 -->
							<td width="50%">
								<a href="javascript:openDetailPage(8, '${FindjobBean.id}');">
									<c:out value="${FindjobBean.title}"/><br><c:out value="${FindjobBean.title}"/>${util:getNewImage(FindjobBean.update_dateTime)}</a>&nbsp;</td>
							<!--희망고용형태 -->
							<td width="10%" align="center">
								<c:if test="${FindjobBean.work_sort == '1'}">
									<img src="jsp/images/new/job_sale_icon.gif" align="middle">
								</c:if>	
								<c:if test="${FindjobBean.work_sort == '2'}">
									<img src="jsp/images/new/job_alba_icon.gif" align="middle">
								</c:if>
								<c:if test="${FindjobBean.work_sort != '1' and FindjobBean.work_sort != '2'}">
									<img src="jsp/images/new/job_sale_icon.gif" align="middle"><img src="jsp/images/new/job_alba_icon.gif" align="middle">
								</c:if>
							</td>
							<!--출생년도 -->
							<td width="8%" align="center">
								<c:out value="${FindjobBean.birthday}"/>
								&nbsp;
							</td>
							<!--성별 -->
							<td width="7%" align="center">
								<c:if test="${FindjobBean.sex == '1'}">
									<img src="jsp/images/new/job_man_icon.gif" align="middle">
								</c:if>	
								<c:if test="${FindjobBean.sex == '2'}">
									<img src="jsp/images/new/job_woman_icon.gif" align="middle">
								</c:if>&nbsp;
							</td>
							<!--등록자 -->
							<td width="7%" align="center">
								<span style="text-decoration: underline">${FindjobBean.user_name}</span>&nbsp;
							</td>
							<!--등록일 -->
							<td width="7%" align="center">
								<c:out value="${FindjobBean.update_date}"/>&nbsp;</td>
							<!--조회수 -->
							<td width="5%" align="center"><c:out value="${FindjobBean.read_count}"/>&nbsp;</td>							
						</tr>
						<tr align="center" bgcolor="#CCCCCC">
							<td height="1" colspan="8" ></td>
						</tr>
						</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td height="8" align="center" valign="top"></td>
				</tr>
				<tr>
					<td align="right" valign="top"><a href="javascript:moreSearch('6');"><img src="jsp/images/new/5_b9.gif"/></a></td>
				</tr>
				<tr>
					<td align="center" valign="top">&nbsp;</td>
				</tr>
				</c:if>
				</c:otherwise>
			</c:choose>
			<!--리스트 표시 끝 -->			
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
			</form>
			</table>
		</td>
	</tr>
  	<!-- END -->
  	<tr>
		<td height="50">&nbsp;</td>
	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
</body>
</html>
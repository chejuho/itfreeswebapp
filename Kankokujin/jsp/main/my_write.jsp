<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>	
<%@ page import="common.bean.PageBean, store.bean.StoreBean"%>
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
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	String sort = (String)Util.changeNullStr(request.getAttribute("sort"));
	MemberBean member = new MemberBean();
	member.setUserid("-");
	if(session.getAttribute("memberInfo")!=null){
		member = (MemberBean) session.getAttribute("memberInfo");	
	}
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title><c:out value="메뉴별 내가 쓴글"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function reloadPage(obj) {
		
		var sort = document.list.sort.value;
		document.list.action="MyWrite?pageNum="+obj+"&sort="+sort;
		document.list.submit(); 
		return true;
	}	
	function changeSort(obj) {
		
		document.list.action="MyWrite?sort="+obj;
		document.list.submit(); 
		return true;
	}	
	function openDetailPage(obj, id) {
		if(obj == 1){
			document.list.action="BuySellDetail?id=" +id +"&before=my_write&search_cate_code_1=C10100";
		} else if (obj == 2){
			document.list.action="BuySellDetail?id=" +id +"&before=my_write&search_cate_code_1=C10200";
		} else if (obj == 3){
			document.list.action="StoreDetail?before=my_write&id="+id;
		} else if (obj == 4){
			document.list.action="GourmetDetail?id=" +id + "&before=my_write";
		} else if (obj == 5){
			document.list.action="RoomSellDetail?id=" +id +"&before=my_write";
		} else if (obj == 6){
			document.list.action="HouseSellDetail?id=" +id + "&before=my_write";
		} else if (obj == 7){
			document.list.action="JobDetail?id=" +id +"&before=my_write";
		} else if (obj == 8){
			document.list.action="FindjobDetail?id=" +id +"&before=my_write";
		}
		
		document.list.submit(); 
		return true;
	}		
</script>	
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
			<input type="hidden" name="sort" value="${sort}">     
			<tr>
				<td height="20"><img src="jsp/images/new/mywrite_tit.gif" width="950" height="82" /></td>
			</tr>
			<tr>
				<td height="20">&nbsp;</td>
			</tr>
			<tr>
				<td>
					<!-- 탑메뉴START -->
					<c:choose>
						<c:when test="${sort == '2'}">
							<table width="950"  height="37" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/mywrite_stit_b2.gif"></c:when>
						<c:when test="${sort == '3'}">
							<table width="950"  height="37" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/mywrite_stit_b3.gif"></c:when>
						<c:when test="${sort == '4'}">
							<table width="950"  height="37" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/mywrite_stit_b4.gif"></c:when>
						<c:when test="${sort == '5'}">
							<table width="950"  height="37" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/mywrite_stit_b5.gif"></c:when>
						<c:when test="${sort == '6'}">
							<table width="950"  height="37" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/mywrite_stit_b6.gif"></c:when>
						<c:when test="${sort == '7'}">
							<table width="950"  height="37" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/mywrite_stit_b7.gif"></c:when>
						<c:when test="${sort == '8'}">
							<table width="950"  height="37" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/mywrite_stit_b8.gif"></c:when>
						<c:when test="${sort == '9'}">
							<table width="950"  height="37" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/mywrite_stit_b9.gif"></c:when>
						<c:otherwise>
							<table width="950"  height="37" border="0" cellpadding="0" cellspacing="0" background="jsp/images/new/mywrite_stit_b1.gif">
						</c:otherwise>
					</c:choose>
					<tr>
						<!-- 물건사기 -->
						<c:choose>
							<c:when test="${empty sort or sort == '1'}">
								<td width="106" align="center">
									<span class="mywrite_m_tit">물건사기(<c:out value="${maxInfoCount1}" />)</span></td></c:when>
							<c:otherwise>
								<td width="96" align="center"style="padding-top:5px;">
								<a href="javascript:changeSort(1);" class="mywirte-link">물건사기(<c:out value="${maxInfoCount1}" />)</a></td>
							</c:otherwise>
						</c:choose>
						<!-- 물건팔기 -->
						<c:choose>
							<c:when test="${sort == '2'}">
								<td width="106" align="center" >
									<span class="mywrite_m_tit">물건팔기(<c:out value="${maxInfoCount2}" />)</span></td></c:when>
							<c:otherwise>
								<td width="96" align="center" style="padding-top:5px;">
									<a href="javascript:changeSort(2);" class="mywirte-link">물건팔기(<c:out value="${maxInfoCount2}" />)</a></td>
							</c:otherwise>
						</c:choose>
						<!-- 업체찾기 -->
						<c:choose>
							<c:when test="${sort == '3'}">
								<td width="106" align="center" >
									<span class="mywrite_m_tit">업체찾기(<c:out value="${maxInfoCount3}" />)</span></td></c:when>
							<c:otherwise>
								<td width="97" align="center" style="padding-top:5px;">
									<a href="javascript:changeSort(3);" class="mywirte-link">업체찾기(<c:out value="${maxInfoCount3}" />)</a></td>
							</c:otherwise>
						</c:choose>
						<!-- 음식점 -->
						<c:choose>
							<c:when test="${sort == '4'}">
								<td width="95" align="center">
									<span class="mywrite_m_tit">음식점(<c:out value="${maxInfoCount4}" />)</span></td></c:when>
							<c:otherwise>
								<td width="86" align="center" style="padding-top:5px;">
									<a href="javascript:changeSort(4);" class="mywirte-link">음식점(<c:out value="${maxInfoCount4}" />)</a></td>
							</c:otherwise>
						</c:choose>
						<!-- 호텔/민박 -->
						<c:choose>
							<c:when test="${sort == '5'}">
								<td width="111" align="center" >
									<span class="mywrite_m_tit">호텔/민박(<c:out value="${maxInfoCount5}" />)</span></td></c:when>
							<c:otherwise>
								<td width="103" align="center" style="padding-top:5px;">
									<a href="javascript:changeSort(5);" class="mywirte-link">호텔/민박(<c:out value="${maxInfoCount5}" />)</a></td>
							</c:otherwise>
						</c:choose>
						<!-- 기숙사/룸메이트 -->
						<c:choose>
							<c:when test="${sort == '6'}">
								<td width="147" align="center" >
									<span class="mywrite_m_tit">기숙사/룸메이트(<c:out value="${maxInfoCount6}" />)</span></td></c:when>
							<c:otherwise>
								<td width="138" align="center" style="padding-top:5px;">
									<a href="javascript:changeSort(6);" class="mywirte-link">기숙사/룸메이트(<c:out value="${maxInfoCount6}" />)</a></td>
							</c:otherwise>
							</c:choose>
						<!-- 부동산 -->
						<c:choose>
							<c:when test="${sort == '7'}">
								<td width="94" align="center" >
									<span class="mywrite_m_tit">부동산(<c:out value="${maxInfoCount7}" />)</span></td></c:when>
							<c:otherwise>
								<td width="85" align="center" style="padding-top:5px;">
									<a href="javascript:changeSort(7);" class="mywirte-link">부동산(<c:out value="${maxInfoCount7}" />)</a></td>
							</c:otherwise>
						</c:choose>
						<!-- 구인 -->
						<c:choose>
							<c:when test="${sort == '8'}">
								<td width="81" align="center" >
									<span class="mywrite_m_tit">구인(<c:out value="${maxInfoCount8}" />)</span></td></c:when>
							<c:otherwise>
								<td width="72" align="center" style="padding-top:5px;">
									<a href="javascript:changeSort(8);" class="mywirte-link">구인(<c:out value="${maxInfoCount8}" />)</a></td>
							</c:otherwise>
						</c:choose>
						<!-- 구직 -->
						<c:choose>
							<c:when test="${sort == '9'}">
								<td width="80" align="center" >
									<span class="mywrite_m_tit">구직(<c:out value="${maxInfoCount9}" />)</span></td></c:when>
							<c:otherwise>
								<td width="72" align="center" style="padding-top:5px;">
									<a href="javascript:changeSort(9);" class="mywirte-link">구직(<c:out value="${maxInfoCount9}" />)</a></td></c:otherwise>
						</c:choose>
						<td width="95">&nbsp;</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="30">&nbsp;</td>
			</tr>
			<!-- 각메뉴별 리스트 출력 -->
			<tr>
				<td>
					<table width="50%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="4%" align="left"><img src="jsp/images/new/mywrite_icon1.gif" align="absmiddle" width="12" height="18" /></td>
						<td width="96%" align="left" style="padding-top:2px;">
							<c:if test="${empty sort or sort == '1'}">
							<span class="mywrite-stit">물건사기</span>
							</c:if>
							<c:if test="${sort == '2'}">
							<span class="mywrite-stit">물건팔기</span>
							</c:if>
							<c:if test="${sort == '3'}">
							<span class="mywrite-stit">업체찾기</span>
							</c:if>
							<c:if test="${sort == '4'}">
							<span class="mywrite-stit">음식점</span>
							</c:if>
							<c:if test="${sort == '5'}">
							<span class="mywrite-stit">호텔/민박</span>
							</c:if>
							<c:if test="${sort == '6'}">
							<span class="mywrite-stit">기숙사/룸메이트</span>
							</c:if>
							<c:if test="${sort == '7'}">
							<span class="mywrite-stit">부동산</span>
							</c:if>
							<c:if test="${sort == '8'}">
							<span class="mywrite-stit">구인</span>
							</c:if>
							<c:if test="${sort == '9'}">
							<span class="mywrite-stit">구직</span>
							</c:if>
							
						</td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="12"></td>
			</tr>
			<!--리스트 표시 시작 -->
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<!--물건사기-->
					<c:if test="${empty sort or sort == '1'}">
					<tr>
						<td height="41" colspan="8" background="jsp/images/new/mywrite_b_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="5%" align="center" class="mywrite-b_it"><span class="style8">번호</span></td>
				                <td width="34%" align="center" class="mywrite-b_it"><span class="style8">글제목</span></td>
				                <td width="8%" align="center" class="mywrite-b_it"><span class="style8">가격</span></td>
				                <td width="12%" align="center" class="mywrite-b_it"><span class="style8">희망거래장소</span></td>
				                <td width="11%" align="center" class="mywrite-b_it"><span class="style8">제품상태<br />배송방식</span></td>
				                <td width="10%" align="center" class="mywrite-b_it"><span class="style8">등록일</span></td>
				                <td width="12%" align="center" class="mywrite-b_it"><span class="style8">등록자</span></td>
				                <td width="8%" align="center" class="mywrite-b_it"><span class="style8">조회수</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
						<c:when test="${!empty BuyBeanList}">
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
					<!--물건팔기-->
					<c:if test="${sort == '2'}">
					<tr>
						<td height="41" colspan="9" background="jsp/images/new/mywrite_b_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="5%" align="center" class="mywrite-b_it"><span class="style8">번호</span></td>
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">이미지</span></td>
								<td width="28%" align="center" class="mywrite-b_it"><span class="style8">글제목</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">가격</span></td>
								<td width="12%" align="center" class="mywrite-b_it"><span class="style8"> 희망거래장소</span></td>
								<td width="11%" align="center" class="mywrite-b_it"><span class="style8">제품상태<br />배송방식</span></td>
								<td width="10%" align="center" class="mywrite-b_it"><span class="style8">등록일</span></td>
								<td width="12%" align="center" class="mywrite-b_it"><span class="style8">등록자</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">조회수</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
						<c:when test="${!empty SellBeanList}">
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
					<!--업체찾기-->
					<c:if test="${sort == '3'}">
					<tr>
						<td height="41" colspan="7" background="jsp/images/new/mywrite_b_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">번호</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8"> 이미지</span></td>
								<td width="39%" align="center" class="mywrite-b_it"><span class="style8"> 업체명</span></td>
								<td width="12%" align="center" class="mywrite-b_it"><span class="style8"> 전화번호</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8"> 홈페이지 </span></td>
								<td width="17%" align="center" class="mywrite-b_it"><span class="style8">지역/노선정보 </span></td>
								<td width="10%" align="center" class="mywrite-b_it"><span class="style8">등록일</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
					<c:when test="${!empty StoreBeanList}">
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
					<!--음식점-->
					<c:if test="${sort == '4'}">
					<tr>
						<td height="41" colspan="7" background="jsp/images/new/mywrite_b_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">번호</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8"> 이미지</span></td>
								<td width="39%" align="center" class="mywrite-b_it"><span class="style8">가게명</span></td>
								<td width="12%" align="center" class="mywrite-b_it"><span class="style8">전화번호</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">홈페이지</span></td>
								<td width="17%" align="center" class="mywrite-b_it"><span class="style8">지역/노선정보</span></td>
								<td width="10%" align="center" class="mywrite-b_it"><span class="style8">등록일</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
					<c:when test="${!empty GourmetBeanList}">
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
					<!--호텔/민박-->
					<c:if test="${sort == '5'}">
					<tr>
						<td height="41" colspan="9" background="jsp/images/new/mywrite_b_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">번호</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">이미지</span></td>
								<td width="28%" align="center" class="mywrite-b_it"><span class="style8">글제목/방물건명</span></td>
								<td width="9%" align="center" class="mywrite-b_it"><span class="style8">종별</span></td>
								<td width="20%" align="center" class="mywrite-b_it"><span class="style8">지역/노선정보</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">요금</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">등록자</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">등록일</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">조회수</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
					<c:when test="${!empty RoomBean1List}">
						<c:forEach var="RoomBean" items="${RoomBean1List}" >
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								${RoomBean.id}&nbsp;
							</td>
							<!--이미지 -->
							<td width="8%" align="center">
								<a href="javascript:openDetailPage(5, '${RoomBean.id}');"><img src="${RoomBean.thumbNail_path}" ></a>
								&nbsp;
							</td>
							<!--글제목/방물건명 -->
							<td width="28%">
								<a href="javascript:openDetailPage(5, '${RoomBean.id}');">
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
								<c:if test="${!empty RoomBean.room_fee and RoomBean.room_fee != '0'}">엔
								</c:if>&nbsp;
							</td>
							<!--등록자 -->
							<td width="7%" align="center">
								<span style="text-decoration: underline">${RoomBean.user_name}</span>&nbsp;
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
					</c:if>
					<!--기숙사/룸메이트-->
					<c:if test="${sort == '6'}">
					<tr>
						<td height="41" colspan="9" background="jsp/images/new/mywrite_b_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">번호</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">이미지</span></td>
								<td width="28%" align="center" class="mywrite-b_it"><span class="style8">글제목/방물건명</span></td>
								<td width="9%" align="center" class="mywrite-b_it"><span class="style8">종별</span></td>
								<td width="20%" align="center" class="mywrite-b_it"><span class="style8">지역/노선정보</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">야칭</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">등록자</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">등록일</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">조회수</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
					<c:when test="${!empty RoomBean2List}">
						<c:forEach var="RoomBean" items="${RoomBean2List}" >
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								${RoomBean.id}&nbsp;
							</td>
							<!--이미지 -->
							<td width="8%" align="center">
								<a href="javascript:openDetailPage(5, '${RoomBean.id}');"><img src="${RoomBean.thumbNail_path}" ></a>
								&nbsp;
							</td>
							<!--글제목/방물건명 -->
							<td width="28%">
								<a href="javascript:openDetailPage(5, '${RoomBean.id}');">
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
								<c:if test="${!empty RoomBean.room_fee and RoomBean.room_fee != '0'}">만엔</c:if>&nbsp;
							</td>
							<!--등록자 -->
							<td width="7%" align="center">
								<span style="text-decoration: underline">${RoomBean.user_name}</span>&nbsp;
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
					</c:if>
					<!--부동산-->
					<c:if test="${sort == '7'}">
					<tr>
						<td height="41" colspan="10" background="jsp/images/new/mywrite_b_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>								
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">번호</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">이미지</span></td>
								<td width="28%" align="center" class="mywrite-b_it"><span class="style8">글제목</span></td>
								<td width="16%" align="center" class="mywrite-b_it"><span class="style8">지역</span><br><span class="style8">노선정보</span></td>
								<td width="5%" align="center" class="mywrite-b_it"><span class="style8">도보</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">야찡</span><br><span class="style8">/관리비</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">시끼낑</span><br><span class="style8">/레이킹</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">보증금</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">마도리</span><br><span class="style8">/전용면적</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">건물종류</span><br><span class="style8">/건축년도</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
					<c:when test="${!empty HouseBeanList}">
						<c:forEach var="HouseBean" items="${HouseBeanList}" >
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								${HouseBean.id}&nbsp;
							</td>
							<!--이미지 -->
							<td width="8%" align="center">
								<a href="javascript:openDetailPage(6, '${HouseBean.id}');"><img src="${HouseBean.thumbNail_path}" ></a>
								&nbsp;
							</td>
							<!--글제목 -->
							<td width="28%">
								<a href="javascript:openDetailPage(6, '${HouseBean.id}');">
									${HouseBean.title}${util:getNewImage(HouseBean.update_dateTime)}<br><c:out value="${HouseBean.title}"/></a>&nbsp;
							</td>
							<!--지역/노선정보 -->
							<td width="16%" align="center">
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
							<!--시끼낑/레이킹-->
							<td width="7%" align="center">
								<c:if test="${!empty HouseBean.deposit and HouseBean.deposit != '0'}">
									<c:out value="${HouseBean.deposit}개월분"/><br>&nbsp;&nbsp;<c:out value="${HouseBean.reikin}개월분"/>
								</c:if>&nbsp;
							</td>
							<!--보증금 -->
							<td width="7%" align="center">
								<c:if test="${!empty HouseBean.guaranty_money and HouseBean.guaranty_money != '0'}">
									<c:out value="${HouseBean.guaranty_money}개월분"/>
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
					</c:if>
					<!--구인-->
					<c:if test="${sort == '8'}">
					<tr>
						<td height="41" colspan="10" background="jsp/images/new/mywrite_b_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>								
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">번호</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">이미지</span></td>
								<td width="28%" align="center" class="mywrite-b_it"><span class="style8">글제목</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">고용형태</span></td>																		
								<td width="13%" align="center" class="mywrite-b_it"><span class="style8">회사명<br>/업종</span></td>									
								<td width="5%" align="center" class="mywrite-b_it"><span class="style8">성별</span></td>																		
								<td width="16%" align="center" class="mywrite-b_it"><span class="style8">급여조건<br>/근무시간</span></td>
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">등록자</span></td>
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">등록일</span></td>
								<td width="5%" align="center" class="mywrite-b_it"><span class="style8">조회수</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
					<c:when test="${!empty JobBeanList}">
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
				             <!--글제목 -->
							<td width="28%">
								<a href="javascript:openDetailPage(7, '${JobBean.id}');">
									<c:out value="${JobBean.title}"/>${util:getNewImage(JobBean.update_dateTime)}</a>&nbsp;
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
				            <!--회사명/업종 -->								
							<td width="13%" align="center">
								<c:out value="${JobBean.company_name_k}"/><br>
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
							<td width="6%" align="center">
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
					<!--구직-->
					<c:if test="${sort == '9'}">
					<tr>
						<td height="41" colspan="8" background="jsp/images/new/mywrite_b_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>								
								<td width="6%" align="center" class="mywrite-b_it"><span class="style8">번호</span></td>
								<td width="50%" align="center" class="mywrite-b_it"><span class="style8">글제목</span></td>
								<td width="10%" align="center" class="mywrite-b_it"><span class="style8">희망고용형태</span></td>
								<td width="8%" align="center" class="mywrite-b_it"><span class="style8">출생년도</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">성별</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">등록자</span></td>
								<td width="7%" align="center" class="mywrite-b_it"><span class="style8">등록일</span></td>
								<td width="5%" align="center" class="mywrite-b_it"><span class="style8">조회수</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--내용표시 -->
					<c:choose>
					<c:when test="${!empty FindjobBeanList}">
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
					</table>
				</td>
			</tr>
			<!--리스트 표시 끝 -->			
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
				<td align="center"><myTags:pageHandle/></td>
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
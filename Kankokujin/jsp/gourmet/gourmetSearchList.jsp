	<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.PageBean, category.bean.CategoryBean"%>
<%@ page import="gourmet.bean.GourmetBean, gourmet.bean.GourmetSearchBean"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ page import="common.bean.MemberBean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>

<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	GourmetSearchBean gourmetSearchBean = (GourmetSearchBean) request.getAttribute("GourmetSearchBean");
	MemberBean member = new MemberBean();
	member.setUserid("-");
	if(session.getAttribute("memberInfo")!=null){
		member = (MemberBean) session.getAttribute("memberInfo");	
	}
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title><c:out value="음식점"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
			if (message == 'WAR0004'){
				alert("<fmt:message key="WAR0004" bundle="${message}"/>");
				window.open('PopLogin', 'notice', 'width=230, height=160');	
			}
		}
	}
	function reloadAreaLineSearch(obj) {
		if(obj == "0"){
			document.list.action="GourmetSearch?re=0";
		} else if (obj == "1"){
			document.list.action="GourmetSearch?re=1";
		}
		
		document.list.submit(); 
		return true;
	}
	function registOpen(ff) {
		ff.action="GourmetRegistOpen?before=search&f=search";
		ff.submit(); 
		return true;
	}	
	function storePageSize(ff) {
		ff.action="GourmetSearch?re=9";
		ff.submit(); 
		return true;
	}

	function reloadPage(obj) {
		document.list.action="GourmetSearch?pageNum="+obj;
		document.list.submit(); 
		return true;
	}
	function reloadCate_code_1(obj) {
		document.list.action="GourmetSearch?re=9&search_cate_code_1=" + obj + "&search_cate_code_2=&before_cate_code_2=";
		document.list.submit(); 	
		return true;
	}
	function reloadCate_code_2(cate_code_1, cate_code_2) {
		document.list.action="GourmetSearch?re=9&search_cate_code_1=" + cate_code_1 + "&search_cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}
	function searchStore(cate_code_1, cate_code_2) {
		document.list.action="GourmetSearch?re=9&search_cate_code_1=" + cate_code_1 + "&search_cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}	
	function my_write(user_id) {

		if(user_id == "-"){
			document.list.action="GourmetSearch?re=9&user_id=-";
		} else if(user_id == "_"){
			document.list.action="GourmetSearch?re=9&user_id=";
		} else {
			document.list.action="GourmetSearch?re=9&user_id=" + user_id;
		}	
		document.list.submit(); 
		return true;
	}
	function openDetailPage(id) {

		document.list.action="GourmetDetail?before=search&id=" + id;
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
			<form name="list" method="post" style="margin:0" action="GourmetSearch?re=9">
			<input type="hidden" id="msg" name = "msg" value="<c:out value="${Message}"/>" />
			<input type="hidden" name="user_id" value="${GourmetSearchBean.user_id}">      			
  			<input type="hidden" name="before_cate_code_1" value="${GourmetSearchBean.cate_code_1}">
 			<input type="hidden" name="before_cate_code_2" value="${GourmetSearchBean.cate_code_2}"> 		
			<input type="hidden" name="before_pageNum" value="${GourmetSearchBean.pageNum}"> 
			<input type="hidden" name="before_pageSize" value="${GourmetSearchBean.pageSize}">    
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
						<td height="63" colspan="3" background="jsp/images/new/food_box_tit.gif">
							<table width="90%"    border="0" align="center" cellpadding="0" cellspacing="1">
							<tr>
								<td width="14%" align="right" ><span class="search-num1"><c:out value="(${Category1Count['categoryTotalCount']})"/></span></td>
								<td width="4%" >&nbsp;</td>
								<td width="82%" >
								<!--제1카테고리-->
									<c:forEach var="Category1" items="${Category1List}" varStatus="i">
          								<c:if test="${GourmetSearchBean.cate_code_1 eq Category1.cate_code}">
											<span class="search-text2" onclick="return reloadCate_code_1('${Category1.cate_code}')"> 
												<!--카테고리2명에서 표시할 카테고리1명설정-->
												<c:set var="SetCategoryName" scope="page" value="${Category1.cate_name}"/>
												<c:if test="${empty Category1Count[Category1['cate_code']]}">
													<c:set var="SetCategoryCount" scope="page" value="0"/>
												</c:if>
												<c:if test="${!empty Category1Count[Category1['cate_code']]}">
													<c:set var="SetCategoryCount" scope="page" value="${Category1Count[Category1['cate_code']]}"/>
												</c:if>												
												<!--카테고리명  검색건수 표시-->
												<c:if test="${empty Category1Count[Category1['cate_code']]}"><c:out value="${Category1.cate_name}(0)"/></c:if>
												<c:if test="${!empty Category1Count[Category1['cate_code']]}"><c:out value="${Category1.cate_name}(${Category1Count[Category1['cate_code']]})"/></c:if></span>
											<!--카테고리1이 마지막이 아닐경우 | 표시를 붙힌다-->	
											<c:if test="${!i.last}">
												<c:out value="|"/>  
											</c:if>							
										</c:if>
										<c:if test="${GourmetSearchBean.cate_code_1 != Category1.cate_code}">
											<a href="javascript:reloadCate_code_1('${Category1.cate_code}')" class="search-link1">
												<!--카테고리명  검색건수 표시-->
												<c:if test="${empty Category1Count[Category1['cate_code']]}"><c:out value="${Category1.cate_name}(0)"/></c:if>
												<c:if test="${!empty Category1Count[Category1['cate_code']]}"><c:out value="${Category1.cate_name}(${Category1Count[Category1['cate_code']]})"/></c:if>
											</a>
										<!--카테고리1이 마지막이 아닐경우 | 표시를 붙힌다-->	
										<c:if test="${!i.last}">
											<c:out value="|"/>  
										</c:if>				
										</c:if>	
										<!--화면에7건-->			
										<c:if test="${(i.index + 1) % 7 == 0}">
											<br>
										</c:if>
        							 </c:forEach>
								</td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td background="jsp/images/new/search_box_left.gif" ><img src="jsp/images/new/search_box_left.gif" width="20" height="30" alt="" /></td>
						<td width="910" height="63" align="center" valign="middle" style="padding:10px 8px 8px 8px;">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<c:if test="${!empty GourmetSearchBean.cate_code_1}">
							<tr>
								<!--제2카테고리-->
								<td width="20%" align="left"><strong class="search-text1"><c:out value="${SetCategoryName}(${SetCategoryCount})"/></strong></td>
								<td width="69%" align="left">
									<c:forEach var="Category2" items="${Category2List}" varStatus="i">
              								<c:if test="${GourmetSearchBean.cate_code_2 eq Category2.cate_code_2}">
												<span class="search-text3" onclick="return reloadCate_code_2('${GourmetSearchBean.cate_code_1}','${Category2.cate_code_2}')">
													<strong> 
													<!--카테고리명  검색건수 표시-->
													<c:if test="${empty Category2Count[Category2['cate_code_2']]}">
														<c:out value="${Category2.cate_name_2}(0)"/>
													</c:if>
													<c:if test="${!empty Category2Count[Category2['cate_code_2']]}">
														<c:out value="${Category2.cate_name_2}(${Category2Count[Category2['cate_code_2']]})"/>
													</c:if></strong></span><strong>&nbsp;&nbsp;							
											</c:if>
											<c:if test="${GourmetSearchBean.cate_code_2 != Category2.cate_code_2}">
												<a href="javascript:reloadCate_code_2('${GourmetSearchBean.cate_code_1}','${Category2.cate_code_2}')" class="search-link2">
													<!--카테고리명  검색건수 표시-->
													<c:if test="${empty Category2Count[Category2['cate_code_2']]}">
														<c:out value="${Category2.cate_name_2}(0)"/>
													</c:if>
													<c:if test="${!empty Category2Count[Category2['cate_code_2']]}">
														<c:out value="${Category2.cate_name_2}(${Category2Count[Category2['cate_code_2']]})"/>
													</c:if></a>&nbsp;&nbsp;				
											</c:if></strong>
											<!--화면에7건-->			
											<c:if test="${(i.index + 1) % 7 == 0}">
												<br>
											</c:if>				
        							 	</c:forEach>
								</td>
								<td width="11%" align="right">&nbsp;</td>
							</tr>
							<tr>
								<td height="23" colspan="3" align="left" background="jsp/images/new/searchbox_line.gif">&nbsp;</td>
							</tr>
							</c:if>
							<tr>
								<td colspan="2" align="left">
                					<select name="search_area_code_1" id="select3" onchange="return reloadAreaLineSearch('0');">
                						${GourmetSearchBean.area_1Tag}
									</select>
									<select name="search_area_code_2" id="select4">
										${GourmetSearchBean.area_2Tag}
									</select>
									  &nbsp;&nbsp;&nbsp;&nbsp;
									<select name="search_line_code" id="select5" onchange="return reloadAreaLineSearch('1');">
										${GourmetSearchBean.lineTag}
									</select>
									<select name="search_station_code" id="select6">
										${GourmetSearchBean.stationTag}
									</select>
									  &nbsp;&nbsp;&nbsp;&nbsp;
									<select name="search_range" id="select7">
										<option value='0' ${GourmetSearchBean.search_all}>전체검색</option>
										<option value='1' ${GourmetSearchBean.search_com_name}>가게명</option>
										<option value='2' ${GourmetSearchBean.search_detail}>상세정보</option>
									</select>
									<input type="text" name="search" id="textfield2" value='${GourmetSearchBean.search}'/>
								</td>
								<td width="11%" align="right">
									<a href="GourmetSearch?re=9"><img src="jsp/images/new/search_return_b.gif" width="94" height="22" /></a></td>
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
								<!--검색 버튼 -->
								<td colspan="3" align="center">
									<a href="javascript:searchStore('${GourmetSearchBean.cate_code_1}','${GourmetSearchBean.cate_code_2}');"><img src="jsp/images/new/search_b.gif" width="107" height="35" /></a></td>
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
							<c:if test="${empty GourmetSearchBean.user_id}">
								<img src="jsp/images/new/search_tit2.gif" width="118" height="23" />
							</c:if>	
							<c:if test="${!empty GourmetSearchBean.user_id}">
								<img src="jsp/images/new/mywrite_title.gif" width="118" height="23" />
							</c:if>	
						</td>
						<td width="56%">&nbsp;</td>
						<td width="31%" align="right">
							<select name="pageSize" id="select2" onChange='return storePageSize(list)'>
								<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10개씩보기</option>
								<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20개씩보기</option>
								<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50개씩보기</option>
								<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100개씩보기</option>
							</select>
							
							<c:if test="${empty GourmetSearchBean.user_id}">
								<!--ID가 없으면 내글보기표시 -->
								<c:if test="${empty memberInfo.userid}">
		              			<a href="javascript:my_write('-');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>	
		              			<c:if test="${!empty memberInfo.userid}">
		              			<a href="javascript:my_write('${memberInfo.userid}');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>
		              		</c:if>	
							<c:if test="${!empty GourmetSearchBean.user_id}">
							<!--ID가 있으면 목록표시 목록이미지 현재 무 -->
							<a href="javascript:my_write('_');">
								<img src="jsp/images/new/btn_list.gif" align="absmiddle"/></a>&nbsp;							
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
						<td height="41" colspan="7" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="6%" align="center" class="board-title-text"><span class="style8">번호</span></td>
								<td width="8%" align="center" class="board-title-text"><span class="style8"> 이미지</span></td>
								<td width="39%" align="center" class="board-title-text"><span class="style8">가게명</span></td>
								<td width="12%" align="center" class="board-title-text"><span class="style8">전화번호</span></td>
								<td width="8%" align="center" class="board-title-text"><span class="style8">홈페이지</span></td>
								<td width="17%" align="center" class="board-title-text"><span class="style8">지역/노선정보</span></td>
								<td width="10%" align="center" class="board-title-text"><span class="style8">등록일</span></td>
							</tr>
							</table>
						</td>
					</tr>
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
				             	<a href="javascript:openDetailPage('${GourmetBean.id}');"><img src="${GourmetBean.thumbNail_path}" ></a>
				             </td>
				              <!--가게명 -->
				             <td width="39%" valign="center">
				             	<a href="javascript:openDetailPage('${GourmetBean.id}');"><c:out value="${GourmetBean.store_full_name}"/>${util:getNewImage(GourmetBean.update_dateTime)}</a>
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
				<!--페이지표시 -->
				<td align="center">
        			<myTags:pageHandle />
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
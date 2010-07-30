<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.PageBean, category.bean.CategoryBean"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ page import="job.bean.JobBean, job.bean.JobSearchBean"%>
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
	JobSearchBean jobSearchBean = (JobSearchBean) request.getAttribute("JobSearchBean");
	List category1List = (List) request.getAttribute("Category1List");
	List category2List = (List) request.getAttribute("Category2List");
	
	MemberBean member = new MemberBean();
	member.setUserid("-");
	if(session.getAttribute("memberInfo")!=null){
		member = (MemberBean) session.getAttribute("memberInfo");	
	}
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title><c:out value="구인"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
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
	function registOpen(obj) {
		document.list.action="JobRegistOpen?before=search&f=search&cate_code_1=" + obj;
		document.list.submit(); 
		return true;
	}			
	function storePageSize(ff) {
		ff.action="JobSearch?re=9";
		ff.submit(); 
		return true;
	}
	function reloadPage(obj) {
		document.list.action="JobSearch?pageNum="+obj;
		document.list.submit(); 
		return true;
	}	
	function reloadCate_code_1(obj) {
		document.list.action="JobSearch?re=9&search_cate_code_1=" + obj + "&search_cate_code_2=&before_cate_code_2=";
		document.list.submit(); 	
		return true;
	}
	function reloadCate_code_2(cate_code_1, cate_code_2) {
		document.list.action="JobSearch?re=9&search_cate_code_1=" + cate_code_1 + "&search_cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}
	function searchStore(cate_code_1, cate_code_2) {
		document.list.action="JobSearch?re=9&search_cate_code_1=" + cate_code_1 + "&search_cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}	
	function my_write(user_id) {
		if(user_id == "-"){
			document.list.action="JobSearch?re=9&user_id=-";
		} else if(user_id == "_"){
			document.list.action="JobSearch?re=9&user_id=";
		} else {
			document.list.action="JobSearch?re=9&user_id=" + user_id;
		}	
		document.list.submit(); 
		return true;
	}
	function openDetailPage(id) {

		document.list.action="JobDetail?before=search&id=" + id;
		document.list.submit(); 
		return true;
	}
	function popupMenuOpen(userid, id, name) {
		clickedUserid = userid;
		clickedId = id;
		clickedName = name;
	}
	function makewriteLook() {
		document.list.action="JobSearch?re=9&user_id=" + clickedUserid;
		document.list.submit(); 
		return true;
	}
	function mailOpenAction() {
		mailOpen(clickedId, clickedName, '6');
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
			<input type="hidden" name="user_id" value="<%=jobSearchBean.getUser_id()%>">      						  
	      	<input type="hidden" name="before_cate_code_1" value="<%=jobSearchBean.getCate_code_1()%>">
			<input type="hidden" name="before_cate_code_2" value="<%=jobSearchBean.getCate_code_2()%>">       		
			<input type="hidden" name="before_pageNum" value="<%=jobSearchBean.getPageNum()%>"> 
			<input type="hidden" name="before_pageSize" value="<%=jobSearchBean.getPageSize()%>">          			      					 				
			<input type="hidden" name="before_sex" value="<%=jobSearchBean.getSex()%>">
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
						<td height="63" colspan="3" background="jsp/images/new/job_box_tit.gif">
							<table width="90%" border="0" align="center" cellpadding="0" cellspacing="1">
							<tr>
								<td width="12%" align="right" ><span class="search-num1"><c:out value="(${Category1Count['categoryTotalCount']})"/></span></td>
								<td width="6%" >&nbsp;</td>
								<td width="82%" >
									<c:forEach var="Category1" items="${Category1List}" varStatus="i">
          								<c:if test="${JobSearchBean.cate_code_1 eq Category1.cate_code}">
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
										<c:if test="${JobSearchBean.cate_code_1 != Category1.cate_code}">
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
						<td width="910" align="center" valign="middle" style="padding:10px 8px 8px 8px;">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<c:if test="${!empty JobSearchBean.cate_code_1}">
							<tr>
								<!--제2카테고리-->
								<td width="19%" align="left" >
									<strong class="search-text1">
				                		<!--카테로리 1이름 -->
				                		<c:out value="${SetCategoryName}(${SetCategoryCount})"/>
				                	</strong>
				                </td>
								<td width="70%" align="left">
									<c:forEach var="Category2" items="${Category2List}" varStatus="i">
          								<c:if test="${JobSearchBean.cate_code_2 eq Category2.cate_code_2}">
											<span class="search-text3" onclick="return reloadCate_code_2('${JobSearchBean.cate_code_1}','${Category2.cate_code_2}')"> 
												<!--카테고리명  검색건수 표시-->
												<c:if test="${empty Category2Count[Category2['cate_code_2']]}">
													<c:out value="${Category2.cate_name_2}(0)"/>
												</c:if>
												<c:if test="${!empty Category2Count[Category2['cate_code_2']]}">
													<c:out value="${Category2.cate_name_2}(${Category2Count[Category2['cate_code_2']]})"/>
												</c:if></span><strong>&nbsp;&nbsp;</strong>							
										</c:if>
										<c:if test="${JobSearchBean.cate_code_2 != Category2.cate_code_2}">
											<a href="javascript:reloadCate_code_2('${JobSearchBean.cate_code_1}','${Category2.cate_code_2}')" class="search-link2">
												<!--카테고리명  검색건수 표시-->
												<c:if test="${empty Category2Count[Category2['cate_code_2']]}">
													<c:out value="${Category2.cate_name_2}(0)"/>
												</c:if>
												<c:if test="${!empty Category2Count[Category2['cate_code_2']]}">
													<c:out value="${Category2.cate_name_2}(${Category2Count[Category2['cate_code_2']]})"/>
												</c:if></a><strong>&nbsp;&nbsp;</strong>
														
										</c:if>
										<!--화면에7건-->			
										<c:if test="${(i.index + 1) % 4 == 0}">
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
								<td colspan="2" align="left">성별
									<select name="search_sex">
										<option value="0" <%=jobSearchBean.getSex_selected(0)%> >무관</option>
										<option value="1" <%=jobSearchBean.getSex_selected(1)%> >남</option>
										<option value="2" <%=jobSearchBean.getSex_selected(2)%> >여</option>
									</select>&nbsp;&nbsp;&nbsp;&nbsp;
									<select name="search_range" id="select7">
										<option value='0' <%=jobSearchBean.getSearch_all() %>>전체검색</option>
										<option value='1' <%=jobSearchBean.getSearch_com_name()%>>회사명</option>
										<option value='2' <%=jobSearchBean.getSearch_title()%>>글제목</option>						
										<option value='3' <%=jobSearchBean.getSearch_detail()%>>상세정보</option>
									</select>
									<input type="text" name="search" id="textfield2" value='<%= jobSearchBean.getSearch()%>' /></td>
								<td width="11%" align="right">
									<!-- 초기화버튼 -->
									<a href="JobSearch?re=9"><img src="jsp/images/new/search_return_b.gif" width="94" height="22" /></a></td>
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
									<a href="javascript:searchStore('${JobSearchBean.cate_code_1}','${JobSearchBean.cate_code_2}');"><img src="jsp/images/new/search_b.gif" width="107" height="35" /></a></td>
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
							<c:if test="${empty JobSearchBean.user_id}">
								<img src="jsp/images/new/search_tit2.gif" width="118" height="23" />
							</c:if>	
							<c:if test="${!empty JobSearchBean.user_id}">
								<img src="jsp/images/new/mywrite_title.gif" width="118" height="23" />
							</c:if>	
						</td>
						<td width="41%">&nbsp;</td>
						<td width="46%" align="right">
							<select name="pageSize" id="select2" onchange='return storePageSize(list)'>
								<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10개씩보기</option>
								<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20개씩보기</option>
								<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50개씩보기</option>
								<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100개씩보기</option>
							</select>
							<c:if test="${empty JobSearchBean.user_id}">
								<!--ID가 없으면 내글보기표시 -->
								<c:if test="${empty memberInfo.userid}">
		              			<a href="javascript:my_write('-');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>	
		              			<c:if test="${!empty memberInfo.userid}">
		              			<a href="javascript:my_write('${memberInfo.userid}');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>
							</c:if>		              			
							<c:if test="${!empty JobSearchBean.user_id}">
							<!--ID가 있으면 목록표시 -->
							<a href="javascript:my_write('_');">
								<img src="jsp/images/new/btn_list.gif" align="absmiddle" /></a>&nbsp;							
							</c:if>	
							
		                	<!--등록 -->
							<a href="javascript:registOpen('C10100');"><img src="jsp/images/new/btn_staff_job_regist.gif" align="absmiddle" /></a>
							<a href="javascript:registOpen('C10200');"><img src="jsp/images/new/btn_arbeit_job_regist.gif" align="absmiddle" /></a>
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
						<td height="41" colspan="10" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="6%" align="center" class="board-title-text"><span class="style8">번호</span></td>
								<td width="8%" align="center" class="board-title-text"><span class="style8">이미지</span></td>
								<td width="29%" align="center" class="board-title-text"><span class="style8">글제목</span></td>
								<td width="7%" align="center" class="board-title-text"><span class="style8">고용형태</span></td>																		
								<td width="13%" align="center" class="board-title-text"><span class="style8">회사명<br>/업종</span></td>									
								<td width="5%" align="center" class="board-title-text"><span class="style8">성별</span></td>																		
								<td width="14%" align="center" class="board-title-text"><span class="style8">급여조건<br>/근무시간</span></td>
								<td width="7%" align="center" class="board-title-text"><span class="style8">등록자</span></td>
								<td width="6%" align="center" class="board-title-text"><span class="style8">등록일</span></td>
								<td width="5%" align="center" class="board-title-text"><span class="style8">조회수</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--리스트 표시 -->
					<c:choose>
					<c:when test="${!empty JobBeanList}">
						<c:forEach var="JobBean" items="${JobBeanList}" varStatus="i">
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								${JobBean.id}	
							</td>
							 <!--이미지 -->
				             <td width="8%" align="center">
				             	<a href="javascript:openDetailPage('${JobBean.id}');"><img src="${JobBean.thumbNail_path}" ></a>
				             </td>
				             <!--글제목 -->
							<td width="29%">
								<a href="javascript:openDetailPage('${JobBean.id}');">
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
							<td width="14%" align="center">
								<c:out value="${JobBean.pay}"/><br><c:out value="${JobBean.work_time}"/>&nbsp;</td>
							 <!--등록자 -->							
							<td width="7%" align="center">
								<!--<a href="javascript:my_write('${JobBean.user_id}');"><span style="text-decoration: underline">${JobBean.user_name}</span>-->
								<span class="registUser" id="link${i.index + 1}" onclick="popupMenuOpen('${JobBean.user_id}','${JobBean.id}','${JobBean.user_name}')">${JobBean.user_name}&nbsp;</span>&nbsp;
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
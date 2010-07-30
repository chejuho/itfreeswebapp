<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.PageBean"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ page import="findjob.bean.FindjobBean, findjob.bean.FindjobSearchBean"%>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	FindjobSearchBean findjobSearchBean = (FindjobSearchBean) request.getAttribute("FindjobSearchBean");
	MemberBean member = new MemberBean();
	member.setUserid("-");
	if(session.getAttribute("memberInfo")!=null){
		member = (MemberBean) session.getAttribute("memberInfo");	
	}
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<head>
<title><c:out value="구직"/>&nbsp;::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
//<!--
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
	function registOpen(ff) {
		ff.action="FindjobRegistOpen?before=search&f=search";
		ff.submit(); 
		return true;
	}	
	function storePageSize(ff) {
		ff.action="FindjobSearch?re=9";
		ff.submit(); 
		return true;
	}

	function reloadPage(obj) {
		document.list.action="FindjobSearch?pageNum="+obj;
		document.list.submit(); 
		return true;
	}
	function searchStore() {
		document.list.action="FindjobSearch?re=9";
		document.list.submit(); 	
		return true;
	}	
	function my_write(user_id) {

		if(user_id == "-"){
			document.list.action="FindjobSearch?re=9&user_id=-";
		} else if(user_id == "_"){
			document.list.action="FindjobSearch?re=9&user_id=";
		} else {
			document.list.action="FindjobSearch?re=9&user_id=" + user_id;
		}			
		document.list.submit(); 
		return true;
	}
	function openDetailPage(id) {

		document.list.action="FindjobDetail?before=search&id=" + id;
		document.list.submit(); 
		return true;
	}
	function popupMenuOpen(userid, id, name) {
		clickedUserid = userid;
		clickedId = id;
		clickedName = name;
	}
	function makewriteLook() {
		document.list.action="FindjobSearch?re=9&user_id=" + clickedUserid;
		document.list.submit(); 
		return true;
	}
	function mailOpenAction() {
		mailOpen(clickedId, clickedName, '7');
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
			<input type="hidden" name="user_id" value="<%=findjobSearchBean.getUser_id()%>" />				
			<input type="hidden" name="before_pageNum" value="<%=findjobSearchBean.getPageNum()%>" />
			<input type="hidden" name="before_pageSize" value="<%=findjobSearchBean.getPageSize()%>" />
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
						<td height="63" colspan="3" background="jsp/images/new/findjob_box_tit.gif">
							<table width="94%"    border="0" align="center" cellpadding="0" cellspacing="1">
							<tr>
								<td width="8%" >&nbsp;</td>
								<td width="92%" ><span class="search-num1"><c:out value="(${PageBean.maxCount})"/></span></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td background="jsp/images/new/search_box_left.gif" ><img src="jsp/images/new/search_box_left.gif" width="20" height="30" alt="" /></td>
						<td width="910" align="center" valign="middle" style="padding:10px 8px 8px 8px;">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="89%" align="left">
									<select name="search_range">
										<option value="0" <%=findjobSearchBean.getSearch_all()%> >전체검색</option>
										<option value="1" <%=findjobSearchBean.getSearch_title()%> >글제목</option>
										<option value="2" <%=findjobSearchBean.getSearch_com_name()%> >등록자</option>
										<option value="3" <%=findjobSearchBean.getSearch_detail()%> >상세정보</option>
									</select>
									<input maxlength="100" name="search" style="width:300px; " value="${FindjobSearchBean.search}"/></td>
								<td width="11%" align="right">
									<!-- 초기화버튼 -->
									<a href="FindjobSearch?re=9"><img src="jsp/images/new/search_return_b.gif" width="94" height="22" /></a></td>
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
									<!-- 검색버튼 -->
									<a href="javascript:searchStore();"><img src="jsp/images/new/search_b.gif" width="107" height="35" /></a></td>
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
							<c:if test="${empty FindjobSearchBean.user_id}">
								<img src="jsp/images/new/search_tit2.gif" width="118" height="23" />
							</c:if>	
							<c:if test="${!empty FindjobSearchBean.user_id}">
								<img src="jsp/images/new/mywrite_title.gif" width="118" height="23" />
							</c:if>	
						</td>
						<td width="56%">&nbsp;</td>
						<td width="31%" align="right">
							<select name="pageSize" id="select2" onchange='return storePageSize(list)'>
								<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10개씩보기</option>
								<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20개씩보기</option>
								<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50개씩보기</option>
								<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100개씩보기</option>
							</select>
							<c:if test="${empty FindjobSearchBean.user_id}">
								<!--ID가 없으면 내글보기표시 -->
								<c:if test="${empty memberInfo.userid}">
		              			<a href="javascript:my_write('-');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>	
		              			<c:if test="${!empty memberInfo.userid}">
		              			<a href="javascript:my_write('${memberInfo.userid}');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>
							</c:if>		              			
							<c:if test="${!empty FindjobSearchBean.user_id}">
							<!--ID가 있으면 목록표시 -->
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
						<td height="41" colspan="8" background="jsp/images/new/board_list_top_bg.gif" class="search-list-tit">
							<table width="100%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td width="6%" align="center" class="board-title-text"><span class="style8">번호</span></td>
								<td width="50%" align="center" class="board-title-text"><span class="style8">글제목</span></td>
								<td width="10%" align="center" class="board-title-text"><span class="style8">희망고용형태</span></td>
								<td width="8%" align="center" class="board-title-text"><span class="style8">출생년도</span></td>
								<td width="7%" align="center" class="board-title-text"><span class="style8">성별</span></td>
								<td width="7%" align="center" class="board-title-text"><span class="style8">등록자</span></td>
								<td width="7%" align="center" class="board-title-text"><span class="style8">등록일</span></td>
								<td width="5%" align="center" class="board-title-text"><span class="style8">조회수</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--리스트 표시 -->
					<c:choose>
					<c:when test="${!empty FindjobBeanList}">
						<c:forEach var="FindjobBean" items="${FindjobBeanList}"  varStatus="i">
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								${FindjobBean.id}
							</td>
							<!--글제목 -->
							<td width="50%">
								<a href="javascript:openDetailPage('${FindjobBean.id}');">
									<c:out value="${FindjobBean.title}"/>${util:getNewImage(FindjobBean.update_dateTime)}</a>&nbsp;</td>
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
								<!--<a href="javascript:my_write('${FindjobBean.user_id}');"><span style="text-decoration: underline">${FindjobBean.user_name}</span>&nbsp;-->
								<span class="registUser" id="link${i.index + 1}" onclick="popupMenuOpen('${FindjobBean.user_id}','${FindjobBean.id}','${FindjobBean.user_name}')">${FindjobBean.user_name}&nbsp;</span>&nbsp;
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
	<div id = "popup" style = "display:none" class="popupMenu">
		<table border="0">
			<tr><td class="board-title-text" width="150px"><a href="javascript:makewriteLook();">작성글보기</a></td></tr>
			<tr><td class="board-title-text" width="150px"><a href="" onclick="mailOpenAction(); return false;">메일보내기</a></td></tr>
		</table>
	</div>
</body>
</html>
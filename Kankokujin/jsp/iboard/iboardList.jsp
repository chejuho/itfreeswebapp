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
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title>게시판&nbsp;::&nbsp;글목록</title>

<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
	//var popupMenuList = new Array();
	window.onload=init;
	/** ERROR메세지 처리  */
	 function init() {
	}
	//ページ処理
	function reloadPage(pagenum) {
		document.list.action="IBoardList?pageNum="+pagenum;
		document.list.submit(); 
		return true;
	}
	function pageSizeChange() {
		document.list.action="IBoardList";
		document.list.submit(); 
		return true;
	}
	
	//登録
	function registOpen() {
		var board_id = document.list.board_id.value;
		document.list.action="IBoardRegistOpen?board_id=" + board_id;
		document.list.submit(); 
		return true;
	}
	//ファイルDownLoad
	function fileDownLoad(filename) {
		document.list.action="FileDownload?fileName=" +encodeURIComponent(filename);
		document.list.submit(); 
		return true;
	}
	//詳細画面
	function openDetailPage(id) {
		var board_id = document.list.board_id.value;
		document.list.action="IBoardDetail?id=" + id + "&board_id=" + board_id;
		document.list.submit(); 
		return true;
	}	
	//Search
	function search() {
		document.list.action="IBoardList?searchGo=ok";
		document.list.submit(); 
		return true;
	}
	//Enter Key Search
	function keyCodeSearch() {
		if(Keycode(event) ==13) search();
	}
	
	
	function goListInit() {
		var board_id = document.list.board_id.value;
		document.list.action="IBoardList?board_id=" + board_id;
		document.list.submit(); 
		return true;
	}
	
	
	//KeyCode
	function Keycode(e){
		
		var result;
		if(window.event) {		
	    	result = window.event.keyCode;
	    } else if(e) {
			result = e.which;
		}		
		return result;
	}
	
			
</script>	
</head>
<body style="margin:0 0 0 0">
	<table border="0">
	<tr>
		<td width="150">&nbsp;</td>
		<td height="20">&nbsp;</td>
	</tr>
	<tr>
		<td width="150">&nbsp;</td>
		<td>
			<form name="list" method="post" style="margin:0">
			<input type="hidden" name="board_id" value="${board_id}"> 
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="85" background="jsp/images/new/foot_bg.gif" style="padding:18px 11px 11px 11px;" valign="bottom" align="center"><a href="javascript:goListInit();"><h2>${boardName} 게시판</h2>&nbsp;</a></td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="41%">&nbsp;</td>
						<td width="46%" align="right">
							<select name="pageSize" id="select2" onchange='return pageSizeChange()'>
								<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10개씩보기</option>
								<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20개씩보기</option>
								<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50개씩보기</option>
								<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100개씩보기</option>
							</select>
							<!--ID가 없으면 내글보기표시 -->
							<!--
							<c:if test="${searchBean.myWrite}">
								
								<c:if test="${empty memberInfo}">
		              				<a href="javascript:goLogin();"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>	
		              			<c:if test="${!empty memberInfo}">
		              				<a href="javascript:my_write('${memberInfo.userid}');"><img src="jsp/images/new/mywriting_b.gif" align="absmiddle" width="77" height="22" /></a>&nbsp;
		              			</c:if>
		              		</c:if>	  -->        			
							<c:if test="${!searchBean.myWrite}">
							<!--ID가 있으면 목록표시 -->
							<!--
							<a href="javascript:my_write('_');">
								<img src="jsp/images/new/btn_list.gif" align="absmiddle" /></a>&nbsp;							
							</c:if>	-->  
							<!--등록 -->
							<a href="javascript:registOpen();"><img src="jsp/images/new/btn_cs_write.gif" align="absmiddle" /></a>
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
								<td width="67%" align="center" class="board-title-text"><span class="style8">글제목</span></td>
								<td width="3%" align="center" class="board-title-text"><span class="style8"></span></td>
								<td width="3%" align="center" class="board-title-text"><span class="style8"></span></td>
								<td width="3%" align="center" class="board-title-text"><span class="style8"></span></td>
								<td width="7%" align="center" class="board-title-text"><span class="style8">글쓴이</span></td>
								<td width="6%" align="center" class="board-title-text"><span class="style8">작성일</span></td>
								<td width="5%" align="center" class="board-title-text"><span class="style8">조회수</span></td>
							</tr>
							</table>
						</td>
					</tr>
					<!--리스트 표시 -->
					<c:choose>
					<c:when test="${!empty boardBeanList}">
						<c:forEach var="boardBean" items="${boardBeanList}" varStatus="i">
						<tr>
							<!--번호 -->
							<td width="6%" height="52" align="center">
								<c:out value="${boardBean.id}"/>
							</td>
				             <!--글제목 -->
							<td width="73%">
								<a href="javascript:openDetailPage('${boardBean.id}');">
									<c:out value="${boardBean.title}"/></a>&nbsp;
									<c:if test="${!empty boardBean.filename1}">
		              					<a href="javascript:fileDownLoad('${boardBean.downFile1Url}');"><img src="jsp/images/new/icon_file.gif"  align="absmiddle"/></a>&nbsp;
		              				</c:if>
		              				<c:if test="${!empty boardBean.filename2}">
		              					<a href="javascript:fileDownLoad('${boardBean.downFile2Url}');"><img src="jsp/images/new/icon_file.gif"  align="absmiddle"/></a>&nbsp;
		              				</c:if>
		              				<c:if test="${!empty boardBean.filename3}">
		              					<a href="javascript:fileDownLoad('${boardBean.downFile3Url}');"><img src="jsp/images/new/icon_file.gif"  align="absmiddle"/></a>&nbsp;
		              				</c:if>
		              				${util:getNewImage(boardBean.update_dateTime)}
							</td>
							 <!--등록자 -->							
							<td width="10%" align="center">
									${boardBean.user_name}&nbsp;
							</td>
							 <!--등록일 -->							
							<td width="6%" align="center">
								<c:out value="${boardBean.update_date}"/>&nbsp;</td>
							 <!--조회수 -->							
							<td width="5%" align="center">
								<c:out value="${boardBean.read_count}"/>&nbsp;</td>
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
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" border="1">
					<select name="search_range" id="select7">
						<c:if test="${'0' == searchBean.search_range}">
							<option value='0' selected>전체검색</option>
							<option value='1' >글제목</option>						
							<option value='2' >글내용</option>
							<option value='3' >파일명</option>
						</c:if>
						<c:if test="${'1' == searchBean.search_range}">
							<option value='0' >전체검색</option>
							<option value='1' selected>글제목</option>						
							<option value='2' >글내용</option>
							<option value='3' >파일명</option>
						</c:if>
						<c:if test="${'2' == searchBean.search_range}">
							<option value='0' >전체검색</option>
							<option value='1' >글제목</option>						
							<option value='2' selected>글내용</option>
							<option value='3' >파일명</option>
						</c:if>
						<c:if test="${'3' == searchBean.search_range}">
							<option value='0' >전체검색</option>
							<option value='1' >글제목</option>						
							<option value='2' >글내용</option>
							<option value='3' selected>파일명</option>
						</c:if>
						<c:if test="${empty searchBean.search_range}">
							<option value='0' >전체검색</option>
							<option value='1' >글제목</option>						
							<option value='2' >글내용</option>
							<option value='3' >파일명</option>
						</c:if>
					</select>
					<input type="text" name="search" onkeydown="keyCodeSearch(event)"　id="textfield2" style="width:300px;" value="${searchBean.search}" align="absmiddle"/>
					<a href="javascript:search();"><img src="jsp/images/new/all_search_b.gif"  width="45" height="21" align="absmiddle"/></a>	
				</td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td width="150">&nbsp;</td>
		<td height="50">&nbsp;</td>
	</tr>
	</table>
</body>
</html>
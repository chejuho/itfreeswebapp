<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean, common.util.EnDecoding"%>
<%@ page import="findjob.bean.FindjobBean, findjob.bean.FindjobSearchBean"%>
<%@ page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<%
	FindjobBean bean = (FindjobBean) request.getAttribute("FindjobBean");
	FindjobSearchBean findjobSearchBean = (FindjobSearchBean) request.getAttribute("FindjobSearchBean");
	
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title>${FindjobBean.title} ::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/popupMenu.js" type="text/javascript"></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/include/js/commonCheck.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
	function goDirectTopMenu(topMenu) {
	 	//var topMenu =	document.getElementById("topMenu").value;
	 	if (topMenu == '1') {
	 		document.wf.action="BuySellList?re=9&search_cate_code_1=C10100";
	 	}
	 	if (topMenu == '2') {
	 		document.wf.action="BuySellList?re=9&search_cate_code_1=C10200";
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
	function deleteCheck(id){
	
			if(confirm("삭제하시겠습니까?")){
				document.wf.action="FindjobDelete?id="+id;
				document.wf.submit(); 
				return true;
			}
	}
	function openUpdate(id){
		document.wf.action="FindjobUpdateOpen?id=" + id;
		document.wf.submit(); 
		return true;
	}	
	function setImage(position){
		document.getElementById("disp").src = position;
		return false;
	}	
	function backSearchPage() {
		document.wf.action="FindjobSearch?re=9&modoru=ok";
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
	function backMyWrite() {
		document.wf.action="MyWrite?sort=9&modoru=ok";
		document.wf.submit(); 
		return true;
	}
	function goSearchPage() {
		document.wf.action="FindjobSearch?re=9";
		document.wf.submit(); 
		return true;
	}
	function mailOpenDetail(id,name) {
		mailOpen(id, name, '7');
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
			<input type="hidden" name="user_id"	value="<%=findjobSearchBean.getUser_id()%>">
			<input type="hidden" name="id"	value="<%=bean.getId()%>">			
  			<input type="hidden" name="search" value="<%=findjobSearchBean.getSearch()%>">      			      			
  			<input type="hidden" name="search_range" value="<%=findjobSearchBean.getSearch_range()%>">      			      			
  			<input type="hidden" name="pageNum" value="<%=findjobSearchBean.getPageNum()%>">    
			<input type="hidden" name="pageSize" value="<%=findjobSearchBean.getPageSize()%>">          			      					 				      			  			  			      			
  			<input type="hidden" name="before" value="<%=findjobSearchBean.getBefore()%>">      			  			      			      						
  			<input type="hidden" name="all_search" value="<%=EnDecoding.decoding(findjobSearchBean.getAll_search())%>"> 
  			<input type="hidden" name="all_search_range" value="<%=findjobSearchBean.getAll_search_range()%>">       
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" height="40" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="5%"><a href="Index"><img src="jsp/images/new/home_icon.gif" width="16" height="16" align="absmiddle"/>Home</a></td>
						<td width="61%" style="padding-top:3px;"> 
							<!-- 현재위치표시-->
							&nbsp;&gt;&nbsp;<a href="javascript:goDirectTopMenu('9');">구직</a>
							<!--&gt;
							<select name="topMenu" id="topMenu" onchange="return goDirectTopMenu();">
		                    	<option value="1">물건사기</option>
		                    	<option value="2">물건팔기</option>
			                    <option value="3">업체찾기</option>
			                    <option value="4">음식점</option>
		                    	<option value="5">호텔/민박</option>
			                    <option value="6">기숙사/룸메이트</option>
			                    <option value="7">부동산</option>
			                    <option value="8">구인</option>
			                    <option value="9" selected="selected">구직</option>
							</select>-->
						</td>
						<td width="37%" align="right" style="padding-top:3px;">
							<!--목록버튼 -->
							<c:if test="${FindjobSearchBean.before == 'search'}">
		              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>	
							<c:if test="${FindjobSearchBean.before == 'search_all'}">
		              			<a href="javascript:backSearchAllPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>	
							<c:if test="${FindjobSearchBean.before == 'mysearch'}">
							 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;							
							</c:if>
							<c:if test="${FindjobSearchBean.before == 'my_write'}">
							 	<a href="javascript:backMyWrite();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;							
							</c:if>
							<!--전의페이지가 메인화면일경우 -->
							<c:if test="${FindjobSearchBean.before == 'new_write'}">
		  						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>								
							<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
							<c:if test="${FindjobBean.user_id == memberInfo.userid}">
								<a href="javascript:openUpdate('${FindjobBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
								<a href="javascript:deleteCheck('${FindjobBean.id}');"><img src="jsp/images/new/btn_delete.gif"></a>
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
					<table id="Table_" width="950" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="67" colspan="3" align="center" background="jsp/images/new/search_content_boxbg.gif">
							<table width="96%" border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td align="left">${util:getNewImage(FindjobBean.update_dateTime)}
									<span class="detail-page">${FindjobBean.title}</span></td>
								<td>&nbsp;</td>
								<td align="right">등록일: <%=Util.getUpdateDateFull(bean.getUpdate_dateTime())%></td>
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
												<td width="15%" align="left" bgcolor="#ececec" class="table-title-text"><strong>희망고용형태<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<!--사원-->
									            	<c:if test="${FindjobBean.work_sort == '1'}">
									            		사원
									            	</c:if>
									            	<!--아르바이트-->
									            	<c:if test="${FindjobBean.work_sort == '2'}">
									            		아르바이트
									            	</c:if>
									            	<c:if test="${FindjobBean.work_sort != '1' and  FindjobBean.work_sort != '2'}">
									            		사원 or 아르바이트
									            	</c:if>&nbsp; 
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>출생년도<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${FindjobBean.birthday}"/>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>성별<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:if test="${FindjobBean.sex == '1'}">
														남
													</c:if>
													<c:if test="${FindjobBean.sex == '2'}">
														여
													</c:if>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>이메일<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<a href="" onclick="mailOpenDetail('${FindjobBean.id}','${FindjobBean.user_name}'); return false;">메일보내기</a>
									            </td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>전화번호1 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${FindjobBean.tel_no1_fname}"/>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>전화번호2 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${FindjobBean.tel_no2_fname}"/>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>등록자 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													 <c:out value="${FindjobBean.user_name}"/>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>조회수<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${FindjobBean.read_count}"/>&nbsp;
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
								<td colspan="3" align="left" valign="top">${FindjobBean.detail_info}&nbsp;</td>
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
				</td>
			</tr>
			<tr>
				<td height="40" align="right">
					<span style="padding-top:3px;">	
						<!--목록버튼 -->
						<c:if test="${FindjobSearchBean.before == 'search'}">
	              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
						</c:if>	
						<c:if test="${FindjobSearchBean.before == 'search_all'}">
	              			<a href="javascript:backSearchAllPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
						</c:if>	
						<c:if test="${FindjobSearchBean.before == 'mysearch'}">
						 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;							
						</c:if>
						<c:if test="${FindjobSearchBean.before == 'my_write'}">
						 	<a href="javascript:backMyWrite();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;							
						</c:if>
						<!--전의페이지가 메인화면일경우 -->
						<c:if test="${FindjobSearchBean.before == 'new_write'}">
	  						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
						</c:if>								
						<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
						<c:if test="${FindjobBean.user_id == memberInfo.userid}">
							<a href="javascript:openUpdate('${FindjobBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
							<a href="javascript:deleteCheck('${FindjobBean.id}');"><img src="jsp/images/new/btn_delete.gif"></a>
						</c:if>
					</span></td>
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

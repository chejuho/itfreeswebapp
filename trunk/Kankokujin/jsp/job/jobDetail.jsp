<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean, common.util.EnDecoding"%>
<%@ page import="job.bean.JobBean, job.bean.JobSearchBean"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<%
	JobBean bean = (JobBean) request.getAttribute("JobBean");
	JobSearchBean jobSearchBean = (JobSearchBean) request.getAttribute("JobSearchBean");
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title>${JobBean.title} ::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
	function goDirectCategory1(category1) {
	 	//var category1 =	document.getElementById("category1").value;
		document.wf.action="JobSearch?re=9&search_cate_code_1=" + category1 + "&search_cate_code_2=";
		document.wf.submit(); 
		return true;
	}
	
	function goDirectCategory2(category1, category2) {
		//var category1 =	document.getElementById("category1").value;
     	//var category2 =	document.getElementById("category2").value;
		document.wf.action="JobSearch?re=9&search_cate_code_1=" + category1 + "&search_cate_code_2=" + category2;
		document.wf.submit(); 
		return true;
	}
   
	function deleteCheck(id){
	
			if(confirm("삭제하시겠습니까?")){
				wf.action="JobDelete?id="+id;
				wf.submit(); 
				return true;
			}
	}
	function openUpdate(id){
		document.wf.action="JobUpdateOpen?id=" + id;
		document.wf.submit(); 
		return true;
	}	
	function setImage(position){
		document.getElementById("disp").src = position;
		return false;
	}	
	function backSearchPage() {
		document.wf.action="JobSearch?re=9&modoru=ok";
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
		document.wf.action="MyWrite?sort=8&modoru=ok";
		document.wf.submit(); 
		return true;
	}
	function goSearchPage() {
		document.wf.action="JobSearch?re=9";
		document.wf.submit(); 
		return true;
	}
	function mailOpenDetail(id,name) {
		mailOpen(id, name, '6');
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
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<form name="wf" method="post">
					<input type="hidden" name="user_id" value="<%=jobSearchBean.getUser_id()%>">      						  
			      	<input type="hidden" name="search_cate_code_1" value="<%=jobSearchBean.getCate_code_1()%>">
					<input type="hidden" name="search_cate_code_2" value="<%=jobSearchBean.getCate_code_2()%>">       		
					<input type="hidden" name="search_sex" value="<%=jobSearchBean.getSex()%>">          			      					 										
					<input type="hidden" name="pageNum" value="<%=jobSearchBean.getPageNum()%>"> 
					<input type="hidden" name="pageSize" value="<%=jobSearchBean.getPageSize()%>">          			      					 				
		   			<input type="hidden" name="search" value="<%=jobSearchBean.getSearch()%>">      			      			
		   			<input type="hidden" name="search_range" value="<%=jobSearchBean.getSearch_range()%>">      			      			
		   			<input type="hidden" name="before" value="<%=jobSearchBean.getBefore()%>">  
					<input type="hidden" name="cate_code_1" value="<%=bean.getCate_code_1()%>">      			    			  			      			      										
		   			<input type="hidden" name="all_search" value="<%=EnDecoding.decoding(jobSearchBean.getAll_search())%>"> 
		   			<input type="hidden" name="all_search_range" value="<%=jobSearchBean.getAll_search_range()%>"> 
					
		  			<input type="hidden" name="photo1" value="${JobBean.photo_path1}">  
		  			<input type="hidden" name="photo2" value="${JobBean.photo_path2}">  
		  			<input type="hidden" name="photo3" value="${JobBean.photo_path3}">  
		  			<input type="hidden" name="photo4" value="${JobBean.photo_path4}">  
		  			<input type="hidden" name="photo5" value="${JobBean.photo_path5}"> 					
					<table width="100%" height="40" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="5%"><a href="Index"><img src="jsp/images/new/home_icon.gif" width="16" height="16" align="absmiddle"/>Home</a></td>
						<td width="61%" style="padding-top:3px;"> 
							<!-- 현재위치표시-->
							&nbsp;&gt;&nbsp;<a href="javascript:goDirectTopMenu('8');">구인</a>
							&nbsp;&gt;&nbsp;<a href="javascript:goDirectCategory1('${JobBean.cate_code_1}');">${JobBean.cate_name_1}</a>
							&nbsp;&gt;&nbsp;<a href="javascript:goDirectCategory2('${JobBean.cate_code_1}', '${JobBean.cate_code_2}');">${JobBean.cate_name_2}</a>
							<!--&gt;
							<select name="topMenu" id="topMenu" onchange="return goDirectTopMenu();">
		                    	<option value="1">물건사기</option>
		                    	<option value="2">물건팔기</option>
			                    <option value="3">업체찾기</option>
			                    <option value="4">음식점</option>
		                    	<option value="5">호텔/민박</option>
			                    <option value="6">기숙사/룸메이트</option>
			                    <option value="7">부동산</option>
			                    <option value="8" selected="selected">구인</option>
			                    <option value="9">구직</option>
							</select>&nbsp;&gt;
							<select name="category1" id="category1" onchange="return goDirectCategory1();">
								<c:forEach var="Category1" items="${Category1List}" varStatus="i">
									<c:if test="${JobBean.cate_code_1 == Category1.cate_code}">
										<option selected value="<c:out value='${Category1.cate_code}'/>"><c:out value="${Category1.cate_name}"/></option>
									</c:if>	
									<c:if test="${JobBean.cate_code_1 != Category1.cate_code}">
										<option value="<c:out value='${Category1.cate_code}'/>"><c:out value="${Category1.cate_name}"/></option>
									</c:if>	
								</c:forEach>
							</select>
							<c:if test="${!empty Category2List}"> &gt;
							<select name="category2" id="category2" onchange="return goDirectCategory2();">
								<c:forEach var="Category2" items="${Category2List}" varStatus="i">
									<c:if test="${JobBean.cate_code_2 == Category2.cate_code_2}">
										<option selected value="<c:out value='${Category2.cate_code_2}'/>"><c:out value="${Category2.cate_name_2}"/></option>
									</c:if>
									<c:if test="${JobBean.cate_code_2 != Category2.cate_code_2}">
										<option value="<c:out value='${Category2.cate_code_2}'/>"><c:out value="${Category2.cate_name_2}"/></option> 
									</c:if>	
								</c:forEach>
							</select>&nbsp;
							</c:if>-->
						</td>
						<td width="37%" align="right" style="padding-top:3px;">
							<!--목록버튼 -->
							<c:if test="${JobSearchBean.before == 'search'}">
		              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>	
							<c:if test="${JobSearchBean.before == 'search_all'}">
		              			<a href="javascript:backSearchAllPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>	
							<c:if test="${JobSearchBean.before == 'mysearch'}">
							 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
							</c:if>
							<c:if test="${JobSearchBean.before == 'my_write'}">
							 	<a href="javascript:backMyWrite();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
							</c:if>
							<!--전의페이지가 메인화면일경우 -->
							<c:if test="${JobSearchBean.before == 'new_write'}">
          						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>							
							<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
							<c:if test="${JobBean.user_id == memberInfo.userid}">
								<a href="javascript:openUpdate('${JobBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
								<a href="javascript:deleteCheck('${JobBean.id}');"><img src="jsp/images/new/btn_delete.gif"></a>
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
								<td align="left">${util:getNewImage(JobBean.update_dateTime)}
									<span class="detail-page"> ${JobBean.title}</span>
								</td>
								<td>&nbsp;</td>
								<td align="right">등록일: <c:out value="${JobBean.updateDateFull}"/></td>
							</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="20" background="jsp/images/new/search_box_left.gif"><img src="jsp/images/new/search_box_left.gif" width="20" height="90" alt="" /></td>
						<td width="910" align="center" style="padding-top:10px;">
							<table border="0" cellspacing="1" cellpadding="0">
							<tr>
								<td valign="top">
									<table width="482" border="0" cellspacing="1" cellpadding="0">
									<tr>
										<td colspan="2" height="366" align="center">
											<img src="${JobBean.photo_path1}" id="disp"/></td>
									</tr>
									<tr>
										<td height="6" colspan="2"></td>
									</tr>
									<tr>
										<td width="392" align="right">
											<img src="${JobBean.photo_path1}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${JobBean.photo_path1}')"  />&nbsp;
											<img src="${JobBean.photo_path2}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${JobBean.photo_path2}')"  />&nbsp;
											<img src="${JobBean.photo_path3}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${JobBean.photo_path3}')"  />&nbsp;
											<img src="${JobBean.photo_path4}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${JobBean.photo_path4}')"  />&nbsp;
											<img src="${JobBean.photo_path5}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${JobBean.photo_path5}')"  /></td>
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
												<td width="30%" align="left" bgcolor="#ececec" class="table-title-text"><strong>회사명</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${JobBean.company_name_k}"/> </td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong> 업종 </strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${JobBean.cate_name_2}"/>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong> 지역정보<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${JobBean.area_fast}"/>
						                          	<c:out value="${JobBean.area_name_1}"/>
						                          	<c:out value="${JobBean.area_name_2}"/>
						                          	<c:out value="${JobBean.area_code_3}"/>&nbsp;<br /></td>
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>노선정보 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${JobBean.lineInfo}"/>&nbsp;</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>홈페이지 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:if test="${!empty JobBean.url}">
														<a href="http://<c:out value="${JobBean.url}"/>" target="_blank">
															<c:out value="${JobBean.url}"/>
														</a>						
													</c:if>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>이메일 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<a href="" onclick="mailOpenDetail('${JobBean.id}','${JobBean.user_name}'); return false;">메일보내기</a>
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>전화번호1</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${JobBean.tel_no1_fname}"/>&nbsp;<br /></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong> 전화번호2 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${JobBean.tel_no2_fname}"/>&nbsp;</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>담당자명 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${JobBean.charge}"/>&nbsp;</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>성별 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:if test="${JobBean.sex == '0'}">
														구분없음
													</c:if>
													<c:if test="${JobBean.sex == '1'}">
														남
													</c:if>
													<c:if test="${JobBean.sex == '2'}">
														여
													</c:if>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>급여조건<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${JobBean.pay}"/>&nbsp;</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>근무시간<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${JobBean.work_time}"/>&nbsp;</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>등록자<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${JobBean.user_name}"/>&nbsp;</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>조회수</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${JobBean.read_count}"/></td>
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
								<td colspan="3" align="left" valign="top">${JobBean.detail_info}&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" align="left" valign="top">&nbsp;</td>
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
					<c:if test="${JobSearchBean.before == 'search'}">
              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
					</c:if>	
					<c:if test="${JobSearchBean.before == 'search_all'}">
              			<a href="javascript:backSearchAllPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
					</c:if>	
					<c:if test="${JobSearchBean.before == 'mysearch'}">
					 	<a href="javascript:backMySearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
					</c:if>
					<c:if test="${JobSearchBean.before == 'my_write'}">
					 	<a href="javascript:backMyWrite();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
					</c:if>
					<!--전의페이지가 메인화면일경우 -->
					<c:if test="${JobSearchBean.before == 'new_write'}">
  						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
					</c:if>							
					<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
					<c:if test="${JobBean.user_id == memberInfo.userid}">
						<a href="javascript:openUpdate('${JobBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
						<a href="javascript:deleteCheck('${JobBean.id}');"><img src="jsp/images/new/btn_delete.gif"></a>
					</c:if>
					</span></td>
			</tr>
			</table>
		</td>
	</tr>
  	<tr>
    	<td height="50">&nbsp;</td>
  	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
</body>
</html>
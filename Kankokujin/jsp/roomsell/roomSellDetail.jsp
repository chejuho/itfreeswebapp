<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="roomsell.bean.RoomBean, roomsell.bean.RoomSearchBean"%>
<%@ page import="common.util.Util"%>
<%@ page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	RoomSearchBean roomSearchBean = (RoomSearchBean) request.getAttribute("RoomSearchBean");
	RoomBean roomBean = (RoomBean) request.getAttribute("RoomBean");
%>
<html>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title>${RoomBean.title}::&nbsp;<fmt:message key="TITLE.title" bundle="${message}"/></title>
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
    
	function backSearchPage() {
		document.wf.action="RoomSellList?re=9&modoru=ok";
		document.wf.submit(); 
		return true;
	}
	function backMySearchPage(ff, obj) {
		ff.submit(); 
		return true;
	}
	function openUpdate(id){
		document.wf.action="RoomSellUpdateOpen?id=" + id;
		document.wf.submit(); 
		return true;
	}	
	function setImage(position){
		document.getElementById("disp").src = position;
		return false;
	}		
	function backMyWrite() {
		<%if("C10001".equals(roomSearchBean.getCate_code_1())){%>
			document.wf.action="MyWrite?sort=5" + "&modoru=ok";
 		<%} else {%>
 			document.wf.action="MyWrite?sort=6" + "&modoru=ok";
 		<%} %>
		document.wf.submit(); 
		return true;
	}	
	function deleteCheck(id, cate_code){
	
			if(confirm("삭제하시겠습니까?")){
				document.wf.action="RoomSellDelete?id="+id + "&search_cate_code_1=" + cate_code;
				document.wf.submit(); 
				return true;
			}
	}
	function goSearchPage() {
		document.wf.action="RoomSellList?re=9";
		document.wf.submit(); 
		return true;
	}
	function mailOpenDetail(id,name) {
		mailOpen(id, name, '4');
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
			<input type="hidden" name="before"	value="<%=roomSearchBean.getBefore()%>">
			<input type="hidden" name="id"	value="<%=roomBean.getId()%>">
   		    <input type="hidden" name="user_id"	value="<%=roomSearchBean.getUser_id()%>">
   		    <input type="hidden" name="room_fee_from" value="<%=roomSearchBean.getRoom_fee_from()%>">
   		    <input type="hidden" name="room_fee_to" value="<%=roomSearchBean.getRoom_fee_to()%>">
   		    <input type="hidden" name="room_sort_0" value="<%=roomSearchBean.getRoom_sort()[0]%>">
   		    <input type="hidden" name="room_sort_1" value="<%=roomSearchBean.getRoom_sort()[1]%>">
   		    <input type="hidden" name="room_sort_2" value="<%=roomSearchBean.getRoom_sort()[2]%>">
   		    <input type="hidden" name="room_sort_3" value="<%=roomSearchBean.getRoom_sort()[3]%>">
   		    <input type="hidden" name="room_sort_4" value="<%=roomSearchBean.getRoom_sort()[4]%>">
   		    <input type="hidden" name="room_sort_5" value="<%=roomSearchBean.getRoom_sort()[5]%>">
   		    <input type="hidden" name="room_sort_6" value="<%=roomSearchBean.getRoom_sort()[6]%>">
   		    <input type="hidden" name="room_sort_7" value="<%=roomSearchBean.getRoom_sort()[7]%>">
   		    <input type="hidden" name="room_sort_8" value="<%=roomSearchBean.getRoom_sort()[8]%>">
   		    <input type="hidden" name="room_sort_9" value="<%=roomSearchBean.getRoom_sort()[9]%>">   		      		      		      		   
   		    <input type="hidden" name="room_sort_10" value="<%=roomSearchBean.getRoom_sort()[10]%>">   		      		      		      		      		   
   		    <input type="hidden" name="cate_code_1" value="<%=roomSearchBean.getCate_code_1()%>">	   		      		   
   		    <input type="hidden" name="search_sex" value="<%=roomSearchBean.getSex()%>">
   		    <input type="hidden" name="search_line_code" value="<%=roomSearchBean.getLine_code()%>">
   		    <input type="hidden" name="search_station_code" value="<%=roomSearchBean.getStation_code()%>">
   		    <input type="hidden" name="search_build_sort" value="<%=roomSearchBean.getBuild_sort()%>">
   		    <input type="hidden" name="search_area_code_1" value="<%=roomSearchBean.getArea_code_1()%>">
   		    <input type="hidden" name="search_area_code_2" value="<%=roomSearchBean.getArea_code_2()%>">   		   
   		    <input type="hidden" name="search_room_type" value="<%=roomSearchBean.getRoom_type()%>">
   		    <input type="hidden" name="search_regist_date" value="<%=roomSearchBean.getRegist_date()%>">
			<input type="hidden" name="pageSize" value="<%=roomSearchBean.getPageSize()%>">          			      					 				      			
   			<input type="hidden" name="pageNum" value="<%=roomSearchBean.getPageNum()%>">    
   			
  			<input type="hidden" name="photo1" value="${RoomBean.photo_path1}">  
  			<input type="hidden" name="photo2" value="${RoomBean.photo_path2}">  
  			<input type="hidden" name="photo3" value="${RoomBean.photo_path3}">  
  			<input type="hidden" name="photo4" value="${RoomBean.photo_path4}">  
  			<input type="hidden" name="photo5" value="${RoomBean.photo_path5}">   	
			<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" height="40" border="0" cellspacing="1" cellpadding="0">
					<tr>
						<td width="5%"><a href="Index"><img src="jsp/images/new/home_icon.gif" width="16" height="16" align="absmiddle"/>Home</a></td>
						<td width="61%" style="padding-top:3px;"> 
							<!-- 현재위치표시-->
							<!--호텔/민박-->
							<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
			                    &nbsp;&gt;&nbsp;<a href="javascript:goDirectTopMenu('5');">호텔/민박</a>
		                    </c:if>
		                     <!--기숙사/룸메이트-->
							<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
		                    	&nbsp;&gt;&nbsp;<a href="javascript:goDirectTopMenu('6');">기숙사/룸메이트</a>
		                    </c:if>	
							<!--&gt;
							<select name="topMenu" id="topMenu" onchange="return goDirectTopMenu();">
		                    	<option value="1">물건사기</option>
		                    	<option value="2">물건팔기</option>
			                    <option value="3">업체찾기</option>
			                    <option value="4">음식점</option>
			                   
								<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
			                    	<option value="5" selected="selected">호텔/민박</option>
			                    	<option value="6">기숙사/룸메이트</option>
			                    </c:if>
								<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
			                    	<option value="5">호텔/민박</option>
			                    	<option value="6" selected="selected">기숙사/룸메이트</option>
			                    </c:if>	
			                    <option value="6">기숙사/룸메이트</option>
			                    <option value="7">부동산</option>
			                    <option value="8">구인</option>
			                    <option value="9">구직</option>
							</select> -->
						</td>
						<td width="37%" align="right" style="padding-top:3px;">
							<!--목록버튼 -->
							<c:if test="${RoomSearchBean.before == 'search'}">
		              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>	
							<c:if test="${RoomSearchBean.before == 'search_all'}">
							 	<a href="javascript:history.back();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
							</c:if>
							<c:if test="${RoomSearchBean.before == 'my_write'}">
							 	<a href="javascript:backMyWrite();"><img src="jsp/images/new/tolist.gif" width="91" /></a>							
							</c:if>
							<!--전의페이지가 메인화면일경우 -->
							<c:if test="${RoomSearchBean.before == 'new_write'}">
          						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
							</c:if>								
							<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
							<c:if test="${RoomBean.user_id == memberInfo.userid}">
								<a href="javascript:openUpdate('${RoomBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
								<a href="javascript:deleteCheck('${RoomBean.id}', '${RoomBean.cate_code_1}');"><img src="jsp/images/new/btn_delete.gif"></a>
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
								<td align="left">
									<span class="detail-page">${util:getNewImage(RoomBean.update_dateTime)}${RoomBean.title}</span></td>
								<td>&nbsp;</td>
								<td align="right">등록일: <c:out value="${RoomBean.updateDateFull}"/></td>
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
											<img src="${RoomBean.photo_path1}" id="disp" onclick="return popup()" />	
										</td>
									</tr>
									<tr>
										<td height="6" colspan="2"></td>
									</tr>
									<tr>
										<td width="392" align="right">
											<img src="${RoomBean.photo_path1}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${RoomBean.photo_path1}')" />&nbsp;
											<img src="${RoomBean.photo_path2}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${RoomBean.photo_path2}')" />&nbsp;
											<img src="${RoomBean.photo_path3}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${RoomBean.photo_path3}')" />&nbsp;
											<img src="${RoomBean.photo_path4}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${RoomBean.photo_path4}')" />&nbsp;
											<img src="${RoomBean.photo_path5}" width="60" height="60" style="border:1px  solid #CCCCCC;" onmouseover="setImage('${RoomBean.photo_path5}')" />
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
												<td width="30%" align="left" bgcolor="#ececec" class="table-title-text"><strong>종별</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
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
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>방물건명</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"><c:out value="${RoomBean.room_name}"/><br /></td>
											</tr>
											<!--기숙사/룸메이트-->
											<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong> 건물종류<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:if test="${RoomBean.build_sort == '0'}">
														아파트(목조)
													</c:if>
													<c:if test="${RoomBean.build_sort == '1'}">
														맨션
													</c:if><br />
												</td>
											</tr>
											</c:if>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong> 지역정보<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${RoomBean.area_fast}"/>
						                          	<c:out value="${RoomBean.area_name_1}"/>
						                          	<c:out value="${RoomBean.area_name_2}"/>
						                          	<c:out value="${RoomBean.area_code_3}"/>
													<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>노선정보 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${RoomBean.lineInfo}"/>
													<c:if test="${!empty RoomBean.walk_time}">
														/도보<c:out value="${RoomBean.walk_time}"/>분
													</c:if>&nbsp;
												</td>
											</tr>
											<!--호텔/민박-->
											<c:if test="${RoomSearchBean.cate_code_1 == 'C10001'}">
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>요금 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${RoomBean.room_fee}"/>
													<c:if test="${!empty RoomBean.room_fee and RoomBean.room_fee != '0'}">
														엔
													</c:if>&nbsp;
													<br />
												</td>
											</tr>
											</c:if>
											<!--기숙사/룸메이트-->
											<c:if test="${RoomSearchBean.cate_code_1 == 'C10002'}">
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>야칭 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${RoomBean.room_fee}"/>
													<c:if test="${!empty RoomBean.room_fee and RoomBean.room_fee != '0'}">
														만엔
													</c:if>
													<c:if test="${RoomBean.fee_unit == '0'}">
														/1개월(공과금 포함)
													</c:if>
													<c:if test="${RoomBean.fee_unit == '1'}">
														/1개월(공과금 미포함) 
													</c:if>
													<c:if test="${RoomBean.fee_unit == '2'}">
														/1일 
													</c:if>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>기타비용 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:if test="${!empty RoomBean.equipment_fee and RoomBean.equipment_fee != '0'}">
														시설비 <c:out value="${RoomBean.equipment_fee}"/>엔<br>
													</c:if>
													<c:if test="${!empty RoomBean.entrance_fee and RoomBean.entrance_fee != '0'}">
														입실료 <c:out value="${RoomBean.entrance_fee}"/>엔<br>
													</c:if>
													<c:if test="${!empty RoomBean.deposit_fee and RoomBean.deposit_fee != '0'}">
														보증금 <c:out value="${RoomBean.deposit_fee}"/>엔<br>
													</c:if>&nbsp;<br />
												</td>
											</tr>
											</c:if>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>방타입 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:if test="${RoomBean.room_type == '0'}">
														1인실
													</c:if>
													<c:if test="${RoomBean.room_type == '1'}">
														2인실
													</c:if>
													<c:if test="${RoomBean.room_type == '2'}">
														다인실 
													</c:if>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>성별</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:if test="${RoomBean.sex == '0'}">
														남
													</c:if>
													<c:if test="${RoomBean.sex == '1'}">
														여
													</c:if>
													<c:if test="${RoomBean.sex == '2'}">
														구분없음
													</c:if>&nbsp;<br />
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>홈페이지<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:if test="${!empty RoomBean.url}">
														<a href="http://<c:out value="${RoomBean.url}"/>" target="_blank"><c:out value="${RoomBean.url}"/></a>
													</c:if>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>이메일 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text"> 
													<a href="" onclick="mailOpenDetail('${RoomBean.id}','${RoomBean.user_name}'); return false;">메일보내기</a>
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>전화번호1 <br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${RoomBean.tel_no1_fname}"/>&nbsp;	
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>전화번호2<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${RoomBean.tel_no2_fname}"/>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>등록자<br /></strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${RoomBean.user_name}"/>&nbsp;
												</td>
											</tr>
											<tr>
												<td align="left" bgcolor="#ececec" class="table-title-text"><strong>조회수</strong></td>
												<td align="left" bgcolor="#FFFFFF" class="table-cont-text">
													<c:out value="${RoomBean.read_count}"/>&nbsp;
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
								<td colspan="3" align="left" valign="top">${RoomBean.detail_info}&nbsp;</td>
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
					<!--목록버튼 -->
					<c:if test="${RoomSearchBean.before == 'search'}">
              			<a href="javascript:backSearchPage();"><img src="jsp/images/new/tolist.gif" width="91"/></a>&nbsp;
					</c:if>	
					<c:if test="${RoomSearchBean.before == 'search_all'}">
					 	<a href="javascript:history.back();"><img src="jsp/images/new/tolist.gif" width="91"/></a>							
					</c:if>
					<c:if test="${RoomSearchBean.before == 'my_write'}">
					 	<a href="javascript:backMyWrite();"><img src="jsp/images/new/tolist.gif" width="91"/></a>							
					</c:if>
					<!--전의페이지가 메인화면일경우 -->
					<c:if test="${RoomSearchBean.before == 'new_write'}">
  						<a href="javascript:goSearchPage();"><img src="jsp/images/new/tolist.gif" width="91" /></a>&nbsp;
					</c:if>						
					<!--수정 삭제버튼 로그인 ID와작성자ID가 일치할경우 -->
					<c:if test="${RoomBean.user_id == memberInfo.userid}">
						<a href="javascript:openUpdate('${RoomBean.id}');"><img src="jsp/images/new/btn_edit.gif"></a> &nbsp;
						<a href="javascript:deleteCheck('${RoomBean.id}', '${RoomBean.cate_code_1}');"><img src="jsp/images/new/btn_delete.gif"></a>
					</c:if>
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
</body>
</html>
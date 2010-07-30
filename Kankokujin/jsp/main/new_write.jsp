<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>	
<%@ page import="common.bean.PageBean, store.bean.StoreBean"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%

	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	MemberBean member = new MemberBean();
	member.setUserid("-");
	if(session.getAttribute("memberInfo")!=null){
		member = (MemberBean) session.getAttribute("memberInfo");	
	}
%>
<html>
<head>
<script type="text/javascript">
<!--
	
//-->
</script>
<script src="jsp/include/js/prototype.js" type="text/javascript" ></script>
<script src="jsp/include/js/src/scriptaculous.js?effets" type="text/javascript" ></script>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script src="jsp/include/js/commonFunction.js" type="text/javascript"></script>
<script language="javascript">

	function openDetailPage(obj, id) {
		if(obj == 1){
			document.list.action="BuySellDetail?id=" +id +"&before=new_write&search_cate_code_1=C10100";
		} else if (obj == 2){
			document.list.action="BuySellDetail?id=" +id +"&before=new_write&search_cate_code_1=C10200";
		} else if (obj == 3){
			document.list.action="StoreDetail?before=new_write&id="+id;
		} else if (obj == 4){
			document.list.action="GourmetDetail?id=" +id + "&before=new_write";
		} else if (obj == 5){
			document.list.action="RoomSellDetail?id=" +id +"&before=new_write";
		} else if (obj == 6){
			document.list.action="HouseSellDetail?id=" +id + "&before=new_write";
		} else if (obj == 7){
			document.list.action="JobDetail?id=" +id +"&before=new_write";
		} else if (obj == 8){
			document.list.action="FindjobDetail?id=" +id +"&before=new_write";
		} else if (obj == 9){
			document.list.action="InformDetail?id=" +id +"&before=new_write";
		}
		
		document.list.submit(); 
		return true;
	}
	function saveid(form) {
		var expdate = new Date();
		if (form.checksaveid.checked) {
			expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30);
		} else {
			expdate.setTime(expdate.getTime() - 1);
			
		}
		setCookie("saveid", form.id.value, expdate);
	}
	function getid(form) {
		lf.checksaveid.checked = ((form.id.value = getCookie("saveid")) != "");
	}

</script>	
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<html>	
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
	<head>
		<title><fmt:message key="TITLE.title" bundle="${message}"/></title>
	</head>
	<body style="margin:0 0 0 0" onload="getid(document.lf)">
	<table>
	<jsp:include page="../include/top.jsp" flush="true" />
	<!-- START -->
	<tr>
		<td height="10"></td>
	</tr>
    <tr>
    	<td>
    		<!-- Main START -->
    		<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
      		<tr>
      			<!-- LEFT START -->
        		<td width="224" valign="top">
        			<jsp:include page="../include/left.jsp" flush="true" />
				</td>
				<form name="list" method="post" style="margin:0">
  				<!-- CENTER START -->	
  				<td width="538" align="center" valign="top">
					<table width="523" border="0" cellspacing="0" cellpadding="0">
					<!-- 물건사기、물건팔기 START -->
					<tr>
            			<td width="261">
							<table width="259" height="120" border="0" cellpadding="0" cellspacing="0">
              				<tr>
                				<td valign="top"  background="jsp/images/new/main_b_a.gif" style="padding:8px 12px 8px 12px;">
                				<table width="100%" border="0" cellspacing="0" cellpadding="0">
                				<a href="BuySellList?re=9&search_cate_code_1=C10100">
			                  	<tr style="cursor:hand">
				                    <td width="76%" height="20" align="left" class="main-notice-tit1">물건사기</td>
				                    <td width="24%" align="right" valign="bottom">
				                    	<a href="BuySellList?re=9&search_cate_code_1=C10100"><img src="jsp/images/new/main_b_moreb.gif" width="40" height="16" /></a></td>
			                  	</tr>
			                  	</a>
			                  	<tr>
			                    	<td height="10" colspan="2"></td>
			                    </tr>
			                  	<tr>
				                    <td align="left" valign="top">
				                    	<!-- 물건사기 타이틀  -->
										<c:forEach var="BuyBean" items="${BuyBeanList}" >
											<c:out value="·" />
										 	<a href="javascript:openDetailPage(1, '${BuyBean.id}');" class="notice-link">
										 		<c:out value="${util:cutLongName(12, BuyBean.title)}" />
											</a><br />
										</c:forEach>
									</td>
				                    <td align="right" valign="top">
				                    	<!-- 물건사기 등록시간  -->
				                    	<c:forEach var="BuyBean" items="${BuyBeanList}" varStatus="status">
                							<c:out value="${BuyBean.update_date}" /><br />
                							<c:if test="${status.last and 3 > status.index}">
												<c:forEach begin="1" end="${3 - status.index}" step="1">
													<br />
												</c:forEach>
  											</c:if>
					                    </c:forEach>
									</td>
			                  </tr>
								</table></td>
							</tr>
							</table>
						</td>
						<td width="259" align="right" >
							<table width="259" height="120" border="0" cellpadding="0" cellspacing="0">
							<tr>
                				<td valign="top" background="jsp/images/new/main_b_a.gif" style="padding:8px 12px 8px 12px;">
                					<table width="100%" border="0" cellspacing="0" cellpadding="0">
                					<a href="BuySellList?re=9&search_cate_code_1=C10200">
                  					<tr style="cursor:hand">
                    					<td width="76%" height="20" align="left" class="main-notice-tit1">물건팔기</td>
                    					<td width="24%" align="right" valign="bottom">
                    					<a href="BuySellList?re=9&search_cate_code_1=C10200"><img src="jsp/images/new/main_b_moreb.gif" alt="" width="40" height="16" /></a></td>
                  					</tr>
                  					</a>
									<tr>
										<td height="10" colspan="2"></td>
									</tr>
									<tr>
                    					<td align="left" valign="top">
				                    		<!-- 물건팔기 타이틀  -->                    					
                    						<c:forEach var="SellBean" items="${SellBeanList}" >
												<c:out value="·" />
											 	<a href="javascript:openDetailPage(2, '${SellBean.id}');" class="notice-link">
											 		<c:out value="${util:cutLongName(12, SellBean.title)}" />
												</a><br />
											</c:forEach>
										</td>
					                    <td align="right" valign="top">
				                    		<!-- 물건팔기 등록시간  --> 					                    
					                    	<c:forEach var="SellBean" items="${SellBeanList}" varStatus="status">
	                							<c:out value="${SellBean.update_date}" /><br />
	                							<c:if test="${status.last and 3 > status.index}">
													<c:forEach begin="1" end="${3 - status.index}" step="1">
														<br />
													</c:forEach>
	  											</c:if>
					                    	</c:forEach>
			                     		</td>
									</tr>
									</table>
								</td>
							</tr>
							</table>
						</td>
					</tr>
          			<tr>
            			<td height="5" colspan="2"></td>
        			</tr>
        			<!-- 업체찾기、음식점 START -->
          			<tr>
            			<td>
            				<table width="259" height="120" border="0" cellpadding="0" cellspacing="0">
              				<tr>
                				<td valign="top"  background="jsp/images/new/main_b_b.gif" style="padding:8px 12px 8px 12px;">
                					<table width="100%" border="0" cellspacing="0" cellpadding="0">
                					<a href="StoreSearch?re=9">
									<tr style="cursor:hand">
					                    <td width="76%" height="20" align="left" class="main-notice-tit2">업체찾기</td>
					                    <td width="24%" align="right" valign="bottom">
					                    	<a href="StoreSearch?re=9"><img src="jsp/images/new/main_b_moreb.gif" width="40" height="16" /></a></td>
				                  	</tr>
				                  	</a>
				                  	<tr>
				                    	<td height="10" colspan="2"></td>
				                  	</tr>
                  					<tr>
                    					<td align="left" valign="top">
				                    		<!-- 업체찾기 이름  -->                        					
                    						<c:forEach var="Store" items="${StoreBeanList}" >
												<c:out value="·" />
											 	<a href="javascript:openDetailPage(3, '${Store.id}');" class="notice-link">
													<c:out value="${util:cutLongName(12, Store.store_full_name)}" />
												</a><br />
											</c:forEach>
										</td>
					                    <td align="right" valign="top">
				                    		<!-- 업체찾기 등록시간  --> 					                    
					                    	<c:forEach var="StoreBean" items="${StoreBeanList}" varStatus="status">
	                							<c:out value="${StoreBean.update_date}" /><br />
	                							<c:if test="${status.last and 3 > status.index}">
													<c:forEach begin="1" end="${3 - status.index}" step="1">
														<br />
													</c:forEach>
	  											</c:if>
					                    	</c:forEach>
										</td>
                  					</tr>
            						</table>
            					</td>
          					</tr>
            				</table>
            			</td>
            			<td align="right">
            				<table width="259" height="120" border="0" cellpadding="0" cellspacing="0">
              				<tr>
                				<td valign="top"  background="jsp/images/new/main_b_b.gif" style="padding:8px 12px 8px 12px;">
                					<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<a href="GourmetSearch?re=9">
									<tr style="cursor:hand">
										<td width="76%" height="20" align="left" class="main-notice-tit2">음식점</td>
										<td width="24%" align="right" valign="bottom">
											<a href="GourmetSearch?re=9"><img src="jsp/images/new/main_b_moreb.gif" width="40" height="16" /></a></td>
									</tr>
									</a>
									<tr>
										<td height="10" colspan="2"></td>
									</tr>
                  					<tr>
                    					<td align="left" valign="top">
                    						<!-- 음식점 타이틀  -->                        					
                    						<c:forEach var="GourmetBean" items="${GourmetBeanList}" >
												<c:out value="·" />
											 	<a href="javascript:openDetailPage(4, '${GourmetBean.id}');" class="notice-link">
											 		<c:out value="${util:cutLongName(12, GourmetBean.store_full_name)}" />
												</a><br />
											</c:forEach>
										</td>
					                    <td align="right" valign="top">
					                    	<!-- 음식점 등록시간  --> 					                    
					                    	<c:forEach var="GourmetBean" items="${GourmetBeanList}" varStatus="status">
	                							<c:out value="${GourmetBean.update_date}" /><br />
	                							<c:if test="${status.last and 3 > status.index}">
													<c:forEach begin="1" end="${3 - status.index}" step="1">
														<br />
													</c:forEach>
	  											</c:if>
					                    	</c:forEach>
										</td>
                  					</tr>
                					</table>
                				</td>
          					</tr>
            				</table>
            			</td>
          			</tr>
          			<tr>
            			<td height="5" colspan="2"></td>
            		</tr>
            		<!-- 호텔/민박、기숙사/룸메이트 START -->
          			<tr>
            			<td>
            				<table width="259" height="120" border="0" cellpadding="0" cellspacing="0">
              				<tr>
                				<td valign="top" background="jsp/images/new/main_b_a.gif" style="padding:8px 12px 8px 12px;">
                					<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<a href="RoomSellList?re=9&cate_code_1=C10001">
									<tr style="cursor:hand">
										<td width="76%" height="20" align="left" class="main-notice-tit1">호텔/민박</td>
										<td width="24%" align="right" valign="bottom">
											<a href="RoomSellList?re=9&cate_code_1=C10001"><img src="jsp/images/new/main_b_moreb.gif" width="40" height="16" /></a></td>
									</tr>
									</a>
									<tr>
										<td height="10" colspan="2"></td>
									</tr>
                  					<tr>
                    					<td width="46%" align="left" valign="top">
                    						<!-- 호텔/민박 타이틀  -->                        					
                    						<c:forEach var="RoomBean" items="${RoomBeanList1}" >
                    							<c:if test="${RoomBean.cate_code_1 == 'C10001'}">
													<c:out value="·" />
												 	<a href="javascript:openDetailPage(5, '${RoomBean.id}');" class="notice-link">
												 		<c:out value="${util:cutLongName(12, RoomBean.title)}" />
													</a><br />
												</c:if>
											</c:forEach>
										</td>
										<!--<td width="30%" align="right" valign="top">
											 
											<c:forEach var="RoomBean" items="${RoomBeanList1}" >
												<c:if test="${RoomBean.cate_code_1 == 'C10001'}">
													<c:if test="${RoomBean.cate_code_1 == 'C10001' and !empty RoomBean.room_fee}">
														<c:out value="${RoomBean.room_fee}" />엔
													</c:if>
													<br />
												</c:if>
											</c:forEach>
										</td>-->
					                    <td align="right" valign="top">
											<!-- 호텔/민박 등록시간   --> 					                    
					                    	<c:forEach var="RoomBean" items="${RoomBeanList1}" varStatus="status">
					                    		<c:if test="${RoomBean.cate_code_1 == 'C10001'}">
		                							<c:out value="${RoomBean.update_date}" /><br />
		                							<c:if test="${status.last and 3 > status.index}">
														<c:forEach begin="1" end="${3 - status.index}" step="1">
															<br />
														</c:forEach>
		  											</c:if>
		  										</c:if>
					                    	</c:forEach>
										</td>
									</tr>
									</table>
								</td>
							</tr>
        					</table>
        				</td>
            			<td align="right">
            				<table width="259" height="120" border="0" cellpadding="0" cellspacing="0">
             	 			<tr>
                				<td valign="top" background="jsp/images/new/main_b_a.gif" style="padding:8px 12px 8px 12px;">
                					<table width="100%" border="0" cellspacing="0" cellpadding="0">
                					<a href="RoomSellList?re=9&cate_code_1=C10002">
									<tr style="cursor:hand">
										<td width="76%" colspan="1" height="20" align="left" class="main-notice-tit1">기숙사/룸메이트</td>
										<td width="24%" align="right" valign="bottom">
											<a href="RoomSellList?re=9&cate_code_1=C10002"><img src="jsp/images/new/main_b_moreb.gif" width="40" height="16" /></a></td>
									</tr>
									</a>
									<tr>
										<td height="10" colspan="2"></td>
									</tr>
                  					<tr>
                    					<td width="54%" align="left" valign="top">
                    						<!-- 기숙사/룸메이트  타이틀-->                        					
                    						<c:forEach var="RoomBean" items="${RoomBeanList2}" >
                    							<c:if test="${RoomBean.cate_code_1 == 'C10002'}">
													<c:out value="·" />
												 	<a href="javascript:openDetailPage(5, '${RoomBean.id}');" class="notice-link">
												 		<c:out value="${util:cutLongName(12, RoomBean.title)}" />
													</a><br />
												</c:if>
											</c:forEach>
										</td>
										<!--<td width="22%" align="right" valign="top"> 
											<c:forEach var="RoomBean" items="${RoomBeanList2}" >
												<c:if test="${RoomBean.cate_code_1 == 'C10002'}">
													<c:if test="${RoomBean.cate_code_1 == 'C10002' and !empty RoomBean.room_fee}">
														<c:out value="${RoomBean.room_fee}" />만엔
													</c:if>
													<br />
												</c:if>
											</c:forEach>
										</td>-->
					                    <td align="right" valign="top">
					                    	<!-- 기숙사/룸메이트 등록시간   --> 					                    
					                    	<c:forEach var="RoomBean" items="${RoomBeanList2}" varStatus="status">
					                    		<c:if test="${RoomBean.cate_code_1 == 'C10002'}">
		                							<c:out value="${RoomBean.update_date}" /><br />
		                							<c:if test="${status.last and 3 > status.index}">
														<c:forEach begin="1" end="${3 - status.index}" step="1">
															<br />
														</c:forEach>
		  											</c:if>
		  										</c:if>
					                    	</c:forEach>
					                    </td>
              						</tr>
                					</table>
                				</td>
          					</tr>
        					</table>
    					</td>
      				</tr>
          			<tr>
            			<td height="5" colspan="2"></td>
            		</tr>
            		<!-- 부동산、구인 START -->            		
          			<tr>
            			<td>
            				<table width="259" height="120" border="0" cellpadding="0" cellspacing="0">
              				<tr>
                				<td valign="top" background="jsp/images/new/main_b_b.gif" style="padding:8px 12px 8px 12px;">
                					<table width="100%" border="0" cellspacing="0" cellpadding="0">
                					<a href="HouseSellList?re=9">
				                  	<tr style="cursor:hand">
				                    	<td width="76%" colspan="1" height="20" align="left" class="main-notice-tit2">부동산</td></a>
				                    	<td width="24%" align="right" valign="bottom"><a href="HouseSellList?re=9"><img src="jsp/images/new/main_b_moreb.gif" width="40" height="16" /></a></td>
				                  	</tr>
				                  	</a>
				                  	<tr>
				                    	<td height="10" colspan="2"></td>
				                  	</tr>
                  					<tr>
                    					<td width="42%" align="left" valign="top">
                    						<!-- 부동산  타이틀-->                        					
                    						<c:forEach var="HouseBean" items="${HouseBeanList}" >
												<c:out value="·" />
											 	<a href="javascript:openDetailPage(6, '${HouseBean.id}');" class="notice-link">
											 		<c:out value="${util:cutLongName(12, HouseBean.title)}" />
												</a><br />
											</c:forEach>
										</td>
										<!--<td width="34%" align="left" valign="top">
											<c:forEach var="HouseBean" items="${HouseBeanList}" >
												 <c:choose>
													<c:when test="${HouseBean.madori == '0'}">
														<c:out value="1R" />
													</c:when>
													<c:when test="${HouseBean.madori == '1'}">
														<c:out value="1K" />
													</c:when>
													<c:when test="${HouseBean.madori == '2'}">
														<c:out value="1DK" />
													</c:when>
													<c:when test="${HouseBean.madori == '3'}">
														<c:out value="1LDK" />
													</c:when>
													<c:when test="${HouseBean.madori == '4'}">
														<c:out value="2K" />
													</c:when>
													<c:when test="${HouseBean.madori == '5'}">
														<c:out value="2DK" />
													</c:when>
													<c:when test="${HouseBean.madori == '6'}">
														<c:out value="2LDK" />
													</c:when>
													<c:when test="${HouseBean.madori == '7'}">
														<c:out value="3DK" />
													</c:when>
													<c:when test="${HouseBean.madori == '8'}">
														<c:out value="3LDK" />
													</c:when>
													<c:when test="${HouseBean.madori == '9'}">
														<c:out value="4DK" />
													</c:when>
													<c:when test="${HouseBean.madori == '10'}">
														<c:out value="4LDK" />
													</c:when>
													<c:otherwise>
														<c:out value="기타" />
													</c:otherwise>
												</c:choose>
												 <c:if test="${HouseBean.cate_code_1 == 'C10002' and !empty HouseBean.room_fee}">
													<c:out value="${HouseBean.room_fee}" />만엔
												</c:if>
												<br /> 
											</c:forEach>
										</td>-->
					                    <td align="right" valign="top">
					                    	<!-- 부동산 등록시간   --> 					                    
					                    	<c:forEach var="HouseBean" items="${HouseBeanList}" varStatus="status">
	                							<c:out value="${HouseBean.update_date}" /><br />
	                							<c:if test="${status.last and 3 > status.index}">
													<c:forEach begin="1" end="${3 - status.index}" step="1">
														<br />
													</c:forEach>
	  											</c:if>
					                    	</c:forEach>
										</td>
                  					</tr>
            						</table>
            					</td>
          					</tr>
            				</table>
            			</td>
            			<td align="right" valign="top">
            				<table width="259" height="120" border="0" cellpadding="0" cellspacing="0">
			              	<tr>
			                	<td valign="top" background="jsp/images/new/main_b_b.gif" style="padding:8px 12px 8px 12px;">
			                		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			                		<a href="JobSearch?re=9">
			                  		<tr style="cursor:hand">
			                    		<td width="76%" height="20" align="left" class="main-notice-tit2">구인</td>
			                    		<td width="24%" align="right" valign="bottom">
			                    			<a href="JobSearch?re=9"><img src="jsp/images/new/main_b_moreb.gif" width="40" height="16" /></a></td>
			                  		</tr>
			                  		</a>
									<tr>
										<td height="10" colspan="2"></td>
									</tr>
                  					<tr>
                    					<td align="left">
                    						<!-- 구인  타이틀-->                        					
                    						<c:forEach var="JobBean" items="${JobBeanList}" >
												<c:out value="·" />
											 	<a href="javascript:openDetailPage(7, '${JobBean.id}');" class="notice-link">
											 		<c:out value="${util:cutLongName(12, JobBean.title)}" />
												</a><br />
											</c:forEach>
										</td>
					                    <td align="right" valign="top">
					                    	<!-- 구인 등록시간   --> 					                    
					                    	<c:forEach var="JobBean" items="${JobBeanList}" varStatus="status">
	                							<c:out value="${JobBean.update_date}" /><br />
	                							<c:if test="${status.last and 3 > status.index}">
													<c:forEach begin="1" end="${3 - status.index}" step="1">
														<br />
													</c:forEach>
	  											</c:if>
					                    	</c:forEach>
										</td>
              						</tr>
            						</table>
            					</td>
          					</tr>
            				</table>            			
            			</td>
      				</tr>
          			<tr>
            			<td height="5" colspan="2"></td>
            		</tr>
            		<!-- 구직 START -->              		
          			<tr>
            			<td>
            				<table width="259" height="120" border="0" cellpadding="0" cellspacing="0">
              				<tr>
                				<td  background="jsp/images/new/main_b_a.gif" style="padding:8px 12px 8px 12px;">
                					<table width="100%" border="0" cellspacing="0" cellpadding="0">
                					<a href="FindjobSearch?re=9">
				                  	<tr style="cursor:hand">
				                    	<td width="76%" height="20" align="left" class="main-notice-tit1">구직</td>
				                    	<td width="24%" align="right" valign="bottom">
				                    		<a href="FindjobSearch?re=9"><img src="jsp/images/new/main_b_moreb.gif" width="40" height="16" /></a></td>
				                  	</tr>
				                  	</a>
				                  	<tr>
				                    	<td height="10" colspan="2"></td>
				                  	</tr>
                  					<tr>
                    					<td align="left">
                    						<!-- 구직  타이틀-->                        					
                    						<c:forEach var="FindjobBean" items="${FindjobBeanList}" >
												<c:out value="·" />
											 	<a href="javascript:openDetailPage(8, '${FindjobBean.id}');" class="notice-link">
											 		<c:out value="${util:cutLongName(12, FindjobBean.title)}" />
												</a><br />
											</c:forEach>
										</td>
					                    <td align="right">
					                    	<!-- 구직 등록시간   --> 					                    
					                    	<c:forEach var="FindjobBean" items="${FindjobBeanList}" varStatus="status">
	                							<c:out value="${FindjobBean.update_date}" /><br />
	                							<c:if test="${status.last and 3 > status.index}">
													<c:forEach begin="1" end="${3 - status.index}" step="1">
														<br />
													</c:forEach>
	  											</c:if>
					                    	</c:forEach>
				                      	</td>
                  					</tr>
            						</table>
            					</td>
          					</tr>
            				</table>
            			</td>
            			<td>&nbsp;</td>
          			</tr>
        			</table>
        		</td>
        		</form>
  				<!-- RIGHT START -->
        		<td width="188" valign="top">
        			<jsp:include page="../include/right.jsp" flush="true" />
        		</td>
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
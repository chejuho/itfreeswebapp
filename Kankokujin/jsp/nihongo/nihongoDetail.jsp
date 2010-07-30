<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.MemberBean, common.util.EnDecoding"%>
<%@ page import="store.bean.StoreBean, store.bean.StoreSearchBean"%>
<%@page import="category.bean.CategoryBean"%>
<%@ page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@page import="menu.Constant.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//StoreBean bean = (StoreBean) request.getAttribute("StoreBean");
	//CategoryBean categoryBean = (CategoryBean) request.getAttribute("CategoryBean");
	//StoreSearchBean storeSearchBean = (StoreSearchBean) request.getAttribute("StoreSearchBean");
	
%>

<script type="text/javascript">
<!--

	/* 
	 * リストへ 
	 */
	function backSearchPage(key, menuNo) {
		document.wf.action="MenuSearch?"+ key + "="+menuNo;
		document.wf.submit(); 
		return true;
	}
	/* 
	 * 大きく見る
	 */
    function popup(img) {
	    var str = document.getElementById("disp").src;
		wo = window.open(str.replace("/M_", "/L_"), "popup", "toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, left=0,top=0 border=0");
		wo.resizeTo("1000","780");
		return;
	}
	/* 
	 * 修正画面
	 */
	function openUpdate(id,key, menuNo){
		document.wf.action="MenuUpdateOpen?" + key + "="+menuNo + "&id="+ id;
		document.wf.submit(); 
		return true;
	}	
	
	/* 
	 * メールOPEN 
	 */
	function mailOpen(id, email) {
		var url ="MailSendOpen?id=" + id + "&email="+email;
		var newWindow =  window.open(url, "メール", "width = 550, height=400, location=no, toolbar=no");
		newWindow.moveTo(0,0);
	}
	
	
	
	function deleteCheck(id, wf){
	
			if(confirm("삭제하시겠습니까?")){
				wf.action="StoreDelete?id="+id;
				wf.submit(); 
				return true;
			}
	}
	
	function setImage(position){
		document.getElementById("disp").src = position;
		return false;
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
		document.wf.action="MyWrite?sort=3";
		document.wf.submit(); 
		return true;
	}	
//-->
</script>
<html>
<head>
<title><%=Const.PAGE_MAIN_TITLE%></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>

<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet"
	type="text/css">
</head>

<body>
<div id="container" align="center">
   <div id="top">
		<jsp:include page="../include/top.jsp" flush="true" />
   </div>
   <div id="body">
	    <form name="wf" method="post">
      			<table border="0" cellspacing="0" cellpadding="0">
  				 <tr>
  				  	<td>
  				  		<img src="jsp/images/common/one_point_square.gif">
  				  		<img src="jsp/images/common/title_store_large.gif">
  				  		<img src="jsp/images/common/title_details.gif">
  				  	</td>
 				 </tr>
  				<tr>
    				<td><img src="jsp/images/common/title_line.gif"></td>
 				 </tr>
				</table>
				<br>
				<table border="1" rules="rows" cellpadding="0" cellspacing="0" width="950">		
					<!-- 학원명 -->			
					<tr>
						<td height="70" style="padding-left:20";>
							<font size="2" color="blue"><c:out value="${menuBean['school_name_k']}"/></font>&nbsp;&nbsp;&nbsp;&nbsp;
							<font size="3"><c:out value="${menuBean['school_name_j']}"/></font>
						</td>
					</tr>									
				</table>
				<table border="1" frame="vsides" cellpadding="0" cellspacing="0" width="950">	
					<tr>
						<td>				
							<table border="0">			
								<tr>
									<td>
										<table border="0" height = "525">
											<tr>
												<td align="center" height="400" colspan="2">
													<img src="<c:out value="${menuBean['photo_name1']}"/>" id="disp" onclick="return popup()">
												</td>								
											</tr>
											<tr>
												<td width="445" align="center">
													<img src="<c:out value="${menuBean['photo_name1']}"/>" alt="" width="60" height="51" 
															onClick="setImage('<c:out value="${menuBean['photo_name1']}"/>')">
													<img src="<c:out value="${menuBean['photo_name2']}"/>" alt="" width="60" height="51" 
															onClick="setImage('<c:out value="${menuBean['photo_name2']}"/>')">
													<img src="<c:out value="${menuBean['photo_name3']}"/>" alt="" width="60" height="51" 
															onClick="setImage('<c:out value="${menuBean['photo_name3']}"/>')">
													<img src="<c:out value="${menuBean['photo_name4']}"/>" alt="" width="60" height="51" 
															onClick="setImage('<c:out value="${menuBean['photo_name4']}"/>')">
													<img src="<c:out value="${menuBean['photo_name5']}"/>" alt="" width="60" height="51" ]
															onClick="setImage('<c:out value="${menuBean['photo_name5']}"/>')">
												</td>
													<td align="right" valign="top">
													<!-- 크게보기 -->
														<img src="jsp/images/common/btn_big_image_view.gif" onclick="return popup()">
													</td>											
											</tr>
										</table>
									</td>				
								</tr>	
							</table>
						</td>
					<td>
						<table border="1" frame="void" rules="rows" cellpadding="0" cellspacing="0" width="400">	
						    <!-- 지역정보 -->
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">지역정보</font>
								</td>
								<td style="padding-left:5";>
									<c:choose>
										<c:when test="${empty Area1[menuBean['area_code1']]}">
										</c:when>
										<c:otherwise>
											<c:out value="${Area1[menuBean['area_code1']]}"/>
											<c:out value="${Area2[menuBean['area_code2']]}"/>
											<c:out value="${menuBean['area_info']}"/>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<!-- 노선정보 -->									
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">노선정보</font>
								</td>
								<td style="padding-left:5";>
									<c:if test="${!empty Line[menuBean['line_code']]}">
										<c:if test="${!empty Station[menuBean['station_code']]}">
											<c:out value="${Line[menuBean['line_code']]}"/><c:out value="/"/>
											<c:out value="${Station[menuBean['station_code']]}"/>
										</c:if>
									</c:if>
								</td>
							</tr>
							<!-- 전화번호 -->				
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">전화번호</font>
								</td>
								<td style="padding-left:5";>
									<c:out value="${menuBean['tel_no']}"/>
								</td>
							</tr>
							<!-- 팩스 -->
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">팩스</font>
								</td>
								<td style="padding-left:5";>
									<c:out value="${menuBean['fax_no']}"/>
								</td>
							</tr>
							<!-- 홈페이지 -->					
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">홈페이지</font>
									
								</td>
								<td style="padding-left:5";>
									<c:if test="${!empty menuBean['url']}">
											<a href="http://<c:out value="${menuBean['url']}"/>" target="_blank">
												<c:out value="${menuBean['url']}"/>
											</a>						
										</c:if>
									
								</td>
								<td rowspan="6" align="center" valign="middle"></td>
							</tr>
							<!-- 이메일 -->	
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">이메일</font>
								</td>
								<td style="padding-left:5";>
									<a href="javascript:mailOpen('<c:out value="${menuBean['id']}"/>','<c:out value="${menuBean['email']}"/>');">
										<c:out value="메일보내기"/>
									</a>
									<br>
								</td>
							</tr>
							<!-- 등록비(1/3/6/12개월) -->				
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">등록비(1/3/6/12개월)</font>
								</td>
								<td style="padding-left:5";>
									<c:out value="${menuBean['registrationfee']}"/>
								</td>
							</tr>
							<!-- 입학금(1/3/6/12개월) -->
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">입학금(1/3/6/12개월)</font>
								</td>
								<td style="padding-left:5";>
									<c:out value="${menuBean['entrancefee']}"/>
								</td>
							</tr>	
							<!-- 수업료(1/3/6/12개월) -->
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">수업료(1/3/6/12개월)</font>
								</td>
								<td style="padding-left:5";> 
									<c:out value="${menuBean['lessonsfee']}"/>
								</td>
							</tr>
							<!-- 국적별학생수(한국인/중국인/기타/총정원) -->
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">국적별학생수<br>(한국인/중국인/기타)</font>
								</td>
								<td style="padding-left:5";> 
									<c:out value="${menuBean['studentsu']}"/>
								</td>
							</tr>
							<!-- 총정원 -->
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">정원</font>
								</td>
								<td style="padding-left:5";> 
									<c:out value="${menuBean['totalsu']}"/>
								</td>
							</tr>	
							<!--기숙사유무-->
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">기숙사유무</font>
								</td>
								<td style="padding-left:5";> 
									<c:if test="${menuBean['dormitoryflg'] == 0}">
										<c:out value="무"/>
									</c:if>
									<c:if test="${menuBean['dormitoryflg'] == 1}">
										<c:out value="유"/>
									</c:if>
								</td>
							</tr>	
							<!--등록자-->					
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">등록자</font>
								</td>
								<td style="padding-left:5";>
									<c:out value="${menuBean['user_id']}"/>
								</td>
							</tr>	
							<!--등록일-->						
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">등록일</font>
								</td>
								<td style="padding-left:5";>
									<c:out value="${menuBean['regist_date']}"/>
								</td>
							</tr>	
							<!--조회수-->
							<tr>
								<td width="120" height="35" style="padding-left:20" bgcolor="#F0F0E2">
									<font color="#2961EF">조회수</font>
								</td>
								<td style="padding-left:5";>
									<c:out value="${menuBean['read_count']}"/>
								</td>
							</tr>					
						</table>
					</td>
				</tr>		
		</table>
		<!--특징-->
		<table border="1" rules="rows" cellpadding="0" cellspacing="0" width="950">		
			<tr>
				<td width="120" height="100" style="padding-left:20" bgcolor="#F0F0E2">
					<font color="#2961EF">특징</font>
				</td>
				<td>
					<c:out value="${menuBean['feature']}"/>
				</td>	
			</tr>	
												
		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="950">
			<tr style="padding-top:10">

				<td align="right" colspan="2">
				<img src="jsp/images/common/btn_list.gif" alt="" onclick='return backSearchPage("<%=KEYConst.MENU%>","<%=VALUEConst.NIHONGOMENU%>")'>
				<c:if test="${menuBean['user_id'] == memberInfo['userid']}">
					 &nbsp;
					<img src="jsp/images/common/btn_edit.gif" alt="" 
						onclick='return openUpdate("<c:out value="${menuBean['id']}"/>", "<%=KEYConst.MENU%>", "<%=VALUEConst.NIHONGOMENU%>")'> &nbsp;
				    <img src="jsp/images/common/btn_delete.gif" onclick='return deleteCheck("<c:out value="${menuBean['id']}"/>", wf)'>
				</c:if>
				
				</td>
			</tr>													
		</table>	
		</form>	
   </div>
   <div id="bottom">
		<jsp:include page="../include/footer.jsp" flush="true" />
   </div>   
</div>

</body>

</html>

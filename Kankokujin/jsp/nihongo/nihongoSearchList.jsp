<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.PageBean"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@page import="menu.Constant.*"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
%>
<html>
<head>
<script type="text/javascript">

	/********************************* AJAX処理 Start ***************************************************/
	/* 
	 * 初期化処理 
	 */
	function init() {
		
		//検索
		var index = $F("search_rangeSet");
		if (chk_empty(index)) {
			index = 0;
		}
		$("search_range").options[index].selected = true;

		//AJAX処理
		var areaCode1 = $F("req_area_code1");
		var areaCode2 = $F("req_area_code2");
		var lineCode = $F("req_line_code");
		var stationCode = $F("req_station_code");

		if (chk_empty(areaCode1)) {
			areaCode1 == "00";
		}	
		var param = "param=Search&"+ "areaCode1=" + areaCode1 + "&" + "areaCode2=" + areaCode2 + 
		"&" + "lineCode=" + lineCode +  "&" + "stationCode=" + stationCode;
		
		new Ajax.Request("AjaxAction", 
			{method:"get",
			onComplete:setInit,
			parameters:param });

	}
	
	/* 
	 * 初期化処理 
	 */
	function setInit(resp) {
		var result = resp.responseText.split('<i>');
		setAreaName1(result[0]);
		setAreaName2(result[1]);
		setLineName(result[2]);
		setStationName(result[3]);
	}
	/* 
	 * 地域情報取得 
	 */
	function areaInfo() {
		var param = "param=areaInfo&"+"areaCode1=" +$F("search_area1");
		new Ajax.Request("AjaxAction", 
			{method:"get",
			onComplete:function areaInfoResult(resp) {
						var result = resp.responseText;
						setAreaName2(result);},
			parameters:param });
	}
	/* 
	 * 駅情報取得 
	 */
	function stationInfo() {

		var param = "param=stationInfo&"+"lineCode=" +$F("search_line");
		new Ajax.Request("AjaxAction", 
			{method:"get",
			onComplete:function stationInfoResult(resp) {
							var result = resp.responseText;
							setStationName(result);},
			parameters:param });
	}
	/* 
	 * 地域情報1セット処理 
	 */
	function setAreaName1(res) {
		eval( "var area1 = ("+ res + ")");
		var areaCode1 = $F("req_area_code1");
		$("search_area1").options.length = 0;
		/** 地域１*/
		for (var i = 0; i < area1.length; i++) {
			$("search_area1").options[i] = new Option(area1[i].value, area1[i].name, true, area1[i].name == areaCode1);
		}	
	}
	/* 
	 * 地域情報2セット処理 
	 */
	function setAreaName2(res) {
		eval( "var area2 = ("+ res + ")");
		var areaCode2 = $F("req_area_code2");
		$("search_area2").options.length = 0;
		/** 地域２*/
		for (var i = 0; i < area2.length; i++) {
			$("search_area2").options[i] = new Option(area2[i].value, area2[i].name, true, area2[i].name == areaCode2);
			
		}
	}
	/* 
	 * ラインセット処理 
	 */
	function setLineName(res) {
		eval( "var line = ("+ res + ")");
		var lineCode = $F("req_line_code");
		$("search_line").options.length = 0;
		/** ライン */		
		for (var i = 0; i < line.length; i++) {
			$("search_line").options[i] = new Option(line[i].value, line[i].name, true, line[i].name == lineCode);
			
		}
	}
	/* 
	 * 駅情報セット処理 
	 */
	function setStationName(res) {
		eval( "var station = ("+ res + ")");
		var stationCode = $F("req_station_code");
		$("search_station").options.length = 0;
		/** 駅 */			
		for (var i = 0; i < station.length; i++) {
			$("search_station").options[i] = new Option(station[i].value, station[i].name, true, station[i].name == stationCode);
		}
	}
	/********************************* AJAX処理 End ***************************************************/
	
	
	/* 
	 * 登録ボタンイベント処理 
	 * 引数：Form、menu番号
	 */
	function registOpen(ff, key, menuNo) {
	
		ff.action="MenuRegistOpen?" + key + "="+menuNo;
		ff.submit(); 
		return true;
	}
	/* 
	 * 登録ボタンイベント処理 
	 * 引数：Form、menu番号
	 */
	function openDetailPage(id,key, menuNo) {

		document.list.action="MenuDetail?" + key + "="+menuNo + "&id="+ id;
		document.list.submit(); 
		return true;
	}
	/* 
	 * 検索処理 
	 * 引数：Form、menu番号
	 */	
	function searchMenu(key, menuNo) {
		document.list.action="MenuSearch?" + key + "=" + menuNo + "&kb=vb" ;
		document.list.submit(); 	
		return true;
	}
	
	
	/* 
	 * 整列ボタンイベント処理 
	 * 引数：Form、menu番号
	 */
	function execSort(sortPattern, key, menuNo) {

		document.list.action="MenuSearch?" + key + "="+menuNo + "&sortPattern="+ sortPattern;
		document.list.submit(); 
		return true;
	}
	
	/* 
	 * 整列ボタンイベント処理 
	 * 引数：Form、menu番号
	 */
	function pageSizeOpen(ff, key, menuNo) {
		ff.action="MenuSearch?" + key + "="+menuNo;
		ff.submit(); 
		return true;
	}

	function reloadPage(obj) {
		document.list.action="MenuSearch?ka=va&pageNum="+obj;
		document.list.submit(); 
		return true;
	}
	function chk_empty(str)
	{
 		if ( str.match(/\S/) == null || str.match(/\S/) == "" ) { return(true); }
 		else { return(false);}
	}
window.onload=init;
//-->
</script>
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script language="javascript">
	<%if ("WAR0004".equals(message)) {%>
			alert("<fmt:message key="WAR0004" bundle="${message}"/>");
			window.open('PopLogin', 'notice', 'width=230, height=160');		
	<%	}
	%>
</script>	
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">  
<html>	
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
  <head>
	<title><%=Const.PAGE_MAIN_TITLE%></title>
  </head>
<body style="margin:0 0 0 0">
<div id="container" align="center">

    <div id="top">
		<jsp:include page="../include/top.jsp" flush="true" />
    </div>
    <div id="body">
	<form name="list" method="post" style="margin:0" action="MenuSearchAction">
	   
		<input type="hidden" id="req_area_code1" name = "search_area_code1" value="<c:out value="${searchBean['searchArea1']}"/>">		
		<input type="hidden" id="req_area_code2" name = "search_area_code2" value="<c:out value="${searchBean['searchArea2']}"/>">	
		<input type="hidden" id="req_line_code" name = "search_line_code" value="<c:out value="${searchBean['searchLine']}"/>">       			    
		<input type="hidden" id="req_station_code" name = "search_station_code" value="<c:out value="${searchBean['searchStation']}"/>">
		<input type="hidden" id="search_rangeSet"  value="<c:out value="${searchBean['search_range']}"/>"> 
		
  		<br>
    	<table width="950" border="0" cellspacing="0" cellpadding="0">
    	<tr>
    		<td>
    			<img src="jsp/images/common/one_point.gif"><img src="jsp/images/common/top_info.gif">
    		</td>
    	</tr>    	
    	<tr>
    		<td>
    			<img src="jsp/images/common/top_line.gif">
    		</td>
    	</tr>
    	<tr>
    		<td background="jsp/images/common/center_line.gif">
				<table border="0" bordercolor="#E2E0D6" rules="rows,cols" width="950">
					<tr>
				        <td><!--주소정보,노선정보-->
				        	&nbsp;&nbsp;&nbsp;
							<select id ="search_area1" name="searchArea1" onChange="areaInfo()">
			     			</select>
			     			&nbsp;&nbsp;&nbsp;
			     			<select id ="search_area2" name="searchArea2">
							</select>
							&nbsp;&nbsp;&nbsp;
							<select id = "search_line" name="searchLine" onChange="stationInfo()">
		                   	</select>
		                   	&nbsp;&nbsp;
		     				<select id = "search_station" name="searchStation" >
							</select>
					   </td>
					   <td><!--기숙사유무-->
					   		<c:if test="${searchBean['search_dormitoryflg'] == 'on' }">
					   			<input type="checkbox" name="search_dormitoryflg" checked>기숙사&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   		</c:if>
					   		<c:if test="${searchBean['search_dormitoryflg'] != 'on' }">
					   			<input type="checkbox" name="search_dormitoryflg" >기숙사&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   		</c:if>
							
					   </td>
					   <td><!--검색범위-->
							<select name='search_range'>
								<option value='0' >전체검색</option>
								<option value='1' >학교명</option>
								<option value='2' >특징</option>
							</select>
					  </td>
					  <td><!--검색어-->
							<input type="text" name="search" maxlength="100" value="<c:out value="${searchBean['search']}"/>">
					  </td>
					  <td><!--검색초기화-->
							<a href="MenuSearchAction?<%=KEYConst.MENU%>=<%=VALUEConst.NIHONGOMENU%>">
								<img src="jsp/images/common/btn_search_start.gif" alt="검색조건 초기화">
							</a>
					  </td>
					</tr>
				</table> 
				<!--정렬순서 -->
				<table border="0" bordercolor="#E2E0D6" rules="rows,cols" width="950">
					<tr>
				        <td>
				        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        	<span class="cate_blue" style="background :#FFFFFF" > 표시순서:</span>
				        	<a href="javascript:execSort('0','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
								총비용1달(높은순)
							</a>
							<c:out value="|"/>
							<a href="javascript:execSort('1','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
								총비용1달(낮은순)
							</a>
							<c:out value="|"/>
							<a href="javascript:execSort('2','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
								총비용3달(높은순)
							</a>
							<c:out value="|"/>
							<a href="javascript:execSort('3','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
								총비용3달(낮은순)
							</a>
							<c:out value="|"/>
							<a href="javascript:execSort('4','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
								총비용6달(높은순)
							</a>
							<c:out value="|"/>
							<a href="javascript:execSort('5','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
								총비용6달(낮은순)
							</a>
							<c:out value="|"/>
							<a href="javascript:execSort('6','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
								총비용12달(높은순)
							</a>
							<c:out value="|"/>
							<a href="javascript:execSort('7','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
								총비용12달(낮은순)
							</a>
					  </td>
					</tr>
				</table>  
			</td>	
		</tr>
    	<tr>
    		<td>
    			<img src="jsp/images/common/bottom_line.gif">
    		</td>
    	</tr>	
    	<tr><!--검색버튼 -->
    		<td align="center">
    			<input name="" type="image" src="jsp/images/common/btn_gp_search.gif" alt="검색" 
    			onClick="return searchMenu('<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>')">
    	
    		</td>
    	</tr>	
		</table>
      	<br>
		<table border="0" width="950" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->	
					<table border="0" width="950" cellspacing="0" cellpadding="0">
						<tr>
							<td align="left"><img src="jsp/images/common/one_point.gif" width="6" height="12">
								
								<img src="jsp/images/common/title_info.gif" width="60" height="12">
								<!--<img src="jsp/images/common/title_mywrite.gif">-->
							</td>								
							<td style="padding:0 0px 5 0;" align="right">열람개수 
								<select name='pageSize' onChange="return pageSizeOpen(list, '<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>')">
									<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10</option>
									<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20</option>
									<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50</option>
									<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100</option>
								</select>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="950" cellspacing="0" cellpadding="0">
						<tr>
							<td align="right">
					    		
								<!--목록<img src="jsp/images/common/btn_list.gif" alt="" onclick="return my_write('_')">-->	
								<!--등록-->			    							
				        		<img src="jsp/images/common/btn_regist.gif" onClick="return registOpen(list, '<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>')">
							</td>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td>	
					<table border="1" cellpadding="0" cellspacing="0" width="950" bordercolor="#E2E0D6" rules="rows" style="border-collapse:collapse;">
						<col width="40"  align="center"><!--번호-->
						<col width="50"  align="center"><!--이미지-->
						<col width="160" ><!--학교명-->
						<col width="160" align="center"><!--지역정보/노선정보-->
						<col width="100"  align="center"><!--전화번호-->
						<col width="30"  align="center"><!--홈페이지-->
						<col width="45"  align="center"><!--기숙사유무-->
						<col width="180"  align="center"><!--총비용-->					
						<col width="115" align="center"><!--국적비율-->									
						<col width="50"  align="center"><!--등록일-->
						<tr>
							<td height="4" style="background:#6BACFB;" colspan="14">
							</td>
						</tr>
						<tr height="35" style="font:bold 18px ArialBlack;">
							<td><font color="#82868C">번호</font></td>
							<td><font color="#82868C">이미지</font></td>
							<td align="center"><font color="#82868C">학교명</font></td>
							<td align="center"><font color="#82868C">지역정보<br>/노선정보</font></td>
							<td align="center"><font color="#82868C">전화번호</font></td>
							<td align="center"><font color="#82868C">홈페이지</font></td>
							<td align="center"><font color="#82868C">&nbsp; 기숙사</font></td>
							<td align="center"><font color="#82868C">총비용 &nbsp;[단위:만엔]<br>(1달/3달/6달/12달)</font></td>								
							<td align="center"><font color="#82868C">국적비율<br>(중국인/한국인/기타)</font></td>									
							<td><font color="#82868C">등록일</font></td>
						</tr>
						<tr>
							<td height="3" style="background:#D3E4F9;" colspan="14">
							
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty menuBeanList}">
								<c:forEach var="menuBean" items="${menuBeanList}" >
									<tr height="50">
										<!-- 번호-->
										<td>
											<a href="javascript:openDetailPage('<c:out value="${menuBean['id']}"/>','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
											<c:out value="${menuBean['id']}"/></a>
										</td>
										<!-- 이미지-->
										<td>
											<a href="javascript:openDetailPage('<c:out value="${menuBean['id']}"/>','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
											<img src="<c:out value="${menuBean['photo_name1']}"/>" ></a>
										</td>
										<!-- 학교명-->
										<td style="padding-left:5";>
											<a href="javascript:openDetailPage('<c:out value="${menuBean['id']}"/>','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>');">
											<c:out value="${menuBean['school_name']}"/>
											</a>
										</td>
										<!-- 지역정보/노선정보-->
										<td style="padding-left:5";>
											<c:choose>
												<c:when test="${empty Area1[menuBean['area_code1']]}">
												</c:when>
												<c:when test="${Area1[menuBean['area_code1']] == '東京都23区' }">
													<c:out value="東京都"/>
													<c:out value="${Area2[menuBean['area_code2']]}"/>
												</c:when>
												<c:when test="${Area1[menuBean['area_code1']] == '東京都市部' }">
													<c:out value="東京都"/>
													<c:out value="${Area2[menuBean['area_code2']]}"/>
												</c:when>
												<c:otherwise>
													<c:out value="${Area1[menuBean['area_code1']]}"/>
													<c:out value="${Area2[menuBean['area_code2']]}"/>
												</c:otherwise>
											</c:choose>
										
											
											<br>
											<c:if test="${!empty Line[menuBean['line_code']]}">
												<c:if test="${!empty Station[menuBean['station_code']]}">
													<c:out value="${Line[menuBean['line_code']]}"/><c:out value="/"/>
													<c:out value="${Station[menuBean['station_code']]}"/>
												</c:if>
											</c:if>
										</td>
										<!-- 전화번호-->
										<td align="center">&nbsp;
											<c:out value="${menuBean['tel_no']}"/>
										</td>
										<!-- 홈페이지-->								
										<td style="padding-left:5";>
											<c:if test="${!empty menuBean['url']}">
												<a href="http://${menuBean['url']}" target="_blank">
												<img src="jsp/images/common/icon_website.gif" width="20" height="25"></a>									
											</c:if>
										</td>		
										<!-- 기숙사유무-->								
										<td style="padding-left:5";>
											<c:if test="${menuBean['dormitoryflg'] == 0}">
												<c:out value="무"/>
											</c:if>
											<c:if test="${menuBean['dormitoryflg'] == 1}">
												<c:out value="유"/>
											</c:if>
										</td>
										<!-- 총비용((1달/3달/6달/12달))-->								
										<td style="padding-left:5";><c:out value="${menuBean['totalfee']}" />
										</td>
										<!-- 국적비율(중국인/한국인/기타)-->								
										<td style="padding-left:5";><c:out value="${menuBean['studentsu']}" />
										</td>
										<!-- 등록일-->								
										<td style="padding-left:5";><c:out value="${menuBean['update_date']}" />
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr height="30">
									<td colspan="14">
										<strong>해당 검색 리스트가 없습니다.</strong>
									</td>
								</tr>
    						</c:otherwise>
    					</c:choose>
							
						
						<tr>
							<td height="3" style="background:#66A4EF;" colspan="14">
							</td>
						</tr>
					</table>		
				</td>
			</tr>
			<tr>
				<td>																				
					<table border="0" cellpadding="0" cellspacing="0" height="20" align="center">
						<tr style="padding-top:10">
							<td>
							<%
								if (pageBean.getMaxCount() != 0) {
							%> 검색결과 : <span class="orange"><%=pageBean.getMaxCount()%></span>건중
							<span class="orange"><%=pageBean.getStartCount()%></span>~ <span
								class="orange"><%=pageBean.getEndCount()%></span>건을표시하고 있습니다.</td>
							<%
							}
							%>
						</tr>
						<!-- Page No--> 
						<tr>
							<td align="center" colspan="5">
							<myTags:pageHandle /> 
							</td>
						</tr>					
						<!-- Page No-->
					</table>
					<table width=950 border="0">
						<tr align="right">
							<td>
								<!--<img src="jsp/images/common/btn_list.gif" alt="" onclick="return my_write('_')">	-->	
								<!--등록-->				    		
				        		<img src="jsp/images/common/btn_regist.gif" onClick="return registOpen(list, '<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>')">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>    
    </div>
    <div id="bottom">
    	<jsp:include page="../include/footer.jsp" flush="true"/>
    </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.constant.Const"%>
<%@page import="menu.Constant.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	//StoreBean storeBean = (StoreBean) request.getAttribute("StoreBean");
	//CategoryBean categoryBean = (CategoryBean) request.getAttribute("CategoryBean");
	//StoreSearchBean storeSearchBean = (StoreSearchBean) request.getAttribute("StoreSearchBean");
	MemberBean member = (MemberBean) session.getAttribute("memberInfo");
	//String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	if (member == null) {
%>
<script language="javascript">
				alert("로그인을 해주세요.");
				location.href="";
			</script>
<%
	}
%>
<html>
<head>
<title><%=Const.PAGE_MAIN_TITLE%></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>

<script type="text/javascript"> 

/********************************* AJAX処理 Start ***************************************************/
	/* 
	 * 初期化処理 
	 */
	function init() {
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
    
	function isValidFormat(obj,format) {
		if(obj.value.search(format) != -1) {
			return true;
		}
		return false;
	}
	function radioCheck(value){
 		if(value == "1" ) {
		 	document.wf.area_fast.disabled=false;
		 	document.wf.area_code_1.disabled=true;
		 	document.wf.area_code_2.disabled=true;
	 	}else if(value == "2" ){
 			document.wf.area_fast.disabled=true;
			document.wf.area_code_1.disabled=false;
			document.wf.area_code_2.disabled=false;
		}
	}
	function isNumber(obj) {
		var str = obj.value;
		if(str.length == 0)
			return false;
	
		for(var i=0; i < str.length; i++) {
			if(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
				return false;
		}
		return true;
	}	
	function isPhoneNumber(obj) {
		if(obj.value == "") {
			return true;
		}
		var format = /^(\d+)-(\d+)-(\d+)$/;
		return isValidFormat(obj,format);
	}	
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function isEmail(obj) {
	    var format = /^[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+)*@[0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*$/;
		if (obj.search(format) != -1){
			return true;		
		}else {
			return false;		
		}	
	}
	function isURL(obj) {
		var format = /^([a-z0-9-]+\.)+[a-z0-9]{2,4}.*$/	    
		if (obj.match(format)){
			return true;		
		}else {
			return false;		
		}	
	}		
		
	function storeList(ff) {

		ff.action="StoreList";
		ff.submit(); 
		return true;
	}	
	/* 戻る処理 
	 * 引数：key、menuNo番号
	 */
	function backSearch(id, key, menuNo) {

		document.wf.action="MenuDetail?" + key + "="+menuNo + "&id="+ id;
		document.wf.submit(); 
		return true;
	}
	
	/* 登録処理 
	 * 引数：key、menuNo番号
	 */	
	function updateCheck(ff, key, menuNo) {
		ID = /^[0-9]{1,4}/;
		if(isNull(ff.school_name_k) && isNull(ff.school_name_j)) {
			alert("학교명을 입력해 주세요.");
			return false;
		}
		if(ff.searchArea1.value !="00" && ff.searchArea2.value.substring(2, 4)=="00") {
			alert("지역상세정보를 선택해 주세요.");
			return false;
		} 	
		
		if(ff.line_code.value !="00" && ff.station_code.value.substring(2, 4)=="00") {
			alert("역 정보를 선택해 주세요.");
			return false;
		} 
		if(!isNull(ff.url) && !isURL(ff.url.value)) {
			alert("홈페이지 형식으로 입력해주세요.");
			return false;
		}	
		if(!isNull(ff.email) && !isEmail(ff.email.value)) {
			alert("예)itfrees@itfrees.com형식으로 입력해주세요.");
			return false;
		}
		
		
		ff.action="MenuUpdate?" + key + "=" + menuNo;
		ff.submit(); 
		return true;
	}
	
	/* 削除処理 
	 * 引数：index
	 */	
	function deletePhoto(index) {
		var id = "p" + index;
		var obj = $(id);
		obj.select();
        document.selection.clear();	
	}	
	
	function chk_empty(str)
	{
 		if ( str.match(/\S/) == null || str.match(/\S/) == "" ) { return(true); }
 		else { return(false);}
	}
window.onload=init;
</script>
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
</head>
<!--표시용-->
<input type="hidden" id="req_area_code1"  value="<c:out value="${menuBean['area_code1']}"/>">		
<input type="hidden" id="req_area_code2"  value="<c:out value="${menuBean['area_code2']}"/>">	
<input type="hidden" id="req_line_code"  value="<c:out value="${menuBean['line_code']}"/>">       			    
<input type="hidden" id="req_station_code"  value="<c:out value="${menuBean['station_code']}"/>">
<!--표시용-->
<body style="margin:0 0 0 0">
<div id="container" align="center">
   <div id="top">
		<jsp:include page="../include/top.jsp" flush="true" />
   </div>
   <div id="body">
   	<form name="wf" method="post" enctype="multipart/form-data">
   		<input type="hidden" name="id"  value="<c:out value="${menuBean['id']}"/>">
  	 	<input type="hidden" name="ka" value="va"> 
   		<table border="0" cellspacing="0" cellpadding="0">
  			<tr>
  				<td>
  					<img src="jsp/images/common/one_point_square.gif" />
  					<img src="jsp/images/common/title_store_large.gif" />
  					<img src="jsp/images/common/title_corrent.gif" />
  				</td>
 			</tr>
  			<tr>
				<td>
					<img src="jsp/images/common/title_line.gif" />
				</td>
 			</tr>
		</table>
			<br>
					      			      			      			
		<table border="0" cellpadding="0" cellspacing="0" width="950">
			<tr>
				<td>

				<table border="0" cellpadding="0" cellspacing="0" width="950"　height="20" align="center">
					<tr style="padding-top:15">
						<td>
							※ 필수항목 (<font color=red>*</font>표시)
							만 입력해도 가능합니다. 선택항목을 입력하면 보다 편리한 정보로 검색되실 수 있습니다.
							<br>
							※ 일본어명, 한글명 둘 중 하나만 입력 하셔도 등록이 가능합니다.
						</td>
					</tr>
				</table>

				<table width="950" border="1" rules="rows" align="center" cellpadding="0" cellspacing="0" bordercolor="#E2E0D6" style="border-collapse:collapse;">
					<col width="120" bgcolor="#F0F0E2" style="padding-left:20">
					<col style="padding-left:5">
					<tr height="35"><!--학교명(한글)-->
						<td>
							<font color=red>*</font><font color="#2961EF">학교명(한글)</font>
						</td>
					    <td>
					    	<input type="text" name="school_name_k" value="${menuBean['school_name_k']}" size="30" maxlength="20">
					    </td>	
					</tr>
					<tr height="35"><!--학교명(일본어)-->
						<td>
							<font color=red>*</font><font color="#2961EF">학교명(일본어)</font>
						</td>
					    <td>
					    	<input type="text" name="school_name_j" value="${menuBean['school_name_j']}" size="30" maxlength="20">
					    </td>
					</tr>
					<tr height="35"><!--지역정보-->
						<td height="60">
							<font color="#2961EF">지역정보</font>
						</td>
						<td>
				        	<select id ="search_area1" name="searchArea1" onChange="areaInfo()">
			     			</select>
			     			<select id ="search_area2" name="searchArea2">
							</select>
								
							<br>
							우편번호<input type="text" name="zip_code1"  value="${menuBean['zip_code1']}" size="3" maxlength="3">-
							       <input type="text" name="zip_code2"  value="${menuBean['zip_code2']}"" size="3" maxlength="4">
							 <br>
							나머지주소 <input type="text" name="searchArea3"  value="${menuBean['area_info']}" size="30" maxlength="30"> <br>
						</td>
					</tr>							
					<tr height="35"><!--노선정보-->
						<td>
							<font color="#2961EF">노선정보</font>
						</td>
						<td>
							<select id = "search_line" name="line_code" onChange="stationInfo()">
		                   	</select>
							<select id = "search_station" name="station_code" >
							</select><br>
						</td>
					</tr>
					<tr height="35"><!--홈페이지-->
						<td>
							<font color="#2961EF">홈페이지</font>
						</td>
						<td>
							<font size=2>http://</font><input type="text" name="url" value="${menuBean['url']}" size="30" maxlength="255">
						</td>
					</tr>	
					<tr height="35"><!--이메일-->
						<td><font color="#2961EF">이메일</font></td>
						<td><input type="text" name="email" value="${menuBean['email']}"
							size="30" maxlength="255"></td>
					</tr>
					<tr height="35"><!--전화번호-->
						<td><font
							color=red>*</font><font color="#2961EF">전화번호</font></td>
						<td>
						    <input type="text" name="tel_no_1" value="${menuBean['tel_no_1']}" size="1" maxlength="4" style="ime-mode:inactive" autocomplete="off">-
							<input type="text" name="tel_no_2" value="${menuBean['tel_no_2']}" size="1" maxlength="4" style="ime-mode:inactive" autocomplete="off">-
							<input type="text" name="tel_no_3" value="${menuBean['tel_no_3']}" size="1" maxlength="4" style="ime-mode:inactive" autocomplete="off">
						</td>
					</tr>
					<tr height="35"><!--팩스-->
						<td><font color="#2961EF">팩스</font></td>
						<td><input type="text" name="fax_no_1" value="${menuBean['fax_no_1']}" size="1" maxlength="4" style="ime-mode:inactive" autocomplete="off">-
							<input type="text" name="fax_no_2" value="${menuBean['fax_no_2']}" size="1" maxlength="4" style="ime-mode:inactive" autocomplete="off">-
							<input type="text" name="fax_no_3" value="${menuBean['fax_no_3']}" size="1" maxlength="4" style="ime-mode:inactive" autocomplete="off">
						</td>
					</tr>
					<tr height="35"><!--비용/1개월-->
						<td>
							<font color="#2961EF">비용/1개월</font>
						</td>
						<td>
							선고비 <input type="text"name="registrationfee_1" value="${menuBean['registrationfee_1']}" size="7" maxlength="7">&nbsp;만엔&nbsp; 
							입학금 <input type="text"name="entrancefee_1" value="${menuBean['entrancefee_1']}" size="7" maxlength="7">&nbsp;만엔&nbsp; 
							수업료 <input type="text" name="lessonsfee_1" size="7" value="${menuBean['lessonsfee_1']}" maxlength="7">&nbsp;만엔&nbsp; 		
						</td>
					</tr>
					<tr height="35"><!--비용/3개월-->
						<td>
							<font color="#2961EF">비용/3개월</font>
						</td>
						<td>
							선고비 <input type="text"name="registrationfee_3" value="${menuBean['registrationfee_3']}" size="7" maxlength="7">&nbsp;만엔&nbsp; 
							입학금 <input type="text"name="entrancefee_3" value="${menuBean['entrancefee_3']}" size="7" maxlength="7">&nbsp;만엔&nbsp; 
							수업료 <input type="text" name="lessonsfee_3" size="7" value="${menuBean['lessonsfee_3']}" maxlength="7">&nbsp;만엔&nbsp; 		
						</td>
					</tr>
					<tr height="35"><!--비용/6개월-->
						<td>
							<font color="#2961EF">비용/6개월</font>
						</td>
						<td>
							선고비 <input type="text"name="registrationfee_6" value="${menuBean['registrationfee_6']}" size="7" maxlength="7">&nbsp;만엔&nbsp; 
							입학금 <input type="text"name="entrancefee_6" value="${menuBean['entrancefee_6']}" size="7" maxlength="7">&nbsp;만엔&nbsp; 
							수업료 <input type="text" name="lessonsfee_6" size="7" value="${menuBean['lessonsfee_6']}" maxlength="7">&nbsp;만엔&nbsp; 		
						</td>
					</tr>
					<tr height="35"><!--비용/12개월-->
						<td>
							<font color="#2961EF">비용/12개월</font>
						</td>
						<td>
							선고비 <input type="text"name="registrationfee_12" value="${menuBean['registrationfee_12']}" size="7" maxlength="7">&nbsp;만엔&nbsp; 
							입학금 <input type="text"name="entrancefee_12" value="${menuBean['entrancefee_12']}" size="7" maxlength="7">&nbsp;만엔&nbsp; 
							수업료 <input type="text" name="lessonsfee_12" size="7" value="${menuBean['lessonsfee_12']}" maxlength="7">&nbsp;만엔&nbsp; 		
						</td>
					</tr>
					<tr height="35"><!--국적별학생수-->
						<td>
							<font color="#2961EF">국적별학생수</font>
						</td>
						<td>
							한국인 <input type="text"name="studentsu_korean" value="${menuBean['studentsu_korean']}" size="5" maxlength="5">&nbsp;명&nbsp; 
							중국인 <input type="text"name="studentsu_chinese" value="${menuBean['studentsu_chinese']}" size="5" maxlength="5">&nbsp;명&nbsp; 
							기타   <input type="text" name="studentsu_others" size="5" value="${menuBean['studentsu_others']}" maxlength="5">&nbsp;명&nbsp; 		
							총정원 <input type="text" name="studentsu_total" size="5" value="${menuBean['totalsu']}" maxlength="5">&nbsp;명&nbsp; 		
						</td>
					</tr>
					<tr height="35"><!--기숙사유무-->
						<td>
							<font color="#2961EF">기숙사유무</font>
						</td>
						<td>
							<c:if test="${menuBean['dormitoryflg'] == 0}">
								<input type="radio" name="dormitoryflg" value="1"> 유
								<input type="radio" name="dormitoryflg" value="0" checked> 무	
							</c:if>
								<c:if test="${menuBean['dormitoryflg'] == 1}">
								<input type="radio" name="dormitoryflg" value="1" checked> 유
								<input type="radio" name="dormitoryflg" value="0"> 무	
							</c:if>	
						</td>
					</tr>
					<tr><!--이미지-->
				    	<td height="120">
				    		<font color="#2961EF">이미지</font>
				    	</td>
				    	<td>
							<img src="${menuBean['photo_name1']}" alt="" width="30" height="30"><input type="file" id = "p1" name="photo_name1" size="20" maxlength="40"><img src="jsp/images/common/btn_delete.gif" onclick='return deletePhoto(1)'><br>
							<img src="${menuBean['photo_name2']}" alt="" width="30" height="30"><input type="file" id = "p2" name="photo_name2" size="20" maxlength="40"><img src="jsp/images/common/btn_delete.gif" onclick='return deletePhoto(2)'><br>
							<img src="${menuBean['photo_name3']}" alt="" width="30" height="30"><input type="file" id = "p3" name="photo_name3" size="20" maxlength="40"><img src="jsp/images/common/btn_delete.gif" onclick='return deletePhoto(3)'><br>
							<img src="${menuBean['photo_name4']}" alt="" width="30" height="30"><input type="file" id = "p4" name="photo_name4" size="20" maxlength="40"><img src="jsp/images/common/btn_delete.gif" onclick='return deletePhoto(4)'><br>
							<img src="${menuBean['photo_name5']}" alt="" width="30" height="30"><input type="file" id = "p5" name="photo_name5" size="20" maxlength="40"><img src="jsp/images/common/btn_delete.gif" onclick='return deletePhoto(5)'>
							<br>※JPEG GIF 이외의 이미지 확장자는 등록이 되지 않습니다.
						</td>
					</tr>
					<tr height="100"><!--특징-->
						<td width="120">
							<font color="#2961EF">특징</font>
						</td>
						<td>
							<textarea name="feature" rows="20" cols="110">${menuBean['feature']}</textarea>
						</td>
					</tr>
										
				</table>
				<table border="0" cellpadding="0" cellspacing="0" width="950" height="20" align="center">
					<tr style="padding-top:15">
						<td align="right">
							<!--登録-->
							<img src="jsp/images/common/btn_edit.gif" onClick="return updateCheck(wf, '<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>')">&nbsp;
							<!--リストに戻る-->
							<img src="jsp/images/common/btn_list.gif" onclick="return backSearch('<c:out value="${menuBean['id']}"/>','<%=KEYConst.MENU%>','<%=VALUEConst.NIHONGOMENU%>')">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="engmail.bean.EngmailListBean" %>
<%@ page import="java.util.List,java.util.Iterator" %>
<%@page import="common.util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	request.setCharacterEncoding("UTF-8");
	List engList = (List) request
	.getAttribute("engList");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	if ("MSG0002".equals(message)) {
%>
		<script language="javascript">
			alert("<fmt:message key="MSG0002" bundle="${message}"/>");
		</script>
	<%
	}else if ("MSG0001".equals(message)) {
	%>
		<script language="javascript">
			alert("<fmt:message key="MSG0001" bundle="${message}"/>");
		</script>
	<%
	}else if ("ERR0002".equals(message)) {
	%>
		<script language="javascript">
			alert("<fmt:message key="ERR0002" bundle="${message}"/>");
		</script>
	<%
	}else if ("ERR0004".equals(message)) {
	%>
		<script language="javascript">
			alert("<fmt:message key="ERR0004" bundle="${message}"/>");
		</script>
	<%
	}
	%>

<html>
<head>
<script type="text/javascript">
<!--
	function web_mail_all(){
		var ChkBox = document.list;
	
		for (i=0; i< ChkBox.checkbox_web_mail.length; i++) {
			ChkBox.checkbox_web_mail[i].checked = ChkBox.web_mail_CheckAll.checked;
		}
	}
	function mobile_mail_all(){
		var ChkBox = document.list;
	
		for (i=0; i< ChkBox.checkbox_mobile_mail.length; i++) {
			ChkBox.checkbox_mobile_mail[i].checked = ChkBox.mobile_mail_CheckAll.checked;
		}
	}	
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function registCheck(ff, count) {
		ff.action="EngMailRegistOpen?count=" + count;
		ff.submit(); 
		return true;
	}
	function interpretReload(ff) {
		ff.action="InterpretList";
		ff.submit(); 
		return true;
	}
	function etcLanaguage(language){
  		if(language==true){
   		//텍스트 입력 보이기
  		 document.getElementById("language_etc").style.display = "inline";
 		 }else{
 		  //텍스트 입력 보이지 않기
 		  document.getElementById("language_etc").style.display = "none";
 		  list.language_etc.value="";
 		 }
	}
	function etcService_area_1(service_area_1){
  		if(service_area_1=="etc"){
   		//텍스트 입력 보이기
  		 document.getElementById("service_area_etc").style.display = "inline";
 		 }else{
 		  //텍스트 입력 보이지 않기
 		  document.getElementById("service_area_etc").style.display = "none";
 		 }
	}
	function etcNation(nation){
  		if(nation=="etc"){
   		//텍스트 입력 보이기
  		 document.getElementById("nation_etc").style.display = "inline";
 		 }else{
 		  //텍스트 입력 보이지 않기
 		  document.getElementById("nation_etc").style.display = "none";
 		 }
	}
	function reload(){
	var language		= list.language5.checked;
	var service_area_1	= list.service_area_1.value;
	var nation			= list.nation.value;
	etcLanaguage(language);
	etcService_area_1(service_area_1);
	etcNation(nation);
	}
			
	
//-->
</script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">

<title><fmt:message key="label.title.interpret" bundle="${message}"/></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
</head>
<body style="margin:0 0 0 0">
<table border="0" cellpadding="0" cellspacing="0" width="950" align="center">
<!----- top메뉴 ------>
<tr valign="top">
	<td colspan="3">
		<jsp:include page="../include/top.jsp" flush="true"/>
	</td>
</tr>
<!----- top메뉴 ------>


<!----- 콘텐츠 영역 ----->
<tr>
	<!-- 콘텐츠간 간격 -->
	<td width="10"><img src="jsp/images/common/space.gif" alt="" width="10" height="15"></td>
	<!-- 콘텐츠간 간격 -->


	<!-- 메인 콘텐츠 -->
	<td valign="top">
	<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
	<form name="list" method="post">

		<table width="930" border="0">
			<tr>
				<td align="center"><img src="jsp/images/common/title_eng_mail_list.gif"></td>
			</tr>
		</table>

	  <table border="0" cellpadding="0" cellspacing="0">
        <tr valign="top">
          <td>
                        
            <table border="1" width="930" cellpadding="0" cellspacing="0" bordercolor="#E2E0D6" rules="rows,cols" style="border-collapse:collapse;">
              <col width="50" align="center">
              <col width="70" align="center">
              <col width="70">
              <col width="70">              
              <col width="100">
              <col width="100">
              <col width="50" align="center">              
              <% int count = 0;%>
              <tr height="28" bgcolor="#F0F0E2">
                <td>web mail<br><input type="checkbox" name="web_mail_CheckAll" onclick="web_mail_all()"></td>              
                <td>mobile mail<br><input type="checkbox" name="mobile_mail_CheckAll" onclick="mobile_mail_all()"></td>              
                <td>イニシャル</td>                
                <td>名前</td>
                <td>ウェブメール</td>
                <td>携帯メール</td>
                <td>登録日付</td>
             </tr>
              <%
                            	Iterator it = engList.iterator();
                            	
                            	if (it.hasNext()) {
                            		while (it.hasNext()) {

                            			EngmailListBean bean = (EngmailListBean) it.next();
              %>
              <tr height="28">
              		<input type="hidden" name="name_<%=count%>" value="<%=bean.getTo_name()%>">
		            <input type="hidden" name="web_mail_<%=count%>" value="<%=bean.getTo_mail()%>">
		            <input type="hidden" name="mobile_mail_<%=count%>" value="<%=bean.getTo_mobile_mail()%>">
              		<td><input type="checkbox" name="checkbox_web_mail" value="<%=count%>"></td>
              		<td><input type="checkbox" name="checkbox_mobile_mail" value="<%=count%>"></td>
					<td><%=bean.getInitial()%></td>              		
					<td><%=bean.getTo_name()%></td>
					<td><%=bean.getTo_mail()%></td>					
					<td><%=bean.getTo_mobile_mail()%></td>					
					<td><%=bean.getInsert_date()%></td>															
              </tr>
              <%
		  			count ++;
              		}
              %>
            </table>
            <%
            } else {
            %>
            </table>
            	<h2 align="center"><strong><fmt:message key="MSG0005" bundle="${message}"/></strong></h2>
            <%
            }
            %>

              <table border="0" cellpadding="0" cellspacing="0" height="20" align="right">
                <tr style="padding-top:15">
                <td>
                  <img src="jsp/images/common/btn_select.gif" onclick='return registCheck(list, <%=count%>)'>&nbsp;
                  </td>
                </tr>
              </table>
            
            

            <!-- 리스트 -->
              <!-- Page No-->
 				<myTags:pageHandle />
 			  <!-- Page No--> 			  
     	 </form>
      </table>
	<!-- 메인 콘텐츠 -->


	<!-- 콘텐츠간 간격 -->
	<!-- 콘텐츠간 간격 -->


	<!-- 우측콘텐츠 -->
      <!-- 포토플레이어 -->      <!----- 스폐셜 ----->	
	<!-- 우측콘텐츠 -->

<!----- 콘텐츠 영역 ----->

<!----- Footer 영역 ----->

<jsp:include page="../include/footer.jsp" flush="true"/>

<!----- Footer 영역 ----->
</body>
</html>
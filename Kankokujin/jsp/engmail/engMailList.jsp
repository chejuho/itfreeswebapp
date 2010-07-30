<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="engmail.bean.EngmailBean" %>
<%@ page import="common.bean.PageBean" %>
<%@ page import="java.util.List,java.util.Iterator" %>
<%@page import="common.util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	request.setCharacterEncoding("UTF-8");

	PageBean pageBean = new PageBean();
	if (session.getAttribute("PageBean") != null) {
		pageBean = (PageBean) session.getAttribute("PageBean");
	}

	List engMailList = (List) request.getAttribute("engMailList");
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
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
 <head>
<title><%=Const.PAGE_MAIN_TITLE%></title>
<script src="jsp/include/js/top.js" type="text/javascript"></script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/basic.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function adminOpen(ff) {
		ff.action="AdminMain";
		ff.submit(); 
		return true;
	}	
	function registOpen(ff) {
		ff.action="EngMailRegistOpen";
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
</head>

<body style="margin:0 0 0 0"> 
	<table>
	<jsp:include page="../include/top.jsp" flush="true" />
	<tr>
    	<td height="20">&nbsp;</td>
  	</tr>
	<tr>
		<form name="list" method="post">

		<table width="930" border="0">
			<tr>
				<td align="center"><img src="jsp/images/common/title_eng_mail_send_list.gif"></td>
			</tr>
		</table>
		<table width="930" border="0">
			<tr>
			    
		        <td style="padding:0 0px 5 0;" align="right">  
            		<fmt:message key="label.view_count" bundle="${message}"/> 
		               <select name="pageSize" onChange='return interpretReload(list)'>
        			       <option <%if(pageBean.getPageSize() == 10){%>selected <%}%> value = "10">10</option>
			               <option <%if(pageBean.getPageSize() == 20){%>selected <%}%> value = "20">20</option>
            			   <option <%if(pageBean.getPageSize() == 50){%>selected <%}%> value = "50">50</option>
			               <option <%if(pageBean.getPageSize() == 100){%>selected <%}%> value = "100">100</option>
            		   </select>
           		</td>
			</tr>
		</table>	
	  <table border="0" cellpadding="0" cellspacing="0">
        <tr valign="top">
          <td>
                        
            <table border="1" width="930" cellpadding="0" cellspacing="0" bordercolor="#E2E0D6" rules="rows,cols" style="border-collapse:collapse;">
              <col width="50" align="center">
              <col width="200">
              <col width="50" align="center">
              <col width="50" align="center">
              
              <tr height="28" bgcolor="#F0F0E2">
                <td>No.</td>
                <td>タイトル</td>
                <td>作成者</td>
                <td>登録日付</td>
             </tr>
              <%
                            	Iterator it = engMailList.iterator();
                            	int size = engMailList.size();
                            	if (it.hasNext()) {
                            		while (it.hasNext()) {
                            			EngmailBean bean = new EngmailBean();
                            	bean = (EngmailBean) it.next();
              %>
              <tr height="28">
					<td><%=bean.getMail_id()%></td>
					<td><a href="EngMailDetail?id=<%=bean.getMail_id()%>"><%=bean.getSubject()%></a></td>
					<td><%=bean.getUpdate_by_user_id()%></td>					
					<td><%=bean.getUpdate_date()%></td>					
              </tr>
              <%
              		size -= 1;
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
              <table border="0" cellpadding="0" cellspacing="0" height="20" align="center">
              <tr style="padding-top:10">
            	<td> <%
 if (pageBean.getMaxCount() != 0) {
 %> <fmt:message key="label.search" bundle="${message}"/><fmt:message key="label.result" bundle="${message}"/> : 
            	<span class="orange"><%=pageBean.getMaxCount()%></span>건중
            	<span class="orange"><%=pageBean.getStartCount()%></span>~
            	<span class="orange"><%=pageBean.getEndCount()%></span>건을 표시하고 있습니다.</td>
            	<%
            	}
            	%>
              </tr> 
              </table>
              <table border="0" cellpadding="0" cellspacing="0" height="20" align="right">
                <tr style="padding-top:15">
                <td>
	                <img src="jsp/images/common/btn_admin_main.gif" onClick="return adminOpen(list)">
                  <img src="jsp/images/common/btn_regist.gif" onClick="return registOpen(list)">
                  </td>
                </tr>
              </table>
            
            

            <!-- 리스트 -->
              <!-- Page No-->
 				<myTags:pageHandle />
 			  <!-- Page No--> 			  
     	 </form>
	</tr>
  	<tr>
    	<td height="50">&nbsp;</td>
  	</tr>
	<jsp:include page="../include/footer.jsp" flush="true"/>
	</table>
</body>
</html>
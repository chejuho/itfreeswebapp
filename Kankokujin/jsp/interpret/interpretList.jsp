<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="interpret.bean.InterpretBean" %>
<%@ page import="common.bean.PageBean" %>
<%@ page import="java.util.List,java.util.Iterator" %>
<%@page import="common.util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	request.setCharacterEncoding("UTF-8");

	InterpretBean interpretBean = (InterpretBean) session
			.getAttribute("InterpretBean");
	if (interpretBean == null) {
		interpretBean = new InterpretBean();
	}
	
	PageBean pageBean = new PageBean();
	if (session.getAttribute("PageBean") != null) {
		pageBean = (PageBean) session.getAttribute("PageBean");
	}

	List InterpretBeanList = (List) request
			.getAttribute("InterpretBeanList");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
	if ("MSG0002".equals(message)) {
	%>
		<script language="javascript">
			alert("<fmt:message key="MSG0002" bundle="${message}"/>");
		</script>
	<%}else if ("MSG0001".equals(message)) {
		%>
		<script language="javascript">
			alert("<fmt:message key="MSG0001" bundle="${message}"/>");
		</script>
	<%}else if ("ERR0002".equals(message)) {
		%>
		<script language="javascript">
			alert("<fmt:message key="ERR0002" bundle="${message}"/>");
		</script>
	<%}else if ("ERR0004".equals(message)) {
		%>
		<script language="javascript">
			alert("<fmt:message key="ERR0004" bundle="${message}"/>");
		</script>
	<%}
	%>

<html>
<head>
<script type="text/javascript">
<!--
	function isNull(obj) {
		if(obj.value == "") {
			return true;
		}
	}
	function registOpen(ff) {
		ff.action="InterpretRegistOpen";
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
<body style="margin:0 0 0 0" onload="reload()">
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
		<table border="0" cellpadding="0" cellspacing="0" height="31" width="930">
		    <tr style="padding-top:5" align="left">
		        <td><img src="jsp/images/10interpret/img_title_interpret_search.gif" width="928" height="29"></td>
		    </tr>
		</table>
		<table border="1" width="930" cellpadding="0" cellspacing="0" bordercolor="#E2E0D6" rules="rows,cols" style="border-collapse:collapse;" style="padding-left:5">
			<tr bgcolor="#F0F0E2">
				<td width="250" align="center"><fmt:message key="label.interpret_language" bundle="${message}"/>				
				</td>
				<td width="250" align="center"><fmt:message key="label.service_area" bundle="${message}"/>
				</td>
				<td width="200" align="center"><fmt:message key="label.sex" bundle="${message}"/>
				</td>		
			</tr>
			<tr align="center">
				<td>
							<input type="checkbox" name="language1" value="0" <%=interpretBean.getLanguage_checked(0)%>><fmt:message key="label.korean" bundle="${message}"/>
							<input type="checkbox" name="language2" value="1" <%=interpretBean.getLanguage_checked(1)%>><fmt:message key="label.japanese" bundle="${message}"/>
							<input type="checkbox" name="language3" value="2" <%=interpretBean.getLanguage_checked(2)%>><fmt:message key="label.english" bundle="${message}"/>
							<input type="checkbox" name="language4" value="3" <%=interpretBean.getLanguage_checked(3)%>><fmt:message key="label.chinese" bundle="${message}"/>
							<input type="checkbox" name="language5" value="4" <%=interpretBean.getLanguage_checked(4)%> onclick="javascript:etcLanaguage(this.checked);"><fmt:message key="label.etc" bundle="${message}"/>
		               	<div name="lytext" id="language_etc" style="display:none">
							: <input type="text" size="10" name="language_etc" value="<%=interpretBean.getLanguage_etc()%>">
						</div>
				</td>
		        <td>
						<select name='service_area_1' onChange="javascript:etcService_area_1(this.value);">				
							<option value=""><fmt:message key="label.please_choice" bundle="${message}"/></option>
							<option value="0" <%=interpretBean.getService_area_selected("0")%>><fmt:message key="label.korea" bundle="${message}"/></option>
							<option value="1" <%=interpretBean.getService_area_selected("1")%>><fmt:message key="label.japan" bundle="${message}"/></option>
							<option value="2" <%=interpretBean.getService_area_selected("2")%>><fmt:message key="label.usa" bundle="${message}"/></option>
							<option value="3" <%=interpretBean.getService_area_selected("3")%>><fmt:message key="label.china" bundle="${message}"/></option>
							<option value="etc" <%=interpretBean.getService_area_selected("etc")%>><fmt:message key="label.etc" bundle="${message}"/></option>		     			
		     			</select>
		               	<div name="lytext" id="service_area_etc" style="display:none">
							<fmt:message key="label.etc" bundle="${message}"/>: <input type="text" size="10" name="service_area_etc" value="<%=interpretBean.getService_area_1_etc()%>">
						</div>
		        </td>
				<td>
		                  <input type="radio" name="sex" value="0" <%=interpretBean.getSex_checked("0")%>>
		                                <fmt:message key="label.man" bundle="${message}"/>
		                  
		                  <input type="radio" name="sex" value="1" <%=interpretBean.getSex_checked("1")%>>
	                  	   <fmt:message key="label.woman" bundle="${message}"/>
		                  
		                  <input type="radio" name="sex" value="" <%=interpretBean.getSex_checked("")%>>
	                  	  <fmt:message key="label.no_matter" bundle="${message}"/>
		                  
				</td>
			</tr>	
			<tr bgcolor="#F0F0E2">
				<td width="250" align="center"><fmt:message key="label.age1" bundle="${message}"/>	
				</td>
				<td width="250" align="center"><fmt:message key="label.nation" bundle="${message}"/>
				</td>
				<td width="200" align="center">
					<fmt:message key="label.resume" bundle="${message}"/>
					<fmt:message key="label.exist" bundle="${message}"/>
					<fmt:message key="label.not_exist" bundle="${message}"/>
				</td>		
			</tr>
			<tr align="center">	
		        <td>
						<select name="age_from" onChange='return interpretReload(list)'>
		                  	<option value="100"><fmt:message key="label.no_limit" bundle="${message}"/></option>
		                    <%=interpretBean.getAge1Tag()%>
		                </select>
		               		&nbsp;<fmt:message key="label.age2" bundle="${message}"/>~ 
		                <select name="age_to">
		                    <option value="100"><fmt:message key="label.no_limit" bundle="${message}"/></option>
		                     <%=interpretBean.getAge2Tag()%>
		                </select>	
		                	&nbsp;<fmt:message key="label.age2" bundle="${message}"/>
		         </td>	
				<td>
						<select name='nation' onChange="javascript:etcNation(this.value);">				
							<option value=""><fmt:message key="label.please_choice" bundle="${message}"/></option>
							<option value="0" <%=interpretBean.getNation_selected("0")%>><fmt:message key="label.korea" bundle="${message}"/></option>
							<option value="1" <%=interpretBean.getNation_selected("1")%>><fmt:message key="label.japan" bundle="${message}"/></option>
							<option value="2" <%=interpretBean.getNation_selected("2")%>><fmt:message key="label.usa" bundle="${message}"/></option>
							<option value="3" <%=interpretBean.getNation_selected("3")%>><fmt:message key="label.china" bundle="${message}"/></option>
							<option value="etc" <%=interpretBean.getNation_selected("etc")%>><fmt:message key="label.etc" bundle="${message}"/></option>		     			
		     			</select>
		               	<div name="lytext" id="nation_etc" style="display:none">
							<fmt:message key="label.etc" bundle="${message}"/>: <input type="text" size="10" name="nation_etc" value="<%=interpretBean.getNation_etc()%>">
						</div>
				</td>
				<td>
		                  <input type="radio" name="resumeChecked" value="1" <%=interpretBean.getResume_checked("1")%>>
	                	    <fmt:message key="label.exist" bundle="${message}"/>
		                  
		                  <input type="radio" name="resumeChecked" value="0" <%=interpretBean.getResume_checked("0")%>>
	                  	    <fmt:message key="label.not_exist" bundle="${message}"/>	                  	    
		                  
		                  <input type="radio" name="resumeChecked" value="" <%=interpretBean.getResume_checked("")%>>
	                  	    <fmt:message key="label.no_matter" bundle="${message}"/>
		                  
				</td>
			</tr>				
		</table>
		<table width="930" border="0">
			<tr>
				<th align="right"><img src="jsp/images/common/img_search_button.gif" onclick='return interpretReload(list)'></th>				
			</tr>
			<tr>
				<td><img src="jsp/images/10interpret/img_title_interpret_list.gif" width="928" height="29"></td>
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
              <col width="100" align="center">
              <col width="170" align="center">
              <col width="90" align="center">
              <col width="180" align="center">
              <col width="80" align="center">
              <col width="180" align="center">
              <col width="80" align="center">
              
              <tr height="28" bgcolor="#F0F0E2">
                <td>No.</td>
                <td><fmt:message key="label.author" bundle="${message}"/></td>
                <td><fmt:message key="label.service_language" bundle="${message}"/></td>
                <td><fmt:message key="label.service_area" bundle="${message}"/></td>
				<td><fmt:message key="label.birth" bundle="${message}"/></td>
				<td><fmt:message key="label.nation" bundle="${message}"/></td>
				<td><fmt:message key="label.service_day" bundle="${message}"/></td>
                <td>등록일</td>
             </tr>
              <%
              	Iterator it = InterpretBeanList.iterator();
              	int size = InterpretBeanList.size();
              	if (it.hasNext()) {
              		while (it.hasNext()) {
              			InterpretBean info = new InterpretBean();
              			info = (InterpretBean) it.next();
              %>
              <tr height="28">
                <td><a href="InterpretDetail?id=<%=info.getId()%>"> <%=info.getId()%></a></td>
                <td><a href="InterpretDetail?id=<%=info.getId()%>"><%=info.getUser_name()%></a></td>
                <td><%=info.getLanguageName()%></td>
                <td><%=info.getServiceArea()%></td>
                <td>
	                <%
	                if (!Util.isEmpty(info.getBirthday())) {
	                %>
		        	    <%=info.getYear()%><fmt:message key="label.year" bundle="${message}"/><%=info.getMonth()%><fmt:message key="label.month" bundle="${message}"/> (<%=info.getAge()%><fmt:message key="label.age2" bundle="${message}"/> / <%=info.getSex_name() %>)
	                <%}else if (!Util.isEmpty(info.getSex_name())){%>
	                	<%=info.getSex_name() %>
	                <%}%>
                </td>
                <td><%=info.getNationName()%></td>
                <td><%=info.getService_day()%></td>
                <td><%=info.getUpdate_date()%></td>               
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
                  <img src="jsp/images/common/btn_cs_write.gif" onClick="return registOpen(list)">
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
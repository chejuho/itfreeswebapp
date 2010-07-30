<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="common.bean.PageBean"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ page import="main.bean.ContactusBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@page import="common.bean.MemberBean"%>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	List contactusList = (List) request.getAttribute("ContactusList");

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
	function registOpen(ff) {
		ff.action="FindjobRegistOpen?before=search&f=search";
		ff.submit(); 
		return true;
	}	
	function storePageSize(ff) {
		ff.action="FindjobSearch";
		ff.submit(); 
		return true;
	}
	function reloadSearch(ff) {
		
		ff.action="FindjobSearch";
		ff.submit(); 
		return true;
	}
	
	function reloadPage(obj) {
		document.list.action="FindjobSearch?&pageNum="+obj;
		document.list.submit(); 
		return true;
	}
	function reloadCate_code_1(obj) {
		document.list.action="FindjobSearch?cate_code_1=" + obj + "&cate_code_2=&before_cate_code_2=";
		document.list.submit(); 	
		return true;
	}
	function reloadCate_code_2(cate_code_1, cate_code_2) {
		document.list.action="FindjobSearch?cate_code_1=" + cate_code_1 + "&cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}
	function searchStore(cate_code_1, cate_code_2) {
		document.list.action="FindjobSearch?cate_code_1=" + cate_code_1 + "&cate_code_2=" + cate_code_2;
		document.list.submit(); 	
		return true;
	}	
	function my_write(user_id) {

		if(user_id == "-"){
			alert("내가 쓴 글을 보려면 로그인을 해주시기 바랍니다");
			window.location.href="MemberLoginOpen";	
			return false;
		}			
		document.list.action="FindjobSearch?user_id=" + user_id;
		document.list.submit(); 
		return true;
	}
	function openDetailPage(id) {

		document.list.action="FindjobDetail?before=search&id=" + id;
		document.list.submit(); 
		return true;
	}		

//-->
</script>
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
		<form name="list" method="post" style="margin:0">    
      	<br>  
      	
				<table border="0">
					<tr><td>
				<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->	
							<table border="0" align="right">

								<tr>
									<td style="padding:0 0px 5 0;" align="right">열람개수 
									<select name='pageSize' onChange='return storePageSize(list)'>
										<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10</option>
										<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20</option>
										<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50</option>
										<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100</option>
									</select>
									</td>
								</tr>

							</table>

					</td></tr>
					<tr><td>
			
							<table border="1" rules="rows" cellpadding="0" cellspacing="0"
								bordercolor="#E2E0D6" 
								style="border-collapse:collapse;">
			
								<tr height="35" bgcolor="#F0F0E2">
									<td width="60"><font color="#2961EF">번호</font></td>
									<td width="100" align="center"><font color="#2961EF">이 름</font></td>
									<td width="500"><font color="#2961EF">제 목<br>내 용</font></td>
									<td width="100"><font color="#2961EF">이메일</font></td>									
									<td width="100"><font color="#2961EF">전화번호1<br>전화번호2</font></td>
									<td width="60"><font color="#2961EF">등록일</font></td>
								</tr>
								<%
									Iterator contactusListIt = contactusList.iterator();
									int contactusListSize = contactusList.size();
									if (contactusListIt.hasNext()) {
										while (contactusListIt.hasNext()) {
											ContactusBean bean = new ContactusBean();
											bean = (ContactusBean) contactusListIt.next();
								%>
									<tr height="35">
										<td><a href="javascript:openDetailPage('<%=bean.getId()%>');"><%=bean.getId()%></a></td>
										<td style="padding-left:10";><a href="javascript:openDetailPage('<%=bean.getId()%>');"><%=bean.getName()%></a></td>
										<td><%=bean.getTitle()%><br>
										<%=bean.getDetail_info()%>
										</td>
										<td><%=bean.getEmail()%>								
										</td>										
										<td><%=bean.getTel_no1_1()%>-<%=bean.getTel_no1_2()%>-<%=bean.getTel_no1_3()%><br>
										<%=bean.getTel_no2_1()%>-<%=bean.getTel_no2_2()%>-<%=bean.getTel_no2_3()%></td>
										<td><%=bean.getUpdate_date()%></td>
									</tr>
								<%
								contactusListSize -= 1;
										}
							
									} else {
								%>						
									<tr height="30">
										<td colspan="8" style="padding-left:5";>
										<strong>해당 검색 리스트가 없습니다.</strong>
										</td>
									</tr>

								<%
									}
								%>
							</table>		
					</td></tr>
					<tr><td>																				
							<table border="0" cellpadding="0" cellspacing="0" height="20"
								align="center">
								<tr style="padding-top:10">
									<td style="padding-left:5";>
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
							<table width=100% border="0"><tr align="right"><td>
									<img src="jsp/images/common/btn_list.gif" alt="" onclick="return reloadSearch(list)">
							</td></tr></table>

								
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="common.bean.PageBean"%>
<%@ page import="java.util.List,java.util.Iterator"%>
<%@ page import="store.bean.StoreBean, category.bean.CategoryBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	List storeBeanList = (List) request.getAttribute("storeBeanList");
	CategoryBean categoryBean = (CategoryBean) request.getAttribute("categoryBean");
	String cate_code_1 = (String) request.getAttribute("cate_code_1");
	String cate_code_2 = (String) request.getAttribute("cate_code_2");	

	String categorySelect = (String) request.getAttribute("CategorySelect");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
%>
<html>
<head>
<script type="text/javascript">
<!--
	function registOpen(ff) {
		ff.action="StoreRegistOpen";
		ff.submit(); 
		return true;
	}	
	function storePageSize(ff) {
		ff.action="StoreList";
		ff.submit(); 
		return true;
	}
	function loadPage(obj){
		location.href = obj.options[obj.selectedIndex].value;
	}
	function reloadPage(ff, obj) {
		//alert("pageNum=" + obj);
		ff.action="StoreList?pageNum="+obj;
		ff.submit(); 
		return true;
	}
//-->
</script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script language="javascript">
	<%if ("WAR0004".equals(message)) {%>
			alert("<fmt:message key="WAR0004" bundle="${message}"/>");
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
    <div id="top">

			<jsp:include page="../include/top.jsp" flush="true" />

    </div>
    <div id="body">
		<table border="0" cellpadding="0" cellspacing="0" width="950">

					<tr valign="middle">
						<td align="center"><img src="jsp/images/common/title_store_list.gif"></td>
					</tr>
					<tr valign="middle">
						<td align="center">대분류:<%=categoryBean.getCate_name() %>/소분류:<%=categoryBean.getCate_name_2() %></td>
					</tr>					
		</table>
      		<form name="list" method="post">
    			<input type="hidden" name="cate_code_1" value="<%=cate_code_1%>">
      			<input type="hidden" name="cate_code_2" value="<%=cate_code_2%>">  
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
			
							<table  border="1" frame="border" cellpadding="0" cellspacing="0"
								bordercolor="#E2E0D6" rules="rows,cols"
								style="border-collapse:collapse;">
								<col width="25" align="center">
								<col width="55" align="center">
								<col width="230" align="center">
								<col width="85" align="center">
								<col width="180" align="center">								
								<col width="120" align="center">
								<col width="120" align="center">
								<col width="60" align="center">
								<col width="60" align="center">
				
								<tr height="28" bgcolor="#F0F0E2">
									<td>No.</td>
									<td>이미지</td>
									<td>업체명</td>
									<td>전화번호</td>
									<td>홈페이지</td>									
									<td>지역</td>
									<td>교통정보</td>
									<td>글쓴이</td>
									<td>등록일</td>
								</tr>
								<%
									Iterator it = storeBeanList.iterator();
									int size = storeBeanList.size();
									if (it.hasNext()) {
										while (it.hasNext()) {
											StoreBean bean = new StoreBean();
											bean = (StoreBean) it.next();
								%>
									<tr height="28">
										<td><a href="StoreDetail?id=<%=bean.getId()%>&cate_code_1=<%=cate_code_1%>&cate_code_2=<%=cate_code_2%>"><%=bean.getId()%></a></td>
										<td><a href="StoreDetail?id=<%=bean.getId()%>&cate_code_1=<%=cate_code_1%>&cate_code_2=<%=cate_code_2%>"><img src="<%=bean.getPhoto_path1()%>" width="50" height="50"></a></td>
										<td><a href="StoreDetail?id=<%=bean.getId()%>&cate_code_1=<%=cate_code_1%>&cate_code_2=<%=cate_code_2%>"><%=bean.getStore_name_k()%></a></td>
										<td><%=bean.getTel_no1_fname()%></td>
										<td><a href="<%=bean.getUrl()%>" target="_blank"><%=bean.getUrl()%></a></td>										
										<td><%=bean.getArea_name()%>&nbsp;</td>
										<td>&nbsp;<%=bean.getLine_name()%></td>
										<td><%=bean.getUserName()%></td>
										<td><%=bean.getUpdate_date()%></td>
									</tr>
								<%
										size -= 1;
										}
							
									} else {
								%>						
									<tr>
										<td colspan="8">
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
									<td>
									<%
									if (pageBean.getMaxCount() != 0) {
									%> 검사결과 : <span class="orange"><%=pageBean.getMaxCount()%></span>건중
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
							<table border="0" cellpadding="0" cellspacing="0" height="20"
								align="right">
								<tr style="padding-top:15">
									<td><img src="jsp/images/common/btn_regist.gif" onClick="return registOpen(list)"></td>
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
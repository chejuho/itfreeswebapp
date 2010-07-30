<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="bean.HouseFindInfo,dbhandler.UtilHandler,common.util.HouseUtil,constant.Constant,bean.SortBean" %>
<%@ page import="common.PageInfo,common.util.Util" %>
<%@ page import="java.util.HashMap, java.util.List,java.text.DecimalFormat,java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%
request.setCharacterEncoding("UTF-8");

PageInfo pageInfo = (PageInfo)session.getAttribute("PageInfo");

List houseFindList = (List)request.getAttribute("HouseFindList");

String pageType = pageInfo.getPageType();
%>
<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>

<script type="text/javascript">
<!--	
	function submitHouseSell(ff) {
		ff.action="HouseSellSearch";
		ff.submit(); 
		return true;
	}	
//-->
</script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
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
	  <table border="0" cellpadding="0" cellspacing="0">
        <tr valign="top">
          <td><!-- 리스트 -->
          		<table border="0" width="930" cellpadding="0" cellspacing="0" >
          		<tr><td align="right">
            		열람개수 
		               <select name='pageSize' onChange='return submitHouseSell(list)'>
        			       <option <%if(pageInfo.getPageSize() == 10){%>selected <%}%> value = "10">10</option>
			               <option <%if(pageInfo.getPageSize() == 20){%>selected <%}%> value = "20">20</option>
            			   <option <%if(pageInfo.getPageSize() == 50){%>selected <%}%> value = "50">50</option>
			               <option <%if(pageInfo.getPageSize() == 100){%>selected <%}%> value = "100">100</option>
            		   </select>
			</td></tr></table>      		   
            <table border="0" width="930" cellpadding="0" cellspacing="0" bordercolor="#E2E0D6" rules="rows,cols" style="border-collapse:collapse;">
              <col width="60" align="center">
              <col width="200">
              <col width="200" >
              <col width="80" align="center">
              <col width="90" align="center">
              <col width="90" align="center">
              <col width="90" align="center">
              <col width="90" align="center">
              <col width="90" align="center">
              <col width="90" align="center">
              <col width="90" align="center">
              <col width="90" align="center">
              
              <tr height="28" bgcolor="#F0F0E2">
				<td width="100" class="text_bold">제목</td>
                <td width="100" class="text_bold">주소</td>
                <td width="100" class="text_bold">마도리</td>                
                <td width="100" class="text_bold">야찡</td>
                <td width="100" class="text_bold">교통정보</td>
                <td width="100" class="text_bold">건물종류</td>
				<td width="100" class="text_bold">입거희망일</td>
				<td width="100" class="text_bold">전용면적</td>
                <td width="90" class="text_bold">등록자</td>
                <td width="90" class="text_bold">등록일</td>
              </tr>
              <%
              
            Iterator it = houseFindList.iterator();
         
      		  while (it.hasNext()) {
          		HouseFindInfo houseFindInfo = (HouseFindInfo) it.next();
              %>
 	                 <input type="hidden" name="sendaddress" value="3">
 	                 <input type="hidden" name="pageType" value="<%=pageType %>">
              <tr height="28">

                <td width="100"><%=houseFindInfo.getTitle() %></td>
                <td width="100"><%=houseFindInfo.getArea_Name(request) %></td>
                <td width="100"><%=houseFindInfo.getMadori_Name(request) %></td>
                <td width="100"><%=houseFindInfo.getHouse_fee_from() %>～<%=houseFindInfo.getHouse_fee_to() %></td>
                <td width="100"><%=houseFindInfo.getTraffic_Name() %></td>
                <td width="100"><%=houseFindInfo.getHouse_sort_Name(request) %></td>
                <td width="100"><%=houseFindInfo.getCome_dock_Name(request)%></td>
                <td width="100"><%=houseFindInfo.getDimension_from() %>～<%=houseFindInfo.getDimension_to() %></td>
                <td width="100"><%=houseFindInfo.getUser_id() %></td>
                <td width="100"><%=houseFindInfo.getRegist_date() %></td>
              </tr>
              <%
      		  }%>
            </table>            
              <table border="0" cellpadding="0" cellspacing="0" height="20" align="center">
              <tr style="padding-top:10">
            	<td> <%if(pageInfo.getMaxCount()!=0){ %> 검사결과 : 
            	<span class="orange"><%=pageInfo.getMaxCount() %></span>건중
            	<span class="orange"><%=pageInfo.getStartCount() %></span>~
            	<span class="orange"><%=pageInfo.getEndCount() %></span>건을표시하고 있습니다.</td>
            	<%} %>
              </tr> 
              </table>
              <table border="0" cellpadding="0" cellspacing="0" height="20" align="right">
                <tr style="padding-top:15">
                <td>
                <img src="jsp/images/common/btn_clubnotice_list.gif" onClick="submitList(list)">
	              <img src="jsp/images/common/btn_cs_likesubmit.gif" onClick="return submitSelect(list)">&nbsp;
                  <a href="HouseFindOpenWrite"><img src="jsp/images/common/btn_cs_write.gif"></a>&nbsp;
                  </td>
                </tr>
              </table>
            
            

            <!-- 리스트 -->
              <!-- Page No-->
 				<myTags:pageHandle />
 			  <!-- Page No-->
     	 </form>
		</td>
        </tr>
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
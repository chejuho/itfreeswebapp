<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List,java.util.Iterator" %> 
<%@ page import="common.bean.PageBean,housesell.bean.HouseBean" %>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" uri="pageHandle" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<%

PageBean pageBean = (PageBean)session.getAttribute("PageBean");

List HouseBeanList = (List)request.getAttribute("HouseBeanList");

String pageType = pageBean.getPageType();

%>	

<html>
<head>
<title><%=Const.PAGE_MAIN_TITLE%></title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="../include/js/mypot.js"></script>
<script language="javascript" src="/Share/Function.js"></script>
<script language="javascript" src="jsp/Scripts/top.js"></script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
	function submitDelete(list) {
		list.action="HouseSellInterestDelete";
		list.submit(); 
		return true;
	}
//-->
</script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style3 {font-size: 12px}
.text {
	line-height: 8px;
}
-->
</style>
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
      
            <table border="0" cellpadding="0" cellspacing="0"  align="right">
              <tr height="20">
                <td height="20"><table border="0" cellspacing="0" cellpadding="0" style="margin:5px 4px 0 0;">
                  <tr>                    
                    <td style="padding:0 0px 5 0;" >  
            		열람개수 
		               <select name='pageSize' onChange='document.list.submit()'>
        			       <option <%if(pageBean.getPageSize() == 10){%>selected <%}%> value = "10">10</option>
			               <option <%if(pageBean.getPageSize() == 20){%>selected <%}%> value = "20">20</option>
            			   <option <%if(pageBean.getPageSize() == 50){%>selected <%}%> value = "50">50</option>
			               <option <%if(pageBean.getPageSize() == 100){%>selected <%}%> value = "100">100</option>
            		   </select>
               		</td>
                  </tr>
                </table></td>
              </tr>
            </table>
            <br><br>
               <table border="0" cellspacing="0" cellpadding="0">
			<tr><td ><img src="jsp/images/common/one_point.gif"><img src="jsp/images/common/title_likesubmit.gif">
				</td></tr>
		</table>             
               <br>      
            <table border="1" width="950" cellpadding="0" cellspacing="0" bordercolor="#E2E0D6" rules="rows,cols" style="border-collapse:collapse;">
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
                <td width="60"><font color="#2961EF">선택</font></td>
                <td width="200"><font color="#2961EF">주소</font></td>
                <td width="200"><font color="#2961EF">노선정보</font></td>
                <td width="80"><font color="#2961EF">도보</font> </td>
                <td width="90"><font color="#2961EF">야찡</font>
                <br>
				<font color="#2961EF">/관리비</font></td>
                <td width="90"><font color="#2961EF">시끼낑<br>/레이킹</font></td>
				<td width="90"><font color="#2961EF">보증금</font></td>
				<td width="90"><font color="#2961EF">마도리<br>/전용면적</font></td>
				<td width="90"><font color="#2961EF">건물종류<br>/건축일</font></td>
                <td width="90"><font color="#2961EF">상세정보</font></td>
                <td width="90"><font color="#2961EF">글쓴이</font></td>
                <td width="90"><font color="#2961EF">등록일</font></td>
              </tr>
              <%
              Iterator it = HouseBeanList.iterator();
              if(it.hasNext()){
        		  while (it.hasNext()) {

            		HouseBean houseBean = (HouseBean) it.next();
                %>
   	                 <input type="hidden" name="sendaddress" value="3">
 	                 <input type="hidden" name="pageType" value="<%=pageType %>">
                <tr height="28">
                  <td width="60">
  	                 <input type="checkbox" name="select_check" value=<%=houseBean.getId()%>></td>
                  <td width="200"><%=houseBean.getArea_fast()+houseBean.getArea_name() %></td>
                  <td width="200"><%=houseBean.getLine_name() %> </td>
                  <td width="80"><%=houseBean.getWalk_time()%> </td>
                  <td width="90"><%=houseBean.getHouse_fee()[0] %><br><%=houseBean.getManage_fee() %></td>
                  <td width="90"><%=houseBean.getDeposit() %><br><%=houseBean.getReikin() %></td>
                  <td width="90"><%=houseBean.getGuaranty_money() %></td>
                  <td width="90"><%=houseBean.getMadori()[0] %><br><%=houseBean.getDimension()[0]%></td>
                  <td width="90"><%=houseBean.getHouse_sort()[0] %><br><%=houseBean.getBuild_year()%></td>
                  <td align="center"><a href="HouseSellDetail?id=<%=houseBean.getId() %>">
                  <%=houseBean.getPhoto_name1_Path()%></a>
  				  </td>
                  <td width="90"><%=houseBean.getUser_name() %></td>
                  <td width="90"><%=houseBean.getUpdate_date()%></td>
                </tr>
              <%if(pageType.equals("2")){ %>
              <tr height="1" bgcolor="#ECEAE3">
               	<td colspan="12"></td>
              </tr>
              <%}
      		  }%>
              </table>
              <%}else{ %>
              </table>
              	<h2 align="center"><strong>해당 검색 리스트가 없습니다.</strong></h2>
              <%} %>
              <table border="0" cellpadding="0" cellspacing="0" height="20" align="center">
              <tr style="padding-top:10">
            	<td>  검사결과 : 
            	<td> <%if(pageBean.getMaxCount()!=0){ %> 검사결과 : 
            	<span class="orange"><%=pageBean.getMaxCount() %></span>건중
            	<span class="orange"><%=pageBean.getStartCount() %></span>~
            	<span class="orange"><%=pageBean.getEndCount() %></span>건을표시하고 있습니다.</td>
            	<%} %>
              </tr> 
              </table>
              <table border="0" cellpadding="0" cellspacing="0" height="20" align="right">
                <tr style="padding-top:15">
                <td>
                  <img src="jsp/images/common/btn_delete.gif" onClick="return submitDelete(list)">&nbsp;                  
                  <a href="HouseSellList"><img src="jsp/images/common/btn_list.gif"></a>&nbsp;
                  </td>
                </tr>
              </table>

 
            <!-- 리스트 -->
              <!-- Page No-->
 				<myTags:pageHandle />
            <!-- Page No-->
     


	<!-- 메인 콘텐츠 -->


	<!-- 콘텐츠간 간격 -->
	<!-- 콘텐츠간 간격 -->


	<!-- 우측콘텐츠 -->
	<!-- 우측콘텐츠 -->


<!----- 콘텐츠 영역 ----->
</form>
</td>
</tr>
<tr height="40">
	<td colspan="3"></td>
</tr>


<!----- Footer 영역 ----->

<tr valign="buttom">
	<td colspan="3">
		<jsp:include page="../include/footer.jsp" flush="true"/>
	</td>
</tr>

<!----- Footer 영역 ----->
</table>
</body>

</html>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="category.bean.CategoryBean, store.bean.StoreSearchBean"%>
<%@page import="common.bean.MemberBean"%>
<%@ page import="java.util.List,java.util.Iterator, java.math.BigInteger"%>
<%@page import="common.constant.Const"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%
	//PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	List storeCateBeanList = (List) request.getAttribute("StoreCateBeanList");
	//String categorySelect = (String) request.getAttribute("CategorySelect");
	//StoreBean storeBean = (StoreBean)session.getAttribute("StoreBean");
	StoreSearchBean storeSearchBean = (StoreSearchBean)request.getAttribute("StoreSearchBean");
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
	function my_write(user_id) {

		if(user_id == "-"){
			alert("내가 쓴 글을 보려면 로그인을 해주시기 바랍니다");
			return false;
		}			
		document.list.action="StoreMyList?user_id=" + user_id;
		document.list.submit(); 
		return true;
	}		
	function reloadSearch(ff) {
		ff.action="StoreMain";
		ff.submit(); 
		return true;
	}	
	function registOpen(ff) {
		ff.action="StoreRegistOpen";
		ff.submit(); 
		return true;
	}	
	function reloadCate_code_1(obj) {
		document.list.action="StoreSearch?cate_code_1=" + obj;
		document.list.submit(); 	
		return true;
	}	
	function searchStore() {
		alert("search");
		document.list.action="StoreSearch";
		document.list.submit(); 	
		return true;
	}	
//-->
</script>
<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
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
    <form name="list" method="post">
    	<table border="1" width="950">
    	<tr>
		<%
				Iterator storeCateBeanListIt = storeCateBeanList.iterator();
				while (storeCateBeanListIt.hasNext()) {
					%><td><%
					CategoryBean bean = (CategoryBean) storeCateBeanListIt.next();
						
					if(!"0000".equals(bean.getCate_name())){
						%><a href="javascript:reloadCate_code_1('<%=bean.getCate_code()%>');"><%=bean.getCate_name()%></a><%
					}%>
					</td><%
				}
				
		%>
		</tr>
		<table>
    	<input type="hidden" name="isfirst" value="1">
		<table border="1" width="950" cellpadding="0" cellspacing="0" bordercolor="#E2E0D6" rules="rows,cols" style="border-collapse:collapse;" style="padding-left:5">
			<tr bgcolor="#F0F0E2">

				<td width="210" align="center"">지역상세명
				</td>
				<td width="320" align="center"">노선정보
				</td>
				<td width="200" align="center"">검색대상
				</td>				
				<td width="200" align="center"">검색
				</td>				
	
		
			</tr>
			<tr>

		        <td>
						<select name='area_code_1' onChange='return reloadSearch(list)'>
		     				<%= storeSearchBean.getArea_1Tag()%>
		     				</select>
		     				<select name='area_code_2'>
							<%= storeSearchBean.getArea_2Tag()%>
						</select>
		        </td>
				<td>
							<select name='line_code' onChange='return reloadSearch(list)'>
		              		<%= storeSearchBean.getLineTag()%>
		                   	</select>
		                   	센
		     				<select name='station_code'>
							<%= storeSearchBean.getStationTag() %>
							</select>
							역
				</td>
				<td>
					<select name='search_range'>
						<option value='<%= storeSearchBean.getStationTag() %>'>전체검색</option>
						<option value='<%= storeSearchBean.getStationTag() %>'>업체명</option>
						<option value='<%= storeSearchBean.getStationTag() %>'>상세정보</option>
					</select>
				</td>				
				<td>
					<input type="text" id="query" name="search" maxlength="100" value="" >
					<input name="" type="image" src="http://img.kakaku.com/images/category/btn_search.gif" alt="検索" onClick='return searchStore()'>
				</td>
			</tr>			
		</table>    	
		<table border="1" cellpadding="4" cellspacing="0" rules="rows,cols"
			style="border-collapse:collapse;" width="950">
			<col width="300" align="center">
			<col width="300" align="center">
			<col width="300" align="center">
			
			
			<%
				Iterator it = storeCateBeanList.iterator();
				int size = storeCateBeanList.size();
				int tdNo = 3;

				BigInteger sizeBigInteger = new BigInteger(String.valueOf(size));
				BigInteger divideBigInteger = new BigInteger(String.valueOf(tdNo));		
				BigInteger[] tempDivideAndRemainder = sizeBigInteger.divideAndRemainder(divideBigInteger);
				int trNo = 0;	
				if(tempDivideAndRemainder[1].compareTo(BigInteger.ZERO)==0){
					trNo = tempDivideAndRemainder[0].intValue();
				} else {
					trNo = tempDivideAndRemainder[0].intValue() + 1;
				}
				int count = 0;
				boolean isStarted = false;
				%><tr height="50" valign="top"><%
				while (it.hasNext()) {
					
					CategoryBean bean = (CategoryBean) it.next();
					BigInteger countBigInteger = new BigInteger(String.valueOf(count));
					count ++;
					BigInteger divedieBigDecimal = countBigInteger.remainder(divideBigInteger);
					boolean isEnd = false;
					if (divedieBigDecimal.compareTo(BigInteger.ZERO)==0) {
						isEnd = true;
					}
					if (!isStarted && isEnd) {
						%>
						<td><font size="3" color="red">
						<%=bean.getCate_name()%></font>
						
							<%
								List childBeanList = bean.getChildBeanList();
           									Iterator childBeanListIt = childBeanList.iterator();
           									if(childBeanListIt.hasNext()){
           										%><br><br><%
           										int tempCount = 0;
               									while (childBeanListIt.hasNext()){
               										tempCount ++ ;
               										if (tempCount >3) {
               											tempCount = 0;
               											%>&nbsp;&nbsp;&nbsp;<%
               										}
               										CategoryBean childCateBean = (CategoryBean)childBeanListIt.next();
               										%><a href="StoreList?cate_code_1=<%=bean.getCate_code()%>&cate_code_2=<%=childCateBean.getCate_code()%>"><%=childCateBean.getCate_name()%></a>
               										
										<%
										
               									}        
               									%><%
           									}

								%>
							</td>
							<%
							isStarted =  true;
						} else if (isStarted && isEnd) {
							
							%></tr><tr height="28">
							<td><font size="3" color="red"><%=bean.getCate_name()%></font>
							
							<%
									List childBeanList = bean.getChildBeanList();
            									Iterator childBeanListIt = childBeanList.iterator();
            									if(childBeanListIt.hasNext()){
            										%><br><br><%
            										int tempCount = 0;
                									while (childBeanListIt.hasNext()){
                										tempCount ++ ;
                										if (tempCount >3) {
                											tempCount = 0;
                											%>&nbsp;&nbsp;&nbsp;<%
                										}
                										CategoryBean childCateBean = (CategoryBean)childBeanListIt.next();
                										%><a href="StoreList?cate_code_1=<%=bean.getCate_code()%>&cate_code_2=<%=childCateBean.getCate_code()%>"><%=childCateBean.getCate_name()%></a>
                										
											<%
											
                									}        
                									%><%
            									}

								%>
							</td>
							<%
							
						} else if (isStarted){
							%>
							<td><font size="3" color="red"><%=bean.getCate_name()%></font>
							
							
																		<%
									List childBeanList = bean.getChildBeanList();
            									Iterator childBeanListIt = childBeanList.iterator();
            									if(childBeanListIt.hasNext()){
            										%><br><br><%
            										int tempCount = 0;
                									while (childBeanListIt.hasNext()){
                										tempCount ++ ;
                										if (tempCount >3) {
                											tempCount = 0;
                											%>&nbsp;&nbsp;&nbsp;<%
                										}
                										CategoryBean childCateBean = (CategoryBean)childBeanListIt.next();
                										%><a href="StoreList?cate_code_1=<%=bean.getCate_code()%>&cate_code_2=<%=childCateBean.getCate_code()%>"><%=childCateBean.getCate_name()%></a>
                										
											<%
											
                 									}        
                 									%><%
             									}

									%>
									
									</td>
									<%	
								} 
							} 
							%></tr>
							
					</table>		
    		<img src="jsp/images/common/btn_my_write.gif" alt="" onclick="return my_write('<%=member.getUserid()%>')">
    		<img src="jsp/images/common/btn_my_write.gif" alt="" onclick="return registOpen(list)">
    		


			</form>    

 
    </div>
    <div id="bottom">

    	<jsp:include page="../include/footer.jsp" flush="true"/>
    </div>

</div>
</body>
</html>
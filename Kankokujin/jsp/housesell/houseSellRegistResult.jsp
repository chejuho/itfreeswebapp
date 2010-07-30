<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="housesell.bean.HouseSearchBean"%>
<%
	request.setCharacterEncoding("UTF-8");
HouseSearchBean houseSearchBean = (HouseSearchBean) request.getAttribute("HouseSearchBean");
%>
<html>
<script language="javascript">
	function start_index() {
		document.list.action="HouseSellList?re=9";
		document.list.submit(); 
		return true;
	}
</script>
<body  onload="start_index()">
	<form name="list" method="post" style="margin:0">
				<input type="hidden" name="user_id" value="<%=houseSearchBean.getUser_id()%>">      						
      			<input type="hidden" name="pageSize" value="<%=houseSearchBean.getPageSize()%>">      			
      			<input type="hidden" name="pageNum" value="<%=houseSearchBean.getPageNum()%>">      			  			      			      							
				<input type="hidden" name="search_area_code_1" value="<%=houseSearchBean.getArea_code_1()%>">      										
				<input type="hidden" name="search_area_code_2" value="<%=houseSearchBean.getArea_code_2()%>">      														
				<input type="hidden" name="search_line_code" value="<%=houseSearchBean.getLine_code()%>">      						
				<input type="hidden" name="search_station_code" value="<%=houseSearchBean.getStation_code()%>">      										
				<input type="hidden" name="search_walk_time" value="<%=houseSearchBean.getWalk_time()%>">      						
				<input type="hidden" name="search_regist_date" value="<%=houseSearchBean.getRegist_date()%>">      										
				<input type="hidden" name="search_build_year" value="<%=houseSearchBean.getBuild_year()%>">      						
				<input type="hidden" name="search_flg_tadami" value="<%=houseSearchBean.getFlg_tadami()%>">      										
				<input type="hidden" name="search_toilet" value="<%=houseSearchBean.getToilet()%>">      														
				
				<input type="hidden" name="house_fee_from" value="<%=houseSearchBean.getHouse_fee(0)%>">      														
				<input type="hidden" name="house_fee_to" value="<%=houseSearchBean.getHouse_fee(1)%>">      														
				<input type="hidden" name="dimension_1" value="<%=houseSearchBean.getDimension(0)%>">      														
				<input type="hidden" name="dimension_2" value="<%=houseSearchBean.getDimension(1)%>">      														
				<input type="hidden" name="madori_0" value="<%=houseSearchBean.getMadori(0)%>">      														
				<input type="hidden" name="madori_1" value="<%=houseSearchBean.getMadori(1)%>">      														
				<input type="hidden" name="madori_2" value="<%=houseSearchBean.getMadori(2)%>">      														
				<input type="hidden" name="madori_3" value="<%=houseSearchBean.getMadori(3)%>">      														
				<input type="hidden" name="madori_4" value="<%=houseSearchBean.getMadori(4)%>">      														
				<input type="hidden" name="madori_5" value="<%=houseSearchBean.getMadori(5)%>">      														
				<input type="hidden" name="madori_6" value="<%=houseSearchBean.getMadori(6)%>">      														
				<input type="hidden" name="madori_7" value="<%=houseSearchBean.getMadori(7)%>">      														
				<input type="hidden" name="madori_8" value="<%=houseSearchBean.getMadori(8)%>">      																						
				<input type="hidden" name="madori_9" value="<%=houseSearchBean.getMadori(9)%>">      														
				<input type="hidden" name="madori_10" value="<%=houseSearchBean.getMadori(10)%>">      														
				<input type="hidden" name="madori_11" value="<%=houseSearchBean.getMadori(11)%>">      														
				<input type="hidden" name="house_sort_0" value="<%=houseSearchBean.getHouse_sort(0)%>">      														
				<input type="hidden" name="house_sort_1" value="<%=houseSearchBean.getHouse_sort(1)%>">      														
				<input type="hidden" name="house_sort_2" value="<%=houseSearchBean.getHouse_sort(2)%>">      														
				<input type="hidden" name="house_sort_3" value="<%=houseSearchBean.getHouse_sort(3)%>">      														
				<input type="hidden" name="house_sort_4" value="<%=houseSearchBean.getHouse_sort(4)%>">      																														
				<input type="hidden" name="house_sort_5" value="<%=houseSearchBean.getHouse_sort(5)%>">      														
				<input type="hidden" name="house_sort_6" value="<%=houseSearchBean.getHouse_sort(6)%>">      														
				<input type="hidden" name="house_sort_7" value="<%=houseSearchBean.getHouse_sort(7)%>">      														
				<input type="hidden" name="house_option_0" value="<%=houseSearchBean.getHouse_option(0)%>">      														
				<input type="hidden" name="house_option_1" value="<%=houseSearchBean.getHouse_option(1)%>">      														
				<input type="hidden" name="house_option_2" value="<%=houseSearchBean.getHouse_option(2)%>">      														
				<input type="hidden" name="house_option_3" value="<%=houseSearchBean.getHouse_option(3)%>">      																										
	</form>
</body>
</html>

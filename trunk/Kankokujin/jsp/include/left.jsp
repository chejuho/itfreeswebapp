<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table width="224" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<!-- LOGIN START -->
		<td>
			<jsp:include page="../include/login.jsp" flush="true" />
		</td>
	</tr>
	<tr>
		<td height="5"></td>
	</tr>
  	<tr>
        <td>
    		<!-- Quick 검색 START -->            			
			<table id="Table_2" width="224"  border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="34" colspan="3" background="jsp/images/new/quick_01.gif"  style="padding-left:10px;">
					<table width="80%" border="0" cellspacing="0" cellpadding="0">
					<tr>
	            		<td width="11%"><img src="jsp/images/new/quick_icon.gif"   width="16" height="17" /></td>
	            		<td width="89%" align="left"><strong>Quick 검색</strong></td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
	            <td background="jsp/images/new/quick_02.gif"><img src="jsp/images/new/quick_02.gif" width="13" height="69" alt="" /></td>
	            <td width="198"  style="padding:5px 5px 5px 5px;">
	            	<a href="RoomSellList?re=9&cate_code_1=C10002&room_sort_0=0&room_sort_1=1&room_sort_2=2&room_sort_5=5" class="quick-link">
	            		기숙사(${QuickSearchCountBean.domi_count})
	            	</a>  
	            	<a href="RoomSellList?re=9&cate_code_1=C10002&room_sort_3=3" class="quick-link">
	            		룸메이트(${QuickSearchCountBean.roomshare_count})
	            	</a> <br />
	              	<a href="RoomSellList?re=9&cate_code_1=C10001&room_sort_8=8" class="quick-link">
	              		민박(${QuickSearchCountBean.minshuku_count})
	              	</a> 
	              	<!--<span class="red-text-w"><strong>호텔</strong></span>(102)-->
	              	<a href="RoomSellList?re=9&cate_code_1=C10001&room_sort_9=9&room_sort_10=10" class="quick-link">
	              		호텔(${QuickSearchCountBean.hotel_count})
	              	</a> 
	              	<a href="JobSearch?re=9&search_cate_code_1=C10100" class="quick-link">
	              		사원모집(${QuickSearchCountBean.staff_count})
	              	</a> <br />
	              	<a href="JobSearch?re=9&search_cate_code_1=C10200" class="quick-link">
	              		알바모집(${QuickSearchCountBean.arbeit_count})
	              	</a> </td>
	            <td background="jsp/images/new/quick_04.gif">
	            	<img src="jsp/images/new/quick_04.gif" width="13" height="69" alt="" />
	            </td>
			</tr>
			<tr>
				<td colspan="3"><img src="jsp/images/new/quick_05.gif" width="224" height="13" alt="" /></td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="5"></td>
	</tr>
	<tr>
		<td>
			<!-- Quick 등록 START --> 
			<table id="Table_3" width="224" border="0" cellpadding="0" cellspacing="0">
	  		<tr>
				<td height="34" colspan="3" background="jsp/images/new/quick_01.gif"  style="padding-left:10px;">
					<table width="80%" border="0" cellspacing="0" cellpadding="0">
	  				<tr>
						<td width="11%"><img src="jsp/images/new/quick_icon.gif"   width="16" height="17" /></td>
						<td width="89%" align="left"><strong>Quick 등록</strong></td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td background="jsp/images/new/quick_02.gif"><img src="jsp/images/new/quick_02.gif" width="13" height="69" alt="" /></td>
				<td width="198" style="padding:5px 5px 5px 5px;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="48%">
							· <a href="BuySellRegistOpen?before=search&f=search&before_cate_code_1=C10100" class="quick-link">물건사기등록</a> <br />
						  	· <a href="StoreRegistOpen?before=search&f=search" class="quick-link">업체찾기등록</a> <br />
						  	· <a href="RoomSellRegistOpen?cate_code_1=C10001&before=search&f=search" class="quick-link">호텔/민박등록</a><br />
						  	· <a href="HouseSellRegistOpen??before=search&f=search" class="quick-link">부동산등록 </a><br />
						  	· <a href="JobRegistOpen?before=search&f=search&cate_code_1=C10200" class="quick-link">알바구인등록</a> 
						</td>
						<td width="52%">
							· <a href="BuySellRegistOpen?before=search&f=search&&before_cate_code_1=C10200" class="quick-link">물건팔기등록</a><br />
						  	· <a href="GourmetRegistOpen?before=search&f=search" class="quick-link">음식점등록</a> <br />
						  	· <a href="RoomSellRegistOpen?cate_code_1=C10002&before=search&f=search" class="quick-link">기숙사/룸메등록 </a><br />
						  	· <a href="JobRegistOpen?before=search&f=search&cate_code_1=C10100" class="quick-link">사원구인등록 </a><br />
						  	· <a href="FindjobRegistOpen?before=search&f=search" class="quick-link">구직등록</a>
						</td>
					</tr>
					</table>
				</td>
				<td background="jsp/images/new/quick_04.gif"><img src="jsp/images/new/quick_04.gif" width="13" height="69" alt="" /></td>
			</tr>
			<tr>
				<td colspan="3"><img src="jsp/images/new/quick_05.gif" width="224" height="13" alt="" /></td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="5"></td>
	</tr>
	<tr>
		<td>
			<!-- Quick 업체찾기 START --> 						
			<table id="Table_4" width="224" border="0" cellpadding="0" cellspacing="0">
			<tr>
    			<td height="34" colspan="3" background="jsp/images/new/quick_01.gif"  style="padding-left:10px;">
    				<table width="80%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
       		 			<td width="11%"><img src="jsp/images/new/quick_icon.gif"   width="16" height="17" /></td>
        				<td width="89%" align="left"><strong>Quick 업체찾기</strong></td>
      				</tr>
    				</table>
				</td>
			</tr>
			<tr>
    			<td background="jsp/images/new/quick_02.gif">
    				<img src="jsp/images/new/quick_02.gif" width="13" height="69" alt="" />
    			</td>
    			<td width="198" style="padding:5px 5px 5px 5px;">
    				· <a href="StoreSearch?re=9&search_cate_code_1=C10100&search_cate_code_2=C20102" class="quick-link">나라시</a>   
    				· <a href="StoreSearch?re=9&search_cate_code_1=C10100&search_cate_code_2=C20104" class="quick-link">이사</a>   
    				· <a href="StoreSearch?re=9&search_cate_code_1=C10200&search_cate_code_2=C20202" class="quick-link">부동산</a> <br />
      				· <a href="StoreSearch?re=9&search_cate_code_1=C10500&search_cate_code_2=C20501" class="quick-link">리사이클</a>   
      				· <a href="StoreSearch?re=9&search_cate_code_1=C11100&search_cate_code_2=C21101" class="quick-link">미용실</a>  
      			 	· <a href="StoreSearch?re=9&search_cate_code_1=C10500&search_cate_code_2=C20513" class="quick-link">세탁소</a><br />
      				· <a href="StoreSearch?re=9&search_cate_code_1=C10700&search_cate_code_2=C20703" class="quick-link">한국식품</a> 
      			</td>
				<td background="jsp/images/new/quick_04.gif"><img src="jsp/images/new/quick_04.gif" width="13" height="69" alt="" /></td>
  				</tr>
  			<tr>
    			<td colspan="3"><img src="jsp/images/new/quick_05.gif" width="224" height="13" alt="" /></td>
  			</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="5"></td>
	</tr>
	<tr>
		<td>
			<table id="Table_5" width="224" height="131" border="0" cellpadding="0" cellspacing="0">
  				<tr>
				<td colspan="3"><img src="jsp/images/new/notice_01.gif" width="224" height="8" alt="" /></td>
  				</tr>
  				<tr>
				<td><img src="jsp/images/new/notice_02.gif" width="8" height="115" alt="" /></td>
				<td width="208" valign="top" style="padding:5px 5px 5px 5px;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
  					<tr>
    					<td><a href="InformList" class="quick-link"><strong>공지사항</strong></a></td>
    					<td align="right"><a href="InformList" class="quick-link"><img src="jsp/images/new/notice_more_b.gif" width="16" height="16" /></a></td>
  					</tr>
					<tr>
						<td height="2" colspan="2" bgcolor="#CCCCCC"></td>
					</tr>
					<tr>
						<td height="8" colspan="2" valign="top"></td>
					</tr>
  					<tr>
    					<td colspan="2" valign="top">
							<c:forEach var="InformBean" items="${InformBeanList}" >
								<a href="javascript:openDetailPage(9, '${InformBean.id}');">·${InformBean.title}<br /></a>
							</c:forEach>
						</td>
  					</tr>
					</table>
				</td>
				<td><img src="jsp/images/new/notice_04.gif" width="8" height="115" alt="" /></td>
			</tr>
			<tr>
				<td colspan="3"><img src="jsp/images/new/notice_05.gif" width="224" height="8" alt="" /></td>
			</tr>
			</table>
		</td>
	</tr>
</table>
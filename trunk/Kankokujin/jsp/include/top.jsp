<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@page import="common.bean.MemberBean, common.bean.SearchBean"%>
<%@page import="common.util.EnDecoding"%>
<%@page import="common.util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--Banner Process START -->
	<c:forEach var="Banner" items="${BannerList1}" varStatus="status">
		<input type="hidden" name="banner${status.index}" id="banner${status.index}" value="${Banner.bannerTag}"/>
		<c:if test="${status.last}">
			<input type="hidden" name="bannerIndex" id = "bannerIndex" value="${status.index}"/>
		</c:if>				
	</c:forEach>
	<c:forEach var="Banner" items="${BannerList2}" varStatus="status">
		<input type="hidden" name="ad${status.index}" id="ad${status.index}" value="${Banner.bannerTag}"/>
		<c:if test="${status.last}">
			<input type="hidden" name="adIndex" id = "adIndex" value="${status.index}"/>
		</c:if>				
	</c:forEach>
<!--Banner Process END -->
<form name="allsearch" method="post" action="AllSearch"> 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>	
		<td height="25" background="jsp/images/new/top_bg.gif">
			<table width="950"  height="25" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
			        <td width="687" class="top-font"><img src="jsp/images/new/top_icon.png"   align="absmiddle" width="11" height="16" /> 
		        		<span class="top-text">Kankokujin.com에오신것을 환영합니다.</span>
		        	</td>
			        <td width="263" align="right" class="top-text">
						<!--<a href="javascript:goBookMark('${memberInfo.userid}')" class="umenu-link"> 북마크</a>-->
						<a href="javascript:goBookMarkManager('${memberInfo.userid}')" class="umenu-link"> 북마크</a>
						<a href="javascript:bookmarksite('KANKOKUJIN.COM', 'http://www.kankokujin.com/')" target="_self">즐겨찾기설정하기</a>
					</td>
				</tr>
	    	</table>
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
	<tr>
		<td>
	    	<table width="950"  border="0" align="center" cellpadding="0" cellspacing="0">
	      	<tr><!--로고 -->
		        <td width="331"><a href="Index"><img src="jsp/images/new/logo.gif" width="331" height="41" border="0"></a></td>
		        <td width="98" align="right">&nbsp;</td>
		        <!--로그인,내가쓴글,회원정보등 -->
		        <td width="521" align="left" valign="bottom">
					<img src="jsp/images/new/top_m_icon1.gif"  align="absmiddle" width="16" height="19" />
					<c:if test="${!empty memberInfo.userid}">
						<a href="javascript:actionforward('MemberLogout')" class="top-link">로그아웃</a>&nbsp;
					</c:if>
					<c:if test="${empty memberInfo.userid}">
						<a href="javascript:actionforward('MemberLoginOpen')" class="top-link">로그인</a>&nbsp;
					</c:if>
					<img src="jsp/images/new/top_m_icon2.gif" align="absmiddle" width="16" height="17" /><a href="MyWrite" class="top-link"> 내가쓴글</a>&nbsp; 
					<img src="jsp/images/new/top_m_icon3.gif" align="absmiddle" width="16" height="16" /><a href="MemberDetail" class="top-link">회원정보</a>&nbsp; 
					<img src="jsp/images/new/top_m_icon4.gif" align="absmiddle" width="16" height="16" /><a href="TopRegist" class="top-link">등록하기</a>&nbsp; 
					<img src="jsp/images/new/top_m_icon5.gif" align="absmiddle" width="16" height="16" /><a href="FAQ" class="top-link">FAQ</a>&nbsp; 
					<img src="jsp/images/new/top_m_icon6.gif" align="absmiddle" width="16" height="16" /><a href="SiteMap" class="top-link">사이트맵</a>&nbsp; 
					<img src="jsp/images/new/top_m_icon7.gif" align="absmiddle" width="16" height="16" /><a href="ContactusRegistOpen" class="top-link">문의하기</a></strong>
				</td>
			</tr>
			</table>
		</td>
	</tr>
	<tr>
	<td height="6"></td>
	</tr>
	<tr>
	<td>
		<table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td valign="bottom"> <img src="jsp/images/new/menu_left.gif" width="23"  alt="" /></td>
			<td valign="bottom"><!--물건사기 --><a href="BuySellList?re=9&search_cate_code_1=C10100" ><img src="jsp/images/new/menu_01.gif" width="95" height="63" border="0" ></a></td>
			<td valign="bottom"><!--물건팔기 --><a href="BuySellList?re=9&search_cate_code_1=C10200" ><img src="jsp/images/new/menu_02.gif" width="104" height="63" border="0" ></a></td>
			<td valign="bottom"><!--업체찾기 --><a href="StoreSearch?re=9" ><img src="jsp/images/new/menu_03.gif" width="109" height="63" border="0" ></a></td>
			<td valign="bottom"><!--음식점 --><a href="GourmetSearch?re=9" ><img src="jsp/images/new/menu_04.gif" width="91" height="63" border="0" ></a></td>
			<td valign="bottom"><!--호텔/민박 --><a href="RoomSellList?re=9&cate_code_1=C10001" ><img src="jsp/images/new/menu_05.gif" width="114" height="63" border="0" ></a></td>
			<td valign="bottom"><!--기숙사 /룸메이트--><a href="RoomSellList?re=9&cate_code_1=C10002" ><img src="jsp/images/new/menu_06.gif" width="151" height="63" border="0" ></a></td>
			<td valign="bottom"><!--부동산 --><a href="HouseSellList?re=9" ><img src="jsp/images/new/menu_07.gif" width="98" height="63" border="0" ></a></td>
			<td valign="bottom"><!--구인 --><a href="JobSearch?re=9" ><img src="jsp/images/new/menu_08.gif" width="75" height="63" border="0" ></a></td>
			<td valign="bottom"><!--구직--><a href="FindjobSearch?re=9" ><img src="jsp/images/new/menu_09.gif" width="65" height="63" border="0" ></a></td>
			<td><img src="jsp/images/new/menu_right.gif" width="25" height="63" alt=""  /></td>
		</tr>
		<tr>
			<td height="52" colspan="11" background="jsp/images/new/all_search_bg.gif"><table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
            <td width="40" align="left"><img src="jsp/images/new/hot_search_icon.png" align="absmiddle" width="29" height="17" /></td>
            <td width="240" align="left">
            	<div id="banner"></div>
            </td>
            <!--검색-->
            <td width="360" align="left">
            	<select name="all_search_range" id="select">
	            	<option value='0'>통합검색</option>
					<option value='1' ${SearchBean.all_search_range1_selected}>물건사기</option>
					<option value='2' ${SearchBean.all_search_range2_selected}>물건팔기</option>					
					<option value='3' ${SearchBean.all_search_range3_selected}>업체찾기</option>		
					<option value='4' ${SearchBean.all_search_range4_selected}>음식점</option>
					<option value='7' ${SearchBean.all_search_range7_selected}>구인</option>
					<option value='8' ${SearchBean.all_search_range8_selected}>구직</option>			
             	</select>
             	<input type="text" name="all_search" id="all_search" style="width:190px; " value="${SearchBean.all_search}" />
                <a href="javascript:searchAll();"><img src="jsp/images/new/all_search_b.gif"  width="45" height="21" align="absmiddle"/></a>
           </td>
            <td width="40" class="top-ad"><img src="jsp/images/new/ad_icon.png" align="absmiddle" width="29" height="17" /></td>
            <td width="220"> <span class="style2" id="ad"></span></td>
          </tr>
        </table></td>
      	</tr>
    	</table>
    </td>
  </tr>
</form>
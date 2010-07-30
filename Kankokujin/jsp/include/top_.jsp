<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="common.bean.MemberBean, common.bean.SearchBean"%>
<%
request.setCharacterEncoding("UTF-8");
MemberBean member = new MemberBean();
SearchBean searchBean = (SearchBean) request.getAttribute("SearchBean");
String topmenu = (String)session.getAttribute("topmenu");
if(searchBean == null){
	searchBean = new SearchBean();
}
if(session.getAttribute("memberInfo")!=null){
	member = (MemberBean) session.getAttribute("memberInfo");	
}
%>

<%@page import="common.util.EnDecoding"%>
<script type="text/javascript">
	function logIn(){
		//window.open('PopLogin', 'notice', 'width=230, height=160');		
		document.allsearch.action="MemberLoginOpen";
		document.allsearch.submit(); 
	}
	function adminLogIn(){
		window.open('AdminLoginOpen', 'notice', 'width=230, height=160');		
	}	
</script>				
<%@page import="common.util.Util"%>
<table border="0" cellpadding="0" cellspacing="0" width="950" height="90">
	  <tr>
			<td><table border="0" cellspacing="0" cellpadding="0" bgcolor="e3dacb">
              <tr>
                <td width="423"><img src="jsp/images/main/img_topline_left.gif" width="4" height="4"></td>
                <td width="104"><img src="jsp/images/common/space.gif" width="1" height="1"></td>
                <td width="423"><div align="right"><img src="jsp/images/main/img_topline_right.gif" width="4" height="4"></div></td>
              </tr>
            </table></td>
	  </tr>
	  <tr>
	    <td><img src="jsp/images/common/space.gif" alt="" width="1" height="5"></td>
	    </tr>
		<tr valign="top">
			<td height="15" align="right"><!-- #BeginLibraryItem "/include/util.lbi" -->
            <table border="0" cellpadding="0" cellspacing="0">
          	  <tr valign="top">
	          	  <td>
	            <%if(!Util.isEmpty(member.getUserid())){ %>
	                <a href="MemberLogout"><img src="jsp/images/common/img_title_logout.gif"></a>
	                <img src="jsp/images/common/util_slide.gif" width="15" height="10">
	            <%}else{ %>		            
	                <img src="jsp/images/common/img_title_login.gif"onClick=logIn();>
	                <img src="jsp/images/common/util_slide.gif" width="15" height="10">
	            <%} %>

						<a href="MyWrite"><img src="jsp/images/common/img_title_mypage.gif"></a>	                
						<img src="jsp/images/common/util_slide.gif" width="15" height="10">	
	                    <a href="MemberDetail">
	                    <img src="jsp/images/common/img_title_member_info.gif"></a>
	                    <img src="jsp/images/common/util_slide.gif" width="15" height="10">
	                    <a href="TopRegist">
	                    <img src="jsp/images/common/img_title_regist.gif"></a>
	                    <img src="jsp/images/common/util_slide.gif" alt="" width="15" height="10">
	                    <a href="FAQ">
	                    <img src="jsp/images/common/img_title_f_a_q.gif"></a>
	                    <img src="jsp/images/common/util_slide.gif" alt="" width="15" height="10">
	                    <a href="SiteMap">
	                    <img src="jsp/images/common/img_title_sitemap.gif"></a>
	                    <img src="jsp/images/common/util_slide.gif" alt="" width="15" height="10">
	                    <a href="ContactusRegistOpen">
	                    <img src="jsp/images/common/img_title_contactus.gif"></a></td>
              </tr>
            </table>
			<!-- #EndLibraryItem --></td>
		</tr>
		<tr valign="top">
		  <td><a href="Index"><img src="jsp/images/common/logo.gif" width="207" height="30"></a></td>
		  </tr>
		<tr valign="top">
		  <td><!-- #BeginLibraryItem "/include/navi.lbi" -->
          <script type="text/javascript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
	function searchAll() {
		if(document.allsearch.all_search.value== "") {
			alert("검색어를 입력해 주세요.");
			return false;
		}		
		document.allsearch.action="AllSearch";
		document.allsearch.submit(); 	
		return true;
	}
//-->
          </script><br>
          
          <table width="950" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td>
                    <a href="BuySellList?re=9&search_cate_code_1=C10100">
                    <%if("buy".equals(topmenu)){%>
                    	<img src="jsp/images/common/top_menu_buy_over.gif" name="Image14" border="1" align="middle">
                    <%} else {%>
                    	<img src="jsp/images/common/top_menu_buy.gif" name="Image14" border="1" align="middle">
                    <%}%></a>

                    <a href="BuySellList?re=9&search_cate_code_1=C10200">
                    <%if("sell".equals(topmenu)){%>                    
                    	<img src="jsp/images/common/top_menu_sell_over.gif" name="Image15" border="0" align="middle">
                    <%} else {%>
                    	<img src="jsp/images/common/top_menu_sell.gif" name="Image15" border="0" align="middle">
                    <%}%></a>
                    <a href="StoreSearch?re=9">
                    <%if("store".equals(topmenu)){%>   
                    <img src="jsp/images/common/top_menu_store_over.gif" name="Image16" border="0" align="middle">
                    <%} else {%>
                    <img src="jsp/images/common/top_menu_store.gif" name="Image16" border="0" align="middle">
                    <%}%></a>
                    <a href="GourmetSearch?re=9">
                    <%if("gourmet".equals(topmenu)){%>   
                    <img src="jsp/images/common/top_menu_gourmet_over.gif" name="Image20" border="0" align="middle">
                    <%} else {%>
                    <img src="jsp/images/common/top_menu_gourmet.gif" name="Image20" border="0" align="middle">
                    <%}%></a>                                       
                    <a href="RoomSellList?re=9&cate_code_1=C10001">
                    <%if("roomsell1".equals(topmenu)){%>
                    <img src="jsp/images/common/top_menu_roomsell_over.gif" name="Image17" border="0" align="middle">
                    <%} else {%>
                    <img src="jsp/images/common/top_menu_roomsell.gif" name="Image17" border="0" align="middle">
                    <%}%></a>   
                 	<a href="RoomSellList?re=9&cate_code_1=C10002">
                    <%if("roomsell2".equals(topmenu)){%>
                    <img src="jsp/images/common/top_menu_roomsell1_over.gif" name="Image22" border="0" align="middle">
                    <%} else {%>
                    <img src="jsp/images/common/top_menu_roomsell1.gif" name="Image22" border="0" align="middle">
                    <%}%></a>                     
                    <a href="HouseSellList?re=9">
                    <%if("housesell".equals(topmenu)){%>
                    <img src="jsp/images/common/top_menu_housesell_over.gif" name="Image21" border="0" align="middle">
                    <%} else {%>
                    <img src="jsp/images/common/top_menu_housesell.gif" name="Image21" border="0" align="middle">
                    <%}%></a>
                    <a href="JobSearch?re=9">
                    <%if("job".equals(topmenu)){%>
                    <img src="jsp/images/common/top_menu_job_over.gif" name="Image18" border="0" align="middle">
                    <%} else {%>
                    <img src="jsp/images/common/top_menu_job.gif" name="Image18" border="0" align="middle">
                    <%}%></a>
                    <a href="FindjobSearch?re=9">
                    <%if("findjob".equals(topmenu)){%>
                    <img src="jsp/images/common/top_menu_findjob_over.gif" name="Image19" border="0" align="middle">
                    <%} else {%>
                    <img src="jsp/images/common/top_menu_findjob.gif" name="Image19" border="0" align="middle">
                    <%}%></a>
                    <a href="MenuSearch?ka=va">
  					<%if("nihongo".equals(topmenu)){%>
                    <img src="jsp/images/common/top_menu_findjob_over.gif" name="Image19" border="0" align="middle">
                    <%} else {%>
                    <img src="jsp/images/common/top_menu_findjob.gif" name="Image19" border="0" align="middle">
                    <%}%></a>

                    </td>
            </tr>
          </table>
          <form name="allsearch" method="post" style="margin:0" onSubmit="return searchAll()">  
		  <table border="0" width="950" align="center" background="jsp/images/common/top_bg.gif">
	    		<tr align="center">
	    		<td height="50" valign="middle">
						<select name='all_search_range' valign="middle">
							<option value='0'>통합검색</option>
							<option value='1' <%=searchBean.getAll_search_range1_selected()%>>삽니다</option>
							<option value='2' <%=searchBean.getAll_search_range2_selected()%>>팝니다</option>					
							<option value='3' <%=searchBean.getAll_search_range3_selected()%>>업체찾기</option>		
							<option value='4' <%=searchBean.getAll_search_range4_selected()%>>음식점</option>
							<option value='7' <%=searchBean.getAll_search_range7_selected()%>>구인</option>
							<option value='8' <%=searchBean.getAll_search_range8_selected()%>>구직</option>																													
	
						</select>
						<input type="text" name="all_search" value="<%=EnDecoding.decoding(searchBean.getAll_search())%>" maxlength="100">
						<input name="" type="image" src="jsp/images/common/btn_search.gif" alt="검색" onClick="return searchAll()">    			
	    		</td></tr>
		   	</table>          
		   	</form>  
		  <!-- #EndLibraryItem --></td>
		</tr>

		</table>	
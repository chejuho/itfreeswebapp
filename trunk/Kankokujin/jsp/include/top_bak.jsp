<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="common.bean.MemberBean"%>
<%
request.setCharacterEncoding("UTF-8");
MemberBean member = new MemberBean();
if(session.getAttribute("memberInfo")!=null){
	member = (MemberBean) session.getAttribute("memberInfo");	
}
%>

<script type="text/javascript">
	function logIn(){
		window.open('PopLogin', 'notice', 'width=230, height=160');		
	}
</script>				
<%@page import="common.util.Util"%>
<table border="0" cellpadding="0" cellspacing="0" width="950" height="90">
	  <tr>
			<td><table width="1000" border="0" cellspacing="0" cellpadding="0" bgcolor="e3dacb">
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
	            <%if(!Util.isEmpty(member.getUserid())){ %>
	                <td><a href="MemberLogout"><img src="jsp/images/common/img_title_logout.gif" width="34" height="10"></a></td>
	                <td valign="top"><img src="jsp/images/common/util_slide.gif" width="15" height="10"></td>
	            <%}else{ %>
	                <td><a href="javascript:logIn()">로그인</a></td>
	                <td valign="top"><img src="jsp/images/common/util_slide.gif" width="15" height="10"></td>
	            <%} %>
	                <td><!--img src="jsp/images/main/img_flash.gif"-->
	                    <a href="MemberDetail"><img src="jsp/images/common/img_title_member_info.gif" width="34" height="10"></a>
	                    <img src="jsp/images/common/util_slide.gif" width="15" height="10">
	                    <a href="07util/qna_list.html"><img src="jsp/images/common/img_title_q_and_a.gif" width="34" height="10"></a>
	                    <img src="jsp/images/common/util_slide.gif" alt="" width="15" height="10"><a href="07util/faq.html">
	                    <img src="jsp/images/common/img_title_f_a_q.gif" width="34" height="10"></a>
	                    <img src="jsp/images/common/util_slide.gif" alt="" width="15" height="10">
	                    <a href="07util/sitemap.html">
	                    <img src="jsp/images/common/img_title_sitemap.gif" width="60" height="10"></a>
	                    <img src="jsp/images/common/util_slide.gif" alt="" width="15" height="10">
	                    <a href="07util/mantoman.html"><img src="jsp/images/common/img_title_contactus.gif" width="60" height="10"></a></td>
              </tr>
            </table>
			<!-- #EndLibraryItem --></td>
		</tr>
		<tr valign="top">
		  <td><a href=""><img src="jsp/images/common/logo.gif" width="207" height="30"></a></td>
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
//-->
          </script>
          <table width="950" border="0" cellpadding="0" cellspacing="0" background="jsp/images/common/top_bg.gif">
            <tr>
              <td width="207"><img src="jsp/images/common/top_banner.gif" width="207" height="54"></td>
              <td width="733"><table width="602" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="71"><a href="BuySellList" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image15','','jsp/images/common/top_menu_buysell_over.gif',1)"><img src="jsp/images/common/top_menu_buysell.gif" name="Image15" width="71" height="23" border="0"></a></td>
                    <td width="21"><img src="jsp/images/common/top_menu_slide.gif" width="21" height="23"></td>
                    <td width="71"><a href="StoreList" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image16','','jsp/images/common/top_menu_store_over.gif',1)"><img src="jsp/images/common/top_menu_store.gif" name="Image16" width="71" height="23" border="0"></a></td>
                    <td width="21"><img src="jsp/images/common/top_menu_slide.gif" alt="" width="21" height="23"></td>
                    <td width="71"><a href="RoomSellList" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image17','','jsp/images/common/top_menu_roomsell_over.gif',1)"><img src="jsp/images/common/top_menu_roomsell.gif" name="Image17" width="71" height="23" border="0"></a></td>
                    <td width="21"><img src="jsp/images/common/top_menu_slide.gif" alt="" width="21" height="23"></td>
                    <td width="71"><a href="HouseSellList" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image21','','jsp/images/common/top_menu_housesell_over.gif',1)"><img src="jsp/images/common/top_menu_housesell.gif" name="Image21" width="71" height="23" border="0"></a></td>
                    <td width="21"><img src="jsp/images/common/top_menu_slide.gif" alt="" width="21" height="23"></td>
                    <td width="80"><a href="InterpretList" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image18','','jsp/images/common/top_menu_interpret_over.gif',1)"><img src="jsp/images/common/top_menu_interpret.gif" name="Image18" width="80" height="23" border="0"></a></td>
                    <td width="21"><img src="jsp/images/common/top_menu_slide.gif" alt="" width="21" height="23"></td>
                    <td width="80"><a href="EngMgnList" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image19','','jsp/images/common/top_menu_engmgn_over.gif',1)"><img src="jsp/images/common/top_menu_engmgn.gif" name="Image19" width="80" height="23" border="0"></a></td>
                  </tr>
              </table></td>
              <td width="10" align="right"><img src="jsp/images/common/top_bg_image.gif" width="10" height="54"></td>
            </tr>
          </table>
          
		  <!-- #EndLibraryItem --></td>
		</tr>

		</table>	
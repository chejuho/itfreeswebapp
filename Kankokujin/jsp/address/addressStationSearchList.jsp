<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<%@ page isELIgnored="false" %>
<%@ page import="common.bean.PageBean"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<%@page import="menu.Constant.*"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));
%>
<html>
<head>
<script type="text/javascript">


	/* 
	 * サーチボタンイベント処理 
	 * 引数：Form、menu番号
	 */
	function search(action, key, menuNo) {
		
		var searchSign = 0;
		//住所名で検索した場合
		if (action == 'address') {
			if (chk_empty($F("address_name"))) {
				alert("주소명을 입력해 주세요.");
				return false;
			}
			searchSign = 0;
			$("zip_code1").value = "";
			$("zip_code2").value = "";
			$("station_name").value = "";
		//郵便番号で検索した場合			
		} else if (action == 'zipcode') {
			if (chk_empty($F("zip_code1"))) {
				alert("우편번호을 입력해 주세요.");
				return false;
			}
			searchSign = 1;
			$("address_name").value = "";
			$("station_name").value = "";
		//駅を検索した場合				
		} else {
			if (chk_empty($F("station_name"))) {
				alert("우편번호을 입력해 주세요.");
				return false;
			}
			searchSign = 2;
			$("zip_code1").value = "";
			$("zip_code2").value = "";
			$("address_name").value = "";
		}
		document.list.action="MenuSearchAction?" + key + "="+menuNo + "&sign=" + searchSign + "&kb=vb";
		document.list.submit(); 
		return true;
	}
	
		/* 
	 * 整列ボタンイベント処理 
	 * 引数：Form、menu番号
	 */
	function pageSizeOpen(key, menuNo) {
		document.list.action="MenuSearchAction?" + key + "="+menuNo;
		document.list.submit(); 
		return true;
	}
	
	function reloadPage(obj) {
		document.list.action="MenuSearchAction?ka=vc&pageNum="+obj;
		document.list.submit(); 
		return true;
	}
	
	function chk_empty(str)
	{
 		if ( str.match(/\S/) == null || str.match(/\S/) == "" ) { return(true); }
 		else { return(false);}
	}

//-->
</script>
<script src = "jsp/Scripts/prototype.js" type="text/javascript" ></script>
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
	<form name="list" method="post" style="margin:0" action="MenuSearchAction">
  		<br>
    	<table width="950" border="0" cellspacing="0" cellpadding="0">
	    	<tr>
	    		<td>
	    			<img src="jsp/images/common/one_point.gif"><img src="jsp/images/common/top_info.gif">
	    		</td>
	    	</tr>    	
	    	<tr>
				<table border="1" bordercolor="#E2E0D6" rules="rows,cols" width="950">
					<tr>
					  <td width="40" style="padding-left:10" bgcolor="#F0F0E2">
					  	<font color="#2961EF">주소명<br>&nbsp;검색</font>
					  </td>
					  <td width="220">
						<input type="text" name="address_name" value="<c:out value="${searchBean['address_name']}"/>" maxlength="130"> 
						 &nbsp; &nbsp; 
						<img src="jsp/images/common/btn_search.gif" width="45" height="20" 
							onClick="return search('address', '<%=KEYConst.MENU%>','<%=VALUEConst.ADDRESSMENU%>')">
					  </td>
					   <td width="60" style="padding-left:10" bgcolor="#F0F0E2">
					  	<font color="#2961EF">우편번호<br> &nbsp; &nbsp;검색</font>
					  </td>
					  <td width="200">
						<input type="text" name="zip_code1"  value="<c:out value="${searchBean['zip_code1']}"/>" size="3" maxlength="3">－
						<input type="text" name="zip_code2"  value="<c:out value="${searchBean['zip_code2']}"/>" size="3" maxlength="4">	
						 &nbsp; &nbsp;
						<img src="jsp/images/common/btn_search.gif" width="45" height="20" 
							onClick="return search('zipcode', '<%=KEYConst.MENU%>','<%=VALUEConst.ADDRESSMENU%>')">
					  </td>
					   <td width="50" style="padding-left:10" bgcolor="#F0F0E2">
					  	<font color="#2961EF">역검색</font>
					  </td>
					  <td width="220">
						<input type="text" name="station_name" value="<c:out value="${searchBean['station_name']}"/>" maxlength="130"> 
						 &nbsp; &nbsp; 
						<img src="jsp/images/common/btn_search.gif" width="45" height="20" 
							onClick="return search('station', '<%=KEYConst.MENU%>','<%=VALUEConst.ADDRESSMENU%>')">
					  </td>
					</tr>
				</table> 
			</tr>	
		</table>
      	<br>
		<table border="0" width="950" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->	
					<table border="0" width="950" cellspacing="0" cellpadding="0">
						<tr>
							<td align="left"><img src="jsp/images/common/one_point.gif" width="6" height="12">
								
								<img src="jsp/images/common/title_info.gif" width="60" height="12">
								<!--<img src="jsp/images/common/title_mywrite.gif">-->
							</td>							
						<!--	
							<td style="padding:0 0px 5 0;"  align="right" > 열람개수 
								<select name='pageSize' onChange="return pageSizeOpen('<%=KEYConst.MENU%>','<%=VALUEConst.ADDRESSMENU%>')">
									<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10</option>
									<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20</option>
									<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50</option>
									<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100</option>
								</select>
							</td>
						-->
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
		<table border="1" cellpadding="0" cellspacing="0" width="950" bordercolor="#E2E0D6" rules="rows" style="border-collapse:collapse;">
			<col width="40"  align="center"><!--번호-->
			<col width="910"  align="center"><!--내용-->
			<tr height="35" style="font:bold 18px ArialBlack;">
				<td><font color="#82868C">내용</font></td>			
			</tr>
			<c:choose>
				<c:when test="${!empty menuBeanList}">
					<c:forEach var="menuBean" items="${menuBeanList}" >
							<tr height="50">
								<!-- 내용-->
								<td align="left">
									<c:if test="${!empty menuBean['zipcode']}">
					   					<B><c:out value="우편번호:"/></B><c:out value="${menuBean['zipcode']}"/>
					   				</c:if>
					   				<c:if test="${!empty menuBean['todoAddress']}">
										<B><c:out value="주소:"/></B><c:out value="${menuBean['todoAddress']}"/>
									</c:if>
									<c:if test="${!empty menuBean['sikuAddress']}">
										<c:out value="${menuBean['sikuAddress']}"/>
									</c:if>
									<c:if test="${!empty menuBean['address']}">
										<c:out value="${menuBean['address']}"/>
									</c:if>
									<c:if test="${!empty menuBean['line_name']}">
					   					<B><c:out value="라인:"/></B><c:out value="${menuBean['line_name']}"/>
					   				</c:if>
					   				<c:if test="${!empty menuBean['station_name']}">
					   					<B><c:out value="역:"/></B><c:out value="${menuBean['station_name']}"/>
					   				</c:if>
								</td>
							</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr height="30">
						<td colspan="14">
							<strong>해당 검색 리스트가 없습니다.</strong>
						</td>
					</tr>
	    		</c:otherwise>
    		</c:choose>
    		
    		<tr>
				<td height="3" style="background:#66A4EF;" colspan="14">
				</td>
			</tr>
		</table>																				
		<table border="0" cellpadding="0" cellspacing="0" height="20" align="center">
			<tr style="padding-top:10">
				<td>
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
				<!--<myTags:pageHandle /> --> 
				</td>
			</tr>					
			<!-- Page No-->
		</table>
	</form>    
    </div>
    <div id="bottom">
    	<jsp:include page="../include/footer.jsp" flush="true"/>
    </div>
</div>
</body>
</html>
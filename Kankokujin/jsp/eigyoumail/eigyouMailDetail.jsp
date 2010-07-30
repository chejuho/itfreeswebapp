<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="common.bean.PageBean"%>
<%@ page import="eigyoumail.bean.EigyoumailBean"%>
<%@ page import="common.util.Util"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>

<%
	EigyoumailBean eigyoumailBean = (EigyoumailBean) request.getAttribute("EigyoumailBean");
	PageBean pageBean = new PageBean();
	if(session.getAttribute("PageBean")!=null){
		pageBean = (PageBean)session.getAttribute("PageBean");
	}else{
		pageBean = new PageBean();
	}
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));	
	if ("MSG0003".equals(message)) {
	%>
		<script language="javascript">
			alert("<fmt:message key="MSG0003" bundle="${message}"/>");
		</script>
	<%}else if ("ERR0001".equals(message)) {
		%>
		<script language="javascript">
			alert("<fmt:message key="ERR0001" bundle="${message}"/>");
		</script>
	<%}else if ("MSG0004".equals(message)) {
		%>
		<script language="javascript">
			alert("<fmt:message key="MSG0004" bundle="${message}"/>");
		</script>
	<%}
	%>

<script type="text/javascript">
<!--

	function deleteCheck(id){
	
			if(confirm("<fmt:message key="MSG0011" bundle="${message}"/>")){
				location.href = "EigyouMailDelete?id="+id;
				return true;
			}
	}
	function sendMail(id){
	
			if(confirm("<fmt:message key="MSG0015" bundle="${message}"/>")){
				location.href = "EigyouMailSend?mail_id="+id;
				return true;
			}
	}	
	
	function popSendMail(id){
	<%if(member==null){ %>
		alert("<fmt:message key="WAR0004" bundle="${message}"/>");
		window.open('PopLogin', 'notice', 'width=230, height=160');
	<%}else{ %>
		window.open('SendMailOpen?toId='+id.value, 'notice', 'width=720, height=410, resizable=0, scrollbars=0, toolbar=0, status=0, menubar=0, top=0, left=0');
	<%}%>
	}
	
	function DownLoad(filename) {
		var file=filename.value;
		location.href = "InterpretDownLoad?filename="+file;
		return true;
	}
//-->
</script>
<html>
<head>
<title>캉코쿠진닷컴</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<script language="javascript" src="jsp/Scripts/top.js"></script>

<script src="jsp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet"
	type="text/css">
</head>

<body>
<table border="0" cellpadding="0" cellspacing="0" width="950"
	align="center">
	<!----- top메뉴 ------>
	<tr valign="top">
		<td colspan="3"><jsp:include page="../include/top.jsp"
			flush="true" /></td>
	</tr>

	<!----- 콘텐츠 영역 ----->
	<tr>


		<!-- 콘텐츠간 간격 -->
		<td width="10"><img src="jsp/images/common/space.gif" alt=""
			width="10" height="15"></td>
		<!-- 메인 콘텐츠 -->
		<td width="930" valign="top"><!-- 여기에 실제 메인 바디 소스코딩을 해주세요. -->
		<table border="0" cellpadding="0" cellspacing="0" width="930">
			<!---- Location ---->
			<tr height="30">
				<td align="right"><a href="">Home</a><b>통번역 회원정보</b></td>
			</tr>
			<!---- Location ---->
			<tr valign="top">
				<td>
				<table border="0" cellpadding="0" cellspacing="0" width="930"
					height="20">
					<tr>
						<td align="center"><img src="jsp/images/common/title_eigyou_mail_detail.gif"></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td align="center"></td>
			</tr>
		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="743">
			<tr valign="top" align="center">
				<td>
					
				
				<table width="800" border="1" align="center" cellspacing="0" bordercolor="#E2E0D6">
						<tr>
							<td>タイトル
							</td>
							<td><%=eigyoumailBean.getTitle()%>
							</td>
							<td>作成者：<%=eigyoumailBean.getUpdate_by_user_id()%>
							</td>
							<td><%=eigyoumailBean.getUpdate_date()%>
							</td>							
						</tr>
						<tr>
							<td>
								内容
							</td>
							<td colspan="3"><%=eigyoumailBean.getContents()%>
							</td>
						</tr>
				</table>
				</td>				
				<!-- 메인 콘텐츠 -->
			</tr>			
			<tr height="40">
				<td colspan="3"></td>
			</tr>
			<tr>
				<td>
					<table border="0" cellpadding="0" cellspacing="0" width="800" align="center">
					<tr height="2" bgcolor="#E2E0D6">
						<td></td>
					</tr>
					<tr style="padding-top:10">
						<td align="right">
						<a href="EigyouMailList?pageNum=<%=pageBean.getPageNum() %>&pageSize=<%=pageBean.getPageSize() %>">
							<img src="jsp/images/common/btn_list.gif" alt="">
						</a> &nbsp;

						<a href="EigyouMailUpdateOpen?id=<%=eigyoumailBean.getMail_id()%>"> <img src="jsp/images/common/btn_edit.gif" alt=""></a> &nbsp;
						<img src="jsp/images/common/btn_delete.gif" alt="" onclick='return deleteCheck(<%=eigyoumailBean.getMail_id()%>)'>
						<img src="jsp/images/common/btn_send_mail.gif" alt="" onclick='return sendMail(<%=eigyoumailBean.getMail_id()%>)'>						

						</td>
					</tr>				
				</table>
				</td>
			</tr>
			<tr valign="top">
				<td colspan="3"><jsp:include page="../include/footer.jsp"
					flush="true" /></td>
			</tr>
			
			<!----- Footer 영역 ----->
			
		</table>
		</td>		
	</tr>
</table>
</body>
</html>
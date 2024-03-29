<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="KO"/>
<fmt:setBundle basename="msg" var="message"/>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="interpret.bean.InterpretBean"%>
<%@ page import="common.util.Util"%>

<%
	InterpretBean interpret = (InterpretBean) session.getAttribute("InterpretBean");
	MemberBean member = new MemberBean();
	member = (MemberBean) session.getAttribute("memberInfo");
	String message = (String)Util.changeNullStr(request.getAttribute("Message"));	
%>

<script type="text/javascript">
<!--

	function deleteCheck(id){
	
			if(confirm("<fmt:message key="MSG0011" bundle="${message}"/>")){
				location.href = "InterpretDelete?id="+id;
				return true;
			}
	}
	
	function popSendMail(id){
	<%if(member==null){ %>
		alert("<fmt:message key="WAR0004" bundle="${message}"/>");
		
	<%}else{ %>
		window.open('SendMailOpen?toId='+id.value, 'notice', 'width=320, height=380, resizable=0, scrollbars=0, toolbar=0, status=0, menubar=0, top=0, left=0');
		<%}%>
	}
	
	function DownLoad() {
		var file=wf.filename.value;
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
		<form name="wf" method="post" enctype="multipart/form-data">
		<table border="0" cellpadding="0" cellspacing="0" width="930">
			<!---- Location ---->
			<tr height="30">
				<td align="right"><a href="">Home</a><b>통번역 회원정보확인</b></td>
			</tr>
			<!---- Location ---->
			<tr valign="top">
				<td>
				<table border="0" cellpadding="0" cellspacing="0" width="930"
					height="20">
					<tr>
						<td><img src="jsp/images/09housesell/img_title.gif"
							width="928" height="29"></td>
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
				<td style="padding:20 30">
					<font color="red"><%=message%></font><br>
				
				<table width="800" border="1" align="center" cellpadding="0"
						cellspacing="0" bordercolor="#E2E0D6" frame="void" rules="rows"
						style="border-collapse:collapse;">
						<col width="116" bgcolor="#F0F0E2" style="padding-left:10">
						<col width="332" style="padding-left:10">
						<col width="102" bgcolor="#F0F0E2" style="padding-left:10">
						<col width="120" style="padding-left:10">
						<tr>
							<td bgcolor="#ffffff" colspan="4"></td>
						</tr>
						<%if(member!=null){ %>
						<tr>							
							<td style="padding-left:20">이름</td>
							<td>
								<%=member.getName() %>
								<input type="hidden" name="user_id" value="<%=member.getUserid() %>">
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 이메일</td>
							<td>
								<%=member.getEmail1() %>@<%=member.getEmail2() %>
							</td>
						</tr>
						<%}else{ %>
						<tr height="28">
							<td style="padding-left:20">아이디</td>
							<td>
								<%=interpret.getUser_id() %>
								<input type="hidden" name="user_id" value="<%=interpret.getUser_id() %>">
							</td>
						</tr>	
						<tr>							
							<td style="padding-left:20">이름</td>
							<td>
								<%=interpret.getUser_name() %>
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 이메일</td>
							<td>
								<%=interpret.getEmail1() %>@<%=interpret.getEmail2() %>
							</td>
						</tr>
						<%} %>
						<tr>
							<td style="padding-left:20"> 전화번호</td>
							<td>
							    <table width="95%">
							    	<tr>
								    	<td  width="100" rowspan="2" align="center">
								    	국가번호<br/>
										 <%=interpret.getNation_no() %>							    		
								    	</td>
								    	<td  width="50" rowspan="2" align="center">
								    	</td>
								    	<td width="50">전화</td>
								    	<td>								    	
											: <%=interpret.getTel_no_1() %>	
								    	</td>
							    	</tr>
							    	<tr>
								    	<td>휴대전화</td>
								    	<td>	
											: <%=interpret.getTel_no_2() %>	
								    	</td>
							    	</tr>
							    	
							    </table>
							</td>
						</tr>	
						<tr>
							<td style="padding-left:20"> 통번역언어</td>
							<td>
								<%String[] language = interpret.getLanguage_name().split("/"); 
								for(int i=0;i<language.length;i++){								
								%>
								제<%=i+1 %>언어 : <%=language[i] %><br/>
								<%} %>
								그외의 언어 : <%=interpret.getLanguage_etc() %>
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 통번역가능지역</td>
							<td>
								서비스가능국가 : <%=interpret.getService_area_1_name() %><br>						
								상세지역 : <%=interpret.getService_area_2() %><br>
								기타서비스가능국가 : <%=interpret.getService_area_1_etc() %><br>
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 성별</td>
							<td>
								<%=interpret.getSex_name() %>	
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 생년월</td>
							<td>
				                <%if(!Util.isEmpty(interpret.getBirthday())){ %>
					        	    <%=interpret.getYear() %>년 <%=interpret.getMonth() %>월 (<%=interpret.getAge()%>세)
				                <%}%>
	               			 </td>
						</tr>
						<tr>
							<td style="padding-left:20"> 국적</td>
							<td>
								<%=interpret.getNationName() %>
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 사진</td>
							<td><img src="<%=interpret.getPhoto_path()%>"></td>
						</tr>
						<tr>
							<td style="padding-left:20"> 이력서</td>
							<td>
								<input type="hidden" name="userid" value="<%=interpret.getUser_id() %>">
								<input type="hidden" name="id" value="<%=interpret.getId() %>">
								<input type="hidden" name="filename" value="<%=interpret.getResume() %>">
								<input type="hidden" name="downcheck" value="<%=interpret.getResume() %>">
								<%if(!Util.isEmpty(interpret.getResume())){%>
									<a href="javascript:DownLoad()"><%=interpret.getResume() %></a>
								<%} %>
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 1일기준요금</td>
							<td>
								<%=interpret.getPay() %>
								<%=interpret.getPay_unit_name() %>
								<%=interpret.getPay_unit_etc() %>
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 경력</td>
							<td>
								<textarea name="service_day" rows="6" cols="90" readonly><%=interpret.getSkill() %></textarea>								
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 자격증</td>
							<td>
								<textarea name="certification" rows="6" cols="90" readonly><%=interpret.getCertification() %></textarea>								
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 자기소개</td>
							<td>
								<textarea name="introduction" rows="6" cols="90" readonly><%=interpret.getIntroduction() %></textarea>								
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 통번역가능일</td>
							<td>
								<textarea name="service_day" rows="6" cols="90" readonly><%=interpret.getService_day() %></textarea>							
							</td>
						</tr>
						<tr>
							<td style="padding-left:20"> 기타</td>
							<td>
								<textarea name="etc" rows="6" cols="90" readonly><%=interpret.getEtc() %></textarea>							
							</td>
						</tr>
	
						<tr>
							<td bgcolor="#ffffff" colspan="2"></td>
						</tr>						
					</table>
				<table border="0" cellpadding="0" cellspacing="0" width="800" align="center">
					<tr height="2" bgcolor="#E2E0D6">
						<td></td>
					</tr>
					<tr style="padding-top:10">
						<td align="right">
							<a href="InterpretRegist"><img src="jsp/images/common/btn_cs_ok.gif" alt=""></a> 
							<a href="InterpretRegistOpen"><img src="jsp/images/common/btn_cs_rewrite.gif"></a>&nbsp;
							<a href="InterpretList"><img src="jsp/images/common/btn_cs_cancel.gif"></a>
						</td>
					</tr>				
				</table>
				</td>				
				<!-- 메인 콘텐츠 -->
			</tr>			
			<tr height="40">
				<td colspan="3"></td>
			</tr>

			<tr valign="top">
				<td colspan="3"><jsp:include page="../include/footer.jsp"
					flush="true" /></td>
			</tr>
			
			<!----- Footer 영역 ----->
			
		</table>
		</form>
		</td>		
	</tr>
</table>
</body>
</html>
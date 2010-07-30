<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@page import="common.util.EnDecoding"%>
<%@page import="common.util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="util" uri="util" %>
<fmt:setLocale value="${LocaleInfo}"/>
<fmt:setBundle basename="aFlashcard" var="message"/>
<script type="text/javascript">

	function loginform_clearbg(type) {
		if (type == "id") {
			document.lf.id.style.backgroundImage = '';
		} else if (type == "pw") {
			document.lf.pw.style.backgroundImage = '';
		}
	}
	function loginform_bgChange(obj, act) {
		if ( act == 'F') {
			obj.className = 'login';
			obj.style.backgroundColor='#FFFFFF';
		} else {
			obj.className = 'login';
			obj.style.backgroundColor='#FFFFFF';	
		}			
	}
	function logout() {		
		document.lf.action="logout";
		document.lf.submit();		
	}
	function languageChange(id) {		
		document.lf.action="list?userId=" + id;
		document.lf.submit();		
	}
	
	
	
	function login(f) {
		if(f.id.value==""){
			alert("<fmt:message key="top.msg.input_err_id" bundle="${message}"/>");
			f.id.focus();
			return;
		}else if(f.pw.value==""){
			alert("<fmt:message key="top.msg.input_err_pwd" bundle="${message}"/>");
			f.pw.focus();
			return;
		}else{
			f.action="login";
			f.submit();
		}
				
	}
	function Keycode(e){
		var result;
		if(window.event) {		
	    	result = window.event.keyCode;
	    } else if(e) {
			result = e.which;
		}
		return result;
	}

</script>
	<tr>
		<td>
	    	<table align="center" cellpadding="0" cellspacing="0">
	    	<form name="lf" method="post" style="margin:0">
	      	<tr><!--로고 -->
		        <!--로그인,내가쓴글,회원정보등 -->
		        <td width="70%" colspan="2" align="right" valign="middle">
		        	<table >
		        		<tr>
				        	<c:if test="${empty M_memberInfo}">
				        	<td>
				        		<fmt:message key="top.label.id" bundle="${message}"/>
				        	</td>
				        	<td>
				        		<input type="text" name="id" id="textfield2" class="idForm" style="height:23px; width:80px;" onkeydown="if(Keycode(event) ==13) login(lf);" onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');"  tabindex="1" align="absmiddle"/>
							</td>
							<td>
								<fmt:message key="top.label.pwd" bundle="${message}"/>
							</td>
							<td>
								<input type="password" name="pw" id="textfield3"  style="height:23px; width:80px;" onkeydown="if(Keycode(event) ==13) login(lf);" onFocus="loginform_clearbg('id');loginform_bgChange(this,'F')" onBlur="loginform_bgChange(this,'B');" onMouseDown="javascript:MouseUp1=true;" onKeyDown="javascript:KeyUp1=true;" tabindex="2" align="absmiddle"/>
							</td>							
							</c:if>
							<c:if test="${!empty M_memberInfo}">
							<td>
				        		<c:out value="${util:cutLongName(10,M_memberInfo.name)}" /></strong><fmt:message key="top.label.nameGuest" bundle="${message}"/>
				        	</td> 
							</c:if>
							<td>
								<img src="<fmt:message key="top.image.log" bundle="${message}"/>"  align="absmiddle" />
							</td>
							<c:if test="${!empty M_memberInfo}">
								<td>
									<a href="javascript:logout()" class="top-link"><fmt:message key="top.label.logout" bundle="${message}"/></a>&nbsp;
								</td>
							</c:if>
							<c:if test="${empty M_memberInfo}">
								<td>
									<a href="javascript:login(lf)" class="top-link"><fmt:message key="top.label.login" bundle="${message}"/></a>&nbsp;
								</td>
							</c:if>
							<td>
								<img src="<fmt:message key="top.image.createAccount" bundle="${message}"/>"  align="absmiddle"  /><a href="memberregistopen" target="_self" tabindex="4" class="top-link" ><fmt:message key="top.label.createAccount" bundle="${message}"/></a></strong></span> &nbsp;&nbsp;
							</td>
							<td>
								<img src="<fmt:message key="top.image.aFlashcardList" bundle="${message}"/>" align="absmiddle" /><a href="list" class="top-link"> <fmt:message key="top.label.aFlashcardList" bundle="${message}"/></a>&nbsp; 
							</td>
							<td>
								<img src="<fmt:message key="top.image.myaFlashcardList" bundle="${message}"/>" align="absmiddle" /><a href="mylist" class="top-link"><fmt:message key="top.label.myaFlashcardList" bundle="${message}"/></a>&nbsp;
							</td>
		        			<td>
				        		<a href="javascript:languageChange('k_admin')" target="_self" tabindex="4" class="top-link" >
				        			<img src="jsp/images/aFlashcard/common/korea.png"  width="24" height="24" align="absmiddle"  />
				        		</a>
				        	</td>
				        	<td>
				        		<a href="javascript:languageChange('j_admin')" target="_self" tabindex="4" class="top-link" >
				        			<img src="jsp/images/aFlashcard/common/japan.png" width="24" height="24" align="absmiddle"  />
				        		</a>
				        	</td>
				        	<td>
				        		<a href="javascript:languageChange('e_admin')" target="_self" tabindex="4" class="top-link" >
				        			<img src="jsp/images/aFlashcard/common/usa.png"  width="24" height="24" align="absmiddle"  />
				        		</a>
				        	</td>
				        	<!--    <td>
				        		<a href="javascript:languageChange('c_admin')" target="_self" tabindex="4" class="top-link" >
									<img src="jsp/images/aFlashcard/common/china.png"  align="absmiddle"  />
								</a>
				        	</td> -->
						</tr>
					</table> 
				</td>
			</tr>
			</form>
			</table>
		</td>
	</tr>
	<tr>
		<td height="6"></td>
	</tr>
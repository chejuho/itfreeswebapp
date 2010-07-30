<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page session="true"%>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="engmgn.bean.EngMgnBean"%>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="common.util.Util"%>
<%@page import="common.constant.Const"%>
<html>
<script type="text/javascript">
<!--
		function checkNow(){
			var check = form.now.checked;
			if(check){
				form.year.value="";
				form.month.value="";
				form.year.disabled=true;
				form.month.disabled=true;
			}else{
				form.year.disabled=false;
				form.month.disabled=false;			
			}		
		}
		
		function isNull(obj) {
			if(obj.value == "") {
				return true;
			}
		}
		
		function isMonth(obj) {
			if(obj.value <= 12) {
				return true;
			}
		}
		
		function isNumber(obj) {
			var str = obj.value;
			if(str.length == 0){
			alert(str.length);
				return false;
			}
			for(var i=0; i < str.length; i++) {
				if(!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
					return false;
			}
			return true;
		}
		
		function submitForm(ff){
		
		    if(ff.initial.value==""){
				alert("イニシャルを入力してください。");
				ff.initial.focus();
				return false;
			}
			if(ff.name1.value==""){
				alert("性を入力してください。");
				ff.name1.focus();
				return false;
			}
			if(ff.name2.value==""){
				alert("名を入力してください。");
				ff.name2.focus();
				return false;
			}
			if(ff.age.value==""){
				alert("年齢を入力してください。");
				ff.age.focus();				
				return false;
			}
			if(!isNumber(ff.age)) {
				alert("年齢は数字で入力してください。");
				ff.age.focus();
				return false;
			}		
			if(ff.career.value==""){
				alert("経歴を入力してください。");
				ff.career.focus();
				return false;
			}
			if(!isNumber(ff.career)) {
				alert("経歴は数字で入力してください。");
				ff.career.focus();
				return false;
			}		
			if(ff.nation[0].checked == false&&ff.nation[1].checked == false&&
			    ff.nation[2].checked == false){
				alert("国籍を選んでください。");
				ff.nation[0].focus();
				return false;
			}
			if(ff.nation[2].checked == true && ff.nation_etc.value==""){
				alert("国籍その他を入力してください。");
				ff.nation_etc.focus();
				return false;
			}
			if(ff.type[0].checked == false&&ff.type[1].checked == false&&
			   ff.type[2].checked == false&&ff.type[3].checked == false){
				alert("区分を選んでください。");
				ff.type[0].focus();
				return false;
			}
			if(ff.os[0].checked == false&&ff.os[1].checked == false&&
			    ff.os[2].checked == false&&ff.os[3].checked == false){
				alert("機種/OS を選んでください。");
				ff.os[0].focus();
				return false;
			}
			if(ff.os[3].checked == true && ff.os_etc.value==""){
				alert("機種/OS その他を入力してください。");
				ff.os_etc.focus();
				return false;
			}
			if(ff.os_etc.value!=null){
			    if(ff.os[0].checked == false&&ff.os[1].checked == false&&
			       ff.os[2].checked == false&&ff.os[3].checked == false){
					alert("機種/OS その他をチェクしてください。");
					return false;
				}
			}
			if(ff.db[0].checked == false&&ff.db[1].checked == false&&
			    ff.db[2].checked == false&&ff.db[3].checked == false){
			    alert("DBを選んでください。");
				return false;
			}
			if(ff.db[3].checked == true && ff.db_etc.value==""){
				alert("DB その他を入力してください。");
				ff.db_etc.focus();
				return false;
			}
			if(ff.db_etc.value!=null&&ff.db[0].checked == false&&ff.db[1].checked == false&&
			    ff.db[2].checked == false){
			   if(ff.db[3].checked == false){
					alert("DB その他をチェクしてください。");
					return false;
				}
			}
			if(ff.language[0].checked == false&&ff.language[1].checked == false&&
			    ff.language[2].checked == false&&ff.language[3].checked == false&&
			    ff.language[4].checked == false&&ff.language[5].checked == false){
				alert("対応可能言語を選んでください。");
				return false;
			}
			if(ff.language[5].checked == true && ff.language_etc.value==""){
				alert("対応可能言語 その他を入力してください。");
				ff.language_etc.focus();
				return false;
			}
			if(ff.language_etc.value!=""){
			    if(ff.language[5].checked == false){
					alert("対応可能言語 その他をチェクしてください。");
					return false;
				}
			}
			if(ff.process[0].checked == false&&ff.process[1].checked == false&&
			    ff.process[2].checked == false&&ff.process[3].checked == false&&
			    ff.process[4].checked == false&&ff.process[5].checked == false&&
			    ff.process[6].checked == false){
				alert("経験工程を選んでください。");
				return false;
			}
			if(ff.jap[0].checked == false&&ff.jap[1].checked == false&&
			    ff.jap[2].checked == false&&ff.jap[3].checked == false){
				alert("日本語能力を選んでください。");
				return false;
			}
			if(ff.now.checked == false && ff.year.value == "" && ff.month.value == ""){
				alert(" 投入可能時期を入力してください。");
				ff.year.focus();
				return false;
			}
			if(!isNull(ff.salary) && !isNumber(ff.salary)) {
				alert("希望値段は数字で入力してください。");
				ff.salary.focus();
				return false;
			}				
			if(!isNull(ff.year) && !isNumber(ff.year)) {
				alert(" 投入可能時期(年)は数字で入力してください。");
				ff.year.focus();
				return false;
			}			
			if(!isNull(ff.month) && !isNumber(ff.month)) {
				alert(" 投入可能時期(月)は数字で入力してください。");
				ff.month.focus();
				return false;
			}					
			if(isNull(ff.year) && !isNull(ff.month)) {
				alert("投入可能時期(年)を入力してください。");
				ff.month.focus();
				return false;
			}		
			if(!isMonth(ff.month)) {
				alert("投入可能時期(月)は12まで入力してください。");
				ff.month.focus();
				return false;
			}			
			if(confirm("修正しますか？")){
				ff.action="EngMgnUpdate";
			    ff.submit(); 
			    return true;
			}
		}
	function etcNation(value){
  		if(value=="9"){
   		//텍스트 입력 보이기
  		 document.getElementById("nation_etc").style.display = "inline";
 		 }else{
 		  //텍스트 입력 보이지 않기
 		  document.getElementById("nation_etc").style.display = "none";
 		  form.nation_etc.value="";
 		 }
	}
	function etcLanguage(value){
  		if(value==true){
   		//텍스트 입력 보이기
  		 document.getElementById("language_etc").style.display = "inline";
 		 }else{
 		  //텍스트 입력 보이지 않기
 		  document.getElementById("language_etc").style.display = "none";
 		  form.language_etc.value="";
 		 }
	}
	function etcDb(value){
  		if(value==true){
   		//텍스트 입력 보이기
  		 document.getElementById("db_etc").style.display = "inline";
 		 }else{
 		  //텍스트 입력 보이지 않기
 		  document.getElementById("db_etc").style.display = "none";
 		  form.db_etc.value="";
 		 }
	}
	function etcOs(value){
  		if(value==true){
   		//텍스트 입력 보이기
  		 document.getElementById("os_etc").style.display = "inline";
 		 }else{
 		  //텍스트 입력 보이지 않기
 		  document.getElementById("os_etc").style.display = "none";
 		  form.os_etc.value="";
 		 }
	}
	
	function reload(){
		var nation = form.nation[2].checked;
		etcNation(nation);
		var os = form.os[3].checked;
		etcOs(os);
		var db = form.db[3].checked;
		etcDb(db);
		var language = form.language[5].checked;
		etcLanguage(language);
	}
	//-->
</script>
<head>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../../css/ITFreesMallStyle.css" tyep="text/css"
	rel="stylesheet" />
<title>ENGINEER DETAILFORM</title>
</head>
<body onload="reload()">
<br>
<table width="70%" border="0" cellpadding="0" cellspacing="1" align="center">
	<tr>
		<td>
			<b><font size=4>技術者情報修正</font></b>
		</td>
	</tr>
	<tr>
		<td>
			<font color="red">&nbsp;&nbsp;*&nbsp;</font>マークされた部分は必ず入力してください。
		</td>
	</tr>
</table>
<%  
	MemberBean userInfo = (MemberBean) session.getAttribute("memberInfo");
	String session_id =null;
	if(userInfo != null){
		session_id = userInfo.getUserid();
	}
	EngMgnBean bean =(EngMgnBean)request.getAttribute("bean");
	
	String eng_possibledate= bean.getEng_possibledate();
	%>
<form name="form"  method="post" enctype="multipart/form-data">
  <input type=hidden name="session_id" value="<%=session_id%>">
  <input type=hidden name="eng_id" value="<%=bean.getEng_id()%>">

<table width="70%" border="0" cellpadding="4" cellspacing="1" align="center">
    <tr><td bgcolor=#E0E0E0><font color="red">&nbsp;&nbsp;*&nbsp;</font>イニシャル</td>
	    <td bgcolor=#E0E0E0 align="left" colspan="5"><input type="text" name="initial" size="25%" value="<%=bean.getEng_initial()%>">
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0><font color="red">&nbsp;&nbsp;*&nbsp;</font>名前</td>
		<td bgcolor=#E0E0E0 align="left" colspan="5">
		    姓&nbsp;&nbsp;<input type="text" name="name1" size="" value="<%=bean.getEng_name1()%>">
		    名&nbsp;&nbsp;<input type="text" name="name2" size="" value="<%=bean.getEng_name2()%>">
	    </td>	    
	</tr>
	<tr>
		<td bgcolor=#E0E0E0><font color="red">&nbsp;&nbsp;*&nbsp;</font>性別</td>
		<td bgcolor=#E0E0E0>
			<input type="radio" name="sex" value="0" <%=bean.getSex_checked()[0] %>> 男
		    <input type="radio" name="sex" value="1" <%=bean.getSex_checked()[1] %>> 女
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0><font color="red">&nbsp;&nbsp;*&nbsp;</font>年齢</td>
		<td bgcolor=#E0E0E0 align="left" colspan="5"><input type="text" name="age" size="25%" maxlength="3"  value="<%=bean.getEng_age()%>">歳
		</td>
	</tr>
	<tr><td bgcolor=#E0E0E0><font color="red">&nbsp;&nbsp;*&nbsp;</font>経歴</td>
		<td bgcolor=#E0E0E0 align="left" colspan="5"><input type="text" name="career" size="25%" maxlength="2"  value="<%=bean.getEng_career()%>">年
	</td>
	</tr>
	<tr><td bgcolor=#E0E0E0><font color="red">&nbsp;&nbsp;*&nbsp;</font>国籍</td>
		<td bgcolor=#E0E0E0 align="left" colspan="5">
	        <input type="radio" name="nation" value="1" <%=bean.getNation_checked()[0] %> onclick="javascript:etcNation(this.value);"> 韓国
	        <input type="radio" name="nation" value="2" <%=bean.getNation_checked()[1] %> onclick="javascript:etcNation(this.value);"> 日本
	    	<input type="radio" name="nation" value="9" <%=bean.getNation_checked()[2] %> onclick="javascript:etcNation(this.value);">その他&nbsp;
	    	   	<div name="lytext" id="nation_etc" style="display:none">
					: <input type="text" size="20" name="nation_etc" value="<%=bean.getEng_nation_etc() %>">
				</div>
	    </td>
	</tr>  
	<tr>
		<td height="20" font="20">&nbsp;&nbsp;<b>技術者 詳細 情報</b>&nbsp;&nbsp;</td>
		<td align="left" colspan="5">	
	<%if(userInfo != null && (Const.ADMIN_LEVEL).equals(userInfo.getUser_level())){		%>
	  	    <input type="checkbox" name="viewflg" value="1"> 未確定
	<%} %>
		</td>
	</tr>
	<tr><td bgcolor=#E0E0E0><font color="red">&nbsp;&nbsp;*&nbsp;</font>区分</td>
	    <td bgcolor=#E0E0E0 align="left" colspan="5">	    
	        <input type="radio" name="type" value="1" <%=bean.getEngType_checked()[0] %>> 正社員
	    	<input type="radio" name="type" value="2" <%=bean.getEngType_checked()[1] %>> 契約社員
	    	<input type="radio" name="type" value="3" <%=bean.getEngType_checked()[2] %>> フリー
	    	<input type="radio" name="type" value="4" <%=bean.getEngType_checked()[3] %>> 協力社員
	    </td>
    </tr>
    <tr><td bgcolor=#E0E0E0 size="20%" ><font color="red">&nbsp;&nbsp;*&nbsp;</font>機種/OS</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	  	    <input type="checkbox" name="os" value="1" <%=bean.getOsType_checked()[0] %>> Linux
	    	<input type="checkbox" name="os" value="2" <%=bean.getOsType_checked()[1] %>> Unix
	    	<input type="checkbox" name="os" value="3" <%=bean.getOsType_checked()[2] %>> Windows
	    	<input type="checkbox" name="os" value="9" <%=bean.getOsType_checked()[3] %> onclick="javascript:etcOs(this.checked);"> その他 	    	
	    	   	<div name="lytext" id="os_etc" style="display:none">
					: <input type="text" size="20" name="os_etc" value="<%=bean.getEng_os_etc() %>">
				</div>
	    
		</td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%" ><font color="red">&nbsp;&nbsp;*&nbsp;</font>DB</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <input type="checkbox" name="db" value="1" <%=bean.getDbType_checked()[0] %>> MySQL
		   	<input type="checkbox" name="db" value="2" <%=bean.getDbType_checked()[1] %>> MsSQL
		   	<input type="checkbox" name="db" value="3" <%=bean.getDbType_checked()[2] %>>Oracle
		   	<input type="checkbox" name="db" value="9"  <%=bean.getDbType_checked()[3] %> onclick="javascript:etcDb(this.checked);"> その他 	    	
	    	   	<div name="lytext" id="db_etc" style="display:none">
					: <input type="text" size="20" name="db_etc" value="<%=bean.getEng_db_etc() %>">
				</div>
	  	 </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%" ><font color="red">&nbsp;&nbsp;*&nbsp;</font>対応可能言語</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <input type="checkbox" name="language" value="1" <%=bean.getLanguage_checked()[0] %>> JAVA
	        <input type="checkbox" name="language" value="2" <%=bean.getLanguage_checked()[1] %>> C
	    	<input type="checkbox" name="language" value="3" <%=bean.getLanguage_checked()[2] %>> C#
	    	<input type="checkbox" name="language" value="4" <%=bean.getLanguage_checked()[3] %>> VB
	    	<input type="checkbox" name="language" value="5" <%=bean.getLanguage_checked()[4] %>> .NET
	    	<input type="checkbox" name="language" value="9"  <%=bean.getLanguage_checked()[5] %> onclick="javascript:etcLanguage(this.checked);"> その他 	    	
	    	   	<div name="lytext" id="language_etc" style="display:none">
					: <input type="text" size="20" name="language_etc" value="<%=bean.getEng_language_etc() %>">
				</div>
	    	
	    </td>
	</tr>
	
	<tr><td bgcolor=#E0E0E0 size="20%" ><font color="red">&nbsp;&nbsp;*&nbsp;</font>経験工程</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <input type="checkbox" name="process" value="1" <%=bean.getProcess_checked()[0] %>>  要件定義 
	    	<input type="checkbox" name="process" value="2" <%=bean.getProcess_checked()[1] %>>  基本設計 
	    	<input type="checkbox" name="process" value="3" <%=bean.getProcess_checked()[2] %>>  詳細設計 
	    	<input type="checkbox" name="process" value="4" <%=bean.getProcess_checked()[3] %>>  製造
	    	<input type="checkbox" name="process" value="5" <%=bean.getProcess_checked()[4] %>>  単体テスト
	    	<input type="checkbox" name="process" value="6" <%=bean.getProcess_checked()[5] %>>  結合テスト
	    	<input type="checkbox" name="process" value="7" <%=bean.getProcess_checked()[6] %>>  システムテスト
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%" ><font color="red">&nbsp;&nbsp;*&nbsp;</font>日本語能力</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	    　　<input type="radio" name="jap" value="1" <%=bean.getJap_checked()[0] %>>  流暢 
	        <input type="radio" name="jap" value="2" <%=bean.getJap_checked()[1] %>>  上 
    	    <input type="radio" name="jap" value="3" <%=bean.getJap_checked()[2] %>>  中 
    	    <input type="radio" name="jap" value="4" <%=bean.getJap_checked()[3] %>>　下
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;技術資格証</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <input type="text" name="skilllicense" size="25%" value="<%=bean.getEng_skilllicense()%>"> 
	    
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;日本語資格証</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <input type="text" name="japlicense" size="25%" value="<%=bean.getEng_japlicense()%>"> 
	    
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;アピールポイント</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <input type="text" name="ment" size="80%" value="<%=bean.getEng_ment()%>"> 
	    
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%" >&nbsp;&nbsp;投入可能時期</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	      <% if(eng_possibledate.equals("now")){%>
		        <input type="text" name="year"size="10%">年
		        <input type="text" name="month"size="5%">月
		        <input type="checkbox" name="now" value ="now" checked onclick="javascript:checkNow()">即可能
	       <%}else{%>
		        <input type="text" name="year"size="10%" value="<%=eng_possibledate.substring(0,4)%>">年
		        <input type="text" name="month"size="5%" value="<%=eng_possibledate.substring(4,6)%>">月
		        <input type="checkbox" name="now" value ="now" onclick="javascript:checkNow()">即可能
	       <%} %>
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%" >&nbsp;&nbsp;希望値段</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <input type="text" name="salary" size="25%" value="<%=bean.getEng_salary()%>">万円/月
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%" >&nbsp;&nbsp;営業状況</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	       <input type="text" name="state" size="25%" value="<%=bean.getEng_state()%>">
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%" >&nbsp;&nbsp;スキルシート</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
			<%if(!Util.isEmpty(bean.getEng_filename())){%>
			<%=bean.getEng_filename()%><br>
			<%} %>
	       <input type="file" name="file" size="25%">
	    </td>
	</tr>
	<tr><td colspan="6" align="center" bgcolor=#E0E0E0>
 	
			<img src="jsp/images/common/btn_cs_ok.gif" onclick="submitForm(form)" style=cursor:hand;>
			<a href="EngMgnUpdateOpen?eng_id=<%=bean.getEng_id()%>"><img src="jsp/images/common/btn_cs_rewrite.gif"></a>&nbsp;
			<a href="EngMgnDetail?eng_id=<%=bean.getEng_id()%>"><img src="jsp/images/common/btn_csnotice_list.gif"></a>
	    </td>
	</tr>
	
	
</table>

</form>
</body>
</html>
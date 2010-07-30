<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page session="true"%>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="engmgn.bean.EngMgnBean"%>

<% request.setCharacterEncoding("utf-8"); 

	
	MemberBean userInfo = (MemberBean) session.getAttribute("memberInfo");
	String session_id =null;
	if(userInfo != null) {
		session_id = userInfo.getUserid();
	}
	
	EngMgnBean bean =(EngMgnBean)request.getAttribute("bean");

%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="common.constant.Const"%>
<html>
<script type="text/javascript">
<!--	  
		function deleteSubmit(eng_id){
			if(confirm("削除しますか？")){
			    location.href ="EngMgnDelete?eng_id="+eng_id.value;
			}
		}
		
		function DownLoad(filename) {
			var file=filename.value;
			location.href = "DownLoad?filename="+file;
			return true;
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
<body>
<br>
<table width="80%" border="0" cellpadding="3" cellspacing="1" align="center">
	<tr>
		<td>
			<b><font size="4">技術者詳細情報</font></b>
		</td>
	</tr>
</table>

<table width="80%" border="0" cellpadding="3" cellspacing="1" align="center">
    <tr>
    <td bgcolor=#E0E0E0 width="20%">&nbsp;&nbsp;イニシャル</td>
	    <td bgcolor=#E0E0E0 align="left" colspan="5"><%=bean.getEng_initial()%>
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0>&nbsp;&nbsp;名前</td>
	    <td bgcolor=#E0E0E0 align="left" colspan="5"><%=bean.getEng_name1()%>&nbsp;&nbsp;<%=bean.getEng_name2()%>
	    </td>
	</tr>
	<tr>
		<td bgcolor=#E0E0E0>&nbsp;&nbsp;性別</td>
		<td bgcolor=#E0E0E0 align="left" colspan="5"><%=bean.getEng_sexname()%></td>
	</tr>
	<tr><td bgcolor=#E0E0E0>&nbsp;&nbsp;年齢</td>
		<td bgcolor=#E0E0E0 align="left" colspan="5"><%=bean.getEng_age()%>歳
		</td>
	</tr>
	<tr><td bgcolor=#E0E0E0>&nbsp;&nbsp;経歴</td>
		<td bgcolor=#E0E0E0 align="left" colspan="5"><%=bean.getEng_career()%>年
	</td>
	</tr>
	<tr><td bgcolor=#E0E0E0>&nbsp;&nbsp;国籍</td>
		<td bgcolor=#E0E0E0 align="left" colspan="5">
		<%=bean.getEng_Nationality()%>
	</td>
	</tr>
	<tr>  
		<td height="20" font="20">&nbsp;&nbsp;<b>技術者 詳細 情報</b>&nbsp;&nbsp;</td>
		<td align="left" colspan="5">				
	<%if(userInfo != null && "1".equals(bean.getViewflg())){		%>
	  	    <font color="red">&nbsp;&nbsp;未確定</font>
	<%} %>
		</td>
	<tr><td bgcolor=#E0E0E0>&nbsp;&nbsp;所属会社</td>
		<td bgcolor=#E0E0E0 align="left" colspan="5"><%=bean.getEng_id_position()%>
	</td>
	</tr>
	<tr><td bgcolor=#E0E0E0>&nbsp;&nbsp;区分</td>
	    <td bgcolor=#E0E0E0 align="left" colspan="5">
	    	<%=bean.getEng_TypeName() %>
	   </td>
    </tr>
    <tr><td bgcolor=#E0E0E0 size="20%" >&nbsp;&nbsp;機種/OS</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
		    <%=bean.getOsType()%>	    	 
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%" >&nbsp;&nbsp;データベース</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
		    <%=bean.getDbType() %>
	    	 
	    </td>
	</tr>
	 <tr><td bgcolor=#E0E0E0 size="20%" >&nbsp;&nbsp;対応可能言語</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
			<%=bean.getLanguage() %>	    	 
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%" >&nbsp;&nbsp;日本語能力</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	    	<%=bean.getJapGrade() %>
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;技術資格証</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <%=bean.getEng_skilllicense()%>	    
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;日本語資格証</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <%=bean.getEng_japlicense()%>
	    
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;アピールポイント</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	       <%=bean.getEng_ment()%> 
	    
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;投入可能時期</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	     <%=bean.getPossibledate() %>
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;希望値段</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	        <%=bean.getEng_salary()%>万円/月
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;営業状況</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	       <%=bean.getEng_state()%>
	    </td>
	</tr>
	<tr><td bgcolor=#E0E0E0 size="20%">&nbsp;&nbsp;スキルシート</td>
	    <td bgcolor=#E0E0E0 colspan="5" size="80%">
	       <a href="javascript:DownLoad(filename)"><%=bean.getEng_filename()%></a>
	    </td>
	</tr>
		<input type="hidden" name="eng_id" value="<%=bean.getEng_id() %>">
		<input type="hidden" name="filename" value="<%=bean.getEng_filename() %>">
	<tr>
		<td colspan="6" align="right" height="40">
 		
 		<a href = "EngMgnUpdateOpen?eng_id=<%=bean.getEng_id()%>"><img src="jsp/images/common/btn_gp_config.gif"></a>&nbsp;&nbsp;
		<a href = "javascript:deleteSubmit(eng_id)"><img src="jsp/images/common/btn_gp_del.gif"></a>&nbsp;&nbsp;
		
		<a href = "EngMgnList"><img src="jsp/images/common/btn_gp_list.gif" alt=""></a>&nbsp;&nbsp;&nbsp;&nbsp;
	    </td>
	</tr>
	
	
</table>
</body>
</html>
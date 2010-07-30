<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page session="true"%>
<%@ page import="common.bean.MemberBean"%>
<%@ page import="java.util.*"%>
<%@ page import="engmgn.bean.EngMgnBean"%>
<%@ taglib prefix="myTags" uri="pageHandle"%>
<%@ page import="common.bean.PageBean"%>

<% request.setCharacterEncoding("utf-8"); 

	PageBean pageBean = (PageBean) session.getAttribute("PageBean");
	MemberBean userInfo = (MemberBean) session.getAttribute("memberInfo");
    String session_id ="";
    String user_id = "";
    //String s_position = "";
    //String s_initial = "";
    //String s_language = "";
    
    if(userInfo != null){
    	session_id = userInfo.getUserid();    
    }
	
	ArrayList list = (ArrayList)request.getAttribute("list");
	int total = list.size();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../../css/ITFreesMallStyle.css" tyep="text/css"
	rel="stylesheet" />
<SCRIPT LANGUAGE = "JavaScript">
	function registOpen(ff) {
			ff.action="EngMgnRegistOpen";
			ff.submit(); 
			return true;
	}
	
	function DownLoads(ff) {
		var result=0;
		var boxlength = ff.downcheck.length;
		for(var i=0;i<boxlength;i++){
			if(ff.downcheck[i].checked==true){
				result++;
			}
		}
		if(result>0){
			ff.action="DownLoad";
			ff.submit(); 
			return true;
		}else{
			alert("選択したファイルがありません。");
			return false;
		}
	}	
		
	function DownLoad(num) {
		var file=list.filename[num].value;
		location.href = "DownLoad?filename="+file;
		return true;
	}
	
	function engmgnPageSize(ff) {
		ff.action="EngMgnList";
		ff.submit(); 
		return true;
	}
	
	function search(ff) {
		ff.action="EngMgnList";
		ff.submit(); 
		return true;
	}
	
	function fileChk(length,i){
		if(length==""){
			alert("ファイルがありません。");
			list.downcheck[i].checked=false;
		}
	}
	function deleteSubmit(eng_id){
		if(confirm("削除しますか？")){
		    location.href ="EngMgnDelete?eng_id="+eng_id;
		}
	}
</SCRIPT>
<link href="jsp/include/css/kankokujin.css" rel="stylesheet" type="text/css">
<title>EngineerList</title>
</head>
<body>
<br>
<form method="post" name="list">
<table border='0' width="1300" align="center">
    <tr>
	    <td>
	    	<b><font size=4>技術者一覧</font></b>			 
		</td>
	</tr>
</table>
<table border='0' width="1300" align="center"> 
    <tr align='right'>
	    <td bgcolor=#E0E0E0 colspan="18" >所属社<input type="text" name="s_position" siz="2">
	       							  イニシャル<input type="text" name="s_initial" siz="2">
	         						  対応可能言語<select name="s_language">
					                                 <option value="">選択
					                                 <option value="1">JAVA
													 <option value="2">C
													 <option value="3">C#
													 <option value="4">VB
													 <option value="5">.NET
												  </select><input type="button" value="検索" onClick="search(list)">
							 
		</td>
	</tr>
</table>
<table border='0' width="1300" align="center"> 
		<tr>
			<td style="padding:0 0px 5 0;" align="right">열람개수 
			<select name='pageSize' onChange='return engmgnPageSize(list)'>
				<option <%if(pageBean.getPageSize() == 10){%> selected <%}%> value="10">10</option>
				<option <%if(pageBean.getPageSize() == 20){%> selected <%}%> value="20">20</option>
				<option <%if(pageBean.getPageSize() == 50){%> selected <%}%> value="50">50</option>
				<option <%if(pageBean.getPageSize() == 100){%> selected <%}%> value="100">100</option>
			</select></td>
		</tr>
	</table>
<%
if (total == 0) {
%> 
<table border='0' width="1100" align="center">
    <tr align='center'>
	    <td>
	    登録された技術者がありません。			 
		</td>
	</tr>
</table>
<%
} else {
%><table border='0' width="1300" align="center">
	<tr align='center'>
	    <td width="20" bgcolor=#E0E0E0>選択</td>
		<td width="20" bgcolor=#E0E0E0>項番</td>
		<td width="80" bgcolor=#E0E0E0>所属</td>
		<td width="50" bgcolor=#E0E0E0>区分</td>
		<td width="50" bgcolor=#E0E0E0>イニ<br>シャル</td>
		<td width="20" bgcolor=#E0E0E0>性別</td>
		<td width="20" bgcolor=#E0E0E0>年齢</td>	
		<td width="30" bgcolor=#E0E0E0>経歴</td>
		<td bgcolor=#E0E0E0>機種/OS</td>
		<td bgcolor=#E0E0E0>DB</td>
		<td bgcolor=#E0E0E0>対応可能言語</td>
		<td width="200" bgcolor=#E0E0E0>経験工程</td>
		<td width="70" bgcolor=#E0E0E0>投入可能<br>時期</td>
		<td width="40" bgcolor=#E0E0E0>日本語<br>能力</td>
		<td bgcolor=#E0E0E0>備考</td>
		<td width="30" bgcolor=#E0E0E0>希望<br>値段</td>
		<td width="30" bgcolor=#E0E0E0>営業<br>状況</td>
		<td width="100" bgcolor=#E0E0E0>スキルシート</td>
		<td width="70" bgcolor=#E0E0E0>更新日</td>
		<td width="30" bgcolor=#E0E0E0>修正<br>削除</td>	
    </tr>
<%
		Iterator it = list.iterator();
		int i=0;
  		while (it.hasNext()) {
		 EngMgnBean bean = (EngMgnBean) it.next();
	%>
	<tr align="center">
	    <td><input type="checkbox" name="downcheck" value="<%=bean.getEng_filename()%>" onclick="fileChk(this.value,<%=i %>)"></td>
	    <td><%=bean.getEng_id()%></td>
		<td><%=bean.getEng_id_position()%></td>
		<td><%=bean.getEng_TypeName() %></td>
		<td><a href="EngMgnDetail?eng_id=<%=bean.getEng_id()%>"><%=bean.getEng_initial()%></a><br>			
	<%if(userInfo != null && "1".equals(bean.getViewflg())){		%>
	  	    <font color="red">&nbsp;&nbsp;(未確定)</font>
	<%} %></td>
		<td><%=bean.getEng_sexname()%></td>
		<td><%=bean.getEng_age()%></td>
		<td><%=bean.getEng_career()%>年</td>
		<td><%=bean.getOsType() %></td>		
		<td><%=bean.getDbType()%></td>		
		<td><%=bean.getLanguage()%></td>		
		<td><%=bean.getProCessName() %></td>		
		<td><%=bean.getPossibledate() %></td>
		<td><%=bean.getJapGrade() %></td>
		<td><%=bean.getEng_ment() %></td>
		<td><%=bean.getEng_salary()%></td>
		<td><%=bean.getEng_state()%></td>
		<input type="hidden" name="filename" value="<%=bean.getEng_filename() %>">
		<td><a href="javascript:DownLoad(<%=i %>)"><%=bean.getEng_filename()%></a></td>
		<td><%=bean.getEng_updatedate()%></td>		
		<td>
<% 	         user_id = bean.getEng_id_position();
             //System.out.println("user_id=="+user_id);
     //        if(user_id.equals(session_id)||user_id==session_id){ %>
				   <a href = "EngMgnUpdateOpen?eng_id=<%=bean.getEng_id()%>">修正</a><br>
				    <a href = "javascript:deleteSubmit(<%=bean.getEng_id()%>)">削除</a>
<%   //        }else{権限<br>なし%>
     <%
    //         }
             i++;
       }%>
       </td>
 </tr>
</table>

	<%
 }
 %>
<table border='0' width="1300" align="center">
	<tr>
		<td colspan="18">
			<input type="button" value="技術者登録" onClick="registOpen(list)">
			<input type="button" value="ダウンロード" onClick="DownLoads(list)">
		</td>
	</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" height="20" align="center">
		<tr style="padding-top:10">
			<td>
			<%
			if (pageBean.getMaxCount() != 0) {
			%> 검사결과 : <span class="orange"><%=pageBean.getMaxCount()%></span>건중
			<span class="orange"><%=pageBean.getStartCount()%></span>~ <span
				class="orange"><%=pageBean.getEndCount()%></span>건을표시하고 있습니다.</td>
			<%
			}
			%>
		</tr>
				<!-- Page No--> 
					<tr>
						<td align="center" colspan="5">
						<myTags:pageHandle /> 
						</td>
					</tr>
					
				<!-- Page No-->
</table>
<jsp:include page="/jsp/base/itfreesmallMark.jsp" flush="true"/>
</form>


</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="board.*, ebs_board.EbsBean,java.util.*, java.util.List" %>
<jsp:include page="../top.jsp" flush="true"/>
<jsp:useBean id="con" scope="page" class="ebs_board.ConnectionBean" />
<jsp:useBean id="ebs_board" scope="page" class="ebs_board.EbsBean" />
<jsp:useBean id="main" scope="page" class="board.MainClass" />
<jsp:useBean id="jp" scope="page" class="ebs_board.JapaneseConn" />
<script>
function key_check(input, obj){
	if (input == "32" || input == "28") {
		obj.value= "";
		alert("변환은 하지 말아주세요 ! (+_+)");
		obj.value= "";
	}
}
function sendit(){
	document.search.submit();
}
</script>

<% 
    String userId = "";
    ebs_board.setConnection(con.getConnection()); 
    main.setConnection(con.getConnection()); 
   // User user = (User)session.getAttribute("user");	    
  	
   	System.out.println("User is not null");
    //  userId = user.getUserId();
   //	System.out.println("userId =" + userId);
%>
<html>
<head>
<title>JAPANESE QUIZ</title>
<style type='text/css'>
  A:link    { color:#183CA5; text-decoration:none;     }
  A:visited { color:#183CA5; text-decoration:none;     }
  A:active  { text-decoration:none;     }
  A:hover    { color:#387FE7; text-decoration:none;}
  .editbox  { border:1 solid black; background-color:white; }
  .input    { height:19px; border:1 solid; border-color:gray; background-color:white; }
  .button   { height:19px; border:1 solid; border-color:gray; background-color:#B5CEFF; border-width:1; color:#183CA5; }
  p,br,table,body,td,select,input,form,textarea,option {font-size:10pt; }
</style>

<script language="javascript">
function check() {
	location.href="/board/write.jsp"
}
function admin() {
	location.href="/board/admin.jsp"
}
</script>

</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<%
	String wordTableName = "word1";
	String selectTable = "word1";
	String temp = request.getParameter("wordtable");
	if (temp == null || "".equals(temp)) {
		temp = (String)session.getAttribute("wordtable");	
	}
	System.out.println("quiz temp=" + temp);
%>
<form method=post name=wordtable action="/quiz/japanese_quiz.jsp">
<select name="wordtable" onChange="document.wordtable.submit()">
<% 
List wordTableList = main.getTableList();

System.out.println("wordSize=" + wordTableList.size());
		Iterator it = wordTableList.iterator();
		while (it.hasNext()) { 
			String tempTableName = (String)it.next();
			%><option 
<%
	String isSelected ="";
	if (temp == null) {
		
		if (selectTable.equals(tempTableName)) {
			isSelected="selected";
			wordTableName = tempTableName;
		}
	} else {
		if (temp.equals(tempTableName)) {
			isSelected="selected";
			wordTableName = tempTableName;
		}
	}
	
	System.out.println("selectTable= " + selectTable + " , tempTableName=" + tempTableName+ " , temp=" + temp + " , isSelected=" + isSelected);
%>
<%=

	isSelected
%> 
				value="<%=tempTableName%>"><%=main.changeTableName(tempTableName)%></option><%  
		}	
%>

</select>

</form>
<%	
	int numa = 0;
	int numb = 0;
	int max_view=5;
	int max_line=20;
	int limit;
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int f = 0;
	int g = 0;
	int h = 0;
%>
<form method=post name=search action="/quiz/japanese_quiz_ok.jsp" onsubmit="return check2();">

<%	
	if(request.getParameter("num")==null) {
		numa=0;
		numb=0;
	} else {
		numa=Integer.parseInt(request.getParameter("num"));
		numb=Integer.parseInt(request.getParameter("numb"));
	}
    	String isFirst = request.getParameter("isFirst");
	System.out.println("isFirst ="+isFirst);

    	if (!("no").equals(isFirst)) {
      		//ebs_board.setNoFlg0();   
	}
	List wordList = null;
    	//if (!(userId == null || "".equals(userId))) {
    	wordList = main.getQuizList(wordTableName, userId);

    	session.setAttribute("wordList", wordList);
	System.out.println("wordList.size() ="+wordList.size());
	limit=Math.min(max_line,wordList.size()-numa*max_line);
    //}
	a=wordList.size();	
	if(a >= max_line) {
		b = a/max_line;
		d = a%max_line;

		if(d!=0) {
			d=1; f=b+d;
		} else {
			d=0; f=b;}
			g = (f/max_view);
			h = (f%max_view);
			if(h!=0) {
				h=1;
			} else {
				h=0;
			}

			h = g+h;
		}
	
	%>
  <%//table 1 start%>
<input type=hidden name=wordtable value='<%=wordTableName%>'>
 <table border="0" cellpadding="1" cellspacing="0" width=900>
  <tr valign="top">
	<td>  <%//table 2 start%>
		<table border="0" width=250>
		<%=main.getTestResult(wordTableName, userId)%></strong></font>
		<tr><td></td><td></td>
		</tr>
		<tr>
			<td><li>1000단어가 너무 많아서 나누어서도 풀수 있도록 했습니다. 일본어 한자읽기1-8까지 각각 140문제 정도 씩 되니 하루에 한부 정도씩 푸시기 바랍니다.
			</td>
		</tr>
		<tr>
			<td><li>틀린 단어는 다시 문제를 풀도록 앞쪽에 나오고 전에 정답을 맞추었다고 하더라도 시간이 지나서
				잊어버릴만 하면 다시 출제 되도록 되어 있습니다. 
			</td>
		</tr>
		<tr>
			<td><li>히라가나 입력란에 한자의 히라가나를 입력하고 밑에 채점(SCORE)버튼을 눌러주세요.
			</td>
		</tr>
		<tr>
			<td><li>문제는 한 번에 20개까지 한번에 풀 수 있습니다.
			</td>
		</tr>
		<tr>
			<td><li>모르는 단어를 먼저 외우고 나서 테스트를 하고 싶을 경우에는 밑에 DOWNLOAD버튼을 눌러 
				엑셀파일로 다운로드 받을 수 있습니다. 프린터 해서 외울 수도 있습니다. 
				(다운로드가 안 되고 브라우저로 열릴 경우에는 DOWNLOAD버튼을 오른쪽 클릭한 후 다른 이름으로 대상저장을 해주세요)
			</td>
		</tr>
		</table>
		<%//table 2 end%>
	</td>
	<td>
	<%//table 3 quiz list start%>
	<table border=0 cellpadding=1 cellspacing=0 width="100%" style="border:1px solid rgb(192,192,192)">
		<tr>
			<td height=50 align=left style="padding-left:20; padding-right:30" colspan=2>
				<font face="Comic Sans MS" size=3 color=#004080><strong>Welcome To Japanese Quiz</strong></font>
			</td>
		</tr>
	 <tr>
	 </tr>

	  <tr>
		<td>
		    <div align="center">
   			<%//table 4 start%>
			<table border=0 cellpadding="0" cellspacing="0" bordercolordark="#BDD7FF" bordercolorlight="white">
				<tr align=center bgcolor='#B5CEFF'>
		    			<td width="40"><font color=#183CA5>NO</font></td>
					<td width="100" align=left><font color=#183CA5>한자</font></td>
		    			<td width="100"><font color=#183CA5>히라가나 입력</font></td>
					<td width="100"><font color=#183CA5>한글뜻</font></td>
				</tr>     
				<input type=hidden name=updateSize value='<%=numa*max_line+limit - numa*max_line%>'>
				<input type=hidden name=startIndex value='<%=numa*max_line%>'>

<% 
for(int idx= numa*max_line; idx < (numa * max_line)+limit; idx++) { 
        WordBean wordBean = (WordBean)wordList.get(idx);

        %> 	
<input type=hidden name=word_idx<%=idx%> class=input value='<%=wordBean.getWord_idx()%>'>
<input type=hidden name=japanese_kanji<%=idx%> class=input value='<%=wordBean.getJapanese_kanji()%>'>
<input type=hidden name=japanese_yomi1<%=idx%> class=input value='<%=wordBean.getJapanese_yomi1()%>'>
<input type=hidden name=korean<%=idx%> class=input value='<%=wordBean.getKorean()%>'>
		<tr align=center bgcolor='white' onMouseOver=this.style.backgroundColor='#E7EFFF' onMouseOut=this.style.backgroundColor=''>
			<td width="40"><%=idx + 1%><font color=black>
			</font></td>

			<td width="100" align=left><font color='black'>
				<%=jp.toJapanese(wordBean.getJapanese_kanji())%>
				</font></td>
			<td width="100"><font color=black>

    			<input type=text size=20 name=input_japanese_yomi1<%=idx%> class=input value='' onKeyUp='key_check(event.keyCode, this);' style="ime-mode:active" autocomplete="off">				
				</font></td>
		    <td width="100"><font color=black>
			    <%=jp.toJapanese(wordBean.getKorean())%>
				</font></td>
		</tr>
		
		<tr>
			<!--<td colspan=5><img src="jsp/images/common/title_line.gif"></td> -->
		</tr>


	</table>
   	<%//table 4 end%>
	</div>
	</td>
 </tr>

 <tr>
	<td>&nbsp;</td>
 </tr>

 <tr>
	<td>
<%//table 5 pages start%>
<table border="0" style='border:0' cellspacing='0' cellpadding='0' width='60%' align='center'>
	<tr>
		<td width='40' style='border:0'>
		<% if(numb != 0) {
		
		 %>

		</td>
		<% } else {} %>

		<td style='border:0'>
		<p align='center'>
		<% 
			
			for(int z=numb*max_view; z<max_view*(numb+1); z++) {
			
			if(z >= f){
			} else {
				if(z==numa) {
		%>
			<%=z+1%>&nbsp;
				<% } else { %>
					[<a href="jsp/quiz/japanese_quiz.jsp?num=<%=c%>&numb=<%=numb%>"><%=z+1%></a>]&nbsp;
				<% } 
			} 
		} %>
		</p>
		</td>

		<td width='40' style='border:0'><p align='center'>
		<% if(a <= max_line) {}
			else {
				if(h != numb+1) {
					if(a > max_view*(numb)) {
		%>
		</td>
		<% } else { %>&nbsp;
		<% } } else {
		} } %></p>
	</tr>
</table>
<%//table 5 end%>
  </td>
 </tr>

 <tr>
	<td align=center>
<a class='MIME' class='MIME' href="javascript:sendit();"><img src="/Kankokujin/jsp/images/common/score.gif" width='100' border='0'></a>
<a href="/japanese.xls" font="#0000ff"><img src="/Kankokujin/jsp/images/common/downloadwords.gif" width='100' border='0'></a><br>
	</td>
 </tr>

</form>
</table>
<%//table 3 end%>

<%//table 1 end%>
</table>


</body>
</html>
		<%
	}
%>

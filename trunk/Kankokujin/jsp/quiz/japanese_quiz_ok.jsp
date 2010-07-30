<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="ebs_board.*, board.*,java.util.*" %>
<jsp:include page="../top.jsp" flush="true"/>
<jsp:useBean id="con" scope="page" class="ebs_board.ConnectionBean" />
<jsp:useBean id="ebs_board" scope="page" class="ebs_board.EbsBean" />
<jsp:useBean id="main" scope="page" class="board.MainClass" />
<jsp:useBean id="jp" scope="page" class="board.JapaneseConn" />

<% ebs_board.setConnection(con.getConnection()); %>
<% main.setConnection(con.getConnection()); %>
<html>
<style type='text/css'>
  A:link    { color:#183CA5; text-decoration:none;     }
  A:visited { color:#183CA5; text-decoration:none;     }
  A:active  { text-decoration:none;     }
  A:hover    { color:#387FE7; text-decoration:none;}
  .editbox  { border:1 solid black; background-color:white; }
  .input    { height:19px; border:1 solid; border-color:gray; background-color:white; }
  .button   { height:19px; border:1 solid; border-color:gray; background-color:#B5CEFF; border-width:1; color:#183CA5; }
  p,br,table,body,td,select,input,form,textarea,option {font-size:9pt; }
</style>
<%
//boolean  ttt = false;
    User user = (User)session.getAttribute("user");	  
	String wordtable = request.getParameter("wordtable");
	System.out.println("ok wordtable = " + wordtable);
	session.setAttribute("wordtable", wordtable);	
    String user_id = "";  
    if (user != null) {
        user_id = user.getUserId();
    } else  {	
    %><script language="javascript">
	     location.href="/quiz/user_login.jsp";
      </script>
    <%
    }
    System.out.println("session = " + session);
    List wordList = (List)session.getAttribute("wordList");

boolean  ttt = true;
String tempSize = request.getParameter("updateSize");
int startIndex = 0;
try {
startIndex = Integer.parseInt(request.getParameter("startIndex"));
} catch (Exception e) {

}

int size = 0;
if (!"".equals(tempSize) && tempSize != null) {
	size = Integer.parseInt (tempSize);
}

String [] word_idx = new String[size];
String [] japanese_kanji_kanji = new String[size];
String [] input_japanese_yomi1 = new String[size];
String [] japanese_yomi1 = new String[size];
String [] korean = new String[size];
String [] isCorrect = new String[size];

//update
for (int i = startIndex; i < startIndex + size ; i ++) {
    WordBean wordBean = (WordBean)wordList.get(i);
	word_idx[i - startIndex] = request.getParameter("word_idx" + i);
	//japanese_kanji_kanji[i - startIndex] = request.getParameter("japanese_kanji" + i);
	japanese_kanji_kanji[i - startIndex] = wordBean.getJapanese_kanji();
	//System.out.println(jp.toJapanese(request.getParameter("japanese_kanji" + i)));
    input_japanese_yomi1[i - startIndex] = request.getParameter("input_japanese_yomi1" + i);
    //System.out.println("input_japanese_yomi1[i] = " + input_japanese_yomi1[i]);
	//japanese_yomi1[i - startIndex] = request.getParameter("japanese_yomi1" + i);
	japanese_yomi1[i - startIndex] = wordBean.getJapanese_yomi1();
	//korean[i - startIndex] = request.getParameter("korean" + i);
	korean[i - startIndex] = wordBean.getKorean();

    //System.out.println("word_idx[i - startIndex] = " + word_idx[i - startIndex]);
	if (("").equals(input_japanese_yomi1[i - startIndex])) {
    	isCorrect[i - startIndex] = "";
		//do nothing
	} else if ((input_japanese_yomi1[i - startIndex]).equals(japanese_yomi1[i - startIndex])) {
		System.out.println("updateOk input_japanese_yomi1[i - startIndex] = " + input_japanese_yomi1[i - startIndex] +"japanese_yomi1[i - startIndex] = " + japanese_yomi1[i - startIndex]);
		// OK
		ttt = main.insertTestInfo("O", word_idx[i - startIndex], user_id, wordtable);
		isCorrect[i - startIndex] = "O";
		
	} else {
		System.out.println("updateNo input_japanese_yomi1[i - startIndex] = " + input_japanese_yomi1[i - startIndex] +"japanese_yomi1 = " + japanese_yomi1);
		// NO
		ttt = main.insertTestInfo("X", word_idx[i - startIndex], user_id, wordtable);
		isCorrect[i - startIndex] = "X";
	}
}

%>
<body>
<table border=0>
    <tr><td></td>
<td>
 <table align=center border="0" cellpadding="0" cellspacing="0" width=800>
  <tr>
	<td>
	<table border=0 cellpadding=0 cellspacing=0 width="100%" style="border:1px solid rgb(192,192,192)">
		<tr>
			<td height=50 align=left style="padding-left:20; padding-right:30" colspan=2>
				<font face="Comic Sans MS" size=3 color=#004080><strong>Japanese Quiz Report</strong></font>
			</td>
		</tr>
	 <tr>
	 </tr>

  <tr>
	<td>
    <div align="center">
   	
	<table border=0 cellpadding="0" cellspacing="0" width="100%" bordercolordark="#BDD7FF" bordercolorlight="white">
		<tr align=center bgcolor='#B5CEFF'>
		    <td height=40 width="20"><font color=#183CA5>NO</font></td>
			<td width="60" align=left><font color=#183CA5>한자</font></td>
			<td width="60"><font color=#183CA5>채점 결과</font></td>
		    <td width="80"><font color=#183CA5>입력 히라가나</font></td>
		    <td width="80"><font color=#183CA5>정답 히라가나</font></td>
			<td width="80"><font color=#183CA5>한글 뜻</font></td>
		</tr>     
<% for(int idx = 0; idx < size; idx++) { %> 	

		<tr height=25 align=center bgcolor='white' onMouseOver=this.style.backgroundColor='#E7EFFF' onMouseOut=this.style.backgroundColor=''>
			<td width="20"><%=idx + 1 + startIndex%><font color=black>
			</font></td>

			<td width="60" align=left><font color='black'>
				<%=jp.toJapanese(japanese_kanji_kanji[idx])%>
				</font></td>
			<td width="60"><font color=black>
            <%=isCorrect[idx]%>
				</font></td>
			<td width="80"><font color=black>
                <%=jp.toJapanese(input_japanese_yomi1[idx])%>
				</font></td>
				
			<td width="80"><font color=black>
	        <div align="center">
                <%=jp.toJapanese(japanese_yomi1[idx])%>
        </div>
				</font></td>
		    <td width="80"><font color=black>
			    <%=jp.toJapanese(korean[idx])%>
				</font></td>
		</tr>
		
		<tr>
			<td colspan=5><img src="/quiz/image/line.gif" width=750></td>
		</tr>

<% } %>

	</table>
	</td>
 </tr>


</table>
</table>
</td>
 	
 </table>

<center><a href="/quiz/japanese_quiz.jsp"><img src="/image/nextquiz.gif" width='100' border='0'></a></center>
</body>

</html>
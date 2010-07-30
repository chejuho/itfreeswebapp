package board;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class MainClass {
	private Connection con = null;
	//private Logger logger = null;
	public MainClass () {
			//logger = Logger.getLogger(MainClass.class);
	}
	public void setConnection(Connection c) {
		this.con = c;
	}

	public List getBoardList() {
		Statement stmt = null;
		ResultSet rs = null;
		List boardList = new ArrayList();
		try {
			String sql1 = "select count(*) from ebs_board";
			String sql2 = "select * from ebs_board order by ref desc,re_step asc";
			System.out.println("sql1=" + sql1);
			System.out.println("sql2=" + sql2);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql1);
			rs.next();
			int cnt = rs.getInt(1);

			rs = stmt.executeQuery(sql2);

			for (int i = 0; rs.next(); i++) {
				BoardContentBean boardContentBean = new BoardContentBean();
				boardContentBean.setBoard_idx(rs.getInt(1));
				boardContentBean.setName(rs.getString(2));
				boardContentBean.setEmail(rs.getString(3));
				boardContentBean.setHomepage(rs.getString(4));
				boardContentBean.setTitle(rs.getString(5));
				boardContentBean.setPwd(rs.getString(6));
				boardContentBean.setNum(rs.getInt(7));
				boardContentBean.setWriteday(rs.getString(8));
				boardContentBean.setReadnum(rs.getInt(9));
				boardContentBean.setTag(rs.getString(10));
				boardContentBean.setRef(rs.getInt(11));
				boardContentBean.setRe_step(rs.getInt(12));
				boardContentBean.setRe_level(rs.getInt(13));
				boardContentBean.setContent(rs.getString(14));
				boardList.add(boardContentBean);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return boardList;
	}

	public List getBoardList(int ref) {
		Statement stmt = null;
		ResultSet rs = null;
		List boardList = new ArrayList();
		try {
			String sql1 = "select count(*) from ebs_board where ref=" + ref
					+ " order by ref desc,re_step asc";
			String sql2 = "select * from ebs_board where ref=" + ref
					+ " order by ref desc,re_step asc";
			System.out.println("sql1=" + sql1);
			System.out.println("sql2=" + sql2);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql1);
			rs.next();
			int cnt = rs.getInt(1);
			System.out.println("cnt=" + cnt);
			rs = stmt.executeQuery(sql2);

			for (int i = 0; rs.next(); i++) {
				BoardContentBean boardContentBean = new BoardContentBean();
				boardContentBean.setBoard_idx(rs.getInt(1));
				boardContentBean.setName(rs.getString(2));
				boardContentBean.setEmail(rs.getString(3));
				boardContentBean.setHomepage(rs.getString(4));
				boardContentBean.setTitle(rs.getString(5));
				boardContentBean.setPwd(rs.getString(6));
				boardContentBean.setNum(rs.getInt(7));
				boardContentBean.setWriteday(rs.getString(8));
				boardContentBean.setReadnum(rs.getInt(9));
				boardContentBean.setTag(rs.getString(10));
				boardContentBean.setRef(rs.getInt(11));
				boardContentBean.setRe_step(rs.getInt(12));
				boardContentBean.setRe_level(rs.getInt(13));
				boardContentBean.setContent(rs.getString(14));
				boardList.add(boardContentBean);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("boardList.size()=" + boardList.size());
		return boardList;
	}

	public BoardContentBean showList(int idx) {
		Statement stmt = null;
		ResultSet rs = null;
		BoardContentBean boardContentBean = null;
		try {
			stmt = con.createStatement();

			String sql = "select * from ebs_board where board_idx='" + idx
					+ "'";
			rs = stmt.executeQuery(sql);

			rs.next();
			boardContentBean = new BoardContentBean();
			boardContentBean.setBoard_idx(rs.getInt(1));
			boardContentBean.setName(rs.getString(2));
			boardContentBean.setEmail(rs.getString(3));
			boardContentBean.setHomepage(rs.getString(4));
			boardContentBean.setTitle(rs.getString(5));
			boardContentBean.setPwd(rs.getString(6));
			boardContentBean.setNum(rs.getInt(7));
			boardContentBean.setWriteday(rs.getString(8));
			boardContentBean.setReadnum(rs.getInt(9));
			boardContentBean.setTag(rs.getString(10));
			boardContentBean.setRef(rs.getInt(11));
			boardContentBean.setRe_step(rs.getInt(12));
			boardContentBean.setRe_level(rs.getInt(13));
			boardContentBean.setContent(rs.getString(14));

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return boardContentBean;
	}

	public void addReadNo(int idx) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update ebs_board set readnum = readnum + 1 where board_idx='"
					+ idx + "'";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List getQuizList(String wordTable, String userId) {
		Statement stmt = null;
		ResultSet rs = null;
		List quizList = new ArrayList();
		//背雁 汽戚斗�? 蒸生�? 歯稽 �??�?
		if (!existTestTable(con, wordTable, userId)) {
			if (insertTestTable(con, wordTable, userId)) {
				System.out.println("insert success");
			} else {
				System.out.println("insert fail");
			}
		}
		//堂鍵 舘嬢 軒�?�? 昼究
		quizList = getNoList(con, wordTable, userId, quizList);
        //限紹走幻 獣�???? 井引吉  舘嬢 軒�?�? 昼究
		quizList = getOkList(con, wordTable, userId, quizList);
		System.out.println("quizList.size()=" + quizList.size());
		makeCsvFile("", quizList);
		return quizList;
	}

	
	public List getNoList(Connection con, String wordTable, String userId, List quizList) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			String getNoListSql = " SELECT word.word_idx, word.chinese_kanji, "
					+ " word.chinese_yomi1, word.chinese_yomi2, word.chinese_sentence, word.japanese_kanji, "
					+ " word.japanese_yomi1, word.japanese_yomi2, word.japanese_sentence, word.korean, word.english, "
					+ " word.english_sentence, word.level FROM test, word "
					//+ wordTable
					+ " WHERE test.user_id= '"
					+ userId
					+ "' AND "
					+ " test.table_id= '"
					+ wordTable
					+ "' AND "
					+ " test.word_id = word.word_idx AND test.test_flg = 0 "
					+ " ORDER BY test.no_count DESC, "
					+ " test.test_date ASC, test.test_count ASC , test.test_idx ASC ";
			System.out.println("getNoListSql=" + getNoListSql);
			rs = stmt.executeQuery(getNoListSql);
			//rs.next();

			for (int i = 0; rs.next(); i++) {
				WordBean wordBean = new WordBean();
				wordBean.setWord_idx(rs.getInt(1));
				wordBean.setChinese_kanji(rs.getString(2));
				wordBean.setChinese_yomi1(rs.getString(3));
				wordBean.setChinese_yomi2(rs.getString(4));
				wordBean.setChinese_sentence(rs.getString(5));
				wordBean.setJapanese_kanji(rs.getString(6));
				wordBean.setJapanese_yomi1(rs.getString(7));
				wordBean.setJapanese_yomi2(rs.getString(8));
				wordBean.setJapanese_sentence(rs.getString(9));
				wordBean.setKorean(rs.getString(10));
				wordBean.setEnglish(rs.getString(11));
				wordBean.setEnglish_sentence(rs.getString(12));
				wordBean.setLevel(rs.getInt(13));
				quizList.add(wordBean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("quizList.size()=" + quizList.size());
		return quizList;
	}
	public List getOkList(Connection con, String wordTable, String userId, List quizList) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			//where箭�? 3�? 壕呪拭 背雁馬�? 稽送聖 坦軒拝 �?
			String getOkListSql = " SELECT word.word_idx, word.chinese_kanji, "
					+ " word.chinese_yomi1, word.chinese_yomi2, word.chinese_sentence, word.japanese_kanji, "
					+ " word.japanese_yomi1, word.japanese_yomi2, word.japanese_sentence, word.korean, word.english, "
					+ " word.english_sentence, word.level FROM test, word "
					//+ wordTable
					+ " WHERE test.user_id= '"
					+ userId
					+ "' AND "
					+ " test.table_id= '"
					+ wordTable
					+ "' AND "
					+ " DATE_SUB(test.test_date, INTERVAL 0 DAY) <= DATE_SUB(now(), INTERVAL POW(3, ok_count - no_count-1) DAY) AND "
					+ " test.word_id = word.word_idx AND test.test_flg = 1 ORDER BY test.no_count DESC, "
					+ " test.test_date ASC, test.test_count ASC , test.test_idx ASC ";
			System.out.println("getOkListSql=" + getOkListSql);
			rs = stmt.executeQuery(getOkListSql);
			//rs.next();

			for (int i = 0; rs.next(); i++) {
				WordBean wordBean = new WordBean();
				wordBean.setWord_idx(rs.getInt(1));
				wordBean.setChinese_kanji(rs.getString(2));
				wordBean.setChinese_yomi1(rs.getString(3));
				wordBean.setChinese_yomi2(rs.getString(4));
				wordBean.setChinese_sentence(rs.getString(5));
				wordBean.setJapanese_kanji(rs.getString(6));
				wordBean.setJapanese_yomi1(rs.getString(7));
				wordBean.setJapanese_yomi2(rs.getString(8));
				wordBean.setJapanese_sentence(rs.getString(9));
				wordBean.setKorean(rs.getString(10));
				wordBean.setEnglish(rs.getString(11));
				wordBean.setEnglish_sentence(rs.getString(12));
				wordBean.setLevel(rs.getInt(13));
				quizList.add(wordBean);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("quizList.size()=" + quizList.size());
		return quizList;
	}
	//	*******************************************************
	//	makeCsvFile
	//	*******************************************************
	public boolean makeCsvFile(String fileName, List wordList) {
		boolean returnBoolean = false;
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			File excel = new File("D://homepage//inputjapanese.xls");
			File outputexcel = new File("D://homepage//japanese.xls");
			inputStream = new FileInputStream(excel);
			HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
			//workBook.removeSheetAt(0);
			//workBook.createSheet();
			//HSSFSheet newSheet = workBook.createSheet();
			HSSFSheet newSheet = workBook.getSheetAt(0);
			//workBook.setSheetName(0, "JAPANESE",
			// HSSFWorkbook.ENCODING_UTF_16);
			int rowNo = 0;
			int temp = 0;
			int cellNo = 0;
			HSSFRow newRow = null;
			String tempStr = "";
			for (int i = 0; i < wordList.size(); i++) {
				WordBean wordBean = (WordBean) wordList.get(i);
				temp = i / 4;
				if (i - (4 * temp) == 0) {
					newRow = newSheet.createRow(rowNo);
					rowNo++;
					cellNo = 0;
				}

				HSSFCell newCell1 = newRow.createCell((short) cellNo++);
				tempStr = new String(wordBean.getJapanese_kanji().getBytes(
						"8859_1"), "UTF-8");
				//tempStr = "1";
				//System.out.println("kanji=" + tempStr);
				newCell1.setEncoding(HSSFCell.ENCODING_UTF_16);
				newCell1.setCellValue(tempStr);
				HSSFCell newCell2 = newRow.createCell((short) cellNo++);
				tempStr = new String(wordBean.getJapanese_yomi1().getBytes(
						"8859_1"), "UTF-8");
				//tempStr = "2";
				//System.out.println("yomi=" + tempStr);
				newCell2.setEncoding(HSSFCell.ENCODING_UTF_16);
				newCell2.setCellValue(tempStr);
				HSSFCell newCell3 = newRow.createCell((short) cellNo++);
				tempStr = new String(wordBean.getKorean().getBytes("8859_1"),
						"UTF-8");
				//tempStr = "3";
				//System.out.println("korean=" + tempStr);
				newCell3.setEncoding(HSSFCell.ENCODING_UTF_16);
				newCell3.setCellValue(tempStr);
			}

			outputStream = new FileOutputStream(outputexcel);
			workBook.write(outputStream);
			returnBoolean = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return returnBoolean;
	}

	//	*******************************************************
	//	update OK
	//	*******************************************************
	public boolean insertTestInfo(String okNo, String word_id, String user_id,
			String table_id) {
		Statement stmt = null;
		ResultSet rs = null;
		try {

			stmt = con.createStatement();
			String sql1 = "SELECT test_idx, test_count, ok_count, no_count FROM TEST WHERE word_id = '"
					+ word_id
					+ "' AND user_id ='"
					+ user_id
					+ "' AND table_id ='" + table_id + "'";
			System.out.println("insertTestInfo sql1=" + sql1);
			rs = stmt.executeQuery(sql1);
			//String nowDate = "20060310";
			String sql2 = "";
			if (rs.next()) {
				int test_idx = rs.getInt(1);
				int testCount = rs.getInt(2) + 1;
				int okCount = rs.getInt(3) + 1;
				int noCount = rs.getInt(4) + 1;
				//update
				if ("O".equals(okNo)) {
					/*
					 * Date nowDate = new Date(); SimpleDateFormat simple = new
					 * SimpleDateFormat(); simple.format("yyyyMMdd"); String
					 * strDate = simple.format(nowDate); System.out.println();
					 */
					sql2 = "update test set test_flg = 1, test_date=now(), ok_count = "
							+ okCount
							+ " , test_count = "
							+ testCount
							+ " WHERE test_idx = " + test_idx;
				} else if ("X".equals(okNo)) {
					sql2 = "update test set test_flg = 0, test_date=now(), no_count = "
							+ noCount
							+ " , test_count = "
							+ testCount
							+ " WHERE test_idx = " + test_idx;
				}
				stmt.executeUpdate(sql2);
			} else {
				//insert
				if ("O".equals(okNo)) {
					sql2 = "insert into test (word_id, user_id, table_id, test_count, ok_count, test_date, test_flg)"
							+ " values ( '"
							+ word_id
							+ "' , '"
							+ user_id
							+ "' , '"
							+ table_id
							+ "' , 1 , 1 , nowDate() , 1)";
				} else if ("X".equals(okNo)) {
					sql2 = "insert into test (word_id, user_id, table_id, test_count, no_count, test_date, test_flg)"
							+ " values ( '"
							+ word_id
							+ "' , '"
							+ user_id
							+ "' , '"
							+ table_id
							+ "' , 1 , 1 , nowDate() , 0)";
				}
				
				stmt.executeUpdate(sql2);
			}
			System.out.println("insertTestInfo sql2=" + sql2);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateOk failed");
			return false;
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	//	*****************************************************************

	public boolean isLogin(String id, String pwd) {
		System.out.println("isLogin start ");
		int cnt = 0;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where user_id ='" + id
					+ "' and user_pwd= '" + pwd + "'";
			System.out.println("isLogin sql = " + sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt(1);
			rs.close();
			stmt.close();

		} catch (SQLException se) {
			System.out.println("sql error");
		} catch (Exception s) {
			s.printStackTrace();
			System.out.println("etc error");
		}
		if (cnt != 0) {
			System.out.println("islogin sucees");
			return true;
		} else {
			System.out.println("islogin fail test");
			return false;
		}
	}
	
	//	*****************************************************************

	public boolean isRegistered(String id, String email) {
		System.out.println("isRegistered start ");
		int cnt = 0;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) from user where user_id ='" + id
					+ "' or email1= '" + email + "'";
			System.out.println("isLogin sql = " + sql);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("sql error");
		} catch (Exception s) {
			s.printStackTrace();
			System.out.println("etc error");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
		}
		if (cnt != 0) {
			System.out.println("user exist");
			return true;
		} else {
			System.out.println("no user exist");
			return false;
		}
	}
	
	public boolean insertRegistUser(String id, String pwd, String email) {
		ConnectionBean connection = new ConnectionBean();
		Connection con = connection.getConnection();
		Statement stmt = null;
		try {

			stmt = con.createStatement();
			String sql = "insert  into user (user_id, user_pwd, email1) values ('" +
					id + "' , '" +
					pwd + "' , '" +
					email + "' )";
			System.out.println("insert sql =" + sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//	*****************************************************************

	public int doubleNum(int num) {
		return num * num;
	}
	
	//	*****************************************************************

	private boolean existTestTable(Connection con, String wordTable, String userId) {
		System.out.println("existTestTable");
		int cnt = 0;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			String existTestTableSql = " select count(*)  from test where table_id = '" 
				    + wordTable 
					+ "' AND user_id= '"
					+ userId
					+ "'";

			System.out.println("existTestTableSql=" + existTestTableSql);
			rs = stmt.executeQuery(existTestTableSql);
			rs.next();
			cnt = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (cnt != 0) {
			System.out.println("existTestTable = true");
			return true;
		} else {
			System.out.println("existTestTable = false");
			return false;
		}
	}
	
	//	*******************************************************
	public boolean insertTestTable(Connection con, String table_id, String user_id) {
		boolean isSuccess = false;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql1 = "";
		String sql2 = "";
		try {

			stmt = con.createStatement();
			sql1 = "select word_idx from word where word_table='" + table_id + "'";
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				sql2 = "insert into test (word_id, user_id, table_id, test_count, ok_count, no_count, test_date, test_flg)"
					+ " values ( '"
					+ rs.getInt(1)
					+ "' , '"
					+ user_id
					+ "' , '"
					+ table_id
					+ "' , 0 , 0 , 0 , now(), 0)";	
				System.out.println("insertTestTable sql2=" + sql2);
				int insertResult = stmt.executeUpdate(sql2);
				System.out.println(insertResult);
			}
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert failed");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rs2 != null) {
					rs2.close();
				}				
				if (stmt != null) {
					stmt.close();
				}	
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return isSuccess;
	}
	//	*******************************************************
	public String getTestResult(String table_id, String user_id) {
		List testResultList = new ArrayList();
		Statement stmt = null;
		ResultSet rs = null;
		String sql1 = "";
		try {

			stmt = con.createStatement();
			sql1 = "select (sum(ok_count)/(sum(ok_count) + sum(no_count)))*100 as percent, " +
			       " sum(ok_count)+ sum(no_count) as total, " + 
				   " sum(ok_count) as sum_ok, sum(no_count) as sum_no, " +
				   " DATE_FORMAT(test_date, '%y %m %d') as test_date " + 
				   " from test where user_id= '" + user_id + "'" + 
				   " and table_id= '" + table_id + "'" +
				   " group by test_date order by test_date desc";
			rs = stmt.executeQuery(sql1);
			System.out.println("getTestResult sql1=" + sql1);
			while (rs.next()) {
				TestResultBean bean = new TestResultBean();
				Object temp = rs.getString(1);
				if (temp == null) {
					bean.setPercent("0");
				} else {
					bean.setPercent((String)temp);
					bean.setTotalCount(rs.getString(2));
					bean.setOkCount(rs.getString(3));
					bean.setNoCount(rs.getString(4));
					bean.setTestDate(rs.getString(5));
					testResultList.add(bean);
				}			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert failed");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}				
				if (stmt != null) {
					stmt.close();
				}	
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		String temp = changeTestResult(testResultList);
		System.out.println(temp);
		return temp;
	}
	
	//	*******************************************************
	private String changeTestResult(List list) {
		Iterator it = list.iterator();
		StringBuffer sbf = new StringBuffer();
		while (it.hasNext()) {
			sbf.append("<tr><td><font color=#004080><strong>");
			sbf.append("舛岩懸");
			TestResultBean bean = (TestResultBean)it.next();
			sbf.append(bean.getPercent());
			sbf.append("% 恥庚薦呪");
			sbf.append(bean.getTotalCount());
			sbf.append(" 舛岩呪");
			sbf.append(bean.getOkCount());
			sbf.append(" 神岩呪");
			sbf.append(bean.getNoCount());
			sbf.append(" 置曽砺�?闘析�?");
			sbf.append(chageDate(bean.getTestDate()));
			sbf.append("</strong></font></td></tr>");
		}

		return sbf.toString();
	}
	private String chageDate(String input) {
		String returnStr = "";
		if (input != null && (input.length() == 8)) {
			returnStr = "20" + input.substring(0, 2) + "�? " + 
			input.substring(3, 5) + "�? " + input.substring(6, 8) + "�?";
		}
		return returnStr;		
	}
	//	*******************************************************
	public List getTableList() {
		List tableList = new ArrayList();
		Statement stmt = null;
		ResultSet rs = null;
		String sql1 = "";
		try {

			stmt = con.createStatement();
			sql1 = "select word_table from word group by word_table " ;
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {				
				tableList.add((rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}	
				if (stmt != null) {
					stmt.close();
				}	
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return tableList;
	}

	//	*******************************************************
	public List getQuizSortList() {
		Statement stmt = null;
		ResultSet rs = null;
		String sql1 = "";
		List quizSortList = new ArrayList();
		try {

			stmt = con.createStatement();
			sql1 = "select constant.constance_name, constant.constance_value from word, constant where word.word_table = constant.constance_name group by word.word_table order by constant.idx" ;
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {	
				ConstantBean bean = new ConstantBean();
				bean.setConstance_name(rs.getString(1));
				bean.setConstance_value(rs.getString(2));	
				quizSortList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}	
				if (stmt != null) {
					stmt.close();
				}	
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return quizSortList;
	}
	
	//	*******************************************************
	public String changeTableName(Object inputValue) {
		String temp = (String)inputValue;
		String returnValue = "";
		if ("word1".equals(temp)) {
			returnValue = "析沙嬢�????石�?1000庚薦";
		} else if ("kanji1".equals(temp)) {
			returnValue = "析沙嬢�????石�?1";
		} else if ("kanji2".equals(temp)) {
			returnValue = "析沙嬢�????石�?2";
		} else if ("kanji3".equals(temp)) {
			returnValue = "析沙嬢�????石�?3";
		} else if ("kanji4".equals(temp)) {
			returnValue = "析沙嬢�????石�?4";
		} else if ("kanji5".equals(temp)) {
			returnValue = "析沙嬢�????石�?5";
		} else if ("kanji6".equals(temp)) {
			returnValue = "析沙嬢�????石�?6";
		} else if ("kanji7".equals(temp)) {
			returnValue = "析沙嬢�????石�?7";
		} else if ("kanji8".equals(temp)) {
			returnValue = "析沙嬢�????石�?8";
		} else if ("newkanji1".equals(temp)) {
			returnValue = "重析沙嬢�????石�?1";
		} else if ("newkanji2".equals(temp)) {
			returnValue = "重析沙嬢�????石�?2";
		} else if ("newkanji3".equals(temp)) {
			returnValue = "重析沙嬢�????石�?3";
		} else if ("newkanji4".equals(temp)) {
			returnValue = "重析沙嬢�????石�?4";		
		} else if ("newkanji5".equals(temp)) {
			returnValue = "重析沙嬢�????石�?5";
		} else if ("newkanji6".equals(temp)) {
			returnValue = "重析沙嬢�????石�?6";
		} else if ("newkanji7".equals(temp)) {
			returnValue = "重析沙嬢�????石�?7";			
		} else if ("keiyousi".equals(temp)) {
			returnValue = "析沙嬢莫遂紫";
		} else if ("dousi".equals(temp)) {
			returnValue = "析沙嬢 疑紫";
		} else if ("katakana1".equals(temp)) {
			returnValue = "朝展亜蟹1";		
		} else if ("katakana2".equals(temp)) {
			returnValue = "朝展亜蟹2";		
		} else if ("katakana3".equals(temp)) {
			returnValue = "朝展亜蟹3";		
		} else if ("katakana4".equals(temp)) {
			returnValue = "朝展亜蟹4";		
		}
		return returnValue;
	}
	
	public List getNewsList() {
		List newsList = new ArrayList();
		Statement stmt = null;
		ResultSet rs = null;
		String sql1 = "";
		try {
			stmt = con.createStatement();
			sql1 = " select contents, test_date, sort from news order by sort, test_date desc " ;
			System.out.println("sql1= " + sql1);
			rs = stmt.executeQuery(sql1);
			int count = 0;
			while (rs.next()) {	
				count ++;
				if (count > 1) {
					break;
				}
				newsList.add((rs.getString(1)));
				//newsList.add((rs.getString(2)));
				//newsList.add((rs.getString(3)));
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}	
				if (stmt != null) {
					stmt.close();
				}	
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return newsList;
	}
	public String readURL(int i) {
		//-----------------------------------------------------//
		//  Step 1: Start creating a few objects we'll need.
		//-----------------------------------------------------//

		URL u;
		InputStream is = null;
		//DataInputStream dis;
		BufferedReader dis = null;
		String s;
		String result = "";

		try {
			String urlStr = "";
			switch (i) {
				case 1: 
					//urlStr = "http://kr.news.yahoo.com/bestclick/";
					urlStr = "http://kr.news.yahoo.com/service/news/shelllist.htm?linkid=rank_news";
					break;
				case 2: 
					urlStr = "http://community.fxkeb.com/fxportal/jsp/RS/DEPLOY_EXRATE/mainrate_1.html";
					break;		
				case 3: 
					urlStr = "http://headlines.yahoo.co.jp/accr?ty=t&c=all";
					break;	
			}
			u = new URL(urlStr);
			is = u.openStream(); 
			//dis = new DataInputStream(new BufferedInputStream(is));
			dis = new BufferedReader(new InputStreamReader(new BufferedInputStream(is)));
			switch (i) {
				case 1: 
					result = mergeNews(dis);
					break;
				case 2: 
					result = mergeRate(dis);
					break;		
				case 3: 
					//result = mergeNewsYahooJp(dis);
					break;	
			}			

		} catch (MalformedURLException mue) {

			System.out.println("Ouch - a MalformedURLException happened.");
			mue.printStackTrace();
			System.exit(1);

		} catch (IOException ioe) {

			System.out.println("Oops- an IOException happened.");
			ioe.printStackTrace();
			System.exit(1);

		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
/*			try {
				String temp = result.toString();
				System.out.println("DB input STR=" + temp);
				if(insertUrlToDB(temp)){
					System.out.println("insert url successed");
				} else {
					System.out.println("insert url failed");
				}
				is.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}*/
		} // end of 'finally' clause
		return result;
	}
	private boolean insertUrlToDB(String inputStr) {
		ConnectionBean connection = new ConnectionBean();
		Connection con = connection.getConnection();
		try {

			Statement stmt = con.createStatement();
			//sour 1. �??��嬢 2 析沙嬢 3 慎嬢 
			int sort = 1;
			inputStr = changeSingleToDouble(inputStr);
			String sql = "insert  into news (contents, test_date, sort) values ('"
					+ new String(inputStr.getBytes("UTF-8"),"8859_1") + "' , now() , " + sort + " )";
			System.out.println("insert sql =" + sql);
			stmt.executeUpdate(sql);

			stmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	private String changeSingleToDouble(String inputStr) {
		inputStr = inputStr.replaceAll("'", "\"");
		return inputStr;
	}
	/*
	 * 敢�?�?  昼究
	 * @param dis URL鎧�?
	 * @return 敢�?
	 */
	private String mergeNews(BufferedReader dis) {
		//logger.debug("mergeNews start");
		StringBuffer sbf = new StringBuffer();
		int count = 0;
		boolean continueFlg = false;
		boolean existDiv = false;
		try {
			while (dis.ready()) {
				//String tempStr = new String(dis.readLine().getBytes("8859_1"), "KSC5601");
				String tempStr = "";
				tempStr = dis.readLine();
				System.out.println(tempStr);
				int isStarted = tempStr.indexOf("<div id=lst1>");
				int isEnded = tempStr.indexOf("<!--// 軒�?�? �?-->");
				if (isStarted != -1) {
					continueFlg = true;
				}
				if (continueFlg && isEnded != -1) {
					return sbf.toString();
				} 
				if (continueFlg) {
					sbf.append(tempStr);
				}
//				int includeRanking = tempStr.indexOf("是");
//				int includeEndTag = tempStr.indexOf("</dd>");
//				if (count > 50) {
//					break;
//				}
//				if (includeRanking != -1 && includeEndTag != -1) {
//					count++;
//					sbf.append(changeRankingStr(tempStr));
//					sbf.append("\r\n");
//				} else if (includeRanking != -1 && includeEndTag == -1) {
//					sbf.append(changeRankingStr(tempStr));
//					continueFlg = true;
//					
//				} else if (continueFlg == true && includeRanking == -1 && includeEndTag != -1) {
//					count++;
//					sbf.append(changeRankingStr(tempStr));
//					sbf.append("\r\n");
//					continueFlg = false;
//				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return sbf.toString();		
	}
	
	/*
	 * YahooJp敢�?�?  昼究
	 * @param dis URL鎧�?
	 * @return 敢�?
	 */
	private String mergeNewsYahooJp(BufferedReader dis) {
		//logger.debug("mergeNews mergeNewsYahooJp");
		StringBuffer sbf = new StringBuffer();
		int count = 0;
		//boolean continueFlg = false;
		boolean includeRankingFlg = false;
		boolean includeStartTagFlg = false;
		boolean includeEndTagFlg = false;
		try {
			while (dis.ready()) {
				String tempStr = new String(dis.readLine().getBytes("8859_1"), "EUC-JP");
				tempStr = new String(tempStr.getBytes("EUC-JP"), "UTF-8");
				//String tempStr = new String(dis.readLine().getBytes("iso-8859-1"), "Shift_JIS");
				//String tempStr = dis.readLine();
				//String tempStr = dis.readLine();
				System.out.println("1mergeNewsAsahi tempStr=" + tempStr);
				int includeRanking = tempStr.indexOf("<!--- News_ranking_TABLE-->");
				tempStr = tempStr.replaceAll("\"", "'");				
				if (includeRanking != -1 ) {
					includeRankingFlg = true;
				}
				int includeStartTag = tempStr.indexOf("<table cellpadding=3 cellspacing=1 border=0 width=100%>");

				if (includeStartTag != -1 ) {
					includeStartTagFlg = true;
				}
				int includeEndTag = tempStr.indexOf("</table>");
				
				if (includeStartTagFlg && (includeEndTag != -1 )) {
					includeEndTagFlg = true;
				}
//				if (count > 1) {
//					break;
//				}
				if (includeRankingFlg && includeStartTagFlg && !includeEndTagFlg) {
					
					sbf.append(tempStr.trim());
					sbf.append("\r\n");
					
				} else if (includeRankingFlg && includeStartTagFlg && includeEndTagFlg) {
					sbf.append(tempStr);
					sbf.append("\r\n");
					includeRankingFlg = false;
					includeEndTagFlg = false;
					count++;
					break;					
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return sbf.toString();		
	}
	private String changeRankingStr (String inputStr) {
		System.out.println("inputStr=" + inputStr.trim() + "=");
		String returnStr = "";
		returnStr = inputStr.trim();
		returnStr = returnStr.replaceAll("a href=./shellview", "a href=http://kr.news.yahoo.com/bestclick/shellview");
		returnStr = returnStr.replaceAll("width:360px", "width:600px");
		return returnStr;
	}
	/*
	 * 古古掻�??���? 昼究
	 * @param dis URL鎧�?
	 * @return 古古掻�??�� 殿�?
	 */
	private String mergeRate(BufferedReader dis) {
		//logger.debug("mergeRate start");
		StringBuffer sbf = new StringBuffer();
		List list = new ArrayList();
		String tag = "";
		try {
			int count = 0;
			boolean continueFlg = false;

			while (dis.ready()) {
				String line = "";
				//line = new String(dis.readLine().getBytes("8859_1"), "KSC5601");
				if (dis != null) {
					line = dis.readLine();
				}
				
				//System.out.println("line=" + line);
				if (continueFlg && count < 2) {
					int includeTd = line.indexOf("</td>");
					if (includeTd != -1) {
						String temp = line.substring(includeTd - 6, includeTd);
						System.out.println("count=" + count + ", temp = " + temp);
						list.add(temp);
						count ++;
					}
				} else if (!continueFlg) {
					int includeYen = line.indexOf("�?");
					if (includeYen != -1) {
						continueFlg = true;//"Y"�? 達紹�? 凶
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			String middlePrice = getMiddlePrice(list);
			tag = makeWeatherTag(list, middlePrice);
		}
		//logger.debug("mergeRate end");
		return tag;		
	}
	/*
	 *古古掻�??���? 昼究
	 * @param list 古古, 古�?晴�? 軒�?�?
	 * @return 古古掻�??�� 
	 */
	private String getMiddlePrice(List list) {
		//logger.debug("getMiddlePrice start");
		String sellPrice = (String)list.get(0);
		String buyPrice = (String)list.get(1);
		BigDecimal bigSellPrice = new BigDecimal(sellPrice);
		BigDecimal bigBuyPrice = new BigDecimal(buyPrice);
		BigDecimal middlePrice = (bigSellPrice.add(bigBuyPrice).divide(new BigDecimal("2"), BigDecimal.ROUND_HALF_UP));
		//logger.debug("getMiddlePrice end , return =" + middlePrice.toString());
		return middlePrice.toString();
	}
	
	/*
	 * 発晴�? 妊獣�? tag�? 持失
	 * @param list 古古, 古�?晴�? 軒�?�?
	 * @param middlePrice 古古掻�??��
	 * @return 発晴�? 妊獣�? tag 
	 */
	private String makeWeatherTag(List list, String middlePrice) {
	//	logger.debug("makeWeatherTag start");
		String sellPrice = (String)list.get(0);
		String buyPrice = (String)list.get(1);
		StringBuffer sb = new StringBuffer();
		sb.append("<TABLE BORDER='1'>");
		sb.append("<TR>");
		sb.append("<TD>");
		sb.append("�??�? 独 凶");
		sb.append("</TD>");
		sb.append("<TD>");
		sb.append("掻�? 古古晴");
		sb.append("</TD>");
		sb.append("<TD>");
		sb.append("�??�? �? 凶");
		sb.append("</TD>");
		sb.append("</TR>");
		
		sb.append("<TR>");
		sb.append("<TD>");
		sb.append(buyPrice);
		sb.append("</TD>");
		sb.append("<TD>");
		sb.append(middlePrice);
		sb.append("</TD>");
		sb.append("<TD>");
		sb.append(sellPrice);
		sb.append("</TD>");
		sb.append("</TR>");
		sb.append("</TABLE>");
		
	//	logger.debug("makeWeatherTag end , return =" + sb.toString());
		return sb.toString();
	}
}
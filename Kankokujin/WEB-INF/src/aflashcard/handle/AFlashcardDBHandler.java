package aflashcard.handle;

import iboard.bean.IBoardSearchBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aflashcard.bean.AFlashcardDeck;
import aflashcard.bean.Question;

import menu.handler.SQLUtil;

import common.bean.MemberBean;
import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.EnDecoding;
import common.util.Util;


public class AFlashcardDBHandler {
	
	
	private static AFlashcardDBHandler instance = null;
	
	private AFlashcardDBHandler(){
		
	}
    public static AFlashcardDBHandler getInstance() {
        if (instance == null) {
            synchronized (AFlashcardDBHandler.class) {
                if (instance == null) {
                    instance = new AFlashcardDBHandler();
                }
            }
        }

        return instance;
    }
    
    
    
    /**
	 * Member��INSERT���閽��
	 * 
	 * @return void
	 */
	public int insertUserInfo(Connection con, MemberBean bean) throws SysException {
		LogPreparedStatement pstmt = null;
		int result = 0;
		try {
			String strSql = "insert into M_user(user_id,password,userName) values(?,?,?)";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, bean.getUserid());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, EnDecoding.decoding(bean.getName()));
			KankokujinLogger.getInstance().debug("insertUserInfo" + pstmt.getQueryString());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new SysException("SYE0010", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0010", e);
					
				}
		}

		return result;
	}
    
    
    public boolean isExistUserId(Connection con, String id) throws SysException {
		int count = 0;
		LogPreparedStatement pstmt = null;
		try {
			String strSql = "select count(*) from M_user where user_id=?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, id);
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.isExistId" + pstmt.getQueryString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			if (count != 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new SysException(
					"SYE0007", e);
		} catch (Exception e) {
			throw new SysException(
					"SYE0007", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException(
							"SYE0007",
							e);
				}
		}
		return false;
	}
    
    /**
	 * Member��id/password *
	 * 
	 * @return void
	 * @throws AppException
	 */
	public MemberBean loginPro(String id, String pw) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean memberBean = null;
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "select * from M_user where user_id=?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberLoginHandler.loginPro" + pstmt.getQueryString());
			if (rs.next()) {
				if (rs.getString("password").equals(pw)) {
					memberBean = new MemberBean();
					memberBean.setUserid(rs.getString("user_id"));
					memberBean.setPassword(rs.getString("password"));
					memberBean.setName(rs.getString("userName"));
				}
			} 
		} catch (SQLException e) {
			throw new SysException("SYE0026", e);
		} catch (Exception e) {
			throw new SysException("SYE0026", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new SysException("SYE0026", e);
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return memberBean;
	} 
    
    
    public List<AFlashcardDeck> getMemorizerGroupList(
    		Connection con,
    		PageBean pageBean,
    		String userId,
    		List<String> categoryCodeList) throws AppException {
    	
    	LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		//maxCount
		int maxCount = 0;
		
		List<AFlashcardDeck> list = new ArrayList<AFlashcardDeck>();
		
		if (categoryCodeList == null) {
			return list;
		}
		
		try {
			String countGetQuery = getCountGetQuery(userId, categoryCodeList);
			String listGetQuery = getListGetQuery(userId, categoryCodeList);
			
			//
			pstmt = new LogPreparedStatement(con, countGetQuery);
			System.out.println(pstmt.getQueryString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemorizerDBHandler.getMemorizerGroupList.sql1=" + pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			
			//�y�[�W����
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			pstmt = new LogPreparedStatement(con, listGetQuery);
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());
			System.out.println(pstmt.getQueryString());
			KankokujinLogger.getInstance().debug("MemorizerDBHandler.getMemorizerGroupList.sql2=" + pstmt.getQueryString());
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
		
				AFlashcardDeck bean = new AFlashcardDeck();
				bean.setGroupid(rs.getInt("groupid"));
				bean.setGroupName(rs.getString("groupname"));
				bean.setUserid(rs.getString("userid"));
				bean.setQuestionCnt(rs.getInt("questionCnt"));
				bean.setRegisterName(rs.getString("username"));
				bean.setCategoryName(rs.getString("cateName"));
				
				list.add(bean);
			}
		
		} catch (SQLException e) {
			throw new AppException("SYE0038", e);
		} catch (Exception e) {
			throw new AppException("SYE0038", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037" + e);
				}
			}
		}
		
		return list;
    	
    }
    
    public List<AFlashcardDeck> getMemorizerGroupListBySearch(
    		Connection con,
    		PageBean pageBean,
    		String userId,
    		List<String> categoryCodeList, 
    		String searchRange,
    		String search) throws AppException {
    	
    	LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		//maxCount
		int maxCount = 0;
		
		List<AFlashcardDeck> list = new ArrayList<AFlashcardDeck>();
		
		if (categoryCodeList == null) {
			return list;
		}
		
		try {
			String countGetQuery = getCountGetQueryBySearch(userId, categoryCodeList, searchRange, search);
			String listGetQuery = getListGetQueryBySearch(userId, categoryCodeList, searchRange, search);
			
			//
			pstmt = new LogPreparedStatement(con, countGetQuery);
			System.out.println(pstmt.getQueryString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemorizerDBHandler.getMemorizerGroupList.sql1=" + pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			
			//�y�[�W����
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			pstmt = new LogPreparedStatement(con, listGetQuery);
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());
			System.out.println(pstmt.getQueryString());
			KankokujinLogger.getInstance().debug("MemorizerDBHandler.getMemorizerGroupList.sql2=" + pstmt.getQueryString());
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
		
				AFlashcardDeck bean = new AFlashcardDeck();
				bean.setGroupid(rs.getInt("groupid"));
				bean.setGroupName(rs.getString("groupname"));
				bean.setUserid(rs.getString("userid"));
				bean.setQuestionCnt(rs.getInt("questionCnt"));
				bean.setRegisterName(rs.getString("username"));
				bean.setCategoryName(rs.getString("cateName"));
				
				list.add(bean);
			}
		
		} catch (SQLException e) {
			throw new AppException("SYE0038", e);
		} catch (Exception e) {
			throw new AppException("SYE0038", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037" + e);
				}
			}
		}
		
		return list;
    	
    }
    
    public Map<String, String> getGroupInfo(Connection con, String groupId, String userId) throws AppException {
    	
    	Map<String, String> userQuestionGroupInfo = new HashMap<String, String>();
    	LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		String groupName = null;
		
		try {
			String query = "select * from M_user_question_groups where group_id = ? and user_id = ?";

			pstmt = new LogPreparedStatement(con, query);
			pstmt.setInt(1, Integer.valueOf(groupId).intValue());
			pstmt.setString(2, userId);
			KankokujinLogger.getInstance().debug("MemorizerDBHandler.getMemorizerGroupList.sql1=" + pstmt.getQueryString());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userQuestionGroupInfo.put("user_id", rs.getString("user_id"));
				userQuestionGroupInfo.put("group_id", rs.getString("group_id"));
				userQuestionGroupInfo.put("group_name", rs.getString("group_name"));
				userQuestionGroupInfo.put("register_user_id", rs.getString("register_user_id"));
			}
		
		} catch (SQLException e) {
			throw new AppException("SYE0038", e);
		} catch (Exception e) {
			throw new AppException("SYE0038", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037" + e);
				}
			}
		}
		return userQuestionGroupInfo;
		
    }
    
    public List<Question> getMemorizerList(Connection con, String groupId, PageBean pageBean) throws AppException {
    	LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		//maxCount
		int maxCount = 0;
		
		List<Question> list = new ArrayList<Question>();
		try {
			String countGetQuery = "select count(*) from M_questionGroup where group_id = ?";
			String listGetQuery = "select * from M_questionGroup inner join M_questions on M_questionGroup.question_id = M_questions.id where M_questionGroup.group_id = ? limit ?,?";
			
			//
			pstmt = new LogPreparedStatement(con, countGetQuery);
			pstmt.setInt(1, Integer.valueOf(groupId).intValue());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemorizerDBHandler.getMemorizerGroupList.sql1=" + pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			
			//�y�[�W����
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			pstmt = new LogPreparedStatement(con, listGetQuery);
			pstmt.setInt(1, Integer.valueOf(groupId).intValue());
			pstmt.setInt(2, pageBean.getStartCount() - 1);
			pstmt.setInt(3, pageBean.getPageSize());
			System.out.println(pstmt.getQueryString());
			KankokujinLogger.getInstance().debug("MemorizerDBHandler.getMemorizerGroupList.sql2=" + pstmt.getQueryString());
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
		
				Question bean = new Question();
				bean.setQuestion(rs.getString("question"));
				bean.setAnswer(rs.getString("answer"));
				
				list.add(bean);
			}
		
		} catch (SQLException e) {
			throw new AppException("SYE0038", e);
		} catch (Exception e) {
			throw new AppException("SYE0038", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037" + e);
				}
			}
		}
		
		return list;
    }
    
    public List<Question> getMemorizerListAll(Connection con, String groupId) throws AppException {
    	LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Question> list = new ArrayList<Question>();
		try {
			String query = "select * from M_questionGroup inner join M_questions on M_questionGroup.question_id = M_questions.id where M_questionGroup.group_id = ?";
			
			//
			pstmt = new LogPreparedStatement(con, query);
			pstmt.setInt(1, Integer.valueOf(groupId).intValue());
		
			System.out.println(pstmt.getQueryString());
			KankokujinLogger.getInstance().debug("MemorizerDBHandler.getMemorizerGroupList.sql2=" + pstmt.getQueryString());
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
		
				Question bean = new Question();
				bean.setQuestion(rs.getString("question"));
				bean.setAnswer(rs.getString("answer"));
				
				list.add(bean);
			}
		
		} catch (SQLException e) {
			throw new AppException("SYE0038", e);
		} catch (Exception e) {
			throw new AppException("SYE0038", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037" + e);
				}
			}
		}
		
		return list;
    }
    
    public int insertQuestions(
    		Connection con, 
    		String groupName,
    		String userid,
    		String username,
    		String registerUserId,
    		String password,
    		List<Question> questions, 
    		String categoryCode) throws AppException {
    	
    	int totalInsertCount = 0;
    	ResultSet rs = null;
    	LogPreparedStatement isExistQuestionsStmt = null;
    	LogPreparedStatement insertQuestionGroupStmt = null;
		LogPreparedStatement insertQuestionsStmt = null;
		try{
			
			
			StringBuilder isExistQuestions = new StringBuilder();
			StringBuilder insertQuestionGroup = new StringBuilder();
			StringBuilder insertQuestions = new StringBuilder();
			
			isExistQuestions.append("select * from M_questions where question = ? and answer = ?");
			insertQuestions.append("insert into M_questions (question, answer) values (?, ?)");
			insertQuestionGroup.append("insert into M_questionGroup (group_id, question_id) values (?, (select id from M_questions where question = ? and answer = ?))");
			
			isExistQuestionsStmt = new LogPreparedStatement(con, isExistQuestions.toString());
			insertQuestionGroupStmt = new LogPreparedStatement(con, insertQuestionGroup.toString());
			insertQuestionsStmt = new LogPreparedStatement(con, insertQuestions.toString());
			
			//問題挿入
			for (Question question : questions) {
				isExistQuestionsStmt.setString(1, question.getQuestion());
				isExistQuestionsStmt.setString(2, question.getAnswer());
				KankokujinLogger.getInstance().debug("isExistQuestionsStmt" + isExistQuestionsStmt.getQueryString());
				rs = isExistQuestionsStmt.executeQuery();
				if (!rs.next()) {
					insertQuestionsStmt.setString(1, question.getQuestion());
					insertQuestionsStmt.setString(2, question.getAnswer());
					System.out.println(insertQuestionsStmt.getQueryString());
					totalInsertCount += insertQuestionsStmt.executeUpdate();
				}
			}
			int groupId = getMaxGroupId(con) + 1;
			//Group挿入
			for (Question question : questions) {
				insertQuestionGroupStmt.setInt(1, groupId);
				insertQuestionGroupStmt.setString(2, question.getQuestion());
				insertQuestionGroupStmt.setString(3, question.getAnswer());
				KankokujinLogger.getInstance().debug("insertQuestionGroupStmt" + insertQuestionGroupStmt.getQueryString());
				System.out.println(insertQuestionGroupStmt.getQueryString());
				insertQuestionGroupStmt.executeUpdate();
			}
			
			insertUserQuestionGroups(con, userid, username, groupId, registerUserId, groupName, categoryCode, password);
	    }catch (Exception e) {
	    	throw new AppException("Exception" , e);

		} finally {
			if (insertQuestionGroupStmt != null) {
				try {
					insertQuestionGroupStmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}
			}
			if (insertQuestionsStmt != null) {
				try {
					insertQuestionsStmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}
			}
				
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return totalInsertCount;

	}
    public boolean deleteUserQuestionGroupsByPassword(Connection con, String userId, int groupId, String password) throws AppException {
    	int result = 0;
    	LogPreparedStatement pstmt = null;
		try{
			StringBuilder sb = new StringBuilder();//1-5
			sb.append("delete from M_user_question_groups where user_id = ? and group_id = ? and password = ?");
			
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, userId);
			pstmt.setInt(2, groupId);
			pstmt.setString(3, password);
			KankokujinLogger.getInstance().debug("deleteUserQuestionGroupsByPassword" + pstmt.getQueryString());
			result = pstmt.executeUpdate();
	    }catch (Exception e) {
	    	throw new AppException("Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}
		}
		return result == 1 ? true : false;
    }
    
    
    public int deleteUserQuestionGroupsByCategoryCode(Connection con, String userId, String categoryCode) throws SysException {
    	
    	int result = 0;
    	LogPreparedStatement pstmt = null;
		try{
			
			StringBuilder sb = new StringBuilder();//1-5
			sb.append("delete from M_user_question_groups where user_id = ? and categoryCode = ?");
			
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, categoryCode);
			KankokujinLogger.getInstance().debug("deleteUserQuestionGroupsByCategoryCode" + pstmt.getQueryString());
			result = pstmt.executeUpdate();
	    }catch (Exception e) {
	    	throw new SysException("Exception" , e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SQLException" , e);
				}
		}
		return result;
    }
    
    public boolean deleteUserQuestionGroupsByGroupId(Connection con, String userId, int groupId) throws AppException {
    	int result = 0;
    	LogPreparedStatement pstmt = null;
		try{
			
			StringBuilder sb = new StringBuilder();//1-5
			sb.append("delete from M_user_question_groups where user_id = ? and group_id = ?");
			
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, userId);
			pstmt.setInt(2, groupId);
			KankokujinLogger.getInstance().debug("deleteUserQuestionGroupsByCategoryCode" + pstmt.getQueryString());
			result = pstmt.executeUpdate();
	    }catch (Exception e) {
	    	throw new AppException("Exception" , e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}
		}
		return result == 1 ? true : false;
    }
    
    
    /**
     * 
     * @param con
     * @param userid
     * @param groupid
     * @param categoryCode
     * @return 0:重複エラー、1:成功
     * @throws AppException
     */
    public int insertUserQuestionGroups(
    		Connection con, 
    		String userid,   
    		String username,
    		int groupid, 
    		String registerUserId,
    		String groupName,
    		String categoryCode, 
    		String password) throws AppException {
    	
    	int result = 0;
    	LogPreparedStatement pstmt = null;
		try{
			if (duplicateCheck(con, userid, groupid)) {
				return result;
			}
			StringBuilder sb = new StringBuilder();//1-5
			sb.append("insert into M_user_question_groups (user_id, user_name, group_id, register_user_id, group_name, categoryCode, password) values (?, ?, ?, ?, ?, ?, ?)");
			
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, username);
			pstmt.setInt(3, groupid);
			pstmt.setString(4, registerUserId);
			pstmt.setString(5, groupName);
			pstmt.setString(6, categoryCode);
			pstmt.setString(7, password);
			KankokujinLogger.getInstance().debug("insertUserQuestionGroups" + pstmt.getQueryString());
			result = pstmt.executeUpdate();
	    }catch (Exception e) {
	    	throw new AppException("Exception" , e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" , e);
				}
		}
		return result;
    }
    
    /**
     * 
     * @param con
     * @param userid
     * @param groupid
     * @return true:重複 false:重複ない
     * @throws AppException
     */
    private boolean duplicateCheck(Connection con, String userid, int groupid) throws AppException {
    	boolean check = false;
    	LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("select * from M_user_question_groups where user_id=? and group_id=?");
			//
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, userid);
			pstmt.setInt(2, groupid);
			System.out.println(pstmt.getQueryString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				check = true;
			}
		} catch (SQLException e) {
			throw new AppException("SYE0038", e);
		} catch (Exception e) {
			throw new AppException("SYE0038", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037" + e);
				}
			}
		}
		return check;
    }
    
    private int getMaxGroupId(Connection con) throws AppException {
    	LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		//maxCount
		int maxCount = 0;
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("select MAX(group_id) from M_questionGroup ");
			
			//
			pstmt = new LogPreparedStatement(con, sb.toString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("getMaxGroupId=" + pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
		
		} catch (SQLException e) {
			throw new AppException("SYE0038", e);
		} catch (Exception e) {
			throw new AppException("SYE0038", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037", e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SYE0037" + e);
				}
			}
		}
		
		return maxCount;
    }
    
    
	
	
	/**
	 * 
	 * @param bean
	 * @return
	 */
	public String getWhereList(IBoardSearchBean bean) {
		
		String whereSql = "";
		String search = bean.getSearch();
		String search_range = bean.getSearch_range();
		String board_id = bean.getIboard_id();
		List<String> andList = new ArrayList<String>();
		List<String> orList = new ArrayList<String>();
		
		if (!Util.isEmpty(search)) {
			List<String> searchList = SQLUtil.changeSearch(search);
			/** 全体検索 */
			if ("0".equals(search_range)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "title"));
				orList.add(SQLUtil.makelikeSQL(searchList, "content"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name1"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name2"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name3"));
			/** タイトル */
			} else if ("1".equals(search_range)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "title"));
			/** 内容 */
			} else if ("2".equals(search_range)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "content"));		
			/** ファイル名 */
			} else if ("3".equals(search_range)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name1"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name2"));
				orList.add(SQLUtil.makelikeSQL(searchList, "file_name3"));
			}
			andList.add(SQLUtil.getWhereOrSql(orList));
			
		}
		andList.add(SQLUtil.makeEqualStateForChar("board_id", board_id));
		whereSql = SQLUtil.getWhereSQL(andList);
		return whereSql;
			
	}
	
	 /**
	 * @param iboard_info
	 * @return 
	 */
	private String getListGetQuery(String userId, List<String> categoryCodeList) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select A.group_id as groupid, A.group_name as groupname, A.user_id as userid, A.user_name as username,count(B.question_id) as questionCnt, C.name as cateName from ");
		sb.append("(M_user_question_groups as A inner join M_questionGroup as B on A.group_id = B.group_id) ");
		sb.append("inner join M_category as C on A.categoryCode = C.code and A.user_id = C.user_id ");
		List<String> andList = new ArrayList<String>();
		
		andList.add(SQLUtil.makeEqualStateForChar("A.user_id", userId));
//		if (categoryCode != null && categoryCode.length() != 0 && !"0000".equals(categoryCode)) {
//			andList.add(SQLUtil.makeEqualStateForChar("categoryCode", categoryCode));
//		}
		andList.add(SQLUtil.makeINStateForChar("A.categoryCode", categoryCodeList));
		
		sb.append(SQLUtil.getWhereSQL(andList));
		
		sb.append(" group by B.group_id");
		
		sb.append(" limit ?,? ");
		return sb.toString();
	}
	
	/**
	 * @param iboard_info
	 * @return 
	 */
	private String getCountGetQuery(String userId, List<String> categoryCodeList) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from M_user_question_groups ");
		
		List<String> andList = new ArrayList<String>();
		
		andList.add(SQLUtil.makeEqualStateForChar("user_id", userId));
//		if (categoryCode != null && categoryCode.length() != 0 && !"0000".equals(categoryCode)) {
//			andList.add(SQLUtil.makeEqualStateForChar("categoryCode", categoryCode));
//		}
		andList.add(SQLUtil.makeINStateForChar("categoryCode", categoryCodeList));
		sb.append(SQLUtil.getWhereSQL(andList));
		return sb.toString();
	}
	
	 /**
	 * @param iboard_info
	 * @return 
	 */
	private String getListGetQueryBySearch(
			String userId,
			List<String> categoryCodeList,
			String searchRange,
			String search) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select A.group_id as groupid, A.group_name as groupname, A.user_id as userid, A.user_name as username, count(B.question_id) as questionCnt, C.name as cateName from ");
		sb.append("(M_user_question_groups as A inner join M_questionGroup as B on A.group_id = B.group_id) ");
		sb.append("inner join M_category as C on A.categoryCode = C.code and A.user_id = C.user_id ");
		List<String> andList = new ArrayList<String>();
		List<String> orList = new ArrayList<String>();
		
		if (!Util.isEmpty(search)) {
			List<String> searchList = SQLUtil.changeSearch(search);
			/** 전체 */
			if ("0".equals(searchRange)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "A.group_name"));
				orList.add(SQLUtil.makelikeSQL(searchList, "A.user_name"));
			/** 암기장 */
			} else if ("1".equals(searchRange)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "A.group_name"));
			/** 등록자 */
			} else if ("2".equals(searchRange)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "A.user_name"));
			}
			andList.add(SQLUtil.getWhereOrSql(orList));
			
		}
		andList.add(SQLUtil.makeEqualStateForChar("A.user_id", userId));
//		if (categoryCode != null && categoryCode.length() != 0 && !"0000".equals(categoryCode)) {
//			andList.add(SQLUtil.makeEqualStateForChar("categoryCode", categoryCode));
//		}
		andList.add(SQLUtil.makeINStateForChar("A.categoryCode", categoryCodeList));
		
		sb.append(SQLUtil.getWhereSQL(andList));
		
		sb.append(" group by B.group_id");
		sb.append(" limit ?,? ");
		return sb.toString();
	}
	
	/**
	 * @param iboard_info
	 * @return 
	 */
	private String getCountGetQueryBySearch(
			String userId,
			List<String> categoryCodeList,
			String searchRange,
			String search) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from ");
		sb.append("(M_user_question_groups as A inner join M_category as B on A.categoryCode = B.code and A.user_id = B.user_id) ");
		List<String> andList = new ArrayList<String>();
		List<String> orList = new ArrayList<String>();
		
		if (!Util.isEmpty(search)) {
			List<String> searchList = SQLUtil.changeSearch(search);
			/** 전체 */
			if ("0".equals(searchRange)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "A.group_name"));
				orList.add(SQLUtil.makelikeSQL(searchList, "A.user_name"));
			/** 암기장 */
			} else if ("1".equals(searchRange)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "A.group_name"));
			/** 등록자 */
			} else if ("2".equals(searchRange)) {
				orList.add(SQLUtil.makelikeSQL(searchList, "A.user_name"));
			}
			andList.add(SQLUtil.getWhereOrSql(orList));
			
		}
		andList.add(SQLUtil.makeEqualStateForChar("A.user_id", userId));
//		if (categoryCode != null && categoryCode.length() != 0 && !"0000".equals(categoryCode)) {
//			andList.add(SQLUtil.makeEqualStateForChar("categoryCode", categoryCode));
//		}
		andList.add(SQLUtil.makeINStateForChar("A.categoryCode", categoryCodeList));
		
		sb.append(SQLUtil.getWhereSQL(andList));
		return sb.toString();
	}
	
	
	
}
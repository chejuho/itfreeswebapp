package aflashcard.category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class MCategoryUtil {
	
	public static void main(String[] args) throws SysException, AppException {
		Connection con = DBConnectionMgr.getInstance().getConnection();
		MCategory category = createTreeCategory("admin");
		
		MCategory searchCategory = searchMCategoryByCode(category, "0001");
		
		List<String> codeList = getCategoryCode(searchCategory);
		
		for (String code : codeList) {
			System.out.println(code);
		}
	}
	
	
	/**
	 * 
	 * @param category
	 * @param selectedCode
	 * @return
	 */
	public static String makeHtmlForManager(MCategory category, String forward, String selectedCode, String userID) {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<table valign='top'>");
		buffer.append("<tr>");
		buffer.append("<td>");
		buffer.append(makeTreeHtmlForManager(category,forward,selectedCode,userID));
		buffer.append("</td>");
		buffer.append("<tr>");
		buffer.append("</table>");
		return buffer.toString();
		
		
		//return compo.makeHtml();
	}
	
	/**
	 * 
	 * @param category
	 * @param selectedCode
	 * @return
	 */
	private static String makeTreeHtmlForManager(MCategory category, String forward, String selectedCode, String userID) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<ul>\n");
		if (category.getChildCategory().size() == 0) {
			if (selectedCode.equals(category.getCateCode())) {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=noneselect " + "onclick='categoryClick(\"" + forward + "\" , \"" + category.getCateCode() + "\" ,\"" + userID  + "\" )'"  + ">" + "\n");
			} else {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=none " + "onclick='categoryClick(\"" + forward + "\" , \"" + category.getCateCode()  + "\" ,\"" + userID  + "\" )'"  + ">" + "\n");
			}
			
		}else if (category.isOpen()) {
			if (selectedCode.equals(category.getCateCode())) {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=minusselect " + "onclick='categoryClick(\"" + forward + "\" , \"" + category.getCateCode()  + "\" ,\"" + userID  + "\" )'"  + ">" + "\n");
			} else {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=minus " + "onclick='categoryClick(\"" + forward + "\" , \"" + category.getCateCode()  + "\" ,\"" + userID  + "\" )'"  + ">" + "\n");
			}
			
		} else {
			if (selectedCode.equals(category.getCateCode())) {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=plusselect " + "onclick='categoryClick(\"" + forward + "\" , \"" + category.getCateCode()  + "\" ,\"" + userID  + "\" )'"  + ">" + "\n");
			} else {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=plus " + "onclick='categoryClick(\"" + forward + "\" , \"" + category.getCateCode()  + "\" ,\"" + userID  + "\" )'"  + ">" + "\n");
			}
		}
		buffer.append(category.getName() + "\n");
		buffer.append("</span>");
		buffer.append("<ul>\n");
		if (category.isOpen()) {
			for (Iterator<MCategory> it = category.getChildCategory().iterator(); it.hasNext();) {
				MCategory cate = it.next();
				buffer.append(makeTreeHtmlForManager(cate, forward, selectedCode,  userID)) ;
			}
		}
		buffer.append("</ul>\n");
		buffer.append("</li>\n");
		//}
		buffer.append("</ul>\n");
		return buffer.toString();
		
		
		//return compo.makeHtml();
	}
	
	public static boolean onclickCategory(MCategory category, String code) {
		
		if (category.getCateCode().equals(code)) {
			if (category.isOpen()) {
				category.setOpenClose(false);
			} else {
				category.setOpenClose(true);
			}
			return true;
		}
		Iterator<MCategory> it = category.getChildCategory().iterator();
		while (it.hasNext()) {
			MCategory subCategory = it.next();
			if (onclickCategory(subCategory, code)) {
				return true;
			}
		}
		return false;
	}
	public static void setTreeMenu(HttpSession session, MCategory category, String userid) {
		session.setAttribute("treeMenu" + userid, category);
	}
	public static MCategory getTreeMenu(HttpSession session, String userid) {
		return (MCategory) session.getAttribute("treeMenu" + userid);
	}
	public static List<String> getEqualLowLevelCategotyCodeList(MCategory category, String code) {
		
		MCategory equalLowLevelCategory = searchMCategoryByCode(category, code);
		
		if (equalLowLevelCategory == null) {
			return null;
		}
		
		return getCategoryCode(equalLowLevelCategory);
	}
 	
	private static List<String> getCategoryCode(MCategory category) {
		List<String> codeList = new ArrayList<String>();
		codeList.add(category.getCateCode());
		Iterator<MCategory> it = category.getChildCategory().iterator();
		while (it.hasNext()) {
			MCategory subCategory = it.next();
			codeList.addAll(getCategoryCode(subCategory));
		}
		return codeList;
		
	}
	
	private static MCategory searchMCategoryByCode(MCategory category, String code) {
		
		if (category.getCateCode().equals(code)) {
			return category;
		}
		Iterator<MCategory> it = category.getChildCategory().iterator();
		while (it.hasNext()) {
			MCategory subCategory = it.next();
			MCategory searchCategory = searchMCategoryByCode(subCategory, code);
			if (searchCategory != null) {
				return searchCategory;
			}
		}
		return null;
		
	}
	
	/**
	 * addGroup
	 */
	public static boolean insertCategoryToObject(MCategory category, String oyaCode, String cateCode, String cateName, boolean openCloseSign) {
		if (category.getCateCode().equals(oyaCode)) {
			category.setOpenClose(openCloseSign);
			category.addCategory(new MCategory(cateName, cateCode));
			return true;
		} else {
			Iterator<MCategory> it = category.getChildCategory().iterator();
			while (it.hasNext()) {
				MCategory subCategory = it.next();
				if (insertCategoryToObject(subCategory, oyaCode, cateCode, cateName, openCloseSign)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * delCategory
	 */
	public static boolean removeCategoryToObject(MCategory category, String cateCode) {
	
		Iterator<MCategory> it = category.getChildCategory().iterator();
		for (int i = 0; i < category.getChildCategory().size(); i++) {
			MCategory subCategory = it.next();
			if (subCategory.getCateCode().equals(cateCode)) {
				category.getChildCategory().remove(i);
				return true;
			} else {
				if (removeCategoryToObject(subCategory, cateCode)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * updateCategory
	 */
	public static boolean updateCategoryToObject(MCategory category, String cateCode, String cateName) {
	
		if (category.getCateCode().equals(cateCode)) {
			category.setName(cateName);
			return true;
		} else {
			Iterator<MCategory> it = category.getChildCategory().iterator();
			while (it.hasNext()) {
				MCategory subCategory = it.next();
				if (updateCategoryToObject(subCategory, cateCode, cateName)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param userid
	 * @return Category
	 * @throws SysException
	 */
	public static MCategory createTreeCategory(String userid) throws SysException {
		
		MCategory rootCategory = null;
		
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean first = true;
		try {
			
			con = DBConnectionMgr.getInstance().getConnection();
			//Category����
			//String subSearchSql = "select * from t_category AS CATE left join t_bookmark AS BOOK on CATE.code= BOOK.code where CATE.user_id=? order by CATE.level, CATE.orderNo";
			String categorySearchSql = "select * from M_category where user_id=? order by level, orderNo";
			pstmt = new LogPreparedStatement(con, categorySearchSql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//�e�R�[�h
				String oyaCode = rs.getString("oya_code");
				//�V�R�[�h
				String code = rs.getString("code");
				//�V�R�[�h��
				String name = rs.getString("name");
				
				if (first) {
					rootCategory = new MCategory(name, code);
					rootCategory.rootSet();
					first = false;
				} else {
					insertCategoryToObject(rootCategory, oyaCode, code, name, false);
				}
			}
			
			
		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
		
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return rootCategory;
	}
	
	/**
	 * oyacode����Category��}���
	 * @param userid
	 * @param oyacode
	 * @param name
	 * @throws SysException 
	 * @throws SysException
	 */
	public static void insertNewCategory(String userid, String code, String name) throws SysException {
		
		Connection con = null;
		LogPreparedStatement pstmt = null;

		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into M_category (user_id, code , name, level, orderNo) ");
			sql.append("values");
			sql.append("(?, ?, ?, ?, ?)");
			
			
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, code);
			pstmt.setString(3, name);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 1);
		
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("insertCategory" + pstmt.getQueryString());
			if (result == 1) {
	
				//return true;
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0020", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

	}
	
	/**
	 * oyacode����Category��}���
	 * @param userid
	 * @param oyacode
	 * @param name
	 * @throws SysException 
	 * @throws SysException
	 */
	public static String insertCategory(String userid, String oyacode, String name) throws SysException {
		
		Connection con = null;
		LogPreparedStatement pstmt = null;
		Integer level = null;
		String newCode = null;
		String orderNo = null;
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into M_category (user_id, code , name, level, orderNo, oya_code) ");
			sql.append("values");
			sql.append("(?, ?, ?, ?, ?, ?)");
			
			level = getCodeLevel(con, oyacode, userid);
			newCode = generateCode(con, userid);
			orderNo = getOrderNo(con, oyacode, userid);
			
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, newCode);
			pstmt.setString(3, name);
			pstmt.setString(4, level.toString());
			pstmt.setString(5, orderNo);
			pstmt.setString(6, oyacode);
		
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("insertCategory" + pstmt.getQueryString());
			if (result == 1) {
	
				//return true;
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0020", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return newCode;

	}
	
	/**
	 * 
	 * @param userid
	 * @param code
	 * @throws SysException 
	 */
	public static void removeCategory(Connection con, String userid, String code) throws SysException {
		
		LogPreparedStatement pstmt = null;
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from M_category where user_id = ? and code = ?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, code);
		
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("insertCategory" + pstmt.getQueryString());
			if (result == 1) {
	
				//return true;
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0020", e);
				}
			
		}
	}
	
	/**
	 * 
	 * @param userid
	 * @param code
	 * @param name
	 * @throws SysException 
	 */
	public static String getCategoryName(String userid, String code) throws SysException {
		
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from M_category where user_id=? and code=?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, code);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("insertCategory " + pstmt.getQueryString());
			while (rs.next()) {
				//�R�[�h��
				name = rs.getString("name");
				
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return name;
		
	}
	
	
	
	/**
	 * 
	 * @param userid
	 * @param code
	 * @param name
	 * @throws SysException 
	 */
	public static void updateCategory(String userid, String code, String name) throws SysException {
		
		Connection con = null;
		LogPreparedStatement pstmt = null;
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update M_category set name = ? where code = ? and user_id = ?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, code);
			pstmt.setString(3, userid);
		
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("insertCategory" + pstmt.getQueryString());
			if (result == 1) {
	
				//return true;
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0020", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		
	}
	
	
	private static Integer getCodeLevel(Connection con, String oyaCode, String userid) throws SysException {
		
		ResultSet rs = null;
		LogPreparedStatement pstmt = null;
		int level = 1;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select level + 1 from ");
			sql.append("M_category where user_id = ? and code = ?");
			pstmt = new LogPreparedStatement(con, sql.toString());

			pstmt.setString(1, userid);
			pstmt.setString(2, oyaCode);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("generateCode" + pstmt.getQueryString());
			
			if (rs.next()) {
				
				level = rs.getInt(1);
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0020", e);
				}
		}
		
		return new Integer(level);
	}
	
	private static String generateCode(Connection con, String userid) throws SysException {
		
		ResultSet rs = null;
		LogPreparedStatement pstmt = null;
		//Default
		int newCode = 0;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select max(code) + 1 from M_category where user_id = ?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("generateCode" + pstmt.getQueryString());
			
			if (rs.next()) {
				//�V�������[�t�̏ꍇ
				newCode = rs.getInt(1);
				if (newCode == 0) {
					newCode = 1;
				}
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0020", e);
				}
			
		}
		
		return codeFormat(String.valueOf(newCode), 4);
		
	}
	
	private static String getOrderNo(Connection con, String oyaCode, String userid) throws SysException {
		
		ResultSet rs = null;
		LogPreparedStatement pstmt = null;
		//Default
		String newCode = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select max(orderNo) + 1 from M_category where user_id = ? and oya_code = ?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, oyaCode);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("generateCode" + pstmt.getQueryString());
			
			if (rs.next()) {
				
				newCode = rs.getString(1);
				//�V�������[�t�̏ꍇ
				if (Util.isEmpty(newCode)) {
					newCode = "1";
				}
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0020", e);
				}
			
		}
		
		return newCode;
		
	}
	/**
	 * 
	 * @param code
	 * @param n
	 * @return
	 */
	private static String codeFormat(String code, int n) {
		
		StringBuffer sb = new StringBuffer();
		
		int addCharSu = n - code.length();
		
		for (int i = 0; i < addCharSu; i++) {
			sb.append("0");
		}
		sb.append(code);
		
		
		return sb.toString();
	}
	
}

package common.category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class CategoryUtil {
	
	public static void main(String[] args) throws SysException, AppException {
		Connection con = DBConnectionMgr.getInstance().getConnection();
//		getCodeLevel(con, "9999");
//		generateCode(con);
	}
	/**
	 * 
	 * @param category
	 * @param selectedCode
	 * @return
	 */
	public static String makeHtmlForManager(Category category, String selectedCode) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<ul>\n");
		if (category.getChildCategory().size() == 0 && category.getChildBookmark().size() == 0) {
			if (selectedCode.equals(category.getCateCode())) {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=noneselect " + "onclick='categoryClick(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			} else {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=none " + "onclick='categoryClick(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			}
			
		}else if (category.isOpen()) {
			if (selectedCode.equals(category.getCateCode())) {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=minusselect " + "onclick='categoryClick(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			} else {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=minus " + "onclick='categoryClick(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			}
			
		} else {
			if (selectedCode.equals(category.getCateCode())) {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=plusselect " + "onclick='categoryClick(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			} else {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=plus " + "onclick='categoryClick(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			}
		}
		buffer.append(category.getName() + "\n");
		buffer.append("</span>");
		buffer.append("<ul>\n");
		if (category.isOpen()) {
			for (Iterator it = category.getChildCategory().iterator(); it.hasNext();) {
				Category cate = (Category) it.next();
				buffer.append(makeHtmlForManager(cate, selectedCode)) ;
			}
			for (Iterator it = category.getChildBookmark().iterator(); it.hasNext();) {
				BookMark bookMark = (BookMark) it.next();
				if (selectedCode.equals(bookMark.getId())) {
					buffer.append("<li> <span title = 'bookmark' id ='" + bookMark.getId() + "' class=bookmarkselect " + "onclick='bookMarkClick(\"" + bookMark.getId() +"\",\"" + bookMark.getUrl() + "\")'"  + ">"+ bookMark.getTitle() + "</span>" + "</li>\n");
				} else {
					//buffer.append("<li> <span title = 'bookmark' id ='" + bookMark.getId() + "' class=bookmark " + "onclick='bookMarkClick(\"" + bookMark.getId() +"\",\"" + bookMark.getUrl() + "\")'"  + ">"+ bookMark.getTitle() + "</span>" + "</li>\n") ;
					//buffer.append("<li> <span title = 'bookmark' id ='" + bookMark.getId() + "' class=bookmark " + "onclick='bookMarkClick(\"" + bookMark.getId() +"\",\"" + bookMark.getUrl() + "\")'"  + ">"+ bookMark.getTitle() + "</span>" + "</li>\n") ;
					buffer.append("<li> <span title = 'bookmark' id ='" + bookMark.getId() + "' class=bookmark><a href=\"javascript:bookMarkClick('" + bookMark.getId() + "','" + bookMark.getUrl() + "')\">" + bookMark.getTitle() + "</a></span></li>\n");
				}
			}
		}
		buffer.append("</ul>\n");
		buffer.append("</li>\n");
		//}
		buffer.append("</ul>\n");
		return buffer.toString();
		
		
		//return compo.makeHtml();
	}
	/**
	 * 
	 * @param category
	 * @param selectedCode
	 * @return
	 */
	public static String makeHtmlForBookMark(Category category, String selectedCode) {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<ul>\n");
		if (category.getChildCategory().size() == 0 && category.getChildBookmark().size() == 0) {
			if (selectedCode.equals(category.getCateCode())) {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=noneselect " + "onclick='select(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			} else {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=none " + "onclick='select(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			}
			
		}else if (category.isOpen()) {
			if (selectedCode.equals(category.getCateCode())) {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=minusselect " + "onclick='select(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			} else {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=minus " + "onclick='select(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			}
			
		} else {
			if (selectedCode.equals(category.getCateCode())) {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=plusselect " + "onclick='select(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			} else {
				buffer.append("<li> <span id ='" + category.getCateCode() + "' class=plus " + "onclick='select(\"" + category.getCateCode()  + "\")'"  + ">" + "\n");
			}
		}
		buffer.append(category.getName() + "\n");
		buffer.append("</span>");
		buffer.append("<ul>\n");
		if (category.isOpen()) {
			for (Iterator it = category.getChildCategory().iterator(); it.hasNext();) {
				Category cate = (Category) it.next();
				buffer.append(makeHtmlForBookMark(cate, selectedCode)) ;
			}
			for (Iterator it = category.getChildBookmark().iterator(); it.hasNext();) {
				BookMark bookMark = (BookMark) it.next();
				if (selectedCode.equals(bookMark.getId())) {
					buffer.append("<li> <span title = 'bookmark' id ='" + bookMark.getId() + "' class=bookmarkselect>" + bookMark.getTitle() + "</span>" + "</li>\n") ;
				} else {
					//buffer.append("<li> <span title = 'bookmark' id ='" + bookMark.getId() + "' class=bookmark><a href=\"javascript:bookMark('" + bookMark.getUrl() + "');\">" + bookMark.getTitle() + "</a></span></li>\n") ;
					buffer.append("<li> <span title = 'bookmark' id ='" + bookMark.getId() + "' class=bookmark><a href=\"javascript:bookmark('" + bookMark.getUrl() + "')\">" + bookMark.getTitle() + "</a></span></li>\n");
				}
			}
		}
		buffer.append("</ul>\n");
		buffer.append("</li>\n");
		//}
		buffer.append("</ul>\n");
		return buffer.toString();
		
		
		//return compo.makeHtml();
	}
	public static boolean onclickCategory(Category category, String code) {
		
		if (category.getCateCode().equals(code)) {
			if (category.isOpen()) {
				category.setOpenClose(false);
			} else {
				category.setOpenClose(true);
			}
			return true;
		}
		Iterator it = category.getChildCategory().iterator();
		while (it.hasNext()) {
			Category subCategory = (Category) it.next();
			if (onclickCategory(subCategory, code)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * addGroup
	 */
	public static boolean insertCategoryToObject(Category category, String oyaCode, String cateCode, String cateName, boolean openCloseSign) {
		if (category.getCateCode().equals(oyaCode)) {
			category.setOpenClose(openCloseSign);
			category.addCategory(new Category(cateName, cateCode));
			return true;
		} else {
			Iterator it = category.getChildCategory().iterator();
			while (it.hasNext()) {
				Category subCategory = (Category) it.next();
				if (insertCategoryToObject(subCategory, oyaCode, cateCode, cateName, openCloseSign)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * addItem
	 */
	public static boolean insertBookMarkToObject(Category category, String oyaCode, String id, String title, String url, String detail) {
		if (category.getCateCode().equals(oyaCode)) {
			category.addBookMark(new BookMark(id, title, url, detail));
			return true;
		} else {
			Iterator it = category.getChildCategory().iterator();
			while (it.hasNext()) {
				Category subCategory = (Category) it.next();
				if (insertBookMarkToObject(subCategory, oyaCode, id, title, url, detail)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	/**
	 * delCategory
	 */
	public static boolean removeCategoryToObject(Category category, String cateCode) {
	
		Iterator it = category.getChildCategory().iterator();
		for (int i = 0; i < category.getChildCategory().size(); i++) {
			Category subCategory = (Category) it.next();
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
	 * delBookMark
	 */
	public static boolean removeBookMarkToObject(Category category, String id) {
		
		Iterator childBookmark = category.getChildBookmark().iterator();
		for (int i = 0; i < category.getChildBookmark().size(); i++) {
			BookMark bookMark = (BookMark) childBookmark.next();
			if (bookMark.getId().equals(id)) {
				category.getChildBookmark().remove(i);
				return true;
			}
		}
		Iterator childCategory = category.getChildCategory().iterator();
		for (int i = 0; i < category.getChildCategory().size(); i++) {
			Category subCategory = (Category) childCategory.next();
			if (removeBookMarkToObject(subCategory, id)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * updateCategory
	 */
	public static boolean updateCategoryToObject(Category category, String cateCode, String cateName) {
	
		if (category.getCateCode().equals(cateCode)) {
			category.setName(cateName);
			return true;
		} else {
			Iterator it = category.getChildCategory().iterator();
			while (it.hasNext()) {
				Category subCategory = (Category) it.next();
				if (updateCategoryToObject(subCategory, cateCode, cateName)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * delBookMark
	 */
	public static boolean updateBookMarkToObject(Category category, String id, String title, String url, String detail) {
		Iterator childBookmark = category.getChildBookmark().iterator();
		while (childBookmark.hasNext()) {
			BookMark bookMark = (BookMark) childBookmark.next();
			if (bookMark.getId().equals(id)) {
				bookMark.setTitle(title);
				bookMark.setUrl(url);
				bookMark.setDetail(detail);
				return true;
			}
		}
		Iterator childCategory = category.getChildCategory().iterator();
		while (childCategory.hasNext()) {
			Category subCategory = (Category) childCategory.next();
			if (updateBookMarkToObject(subCategory, id, title, url, detail)) {
				return true;
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
	public static Category createTreeCategory(String userid) throws SysException {
		
		Category rootCategory = null;
		
		Connection con = null;
		LogPreparedStatement pstmt1 = null;
		LogPreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try {
			
			rootCategory = new Category("root", "0000");
			con = DBConnectionMgr.getInstance().getConnection();
			//Category発見
			//String subSearchSql = "select * from t_category AS CATE left join t_bookmark AS BOOK on CATE.code= BOOK.code where CATE.user_id=? order by CATE.level, CATE.orderNo";
			String categorySearchSql = "select * from t_category where user_id=? order by level, orderNo";
			String bookmarkSearchSql = "select * from t_bookmark where user_id=? ";
			pstmt1 = new LogPreparedStatement(con, categorySearchSql);
			pstmt2 = new LogPreparedStatement(con, bookmarkSearchSql);
			pstmt1.setString(1, userid);
			pstmt2.setString(1, userid);
			rs1 = pstmt1.executeQuery();
			rs2 = pstmt2.executeQuery();
			while (rs1.next()) {
				//親コード
				String oyaCode = rs1.getString("oya_code");
				//新コード
				String newCode = rs1.getString("code");
				//新コード名
				String newName = rs1.getString("name");
				insertCategoryToObject(rootCategory, oyaCode, newCode, newName, false);
			}
			while (rs2.next()) {
				//ID
				String id = rs2.getString("id");
				//コード
				String oyacode = rs2.getString("code");
				//タイトル
				String title = rs2.getString("title");
				//url
				String url = rs2.getString("url");
				//詳細
				String detail = rs2.getString("detail");
				insertBookMarkToObject(rootCategory, oyacode, id, title, url, detail);
			}
			rootCategory.rootSet();
		} catch (SQLException e) {
			throw new SysException("SYE0031", e);

		} catch (Exception e) {
			throw new SysException("SYE0031", e);

		} finally {
			if (rs1 != null) {
				try {
					rs1.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (rs2 != null) {
				try {
					rs1.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt2 != null) {
				try {
					pstmt1.close();
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
	 * oyacode下にCategoryを挿入する
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
			sql.append("insert into t_category (user_id, code , name, level, orderNo, oya_code) ");
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
	 * @param cateCode
	 * @param title
	 * @param url
	 * @param detail
	 * @throws SysException 
	 */
	public static String insertBookMark(String userid, String oyaCode, String title, String url, String detail) throws SysException {
		
		String id = null;  
		Connection con = null;
		ResultSet rs = null;
		LogPreparedStatement pstmt1 = null;
		LogPreparedStatement pstmt2 = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sql1 = new StringBuffer();
			StringBuffer sql2 = new StringBuffer();
			
			sql1.append("insert into t_bookmark (user_id, code , title, url, detail) values (?, ?, ?, ?, ?)");
			sql2.append("select max(id) from t_bookmark where user_id = ? and code = ?");
			pstmt1 = new LogPreparedStatement(con, sql1.toString());
			pstmt2 = new LogPreparedStatement(con, sql2.toString());
			pstmt1.setString(1, userid);
			pstmt1.setString(2, oyaCode);
			pstmt1.setString(3, title);
			pstmt1.setString(4, url);
			pstmt1.setString(5, detail);
			pstmt2.setString(1, userid);
			pstmt2.setString(2, oyaCode);
		
			pstmt1.executeUpdate();
			KankokujinLogger.getInstance().debug("insertCategory" + pstmt1.getQueryString());
			rs = pstmt2.executeQuery();
			if (rs.next()) {
				id = rs.getString(1);
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
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (pstmt2 != null) {
				try {
					pstmt1.close();
				} catch (SQLException e) {
					throw new SysException("SYE0031", e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return id;
	}
	
	
	/**
	 * 
	 * @param userid
	 * @param code
	 * @throws SysException 
	 */
	public static void removeCategory(String userid, String code) throws SysException {
		
		Connection con = null;
		LogPreparedStatement pstmt = null;
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from t_category where user_id = ? and code = ?");
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
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
	}
	/**
	 * 
	 * @param id
	 * @throws SysException 
	 */
	public static void removeBookMark(String id) throws SysException {
		
		Connection con = null;
		LogPreparedStatement pstmt = null;
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from t_bookmark where id = ? ");
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setInt(1, Integer.parseInt(id));
			KankokujinLogger.getInstance().debug("insertCategory" + pstmt.getQueryString());
			int result = pstmt.executeUpdate();
			
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
			sql.append("select * from t_category where user_id=? and code=?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, code);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("insertCategory " + pstmt.getQueryString());
			while (rs.next()) {
				//コード名
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
	public static BookMark getBookMarkInfo(String id) throws SysException {
		
		BookMark bookMark = null;
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from t_bookmark where id=?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("getBookMarkInfo " + pstmt.getQueryString());
			while (rs.next()) {
				//タイトル
				String title = rs.getString("title");
				//url
				String url = rs.getString("url");
				//詳細
				String detail = rs.getString("detail");
				bookMark = new BookMark(id, title, url, detail);
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
		return bookMark;
		
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
			sql.append("update t_category set name = ? where code = ? and user_id = ?");
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
	/**
	 * 
	 * @param userid
	 * @param code
	 * @param title
	 * @param url
	 * @param detail
	 * @throws SysException
	 */
	public static void updateBookMark(String code, String title, String url, String detail) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update t_bookmark set title = ?, url = ?, detail = ? where id = ?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, title);
			pstmt.setString(2, url);
			pstmt.setString(3, detail);
			pstmt.setInt(4, Integer.parseInt(code));
		
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
			sql.append("t_category where user_id = ? and code = ?");
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
			sql.append("select max(code) + 1 from t_category where user_id = ?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("generateCode" + pstmt.getQueryString());
			
			if (rs.next()) {
				//新しいリーフの場合
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
			sql.append("select max(orderNo) + 1 from t_category where user_id = ? and oya_code = ?");
			pstmt = new LogPreparedStatement(con, sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, oyaCode);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("generateCode" + pstmt.getQueryString());
			
			if (rs.next()) {
				
				newCode = rs.getString(1);
				//新しいリーフの場合
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

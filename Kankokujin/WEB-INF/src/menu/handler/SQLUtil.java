package menu.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;

import menu.bean.MenuBean;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class SQLUtil {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String userId  = "12345";
		String searchAreaCode1  = "00";
		String searchAreaCode2  = "0000";
		String searchLineCode    = "55555";
		String searchStationCode = "66666";
		String search_dormitoryflg 	   = "1";
		String search_range 	   = "0";
		String search 			   = "a v s b";
		ArrayList<String> andList = new ArrayList<String>();
		ArrayList<String> orList = new ArrayList<String>();

		andList.add(SQLUtil.makeEqualState("deleteflg", "0"));
		//�n��R�[�h�P
		if (!"".equals(searchAreaCode1) && !"00".equals(searchAreaCode1)) {
			andList.add(SQLUtil.makeEqualState("area_code_1", searchAreaCode1));
			//�n��R�[�h�Q
			if (!"".equals(searchAreaCode2) && !"00".equals(searchAreaCode2.substring(2, 4))) {
				andList.add(SQLUtil.makeEqualState("area_code_2", searchAreaCode2));
			}
		}
		//���C���R�[�h�A�w�R�[�h
		if (!"".equals(searchLineCode) && !"00".equals(searchLineCode)) {
			andList.add(SQLUtil.makeEqualState("line_code", searchLineCode));

			if (!Util.isEmpty(searchStationCode) && searchStationCode.length() == 4) {
				if (!"00".equals(searchStationCode.substring(2, 4))) {
					andList.add(SQLUtil.makeEqualState("station_code", searchStationCode));
				}
			}
		}
		//���L��
		if (search_dormitoryflg != null) {
			andList.add(SQLUtil.makeEqualState("dormitoryflg", "1"));
		}
		/** ���[�UID*/
		if(!Util.isEmpty(userId)){
			andList.add(SQLUtil.makeEqualState("userId", userId));
		}
		
		//����ꂪ����ꍇ
		List searchList = SQLUtil.changeSearch(search);
		/** �S�̌��� */
		if ("0".equals(search_range)) {
			orList.add(SQLUtil.makelikeSQL(searchList, "school_name_k"));
			orList.add(SQLUtil.makelikeSQL(searchList, "school_name_j"));
			orList.add(SQLUtil.makelikeSQL(searchList, "feature"));
		/** �w�Z�� */
		} else if ("1".equals(search_range)) {
			orList.add(SQLUtil.makelikeSQL(searchList, "school_name_k"));
			orList.add(SQLUtil.makelikeSQL(searchList, "school_name_j"));
		/** �R� */
		} else if ("2".equals(search_range)) {
			orList.add(SQLUtil.makelikeSQL(searchList, "feature"));		}
		
		andList.add(SQLUtil.getWhereOrSql(orList));
		
		System.out.println(SQLUtil.getWhereSQL(andList));
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	public static ArrayList<MenuBean> resultSetToList(ResultSet rs) throws SQLException {
		
		ResultSetMetaData rsm = rs.getMetaData();
		ArrayList<MenuBean> list = new ArrayList<MenuBean>();
		
		int n = rsm.getColumnCount();
		while (rs.next()) {
			MenuBean bean = new MenuBean();
			for (int i = 1; i <= n; i++) {
				String columnName = rsm.getColumnName(i);
				int type = rsm.getColumnType(i);
				//int�^�C�v(4)�A�����^�C�v(12)�A�e�L�X�g�^�C�v(-1),char(1)�̏ꍇ
				if (type == -5 || type == 4 || type == 12 || type == -1 || type == 1) {
					//System.out.println(rs.getString(columnName));
					bean.put(columnName, rs.getString(columnName));
				}
				//timeStamp�^�C�v(4)�̏ꍇ
				if (type == 93) {
					//System.out.println(rs.getString(columnName));
					bean.put(columnName, rs.getTimestamp(columnName));
				}
			}
			list.add(bean);
			
		}
		return list;
	}
	/**
	 * 
	 * @param sql1
	 * @param menuBean
	 * @return
	 * @throws SysException
	 */
	public static boolean insert(String sql1, SortedMap menuBean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = new LogPreparedStatement(con, sql1);
			Set set = menuBean.keySet();
			Iterator it = set.iterator();
			int count = 0;
			while(it.hasNext()){
				String key = (String) it.next();
				String value = (String)menuBean.get(key);
				//System.out.println("key=" + key + ", value=" + value);
				pstmt.setString(++count, value);
			}
			//System.out.println(pstmt.getQueryString());
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("MenuHandler.insertMenu" + pstmt.getQueryString());
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SysException("SYE0024" , e);
		} catch (Exception e) {
			throw new SysException("SYE0024" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0024" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}
	
	/**
	 * desc��asc�̐���
	 * 
	 * @param request,interpretBean,interpretSortBean,start,num
	 * @return list ����̒l
	 */
	public static ArrayList<MenuBean> select(
			String sql1,
			String sql2,
			PageBean pageBean) throws SysException {

		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//maxCount
		int maxCount = 0;

		ArrayList<MenuBean> list = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			//��ʂɕ\�����鑍�f�[�^����擾
			pstmt = new LogPreparedStatement(con, sql1);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.getSearchStoreListTotal" + pstmt.getQueryString());
			while (rs.next()) {
				maxCount += rs.getInt(1);
			}
			//�y�[�W����
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			//��ʂɕ\�����鑍�f�[�^���X�g��擾
			pstmt = new LogPreparedStatement(con, sql2);
			
			//�p�����^���Q�̏ꍇ
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());

			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.getSearchStoreListTotal" + pstmt.getQueryString());

			//���ʂ㊃X�g�Ɋi�[
			list = resultSetToList(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SysException("SYE0033", e);
			

		} catch (Exception e) {
			throw new SysException("SYE0033", e);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0036", e);
				}
			}			
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0036", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return list;
	}
	
	/**
	 * RoomInfo��INSERT���郁�\�b�h�h
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public static MenuBean selectDetail(String sql1, String sql2,
			String id, boolean updateSign) throws SysException {
		
		Connection con = null;
		LogPreparedStatement pstmt1 = null;
		LogPreparedStatement pstmt2 = null;
		ResultSet rs = null;
		MenuBean resultBean = null;

		try {

			con = DBConnectionMgr.getInstance().getConnection();
			if(updateSign){
				pstmt1 = new LogPreparedStatement(con, sql1);
				pstmt1.setString(1, id);
				int result = pstmt1.executeUpdate();
				KankokujinLogger.getInstance().debug("StoreDetailHandler.getStoreBean" + pstmt1.getQueryString());
				if (result == 1) {
					//return bean;
				}				
			}
			pstmt2 = new LogPreparedStatement(con, sql2);
			pstmt2.setString(1, id);
			rs = pstmt2.executeQuery();
			KankokujinLogger.getInstance().debug("StoreDetailHandler.getStoreBean" + pstmt2.getQueryString());
			
			resultBean = resultSetToList(rs).get(0);
			
		} catch (SQLException e) {
			throw new SysException("SYE0015", e);

		} catch (Exception e) {
			throw new SysException("SYE0015" , e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015", e);
				}
			}
			if (pstmt1 != null)
				try {
					pstmt1.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015" , e);
				}
			if (pstmt2 != null)
				try {
					pstmt2.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015" , e);
				}				
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return resultBean;
	}
	
	/**
	 * 
	 * @param menuBean
	 * @return
	 * @throws SysException
	 */
	public static int update(String sql1, MenuBean menuBean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = new LogPreparedStatement(con, sql1);
			Set set = menuBean.keySet();
			Iterator it = set.iterator();
			int count = 0;
			while(it.hasNext()){
				String key = (String) it.next();
				String value = (String)menuBean.get(key);
				System.out.println("key=" + key + ", value=" + value);
				pstmt.setString(++count, value);
			}
			KankokujinLogger.getInstance().debug("StoreUpdateHandler.updateStoreBean" + pstmt.getQueryString());
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			throw new SysException("SYE0024" , e);
		} catch (Exception e) {
			throw new SysException("SYE0024" , e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0015" , e);
				}	
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return result;

	}
	
	/**
	 * db:house_info��id����n�E�X����폜���郁�\�b�h
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public static boolean delete(String sql, MenuBean bean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = new LogPreparedStatement(con, sql);
			Set set = bean.keySet();	
			Iterator it = set.iterator();	
			int count = 0;	
			while(it.hasNext()){	
				String key = (String) it.next();
				String value = (String) bean.get(key);
				System.out.println("key=" + key + ", value=" + value);
				pstmt.setString(++count, value);
			}	
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("MenuDeleteHandler.deleteStoreInfo" + pstmt.getQueryString());
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			throw new SysException("SYE0014", e);
		} catch (Exception e) {
			throw new SysException("SYE0014", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0014", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}
	
	
	
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	public static String makelikeSQL(Map condition) {
		
		StringBuffer sb = new StringBuffer();
		for (Iterator it = condition.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			sb.append(key);
			sb.append(" like '");
			sb.append(value);
			sb.append("%'");
			sb.append(" or ");
		}
		sb.delete(sb.length() -3, sb.length() - 1);
		
		return  sb.toString();
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	public static String makelikeSQL(List<String> searchList, String column) {
		
		StringBuffer sb = new StringBuffer();
		for (Iterator<String> it = searchList.iterator(); it.hasNext();) {
			String search = it.next();
			sb.append(column);
			sb.append(" like '%");
			sb.append(search);
			sb.append("%'");
			sb.append(" or ");
		}
		sb.delete(sb.length() -3, sb.length() - 1);
		
		return  sb.toString();
	}
	
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	public static String makelikeStartMatchSQL(List searchList, String column) {
		
		StringBuffer sb = new StringBuffer();
		for (Iterator it = searchList.iterator(); it.hasNext();) {
			String search = (String) it.next();
			sb.append(column);
			sb.append(" like '");
			sb.append(search);
			sb.append("%'");
			sb.append(" or ");
		}
		sb.delete(sb.length() -3, sb.length() - 1);
		
		return  sb.toString();
	}
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public static List<String> changeSearch(String search) {
		List<String> list = new ArrayList<String>();

		StringTokenizer st1 = new StringTokenizer(search, " ");
		while (st1.hasMoreTokens()) {
			changeSearchZenkaku(list, st1.nextToken());
		}

		return list;
	}

	private static void changeSearchZenkaku(List<String> list, String input) {
		StringTokenizer st2 = new StringTokenizer(input, " ");
		while (st2.hasMoreTokens()) {
			list.add(st2.nextToken());
		}
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	public static String getWhereSQL(List<String> list) {
		Iterator<String> it = list.iterator();
		StringBuffer sb = new StringBuffer();
		
		if (list.size() > 0) {
			sb.append(" where ");
		}
		boolean isNotFirst = false;
		while (it.hasNext()) {
			if (isNotFirst) {
				sb.append(" and ");
			}
			isNotFirst = true;
			sb.append(it.next());
			sb.append(" ");

		}
		return sb.toString();

	}
	
	public static String getWhereOrSql(List<String> list) {
		Iterator<String> it = list.iterator();
		StringBuffer sb = new StringBuffer();

		if (list.size() > 0) {
			sb.append(" (");
		}
		boolean isNotFirst = false;
		while (it.hasNext()) {
			if (isNotFirst) {
				sb.append(" or ");
			}			
			isNotFirst = true;
			sb.append((String) it.next());
			sb.append(" ");

		}
		if (list.size() > 0) {
			sb.append(") ");
		}
		return sb.toString();

	}
	/**
	 * 
	 * @param search
	 * @return
	 */
	public static String makeEqualState(String column, String value) {
		StringBuffer sb = new StringBuffer();
		sb.append(column);
		sb.append("=");
		sb.append(value);
		return sb.toString();
	}
	/**
	 * 
	 * @param search
	 * @return
	 */
	public static String makeEqualStateForChar(String column, String value) {
		StringBuffer sb = new StringBuffer();
		sb.append(column);
		sb.append("=");
		sb.append("'");
		sb.append(value);
		sb.append("'");
		return sb.toString();
	}
	
	public static String makeINStateForChar(String column, List<String> list) {
		StringBuffer sb = new StringBuffer();
		sb.append(column);
		sb.append(" IN(");
		for (String val : list) {
			sb.append("'");
			sb.append(val);
			sb.append("'");
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		
		sb.append(") ");
		return sb.toString();
	}
	
	/**
	 * 
	 * @param column,value:0(DESC)�Avalue:1(ASC)
	 * @return
	 */
	public static String makeOrderBy(String column, int sortSign) {
		StringBuffer sb = new StringBuffer();
		sb.append(" ");
		sb.append(column);
		sb.append(" ");
		if (sortSign == 0) {
			sb.append("DESC ");
		}
		if (sortSign == 1) {
			sb.append("ASC ");
		}
		return sb.toString();
	}
	
	
}

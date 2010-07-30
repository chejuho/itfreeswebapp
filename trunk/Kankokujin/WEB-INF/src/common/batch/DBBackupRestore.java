package common.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.database.DBConnectionMgr;
import common.util.Util;

public class DBBackupRestore {
	public List getTables(String db_name) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBConnectionMgr.getInstance().getConnection();			
			StringBuffer sb = new StringBuffer();
			sb.append("show tables");
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(rs.getString(1));
			}

		} catch (Exception e) {
			throw e;

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw e;
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw e;
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}		
		return list;
	}
	public List getColumnNames(String table_name) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBConnectionMgr.getInstance().getConnection();			
			StringBuffer sb = new StringBuffer();
			sb.append("show columns from ");
			sb.append(table_name);
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(rs.getString(1));
			}

		} catch (Exception e) {
			throw e;

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw e;
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw e;
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}		
		return list;
	}
	
	public List getTableValues(String table_name, List column_names) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<List> list = new ArrayList<List>();
		try {
			con = DBConnectionMgr.getInstance().getConnection();			
			StringBuffer sb = new StringBuffer();
			sb.append("select * from ");
			sb.append(table_name);
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				List valueList = new ArrayList();
				Iterator it = column_names.iterator();
				while(it.hasNext()){
					valueList.add(Util.changeNullStr(rs.getString((String)it.next())));
				}
				list.add(valueList);
			}

		} catch (SQLException e) {
			throw e;

		} catch (Exception e) {
			throw e;

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw e;
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw e;
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}		
		return list;
	}
}

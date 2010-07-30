package member.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.bean.MemberBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class MemberFindInfoHandler {

	public boolean isExistIdMail(String id, String mail1, String mail2)
			throws SysException {
		int count = 0;
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "select count(*) from member where user_id=? and email1=? and email2=?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, id);
			pstmt.setString(2, mail1);
			pstmt.setString(3, mail2);
			
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.isExistIdMail" + pstmt.getQueryString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			if (count != 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new SysException(
					"SYE0006", e);
		} catch (Exception e) {
			throw new SysException(
					"SYE0006", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException(
							"SYE0006",
							e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}

	public String isExistId(String username, String mail1, String mail2) throws SysException {
		String user_id = "";
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "select user_id from member where name=? and email1=? and email2=?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, username);
			pstmt.setString(2, mail1);
			pstmt.setString(3, mail2);			
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.isExistId" + pstmt.getQueryString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user_id = rs.getString("user_id");
			}
		} catch (SQLException e) {
			throw new SysException(
					"SYE0004", e);
		} catch (Exception e) {
			throw new SysException(
					"SYE0004", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException(
							"SYE0004",
							e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return user_id;
	}

	public boolean isExistId(String id) throws SysException {
		int count = 0;
		LogPreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "select count(*) from member where user_id=?";
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
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}

	public boolean reSetMemberInfo(MemberBean bean) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "update member set tmppassword=?, email1=?, email2=? where user_id=?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, Util.password(bean.getPassword()));
			pstmt.setString(2, bean.getEmail1());
			pstmt.setString(3, bean.getEmail2());
			pstmt.setString(4, bean.getUserid());
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.reSetMemberInfo" + pstmt.getQueryString());
			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			throw new AppException(
					"MemberFindInfoHandler.reSetMemberInfo.SQLException", e);
		} catch (Exception e) {
			throw new AppException(
					"MemberFindInfoHandler.reSetMemberInfo.Exception", e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException(
							"MemberFindInfoHandler.reSetMemberInfo.SQLException",
							e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;

	}

}

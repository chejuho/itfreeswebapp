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
import common.util.EnDecoding;
import common.util.Util;

public class MemberLoginHandler {

	/**
	 * Member��id/password *
	 * 
	 * @return void
	 * @throws AppException
	 */
	public boolean loginPro(String id, String pw) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "select password from member where user_id=? and registflg = 1 and deleteflg=0";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberLoginHandler.loginPro" + pstmt.getQueryString());
			if (rs.next()) {
				if (rs.getString("password").equals(Util.password(pw))) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = false;
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
		return result;
	}

	public MemberBean getMemberInfo(String id) throws SysException {
		MemberBean bean = new MemberBean();
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "select * from member where user_id=? and deleteflg=0";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberLoginHandler.getMemberInfo" + pstmt.getQueryString());
			while (rs.next()) {

				bean.setUserid(Util.changeNullStr(rs.getString("user_id")));
				bean.setEmail1(Util.changeNullStr(rs.getString("email1")));
				bean.setEmail2(Util.changeNullStr(rs.getString("email2")));
				bean.setName(Util.changeNullStr(rs.getString("name")));
				bean.setAddress(rs.getString("address"));
				bean.setTelephone1(Util.changeNullStr(rs.getString("telephone1")));
				bean.setTelephone2(Util.changeNullStr(rs.getString("telephone2")));
				bean.setTelephone3(Util.changeNullStr(rs.getString("telephone3")));
				bean.setMobile1(Util.changeNullStr(rs.getString("mobile1")));
				bean.setMobile2(Util.changeNullStr(rs.getString("mobile2")));
				bean.setMobile3(Util.changeNullStr(rs.getString("mobile3")));
				bean.setRegistflg(Util.changeNullStr(rs.getString("registflg")));
				bean.setUser_level(Util.changeNullStr(rs.getString("user_level")));

			}

		} catch (SQLException e) {
			throw new SysException(
					"SYE0003", e);
		} catch (Exception e) {
			throw new SysException(
					"SYE0003", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new SysException(
						"SYE0003", e);
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}
}

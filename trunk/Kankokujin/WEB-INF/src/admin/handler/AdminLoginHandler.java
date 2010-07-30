package admin.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.bean.MemberBean;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;

public class AdminLoginHandler {

	/**
	 * Member‚Ìid/password *
	 * 
	 * @return void
	 * @throws AppException
	 */
	public boolean loginPro(String id, String pw) throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "select password from member where user_id=? and user_level=9";
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug(
					"loginPro sql =" + sql + ", id=" + id + ", pw=" + pw);
			if (rs.next()) {
				if (rs.getString("password").equals(pw)) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = false;
			}
		} catch (SQLException e) {
			throw new AppException("MemberLoginHandler.loginPro.SQLException",
					e);
		} catch (Exception e) {
			throw new AppException("MemberLoginHandler.loginPro.Exception", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new AppException(
						"MemberLoginHandler.loginPro.SQLException", e);
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return result;
	}

	public MemberBean getMemberInfo(String id) throws AppException {
		MemberBean bean = new MemberBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "select * from member where user_id=? and deleteflg=0";
			pstmt = con.prepareStatement(strSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				bean.setUserid(rs.getString("user_id"));
				bean.setEmail1(rs.getString("email1"));
				bean.setEmail2(rs.getString("email2"));
				bean.setName(rs.getString("name"));
				bean.setAddress(rs.getString("address"));
				bean.setTelephone1(rs.getString("telephone1"));
				bean.setTelephone2(rs.getString("telephone2"));
				bean.setTelephone3(rs.getString("telephone3"));
				bean.setMobile1(rs.getString("mobile1"));
				bean.setMobile2(rs.getString("mobile2"));
				bean.setMobile3(rs.getString("mobile3"));
				bean.setRegistflg(rs.getString("registflg"));
				bean.setUser_level(rs.getString("user_level"));

			}

		} catch (SQLException e) {
			throw new AppException(
					"MemberLoginHandler.getMemberInfo.SQLException", e);
		} catch (Exception e) {
			throw new AppException(
					"MemberLoginHandler.getMemberInfo.Exception", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				
			} catch (SQLException e) {
				throw new AppException(
						"MemberLoginHandler.getMemberInfo.SQLException", e);
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return bean;

	}

}

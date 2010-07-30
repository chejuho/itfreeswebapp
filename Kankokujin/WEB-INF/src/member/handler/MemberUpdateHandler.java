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

public class MemberUpdateHandler {
	public boolean updateMemberBean(MemberBean bean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("update member set password=?, name=?, ");
			sb.append(" telephone1=?, telephone2=?, telephone3=?, " );
			sb.append(" mobile1=?, mobile2=?,mobile3=?, address=? where user_id=? " );
			pstmt = new LogPreparedStatement(con, sb.toString());
			if(Util.isEmpty(bean.getNewPassword())){
				pstmt.setString(1, Util.password(bean.getPassword()));
			} else {
				pstmt.setString(1, Util.password(bean.getNewPassword()));
			}
			pstmt.setString(2, EnDecoding.decoding(bean.getName()));
			pstmt.setString(3, bean.getTelephone1());
			pstmt.setString(4, bean.getTelephone2());
			pstmt.setString(5, bean.getTelephone3());
			pstmt.setString(6, bean.getMobile1());
			pstmt.setString(7, bean.getMobile2());
			pstmt.setString(8, bean.getMobile3());
			pstmt.setString(9, bean.getAddress());	
			pstmt.setString(10, bean.getUserid());
			
			KankokujinLogger.getInstance().debug("MemberUpdateHandler.updateMemberBean sql =" + pstmt.getQueryString());
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				return true;
			}

		} catch (SQLException e) {
			throw new SysException("SYE0011" , e);
		} catch (Exception e) {
			throw new SysException("SYE0011" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0011" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;

	}
	
	public boolean updateNewPW(MemberBean bean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql= "update member set password=?, tmppassword=? where user_id=?";
			pstmt = new LogPreparedStatement(con, strSql);

			pstmt.setString(1, Util.password(bean.getNewPassword()));
			pstmt.setString(2, "");
			pstmt.setString(3, bean.getUserid());
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("MemberUpdateHandler.updateNewPW sql =" + pstmt.getQueryString());
			
			if (result == 1) {
				return true;
			}

		} catch (SQLException e) {
			throw new SysException("SYE0008" , e);
		} catch (Exception e) {
			throw new SysException("SYE0008" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0008" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;

	}
	public boolean setMemberRegistFlg(MemberBean bean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql= "update member set registflg=1 where user_id=? and registnum=? and deleteflg=0";
			pstmt = new LogPreparedStatement(con, strSql);

			pstmt.setString(1, bean.getUserid());
			pstmt.setString(2, bean.getRegistnum());
			KankokujinLogger.getInstance().debug("MemberUpdateHandler.setMemberRegistFlg sql=" + pstmt.getQueryString());
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			throw new SysException("SYE0012" , e);
		} catch (Exception e) {
			throw new SysException("SYE0012" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0012" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}
/*	
	public void interpretViewOn(String userid) throws SysException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			KankokujinLogger.getInstance().debug(
					"MemberUpdateHandler.interpretViewOn.start");
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("update interpret_info ");
			sb.append(" set " );	
			sb.append(" viewflg=0 " );
			sb.append(" where user_id=? ");
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setString(1, userid);
			
			KankokujinLogger.getInstance().debug("interpretViewOn sql =" + sb.toString());
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			throw new SysException("SYE0013" , e);
		} catch (Exception e) {
			throw new SysException("SYE0013" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("MemberUpdateHandler.interpretViewOn.SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
	}
*/	
	/**
	 * tmpSign : tmppassword サイン　false:一般パースワード　true：臨時パースワード
	 */
	public boolean pwCheck(MemberBean bean, boolean tmpSign) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		String strSql = null;
		String pwd = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			if (tmpSign) {
				strSql = "select tmppassword as pwd from member where user_id=?";
			} else {
				strSql = "select password as pwd from member where user_id=?";
			}
			
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, bean.getUserid());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberUpdateHandler.pwCheck.sql=" + pstmt.getQueryString());
			
			if (rs.next()) {
				pwd = rs.getString("pwd");
			}
			if (pwd.equals(Util.password(bean.getPassword()))){
				result = true;
			}else{
				result = false;
			}
		} catch (Exception e) {
			throw new SysException("SYE0001" , e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SQLException", e);
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0001" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return result;
	}
}
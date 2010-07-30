package member.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.bean.MemberBean;
import common.constant.Const;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

import email.bean.EmailBean;
import email.handler.SendMailHandler;

public class MemberRegistHandler {

	/**
	 * Member‚ÌINSERT‚·‚é–½—ß
	 * 
	 * @return void
	 */
	public boolean insert(MemberBean bean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "insert into member(user_id,password,email1,email2,"
					+ "name,telephone1,telephone2,telephone3,mobile1,mobile2,mobile3,address,registnum,registflg)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, bean.getUserid());
			pstmt.setString(2, Util.password(bean.getPassword()));
			pstmt.setString(3, bean.getEmail1());
			pstmt.setString(4, bean.getEmail2());
			pstmt.setString(5, EnDecoding.decoding(bean.getName()));
			pstmt.setString(6, bean.getTelephone1());
			pstmt.setString(7, bean.getTelephone2());
			pstmt.setString(8, bean.getTelephone3());
			pstmt.setString(9, bean.getMobile1());
			pstmt.setString(10, bean.getMobile2());
			pstmt.setString(11, bean.getMobile3());
			pstmt.setString(12, bean.getAddress());
			pstmt.setString(13, bean.getRegistnum());
			con.setAutoCommit(false);
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("MemberRegistHandler.insert" + pstmt.getQueryString());
			if (result == 1) {
				EmailBean emailBean = setEmailBean(bean);
				emailBean.setToId(bean.getEmail1() + "@" + bean.getEmail2());
				SendMailHandler sendMailHandler = new SendMailHandler();
				if (sendMailHandler.sendmail(emailBean)) {
					con.commit();
					con.setAutoCommit(true);
					return true;
				} else {
					con.rollback();
					con.setAutoCommit(true);
					return false;
				}
			}
		} catch (SysException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SysException(e.getMessage(), e);			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SysException("SYE0010", e);
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SysException("SYE0010", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0010", e);
					
				}
			if (con != null) {
				
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return false;
	}

	private EmailBean setEmailBean(MemberBean bean) throws AppException, SysException {

		SendMailHandler handler = new SendMailHandler();
		EmailBean emailBean = handler.getEmailInfo("1");

		String subject = emailBean.getSubject();
		String contents = emailBean.getContents();

		subject.replaceAll("\n", "");
		contents = contents.replace("USERID_X", bean.getUserid());
		contents = contents.replace("USERNAME_X", EnDecoding.decoding(bean.getName()));
		//contents = contents.replace("PASSWORD_X", bean.getPassword());
		contents = contents.replace("REGISTNUM_X", bean.getRegistnum());
		contents = contents.replace("SERVER_DOMAIN", Const.SERVER_DOMAIN);

		emailBean.setToId(bean.getUserid());
		emailBean.setFromId(Const.ADMIN_ID);
		emailBean.setSubject(subject);
		emailBean.setContents(contents);
		return emailBean;
	}

	public boolean isExistIdMail(String id, String mail1, String mail2)
			throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			int count = 0;
			con = DBConnectionMgr.getInstance().getConnection();
			
			String strSql = "select count(*) from member where user_id=? or (email1=? and email2=?)";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, id);
			pstmt.setString(2, mail1);
			pstmt.setString(3, mail2);
			ResultSet rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.isExistIdMail" + pstmt.getQueryString());
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
			if (count == 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new SysException(
					"SYE0009", e);
		} catch (Exception e) {
			throw new SysException(
					"SYE0009", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException(
							"SYE0009", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}

	public boolean userMatch(String id, String mail1, String mail2)
			throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			int count = 0;
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "select count(*) from member where user_id=? and email1=? and email2=?";
			pstmt = new LogPreparedStatement(con, strSql);
			pstmt.setString(1, id);
			pstmt.setString(2, mail1);
			pstmt.setString(3, mail2);
			ResultSet rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("MemberFindInfoHandler.userMatch" + pstmt.getQueryString());
			if (rs.next()) {
				count = rs.getInt(1);
			}
			if (count == 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new AppException(
					"MemberRegistHandler.userMatch.SQLException", e);
		} catch (Exception e) {
			throw new AppException(
					"MemberRegistHandler.userMatch.Exception", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}

}

package eigyoumail.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import roomsell.bean.RoomBean;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;

import eigyoumail.bean.EigyoumailBean;
import eigyoumail.bean.EigyoumailListBean;

public class EigyouMailListHandler {
/*	public ArrayList<EigyoumailBean> getSendMailList() throws AppException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		ArrayList<EigyoumailBean> list = new ArrayList<EigyoumailBean>();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			query = "select * from eigyou_email_list ";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				EigyoumailBean eigyoumailBean = new EigyoumailBean();
				eigyoumailBean.setMail_id(rs.getInt("mail_id"));
				eigyoumailBean.setCompany(EnDecoding.decoding(rs.getString("company")));
				eigyoumailBean.setPart_name(EnDecoding.decoding(rs.getString("part_name")));
				eigyoumailBean.setView_to_name(EnDecoding.decoding(rs.getString("view_to_name")));
				eigyoumailBean.setTo_name(EnDecoding.decoding(rs.getString("to_name")));
				eigyoumailBean.setTo_mail(rs.getString("to_mail"));
				eigyoumailBean.setFlag_send(rs.getInt("flag"));
				
				list.add(eigyoumailBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;
	
	}*/	
	public ArrayList<EigyoumailBean> getEigyoumailList() throws AppException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		ArrayList<EigyoumailBean> list = new ArrayList<EigyoumailBean>();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			query = "select * from eigyou_email";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				EigyoumailBean eigyoumailBean = new EigyoumailBean();
				eigyoumailBean.setMail_id(rs.getInt("mail_id"));
				eigyoumailBean.setTitle(EnDecoding.decoding(rs.getString("title")));
				eigyoumailBean.setUpdate_by_user_id(rs.getString("update_by_user_id"));
				eigyoumailBean.setContents(EnDecoding.decoding(rs.getString("contents")));
				
				list.add(eigyoumailBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;
	
	}
	/**
	 * countÇÃèÓïÒÇÇ®ímÇÁÇπÇ∑ÇÈ
	 * @param beanÅ@countÇãyÇ‘
	 * @return count columnIndexÇÃç≈èâÇÃóÒÇintÇ∆ÇµÇƒéÊìæ
	 */
	public int getInfoCount(EigyoumailBean bean) throws AppException {
		KankokujinLogger.getInstance().debug("EigyouMailListHandler.getInfoCount.start");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from eigyou_email");
			//sb.append(getWhereList(bean));
			KankokujinLogger.getInstance().debug("getInfoCount sql=" + sb.toString());
			pstmt = con.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {

				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("Exception" + e);

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			}
		}

		return count;

	}

}
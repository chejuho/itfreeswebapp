package engmail.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;

import engmail.bean.EngmailBean;

public class EngMailListHandler {

	public ArrayList<EngmailBean> getEngmailList() throws AppException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		ArrayList<EngmailBean> list = new ArrayList<EngmailBean>();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			query = "select * from eng_email order by update_date desc";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				EngmailBean engmailBean = new EngmailBean();
				engmailBean.setMail_id(rs.getInt("mail_id"));
				engmailBean.setSubject(EnDecoding.decoding(rs.getString("title")));
				engmailBean.setUpdate_by_user_id(rs.getString("update_by_user_id"));
				engmailBean.setContents(EnDecoding.decoding(rs.getString("contents")));
				engmailBean.setUpdate_date(rs.getString("update_date"));
				
				list.add(engmailBean);
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
	public int getInfoCount(EngmailBean bean) throws AppException {
		KankokujinLogger.getInstance().debug("EngMailListHandler.getInfoCount.start");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from eng_email");
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
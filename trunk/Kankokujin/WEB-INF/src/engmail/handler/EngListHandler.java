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
import engmail.bean.EngmailListBean;

public class EngListHandler {

	public ArrayList<EngmailListBean> getEngList() throws AppException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		ArrayList<EngmailListBean> list = new ArrayList<EngmailListBean>();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			query = "select * from eng_email_list order by initial";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				EngmailListBean engmailListBean = new EngmailListBean();
				engmailListBean.setInitial(EnDecoding.decoding(rs.getString("initial")));
				engmailListBean.setTo_mail(rs.getString("web_mail"));
				engmailListBean.setTo_mobile_mail(rs.getString("mobile_mail"));
				engmailListBean.setTo_name(EnDecoding.decoding(rs.getString("name")));
				engmailListBean.setInsert_date(rs.getString("insert_date"));
				list.add(engmailListBean);
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
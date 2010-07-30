package main.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.bean.ContactusBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.EnDecoding;
import common.util.Util;

public class ContactusListHandler {

	/**
	 * countÇÃèÓïÒÇÇ®ímÇÁÇπÇ∑ÇÈ
	 * 
	 * @param bean
	 *            countÇãyÇ‘
	 * @return count columnIndexÇÃç≈èâÇÃóÒÇintÇ∆ÇµÇƒéÊìæ
	 */
	public int getInfoCount() throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String strSql = "select count(*) from contactus_info";			
			pstmt = new LogPreparedStatement(con, strSql);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("ContactusListHandler.getInfoCount" + pstmt.getQueryString());
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new SysException("SYE0021", e);

		} catch (Exception e) {
			throw new SysException("SYE0021", e);

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new SysException("SYE0021", e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0021" + e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return count;

	}
	/**
	 * descÇ∆ascÇÃêÆóÒ
	 * 
	 * @param request,interpretBean,interpretSortBean,start,num
	 * @return list êÆóÒÇÃíl
	 */
	public ArrayList getContactusList(int start, int num) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList list = new ArrayList();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from contactus_info");
			sb.append(" order by update_date desc limit ?,? ");

			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setInt(1, start - 1);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("ContactusListHandler.getContactusList" + pstmt.getQueryString());
			while (rs.next()) {
				ContactusBean contactusBean = new ContactusBean();
				contactusBean.setId(rs.getString("id"));
				contactusBean.setName(EnDecoding.decoding(rs.getString("name")));
				contactusBean.setEmail(Util.changeNullStr(rs.getString("email")));
				contactusBean.setTel_no1_1(Util.changeNullStr(rs.getString("tel_no1_1")));
				contactusBean.setTel_no1_2(Util.changeNullStr(rs.getString("tel_no1_2")));
				contactusBean.setTel_no1_3(Util.changeNullStr(rs.getString("tel_no1_3")));
				contactusBean.setTel_no2_1(Util.changeNullStr(rs.getString("tel_no2_1")));
				contactusBean.setTel_no2_2(Util.changeNullStr(rs.getString("tel_no2_2")));
				contactusBean.setTel_no2_3(Util.changeNullStr(rs.getString("tel_no2_3")));
				contactusBean.setTitle(EnDecoding.decoding(rs.getString("title")));
				contactusBean.setDetail_info(Util.changeRnToBrTag(EnDecoding.decoding(rs.getString("detail_info"))));
				contactusBean.setUpdate_date(rs.getTimestamp("update_date"));
				list.add(contactusBean);

			}

		} catch (SQLException e) {
			throw new SysException("SYE0033", e);

		} catch (Exception e) {
			throw new SysException("SYE0033", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0033", e);

				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;

	}
}
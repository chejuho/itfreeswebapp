package eigyoumail.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.util.EnDecoding;

import eigyoumail.bean.EigyoumailBean;
import eigyoumail.bean.EigyoumailListBean;

public class EigyouMailSendHandler {
	public ArrayList<EigyoumailListBean> getEigyouMailSendList() throws AppException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		ArrayList<EigyoumailListBean> list = new ArrayList<EigyoumailListBean>();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			query = "select * from eigyou_email_list ";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				EigyoumailListBean sendMailListForm = new EigyoumailListBean();
				sendMailListForm.setMail_id(rs.getInt("mail_id"));
				sendMailListForm.setCompany(EnDecoding.decoding(rs.getString("company")));
				sendMailListForm.setPart_name(EnDecoding.decoding(rs.getString("part_name")));
				sendMailListForm.setView_to_name(EnDecoding.decoding(rs.getString("view_to_name")));
				sendMailListForm.setTo_name(EnDecoding.decoding(rs.getString("to_name")));
				sendMailListForm.setTo_mail(rs.getString("to_mail"));
				sendMailListForm.setFlag_send(rs.getInt("flag"));
				
				list.add(sendMailListForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;
	
	}
	public EigyoumailBean getEigyoumailBean(String mail_id) throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EigyoumailBean bean = null;

		try {
			String query = "select * from eigyou_email where mail_id=?";
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con.prepareStatement(query);
			bean = new EigyoumailBean();

			pstmt.setString(1, mail_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean.setMail_id(rs.getInt("mail_id"));
				bean.setTitle(EnDecoding.decoding(rs.getString("title")));
				bean.setUpdate_by_user_id(EnDecoding.decoding(rs
						.getString("update_by_user_id")));
				bean.setContents(EnDecoding.decoding(rs
						.getString("contents")));
				bean.setInsert_date(rs.getString("insert_date"));
				bean.setUpdate_date(rs.getString("update_date"));
			}

		} catch (Exception e) {
			throw new AppException("getEigyoumailBean exception", e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new AppException("getEigyoumailBean SQLException", e);
			}
		}
		return bean;
	}
}
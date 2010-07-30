package engmail.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.util.EnDecoding;

import engmail.bean.EngmailBean;
import engmail.bean.EngmailListBean;

public class EngMailSendHandler {
	public ArrayList<EngmailListBean> getEngMailSendList() throws AppException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		ArrayList<EngmailListBean> list = new ArrayList<EngmailListBean>();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			query = "select * from eng_email_list ";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				EngmailListBean engmailListBean = new EngmailListBean();
				engmailListBean.setId(rs.getInt("id"));
				engmailListBean.setTo_name(EnDecoding.decoding(rs.getString("name")));
				engmailListBean.setTo_mail(rs.getString("email"));
				
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
	private String removeBrTag(String content){
		content = content.replace("<BR>", "\n");
		content = content.replace("<br>", "\n");
		
		return content;
	}	
	public EngmailBean getEngmailBean(String mail_id) throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EngmailBean bean = null;

		try {
			String query = "select * from eng_email where mail_id=?";
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con.prepareStatement(query);
			bean = new EngmailBean();

			pstmt.setString(1, mail_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean.setMail_id(rs.getInt("mail_id"));
				bean.setSubject(EnDecoding.decoding(rs.getString("title")));
				bean.setUpdate_by_user_id(EnDecoding.decoding(rs.getString("update_by_user_id")));
				bean.setContents(EnDecoding.decoding(removeBrTag(rs.getString("contents"))));
				//bean.setContents(EnDecoding.decoding(rs.getString("contents")));
				System.out.println("content=" + bean.getContents());
				bean.setInsert_date(rs.getString("insert_date"));
				bean.setUpdate_date(rs.getString("update_date"));
			}

		} catch (Exception e) {
			throw new AppException("getEngmailBean exception", e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new AppException("getEngmailBean SQLException", e);
			}
		}
		return bean;
	}	
}
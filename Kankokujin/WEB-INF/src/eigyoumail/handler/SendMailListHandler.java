package eigyoumail.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SendMailListHandler {
//
//	public ArrayList<SendMailListForm> getSendMailList() throws AppException {
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		String query = "";
//		ArrayList<SendMailListForm> list = new ArrayList<SendMailListForm>();
//		try {
//			con = DBConnectionMgr.getInstance().getConnection();
//			stmt = con.createStatement();
//			query = "select * from email_list ";
//			rs = stmt.executeQuery(query);
//
//			while (rs.next()) {
//				SendMailListForm sendMailListForm = new SendMailListForm();
//				sendMailListForm.setMail_id(rs.getInt("mail_id"));
//				sendMailListForm.setCompany(EnDecoding.decoding(rs.getString("company")));
//				sendMailListForm.setPart_name(EnDecoding.decoding(rs.getString("part_name")));
//				sendMailListForm.setView_to_name(EnDecoding.decoding(rs.getString("view_to_name")));
//				sendMailListForm.setTo_name(EnDecoding.decoding(rs.getString("to_name")));
//				sendMailListForm.setTo_mail(rs.getString("to_mail"));
//				sendMailListForm.setFlag_send(rs.getInt("flag"));
//				
//				list.add(sendMailListForm);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
//		} finally {
//			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
//		}
//		return list;
//	
//	}
//	
//	public boolean updateMailList(int mail_id, int flag_send) {
//		Connection con = null;
//		Statement st = null;
//		int result = 0;
//
//		try {
//			con = DBConnectionMgr.getInstance().getConnection();
//			st = con.createStatement();
//
//			String query = "update email_list set flag= "+flag_send+" where mail_id ="+mail_id;
//
//			result = st.executeUpdate(query);
//			System.out.println(query);
//			if (result == 1) {
//				return true;
//			}
//
//		} catch (Exception e) {
//			System.out.println(e);
//			DBConnectionMgr.getInstance().freeConnection(con);
//		} finally {
//			if (st != null) {
//				try {
//					st.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (con != null) {
//				DBConnectionMgr.getInstance().freeConnection(con);
//			}
//		}
//		return false;
//	}
}
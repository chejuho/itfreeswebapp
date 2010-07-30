package engmail.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.database.DBConnectionMgr;

import engmail.bean.EngmailBean;

public class EngMailRegistHandler {



	public boolean insertEng_email(EngmailBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			String query = "insert into eng_email(title, to_mail_list, contents, update_by_user_id,"
					+ " insert_date, update_date)"
					+ " values (?, ?, ?, ?, now(), now())";
			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2, bean.getTo_mail_list());
			pstmt.setString(3, bean.getContents());
			pstmt.setString(4, bean.getUpdate_by_user_id());

			int cnt = pstmt.executeUpdate();

			if (cnt == 1) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("mailInsert failed : " + e);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, pstmt);
		}
		return result;
	}

}

package eigyoumail.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.util.EnDecoding;

import eigyoumail.bean.EigyoumailBean;

public class EigyouMailDetailHandler {

	private String reContent(String content) {
		return addBrTag(" ", "<br>", content);
	}

	private String addBrTag(String first, String brTag, String content) {
		StringBuffer bf = new StringBuffer();
		StringTokenizer st = new StringTokenizer(content, "\n");
		int count = st.countTokens();
		bf.append(first);
		int i = 1;
		while (st.hasMoreTokens()) {
			if (i == count) {
				bf.append(st.nextToken());
			} else {
				bf.append(st.nextToken() + brTag);
			}
			i++;
		}
		return bf.toString();

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
				bean.setContents(EnDecoding.decoding(reContent(rs
						.getString("contents"))));
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

package findjob.handler;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

import findjob.bean.FindjobBean;

public class FindjobRegistHandler {
	private static FindjobRegistHandler instance = null;
	private FindjobRegistHandler(){
		
	}
    public static FindjobRegistHandler getInstance() {
        if (instance == null) {
            synchronized (FindjobRegistHandler.class) {
                if (instance == null) {
                    instance = new FindjobRegistHandler();
                }
            }
        }

        return instance;
    }
	/**
	 * RoomInfoのINSERTするメソッドド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public boolean insertFindjobBean(FindjobBean bean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("insert into findjob_info (user_id, title, tel_no1_1, tel_no1_2, tel_no1_3, ");
			sb.append("tel_no2_1, tel_no2_2, tel_no2_3, email, work_sort,");
			sb.append("birthday, sex, appeal_point, detail_info, regist_date, update_date, read_count)");
			sb.append("values(?, ?, ?, ?, ?,");
			sb.append("?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, now(), now(), 0)");
					
			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, bean.getUser_id());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getTel_no1_1());
			pstmt.setString(4, bean.getTel_no1_2());
			pstmt.setString(5, bean.getTel_no1_3());
			pstmt.setString(6, bean.getTel_no2_1());
			pstmt.setString(7, bean.getTel_no2_2());
			pstmt.setString(8, bean.getTel_no2_3());
			pstmt.setString(9, bean.getEmail());
			pstmt.setString(10, bean.getWork_sort());
			pstmt.setString(11, bean.getBirthday());
			pstmt.setString(12, bean.getSex());
			pstmt.setString(13, bean.getAppeal_point());
			pstmt.setString(14, bean.getDetail_info());
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("FindjobRegistHandler.insertFindjobBean" + pstmt.getQueryString());
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			throw new SysException("SYE0020", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0020", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}
}

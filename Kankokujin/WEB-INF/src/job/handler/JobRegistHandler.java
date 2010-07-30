package job.handler;

import java.sql.Connection;
import java.sql.SQLException;

import job.bean.JobBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.exception.SysException;
import common.logger.KankokujinLogger;

public class JobRegistHandler {
	private static JobRegistHandler instance = null;
	private JobRegistHandler(){
		
	}
    public static JobRegistHandler getInstance() {
        if (instance == null) {
            synchronized (JobRegistHandler.class) {
                if (instance == null) {
                    instance = new JobRegistHandler();
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
	public boolean insertJobBean(JobBean bean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer("insert into job_info (user_id, company_name_k, search_word, tel_no1_1, ");
			sb.append("tel_no1_2, tel_no1_3, tel_no2_1, ");
			sb.append("tel_no2_2, tel_no2_3, fax_no_1, ");
			sb.append("fax_no_2, fax_no_3, email, ");
			sb.append("url, photo_name1, photo_name2, photo_name3, photo_name4, ");
			sb.append("photo_name5, area_code_1, area_code_2, area_code_3, line_code, ");
			sb.append("station_code, area_fast, cate_code_1, cate_code_2,  main_area, ");
			sb.append("appeal_point, detail_info, regist_date, update_date, title, charge, pay, work_time, sex, read_count)");
			sb.append("values");
			sb.append("(?, ?, ?, ?,");
			sb.append("?, ?, ?, ");
			sb.append("?, ?, ?, ");
			sb.append("?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ");
			sb.append("?, ?, ?, now(),  now(), ?, ?, ?, ?, ?, 0)");

			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setString(1, bean.getUser_id());
			pstmt.setString(2, bean.getCompany_name_k());
			pstmt.setString(3, bean.getSearch_word());
			pstmt.setString(4, bean.getTel_no1_1());
			pstmt.setString(5, bean.getTel_no1_2());
			pstmt.setString(6, bean.getTel_no1_3());
			pstmt.setString(7, bean.getTel_no2_1());
			pstmt.setString(8, bean.getTel_no2_2());
			pstmt.setString(9, bean.getTel_no2_3());
			pstmt.setString(10, bean.getFax_no_1());
			pstmt.setString(11, bean.getFax_no_2());
			pstmt.setString(12, bean.getFax_no_3());
			pstmt.setString(13, bean.getEmail());
			pstmt.setString(14, bean.getUrl());
			pstmt.setString(15, bean.getPhoto_name1());
			pstmt.setString(16, bean.getPhoto_name2());
			pstmt.setString(17, bean.getPhoto_name3());
			pstmt.setString(18, bean.getPhoto_name4());
			pstmt.setString(19, bean.getPhoto_name5());
			pstmt.setString(20, bean.getArea_code_1());
			pstmt.setString(21, bean.getArea_code_2());
			pstmt.setString(22, bean.getArea_code_3());
			pstmt.setString(23, bean.getLine_code());
			pstmt.setString(24, bean.getStation_code());
			pstmt.setString(25, bean.getArea_fast());
			pstmt.setString(26, bean.getCate_code_1());
			pstmt.setString(27, bean.getCate_code_2());
			pstmt.setString(28, bean.getMain_area());
			pstmt.setString(29, bean.getAppeal_point());
			pstmt.setString(30, bean.getDetail_info());
			pstmt.setString(31, bean.getTitle());
			pstmt.setString(32, bean.getCharge());
			pstmt.setString(33, bean.getPay());
			pstmt.setString(34, bean.getWork_time());
			pstmt.setString(35, bean.getSex());
			int result = pstmt.executeUpdate();
			KankokujinLogger.getInstance().debug("JobRegistHandler.insertJobBean" + pstmt.getQueryString());
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

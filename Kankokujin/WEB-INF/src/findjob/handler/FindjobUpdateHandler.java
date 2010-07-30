package findjob.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import findjob.bean.FindjobBean;

public class FindjobUpdateHandler {
	private static FindjobUpdateHandler instance = null;
	private FindjobUpdateHandler(){
		
	}
    public static FindjobUpdateHandler getInstance() {
        if (instance == null) {
            synchronized (FindjobUpdateHandler.class) {
                if (instance == null) {
                    instance = new FindjobUpdateHandler();
                }
            }
        }

        return instance;
    }
	public boolean updateFindjobBean(FindjobBean bean) throws SysException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("update findjob_info ");
			sb.append(" set title=?, tel_no1_1=?, tel_no1_2=?, tel_no1_3=?, tel_no2_1=?, " );
			sb.append(" tel_no2_2=?, tel_no2_3=?, email=?, appeal_point=?, detail_info=?, birthday=?, work_sort=?, sex=?," );
			sb.append(" update_date=(now())" );
			sb.append(" where id=?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getTel_no1_1());
			pstmt.setString(3, bean.getTel_no1_2());
			pstmt.setString(4, bean.getTel_no1_3());
			pstmt.setString(5, bean.getTel_no2_1());
			pstmt.setString(6, bean.getTel_no2_2());
			pstmt.setString(7, bean.getTel_no2_3());
			pstmt.setString(8, bean.getEmail());
			pstmt.setString(9, bean.getAppeal_point());
			pstmt.setString(10, bean.getDetail_info());			
			pstmt.setString(11, bean.getBirthday());
			pstmt.setString(12, bean.getWork_sort());
			pstmt.setString(13, bean.getSex());			
			pstmt.setString(14, bean.getId());
			
			KankokujinLogger.getInstance().debug("updateFindjobBean sql =" + sb.toString());
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			throw new SysException("SYE0024" , e);
		} catch (Exception e) {
			throw new SysException("SYE0024" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SysException("SYE0024" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;

	}
	
}
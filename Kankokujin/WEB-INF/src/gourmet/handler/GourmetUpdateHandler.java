package gourmet.handler;

import gourmet.bean.GourmetBean;

import java.sql.Connection;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class GourmetUpdateHandler {
	private static GourmetUpdateHandler instance = null;
	private GourmetUpdateHandler(){
		
	}
    public static GourmetUpdateHandler getInstance() {
        if (instance == null) {
            synchronized (GourmetUpdateHandler.class) {
                if (instance == null) {
                    instance = new GourmetUpdateHandler();
                }
            }
        }

        return instance;
    }
	public boolean updateGourmetBean(GourmetBean bean) throws SysException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();

			StringBuffer sb = new StringBuffer();
			sb.append("update gourmet_info ");
			sb.append(" set " );
			sb.append(" store_name_k=?, store_name_j=?, search_word=?, tel_no1_1=?, tel_no1_2=?, tel_no1_3=?, tel_no2_1=?, tel_no2_2=?, tel_no2_3=?, " );
			sb.append(" fax_no_1=?, fax_no_2=?, fax_no_3=?, email=?, work_time=?, url=?, " );
			sb.append(" photo_name1=?, photo_name2=?, photo_name3=?, photo_name4=?, photo_name5=?, " );
			sb.append(" main_area=?, area_code_1=?, area_code_2=?, area_code_3=?, rest_day=?, line_code=?, " );
			sb.append(" station_code=?, area_fast=?, sort_code=?, cate_code_1=?, cate_code_2=?, view_code=?, appeal_point=?, detail_info=?, update_date=(now())" );
			sb.append(" where id=?");
			pstmt = new LogPreparedStatement(con, sb.toString());

			pstmt.setString(1, bean.getStore_name_k());
			pstmt.setString(2, bean.getStore_name_j());
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
			pstmt.setString(14, bean.getWork_time());
			pstmt.setString(15, bean.getUrl());
			pstmt.setString(16, bean.getPhoto_name1());
			pstmt.setString(17, bean.getPhoto_name2());
			pstmt.setString(18, bean.getPhoto_name3());
			pstmt.setString(19, bean.getPhoto_name4());
			pstmt.setString(20, bean.getPhoto_name5());			
			pstmt.setString(21, bean.getMain_area());
			pstmt.setString(22, Util.changeNullCode(0, bean.getArea_code_1()));
			pstmt.setString(23, Util.changeNullCode(1, bean.getArea_code_2()));
			pstmt.setString(24, bean.getArea_code_3());
			pstmt.setString(25, bean.getRest_day());
			pstmt.setString(26, Util.changeNullCode(0, bean.getLine_code()));
			pstmt.setString(27, Util.changeNullCode(1, bean.getStation_code()));
			pstmt.setString(28, bean.getArea_fast());
			pstmt.setString(29, bean.getSort_code());
			pstmt.setString(30, bean.getCate_code_1());
			pstmt.setString(31, bean.getCate_code_2());
			pstmt.setString(32, bean.getView_code());
			pstmt.setString(33, bean.getAppeal_point());
			pstmt.setString(34, bean.getDetail_info());
			pstmt.setString(35, bean.getId());
			KankokujinLogger.getInstance().debug("GourmetUpdateHandler.updateGourmetBean" + pstmt.getQueryString());
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
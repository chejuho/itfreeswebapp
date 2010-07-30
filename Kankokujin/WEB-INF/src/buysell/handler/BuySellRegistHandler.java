package buysell.handler;

import java.sql.Connection;
import java.sql.SQLException;

import buysell.bean.BuySellBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;


public class BuySellRegistHandler {
	private static BuySellRegistHandler instance = null;
	private BuySellRegistHandler(){
		
	}
    public static BuySellRegistHandler getInstance() {
        if (instance == null) {
            synchronized (BuySellRegistHandler.class) {
                if (instance == null) {
                    instance = new BuySellRegistHandler();
                }
            }
        }

        return instance;
    }	
	/**
	 * BuySellInfoのINSERTするメソッドド
	 * 
	 * @return boolean
	 * @throws AppException 
	 */
	 public boolean insertBuySellBean(BuySellBean bean) throws AppException{
			Connection con= null;
			LogPreparedStatement pstmt = null;
			try{
				con = DBConnectionMgr.getInstance().getConnection();
				StringBuffer sb = new StringBuffer("insert into buysell_info (user_id, title, price, price_unit, sell_place,");//1-5
				sb.append("send_method, cate_code_1, cate_code_2, tel_no1_1, tel_no1_2,");//6-10
				sb.append("tel_no1_3, tel_no2_1, tel_no2_2, tel_no2_3, detail_info,");//11-15
				sb.append("photo_name1, photo_name2, photo_name3, photo_name4, photo_name5,");//16-20		
				sb.append("pro_status, member_sort, regist_date, update_date, read_count, free_price, email)");//21-24			
				sb.append(" values (?, ?, ?, ?, ?, ");//1-5
				sb.append(" ?, ?, ?, ?, ?, ");//6-10
				sb.append(" ?, ?, ?, ?, ?, ");//11-15
				sb.append(" ?, ?, ?, ?, ?, ?,");//16-20	
				sb.append(" ?, now(), now(), 0, ?, ?)");//21-24
				
				pstmt = new LogPreparedStatement(con, sb.toString());
				pstmt.setString(1, bean.getUser_id());
				pstmt.setString(2, bean.getTitle());
				pstmt.setString(3, bean.getPrice());
				pstmt.setString(4, Util.changeNullStrToNull(bean.getPrice_unit()));
				pstmt.setString(5, bean.getSell_place());
				pstmt.setString(6, bean.getSend_method());
				pstmt.setString(7, bean.getCate_code_1());
				pstmt.setString(8, bean.getCate_code_2());
				
				pstmt.setString(9, bean.getTel_no1_1());
				pstmt.setString(10, bean.getTel_no1_2());
				pstmt.setString(11, bean.getTel_no1_3());
				
				pstmt.setString(12, bean.getTel_no2_1());
				pstmt.setString(13, bean.getTel_no2_2());
				pstmt.setString(14, bean.getTel_no2_3());
				
				pstmt.setString(15, bean.getDetail_info());
				pstmt.setString(16, bean.getPhoto_name1());
				pstmt.setString(17, bean.getPhoto_name2());
				pstmt.setString(18, bean.getPhoto_name3());
				pstmt.setString(19, bean.getPhoto_name4());
				pstmt.setString(20, bean.getPhoto_name5());
				pstmt.setString(21, bean.getPro_status());
				pstmt.setString(22, Util.changeNullStrToNull(bean.getMember_sort()));
				pstmt.setString(23, Util.changeNullStrToNull(bean.getFree_price()));
				pstmt.setString(24, bean.getEmail());
				
				KankokujinLogger.getInstance().debug("BuySellRegistHandler.insertBuySellBean" + pstmt.getQueryString());
				int result = pstmt.executeUpdate();
				if(result==1){
				
				return true;
				}
				
		    }catch (Exception e) {
		    	throw new AppException("Exception" , e);

			} finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						throw new AppException("SQLException" , e);
					}
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
			}
			return false;
	 }	  
}


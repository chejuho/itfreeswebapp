package buysell.handler;

import java.sql.Connection;
import java.sql.SQLException;

import buysell.bean.BuySellBean;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;


public class BuySellUpdateHandler {
	private static BuySellUpdateHandler instance = null;
	private BuySellUpdateHandler(){
		
	}
    public static BuySellUpdateHandler getInstance() {
        if (instance == null) {
            synchronized (BuySellUpdateHandler.class) {
                if (instance == null) {
                    instance = new BuySellUpdateHandler();
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
	 public boolean updateBuySellBean(BuySellBean bean) throws AppException{
			Connection con= null;
			LogPreparedStatement pstmt = null;
			try{
				
				con = DBConnectionMgr.getInstance().getConnection();
				StringBuffer sb = new StringBuffer();  
				sb.append("update buysell_info set ");
				sb.append("title=?, price=?, price_unit=?, cate_code_2=?, sell_place=?, " );//5
				sb.append("send_method=?, tel_no1_1=?, tel_no1_2=?, tel_no1_3=?, tel_no2_1=?,  " );//10
				sb.append("tel_no2_2=?, tel_no2_3=? , detail_info=?, photo_name1=?, photo_name2=?,");//15
				sb.append("photo_name3=?, photo_name4=? , photo_name5=?, pro_status=? , member_sort=?, ");//20
				sb.append("update_date=now(), free_price=?, email=?  where id=?" );//23
				pstmt = new LogPreparedStatement(con, sb.toString());
				pstmt.setString(1, bean.getTitle());
				pstmt.setString(2, bean.getPrice());
				pstmt.setString(3, Util.changeNullStrToNull(bean.getPrice_unit()));
				pstmt.setString(4, bean.getCate_code_2());
				pstmt.setString(5, bean.getSell_place());
				pstmt.setString(6, bean.getSend_method());
				pstmt.setString(7, bean.getTel_no1_1());
				pstmt.setString(8, bean.getTel_no1_2());
				pstmt.setString(9, bean.getTel_no1_3());
				pstmt.setString(10, bean.getTel_no2_1());
				pstmt.setString(11, bean.getTel_no2_2());
				pstmt.setString(12, bean.getTel_no2_3());
				pstmt.setString(13, bean.getDetail_info());
				pstmt.setString(14, bean.getPhoto_name1());
				pstmt.setString(15, bean.getPhoto_name2());
				pstmt.setString(16, bean.getPhoto_name3());
				pstmt.setString(17, bean.getPhoto_name4());
				pstmt.setString(18, bean.getPhoto_name5());				
				pstmt.setString(19, bean.getPro_status());
				pstmt.setString(20, Util.changeNullStrToNull(bean.getMember_sort()));
				pstmt.setString(21, Util.changeNullStrToNull(bean.getFree_price()));
				pstmt.setString(22, bean.getEmail());
				pstmt.setString(23, bean.getId());
				KankokujinLogger.getInstance().debug("BuySellUpdateHandler.updateBuySellBean" + pstmt.getQueryString());
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


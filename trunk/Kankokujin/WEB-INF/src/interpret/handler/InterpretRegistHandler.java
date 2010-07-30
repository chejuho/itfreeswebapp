package interpret.handler;

import interpret.bean.InterpretBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;


public class InterpretRegistHandler {	
	/**
	 * RoomInfoのINSERTするメソッドド
	 * 
	 * @return boolean
	 * @throws AppException 
	 */
	 public boolean insertInterpretBean(InterpretBean bean) throws AppException{
			Connection con= null;
			PreparedStatement pstmt = null;
			try{
				KankokujinLogger.getInstance().debug("InterpretRegistHandler.insertInterpretBean.start");
				con = DBConnectionMgr.getInstance().getConnection();
				String strsqr = 						        
				"insert into interpret_info (user_id, name_open, language, language_etc, service_area_1, service_area_1_etc,"+
				"service_area_2, sex, birthday, nation, nation_no, photo_path, photo_path_open, resume_path, "+
				"resume_path_open, tel_no_1, tel_no_2, tel_no_1_open, tel_no_2_open, "+
				"pay, pay_unit, pay_unit_etc, service_day, service_day_open, certification, "+
				"certification_open, skill, skill_open, introduction, introduction_open, " +
				"nation_etc, etc, etc_open, regist_date, update_date, viewflg)"+
				"values"+
				"(?, ?, ?, ?, ?, ?, "+
				" ?, ?, ?, ?, ?, ?, "+
				" ?, ?, ?, ?, ?, ?, "+
				" ?, ?, ?, ?, ?, ?, "+
				" ?, ?, ?, ?, ?, ?, "+
				" ?, ?, ?, now(),now(),?)";
				pstmt = con.prepareStatement(strsqr);
				pstmt.setString(1, bean.getUser_id());
				pstmt.setString(2, bean.getName_open());
				pstmt.setString(3, bean.getLanguage());
				pstmt.setString(4, bean.getLanguage_etc());
				pstmt.setString(5, bean.getService_area_1());
				pstmt.setString(6, bean.getService_area_1_etc());
				pstmt.setString(7, bean.getService_area_2());
				pstmt.setString(8, bean.getSex());
				pstmt.setString(9, bean.getBirthday());
				pstmt.setString(10, bean.getNation());
				pstmt.setString(11, bean.getNation_no());
				pstmt.setString(12, bean.getPhoto());
				pstmt.setString(13, bean.getPhoto_path_open());
				pstmt.setString(14, bean.getResume());
				pstmt.setString(15, bean.getResume_path_open());
				pstmt.setString(16, bean.getTel_no_1());
				pstmt.setString(17, bean.getTel_no_2());
				pstmt.setString(18, bean.getTel_no_1_open());
				pstmt.setString(19, bean.getTel_no_2_open());
				pstmt.setString(20, bean.getPay());
				pstmt.setString(21, bean.getPay_unit());
				pstmt.setString(22, bean.getPay_unit_etc());
				pstmt.setString(23, bean.getService_day());
				pstmt.setString(24, bean.getService_day_open());
				pstmt.setString(25, bean.getCertification());
				pstmt.setString(26, bean.getCertification_open());
				pstmt.setString(27, bean.getSkill());
				pstmt.setString(28, bean.getSkill_open());
				pstmt.setString(29, bean.getIntroduction());
				pstmt.setString(30, bean.getIntroduction_open());
				pstmt.setString(31, bean.getNation_etc());
				pstmt.setString(32, bean.getEtc());
				pstmt.setString(33, bean.getEtc_open());
				pstmt.setString(34, bean.getViewflg());
				KankokujinLogger.getInstance().debug("insertInterpretBean sql =" + pstmt.toString());
				int result = pstmt.executeUpdate();
				if(result==1){
				
				return true;
				}
				
		    }catch (SQLException e) {
		    	throw new AppException("InterpretRegistHandler.insertInterpretBean.SQLException" , e);

			} catch (Exception e) {
		    	throw new AppException("InterpretRegistHandler.insertInterpretBean.Exception"+pstmt.toString() , e);

			} finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						throw new AppException("InterpretRegistHandler.insertInterpretBean.SQLException" , e);
					}
				if (con != null) {
					DBConnectionMgr.getInstance().freeConnection(con);
				}
			}
			return false;
	 }
	 public boolean registCheck(String id) throws AppException{
		 KankokujinLogger.getInstance().debug("InterpretRegistHandler.registCheck.start");
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int count = 0;
			boolean result = false;

			try {
				con = DBConnectionMgr.getInstance().getConnection();
				StringBuffer sb = new StringBuffer();
				sb.append("select count(*) from interpret_info where user_id ='"+id+"'");
				KankokujinLogger.getInstance().debug("registCheck sql=" + sb.toString());
				pstmt = con.prepareStatement(sb.toString());

				rs = pstmt.executeQuery();

				if (rs.next()) {
					count = rs.getInt(1);

					if(count==0){
						result=true;
					}
				}

			} catch (SQLException e) {
				throw new AppException("InterpretRegistHandler.registCheck.SQLException", e);

			} catch (Exception e) {
				throw new AppException("InterpretRegistHandler.registCheck.Exception", e);

			} finally {
				if (rs != null) {

					try {
						rs.close();
					} catch (SQLException e) {
						throw new AppException("InterpretRegistHandler.registCheck.SQLException", e);
					}
				}
				if (pstmt != null) {

					try {
						pstmt.close();
					} catch (SQLException e) {
						throw new AppException("InterpretRegistHandler.registCheck.SQLException", e);
					}
				}
				if (con != null) {

					try {
						con.close();
					} catch (SQLException e) {
						throw new AppException("InterpretRegistHandler.registCheck.SQLException", e);
					}
				}
			}

			return result;

		}
	 
	 public String getContentId(String Userid) throws AppException{
		 KankokujinLogger.getInstance().debug("InterpretRegistHandler.getContentId.start");
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String ID = "";

			try {
				con = DBConnectionMgr.getInstance().getConnection();
				StringBuffer sb = new StringBuffer();
				sb.append("select id from interpret_info where user_id ='"+Userid+"'");					
				KankokujinLogger.getInstance().debug("getContentId sql=" + sb.toString());
				pstmt = con.prepareStatement(sb.toString());

				rs = pstmt.executeQuery();

				if (rs.next()) {
					ID = rs.getString("id");
				}

			} catch (SQLException e) {
				throw new AppException("InterpretRegistHandler.getContentId.SQLException", e);

			} catch (Exception e) {
				throw new AppException("InterpretRegistHandler.getContentId.Exception", e);

			} finally {
				if (rs != null) {

					try {
						rs.close();
					} catch (SQLException e) {
						throw new AppException("InterpretRegistHandler.getContentId.SQLException", e);
					}
				}
				if (pstmt != null) {

					try {
						pstmt.close();
					} catch (SQLException e) {
						throw new AppException("InterpretRegistHandler.getContentId.SQLException", e);
					}
				}
				if (con != null) {

					try {
						con.close();
					} catch (SQLException e) {
						throw new AppException("InterpretRegistHandler.getContentId.SQLException", e);
					}
				}
			}

			return ID;

		}
}


package interpret.handler;

import interpret.bean.InterpretBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class InterpretUpdateHandler {
	public boolean updateInterpretBean(InterpretBean bean) throws AppException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			KankokujinLogger.getInstance().debug(
					"InterpretUpdateHandler.updateInterpretBean.start");
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE interpret_info ");
			sb.append(" SET " );
			sb.append(" name_open=?, language=?, language_etc=?, service_area_1=?, " );
			sb.append(" service_area_1_etc=?, service_area_2=?, sex=?, birthday=?, nation=?, " );
			sb.append(" nation_no=?, " );
			if(!Util.isEmpty(bean.getPhoto())){
				sb.append(" photo_path='"+bean.getPhoto() + "' ,");
			}
			if(!Util.isEmpty(bean.getResume())){
				sb.append(" resume_path='"+bean.getResume() + "' ,");
			}
			sb.append(" photo_path_open=?, " );
			sb.append(" resume_path_open=?, ");
			sb.append(" tel_no_1=?, tel_no_2=?, tel_no_1_open=?, tel_no_2_open=?, pay=?, ");
			sb.append(" pay_unit=?, pay_unit_etc=?, service_day=?, service_day_open=?, certification=?, " );
			sb.append(" certification_open=?, skill=?, skill_open=?, introduction=?, introduction_open=?, " );
			sb.append(" nation_etc=?, etc=?, etc_open=?, update_date=(now()) " );
			sb.append(" where id=?");
			
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setString(1, bean.getName_open());
			pstmt.setString(2, bean.getLanguage());
			pstmt.setString(3, bean.getLanguage_etc());
			pstmt.setString(4, bean.getService_area_1());
			pstmt.setString(5, bean.getService_area_1_etc());
			pstmt.setString(6, bean.getService_area_2());
			pstmt.setString(7, bean.getSex());
			pstmt.setString(8, bean.getBirthday());
			pstmt.setString(9, bean.getNation());
			pstmt.setString(10, bean.getNation_no());			
			pstmt.setString(11, bean.getPhoto_path_open());			
			pstmt.setString(12, bean.getResume_path_open());
			pstmt.setString(13, bean.getTel_no_1());
			pstmt.setString(14, bean.getTel_no_2());
			pstmt.setString(15, bean.getTel_no_1_open());
			pstmt.setString(16, bean.getTel_no_2_open());
			pstmt.setString(17, bean.getPay());
			pstmt.setString(18, bean.getPay_unit());
			pstmt.setString(19, bean.getPay_unit_etc());
			pstmt.setString(20, bean.getService_day());
			pstmt.setString(21, bean.getService_day_open());
			pstmt.setString(22, bean.getCertification());
			pstmt.setString(23, bean.getCertification_open());
			pstmt.setString(24, bean.getSkill());
			pstmt.setString(25, bean.getSkill_open());
			pstmt.setString(26, bean.getIntroduction());
			pstmt.setString(27, bean.getIntroduction_open());
			pstmt.setString(28, bean.getNation_etc());
			pstmt.setString(29, bean.getEtc());
			pstmt.setString(30, bean.getEtc_open());
			pstmt.setString(31, bean.getId());
			
			KankokujinLogger.getInstance().debug("getInterpretBeanList sql =" + sb.toString());
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				return true;
			}

		} catch (SQLException e) {
			throw new AppException("InterpretUpdateHandler.updateInterpretBean.SQLException", e);

		} catch (Exception e) {
			throw new AppException("InterpretUpdateHandler.updateInterpretBean.Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("InterpretUpdateHandler.updateInterpretBean.SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;

	}
	
}
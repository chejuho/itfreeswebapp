package interpret.handler;

import interpret.bean.InterpretBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.handler.MemberLoginHandler;

import common.bean.MemberBean;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class InterpretUpdateOpenHandler {
	/**
	 * RoomInfoのINSERTするメソッドド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public InterpretBean getInterpretBean(String id) throws AppException {
		KankokujinLogger.getInstance().debug("HouseSellDetailHandler.getInterpretBean.start");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberLoginHandler member = new MemberLoginHandler();
		InterpretBean bean = new InterpretBean();
		try {

			con = DBConnectionMgr.getInstance().getConnection();

			String strSql = "select * from interpret_info where id = ?";

			pstmt = con.prepareStatement(strSql);

			pstmt.setString(1, id);
			KankokujinLogger.getInstance().debug("getInterpretBean sql=" + strSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				bean.setId(Util.changeNullStr(rs.getString("id")));

				String user_id = Util.changeNullStr(rs.getString("user_id"));
				MemberBean mBean = member.getMemberInfo(user_id);					
				
				String userName = mBean.getName();
				String name_open = rs.getString("name_open");
				bean.setUser_name(Util.getSecurityInfo(userName, name_open));
				
				bean.setUser_id(Util.changeNullStr(rs.getString("user_id")));								
				
				bean.setEmail1(mBean.getEmail1());
				bean.setEmail2(mBean.getEmail2());
				bean.setName_open(Util.changeNullStr(rs.getString("name_open")));
				
				bean.setLanguage(Util.changeNullStr(rs.getString("language")));				
				bean.setLanguage_etc(Util.changeNullStr(rs.getString("language_etc")));		
				bean.setService_area_1(Util.changeNullStr(rs.getString("service_area_1")));
				bean.setService_area_1_etc(Util.changeNullStr(rs.getString("service_area_1_etc")));
				bean.setService_area_2(Util.changeNullStr(rs.getString("service_area_2")));				
				bean.setSex(Util.changeNullStr(rs.getString("sex")));				
				bean.setBirthday(Util.changeNullStr(rs.getString("birthday")));				
				bean.setNation(Util.changeNullStr(rs.getString("nation")));				
				bean.setNation_etc(Util.changeNullStr(rs.getString("nation_etc")));				
				bean.setPhoto_path(Util.changeNullStr(rs.getString("photo_path")));
				bean.setPhoto_path_open(Util.changeNullStr(rs.getString("photo_path_open")));		
				bean.setResume(Util.changeNullStr(rs.getString("resume_path")));				
				bean.setResume_path(Util.changeNullStr(rs.getString("resume_path")));				
				bean.setResume_path_open(Util.changeNullStr(rs.getString("resume_path_open")));				
				bean.setNation_no(Util.changeNullStr(rs.getString("nation_no")));				
				bean.setTel_no_1(Util.changeNullStr(rs.getString("tel_no_1")));
				bean.setTel_no_1_open(Util.changeNullStr(rs.getString("tel_no_1_open")));				
				bean.setTel_no_2(Util.changeNullStr(rs.getString("tel_no_2")));
				bean.setTel_no_2_open(Util.changeNullStr(rs.getString("tel_no_2_open")));				
				bean.setPay(Util.changeNullStr(rs.getString("pay")));
				bean.setPay_unit(Util.changeNullStr(rs.getString("pay_unit")));
				bean.setPay_unit_etc(Util.changeNullStr(rs.getString("pay_unit_etc")));				
				bean.setService_day(Util.changeNullStr(rs.getString("service_day")));
				bean.setService_day_open(Util.changeNullStr(rs.getString("service_day_open")));				
				bean.setCertification(Util.changeNullStr(rs.getString("certification")));
				bean.setCertification_open(Util.changeNullStr(rs.getString("certification_open")));		
				bean.setEtc(Util.changeNullStr(rs.getString("etc")));
				bean.setEtc_open(Util.changeNullStr(rs.getString("etc_open")));
				
				bean.setSkill(Util.changeNullStr(rs.getString("skill")));
				bean.setSkill_open(Util.changeNullStr(rs.getString("skill_open")));
				
				bean.setIntroduction(Util.changeNullStr(rs.getString("introduction")));
				bean.setIntroduction_open(Util.changeNullStr(rs.getString("introduction_open")));				
				bean.setRegist_date(Util.changeNullStr(rs.getString("regist_date")));
				bean.setUpdate_date(Util.changeNullStr(rs.getString("update_date")));
				
			}
		} catch (SQLException e) {
			throw new AppException("InterpretUpdateOpenHandler.getInterpretBean.SQLException", e);

		} catch (Exception e) {
			throw new AppException("InterpretUpdateOpenHandler.getInterpretBean.Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("InterpretUpdateOpenHandler.getInterpretBean.SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}

}

package interpret.handler;

import interpret.bean.InterpretBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import member.handler.MemberLoginHandler;

import common.bean.MemberBean;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class InterpretDetailHandler {
	/**
	 * RoomInfoのINSERTするメソッドド
	 * 
	 * @return boolean
	 * @throws AppException
	 */
	public InterpretBean getInterpretBean(HttpServletRequest request,String id) throws AppException {
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
//				String name_open = rs.getString("name_open");
				bean.setUser_name(userName);
				bean.setUser_id(Util.changeNullStr(rs.getString("user_id")));
								
				bean.setEmail1(mBean.getEmail1());
				bean.setEmail2(mBean.getEmail2());
				bean.setName_open(Util.changeNullStr(rs.getString("name_open")));
				
				if(!Util.isEmpty(rs.getString("language"))){
					String sign = "/";
					String language = Util.changeData(request, rs.getString("language"), sign);
					bean.setLanguage(language);
				}
				
				bean.setLanguage_etc(Util.changeNullStr(rs.getString("language_etc")));
				
				String service_area_1 = Util.changeNullStr(rs.getString("service_area_1"));
				bean.setService_area_1(Util.changeNation(request, service_area_1));
				bean.setService_area_1_etc(Util.changeNullStr(rs.getString("service_area_1_etc")));
				bean.setService_area_2(Util.changeNullStr(rs.getString("service_area_2")));
				
				String sexNo = Util.changeNullStr(rs.getString("sex"));
				bean.setSex(Util.changeSex(request, sexNo));

				String birthday = rs.getString("birthday");
				if(!Util.isEmpty(birthday)){
					String year = birthday.substring(0,4);
					bean.setYear(year);
					String month = birthday.substring(4);
					bean.setMonth(month);
					bean.setBirthday(birthday);
					String age = Util.getKoreanAge(bean.getBirthday());
					bean.setAge(age);
				}
				
				String nationNo = Util.changeNullStr(rs.getString("nation"));
				bean.setNation(nationNo);
				bean.setNation_name(Util.changeNation(request, nationNo));
				
				bean.setNation_etc(Util.changeNullStr(rs.getString("nation_etc")));
				
				String photo_path = Util.changeNullStr(rs.getString("photo_path"));
				String photo_path_open = Util.changeNullStr(rs.getString("photo_path_open"));
				bean.setPhoto_path(Util.getSecurityInfo(photo_path, photo_path_open));
		
				bean.setResume(Util.changeNullStr(rs.getString("resume_path")));				
				String resume_path = Util.changeNullStr(rs.getString("resume_path"));				
				String resume_path_open = Util.changeNullStr(rs.getString("resume_path_open"));
				bean.setResume_path(Util.getSecurityInfo(resume_path, resume_path_open));
				
				bean.setNation_no(Util.changeNullStr(rs.getString("nation_no")));
				
				String tel_no_1 = Util.changeNullStr(rs.getString("tel_no_1"));
				String tel_no_1_open = Util.changeNullStr(rs.getString("tel_no_1_open"));
				bean.setTel_no_1(Util.getSecurityInfo(tel_no_1, tel_no_1_open));
				
				String tel_no_2 = Util.changeNullStr(rs.getString("tel_no_2"));
				String tel_no_2_open = Util.changeNullStr(rs.getString("tel_no_2_open"));
				bean.setTel_no_2(Util.getSecurityInfo(tel_no_2, tel_no_2_open));
				
				bean.setPay(Util.changeNullStr(rs.getString("pay")));
				String pay_unit = Util.changeNullStr(rs.getString("pay_unit"));
				bean.setPay_unit(Util.changePayUnit(request, pay_unit));
				bean.setPay_unit_etc(Util.changeNullStr(rs.getString("pay_unit_etc")));
				
				String service_day = Util.changeNullStr(rs.getString("service_day"));
				String service_day_open = Util.changeNullStr(rs.getString("service_day_open"));
				bean.setService_day(Util.getSecurityInfo(service_day, service_day_open));
				
				String certification = Util.changeNullStr(rs.getString("certification"));
				String certification_open = Util.changeNullStr(rs.getString("certification_open"));
				bean.setCertification(Util.getSecurityInfo(certification, certification_open));

				String skill = Util.changeNullStr(rs.getString("skill"));
				String skill_open = Util.changeNullStr(rs.getString("skill_open"));
				bean.setSkill(Util.getSecurityInfo(skill, skill_open));

				String introduction = Util.changeNullStr(rs.getString("introduction"));
				String introduction_open = Util.changeNullStr(rs.getString("introduction_open"));
				bean.setIntroduction(Util.getSecurityInfo(introduction, introduction_open));
				
				String etc = Util.changeNullStr(rs.getString("etc"));
				String etc_open = Util.changeNullStr(rs.getString("etc_open"));
				bean.setEtc(Util.getSecurityInfo(etc, etc_open));
				
				bean.setRegist_date(Util.changeNullStr(rs.getString("regist_date")));
				bean.setUpdate_date(Util.changeNullStr(rs.getString("update_date")));
				
			}
				
		} catch (SQLException e) {
			throw new AppException("InterpretDetailHandler.getInterpretBean.SQLException", e);

		} catch (Exception e) {
			throw new AppException("InterpretDetailHandler.getInterpretBean.Exception" , e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("InterpretDetailHandler.getInterpretBean.SQLException" , e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return bean;
	}

}

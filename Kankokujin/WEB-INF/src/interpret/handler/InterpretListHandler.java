package interpret.handler;
                       
import interpret.bean.InterpretBean;
import interpret.bean.InterpretSortBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.handler.UtilHandler;
import common.logger.KankokujinLogger;
import common.util.Util;

public class InterpretListHandler {
	
	/**
	 * count�̏��⨒m�点����
	 * @param bean�@count��y��
	 * @return count columnIndex�̍ŏ��̗��int�Ƃ��Ď擾
	 */
	public int getInfoCount(InterpretBean bean) throws AppException {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getInfoCount.start");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from interpret_info");
			sb.append(getWhereList(bean));
			KankokujinLogger.getInstance().debug("getInfoCount sql=" + sb.toString());
			pstmt = con.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {

				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			throw new AppException("InterpretListHandler.getInfoCount.SQLException", e);

		} catch (Exception e) {
			throw new AppException("InterpretListHandler.getInfoCount.Exception", e);

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("InterpretListHandler.getInfoCount.SQLException", e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("InterpretListHandler.getInfoCount.SQLException", e);
				}
			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					throw new AppException("InterpretListHandler.getInfoCount.SQLException", e);
				}
			}
		}

		return count;

	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getWhereList(InterpretBean bean) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getWhereList.start");
		ArrayList<String> list = new ArrayList<String>();

		String sql = "";
		
		// �ƒJ�n�l�i	
		
		if (!"".equals(bean.getLanguage_etc())) {
			sql = getLanguageEtcTag(bean.getLanguage_etc());
			list.add(sql);
		}
		
		if (!"".equals(bean.getService_area_1()) && !"etc".equals(bean.getService_area_1())) {
			sql = getServiceAreaTag(bean.getService_area_1());
			list.add(sql);
		}else if ("etc".equals(bean.getService_area_1())) {
			sql = getServiceAreaEtcTag(bean.getService_area_1_etc());
			list.add(sql);
		}
		
		if (!"".equals(bean.getSex())) {
			sql = getSexTag(bean.getSex());
			list.add(sql);
		}
		

		if ((!"".equals(bean.getInterpret()[0])
				|| !"".equals(bean.getInterpret()[1])
				|| !"".equals(bean.getInterpret()[2])
				|| !"".equals(bean.getInterpret()[3]))) {
			sql = getOrSQL(getInterpretTag(bean));
			list.add(sql);
		}

		if ((!"".equals(bean.getAges()[0]) || !"".equals(bean.getAges()[1]))
				&& (!"100".equals(bean.getAges()[0]) || !"100".equals(bean.getAges()[1]))) {
			sql = getAgeTag(bean.getAges()[0], bean.getAges()[1]);
			list.add(sql);
		}		
		
		if (!"".equals(bean.getNation()) && !"etc".equals(bean.getNation())) {
			sql = getNationTag(bean.getNation());
			list.add(sql);
		}else if ("etc".equals(bean.getNation())) {
			sql = getNationEtcTag(bean.getNation_etc());
			list.add(sql);
		}
		
		if (!"".equals(bean.getResume())) {
			sql = getResumeTag(bean.getResume());
			list.add(sql);
		}

		sql = "viewflg=0";
		list.add(sql);
		
//		if ((!"".equals(bean.getInterpret_fee()[0]) || !"".equals(bean
//				.getInterpret_fee()[1]))
//				&& (!"100".equals(bean.getInterpret_fee()[0]) || !"100".equals(bean
//						.getInterpret_fee()[1]))) {
//			sql = getInterpretFeeTag(bean.getInterpret_fee()[0], bean.getInterpret_fee()[1]);
//			list.add(sql);
//		}

		return getWhereSQL(list);

	}
	
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * @param map
	 * @return
	 */
	private String getOrSQL(ArrayList list){
		KankokujinLogger.getInstance().debug("HouseSellListHandler.getOrSQL.start");
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();		
		boolean isFirst = true;
		while (it.hasNext()) {
			if (isFirst) {
				isFirst = false;	
				sb.append("(");
			}else {
				sb.append(" AND ");
			}
			String temp = (String)it.next();
			sb.append(temp + " ");
			
		}
		sb.append(")");
		return sb.toString();
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private ArrayList getInterpretTag(InterpretBean bean) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getInterpretTag.start");
		ArrayList<String> list = new ArrayList<String>();
		
		if (!Util.isEmpty(bean.getInterpret()[0])
				&& "0".equals(bean.getInterpret()[0])) {
			list.add(" language like '%0%' ");
		}
		if (!Util.isEmpty(bean.getInterpret()[1])
				&& "1".equals(bean.getInterpret()[1])) {
			list.add(" language like '%1%' ");
		}
		if (!Util.isEmpty(bean.getInterpret()[2])
				&& "2".equals(bean.getInterpret()[2])) {
			list.add(" language like '%2%' ");
		}
		if (!Util.isEmpty(bean.getInterpret()[3])
				&& "3".equals(bean.getInterpret()[3])) {
			list.add(" language like '%3%' ");
		}
		return list;
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
//	private String getInterpretFeeTag(String interpret_fee_from, String interpret_fee_to) {
//		KankokujinLogger.getInstance().debug("InterpretListHandler.getInterpretFeeTag.start");
//		StringBuffer sb = new StringBuffer();
//		int interpret_fee1 = Integer.parseInt(interpret_fee_from) * 10000;
//		int interpret_fee2 = Integer.parseInt(interpret_fee_to) * 10000;
//		if (!"100".equals(interpret_fee_from)) {
//			sb.append(" pay >= " + interpret_fee1);
//		}
//		if (!"100".equals(interpret_fee_from) && !"100".equals(interpret_fee_to)) {
//			sb.append(" and ");
//		}
//		if (!"100".equals(interpret_fee_to)) {
//			sb.append(" pay <= " + interpret_fee2);
//		}
//
//		return sb.toString();
//	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getAgeTag(String age_from, String age_to) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getAgeTag.start");
		StringBuffer sb = new StringBuffer();
		int age1 = Integer.parseInt(Util.getKoreanAgeYear(age_from));
		int age2 = Integer.parseInt(Util.getKoreanAgeYear(age_to));
		if (!"100".equals(age_from)) {
			sb.append(" birthday <= " + age1);
		}
		if (!"100".equals(age_from) && !"100".equals(age_to)) {
			sb.append(" and ");
		}
		if (!"100".equals(age_to)) {
			sb.append(" birthday >= " + age2);
		}
		return sb.toString();
	}


	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getWhereSQL(ArrayList list) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getWhereSQL.start");
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();

		if (list.size() > 0) {
			sb.append(" where ");
		}
		boolean isNotFirst = false;
		while (it.hasNext()) {
			if (isNotFirst) {
				sb.append(" and ");
			}
			isNotFirst = true;
			String temp = (String) it.next();
			sb.append(temp + " ");

		}
		return sb.toString();

	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getSexTag(String sex) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getSexTag.start");
		StringBuffer sb = new StringBuffer();
		
		sb.append("sex = '" + sex+"'" );
		return sb.toString();
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getResumeTag(String resume) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getResumeTag.start");
		StringBuffer sb = new StringBuffer();
		if("0".equals(resume)){			
			sb.append("resume_path = '' ");
		}else if("1".equals(resume)){
			sb.append("resume_path != '' " );			
		}
		return sb.toString();
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
//	private String getLanguageTag(String language) {
//		KankokujinLogger.getInstance().debug("InterpretListHandler.getLanguageTag.start");
//		StringBuffer sb = new StringBuffer();
//		if("etc".equals(language)){
//			sb.append("language_etc like '%" +language+"%'" );
//		}else{
//			sb.append("language like '%" +language+"%'" );
//		}
//		return sb.toString();
//	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getLanguageEtcTag(String language_etc) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getLanguageTag.start");
		StringBuffer sb = new StringBuffer();
		sb.append("language_etc like '%" +language_etc+"%'" );
		return sb.toString();
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getNationTag(String nation) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getLanguageTag.start");
		StringBuffer sb = new StringBuffer();
			sb.append("nation like '%" +nation+"%'" );
		return sb.toString();
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getNationEtcTag(String nation_etc) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getLanguageTag.start");
		StringBuffer sb = new StringBuffer();
		sb.append("nation_etc like '%" +nation_etc+"%'" );
		return sb.toString();
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getServiceAreaTag(String serviceArea) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getServiceAreaTag.start");
		StringBuffer sb = new StringBuffer();
			sb.append("service_area_1 like '%" +serviceArea+"%'" );
		return sb.toString();
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getServiceAreaEtcTag(String serviceArea) {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getServiceAreaTag.start");
		StringBuffer sb = new StringBuffer();
		sb.append("service_area_1_etc like '%" +serviceArea+"%'" );
		return sb.toString();
	}
	/**
	 * desc��asc�̐���
	 * @param request,interpretBean,interpretSortBean,start,num 
	 * @return list ����̒l
	 */
	public ArrayList<InterpretBean> getInterpretBeanList(HttpServletRequest request, InterpretBean interpretBean, InterpretSortBean interpretSortBean,
			int start, int num) throws AppException {
		KankokujinLogger.getInstance().debug("InterpretListHandler.getInterpretBeanList.start");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<InterpretBean> list = new ArrayList<InterpretBean>();
		StringBuffer sb = new StringBuffer();
		try {

			con = DBConnectionMgr.getInstance().getConnection();			
			
			sb.append("select * from interpret_info ");

			sb.append(getWhereList(interpretBean));
//			getOrderbyList(interpretSortBean, sb);
			//getOrderbySQL(cutSameList(interpretSortBean.getSortList()), sb);

			sb.append(" Order by update_date desc ");
			
			sb.append(" limit ?,? ");
			
			KankokujinLogger.getInstance().debug("getInterpretBeanList sql =" + sb.toString());
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, start - 1);

			pstmt.setInt(2, num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				InterpretBean bean = new InterpretBean();
				
				KankokujinLogger.getInstance().debug("bean start="+rs.getString("id"));
				
				bean.setId(rs.getString("id"));
				String user_id = rs.getString("user_id");
				//String userName = UtilHandler.getUserName(user_id);				
				String userName = "";
//				String name_open = rs.getString("name_open");
				bean.setUser_name(userName);

				if(!Util.isEmpty(rs.getString("language"))){
					String sign = "/";
					String language = Util.changeData(request, rs.getString("language"), sign);
					bean.setLanguage(language);
				}
				bean.setLanguage_etc(rs.getString("language_etc"));
				
				if(!Util.isEmpty(rs.getString("service_area_1"))){
					String nationNo = rs.getString("service_area_1");
					String service_area_1 = Util.changeNation(request, nationNo);
					bean.setService_area_1(service_area_1);
				}
				bean.setService_area_2(rs.getString("service_area_2"));
				bean.setService_area_1_etc(rs.getString("service_area_1_etc"));
				bean.setSkill(rs.getString("skill"));
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
				String sexNo = Util.changeNullStr(rs.getString("sex"));
				bean.setSex_name(Util.changeSex(request, sexNo));
				String nationNo = Util.changeNullStr(rs.getString("nation"));
				bean.setNation(nationNo);
				bean.setNation_name(Util.changeNation(request, nationNo));
				bean.setNation_etc(rs.getString("nation_etc"));
				String service_day = rs.getString("service_day");
				String service_day_open =rs.getString("service_day_open");
				bean.setService_day(Util.getSecurityInfo(service_day, service_day_open));


				//String day = rs.getString("update_date");
				Date date = rs.getDate("update_date");
				bean.setUpdate_date(Util.getRegistDate(date));

				list.add(bean);

			}

		} catch (SQLException e) {
			throw new AppException("InterpretListHandler.getInterpretBeanList.SQLException", e);

		} catch (Exception e) {
			throw new AppException("InterpretListHandler.getInterpretBeanList.Exception", e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("InterpretListHandler.getInterpretBeanList.SQLException", e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;

	}	
	
}
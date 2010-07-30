package roomsell.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import roomsell.bean.RoomBean;
import roomsell.bean.RoomSearchBean;

import common.bean.PageBean;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;
import common.logger.KankokujinLogger;
import common.page.PageUtil;
import common.util.Util;

public class RoomSellListHandler {
	private static RoomSellListHandler instance = null;

	private RoomSellListHandler() {

	}

	public static RoomSellListHandler getInstance() {
		if (instance == null) {
			synchronized (RoomSellListHandler.class) {
				if (instance == null) {
					instance = new RoomSellListHandler();
				}
			}
		}

		return instance;
	}

	/**
	 * count�̏��⨒m�点����
	 * 
	 * @param bean
	 *            count��y��
	 * @return count columnIndex�̍ŏ��̗��int�Ƃ��Ď擾
	 */
	public int getInfoCount(RoomSearchBean bean) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from room_info, member, t_area , t_train where ");
			sb.append(" room_info.user_id=member.user_id and ");
			sb.append(" room_info.area_code_1=t_area.area_code_1 and ");
			sb.append(" room_info.area_code_2=t_area.area_code_2 and ");
			sb.append(" room_info.line_code=t_train.line_code and ");
			sb.append(" room_info.station_code=t_train.station_code and ");
			if("C10001".equals(bean.getCate_code_1())){
				sb.append(" (room_info.room_sort=7 or room_info.room_sort=8 or room_info.room_sort=9 or room_info.room_sort=10) and ");
			} else {
				sb.append(" (room_info.room_sort=0 or room_info.room_sort=1 or room_info.room_sort=2 or room_info.room_sort=3 or room_info.room_sort=4 or room_info.room_sort=5 or room_info.room_sort=6) and ");
			}
			sb.append(" room_info.deleteflg=0 ");

			sb.append(getWhereList(bean));
			pstmt = new LogPreparedStatement(con, sb.toString());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("RoomSellListHandler.getInfoCount" + pstmt.getQueryString());
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("Exception" + e);

		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			}
			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
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
	private String getWhereList(RoomSearchBean bean) {
		ArrayList<String> list = new ArrayList<String>();

		// �ƒJ�n�l�i
		if ((!Util.isEmpty(bean.getRoom_fee_from()) || !Util.isEmpty(bean
				.getRoom_fee_to()))
				&& (!"100".equals(bean.getRoom_fee_from()) || !"100"
						.equals(bean.getRoom_fee_to()))) {
			list.add(getRoomFeeTag(bean));
		}

		if ((!Util.isEmpty(bean.getRoom_sort()[0])
				|| !Util.isEmpty(bean.getRoom_sort()[1])
				|| !Util.isEmpty(bean.getRoom_sort()[2])
				|| !Util.isEmpty(bean.getRoom_sort()[3])
				|| !Util.isEmpty(bean.getRoom_sort()[4])
				|| !Util.isEmpty(bean.getRoom_sort()[5])
				|| !Util.isEmpty(bean.getRoom_sort()[6])
				|| !Util.isEmpty(bean.getRoom_sort()[7])
				|| !Util.isEmpty(bean.getRoom_sort()[8])
				|| !Util.isEmpty(bean.getRoom_sort()[9]) || !Util.isEmpty(bean
				.getRoom_sort()[10]))) {
			list.add(getOrSQL(getRoom_sortTag(bean)));
		}
		if (!Util.isEmpty(bean.getArea_code_1())
				&& !"00".equals(bean.getArea_code_1())) {
			list.add(getAreaCode1Tag(bean.getArea_code_1()));
		}
		if (!Util.isEmpty(bean.getArea_code_2())
				&& !"00".equals(bean.getArea_code_2().substring(2, 4))) {
			list.add(getAreaCode2Tag(bean.getArea_code_2()));
		}
		if (!Util.isEmpty(bean.getLine_code())
				&& !"00".equals(bean.getLine_code())) {
			list.add(getLineCodeTag(bean.getLine_code()));
		}
		if (!Util.isEmpty(bean.getStation_code())
				&& !"00".equals(bean.getStation_code().substring(2, 4))) {
			list.add(getStationCodeTag(bean.getStation_code()));
		}
		if ("0".equals(bean.getSex()) || "1".equals(bean.getSex())) {
			list.add(getSexTag(bean.getSex()));
		}
		if ("0".equals(bean.getBuild_sort())
				|| "1".equals(bean.getBuild_sort())) {
			list.add(getBuild_sortTag(bean.getBuild_sort()));
		} else if ("2".equals(bean.getBuild_sort())) {
			list.add(getBuild_sortAllTag());
		}
		if ("0".equals(bean.getRoom_type()) || "1".equals(bean.getRoom_type())
				|| "2".equals(bean.getRoom_type())) {
			list.add(getRoom_typeTag(bean.getRoom_type()));
		} else if ("3".equals(bean.getRoom_type())) {
			list.add(getRoom_typeAllTag());
		}
		if (("0".equals(bean.getRegist_date()))
				|| ("1".equals(bean.getRegist_date()))
				|| ("2".equals(bean.getRegist_date()))) {
			list.add(getRegistDateTag(bean.getRegist_date()));
		}
		if(!Util.isEmpty(bean.getUser_id())){
			list.add(getUser_id_Tag(bean.getUser_id()));
		}
		return getWhereSQL(list);

	}
	private String getUser_id_Tag(String user_id) {
		return "room_info.user_id = '" + user_id + "'";
	}
	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getWhereSQL(ArrayList list) {
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();
		while (it.hasNext()) {
			sb.append(" and ");
			sb.append((String) it.next());
			sb.append(" ");

		}
		return sb.toString();

	}

	/**
	 * desc��asc�̐���
	 * 
	 * @param request,houseBean,houseSellSortBean,start,num
	 * @return list ����̒l
	 */
	public ArrayList<RoomBean> getRoomBeanList(	RoomSearchBean roomSearchBean, 
			int start, int num) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<RoomBean> list = new ArrayList<RoomBean>();
		StringBuffer sb = new StringBuffer();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			sb
					.append("select * from room_info, member, t_area , t_train where ");
			sb.append(" room_info.user_id=member.user_id and ");
			sb.append(" room_info.area_code_1=t_area.area_code_1 and ");
			sb.append(" room_info.area_code_2=t_area.area_code_2 and ");
			sb.append(" room_info.line_code=t_train.line_code and ");
			sb.append(" room_info.station_code=t_train.station_code and ");
			if("C10001".equals(roomSearchBean.getCate_code_1())){
				sb.append(" (room_info.room_sort=7 or room_info.room_sort=8 or room_info.room_sort=9 or room_info.room_sort=10) and ");
			} else {
				sb.append(" (room_info.room_sort=0 or room_info.room_sort=1 or room_info.room_sort=2 or room_info.room_sort=3 or room_info.room_sort=4 or room_info.room_sort=5 or room_info.room_sort=6) and ");
			}			
			sb.append(" room_info.deleteflg=0 ");
			sb.append(getWhereList(roomSearchBean));
			sb.append(" order by room_info.update_date desc limit ?,? ");

			pstmt = new LogPreparedStatement(con, sb.toString());
			pstmt.setInt(1, start - 1);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("RoomSellListHandler.getRoomBeanList" + pstmt.getQueryString());
			while (rs.next()) {

				RoomBean bean = new RoomBean();
				bean.setUser_name(Util.getShortName(Util.changeNullStr(rs
						.getString("name"))));
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setRoom_name(rs.getString("room_name"));
				bean.setRoom_sort(rs.getString("room_sort"));
				bean.setBuild_sort(rs.getString("build_sort"));
				bean.setMain_area(rs.getString("main_area"));
				bean.setArea_fast(rs.getString("area_fast"));
				bean.setCate_code_1(Util.changeNullStr(rs.getString("cate_code_1")));
				bean.setArea_code_1(Util.changeNullStr(rs.getString("area_code_1")));
				bean.setArea_code_2(Util.changeNullStr(rs.getString("area_code_2")));
				if(!"00".equals(bean.getArea_code_1())){
					bean.setArea_name_1(Util.changeNullStr(rs.getString("area_name_1")));
				}
				if(!"00".equals(bean.getArea_code_2().substring(2, 4))){
					bean.setArea_name_2(Util.changeNullStr(rs.getString("area_name_2")));
				}				
				bean.setArea_code_3(Util.changeNullStr(rs.getString("area_code_3")));
				bean.setLine_code(Util.changeNullStr(rs.getString("line_code")));
				bean.setStation_code(Util.changeNullStr(rs.getString("station_code")));
				if(!"00".equals(bean.getLine_code())){
					bean.setLine_name(Util.changeNullStr(rs.getString("line_kanji")));
				}
				if(!"00".equals(bean.getStation_code().substring(2, 4))){
					bean.setStation_name(Util.changeNullStr(rs.getString("station_kanji")));
				}
				if("C10002".equals(bean.getCate_code_1())){
					bean.setRoom_fee(Util.changePriceToMan(rs.getString("room_fee")));	
				} else {
					bean.setRoom_fee(rs.getString("room_fee"));
				}
				bean.setWalk_time(rs.getString("walk_time"));				
				bean.setFee_unit(rs.getString("fee_unit"));
				bean.setEquipment_fee(rs.getString("equipment_fee"));
				bean.setDeposit_fee(rs.getString("deposit_fee"));
				bean.setEntrance_fee(rs.getString("entrance_fee"));
				bean.setRoom_type(rs.getString("room_type"));
				bean.setSex(rs.getString("sex"));
				bean.setEmail(rs.getString("email"));
				bean.setTel_no1_1(rs.getString("tel_no1_1"));
				bean.setTel_no1_2(rs.getString("tel_no1_2"));
				bean.setTel_no1_3(rs.getString("tel_no1_3"));
				bean.setTel_no2_1(rs.getString("tel_no2_1"));
				bean.setTel_no2_2(rs.getString("tel_no2_2"));
				bean.setTel_no2_3(rs.getString("tel_no2_3"));

				bean.setPhoto_name1(rs.getString("photo_name1"));
				bean.setPhoto_name2(rs.getString("photo_name2"));
				bean.setPhoto_name3(rs.getString("photo_name3"));
				bean.setPhoto_name4(rs.getString("photo_name4"));
				bean.setPhoto_name5(rs.getString("photo_name5"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setRead_count(rs.getString("read_count"));
				bean.setDetail_info(Util.changeRnToBrTag(Util.changeNullStr(rs
						.getString("detail_info"))));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("Exception" + e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;

	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getRoomFeeTag(RoomSearchBean bean) {
		StringBuffer sb = new StringBuffer();
		int room_fee1 = 0;
		int room_fee2 = 0;
		if("C10001".equals(bean.getCate_code_1())){
			room_fee1 = Integer.parseInt(bean.getRoom_fee_from());
			room_fee2 = Integer.parseInt(bean.getRoom_fee_to());
		} else if ("C10002".equals(bean.getCate_code_1())){
			room_fee1 = Integer.parseInt(bean.getRoom_fee_from()) * 10000;
			room_fee2 = Integer.parseInt(bean.getRoom_fee_to()) * 10000;
		}
		if (!"100".equals(bean.getRoom_fee_from())) {
			sb.append(" room_info.room_fee >= " + room_fee1);
		}
		if (!"100".equals(bean.getRoom_fee_from()) && !"100".equals(bean.getRoom_fee_to())) {
			sb.append(" and ");
		}
		if (!"100".equals(bean.getRoom_fee_to())) {
			sb.append(" room_info.room_fee <= " + room_fee2);
		}

		return sb.toString();
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getAreaCode1Tag(String area_code_1) {
		return "room_info.area_code_1 = " + area_code_1;
	}

	private String getSexTag(String sex) {
		return " (room_info.sex = 2 or room_info.sex = " + sex + ")";
	}

	private String getBuild_sortTag(String build_sort) {
		return "room_info.build_sort = " + build_sort;
	}

	private String getRoom_typeTag(String room_type) {
		return "room_info.room_type = " + room_type;
	}

	private String getRoom_typeAllTag() {
		return " (room_info.room_type = 0 or room_info.room_type = 1 or room_info.room_type = 2)";
	}

	private String getBuild_sortAllTag() {
		return " (room_info.build_sort = 0 or room_info.build_sort = 1)";
	}

	private ArrayList getRoom_sortTag(RoomSearchBean bean) {
		ArrayList<String> list = new ArrayList<String>();
		if (!Util.isEmpty(bean.getRoom_sort()[0])) {
			list.add(" room_info.room_sort='0'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[1])) {
			list.add(" room_info.room_sort='1'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[2])) {
			list.add(" room_info.room_sort='2'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[3])) {
			list.add(" room_sort='3'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[4])) {
			list.add(" room_info.room_sort='4'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[5])) {
			list.add(" room_info.room_sort='5'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[6])) {
			list.add(" room_info.room_sort='6'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[7])) {
			list.add(" room_info.room_sort='7'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[8])) {
			list.add(" room_info.room_sort='8'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[9])) {
			list.add(" room_info.room_sort='9'");
		}
		if (!Util.isEmpty(bean.getRoom_sort()[10])) {
			list.add(" room_info.room_sort='10'");
		}
		return list;
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getAreaCode2Tag(String area_code_2) {
		return "room_info.area_code_2 = " + area_code_2;
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getLineCodeTag(String line_code) {
		return "room_info.line_code = " + line_code;
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getStationCodeTag(String station_code) {
		return "room_info.station_code = " + station_code;
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getRegistDateTag(String regist_date) {

		if ("0".equals(regist_date)) {
			return "room_info.update_date > DATE_SUB(CURDATE(),INTERVAL 1 DAY)";
		} else if ("1".equals(regist_date)) {
			return "room_info.update_date > DATE_SUB(CURDATE(),INTERVAL 7 DAY)";
		} else if ("2".equals(regist_date)) {
			return "room_info.update_date > DATE_SUB(CURDATE(),INTERVAL 30 DAY)";
		} else {
			return "";
		}
	}

	/**
	 * �쏐߂̃n�b�V���}�b�v��񂩂�where�߂���
	 * 
	 * @param map
	 * @return
	 */
	private String getOrSQL(ArrayList list) {
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();
		boolean isFirst = true;
		while (it.hasNext()) {
			if (isFirst) {
				isFirst = false;
				sb.append("(");
			} else {
				sb.append(" or ");
			}
			sb.append((String) it.next());
			sb.append(" ");

		}
		sb.append(")");
		return sb.toString();
	}
	
	
	/**
	 * desc��asc�̐���
	 * 
	 * @param request,houseBean,houseSellSortBean,start,num
	 * @return list ����̒l
	 */
	public ArrayList<RoomBean> getRoomBeanListTotal(PageBean pageBean, RoomSearchBean roomSearchBean) throws AppException {
		Connection con = null;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//maxCount
		int maxCount = 0;

		ArrayList<RoomBean> list = new ArrayList<RoomBean>();
		try {

			con = DBConnectionMgr.getInstance().getConnection();
			
			String countGetQuery = getCountGetQuery(roomSearchBean);
			String listGetQuery = getListGetQuery(roomSearchBean);
			
			//��ʂɕ\�����鑍�f�[�^����擾
			pstmt = new LogPreparedStatement(con, countGetQuery);
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("RoomSellListHandler.getRoomBeanListTotal1 sql= " + pstmt.getQueryString());
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
			//�y�[�W����
			PageUtil.getInstance().nextPage(pageBean, maxCount);
			
			//��ʂɕ\�����鑍�f�[�^���X�g��擾
			pstmt = new LogPreparedStatement(con, listGetQuery);
			pstmt.setInt(1, pageBean.getStartCount() - 1);
			pstmt.setInt(2, pageBean.getPageSize());
			rs = pstmt.executeQuery();
			KankokujinLogger.getInstance().debug("RoomSellListHandler.getRoomBeanListTotal2 sql=" + pstmt.getQueryString());
			
			while (rs.next()) {

				RoomBean bean = new RoomBean();
				bean.setUser_name(Util.cutLongName(5, rs.getString("name")));
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setRoom_name(rs.getString("room_name"));
				bean.setRoom_sort(rs.getString("room_sort"));
				bean.setBuild_sort(rs.getString("build_sort"));
				bean.setMain_area(rs.getString("main_area"));
				bean.setArea_fast(rs.getString("area_fast"));
				bean.setCate_code_1(Util.changeNullStr(rs.getString("cate_code_1")));
				bean.setArea_code_1(Util.changeNullStr(rs.getString("area_code_1")));
				bean.setArea_code_2(Util.changeNullStr(rs.getString("area_code_2")));
				if(!"00".equals(bean.getArea_code_1())){
					bean.setArea_name_1(Util.changeNullStr(rs.getString("area_name_1")));
				}
				if(!"00".equals(bean.getArea_code_2().substring(2, 4))){
					bean.setArea_name_2(Util.changeNullStr(rs.getString("area_name_2")));
				}				
				bean.setArea_code_3(Util.changeNullStr(rs.getString("area_code_3")));
				bean.setLine_code(Util.changeNullStr(rs.getString("line_code")));
				bean.setStation_code(Util.changeNullStr(rs.getString("station_code")));
				if(!"00".equals(bean.getLine_code())){
					bean.setLine_name(Util.changeNullStr(rs.getString("line_kanji")));
				}
				if(!"00".equals(bean.getStation_code().substring(2, 4))){
					bean.setStation_name(Util.changeNullStr(rs.getString("station_kanji")));
				}
				if("C10002".equals(bean.getCate_code_1())){
					bean.setRoom_fee(Util.changePriceToMan(rs.getString("room_fee")));	
				} else {
					bean.setRoom_fee(rs.getString("room_fee"));
				}
				bean.setWalk_time(rs.getString("walk_time"));				
				bean.setFee_unit(rs.getString("fee_unit"));
				bean.setEquipment_fee(rs.getString("equipment_fee"));
				bean.setDeposit_fee(rs.getString("deposit_fee"));
				bean.setEntrance_fee(rs.getString("entrance_fee"));
				bean.setRoom_type(rs.getString("room_type"));
				bean.setSex(rs.getString("sex"));
				bean.setEmail(rs.getString("email"));
				bean.setTel_no1_1(rs.getString("tel_no1_1"));
				bean.setTel_no1_2(rs.getString("tel_no1_2"));
				bean.setTel_no1_3(rs.getString("tel_no1_3"));
				bean.setTel_no2_1(rs.getString("tel_no2_1"));
				bean.setTel_no2_2(rs.getString("tel_no2_2"));
				bean.setTel_no2_3(rs.getString("tel_no2_3"));

				bean.setPhoto_name1(rs.getString("photo_name1"));
				bean.setPhoto_name2(rs.getString("photo_name2"));
				bean.setPhoto_name3(rs.getString("photo_name3"));
				bean.setPhoto_name4(rs.getString("photo_name4"));
				bean.setPhoto_name5(rs.getString("photo_name5"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUpdate_date(rs.getTimestamp("update_date"));
				bean.setRead_count(rs.getString("read_count"));
				bean.setDetail_info(Util.changeRnToBrTag(Util.changeNullStr(rs.getString("detail_info"))));
				list.add(bean);

			}

		} catch (SQLException e) {
			throw new AppException("SQLException" + e);

		} catch (Exception e) {
			throw new AppException("Exception" + e);

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new AppException("SQLException" + e);
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return list;

	}
	
	/**
	 * @param gourmetSearchBean
	 * @return Count��擾����SQL
	 */
	private String getCountGetQuery(RoomSearchBean roomSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from room_info, member, t_area , t_train where ");
		sb.append(" room_info.user_id=member.user_id and ");
		sb.append(" room_info.area_code_1=t_area.area_code_1 and ");
		sb.append(" room_info.area_code_2=t_area.area_code_2 and ");
		sb.append(" room_info.line_code=t_train.line_code and ");
		sb.append(" room_info.station_code=t_train.station_code and ");
		if("C10001".equals(roomSearchBean.getCate_code_1())){
			sb.append(" (room_info.room_sort=7 or room_info.room_sort=8 or room_info.room_sort=9 or room_info.room_sort=10) and ");
		} else {
			sb.append(" (room_info.room_sort=0 or room_info.room_sort=1 or room_info.room_sort=2 or room_info.room_sort=3 or room_info.room_sort=4 or room_info.room_sort=5 or room_info.room_sort=6) and ");
		}
		sb.append(" room_info.deleteflg=0 ");
		
		sb.append(getWhereList(roomSearchBean));
		
		return sb.toString();
	}
	/**
	 * @param gourmetSearchBean
	 * @return ���X�g��擾����SQL
	 */
	private String getListGetQuery(RoomSearchBean roomSearchBean) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from room_info, member, t_area , t_train where ");
		sb.append(" room_info.user_id=member.user_id and ");
		sb.append(" room_info.area_code_1=t_area.area_code_1 and ");
		sb.append(" room_info.area_code_2=t_area.area_code_2 and ");
		sb.append(" room_info.line_code=t_train.line_code and ");
		sb.append(" room_info.station_code=t_train.station_code and ");
		if("C10001".equals(roomSearchBean.getCate_code_1())){
			sb.append(" (room_info.room_sort=7 or room_info.room_sort=8 or room_info.room_sort=9 or room_info.room_sort=10) and ");
		} else {
			sb.append(" (room_info.room_sort=0 or room_info.room_sort=1 or room_info.room_sort=2 or room_info.room_sort=3 or room_info.room_sort=4 or room_info.room_sort=5 or room_info.room_sort=6) and ");
		}			
		sb.append(" room_info.deleteflg=0 ");
		sb.append(getWhereList(roomSearchBean));
		sb.append(" order by room_info.update_date desc limit ?,? ");

		
		return sb.toString();
	}


}
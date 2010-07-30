package hudousan.common;

import java.util.List;

import hudousan.bean.HudousanSearchBean;
import hudousan.bean.HudousanSortBean;
import hudousan.handler.RequestProcess;
import hudousan.handler.findroom.BuyFindRoomRequestProcess;
import hudousan.handler.findroom.BuyInitFindRoomRequestProcess;
import hudousan.handler.findroom.LeaseFindRoomRequestProcess;
import hudousan.handler.findroom.LeaseInitFindRoomRequestProcess;
import hudousan.handler.search.BuySearchBackProcess;
import hudousan.handler.search.BuySearchInitProcess;
import hudousan.handler.search.BuySearchProcess;
import hudousan.handler.search.BuySuggestInitProcess;
import hudousan.handler.search.lease.LeaseSearchBackProcess;
import hudousan.handler.search.lease.LeaseSearchInitProcess;
import hudousan.handler.search.lease.LeaseSearchProcess;
import hudousan.handler.search.lease.LeaseSearchSortProcess;
import hudousan.handler.search.lease.LeaseSuggestInitProcess;
import hudousan.handler.search.lease.LeaseSuggestProcess;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.constant.Const;
import common.util.Util;

public class HudousanUtil extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	private static final String REGIST_DATE_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
	+ Const.REGIST_DATE + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String REGIST_DATE_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.REGIST_DATE + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String ADDREES_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.AREA_CODE_1 + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String ADDREES_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.AREA_CODE_1 + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String LINE_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.LINE_CODE + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String LINE_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.LINE_CODE + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String WALK_TIME_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.WALK_TIME + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String WALK_TIME_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.WALK_TIME + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String HOUSE_FEE_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.HOUSE_FEE + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String HOUSE_FEE_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.HOUSE_FEE + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String MANAGE_FEE_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.MANAGE_FEE + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String MANAGE_FEE_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.MANAGE_FEE + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String DEPOSIT_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.DEPOSIT + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String DEPOSIT_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.DEPOSIT + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String REIKIN_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.REIKIN + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String REIKIN_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.REIKIN + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String GUARANTY_MONEY_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.GUARANTY_MONEY + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String GUARANTY_MONEY_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.GUARANTY_MONEY + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String MADORI_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.MADORI + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String MADORI_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.MADORI + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String DIMENSION_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.DIMENSION + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String DIMENSION_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.DIMENSION + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String HOUSE_SORT_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.HOUSE_SORT + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String HOUSE_SORT_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.HOUSE_SORT + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String BUILD_YEAR_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.BUILD_YEAR + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String BUILD_YEAR_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.BUILD_YEAR + Const.SPACE + Const.DESC + Const.SPACE;
	private static final String USER_ID_UP = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.USER_ID + Const.SPACE + Const.ASC + Const.SPACE;
	private static final String USER_ID_DOWN = Const.SPACE + Const.TBL_HUDOUSAN_INFO
		+ Const.USER_ID + Const.SPACE + Const.DESC + Const.SPACE;
	
	/**
	 * ���C����ʂ̐V�K�����擾����
	 * 
	 * @param bean
	 *            count���y��
	 * @return count columnIndex�̍ŏ��̗��int�Ƃ��Ď擾
	 */
	public static RequestProcess getSearchRequestProcessor( String method) {
		
		/** ���݃T�[�`�������@*/
		if (Constant.LEASE_SEARCH_INIT.equals(method)) {
			return new LeaseSearchInitProcess();
		/** ���݃T�[�`���s�@*/	
		} else if (Constant.LEASE_SEARCH.equals(method)) {
			return new LeaseSearchProcess();
		/** ���݃T�[�`�\�[�g���s�@*/
		} else if (Constant.LEASE_SEARCH_SORT.equals(method)) {
			return new LeaseSearchSortProcess();
		/** ���݂����ߏ��������s�@*/	
		} else if (Constant.LEASE_SUGGEST_INIT.equals(method)) {
			return new LeaseSuggestInitProcess();
		/** ���݂����ߎ��s�@*/
		} else if (Constant.LEASE_SUGGEST.equals(method)) {
			return new LeaseSuggestProcess();
		} else if (Constant.LEASE_SEARCH_BACK.equals(method)) {
			return new LeaseSearchBackProcess();
		} else if (Constant.BUY_SEARCH_INIT.equals(method)) {
			return new BuySearchInitProcess();
		} else if (Constant.BUY_SEARCH.equals(method)) {
			return new BuySearchProcess();
		} else if (Constant.BUY_SUGGEST_INIT.equals(method)) {
			return new BuySuggestInitProcess();
		} else if (Constant.BUY_SEARCH_BACK.equals(method)) {
			return new BuySearchBackProcess();
		}else if (Constant.BUY_SEARCH_BACK.equals(method)) {
			return new BuySearchBackProcess();
		} 

		return null;
	}
	
	/**
	 * ���C����ʂ̐V�K�����擾����
	 * 
	 * @param bean
	 *            count���y��
	 * @return count columnIndex�̍ŏ��̗��int�Ƃ��Ď擾
	 */
	public static RequestProcess getFindRoomRequestProcessor( String method) {
		
		
		if (Constant.FIND_LEASEROOM_INIT.equals(method)) {
			return new LeaseInitFindRoomRequestProcess();
		} else if (Constant.FIND_BUYROOM_INIT.equals(method)) {
			return new BuyInitFindRoomRequestProcess();
		} else if (Constant.FIND_LEASEROOM.equals(method)) {
			return new LeaseFindRoomRequestProcess();
		} else if (Constant.FIND_BUYROOM.equals(method)) {
			return new BuyFindRoomRequestProcess();
		} 

		return null;
	}
	
	
	
	public static HttpSession newCreateSession(HttpServletRequest request) {
		 /* getSession(false) �͌��݃Z�b�V���������݂��Ȃ����
		  * null ��ԋp���܂��B */	
		HttpSession session=request.getSession(false);

		/* �Z�b�V���������݂���Δj�����܂��B */
		if(session != null){
			/* �Z�b�V����session��j�� */
			session.invalidate();
		}
		session=request.getSession(true);
		
		return session;
	}
	
	
	/**
	 * 
	 * @param searchBean
	 * @param request
	 */
	public static void setSearchBean(HudousanSearchBean searchBean,
			HttpServletRequest request) {
		
		//�ƒ��E�������z�J�n
		if (!Util.isEmpty(request.getParameter("house_fee_from"))) {
			searchBean.setHouse_fee(0, request.getParameter("house_fee_from"));
		} else {
			searchBean.setHouse_fee(0, "");
		}
		//�ƒ��E�������z�I��
		if (!Util.isEmpty(request.getParameter("house_fee_to"))) {
			searchBean.setHouse_fee(1, request.getParameter("house_fee_to"));
		} else {
			searchBean.setHouse_fee(1, "");
		}
		//�n��R�[�h
		if (!Util.isEmpty(request.getParameter("search_area_code_1"))) {
			searchBean.setArea_code_1(request.getParameter("search_area_code_1"));
		}
		if ("00".equals(searchBean.getArea_code_1())) {
			searchBean.setArea_code_2("0000");
		} else {
			searchBean.setArea_code_2(Util.changeNullStr(request.getParameter("search_area_code_2")));
		}

		if (!Util.isEmpty(request.getParameter("search_line_code"))) {
			searchBean.setLine_code(request.getParameter("search_line_code"));
		}
		if (!Util.isEmpty(request.getParameter("search_station_code"))) {
			searchBean.setStation_code(request.getParameter("search_station_code"));
		}
		if (!Util.isEmpty(request.getParameter("search_walk_time"))) {
			searchBean.setWalk_time(request.getParameter("search_walk_time"));
		}
		if (!Util.isEmpty(request.getParameter("search_regist_date"))) {
			searchBean.setRegist_date(request.getParameter("search_regist_date"));
		} else {
			searchBean.setRegist_date("3");
		}
		if (!Util.isEmpty(request.getParameter("dimension_1"))) {
			searchBean.setDimension(0, request.getParameter("dimension_1"));
		}
		if (!Util.isEmpty(request.getParameter("dimension_2"))) {
			searchBean.setDimension(1, request.getParameter("dimension_2"));
		}
		searchBean.setUser_id(request.getParameter("user_id"));
		
		//�Ԏ��
		if (!Util.isEmpty(request.getParameter("madori_0"))
				&& "0".equals(request.getParameter("madori_0"))) {
			searchBean.setMadori(0, "0");
		} else {
			searchBean.setMadori(0, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_1"))
				&& "1".equals(request.getParameter("madori_1"))) {
			searchBean.setMadori(1, "1");
		} else {
			searchBean.setMadori(1, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_2"))
				&& "2".equals(request.getParameter("madori_2"))) {
			searchBean.setMadori(2, "2");
		} else {
			searchBean.setMadori(2, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_3"))
				&& "3".equals(request.getParameter("madori_3"))) {
			searchBean.setMadori(3, "3");
		} else {
			searchBean.setMadori(3, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_4"))
				&& "4".equals(request.getParameter("madori_4"))) {
			searchBean.setMadori(4, "4");
		} else {
			searchBean.setMadori(4, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_5"))
				&& "5".equals(request.getParameter("madori_5"))) {
			searchBean.setMadori(5, "5");
		} else {
			searchBean.setMadori(5, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_6"))
				&& "6".equals(request.getParameter("madori_6"))) {
			searchBean.setMadori(6, "6");
		} else {
			searchBean.setMadori(6, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_7"))
				&& "7".equals(request.getParameter("madori_7"))) {
			searchBean.setMadori(7, "7");
		} else {
			searchBean.setMadori(7, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_8"))
				&& "8".equals(request.getParameter("madori_8"))) {
			searchBean.setMadori(8, "8");
		} else {
			searchBean.setMadori(8, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_9"))
				&& "9".equals(request.getParameter("madori_9"))) {
			searchBean.setMadori(9, "9");
		} else {
			searchBean.setMadori(9, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_10"))
				&& "10".equals(request.getParameter("madori_10"))) {
			searchBean.setMadori(10, "10");
		} else {
			searchBean.setMadori(10, "");
		}
		if (!Util.isEmpty(request.getParameter("madori_11"))
				&& "11".equals(request.getParameter("madori_11"))) {
			searchBean.setMadori(11, "11");
		} else {
			searchBean.setMadori(11, "");
		}
		//��
		if (!Util.isEmpty(request.getParameter("search_flg_tadami"))) {
			searchBean.setFlg_tadami(request.getParameter("search_flg_tadami"));
		}
		//���z�N�x
		if (!Util.isEmpty(request.getParameter("search_build_year"))) {
			searchBean.setBuild_year(request.getParameter("search_build_year"));
		}
		//�g�C��
		if (!Util.isEmpty(request.getParameter("search_toilet"))) {
			searchBean.setToilet(request.getParameter("search_toilet"));
		}
		//������� 
		if (!Util.isEmpty(request.getParameter("house_sort_0"))
				&& "0".equals(request.getParameter("house_sort_0"))) {
			searchBean.setHouse_sort(0, request.getParameter("house_sort_0"));
		} else {
			searchBean.setHouse_sort(0, "");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_1"))
				&& "1".equals(request.getParameter("house_sort_1"))) {
			searchBean.setHouse_sort(1, request.getParameter("house_sort_1"));
		} else {
			searchBean.setHouse_sort(1, "");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_2"))
				&& "2".equals(request.getParameter("house_sort_2"))) {
			searchBean.setHouse_sort(2, request.getParameter("house_sort_2"));
		} else {
			searchBean.setHouse_sort(2, "");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_3"))
				&& "3".equals(request.getParameter("house_sort_3"))) {
			searchBean.setHouse_sort(3, request.getParameter("house_sort_3"));
		} else {
			searchBean.setHouse_sort(3, "");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_4"))
				&& "4".equals(request.getParameter("house_sort_4"))) {
			searchBean.setHouse_sort(4, request.getParameter("house_sort_4"));
		} else {
			searchBean.setHouse_sort(4, "");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_5"))
				&& "5".equals(request.getParameter("house_sort_5"))) {
			searchBean.setHouse_sort(5, request.getParameter("house_sort_5"));
		} else {
			searchBean.setHouse_sort(5, "");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_6"))
				&& "6".equals(request.getParameter("house_sort_6"))) {
			searchBean.setHouse_sort(6, request.getParameter("house_sort_6"));
		} else {
			searchBean.setHouse_sort(6, "");
		}
		if (!Util.isEmpty(request.getParameter("house_sort_7"))
				&& "7".equals(request.getParameter("house_sort_7"))) {
			searchBean.setHouse_sort(7, request.getParameter("house_sort_7"));
		} else {
			searchBean.setHouse_sort(7, "");
		}
		if (!Util.isEmpty(request.getParameter("pageSize"))) {
			searchBean.setPageSize(request.getParameter("pageSize"));
		}
		//����
		if (!Util.isEmpty(request.getParameter("house_option_0"))
				&& "1".equals(request.getParameter("house_option_0"))) {
			searchBean.setHouse_option(0, "1");
		} else {
			searchBean.setHouse_option(0, "");
		}
		if (!Util.isEmpty(request.getParameter("house_option_1"))
				&& "1".equals(request.getParameter("house_option_1"))) {
			searchBean.setHouse_option(1, "1");
		} else {
			searchBean.setHouse_option(1, "");
		}
		if (!Util.isEmpty(request.getParameter("house_option_2"))
				&& "1".equals(request.getParameter("house_option_2"))) {
			searchBean.setHouse_option(2, "1");
		} else {
			searchBean.setHouse_option(2, "");
		}
		if (!Util.isEmpty(request.getParameter("house_option_3"))
				&& "1".equals(request.getParameter("house_option_3"))) {
			searchBean.setHouse_option(3, "1");
		} else {
			searchBean.setHouse_option(3, "");
		}
		if ("0".equals(request.getParameter("re"))) {
			searchBean.setArea_code_2("0000");
		} else if ("1".equals(request.getParameter("re"))) {
			searchBean.setStation_code("0000");
		}
	}
	/**
	 * list��ʂ�sort�̌`��ύX����
	 * 
	 * @param sortBean
	 * @return image bean�̒l
	 */
	public static void initSort(HudousanSortBean sortBean) {
		/** �Z�� */
		sortBean.setAddress_up("0");
		sortBean.setAddress_image("jsp/images/new/up.gif");
		/** �H�� */
		sortBean.setLine_up("0");
		sortBean.setLine_image("jsp/images/new/up.gif");
		/** �k�� */
		sortBean.setWalk_up("0");
		sortBean.setWalk_image("jsp/images/new/up.gif");
		/** �ƒ��A�������z */
		sortBean.setHouseFee_up("0");
		sortBean.setHouseFee_image("jsp/images/new/up.gif");
		/** �Ǘ��� */
		sortBean.setManageFee_up("0");
		sortBean.setManageFee_image("jsp/images/new/up.gif");
		/** �~�� */
		sortBean.setDeposit_up("0");
		sortBean.setDeposit_image("jsp/images/new/up.gif");
		/** ��� */
		sortBean.setReikin_up("0");
		sortBean.setReikin_image("jsp/images/new/up.gif");
		/** �ۏ؋� */
		sortBean.setGuaranty_up("0");
		sortBean.setGuaranty_image("jsp/images/new/up.gif");
		/** �Ԏ�� */
		sortBean.setMadori_up("0");
		sortBean.setMadori_image("jsp/images/new/up.gif");
		/** �ʐ� */
		sortBean.setDimension_up("0");
		sortBean.setDimension_image("jsp/images/new/up.gif");
		/** ��� */
		sortBean.setHouseSort_up("0");
		sortBean.setHouseSort_image("jsp/images/new/up.gif");
		/** ���z�N�x */
		sortBean.setBuildDate_up("0");
		sortBean.setBuildDate_image("jsp/images/new/up.gif");
	}
	
	/**
	 * list��ʂ�sort�̌`��ύX����
	 * 
	 * @param houseSellSortBean
	 *            ��{�l��0�ň��N���b�N������`���ύX����
	 * @return image�̕ύX�ɂȂ���bean�̒l
	 */
	public static void changeSort(HudousanSortBean sortBean,
			HttpServletRequest request) {
		
		List<String> list = sortBean.getSortList();
		
		if (list.size() == 0) {
			listAdd(REGIST_DATE_DOWN, list);
		}
		
		/** �Z�����{�^�������������ꍇ */
		if (isUp(request.getParameter("address_up"))) {
			sortBean.setAddress_up("1");
			sortBean.setAddress_image("jsp/images/new/down.gif");
			listRemove(ADDREES_UP, list);
			listAdd(ADDREES_DOWN, list);
			
		}
		/** �Z�����{�^�������������ꍇ */
		if (isDown(request.getParameter("address_up"))) {
			sortBean.setAddress_up("0");
			sortBean.setAddress_image("jsp/images/new/up.gif");
			listRemove(ADDREES_DOWN, list);
			listAdd(ADDREES_UP, list);
			
		}
		
		/** �H�����{�^�������������ꍇ */
		if (isUp(request.getParameter("line_up"))) {
			sortBean.setLine_up("1");
			sortBean.setLine_image("jsp/images/new/down.gif");
			listRemove(LINE_UP, list);
			listAdd(LINE_DOWN, list);
		}
		/** �H�����{�^�������������ꍇ */
		if (isDown(request.getParameter("line_up"))) {
			sortBean.setLine_up("0");
			sortBean.setLine_image("jsp/images/new/up.gif");
			listRemove(LINE_DOWN, list);
			listAdd(LINE_UP, list);
		}
		
		/** �k�����{�^�������������ꍇ */
		if (isUp(request.getParameter("walk_up"))) {
			sortBean.setWalk_up("1");
			sortBean.setWalk_image("jsp/images/new/down.gif");
			
			listRemove(WALK_TIME_UP, list);
			listAdd(WALK_TIME_DOWN, list);
		}
		/** �k�����{�^�������������ꍇ */
		if (isDown(request.getParameter("walk_up"))) {
			sortBean.setWalk_up("0");
			sortBean.setWalk_image("jsp/images/new/up.gif");
			
			listRemove(WALK_TIME_DOWN, list);
			listAdd(WALK_TIME_UP, list);
		}
		
		/** �ƒ��A�������z���{�^�������������ꍇ */
		if (isUp(request.getParameter("houseFee_up"))) {
			sortBean.setHouseFee_up("1");
			sortBean.setHouseFee_image("jsp/images/new/down.gif");
			
			listRemove(HOUSE_FEE_UP, list);
			listAdd(HOUSE_FEE_DOWN, list);
		}
		/** �ƒ��A�������z���{�^�������������ꍇ */
		if (isDown(request.getParameter("houseFee_up"))) {
			sortBean.setHouseFee_up("0");
			sortBean.setHouseFee_image("jsp/images/new/up.gif");
			
			listRemove(HOUSE_FEE_DOWN, list);
			listAdd(HOUSE_FEE_UP, list);
		}
		
		/** �Ǘ���{�^�������������ꍇ */
		if (isUp(request.getParameter("manageFee_up"))) {
			sortBean.setManageFee_up("1");
			sortBean.setManageFee_image("jsp/images/new/down.gif");
			
			listRemove(MANAGE_FEE_UP, list);
			listAdd(MANAGE_FEE_DOWN, list);
		}
		/** �Ǘ���{�^�������������ꍇ */
		if (isDown(request.getParameter("manageFee_up"))) {
			sortBean.setManageFee_up("0");
			sortBean.setManageFee_image("jsp/images/new/up.gif");
			
			listRemove(MANAGE_FEE_DOWN, list);
			listAdd(MANAGE_FEE_UP, list);
		}
		
		/** �~�����{�^�������������ꍇ */
		if (isUp(request.getParameter("deposit_up"))) {
			sortBean.setDeposit_up("1");
			sortBean.setDeposit_image("jsp/images/new/down.gif");
			
			listRemove(DEPOSIT_UP, list);
			listAdd(DEPOSIT_DOWN, list);
		}
		/** �~�����{�^�������������ꍇ */
		if (isDown(request.getParameter("deposit_up"))) {
			sortBean.setDeposit_up("0");
			sortBean.setDeposit_image("jsp/images/new/up.gif");
			
			listRemove(DEPOSIT_DOWN, list);
			listAdd(DEPOSIT_UP, list);
		}
		
		/** ������{�^�������������ꍇ */
		if (isUp(request.getParameter("reikin_up"))) {
			sortBean.setReikin_up("1");
			sortBean.setReikin_image("jsp/images/new/down.gif");
			
			listRemove(REIKIN_UP, list);
			listAdd(REIKIN_DOWN, list);
		}
		/** ������{�^�������������ꍇ */
		if (isDown(request.getParameter("reikin_up"))) {
			sortBean.setReikin_up("0");
			sortBean.setReikin_image("jsp/images/new/up.gif");

			listRemove(REIKIN_DOWN, list);
			listAdd(REIKIN_UP, list);
		}
		
		/** �ۏ؋����{�^�������������ꍇ */
		if (isUp(request.getParameter("guaranty_up"))) {
			sortBean.setGuaranty_up("1");
			sortBean.setGuaranty_image("jsp/images/new/down.gif");
			
			listRemove(GUARANTY_MONEY_UP, list);
			listAdd(GUARANTY_MONEY_DOWN, list);
		}
		/** �ۏ؋����{�^�������������ꍇ */
		if (isDown(request.getParameter("guaranty_up"))) {
			sortBean.setGuaranty_up("0");
			sortBean.setGuaranty_image("jsp/images/new/up.gif");

			listRemove(GUARANTY_MONEY_DOWN, list);
			listAdd(GUARANTY_MONEY_UP, list);
		}
		
		/** �Ԏ�聪�{�^�������������ꍇ */
		if (isUp(request.getParameter("madori_up"))) {
			sortBean.setMadori_up("1");
			sortBean.setMadori_image("jsp/images/new/down.gif");
			
			listRemove(MADORI_UP, list);
			listAdd(MADORI_DOWN, list);
		}
		/** �Ԏ�聫�{�^�������������ꍇ */
		if (isDown(request.getParameter("madori_up"))) {
			sortBean.setMadori_up("0");
			sortBean.setMadori_image("jsp/images/new/up.gif");

			listRemove(MADORI_DOWN, list);
			listAdd(MADORI_UP, list);
		}
		
		/** �ʐρ��{�^�������������ꍇ */
		if (isUp(request.getParameter("dimension_up"))) {
			sortBean.setDimension_up("1");
			sortBean.setDimension_image("jsp/images/new/down.gif");
			
			listRemove(DIMENSION_UP, list);
			listAdd(DIMENSION_DOWN, list);
		}
		/** �ʐρ��{�^�������������ꍇ */
		if (isDown(request.getParameter("dimension_up"))) {
			sortBean.setDimension_up("0");
			sortBean.setDimension_image("jsp/images/new/up.gif");
			listRemove(DIMENSION_DOWN, list);
			listAdd(DIMENSION_UP, list);
		}
		
		/** ��ށ��{�^�������������ꍇ */
		if (isUp(request.getParameter("houseSort_up"))) {
			sortBean.setHouseSort_up("1");
			sortBean.setHouseSort_image("jsp/images/new/down.gif");
			
			listRemove(HOUSE_SORT_UP, list);
			listAdd(HOUSE_SORT_DOWN, list);
		}
		/** ��ށ��{�^�������������ꍇ */
		if (isDown(request.getParameter("houseSort_up"))) {
			sortBean.setHouseSort_up("0");
			sortBean.setHouseSort_image("jsp/images/new/up.gif");
			
			listRemove(HOUSE_SORT_DOWN, list);
			listAdd(HOUSE_SORT_UP, list);
		}
		
		/** ���z�N�x���{�^�������������ꍇ */
		if (isUp(request.getParameter("buildDate_up"))) {
			sortBean.setBuildDate_up("1");
			sortBean.setBuildDate_image("jsp/images/new/down.gif");
			
			listRemove(BUILD_YEAR_UP, list);
			listAdd(BUILD_YEAR_DOWN, list);
		}
		/** ���z�N�x���{�^�������������ꍇ */
		if (isDown(request.getParameter("buildDate_up"))) {
			sortBean.setBuildDate_up("0");
			sortBean.setBuildDate_image("jsp/images/new/up.gif");
			listRemove(BUILD_YEAR_DOWN, list);
			listAdd(BUILD_YEAR_UP, list);
		}
		
		
	}
	
	/**
	 * 
	 */
	private static void listRemove(String value, List list) {
		if (list.contains(value)) {
			list.remove(value);
		}
	}
	
	/**
	 * 
	 */
	private static void listAdd(String value, List list) {
		if (!list.contains(value)) {
			list.add(value);
		}
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	private static boolean isUp(String param) {
		if (!Util.isEmpty(param)
				&& "0".equals(param)) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	private static boolean isDown(String param) {
		if (!Util.isEmpty(param)
				&& "1".equals(param)) {
			return true;
		}
		return false;
		
	}
}

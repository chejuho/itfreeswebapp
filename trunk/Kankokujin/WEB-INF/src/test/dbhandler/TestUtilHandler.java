package test.dbhandler;

import java.util.HashMap;

import junit.framework.TestCase;

import common.handler.UtilHandler;

public class TestUtilHandler extends TestCase {
//	public void testGetArea1Info(){
//		UtilHandler util = new UtilHandler();
//		ArrayList list = util.getArea1Info();
//		Iterator it = list.iterator();
//		while (it.hasNext()) {
//			AreaBean bean = (AreaBean)it.next();
//			System.out.println(bean.getArea_code_1() + bean.getArea_name_1());
//		}
//	}
//	
//	public void testGetArea2Info(){
//		UtilHandler util = new UtilHandler();
//		ArrayList list = util.getArea2Info("01");
//		Iterator it = list.iterator();
//		while (it.hasNext()) {
//			AreaBean bean = (AreaBean)it.next();
//			System.out.println(bean.getArea_code_2() + bean.getArea_name_2());
//		}
//	}
//	
//	public void testGetTrainLineInfo(){
//		UtilHandler util = new UtilHandler();
//		ArrayList list = util.getTrainLineInfo();
//		Iterator it = list.iterator();
//		while (it.hasNext()) {
//			TrainBean bean = (TrainBean)it.next();
//			System.out.println(bean.getLine_code() + bean.getLine_kanji());
//		}
//	}
//	
//	public void testGetStationInfoList(){
//		UtilHandler util = new UtilHandler();
//		ArrayList list = util.getStationInfoList("0101");
//		Iterator it = list.iterator();
//		while (it.hasNext()) {
//			TrainBean bean = (TrainBean)it.next();
//			System.out.println(bean.getStation_code() + bean.getStation_kanji());
//		}
//	}
	
//	public void testGetWhereList01(){
//		UtilHandler util = new UtilHandler();
//		HashMap map = new HashMap();
//		map.put("house_fee_from", "50000");
//		map.put("house_fee_to", "100000");
//		
//		System.out.println("sql=" + util.getWhereList(map));
//	}
	
	public void testGetWhereList02(){
		UtilHandler util = new UtilHandler();
		HashMap map = new HashMap();
		map.put("house_sort_0", "1");
		map.put("house_sort_3", "4");
		map.put("house_sort_5", "6");
		map.put("house_sort_7", "8");
		map.put("house_fee_from","50000");
		map.put("house_fee_to", "100000");
		map.put("area_code_1","01");
		map.put("area_code_2","0101");
		
		map.put("walk_time","5");
		map.put("dimension_1","10000");
		map.put("dimension_2","20000");
		map.put("madori_1","1");
		map.put("madori_2","2");
		map.put("madori_6","6");
		map.put("madori_10","10");
		map.put("build_yaer","3");
		map.put("all_stairs","10");
		map.put("stairs","5");
		map.put("flg_tadami","2");
		map.put("toilet","2");
		map.put("regist_date","7");
		
		
		//System.out.println("sql=" + util.getWhereList(map));
	}
}

package common.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import main.handler.NewWriteHandler;

import common.constant.Const;
import common.database.DBConnectionMgr;
import common.exception.AppException;
import common.exception.SysException;
import common.handler.InitServletHandler;
import common.logger.KankokujinLogger;

/** 
 * 機能：Tomcatが起動する時初期化作業を行う
 * 
 */
public class InitServletAction implements ServletContextListener {

	
	/** 
	 * Tomcatが開始する際に実行される
	 * Contant情報、地域情報、交通ライン情報をXMLファイル情報を
	 * Propertiesオブジェクトに変換してServletContext情報に格納
	 */
	public void contextInitialized(ServletContextEvent event) {
		
		KankokujinLogger.getInstance().debug("InitServletAction start");
		
		ServletContext ctx = event.getServletContext();
		InitServletHandler initServletHandler = InitServletHandler.getInstance();
		SortedMap  area1InfoMap = null;
		SortedMap  area2InfoMap = null;
		SortedMap  lineInfoMap = null;
		SortedMap  stationInfoMap = null;
		SortedMap  buysellCategory1Map = null;
		SortedMap  buysellCategory2Map = null;	
		SortedMap  storeCategory1Map = null;
		SortedMap  storeCategory2Map = null;
		SortedMap  gourmetCategory1Map = null;
		SortedMap  gourmetCategory2Map = null;	
		SortedMap  jobCategory1Map = null;
		SortedMap  jobCategory2Map = null;	
		
		Connection con = null;
		/** 新しいカテゴリデータを格納するMap */
		Map  areaInfoMap = null;	
		Map  trainInfoMap = null;	
		Map  buysellCategoryMap = null;
		Map  storeCategoryyMap = null;
		Map  gourmetCategoryMap = null;
		Map  jobCategoryMap = null;
		
		List bannerList1 = null;
		List bannerList2 = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			areaInfoMap = initServletHandler.readAreaCodeToMap(con);
			trainInfoMap = initServletHandler.readTrainCodeToMap(con);
			buysellCategoryMap = initServletHandler.readCategoryCodeToMap(con, Const.TABLE_NAME_BUYSELL_CATEGORY);
			storeCategoryyMap = initServletHandler.readCategoryCodeToMap(con, Const.TABLE_NAME_STORE_CATEGORY);
			gourmetCategoryMap = initServletHandler.readCategoryCodeToMap(con, Const.TABLE_NAME_GOURMET_CATEGORY);
			jobCategoryMap = initServletHandler.readCategoryCodeToMap(con, Const.TABLE_NAME_JOB_CATEGORY);
			
			area1InfoMap = initServletHandler.getArea1Info(con);
			area2InfoMap = initServletHandler.getArea2Info(con);
			lineInfoMap = initServletHandler.getTrainLineInfo(con);
			stationInfoMap = initServletHandler.getStationInfoList(con);
			buysellCategory1Map = initServletHandler.getCate1Info(con, Const.TABLE_NAME_BUYSELL_CATEGORY);
			buysellCategory2Map = initServletHandler.getCate2Info(con, Const.TABLE_NAME_BUYSELL_CATEGORY);			
			storeCategory1Map = initServletHandler.getCate1Info(con, Const.TABLE_NAME_STORE_CATEGORY);
			storeCategory2Map = initServletHandler.getCate2Info(con, Const.TABLE_NAME_STORE_CATEGORY);
			gourmetCategory1Map = initServletHandler.getCate1Info(con, Const.TABLE_NAME_GOURMET_CATEGORY);
			gourmetCategory2Map = initServletHandler.getCate2Info(con, Const.TABLE_NAME_GOURMET_CATEGORY);
			jobCategory1Map = initServletHandler.getCate1Info(con, Const.TABLE_NAME_JOB_CATEGORY);
			jobCategory2Map = initServletHandler.getCate2Info(con, Const.TABLE_NAME_JOB_CATEGORY);
			
			bannerList1 = initServletHandler.getInstance().getBannerList(con, "1");
			bannerList2 = initServletHandler.getInstance().getBannerList(con, "2");
		} catch (SysException e) {
			area1InfoMap = new TreeMap();
			area2InfoMap = new TreeMap();
			lineInfoMap = new TreeMap();
			stationInfoMap = new TreeMap();
			buysellCategory1Map = new TreeMap();
			buysellCategory2Map = new TreeMap();			
			storeCategory1Map = new TreeMap();
			storeCategory2Map = new TreeMap();
			gourmetCategory1Map = new TreeMap();
			gourmetCategory2Map = new TreeMap();
			jobCategory1Map = new TreeMap();
			jobCategory2Map = new TreeMap();
		} catch (AppException e) {
			bannerList1 = new ArrayList();
			bannerList2 = new ArrayList();
		}
		/** 新しいカテゴリデータをコンテキストに格納する */
		ctx.setAttribute("Area", areaInfoMap);
		ctx.setAttribute("Train", trainInfoMap);
		ctx.setAttribute("BuySellCategory", buysellCategoryMap);
		ctx.setAttribute("StoreCategory", storeCategoryyMap);
		ctx.setAttribute("GourmetCategory", gourmetCategoryMap);
		ctx.setAttribute("JobCategory", jobCategoryMap);
		
		
		ctx.setAttribute("Area1", area1InfoMap);
		ctx.setAttribute("Area2", area2InfoMap);

		ctx.setAttribute("Line", lineInfoMap);
		ctx.setAttribute("Station", stationInfoMap);
		ctx.setAttribute("BuySellCategory1", buysellCategory1Map);
		ctx.setAttribute("BuySellCategory2", buysellCategory2Map);
		ctx.setAttribute("StoreCategory1", storeCategory1Map);
		ctx.setAttribute("StoreCategory2", storeCategory2Map);		
		ctx.setAttribute("GourmetCategory1", gourmetCategory1Map);
		ctx.setAttribute("GourmetCategory2", gourmetCategory2Map);
		ctx.setAttribute("JobCategory1", jobCategory1Map);
		ctx.setAttribute("JobCategory2", jobCategory2Map);
		
		ctx.setAttribute("BannerList1", bannerList1);
		ctx.setAttribute("BannerList2", bannerList2);
		
	}
	/** 
	 * Tomcatが終了する際に実行される
	 * だたログだけ出力
	 */
	public void contextDestroyed(ServletContextEvent event) {
		KankokujinLogger.getInstance().debug("InitServletAction end");
		
	}
}

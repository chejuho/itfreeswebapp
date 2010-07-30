package common.batch.url;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.AppException;


public class RealEstateInfoAcquisition {

	private final static int YAHOO = 0;
	private final static int ATHOME = 1;
	
	private Connection con_ = null;

	private URLReader reader = null;

	public static void main(String[] args) throws Exception {

		String yahooURL = "http://rent.realestate.yahoo.co.jp/bin/rsearch?md=geo&lc=03&pf=13&geo=13104&from=0&to=0&wlk=0&spfrom=0&spto=0&yr=0&nc=0&submit.x=122&submit.y=21&submit=%A4%B3%A4%CE%BE%F2%B7%EF%A4%C7%B8%A1%BA%F7";
		String atHome = "http://www.athome.co.jp/%E6%96%B0%E5%AE%BF%E5%8C%BA/kr_01-1_12_13-lst_13104";
		
		
		RealEstateInfoAcquisition acquisition = new RealEstateInfoAcquisition();
		//int insertCnt1 = acquisition.executeListAll(yahooURL , YAHOO);
		int insertCnt2 = acquisition.executeListAll(atHome , ATHOME);
		
		
		
		//System.out.println("insert Count=" + insertCnt1);
		//System.out.println(acquisition.getMaxCount(yahoo_YamateSenURL));
	}

	/**
	 * 
	 * @param urlstr
	 * @param sort
	 * @return
	 */
	public int executeListAll(String urlstr, int sort) {
		
		
		String pageKbn = null;
		String pageEnd = null;
		int pageInc = 0;
		int pageNo = 0;
		if (sort == YAHOO) {
			pageKbn = "&b=";
			pageNo = 0;
			pageEnd = "";
			pageInc = 20;
		//_2.html
		} else if (sort == ATHOME) {
			pageKbn = "_";
			pageNo = 1;
			pageInc = 1;
			pageEnd = ".html";
		} 
		
		while (true) {
			List<Map<String, String>> list = null;
			try {
				String pageUrl = urlstr + pageKbn + pageNo + pageEnd;
				System.out.println(pageUrl);
				//resultList.addAll(executeYahooList(pageUrl));
				if (sort == YAHOO) {
					list = executeYahooList(pageUrl);
				} else if (sort == ATHOME) {
					list = executeAthomeList(pageUrl);
				}
				insertExecute(list);
				pageNo += pageInc;
			} catch (AppException e) {
				e.printStackTrace();
				break;
			} finally {
				list = null;
				Runtime rt = Runtime.getRuntime();
				long totalmemory = rt.totalMemory();
				long freememory = rt.freeMemory();
				long heapsize = rt.totalMemory()-rt.freeMemory();
				System.out.println("total=" + totalmemory + ",free=" + freememory+ ",heap=" + heapsize);
			}
		}
		return pageNo;
		
	}
	
	private List<Map<String, String>> executeYahooList(String urlstr) throws AppException {

		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		WebSearchInputBean bean = new WebSearchInputBean();
		URLReader reader = new URLReader();

		URL url = null;
		String html = null;
		String body = null;
		List<String> lineList = null;
		

		try {
			url = new URL(urlstr);
			html = reader.readHtml(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

		bean.setKey("body");
		bean.setStartKey("<th scope=\"col\" class=\"checkbox\">選択</th>");
		bean.setEndKey("<div id=\"ichiran-bottom\">");
		bean.setStartOffset(0);
		bean.setEndOffset(0);

		// Body取得
		body = getTextSearchResult(html, bean);

		bean.setKey("line");
		bean.setStartKey("<tr>\n<td class=\"photo\" id=\"col");
		bean.setEndKey("</tr>");
		bean.setStartOffset(0);
		bean.setEndOffset(0);

		// テーブルRow取得
		lineList = getTextSearchResultList(body, bean);

		
		if (lineList.size() == 0) {
			//検索ができない場合
			throw new AppException("Search Not Found");
		}
		
		for (Iterator<String> iterator = lineList.iterator(); iterator.hasNext();) {
			Map<String, String> dataMap = new HashMap<String, String>();
			String line = (String) iterator.next();
			
			line = line.replaceAll("<br[^>]*>", "_");

			//ID取得
			bean.setKey("id");
			bean.setStartKey("<td class=\"checkbox\"><input name=\"id\" type=\"checkbox\"");
			bean.setEndKey("onclick=\"check_detail(this);\" ></td>");
			bean.setStartOffset(61);
			bean.setEndOffset(-38);
			
			String searchId = getTextSearchResult(line, bean);
			// System.out.println(searchAddress);
			
			String id = getElement(searchId);
			
			dataMap.put("info_id", id);
			
			// 家賃,管理費
			bean.setKey("yatinn");
			bean.setStartKey("<td id=\"col4");
			bean.setEndKey("</td>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchYatinn = getTextSearchResult(line, bean);
			String houseFeeAll = getElement(searchYatinn);
			// System.out.println(searchAddress);
			
			String house_fee = houseFeeAll.substring(0, houseFeeAll.indexOf("_") - 2);
			String manage_fee = houseFeeAll.substring(houseFeeAll.indexOf("_") + 1, houseFeeAll.length());
			dataMap.put("house_fee", DataTransferHandler.getHouseFee(house_fee));
			dataMap.put("manage_fee", DataTransferHandler.getManage_fee(manage_fee));
			
			//敷金,礼金
			bean.setKey("sikikinn");
			bean.setStartKey("<td id=\"col5");
			bean.setEndKey("</td>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchSikikinReikin = getTextSearchResult(line, bean);
			String sikikinReikin = getElement(searchSikikinReikin);
			
			String sikikin = sikikinReikin.substring(0, sikikinReikin.indexOf("_"));
			String reikin = sikikinReikin.substring(sikikinReikin.indexOf("_") + 1, sikikinReikin.length());
			
			StringBuffer detail = new StringBuffer();
			
			if (sikikin.matches("\\dか月")) {
				dataMap.put("deposit", DataTransferHandler.getNumberOnly(sikikin));
			} else {
				detail.append("敷金 : ");
				detail.append(sikikin);
				detail.append("<br>");
				
			}
			
			if (reikin.matches("\\dか月.*")) {
				dataMap.put("reikin", DataTransferHandler.getNumberOnly(reikin));
			} else {
				detail.append("礼金 : ");
				detail.append(reikin);
				detail.append("<br>");
			}
			
			// 距離
			bean.setKey("distance");
			bean.setStartKey("<td class=\"distance\"");
			bean.setEndKey("</td>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchDistance = getTextSearchResult(line, bean);
			String distance = getElement(searchDistance);
			dataMap.put("walk_time", distance.substring(distance.indexOf("_") + 1, distance.length() - 1));

			// 間取り、専有面積
			bean.setKey("size");
			bean.setStartKey("<td id=\"col6");
			bean.setEndKey("</td>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchSize = getTextSearchResult(line, bean);
			String size = getElement(searchSize);
			dataMap.put("madori", DataTransferHandler.getMadori(size.substring(0, size.indexOf("_"))));
			dataMap.put("dimension", size.substring(size.indexOf("_") + 1, size.length() - 3));
			
			// 築年月
			bean.setKey("build_year_month");
			bean.setStartKey("<td id=\"col7");
			bean.setEndKey("</td>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchBuildInfo = getTextSearchResult(line, bean);
			String buildInfo = getElement(searchBuildInfo);
			//dataMap.put("build_year_month", buildInfo.substring(0, buildInfo.indexOf("_")));
			//dataMap.put("build_", buildInfo.substring(buildInfo.indexOf("_") + 1, buildInfo.length() - 1));
			
			if (buildInfo.indexOf("/") == -1) {
				dataMap.put("build_year", "");
				dataMap.put("build_month", "");
			} else {
				dataMap.put("build_year", buildInfo.substring(1, buildInfo.indexOf("/")));
				dataMap.put("build_month", buildInfo.substring(buildInfo.indexOf("/") + 1, buildInfo.indexOf("/") + 3));
			}

			//詳細情報取得
			try {
				Map<String, String> detailMap =  executeYahooDetail(id);
				String detailStr = detailMap.get("detail");
				detailMap.put("detail", detail.toString() + detailStr);
				dataMap.putAll(detailMap);
				resultList.add(dataMap);
			} catch (AppException e) {
				System.out.println("取得失敗：http://rent.realestate.yahoo.co.jp/bin/dsearch?id=" + id);
			}
		}

		// Body取得
		// String body = searchList.get(0);

		return resultList;
	}
	
	
	private List<Map<String, String>> executeAthomeList(String urlstr) throws AppException {
		
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		WebSearchInputBean bean = new WebSearchInputBean();
		URLReader reader = new URLReader();

		URL url = null;
		String encoding = null;
		String html = null;
		String body = null;
		List<String> lineList = null;
		
		try {
			url = new URL(urlstr);
			encoding = reader.getCharSet(url);
			html = reader.readHtml(url, encoding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bean.setKey("body");
		bean.setStartKey("<span id=\"sortcombo_1_dummy\" class=\"dummySelectBox\"></span>");
		bean.setEndKey("<div class=\"innerArea\" style=\"background-image:none; margin-bottom:0\">");
		bean.setStartOffset(0);
		bean.setEndOffset(0);

		// Body取得
		body = getTextSearchResult(html, bean);

		bean.setKey("line");
		bean.setStartKey("<ul class=\"icons\">");
		bean.setEndKey("<td colspan=\"6\" class=\"estate \" id=\"estate");
		bean.setStartOffset(0);
		bean.setEndOffset(0);

		// テーブルRow取得
		lineList = getTextSearchResultList(body, bean);

		
		if (lineList.size() == 0) {
			//検索ができない場合
			throw new AppException("Search Not Found");
		}
		
		for (Iterator<String> iterator = lineList.iterator(); iterator.hasNext();) {
			Map<String, String> dataMap = new HashMap<String, String>();
			String line = (String) iterator.next();
			
			line = line.replaceAll("<br[^>]*>", "_");
			
			//link取得
			bean.setKey("detailLink");
			bean.setStartKey("<a target=\"_blank\" href=");
			bean.setEndKey("onclick=\"addEturanImg");
			bean.setStartOffset(25);
			bean.setEndOffset(-23);
			
			String searchDetailLink = getTextSearchResult(line, bean);
			String detailLink = getElement(searchDetailLink);
			
			dataMap.put("detail_url", detailLink);
			
			
			//id取得
			bean.setKey("id");
			bean.setStartKey("<td rowspan=\"3\" class=\"action\"  onclick='setRowSelected(\"");
			bean.setEndKey("\");' style=\"width:6%;\">");
			bean.setStartOffset(57);
			bean.setEndOffset(-23);
			
			String id = getTextSearchResult(line, bean);
			
			dataMap.put("info_id", id);
			
			// 家賃
			bean.setKey("yatinn");
			bean.setStartKey("<p class=\"price\">");
			bean.setEndKey("</strong><span>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchYatinn = getTextSearchResult(line, bean);
			// System.out.println(searchAddress);
			
			//管理費
			bean.setKey("manageFee");
			bean.setStartKey("<p class=\"upkeep\">");
			bean.setEndKey("</p>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);
			
			String searchManageFee = getTextSearchResult(line, bean);
			String house_fee = getElement(DataTransferHandler.removeLnKara(searchYatinn));
			String manage_fee = getElement(searchManageFee);
			dataMap.put("house_fee", DataTransferHandler.getHouseFee(house_fee));
			dataMap.put("manage_fee", DataTransferHandler.getManage_fee(manage_fee));
			
			//敷金
			bean.setKey("sikikinn");
			bean.setStartKey("<p class=\"deposit\">");
			bean.setEndKey("</td>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchSikikin = getTextSearchResult(line, bean);
			String sikikin = getElement(searchSikikin);
			
			
			
			//礼金
			bean.setKey("reikinn");
			bean.setStartKey("<p class=\"reward\">");
			bean.setEndKey("</p>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);
			
			String searchReikin = getTextSearchResult(line, bean);
			String reikin = getElement(searchReikin);
			
			sikikin = sikikin.substring(0, sikikin.indexOf("/"));
	
			StringBuffer detail = new StringBuffer();
			
			if (sikikin.matches("\\dヶ月.*")) {
				dataMap.put("deposit", DataTransferHandler.getNumberOnly(sikikin));
			} else {
				detail.append("敷金 : ");
				detail.append(sikikin);
				detail.append("<br>");
				
			}
			
			if (reikin.matches("\\dヶ月.*")) {
				dataMap.put("reikin", DataTransferHandler.getNumberOnly(reikin));
			} else {
				detail.append("礼金 : ");
				detail.append(reikin);
				detail.append("<br>");
			}
			
			// 距離
			bean.setKey("distance");
			bean.setStartKey("<p class=\"walk\">");
			bean.setEndKey("</p>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchDistance = getTextSearchResult(line, bean);
			String distance = getElement(searchDistance);

			dataMap.put("walk_time", DataTransferHandler.getNumberOnly(distance));

			// 間取り
			bean.setKey("size");
			bean.setStartKey("<p class=\"layout\">");
			bean.setEndKey("</p>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchSize = getTextSearchResult(line, bean);
			String size = getElement(searchSize);
	
			dataMap.put("madori", DataTransferHandler.getMadori(size));
			
			//専有面積
			bean.setKey("dimension");
			bean.setStartKey("<p class=\"area\">");
			bean.setEndKey("</p>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchDimension = getTextSearchResult(line, bean);
			String dimension = getElement(searchDimension);
	
			
			if (dimension.indexOf("m&sup2") == -1) {
				dataMap.put("dimension", "0");
			} else {
				dataMap.put("dimension", dimension.substring(dimension.indexOf("m&sup2") - 6, dimension.indexOf("m&sup2")).replaceAll(" ", ""));
			}
			
			
			
			// 築年月
			bean.setKey("build_year_month");
			bean.setStartKey("<p class=\"completion\">");
			bean.setEndKey("</p>");
			bean.setStartOffset(0);
			bean.setEndOffset(0);

			String searchBuildInfo = getTextSearchResult(line, bean);
			String buildInfo = getElement(searchBuildInfo);
			//dataMap.put("build_year_month", buildInfo.substring(0, buildInfo.indexOf("_")));
			//dataMap.put("build_", buildInfo.substring(buildInfo.indexOf("_") + 1, buildInfo.length() - 1));
			
			if (buildInfo.indexOf("年") == -1) {
				dataMap.put("build_year", "");
				dataMap.put("build_month", "");
			} else {
				dataMap.put("build_year", buildInfo.substring(0, buildInfo.indexOf("年")));
				
				if (buildInfo.indexOf("月") == -1) {
					dataMap.put("build_month", "");
				} else {
					dataMap.put("build_month", buildInfo.substring(buildInfo.indexOf("年") + 1, buildInfo.indexOf("月")));
				}
				
				
			}

			//詳細情報取得
			try {
				Map<String, String> detailMap =  executeAthomeDetail(detailLink);
				String detailStr = detailMap.get("detail");
				detailMap.put("detail", detail.toString() + detailStr);
				dataMap.putAll(detailMap);
				resultList.add(dataMap);
			} catch (AppException e) {
				System.out.println("取得失敗：" + detailLink);
			}
		}

		// Body取得
		// String body = searchList.get(0);

		return resultList;
		
	}
	
	/**
	 * 
	 * @param hudouasnBeanList
	 */
	public void insertExecute(List<Map<String, String>> hudouasnBeanList) {
		try {
			con_ = DBConnectionMgr.getInstance().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int insertCnt = 0;
		for (Iterator<Map<String, String>> it = hudouasnBeanList.iterator(); it.hasNext();) {

			Map<String, String> bean = it.next();

			// データが存在するかを確認
			boolean existSign = isDataExist(con_, bean, 2);

			// データが存在しない場合
			if (!existSign) {
				insertBean(con_, bean);
				++insertCnt;
				System.out.println("insert件数:"+ insertCnt);
				// データが存在する場合
			} else {
				// データが修正した場合
				// if (isDataEdited(dbBean, bean)) {
				updateBean(con_, bean);
				// }
			}
		}
		//deleteProcess(con_);

		DBConnectionMgr.getInstance().freeConnection(con_);
		//System.out.println("完了");
	}

	/**
	 * 
	 * @param con
	 * @param bean
	 * @return
	 */
	private int updateBean(Connection con, Map<String, String> bean) {

		LogPreparedStatement pstmt = null;
		int result = 0;
		StringBuffer query = new StringBuffer();
		query.append("update house_info set ");
		query.append("info_id = ?, house_fee = ?, manage_fee = ?, deposit=?, reikin=?, walk_time=?, madori=?, dimension=?,");
		query.append("build_year = ?, build_month = ?, detail_url = ?, house_name=?, flg_tadami=?, point_compass=?, all_stairs=?, stairs=?,");
		query.append("come_dock = ?, detail_info = ?, info_company_id = ?, info_acquisition_site=?, area_code_1=?, area_code_2=?, area_code_3=?,");
		query.append("station_code = ?, line_code = ?, house_sort = ?, user_id=?, update_date= now() where info_id = ?");
		try {
			pstmt = new LogPreparedStatement(con, query.toString());
			pstmt.setString(1, bean.get("info_id"));
			pstmt.setString(2, bean.get("house_fee"));
			pstmt.setString(3, bean.get("manage_fee"));
			pstmt.setString(4, nullToZero(bean.get("deposit")));
			pstmt.setString(5, nullToZero(bean.get("reikin")));
			pstmt.setString(6, bean.get("walk_time"));
			pstmt.setString(7, bean.get("madori"));
			pstmt.setString(8, bean.get("dimension"));
			pstmt.setString(9, bean.get("build_year"));
			pstmt.setString(10, bean.get("build_month"));
			pstmt.setString(11, bean.get("detail_url"));
			pstmt.setString(12, bean.get("house_name"));
			//pstmt.setString(13, bean.get("flg_tadami"));
			pstmt.setString(13, bean.get("0"));
			pstmt.setString(14, bean.get("point_compass"));
			pstmt.setString(15, bean.get("all_stairs"));
			pstmt.setString(16, bean.get("stairs"));
			pstmt.setString(17, bean.get("come_dock"));
			pstmt.setString(18, bean.get("detail"));
			pstmt.setString(19, "1");
			pstmt.setString(20, bean.get("info_acquisition_site"));
			pstmt.setString(21, bean.get("area_code_1"));
			pstmt.setString(22, bean.get("area_code_2"));
			pstmt.setString(23, bean.get("area_code_3"));
			pstmt.setString(24, bean.get("station_code"));
			pstmt.setString(25, bean.get("line_code"));
			pstmt.setString(26, bean.get("house_sort"));
			pstmt.setString(27, "sallamang");
			pstmt.setString(28, bean.get("info_id"));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	
	private int getMaxCount(String urlStr) throws AppException {
		
		WebSearchInputBean bean = new WebSearchInputBean();
		URLReader reader = new URLReader();
		
		URL url = null;
		String encoding = null;
		String html = null;
		String resultCnt = null;
		
		try {
			url = new URL(urlStr);
			encoding = reader.getCharSet(url);
			html = reader.readHtml(url, encoding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		bean.setKey("body");
		bean.setStartKey("<span class=\"all\" id=\"count_total_top\">");
		bean.setEndKey("</span>");
		bean.setStartOffset(39);
		bean.setEndOffset(-7);
		
		resultCnt = getTextSearchResult(html, bean);
		return Integer.parseInt(resultCnt.replaceAll(",", ""));
		
	}
	
	private Map<String, String> executeAthomeDetail(String urlstr) throws AppException  {
		
		//
		//System.out.println(urlstr);
		// 物件詳細
		WebSearchInputBean bean = new WebSearchInputBean();
		URLReader reader = new URLReader();

		URL url = null;
		String html = null;
		String body = null;
		Map<String, String> dataMap = null;

		try {
			url = new URL(urlstr);
			html = reader.readHtml(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection refused=" + urlstr);
			throw new AppException("NOT FOUNT PAGE");
		}

		dataMap = new HashMap<String, String>();

		bean.setKey("body");
		bean.setStartKey("<tbody>");
		bean.setEndKey("</div><!--/wrapLeft -->");
		bean.setStartOffset(0);
		bean.setEndOffset(0);

		// Body取得
		try {
			body = getTextSearchResult(html, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("body取得失敗");
			throw new AppException("NOT FOUNT INDEX");
		}

		bean.setKey("line");
		bean.setStartKey("<tr class=\"");
		bean.setEndKey("</tr>");
		bean.setStartOffset(0);
		bean.setEndOffset(0);

		//建物種類
		bean.setKey("house_sort");
		bean.setStartKey("<p class=\"type\">");
		bean.setEndKey("</p>");
		bean.setStartOffset(0);
		bean.setEndOffset(0);
		
		String house_sort = null;
		try {
			house_sort = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("house_sort取得失敗");
			throw new AppException("NOT FOUNT INDEX");
		}
		dataMap.put("house_sort", DataTransferHandler.getHouseSort(getElement(house_sort)));

		// 所在地
		bean.setKey("address");
		bean.setStartKey("<p class=\"add\">");
		bean.setEndKey("</p>");
		bean.setStartOffset(0);
		bean.setEndOffset(0);

		String searchAddress = null;
		try {
			searchAddress = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("Address取得失敗");
			throw new AppException("NOT FOUNT INDEX");
		}
		// System.out.println(searchAddress);
		dataMap.putAll(DataTransferHandler.getAreaCode(getElement(searchAddress)));
		
		// 交通
		bean.setKey("traffic");
		bean.setStartKey("<p class=\"station\">");
		bean.setEndKey("</span>");
		bean.setStartOffset(0);
		bean.setEndOffset(-0);

		String searchTraffic = null;
		try {
			searchTraffic = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("Traffic取得失敗");
			throw new AppException("NOT FOUNT INDEX");
		}

		
		dataMap.putAll(DataTransferHandler.getTrainInfo(getElement(searchTraffic)));
		
		
		// 建物名
		bean.setKey("name");
		bean.setStartKey("<th scope=\"row\">建物名</th>");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\">建物名</th>".length());
		bean.setEndOffset(0);

		String searchName = null;
		try {
			searchName = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("建物名取得失敗");
			throw new AppException("NOT FOUNT INDEX");
		}
		dataMap.put("house_name", getElement(searchName.replace("&nbsp;", "")));
		
		
		// 方位なし

		// 建物階/所在階
		bean.setKey("stairsInfo");
		bean.setStartKey("<th scope=\"row\">階建 / 階</th>");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\">階建 / 階</th>".length());
		bean.setEndOffset(0);

		String searchStairsInfo = null;
		try {
			searchStairsInfo = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("建物階/所在階取得失敗");
			throw new AppException("NOT FOUNT INDEX");
		}

		String stairsInfo = DataTransferHandler.removeLnKara(getElement(searchStairsInfo));
		
		if (stairsInfo.indexOf("/") != -1) {
			dataMap.put("all_stairs", DataTransferHandler.getNumberOnly(stairsInfo.substring(0, stairsInfo.indexOf("/"))));
			dataMap.put("stairs", DataTransferHandler.getNumberOnly(stairsInfo.substring(stairsInfo.indexOf("/"), stairsInfo.length())));
		}
		// 構造
//		bean.setKey("structure");
//		bean.setStartKey("<th scope=\"row\">構造</th><td>");
//		bean.setEndKey("</td>");
//		bean.setStartOffset("<th scope=\"row\">構造</th><td>".length());
//		bean.setEndOffset(-5);
//
//		String searchStructure = getTextSearchResult(body, bean);
//
//		dataMap.put("searchStructure", searchStructure);

		// 駐車場
//		bean.setKey("carPark");
//		bean.setStartKey("<th scope=\"row\" class=\"col2\">駐車場</th><td>");
//		bean.setEndKey("</td>");
//		bean.setStartOffset("<th scope=\"row\" class=\"col2\">駐車場</th><td>"
//				.length());
//		bean.setEndOffset(-5);
//
//		String searchCarPark = getTextSearchResult(body, bean);
//
//		dataMap.put("searchCarPark", searchCarPark);

		// 条件等
//		bean.setKey("condition");
//		bean.setStartKey("<th scope=\"row\">条件等</th><td>");
//		bean.setEndKey("</td>");
//		bean.setStartOffset("<th scope=\"row\">条件等</th><td>".length());
//		bean.setEndOffset(-5);
//
//		String searchCondition = getTextSearchResult(body, bean);
//
//		dataMap.put("searchCondition", searchCondition);

		// 契約期間
//		bean.setKey("contract");
//		bean.setStartKey("<th scope=\"row\" class=\"col2\">契約期間</th><td>");
//		bean.setEndKey("</td>");
//		bean.setStartOffset("<th scope=\"row\">条件等</th><td>".length());
//		bean.setEndOffset(-5);
//
//		String searchContract = getTextSearchResult(body, bean);
//
//		dataMap.put("searchContract", searchContract);

		// 入居可能時期
		bean.setKey("entrancePossibleTime");
		bean.setStartKey("<th scope=\"row\">入居日</th>");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\">入居日</th>".length());
		bean.setEndOffset(-5);

		String searchEntrancePossibleTime = null;
		try {
			searchEntrancePossibleTime = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("入居可能時期取得失敗");
			throw new AppException("NOT FOUNT INDEX");
		}
		String comeDock = DataTransferHandler.getComeDock(searchEntrancePossibleTime);
		dataMap.put("come_dock", comeDock);
		
		// 特記事項,設備,備考
		StringBuffer detail = new StringBuffer();
		
		//特記事項なし
		//設備なし
		//おすすめPOINT
		bean.setKey("detail");
		bean.setStartKey("alt=\"おすすめPOINT\" /><strong>");
		bean.setEndKey("</strong>");
		bean.setStartOffset("alt=\"おすすめPOINT\" /><strong>".length());
		bean.setEndOffset(-9);

		String searchRemark = null;
		try {
			searchRemark = getTextSearchResult(body, bean);
		} catch (AppException e) {
			searchRemark = "";
		}

		detail.append("おすすめPOINT: ");
		detail.append(searchRemark);
		
		
		/* マッチできないデータをDetailに書く*/
		
		if (!comeDock.equals("0")) {
			detail.append("<br>");
			detail.append("入居可能時期　: ");
			detail.append(searchEntrancePossibleTime);
		}
		dataMap.put("detail", detail.toString());
		
		//問い合わせ先なし
		
		//情報取得サイト
		dataMap.put("info_acquisition_site", "athome");

		return dataMap;
	}
	
	
	
	private Map<String, String> executeYahooDetail(String id) throws AppException {

		//
		String urlstr = "http://rent.realestate.yahoo.co.jp/bin/dsearch?id=" + id;
		//System.out.println(urlstr);
		// 物件詳細
		WebSearchInputBean bean = new WebSearchInputBean();
		URLReader reader = new URLReader();

		URL url = null;
		String encoding = null;
		String html = null;
		String body = null;
		Map<String, String> dataMap = null;

		try {
			url = new URL(urlstr);
			encoding = reader.getCharSet(url);
			html = reader.readHtml(url, encoding);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection refused=" + urlstr);
			throw new AppException("NOT FOUNT PAGE");
		}

		dataMap = new HashMap<String, String>();

		bean.setKey("body");
		bean.setStartKey("<div id=\"info-basic\">");
		bean.setEndKey("</div><!--/#info-detail end-->");
		bean.setStartOffset(0);
		bean.setEndOffset(0);

		// Body取得
		try {
			body = getTextSearchResult(html, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("Body取得失敗");
			throw new AppException("NOT FOUNT Index");
		}

		bean.setKey("line");
		bean.setStartKey("<tr class=\"");
		bean.setEndKey("</tr>");
		bean.setStartOffset(0);
		bean.setEndOffset(0);

		//詳細URL
		dataMap.put("detail_url", urlstr);
		//建物種類
		bean.setKey("house_sort");
		bean.setStartKey("<span class=\"howtogo\">");
		bean.setEndKey("</div><!--/#info-basic end-->");
		bean.setStartOffset(0);
		bean.setEndOffset(0);
		
		String house_sort;
		try {
			house_sort = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("建物種類取得失敗");
			throw new AppException("NOT FOUNT Index");
		}
		dataMap.put("house_sort", DataTransferHandler.getHouseSort(getElement(house_sort)));

		// 所在地
		bean.setKey("address");
		bean.setStartKey("<th scope=\"row\">所在地</th><td colspan=\"3\">");
		bean.setEndKey("</td>");
		bean.setStartOffset(40);
		bean.setEndOffset(-5);

		String searchAddress;
		try {
			searchAddress = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("所在地取得失敗");
			throw new AppException("NOT FOUNT Index");
		}
		// System.out.println(searchAddress);
		dataMap.putAll(DataTransferHandler.getAreaCode(searchAddress));
		
		// 交通
		bean.setKey("traffic");
		bean.setStartKey("<td class=\"td-align\">");
		bean.setEndKey("<br><span class=\"howtogo\">");
		bean.setStartOffset(21);
		bean.setEndOffset(-27);

		String searchTraffic;
		try {
			searchTraffic = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("交通取得失敗");
			throw new AppException("NOT FOUNT Index");
		}
		
		if (searchTraffic.indexOf("<br>") >= 0) {
			searchTraffic = searchTraffic.substring(0, searchTraffic.indexOf("<br>"));
		}
		
		dataMap.putAll(DataTransferHandler.getTrainInfo(getElement(searchTraffic)));
		// 建物名
		bean.setKey("name");
		bean.setStartKey("<th scope=\"row\">建物名</th><td class=\"adjuster\">");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\">建物名</th><td class=\"adjuster\">"
				.length());
		bean.setEndOffset(-5);

		String searchName;
		try {
			searchName = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("建物名取得失敗");
			throw new AppException("NOT FOUNT Index");
		}

		dataMap.put("house_name", searchName);

		// 間取りの内訳
		bean.setKey("madori");
		bean.setStartKey("<th scope=\"row\" class=\"col2\">間取りの内訳</th><td class=\"adjuster\">");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\" class=\"col2\">間取りの内訳</th><td class=\"adjuster\">".length());
		bean.setEndOffset(-5);

		String searchMadori;
		try {
			searchMadori = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("間取りの内訳取得失敗");
			throw new AppException("NOT FOUNT Index");
		}

		dataMap.put("flg_tadami", searchMadori);

		// 方位
		bean.setKey("compass");
		bean.setStartKey("<th scope=\"row\">方位</th><td>");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\">方位</th><td>".length());
		bean.setEndOffset(-5);

		String searchCompass = null;
		try {
			searchCompass = getTextSearchResult(body, bean);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataMap.put("point_compass", DataTransferHandler.getCompass(searchCompass));

		// 建物階/所在階
		bean.setKey("stairsInfo");
		bean.setStartKey("<th scope=\"row\" class=\"col2\">建物階/所在階</th><td>");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\" class=\"col2\">建物階/所在階</th><td>".length());
		bean.setEndOffset(-5);

		String searchStairsInfo = null;
		try {
			searchStairsInfo = getTextSearchResult(body, bean);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (searchStairsInfo.indexOf("/") != -1) {
			dataMap.put("all_stairs", DataTransferHandler.getStairs(searchStairsInfo.substring(0, searchStairsInfo.indexOf("/"))));
			dataMap.put("stairs", DataTransferHandler.getStairs(searchStairsInfo.substring(searchStairsInfo.indexOf("/") + 1, searchStairsInfo.length())));

		}
		
		// 構造
//		bean.setKey("structure");
//		bean.setStartKey("<th scope=\"row\">構造</th><td>");
//		bean.setEndKey("</td>");
//		bean.setStartOffset("<th scope=\"row\">構造</th><td>".length());
//		bean.setEndOffset(-5);
//
//		String searchStructure = getTextSearchResult(body, bean);
//
//		dataMap.put("searchStructure", searchStructure);

		// 駐車場
//		bean.setKey("carPark");
//		bean.setStartKey("<th scope=\"row\" class=\"col2\">駐車場</th><td>");
//		bean.setEndKey("</td>");
//		bean.setStartOffset("<th scope=\"row\" class=\"col2\">駐車場</th><td>"
//				.length());
//		bean.setEndOffset(-5);
//
//		String searchCarPark = getTextSearchResult(body, bean);
//
//		dataMap.put("searchCarPark", searchCarPark);

		// 条件等
//		bean.setKey("condition");
//		bean.setStartKey("<th scope=\"row\">条件等</th><td>");
//		bean.setEndKey("</td>");
//		bean.setStartOffset("<th scope=\"row\">条件等</th><td>".length());
//		bean.setEndOffset(-5);
//
//		String searchCondition = getTextSearchResult(body, bean);
//
//		dataMap.put("searchCondition", searchCondition);

		// 契約期間
//		bean.setKey("contract");
//		bean.setStartKey("<th scope=\"row\" class=\"col2\">契約期間</th><td>");
//		bean.setEndKey("</td>");
//		bean.setStartOffset("<th scope=\"row\">条件等</th><td>".length());
//		bean.setEndOffset(-5);
//
//		String searchContract = getTextSearchResult(body, bean);
//
//		dataMap.put("searchContract", searchContract);

		// 入居可能時期
		bean.setKey("entrancePossibleTime");
		bean.setStartKey("<th scope=\"row\">入居可能時期</th><td>");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\">入居可能時期</th><td>".length());
		bean.setEndOffset(-5);

		String searchEntrancePossibleTime = null;
		try {
			searchEntrancePossibleTime = getTextSearchResult(body, bean);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String comeDock = DataTransferHandler.getComeDock(searchEntrancePossibleTime);
		dataMap.put("come_dock", comeDock);
		
		// 特記事項,設備,備考
		StringBuffer detail = new StringBuffer();
		
		//特記事項
		bean.setKey("detail");
		bean.setStartKey("<th scope=\"row\">特記事項</th><td colspan=\"3\">");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\">特記事項</th><td colspan=\"3\">".length());
		bean.setEndOffset(-5);

		String searchParticularNote;
		try {
			searchParticularNote = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("特記事項取得失敗");
			throw new AppException("NOT FOUNT Index");
		}

		//設備
		bean.setKey("detail");
		bean.setStartKey("<th scope=\"row\">設備</th><td colspan=\"3\">");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\">設備</th><td colspan=\"3\">".length());
		bean.setEndOffset(-5);

		String searchFacilities;
		try {
			searchFacilities = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("設備取得失敗");
			throw new AppException("NOT FOUNT Index");
		}
		
		//備考
		bean.setKey("detail");
		bean.setStartKey("<th scope=\"row\">備考</th><td colspan=\"3\">");
		bean.setEndKey("</td>");
		bean.setStartOffset("<th scope=\"row\">備考</th><td colspan=\"3\">".length());
		bean.setEndOffset(-5);

		String searchRemark;
		try {
			searchRemark = getTextSearchResult(body, bean);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println("備考取得失敗");
			throw new AppException("NOT FOUNT Index");
		}

		detail.append("特記事項 : ");
		detail.append(getElement(searchParticularNote));
		detail.append("<br>");
		detail.append("設備 : ");
		detail.append(getElement(searchFacilities));
		detail.append("<br>");
		detail.append("備考 : ");
		detail.append(getElement(searchRemark));
		
		/* マッチできないデータをDetailに書く*/
		
		if (!comeDock.equals("0")) {
			detail.append("<br>");
			detail.append("入居可能時期　: ");
			detail.append(searchEntrancePossibleTime);
		}
		dataMap.put("detail", detail.toString());
		
		//問い合わせ先
		bean.setKey("info_company");
		bean.setStartKey("<th scope=\"row\">問い合わせ先</th>");
		bean.setEndKey("<input type=\"image\"");
		bean.setStartOffset(0);
		bean.setEndOffset(0);
		
		String searchInfoCompany = null;
		try {
			searchInfoCompany = getTextSearchResult(body, bean);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataMap.put("info_company", DataTransferHandler.getCompanyName(getElement(searchInfoCompany)));
		
		//情報取得サイト
		dataMap.put("info_acquisition_site", "yahoo");

		return dataMap;
	}
	
	public String getElement(String html) {

		String editHtml = html;
		return editHtml.replaceAll("<(\"[^\"]*\"|'[^']*'|[^'\">])*>", "");
	}

	/**
	 * 
	 * @param key
	 * @param startKey
	 * @param endKey
	 * @return
	 */
	// public Map<String, List<String>> getWebData(
	// String key,
	// String startKey,
	// String endKey) {
	// return null;
	// }

	/**
	 * 
	 * @param html
	 * @param key
	 * @param startKey
	 * @param endKey
	 * @param startOffset
	 * @param endOffset
	 * @return
	 */
	public Map<String, List<String>> getWebSearchData(String html,
			List<WebSearchInputBean> beanList) {

		// 取得データ
		Map<String, List<String>> webData = new HashMap<String, List<String>>();

		for (Iterator<WebSearchInputBean> it = beanList.iterator(); it
				.hasNext();) {

			WebSearchInputBean bean = it.next();
			List<String> searchResult = getTextSearchResultList(html, bean);
			webData.put(bean.getKey(), searchResult);

		}
		return webData;
	}

	
	
	public List<String> getTextSearchResultList(String editHtml,
			WebSearchInputBean bean) {

		String startKey = bean.getStartKey();
		String endKey = bean.getEndKey();
		int startOffset = bean.getStartOffset();
		int endOffset = bean.getEndOffset();

		// String editHtml = html;
		// 取得データリスト
		List<String> linkDataList = new ArrayList<String>();

		for (int startSearchIndex = 0, endSearchIndex = 0; (startSearchIndex = editHtml.indexOf(startKey)) >= 0;) {

			// 開始以降から検索
			editHtml = editHtml.substring(startSearchIndex, editHtml.length());

			endSearchIndex = editHtml.indexOf(endKey);

			int startSeachMatchIndex = editHtml.indexOf(startKey) + startOffset;
			int endSeachMatchIndex = endSearchIndex + endKey.length()
					+ endOffset;

			// 検索結果
			String search = editHtml.substring(startSeachMatchIndex, endSeachMatchIndex);
			linkDataList.add(search);

			// 検索したものは使わない
			editHtml = editHtml.substring(endSearchIndex, editHtml.length());
		}

		return linkDataList;
	}

	public String getTextSearchResult(String editHtml, WebSearchInputBean bean) throws AppException {

		String startKey = bean.getStartKey();
		String endKey = bean.getEndKey();
		int startOffset = bean.getStartOffset();
		int endOffset = bean.getEndOffset();

		// String editHtml = html;

		int startSearchIndex = editHtml.indexOf(startKey);
		
		//検索ができない場合
		if (startSearchIndex == -1) {
			throw new AppException("Search Not Found");
		}
		
		// 開始以降から検索
		editHtml = editHtml.substring(startSearchIndex, editHtml.length());
		int endSearchIndex = editHtml.indexOf(endKey);

		//検索ができない場合
		if (endSearchIndex == -1) {
			throw new AppException("Search Not Found");
		}
		
		int startSeachMatchIndex = editHtml.indexOf(startKey) + startOffset;
		int endSeachMatchIndex = endSearchIndex + endKey.length() + endOffset;

		// 検索結果
		return editHtml.substring(startSeachMatchIndex, endSeachMatchIndex);
	}

	private int deleteProcess(Connection con) {
		LogPreparedStatement pstmt = null;
		int result = 0;
		StringBuffer query = new StringBuffer();
		query.append("update house_info set delete_flag = 1 where date_format(update_date ,'%Y-%m-%d') < date_format(CURRENT_TIMESTAMP, '%Y-%m-%d')");
		try {
			pstmt = new LogPreparedStatement(con, query.toString());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	/**
	 * 
	 * @param con
	 * @param bean
	 * @return
	 */
	private int insertBean(Connection con, Map<String, String> bean) {

		LogPreparedStatement pstmt = null;
		int result = 0;
		StringBuffer query = new StringBuffer();
		query.append("insert into house_info (");
		query.append("info_id,house_fee,manage_fee,deposit,reikin,walk_time,madori,dimension,build_year,build_month,detail_url,");
		query.append("house_name,flg_tadami,point_compass,all_stairs,stairs,come_dock,detail_info,info_company_id,info_acquisition_site,");
		query.append("area_code_1, area_code_2, area_code_3, station_code, line_code, house_sort, user_id,");
		query.append("regist_date,update_date");
		query.append(") values (");
		query.append("?,?,?,?,?,?,?,?,?,?," +
				     "?,?,?,?,?,?,?,?,?,?," +
				     "?,?,?,?,?,?,?," +
				     "now(), now())");
		try {
			pstmt = new LogPreparedStatement(con, query.toString());
			pstmt.setString(1, bean.get("info_id"));
			pstmt.setString(2, bean.get("house_fee"));
			pstmt.setString(3, bean.get("manage_fee"));
			pstmt.setString(4, nullToZero(bean.get("deposit")));
			pstmt.setString(5, nullToZero(bean.get("reikin")));
			pstmt.setString(6, bean.get("walk_time"));
			pstmt.setString(7, bean.get("madori"));
			pstmt.setString(8, bean.get("dimension"));
			pstmt.setString(9, bean.get("build_year"));
			pstmt.setString(10, bean.get("build_month"));
			pstmt.setString(11, bean.get("detail_url"));
			pstmt.setString(12, bean.get("house_name"));
			//pstmt.setString(13, bean.get("flg_tadami"));
			pstmt.setString(13, bean.get("0"));
			pstmt.setString(14, bean.get("point_compass"));
			pstmt.setString(15, bean.get("all_stairs"));
			pstmt.setString(16, bean.get("stairs"));
			pstmt.setString(17, bean.get("come_dock"));
			pstmt.setString(18, bean.get("detail"));
			pstmt.setString(19, "1");
			pstmt.setString(20, bean.get("info_acquisition_site"));
			pstmt.setString(21, bean.get("area_code_1"));
			pstmt.setString(22, bean.get("area_code_2"));
			pstmt.setString(23, bean.get("area_code_3"));
			pstmt.setString(24, bean.get("station_code"));
			pstmt.setString(25, bean.get("line_code"));
			pstmt.setString(26, bean.get("house_sort"));
			pstmt.setString(27, "sallamang");
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			result = 0;
			System.out.println(pstmt.getQueryString());
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	

	/**
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	private boolean isDataExist(Connection con, Map<String, String> bean, int level) {

		boolean exist = false;
		LogPreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer idCheckQuery = new StringBuffer();
		StringBuffer dataCheckQuery = new StringBuffer();
		
		//IDだけ確認
		idCheckQuery.append("select * from house_info where info_id = ?");

		//データ確認
		dataCheckQuery.append("select * from house_info where ");
		dataCheckQuery.append("house_fee = ? and manage_fee = ? and deposit = ? and ");
		dataCheckQuery.append("reikin = ? and walk_time = ? and madori = ? and dimension = ? and ");
		dataCheckQuery.append("build_year = ? and build_month = ? and area_code_1 = ? and area_code_2 = ? and ");
		dataCheckQuery.append("station_code = ? and line_code = ? ");
		
		try {
			pstmt = new LogPreparedStatement(con, idCheckQuery.toString());
			pstmt.setString(1, bean.get("info_id"));
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				exist = true;
				//System.out.println("存在");
			}
			
			//IDだけ確認
			if (level == 1) {
				return exist;
			}
			//データ確認
			if (level == 2) {
				//idが存在場合
				if (exist) {
					return exist;
				//idが存在しない場合 データチェックを行う
				} else {
					pstmt = new LogPreparedStatement(con, dataCheckQuery.toString());
					pstmt.setString(1, bean.get("house_fee"));
					pstmt.setString(2, bean.get("manage_fee"));
					pstmt.setString(3, nullToZero(bean.get("deposit")));
					pstmt.setString(4, nullToZero(bean.get("reikin")));
					pstmt.setString(5, bean.get("walk_time"));
					pstmt.setString(6, bean.get("madori"));
					pstmt.setString(7, bean.get("dimension"));
					pstmt.setString(8, bean.get("build_year"));
					pstmt.setString(9, bean.get("build_month"));
					pstmt.setString(10, bean.get("area_code_1"));
					pstmt.setString(11, bean.get("area_code_2"));
					pstmt.setString(12, bean.get("station_code"));
					pstmt.setString(13, bean.get("line_code"));
					rs = pstmt.executeQuery();
					if (rs.next()) {
						exist = true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return exist;
	}

	private String nullToZero(String str) {
		return (str == null) ? "0" : str;
	}
	
	
	private void print(List<Map<String, String>> list) {
		for (Iterator<Map<String, String>> it = list.iterator(); it.hasNext();) {
			Map<String, String> line = it.next();

			for (Iterator<Map.Entry<String, String>> itmap = line.entrySet()
					.iterator(); itmap.hasNext();) {
				Map.Entry<String, String> map = itmap.next();
				System.out.print(map.getKey());
				System.out.print("=");
				System.out.print(map.getValue());
				System.out.print(",");

			}
			System.out.println();
		}
	}

	

}

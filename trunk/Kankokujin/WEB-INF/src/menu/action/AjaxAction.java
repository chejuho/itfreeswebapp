package menu.action;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.AppException;
import common.exception.SysException;
import common.handler.UtilHandler;
import common.util.Util;

public class AjaxAction extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		
		
		String areacode1 = request.getParameter("areaCode1");
		String line = request.getParameter("lineCode");
		
		
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"), true);
		String param = request.getParameter("param");
		String result = null;
		System.out.println("sign="+param);
		
		
		if ("Search".equals(param)) {
			
			result = getAllInfo(areacode1, line);
		}
		
		if ("areaInfo".equals(param)) {
			
			result = getCategoryInfo(areacode1, "Area");
		}
		
		if ("stationInfo".equals(param)) {
			
			result = getCategoryInfo(line, "Train");
		}
		
//		if ("category".equals(param)) {
//			String cate1 = request.getParameter("cate1");
//			String cate2 = request.getParameter("cate2");
//			String cate3 = request.getParameter("cate3");
//			result = getCategoryInfo(line, "Train");
//		}
		
		out.println(result);

	}
	
	/** 新しいカテゴリBeanを利用する*/
	private String getAllInfo(String areacode, String line) {
		
		if (Util.isEmpty(areacode)) {
			areacode = "00";
		}
		if (Util.isEmpty(line)) {
			line = "00";
		}
		
		StringBuffer sb = new StringBuffer();
		Map areaInfoMap = (SortedMap) getServletContext().getAttribute("Area");
		Map trainInfoMap = (SortedMap) getServletContext().getAttribute("Train");
		
		sb.append(UtilHandler.getJSONData(areaInfoMap)).append("<i>");
		sb.append(UtilHandler.getJSONData(areaInfoMap, areacode)).append("<i>");
		sb.append(UtilHandler.getJSONData(trainInfoMap)).append("<i>");
		sb.append(UtilHandler.getJSONData(trainInfoMap, line));
		return sb.toString();
	}
	
	
	/** 新しいカテゴリBeanを利用する*/
	private String getCategoryInfo(String code, String category_name) {
		
		StringBuffer sb = new StringBuffer();
		Map infoMap = (SortedMap) getServletContext().getAttribute(category_name);
		sb.append(UtilHandler.getJSONData(infoMap, code));
		return sb.toString();
	}
	
	
	private String getInit(String areacode1, String line) {
		

		if (Util.isEmpty(areacode1)) {
			areacode1 = "";
		}
		if (Util.isEmpty(line)) {
			line = "";
		}
		
		StringBuffer sb = new StringBuffer();
		SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
		SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
		SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
		SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
		try {
			sb.append(UtilHandler.getArea1Name(area1InfoMap)).append("<i>");
			sb.append(UtilHandler.getArea2Name(areacode1, area2InfoMap)).append("<i>");
			sb.append(UtilHandler.getTrainLineName(lineInfoMap)).append("<i>");
			sb.append(UtilHandler.getStationName(line, stationInfoMap));
		} catch (SysException e) {
			e.printStackTrace();
		} catch (AppException e) {
			e.printStackTrace();
		} 
		
		return sb.toString();
	}
	
	private String getAreaInfo(String areacode) {
		StringBuilder sb = new StringBuilder();
		SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
		try {
			sb.append(UtilHandler.getArea2Name(areacode, area2InfoMap));
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
	private String getStationInfo(String linecode) {
		
		StringBuilder sb = new StringBuilder();
		SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
		try {
			sb.append(UtilHandler.getStationName(linecode, stationInfoMap));
		}  catch (AppException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return sb.toString();
	}

	

	
	
	
	private String getInitTag() {
		StringBuilder sb = new StringBuilder();
		SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
		SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
		SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
		SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
		try {
			sb.append(UtilHandler.getArea1Name(area1InfoMap));
//		} catch (AppException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} 
		
		return sb.toString();
	}
	
	private String getSearch(String areacode1, String areacode2, String line, String station) {
		StringBuilder sb = new StringBuilder();
		SortedMap area1InfoMap = (SortedMap) getServletContext().getAttribute("Area1");
		SortedMap area2InfoMap = (SortedMap) getServletContext().getAttribute("Area2");
		SortedMap lineInfoMap = (SortedMap) getServletContext().getAttribute("Line");
		SortedMap stationInfoMap = (SortedMap) getServletContext().getAttribute("Station");
		try {
			sb.append(UtilHandler.getArea1TagFromMap(areacode1, area1InfoMap)).append("<i>");
			sb.append(UtilHandler.getArea2TagFromMap(areacode1, areacode2, area2InfoMap)).append("<i>");
			sb.append(UtilHandler.getTrainLineTagFromMap(line, lineInfoMap)).append("<i>");
			sb.append(UtilHandler.getStationTagFromMap(line, station, stationInfoMap));
//		} catch (AppException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
		} catch (SysException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (AppException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	

}

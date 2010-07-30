package common.batch.insertdata;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import common.exception.AppException;
import common.util.EnDecoding;
import common.database.DBConnectionMgr;


import bean.StockBean;
import bean.StockCodeURLBean;

/*
 * Created on 2006. 6. 29.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InsertStockInfo {
	//select count(*) from stockinfo where stockdate > DATE_ADD(now(), INTERVAL -1 day)
	//delete from stockinfo where stockdate > DATE_ADD(now(), INTERVAL -1 day)
//	String END_PRICE = "";
//	String COMPARE_YEST = "";
//	String SELL= "";
//	String BUY = "";
//	String START_PRICE = "";
//	String HIGH_PRICE = "";
//	String LOW_PRICE = "";
	
	String END_PRICE = "終値</font></td>";
	String COMPARE_YEST = "前日比</font></td>";
	String SELL= "売気配</font></td>";
	String BUY = "買気配</font></td>";
	String START_PRICE = "始値</font></td>";
	String HIGH_PRICE = "高値</font></td>";
	String LOW_PRICE = "安値</font></td>";
	
	private boolean isStarted = false;
	private StockBean stockBean;
	int endPriceIndex = 0;
	int compareYestIndex = 0;
	int sellIndex = 0;
	int buyIndex = 0;
	int startPriceIndex = 0;
	int highPriceIndex = 0;
	int lowPriceIndex = 0;
	public static void main(String[] args) {

		InsertStockInfo stock = new InsertStockInfo();
//		List paramlist = stock.getExcelParam();
//		Iterator it = paramlist.iterator();
//		stock.END_PRICE =(String)it.next();
//		stock.COMPARE_YEST =(String)it.next();
//		stock.SELL =(String)it.next();
//		stock.BUY =(String)it.next();
//		stock.START_PRICE =(String)it.next();
//		stock.HIGH_PRICE =(String)it.next();
//		stock.LOW_PRICE =(String)it.next();
		stock.excute();

	}
	
	/*
	 * ｸﾞﾀﾎ ｸﾞｼﾒ??
	 */
	private void excute () {
		String filePath = "C://batch//excel//stock.xls";
		List list = getExcelData(filePath);
		Iterator it = list.iterator();
		int count = 0;
		while (it.hasNext()) {
			StockCodeURLBean bean = (StockCodeURLBean)it.next();
			insertStockInfo(bean.getCode(), bean.getUrl());
			System.out.println("count=" + ++count );
		}
		//insertStockInfo("","");
		
	}
	
	/*
	 * ﾄｫﾅﾗｰ昤ｮ ｸﾞｴｺｸｮｽｺﾆｮｸｦ  ﾅﾂｱﾗｷﾎ ｺｯ??
	 * @param map ﾄｫﾅﾗｰ昤ｮ ｸﾞｴｺｸｮｽｺﾆｮ
	 * @return ﾄｫﾅﾗｰ昤ｮｸﾞｴｺﾅﾂｱﾗ 
	 */
	private void getInfoValue(List list, String tempStr) {


		try {
			if (!isStarted) {
//				System.out.println("1=" + tempStr);
//				System.out.println("2=" + EnDecoding.encoding(END_PRICE));
				
				endPriceIndex = tempStr.indexOf(END_PRICE);
				compareYestIndex = tempStr.indexOf(COMPARE_YEST);
				sellIndex = tempStr.indexOf(SELL);
				buyIndex = tempStr.indexOf(BUY);
				startPriceIndex = tempStr.indexOf(START_PRICE);
				highPriceIndex = tempStr.indexOf(HIGH_PRICE);
				lowPriceIndex = tempStr.indexOf(LOW_PRICE);
//				System.out.println("endPriceIndex= " + endPriceIndex + ", compareYestIndex= " + compareYestIndex 
//						+ ", sellIndex= " + sellIndex 
//						+ ", buyIndex= " + buyIndex 
//						+ ", startPriceIndex= " + startPriceIndex 
//						+ ", highPriceIndex= " + highPriceIndex 
//						+ ", lowPriceIndex= " + lowPriceIndex );
				if (endPriceIndex != -1 || compareYestIndex != -1 || sellIndex != -1 
						|| buyIndex != -1 || startPriceIndex != -1 || highPriceIndex != -1
						|| lowPriceIndex != -1) {
					isStarted = true;
				}
				
			} else if (isStarted) {
				tempStr = tempStr.replaceAll("\"", "\'");
				int start = tempStr.indexOf("<font color=");
				int end = tempStr.indexOf("</font></td>");
				if (endPriceIndex != -1) {
					stockBean = new StockBean();
					stockBean.setEndPrice(tempStr.substring(start + 22, end));
				} else if (compareYestIndex != -1){
					stockBean.setCompareYest(tempStr.substring(start + 22, end));
				} else if (sellIndex != -1){
					stockBean.setSell(tempStr.substring(start + 22, end));
				} else if (buyIndex != -1){
					stockBean.setBuy(tempStr.substring(start + 22, end));
				} else if (startPriceIndex != -1){
					stockBean.setStartPrice(tempStr.substring(start + 22, end));
				} else if (highPriceIndex != -1){
					stockBean.setHighPrice(tempStr.substring(start + 22, end));
				} else if (lowPriceIndex != -1){
					stockBean.setLowPrice(tempStr.substring(start + 22, end));
					list.add(stockBean);
				}
				endPriceIndex = 0;
				compareYestIndex = 0;
				sellIndex = 0;
				buyIndex = 0;
				startPriceIndex = 0;
				highPriceIndex = 0;
				lowPriceIndex = 0;
				//list.add(tempStr.substring(start + 22, end));
				isStarted = false;
			}
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	/*
	 * insert Stock info into DB
	 * @param list Stock info list
	 */
	private void insertIntoStockDB(String code, List list) {
		Iterator it = list.iterator();
		while (it.hasNext()) {
			StringBuffer sb = new StringBuffer();
			StockBean bean = (StockBean)it.next();
			sb.append("insert into stockinfo ");
			sb.append(" (code, endprice, compareyest, sell, buy, startprice, highprice, lowprice, stockdate) ");
			sb.append(" values ");
			sb.append(" ( '");
			sb.append(code);
			sb.append("','");		
			sb.append(bean.getEndPrice());
			sb.append("','");
			sb.append(bean.getCompareYest());
			sb.append("','");
			sb.append(bean.getSell());
			sb.append("','");
			sb.append(bean.getBuy());
			sb.append("','");
			sb.append(bean.getStartPrice());
			sb.append("','");
			sb.append(bean.getHighPrice());
			sb.append("','");
			sb.append(bean.getLowPrice());
			sb.append("',now())");
			insertSQL(sb.toString());
		}
	}
	
	private boolean insertSQL(String sql) {

		Connection con = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			Statement stmt = con.createStatement();
			//System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert failed");
			
		} catch (AppException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}
		return false;
	}
	
	private void insertStockInfo(String code, String urlStr) {
//		urlStr = "http://www.stockweather.co.jp/sw/mei/79/7974T1a.html";
		URL url;
		InputStream is = null;
		List list = new ArrayList();
		//String code = "test";
		//System.out.println("urlStr=" + urlStr);
		try {
			url = new URL(urlStr);
			is = url.openStream();
			BufferedReader br
	          = new BufferedReader(new InputStreamReader(new BufferedInputStream(is)));

			//while (br.ready()) {
			while (br.read() != -1) {
				String tempStr = br.readLine();
				//String tempStr = new String(br.readLine().getBytes("8859_1"),"Shift_JIS");
				//String tempStr = new String(br.readLine().getBytes("Shift_JIS"),"8859_1");
				//String tempStr = new String(br.readLine().getBytes("Shift_JIS"),"UTF-8");
				//String tempStr = new String(br.readLine().getBytes("Shift_JIS"),"UTF-8");
				//String tempStr = new String(br.readLine().getBytes("iso-8859-1"),"Shift_JIS");
				//String tempStr = new String(br.readLine().getBytes("Shift_JIS"),"JISAutoDetect");
				//String tempStr = URLDecoder.decode(br.readLine(), "8859_1");
				//URLCodec codec = new URLCodec();
				//String tempStr = codec.decode(br.readLine(), "Windows-31J");
				
				//System.out.println(tempStr);
				//System.out.println(tempStr);
				getInfoValue(list, tempStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		if (list.size() >= 1) {
			insertIntoStockDB(code, list);	
		}	
	}
	
	private List getExcelData(String filePath) {
		List dataList = new ArrayList();
		FileInputStream inputStream = null;
		try {
			File excel = new File(filePath);
			inputStream = new FileInputStream(excel);
			HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
			int sheetCount = workBook.getNumberOfSheets();
			Loop1: for (int i = 0; i < sheetCount; i++) {
				String sheetName = workBook.getSheetName(i);
				//System.out.println("｡ｼ" + sheetName + "｡ｽ");
				HSSFSheet sheet = workBook.getSheetAt(i);
				Loop2: for (int j = 0; j <= sheet.getLastRowNum(); j++) {
					//System.out.println("list no = " + sheet.getLastRowNum());
					StockCodeURLBean bean = new StockCodeURLBean();
					int count = 0;
					HSSFRow row = sheet.getRow(j);
					if (row == null)
						continue;
					Loop3: for (int k = 0; k < row.getLastCellNum(); k++) {
						HSSFCell cell = row.getCell((short) k);
						if (cell == null)
							continue;
						int type = cell.getCellType();
						switch (type) {
						case HSSFCell.CELL_TYPE_BLANK:
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:							
							bean.setCode(String.valueOf(cell.getNumericCellValue()));
							break;
						case HSSFCell.CELL_TYPE_STRING:
							
						    //String tempStr = new String(cell.getStringCellValue().getBytes("8859_1"), "JISAutoDetect");
							String tempStr = new String(cell.getStringCellValue().getBytes("UTF-8"),"8859_1");
							//String tempStr = new String(cell.getStringCellValue());
						    
						    if (count == 0 ) {
						    	bean.setUrl(tempStr);						    	
						    } else if (count == 1 ) {
						    	bean.setName(tempStr);
						    } else if (count == 2 ) {
						    	//bean.setUrl(tempStr);
						    }
							count ++;							
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							//System.out.print(cell.getBooleanCellValue());
							break;
						default:
							//System.out.print("");
							break;
						}
						//System.out.print(" | ");
					}
					//System.out.println("\n------------------"
					//		+ "----------------------------------------");
					dataList.add(bean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}
	
	private List getExcelParam() {
		List dataList = new ArrayList();
		FileInputStream inputStream = null;
		try {
			String filePath = "C://batch//excel//stockparam.xls";
			File excel = new File(filePath);
			inputStream = new FileInputStream(excel);
			HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
			int sheetCount = workBook.getNumberOfSheets();
			Loop1: for (int i = 0; i < sheetCount; i++) {
				String sheetName = workBook.getSheetName(i);
				HSSFSheet sheet = workBook.getSheetAt(i);
				Loop2: for (int j = 0; j <= sheet.getLastRowNum(); j++) {
					
					HSSFRow row = sheet.getRow(j);
					if (row == null)
						continue;
					Loop3: for (int k = 0; k < row.getLastCellNum(); k++) {
						HSSFCell cell = row.getCell((short) k);
						if (cell == null)
							continue;
						int type = cell.getCellType();
						switch (type) {
						case HSSFCell.CELL_TYPE_BLANK:
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							//System.out.print((int) cell.getNumericCellValue());
							break;
						case HSSFCell.CELL_TYPE_STRING:
							
						    //String tempStr = new String(cell.getStringCellValue().getBytes("8859_1"), "JISAutoDetect");
							String tempStr = new String(cell.getStringCellValue().getBytes("UTF-8"),"8859_1");
							//String tempStr = new String(cell.getStringCellValue());
							dataList.add(tempStr);
						
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							//System.out.print(cell.getBooleanCellValue());
							break;
						default:
							//System.out.print("");
							break;
						}
						//System.out.print(" | ");
					}
					//System.out.println("\n------------------"
					//		+ "----------------------------------------");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}
}

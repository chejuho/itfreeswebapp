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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import bean.MainStockBean;
import bean.StockCodeURLBean;

import common.database.DBConnectionMgr;
import common.exception.AppException;

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
public class InsertMainStockInfo {
	
	String NIKKEI_AVER = "日経平均</a></td>";
	String JASDAQ_AVER = "JASDAQ</a></td>";
	String DAW_AVER = "NYダウ</a></td>";
	String KOSDAQ_AVER = "韓国総合</a></td>";	
	int nikkeiAverIndex = 0;
	int jasdaqAverIndex = 0;
	int dawAverIndex = 0;
	int kosdawAverIndex = 0;
	
	private boolean isStarted = false;
	private MainStockBean mainStockBean;

	public static void main(String[] args) {

		InsertMainStockInfo stock = new InsertMainStockInfo();
		stock.execute();

	}
	

	/*
	 * ﾄｫﾅﾗｰ昤ｮ ｸﾞｴｺｸｮｽｺﾆｮｸｦ  ﾅﾂｱﾗｷﾎ ｺｯ??
	 * @param map ﾄｫﾅﾗｰ昤ｮ ｸﾞｴｺｸｮｽｺﾆｮ
	 * @return ﾄｫﾅﾗｰ昤ｮｸﾞｴｺﾅﾂｱﾗ 
	 */
	private void getInfoValue(List list, String tempStr) {


		try {
			if (!isStarted) {
				
				nikkeiAverIndex = tempStr.indexOf(NIKKEI_AVER);
				jasdaqAverIndex = tempStr.indexOf(JASDAQ_AVER);
				dawAverIndex  = tempStr.indexOf(DAW_AVER);
				kosdawAverIndex  = tempStr.indexOf(KOSDAQ_AVER);

				if (nikkeiAverIndex != -1 || jasdaqAverIndex != -1 || dawAverIndex != -1 || kosdawAverIndex != -1) {
					isStarted = true;
				}
				
			} else if (isStarted) {
				tempStr = tempStr.replaceAll("\"", "\'");
				int start = tempStr.indexOf("<td class='ind_td2'>");
				int valuePlus = tempStr.indexOf("<td class='ind_td2'><span class='ind_num_plus'>");
				int valueMinus = tempStr.indexOf("<td class='ind_td2'><span class='ind_num_minus'>");
				int end = tempStr.indexOf("</td>");
				if (nikkeiAverIndex != -1 && start !=-1 && end!=-1 && valuePlus ==-1 && valueMinus==-1) {
					mainStockBean = new MainStockBean();
					System.out.println("日経平均=" + tempStr.substring(start + 20, end));
					mainStockBean.setNikkei_aver(tempStr.substring(start + 20, end));
	
				} else if (nikkeiAverIndex != -1 && end!=-1 && (valuePlus !=-1 || valueMinus!=-1)) {
					if (valuePlus != -1) {
						System.out.println("日経平均 plus=" + tempStr.substring(start + 47, end-7));
						mainStockBean.setNikkei_plus(tempStr.substring(start + 47, end-7));						
					} else {
						System.out.println("日経平均 plus=" + tempStr.substring(start + 48, end-7));
						mainStockBean.setNikkei_plus(tempStr.substring(start + 48, end-7));						
					}

					nikkeiAverIndex = 0;	
					isStarted = false;
				} else if (jasdaqAverIndex != -1 && start !=-1 && end!=-1 && valuePlus ==-1) {
	
						System.out.println("JASDAQ=" + tempStr.substring(start + 20, end));
						mainStockBean.setJasdaq_aver(tempStr.substring(start + 20, end));

				} else if (jasdaqAverIndex != -1 && end!=-1 && (valuePlus !=-1 || valueMinus!=-1)) {
					if (valuePlus != -1) {
						System.out.println("JASDAQ plus=" + tempStr.substring(start + 47, end-7));
						mainStockBean.setJasdaq_plus(tempStr.substring(start + 47, end-7));
					} else {
						System.out.println("JASDAQ plus=" + tempStr.substring(start + 48, end-7));
						mainStockBean.setJasdaq_plus(tempStr.substring(start + 48, end-7));
					}

					nikkeiAverIndex = 0;	
					isStarted = false;
				} else if (dawAverIndex != -1 && start !=-1 && end!=-1 && valuePlus ==-1) {
					
					System.out.println("NYダウ=" + tempStr.substring(start + 20, end));
					mainStockBean.setDau_aver(tempStr.substring(start + 20, end));

				} else if (dawAverIndex != -1 && end!=-1 && (valuePlus !=-1 || valueMinus!=-1)) {
					if (valuePlus != -1) {
						System.out.println("NYダウ plus=" + tempStr.substring(start + 47, end-7));
						mainStockBean.setDau_plus(tempStr.substring(start + 47, end-7));
					} else {
						System.out.println("NYダウ plus=" + tempStr.substring(start + 48, end-7));
						mainStockBean.setDau_plus(tempStr.substring(start + 48, end-7));
					}

					nikkeiAverIndex = 0;	
					isStarted = false;					
				} else if (kosdawAverIndex != -1 && start !=-1 && end!=-1 && valuePlus ==-1 && valueMinus==-1) {
					
					System.out.println("韓国総合=" + tempStr.substring(start + 20, end));
					mainStockBean.setKosdaq_aver(tempStr.substring(start + 20, end));

				} else if (kosdawAverIndex != -1 && end!=-1 && (valuePlus !=-1 || valueMinus!=-1)) {
					if (valuePlus != -1) {
						System.out.println("韓国総合 plus=" + tempStr.substring(start + 47, end-7));
						mainStockBean.setKosdaq_plus(tempStr.substring(start + 47, end-7));
					} else {
						System.out.println("韓国総合 plus=" + tempStr.substring(start + 48, end-7));
						mainStockBean.setKosdaq_plus(tempStr.substring(start + 48, end-7));
					}

					nikkeiAverIndex = 0;	
					isStarted = false;
					//list.add(mainStockBean);
				} 
				
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

			StringBuffer sb = new StringBuffer();

			sb.append("insert into mainstockinfo ");
			sb.append(" (nikkei_aver, nikkei_plus, jasdaq_aver, jasdaq_plus, dau_aver, dau_plus, kosdaq_aver, kosdaq_plus, stockdate) ");
			sb.append(" values ");
			sb.append(" ( '");
			sb.append(mainStockBean.getNikkei_aver());
			sb.append("','");		
			sb.append(mainStockBean.getNikkei_plus());
			sb.append("','");
			sb.append(mainStockBean.getJasdaq_aver());
			sb.append("','");
			sb.append(mainStockBean.getJasdaq_plus());
			sb.append("','");
			sb.append(mainStockBean.getDau_aver());
			sb.append("','");
			sb.append(mainStockBean.getDau_plus());
			sb.append("','");
			sb.append(mainStockBean.getKosdaq_aver());
			sb.append("','");
			sb.append(mainStockBean.getKosdaq_plus());
			sb.append("',now())");
			insertSQL(sb.toString());

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
	
	public MainStockBean execute() {
		String urlStr = "http://www.traders.co.jp/";
		URL url;
		InputStream is = null;
		List list = new ArrayList();

		try {
			url = new URL(urlStr);
			is = url.openStream();
			BufferedReader br
	          = new BufferedReader(new InputStreamReader(new BufferedInputStream(is)));

			//while (br.ready()) {
			while (br.read() != -1) {
				String tempStr = br.readLine();
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

//		System.out.println("list.size()=" + list.size());
//		if (list.size() >= 1) {
			insertIntoStockDB("", list);	
//		}	
		return mainStockBean;
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
	
	 public MainStockBean getMainStockBean(){
		    Connection con= null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    MainStockBean bean = new MainStockBean();
			try{
				
				con = DBConnectionMgr.getInstance().getConnection();
					
				String strSql= "select * from mainstockinfo order by idx desc limit 1";
				
				pstmt=con.prepareStatement(strSql);				
				
				rs=pstmt.executeQuery();
				while(rs.next()){
								
					bean.setNikkei_aver(rs.getString("nikkei_aver"));
					bean.setNikkei_plus(rs.getString("nikkei_plus"));
					bean.setJasdaq_aver(rs.getString("jasdaq_aver"));
					bean.setJasdaq_plus(rs.getString("jasdaq_plus"));
					bean.setDau_aver(rs.getString("dau_aver"));
					bean.setDau_plus(rs.getString("dau_plus"));
					bean.setKosdaq_aver(rs.getString("kosdaq_aver"));
					bean.setKosdaq_plus(rs.getString("kosdaq_plus"));
				
				}
				
				rs.close();
				pstmt.close();

		}catch(SQLException e){
			System.out.println("datebase error");
			System.out.println("error message:"+e.getMessage());
				
		}catch(Exception e){
		    e.printStackTrace();
		} finally {    
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return bean;
	 }
}

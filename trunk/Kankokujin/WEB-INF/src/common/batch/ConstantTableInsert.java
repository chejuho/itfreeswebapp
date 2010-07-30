package common.batch;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import bean.ColumnBean;
import bean.TableBean;
import common.constant.BatchConstant;
import common.exception.AppException;
import common.database.DBConnectionMgr;



/*
 * Created on 2006. 3. 3.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ConstantTableInsert {

	public static void main(String[] args) {
		ConstantTableInsert excel = new ConstantTableInsert();
		excel.excute();
	}

	public void excute() {
		Map list = getExcelData();
		insertData(list);
		//System.out.println("list size = " + list);
	}

	private Map getExcelData() {
		Map dataMap = new HashMap();
		List<ColumnBean> columnList = new ArrayList<ColumnBean>();
		List dataList = new ArrayList();
		TableBean tableInfo = new TableBean();
		FileInputStream inputStream = null;
		try {
			File excel = new File(BatchConstant.CONSTANT_TABLE_MAKE_FILE);
			inputStream = new FileInputStream(excel);
			HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
			int sheetCount = workBook.getNumberOfSheets();
			Loop1: for (int i = 0; i < sheetCount; i++) {
				String sheetName = workBook.getSheetName(i);
				tableInfo.setEnglishTableName(sheetName);
				System.out.println("¡¼" + sheetName + "¡½");
				HSSFSheet sheet = workBook.getSheetAt(i);

				HSSFRow row1 = sheet.getRow(0);
				
				HSSFCell cell1 = row1.getCell((short) 0);
				String tempStr = new String(cell1.getStringCellValue().getBytes("UTF-8"),"8859_1");
				ColumnBean column1 = new ColumnBean();
				column1.setEnglishColumnName(tempStr);
				
				HSSFCell cell2 = row1.getCell((short) 1);
				tempStr = new String(cell2.getStringCellValue().getBytes("UTF-8"),"8859_1");
				ColumnBean column2 = new ColumnBean();
				column2.setEnglishColumnName(tempStr);
				
				HSSFCell cell3 = row1.getCell((short) 2);
				tempStr = new String(cell3.getStringCellValue().getBytes("UTF-8"),"8859_1");
				ColumnBean column3 = new ColumnBean();
				column3.setEnglishColumnName(tempStr);
		
				HSSFCell cell4 = row1.getCell((short) 3);
				tempStr = new String(cell4.getStringCellValue().getBytes("UTF-8"),"8859_1");
				ColumnBean column4 = new ColumnBean();
				column4.setEnglishColumnName(tempStr);
				
				columnList.add(column1);
				columnList.add(column2);
				columnList.add(column3);
				columnList.add(column4);
				tableInfo.setColumnBeanList(columnList);
				Loop2: for (int j = 1; j <= sheet.getLastRowNum(); j++) {
					System.out.println("list no = " + sheet.getLastRowNum());
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
							dataList.add(cell.getNumericCellValue());
							break;
						case HSSFCell.CELL_TYPE_STRING:
							
						    //String tempStr = new String(cell.getStringCellValue().getBytes("8859_1"), "JISAutoDetect");
							tempStr = new String(cell.getStringCellValue().getBytes("UTF-8"),"8859_1");
							//String tempStr = new String(cell.getStringCellValue());
						    System.out.print(tempStr.toString());
							dataList.add(tempStr.toString());
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							System.out.print(cell.getBooleanCellValue());
							break;
						default:
							System.out.print("");
							break;
						}
						System.out.print(" | ");
					}
					System.out.println("\n------------------"
							+ "----------------------------------------");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("tableInfo", tableInfo);
		dataMap.put("tableData", dataList);
		return dataMap;
	}

	private void insertData(Map dataMap) {
		TableBean tableBean = (TableBean)dataMap.get("tableInfo");
		List columnBeanList = tableBean.getColumnBeanList();
		ColumnBean column1 = (ColumnBean)columnBeanList.get(0);
		ColumnBean column2 = (ColumnBean)columnBeanList.get(1);
		ColumnBean column3 = (ColumnBean)columnBeanList.get(2);
		ColumnBean column4 = (ColumnBean)columnBeanList.get(3);
		List dataList = (List)dataMap.get("tableData");
		Iterator iterator = (Iterator) dataList.iterator();
		Double idx = null;
		String constance_name = "";
		String constance_value = "";
		String constance_sort = "";
		while (iterator.hasNext()) {

			idx = (Double) iterator.next();
			constance_name = (String) iterator.next();
			constance_value = (String) iterator.next();
			Double tempDouble = (Double) iterator.next();
			constance_sort = String.valueOf(tempDouble);

			String sql = makeSQLSentence(tableBean.getEnglishTableName(), column1.getEnglishColumnName(), column2.getEnglishColumnName(), column3.getEnglishColumnName(), column4.getEnglishColumnName(), 
					idx, constance_name, constance_value, constance_sort);
			if (!insertWord(sql)) {
				System.out.println("fail");
			}
		}
	}

	private String makeSQLSentence(String tableName, String column1, String column2, String column3, String column4, Double idx, String constance_name, String constance_value, String constance_sort) {
		String sql = "insert  into " + tableName + " (" + column1 + ", " + column2 + ", " + column3 + ", " + column4 + ")"
				+ " values ('" + idx.intValue() + "','" + constance_name + "','" + constance_value + "','" + constance_sort + "')";
		return sql;
	}

	private boolean insertWord(String sql) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnectionMgr pool = DBConnectionMgr.getInstance();

		try {
			
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.executeUpdate(sql);
			pstmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("insertWord failed");
			return false;
		} catch (AppException e) {
			// TODO Ž©“®¶¬‚³‚ê‚½ catch ƒuƒƒbƒN
			e.printStackTrace();
		}finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return false;
	}
	
	public String test(String aaa) {
		System.out.println(aaa);
		return aaa;
	}
}
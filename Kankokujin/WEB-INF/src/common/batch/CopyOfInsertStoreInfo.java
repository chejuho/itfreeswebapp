package common.batch;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


import common.database.DBConnectionMgr;
import common.util.EnDecoding;
import item.bean.ItemBean;


import common.constant.BatchConstant;


/**
 * �J�e�S�����ǉ�
 * 
 * @author user
 * 
 */
public class CopyOfInsertStoreInfo{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CopyOfInsertStoreInfo readExcelData = new CopyOfInsertStoreInfo(); 
		boolean result = false;
		try {
			result = readExcelData.exec();
		} catch (Exception e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
		System.out.println("result =" + result);

	}

	public boolean exec() throws Exception {

		ItemBean itemForm = new ItemBean();

		FileInputStream fis = new FileInputStream(BatchConstant.STORE_INFO_FILE);
		POIFSFileSystem fs = new POIFSFileSystem(fis);
		HSSFWorkbook wb = new HSSFWorkbook(fs);

		int sheets = wb.getNumberOfSheets();

		try {
			for (int sheetIdx = 0; sheetIdx < sheets; sheetIdx++) {

				HSSFSheet sheet = wb.getSheetAt(sheetIdx);
				int firstRow = sheet.getFirstRowNum();
				int lastRow = sheet.getLastRowNum();

				for (int rowIdx = firstRow; rowIdx <= lastRow; rowIdx++) {

					HSSFRow row = sheet.getRow(rowIdx + 1);

					if (row == null)
						continue;

					short firstCell = row.getFirstCellNum();
					//short lastCell = row.getLastCellNum();
					short lastCell = 11;

					ArrayList list = new ArrayList();

					for (short cellIdx = firstCell; cellIdx <= lastCell; cellIdx++) {
						String data = null;

						HSSFCell cell = row.getCell(cellIdx);
//						if (cell == null)
//							continue;
						
						if (cell == null) {
							list.add("");
						} else {
							int type = cell.getCellType();
							switch (type) {						
							case HSSFCell.CELL_TYPE_BOOLEAN:
								boolean bdata = cell.getBooleanCellValue();
								data = String.valueOf(bdata);
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								double ddata = cell.getNumericCellValue();
								data = String.valueOf(ddata);
								break;
							case HSSFCell.CELL_TYPE_STRING:
								data = cell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_BLANK:
								data = cell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_ERROR:
							case HSSFCell.CELL_TYPE_FORMULA:
							default:
								continue;
							}
							list.add(data);
						}
						


						// System.out.println(list.get(cellIdx));

					} // end cell

					Iterator itList = list.iterator();
					while (itList.hasNext()) {
						String col01 = (String) itList.next();						
						String col02 = (String) itList.next();						
						String col03 = (String) itList.next();
						String col04 = (String) itList.next();						
						String col05 = (String) itList.next();
						String col06 = (String) itList.next();
						String col07 = (String) itList.next();
						String col08 = (String) itList.next();
						String col09 = (String) itList.next();
						String col10 = (String) itList.next();
						String col11 = (String) itList.next();
						String col12 = (String) itList.next();
						
						itemForm.setCol01(col01);						
						itemForm.setCol02(EnDecoding.encoding(col02));
						itemForm.setCol03(EnDecoding.encoding(col03));
//						itemForm.setCol02(col02);
//						itemForm.setCol03(col03);						
						itemForm.setCol04(col04);
						itemForm.setCol05(col05);
						itemForm.setCol06(col06);
						itemForm.setCol07(col07);
						itemForm.setCol08(col08);
						itemForm.setCol09(col09);
						itemForm.setCol10(col10);
						itemForm.setCol11(col11);
						itemForm.setCol12(col12);
						insertItem(itemForm);						
					}
						
					

				} // end row

			} // end sheet
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}
	
	/**
	 * CateForm��INSERT���閽��
	 * 
	 * @return void
	 */
	public void insertItem(ItemBean itemForm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnectionMgr pool = DBConnectionMgr.getInstance();

		try {
			conn = pool.getConnection();
			pstmt = conn
					.prepareStatement("insert into store_info " +
					"(user_id, store_name_k, store_name_j, tel_no_1, fax_no, url, area_code_1, area_code_2, line_code, station_code, cate_code_1, cate_code_2)" +		
					"values (?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, itemForm.getCol01());
			pstmt.setString(2, itemForm.getCol02());
			pstmt.setString(3, itemForm.getCol03());
			pstmt.setString(4, itemForm.getCol04());
			pstmt.setString(5, itemForm.getCol05());
			pstmt.setString(6, itemForm.getCol06());
			pstmt.setString(7, itemForm.getCol07());
			pstmt.setString(8, itemForm.getCol08());
			pstmt.setString(9, itemForm.getCol09());
			pstmt.setString(10, itemForm.getCol10());
			pstmt.setString(11, itemForm.getCol11());
			pstmt.setString(12, itemForm.getCol12());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}
}
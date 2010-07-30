package common.batch.insertdata;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
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
 * カテゴリ情報追加
 * 
 * @author user
 * 
 */
public class InsertHouseInfo{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InsertHouseInfo readExcelData = new InsertHouseInfo(); 
		boolean result = false;
		try {
			result = readExcelData.exec();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("result =" + result);

	}

	public boolean exec() throws Exception {

		ItemBean itemForm = new ItemBean();

		FileInputStream fis = new FileInputStream(BatchConstant.HOUSE_INFO_FILE);
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
					short lastCell = 28;

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
						String col13 = (String) itList.next();
						String col14 = (String) itList.next();
						String col15 = (String) itList.next();
						String col16 = (String) itList.next();
						String col17 = (String) itList.next();
						String col18 = (String) itList.next();
						String col19 = (String) itList.next();
						String col20 = (String) itList.next();
						String col21 = (String) itList.next();
						String col22 = (String) itList.next();
						String col23 = (String) itList.next();
						
						String col24 = (String) itList.next();
						String col25 = (String) itList.next();
						String col26 = (String) itList.next();
						String col27 = (String) itList.next();
						String col28 = (String) itList.next();
						String col29 = (String) itList.next();
						
						
						itemForm.setCol01(col01);						
						itemForm.setCol02(EnDecoding.encoding(col02));
						itemForm.setCol03(col03);
				
						itemForm.setCol04(col04);
						itemForm.setCol05(EnDecoding.encoding(col05));
						itemForm.setCol06(col06);
						itemForm.setCol07(col07);
						itemForm.setCol08(col08);
						itemForm.setCol09(col09);
						itemForm.setCol10(col10);
						itemForm.setCol11(col11);
						itemForm.setCol12(col12);
						itemForm.setCol13(col13);
						itemForm.setCol14(col14);
						itemForm.setCol15(EnDecoding.encoding(col15));
						itemForm.setCol16(col16);
						itemForm.setCol17(col17);
						itemForm.setCol18(col18);
						itemForm.setCol19(col19);
						itemForm.setCol20(col20);
						itemForm.setCol21(col21);
						itemForm.setCol22(col22);
						itemForm.setCol23(col23);
						itemForm.setCol24(col24);
						itemForm.setCol25(col25);
						itemForm.setCol26(col26);
						itemForm.setCol27(col27);
						itemForm.setCol28(col28);
						itemForm.setCol29(col29);
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
	 * CateFormのINSERTする命令
	 * 
	 * @return void
	 */
	public void insertItem(ItemBean itemForm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnectionMgr pool = DBConnectionMgr.getInstance();

		try {
			conn = pool.getConnection();
			
			String strsqr = "insert into house_info(title,house_name,detail_info, manage_fee, house_sort, dimension,"+
			"house_fee,deposit,reikin,walk_time,build_year,madori,all_stairs,stairs,flg_tadami,toilet,line_code,"+
			"station_code,photo_name1,photo_name2,photo_name3,photo_name4,area_code_1,area_code_2,main_area,"+
			"user_id,email,telephone,photo_name5,area_fast,area_code_3,point_compass,come_dock,come_dock_year,"+
			"come_dock_month,build_month,guaranty_money,house_option,madori_info," +
			"update_date,regist_date,read_count)"+
	        "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),now(),0)";
			
			pstmt = conn.prepareStatement(strsqr);
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
			pstmt.setString(13, itemForm.getCol13());
			pstmt.setString(14, itemForm.getCol14());
			pstmt.setString(15, itemForm.getCol15());
			pstmt.setString(16, itemForm.getCol16());
			pstmt.setString(17, itemForm.getCol17());
			pstmt.setString(18, itemForm.getCol18());
			pstmt.setString(19, itemForm.getCol19());
			pstmt.setString(20, itemForm.getCol20());
			pstmt.setString(21, itemForm.getCol21());
			pstmt.setString(22, itemForm.getCol22());
			pstmt.setString(23, itemForm.getCol23());

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
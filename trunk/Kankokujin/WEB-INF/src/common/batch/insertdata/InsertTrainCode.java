package common.batch.insertdata;

import item.bean.ItemBean;

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

import common.constant.BatchConstant;
import common.database.DBConnectionMgr;


/**
 * カテゴリ情報追加
 * 
 * @author user
 * 
 */
public class InsertTrainCode{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InsertTrainCode readExcelData = new InsertTrainCode(); 
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

		FileInputStream fis = new FileInputStream(BatchConstant.TRAIN_TABLE_MAKE_FILE);
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
					short lastCell = row.getLastCellNum();

					ArrayList list = new ArrayList();

					for (short cellIdx = firstCell; cellIdx <= lastCell; cellIdx++) {
						String data = null;

						HSSFCell cell = row.getCell(cellIdx);
						if (cell == null)
							continue;
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
						
						
/*						itemForm.setCol01(col01);
						itemForm.setCol02(EnDecoding.encoding(col02));
						itemForm.setCol03(EnDecoding.encoding(col03));
						itemForm.setCol04(col04);
						itemForm.setCol05(EnDecoding.encoding(col05));
						itemForm.setCol06(EnDecoding.encoding(col06));*/
						
						itemForm.setCol01(col01);
						itemForm.setCol02(col02);
						itemForm.setCol03(col03);
						itemForm.setCol04(col04);
						itemForm.setCol05(col05);
						itemForm.setCol06(col06);						
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
			pstmt = conn
					.prepareStatement("insert into t_train " +
					"(station_code, station_kanji, station_kana, line_code, line_kanji, line_kana)" +		
					"values (?,?,?,?,?,?)");
			pstmt.setString(1, itemForm.getCol01());
			pstmt.setString(2, itemForm.getCol02());
			pstmt.setString(3, itemForm.getCol03());
			pstmt.setString(4, itemForm.getCol04());
			pstmt.setString(5, itemForm.getCol05());
			pstmt.setString(6, itemForm.getCol06());
			
			//pstmt.setString(5, "0");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null) {
				DBConnectionMgr.getInstance().freeConnection(conn);
			}
		}
	}
}
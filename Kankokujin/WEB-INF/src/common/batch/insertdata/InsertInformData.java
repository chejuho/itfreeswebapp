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

import common.constant.Const;
import common.database.DBConnectionMgr;
import common.exception.SysException;
import common.util.EnDecoding;

/**
 * カテゴリ情報追加
 * 
 * @author user
 * 
 */
public class InsertInformData {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InsertInformData insertInformData = new InsertInformData(); 
		boolean result = false;
		try {
			result = insertInformData.exec();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("result =" + result);

	}
//	public ActionForward execute(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		ReadExcelTCategory category = new ReadExcelTCategory();
//		boolean categoryInsertResult = category.exec();
//		
//		KankokujinLogger.debug("categoryInsertResult=" + categoryInsertResult);
//		if (categoryInsertResult) {
//			return mapping.findForward("success");
//		} else {
//			return mapping.findForward("fail");
//		}
		//	}
	
	public boolean exec() throws Exception {

		ItemBean itemForm = new ItemBean();

		FileInputStream fis = new FileInputStream(Const.EXCEL_INFORM_PATH);
		
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
						
						itemForm.setCol01(col01);
						itemForm.setCol02(col02);
						itemForm.setCol03(col03);
						insertItem(itemForm);						
					}

					

				} // end row

			} // end sheet
			

		} catch (Exception e) {
			throw e;
		}
		return true;

	}
	
	/**
	 * CateFormのINSERTする命令
	 * 
	 * @return void
	 * @throws Exception 
	 */
	public void insertItem(ItemBean itemForm) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnectionMgr pool = DBConnectionMgr.getInstance();

		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement("insert into inform " + "(title, detail_info, regist_date)" + "values (?,?,now())");
			//pstmt.setString(1, itemForm.getCol01());
			pstmt.setString(1, itemForm.getCol02());
			pstmt.setString(2, itemForm.getCol03());
			
			//pstmt.setString(5, "0");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
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
package common.batch.insertdata;

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

import common.bean.ItemBean;
import common.constant.Const;
import common.database.DBConnectionMgr;
import common.util.EnDecoding;


/**
 * カテゴリ情報追加
 * 
 * @author user
 * 
 */
public class InsertCompanyData{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InsertCompanyData readExcelData = new InsertCompanyData(); 
		boolean result = false;
		try {
			result = readExcelData.exec();
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

		FileInputStream fis = new FileInputStream(Const.EXCEL_RESTORE_PATH + "eigyou_email_list.xls");
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
						itemForm.setCol01(EnDecoding.encoding((String) itList.next()));
						itemForm.setCol02(EnDecoding.encoding((String) itList.next()));
						itemForm.setCol03(EnDecoding.encoding((String) itList.next()));
						itemForm.setCol04(EnDecoding.encoding((String) itList.next()));
						itemForm.setCol05(EnDecoding.encoding((String) itList.next()));
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

		try {
			conn = DBConnectionMgr.getInstance().getConnection();
			pstmt = conn
					.prepareStatement("insert into eigyou_email_list " +
					"(company, part_name, view_to_name, to_name, to_mail, flag)" +		
					"values (?,?,?,?,?,0)");
			pstmt.setString(1, itemForm.getCol01());
			pstmt.setString(2, itemForm.getCol02());
			pstmt.setString(3, itemForm.getCol03());
			pstmt.setString(4, itemForm.getCol04());
			pstmt.setString(5, itemForm.getCol05());
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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}
}
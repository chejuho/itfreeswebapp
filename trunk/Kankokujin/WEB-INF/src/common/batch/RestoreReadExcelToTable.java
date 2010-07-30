package common.batch;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import common.constant.Const;
import common.database.DBConnectionMgr;
import common.database.LogPreparedStatement;
import common.exception.SysException;
import common.util.Util;

/**
 * カテゴリ情報作成
 * 
 * @author user
 * 
 */
public class RestoreReadExcelToTable {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RestoreReadExcelToTable writeExcelData = new RestoreReadExcelToTable();
		boolean result = false;
		try {
			result = writeExcelData.exec();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("result =" + result);

	}

	public boolean exec() throws Exception {
		DBBackupRestore dBBackupRestore = new DBBackupRestore();
		List tableList = dBBackupRestore.getTables(Const.DB_NAME);
		Iterator it = tableList.iterator();
		while (it.hasNext()) {
			String table_name = (String) it.next();
			readExcel(table_name, dBBackupRestore.getColumnNames(table_name));
		}

		return true;
	}

	public void readExcel(String table_name, List column_list) throws SysException{

		try {
			System.out.println(Const.EXCEL_RESTORE_PATH+ table_name + Const.EXCEL_KAKUTYOUSI);
			FileInputStream fis = new FileInputStream(Const.EXCEL_RESTORE_PATH+ table_name + Const.EXCEL_KAKUTYOUSI);
			System.out.println(Const.EXCEL_RESTORE_PATH+ table_name + Const.EXCEL_KAKUTYOUSI);
			POIFSFileSystem fs = new POIFSFileSystem(fis);
			HSSFWorkbook wb = new HSSFWorkbook(fs);

			int sheets = wb.getNumberOfSheets();

			for (int sheetIdx = 0; sheetIdx < sheets; sheetIdx++) {

				HSSFSheet sheet = wb.getSheetAt(sheetIdx);
				int firstRow = sheet.getFirstRowNum();
				int lastRow = sheet.getLastRowNum();
				//for rows
				for (int rowIdx = firstRow; rowIdx <= lastRow; rowIdx++) {

					HSSFRow row = sheet.getRow(rowIdx + 1);

					if (row == null)
						continue;

					short firstCell = row.getFirstCellNum();
					short lastCell = row.getLastCellNum();

					ArrayList list = new ArrayList();

					for (short cellIdx = firstCell; cellIdx < column_list.size(); cellIdx++) {
						String data = null;

						HSSFCell cell = row.getCell(cellIdx);
						if (cell == null) {
							list.add(null);
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
						

					} // end cell
					insertTableData(table_name, list);
				} // //for rows end row

			} // end sheet

		} catch (Exception e) {
			//throw new SysException("SYE0015", e);
		} finally {

		}
	}

	public void insertTableData(String table_name, List data_list) {
		Connection conn = null;
		LogPreparedStatement pstmt = null;
		DBConnectionMgr pool = DBConnectionMgr.getInstance();

		try {
			DBBackupRestore dBBackupRestore = new DBBackupRestore();
			List columnNames = dBBackupRestore.getColumnNames(table_name);
			Iterator it1 = columnNames.iterator();
			Iterator it2 = columnNames.iterator();
			Iterator it3 = data_list.iterator();
			conn = pool.getConnection();
			StringBuffer sb = new StringBuffer("insert into ");
			sb.append(table_name);
			
			boolean isFirst = true;
			while(it1.hasNext()){
				if(isFirst){
					sb.append("(");
					sb.append((String)it1.next());
					isFirst = false;
				} else {
					sb.append(",");
					sb.append((String)it1.next());
				}
			}
			sb.append(") values ");
			isFirst = true;
			while(it2.hasNext()){
				if(isFirst){
					sb.append("(");
					sb.append("?");
					it2.next();
					isFirst = false;
				} else {
					sb.append(",");
					sb.append("?");		
					it2.next();
				}
			}			
			sb.append(")");
			
			pstmt = new LogPreparedStatement(conn, sb.toString());
			int count = 0;
			while(it3.hasNext()){
				pstmt.setString(++count, changeEmptyToNull((String)it3.next()));
			}
			if(pstmt.executeUpdate()==1){
				System.out.println("insert suceessed");
			} else {
				System.out.println("insert failed");
			}
			System.out.println(pstmt.getQueryString());
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
	private String changeEmptyToNull(String input){
		if(Util.isEmpty(input)){
			return null;
		} else {
			return input;
		}
	}
}
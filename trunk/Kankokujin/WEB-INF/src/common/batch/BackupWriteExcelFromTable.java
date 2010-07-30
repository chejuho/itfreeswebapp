package common.batch;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import common.constant.Const;
import common.exception.SysException;

/**
 * カテゴリ情報作成
 * 
 * @author user
 * 
 */
public class BackupWriteExcelFromTable {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BackupWriteExcelFromTable writeExcelData = new BackupWriteExcelFromTable();
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
		List tableList = dBBackupRestore.getTables("kankokujincom");
		Iterator it = tableList.iterator();
		while(it.hasNext()){
			String table_name = (String)it.next();
			System.out.println(table_name);
			writeExcel(table_name, dBBackupRestore.getColumnNames(table_name));
		}
		
		return true;
	}

	public void writeExcel(String table_name, List column_list)
			throws SysException {
		FileOutputStream fileOut = null;
		HSSFWorkbook wb = new HSSFWorkbook();
		try {
			DBBackupRestore dBBackupRestore = new DBBackupRestore();
			List tableValues = dBBackupRestore.getTableValues(table_name, column_list);
			HSSFSheet sheet1 = wb.createSheet(table_name);
			int rowCount = 0;
			HSSFRow row0 = sheet1.createRow(rowCount++);
			Iterator it = column_list.iterator();
			int count = 0;
			while(it.hasNext()){
				row0.createCell((short) count++).setCellValue((String)it.next());
			}
			Iterator tableValuesIt = tableValues.iterator();
			while(tableValuesIt.hasNext()){
				List valueList = (List)tableValuesIt.next();
				Iterator valueListIt = valueList.iterator();
				int cellCount = 0;
				HSSFRow tmpRow = sheet1.createRow(rowCount++);
				
				while(valueListIt.hasNext()){
					
					
					HSSFCell tmpCell1 = tmpRow.createCell((short) cellCount);
					tmpCell1.setEncoding(HSSFCell.ENCODING_UTF_16);
					tmpCell1.setCellValue((String)valueListIt.next());
					//System.out.println(count);
					cellCount++;
					
				}
			}
			
			fileOut = new FileOutputStream(Const.EXCEL_BACKUP_PATH + table_name + Const.EXCEL_KAKUTYOUSI);
			wb.write(fileOut);

		} catch (Exception e) {
			throw new SysException("SYE0015", e);
		} finally {
			try {
				if(fileOut != null){
					fileOut.close();
				}
				
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
	}


}
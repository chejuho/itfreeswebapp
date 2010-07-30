package common.batch;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import item.bean.ItemBean;
import common.util.EnDecoding;
import common.constant.BatchConstant;
import common.database.DBConnectionMgr;




/**
 * カテゴリ情報作成
 * 
 * @author user
 * 
 */
public class CopyOfWriteExcelStoreInfo{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CopyOfWriteExcelStoreInfo writeExcelData = new CopyOfWriteExcelStoreInfo(); 
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
		   FileOutputStream fileOut = null;
		   HSSFWorkbook wb = new HSSFWorkbook();
		   try {
			   ArrayList list = getItemList();
			   int su = list.size();
			   HSSFSheet sheet1 = wb.createSheet("store_info");
		   
			   HSSFRow row0 = sheet1.createRow(0);
			   
			   
			   row0.createCell((short)0).setCellValue("user_id");
			   row0.createCell((short)1).setCellValue("store_name_k");
			   row0.createCell((short)2).setCellValue("store_name_j");
			   row0.createCell((short)3).setCellValue("tel_no_1");
			   row0.createCell((short)4).setCellValue("fax_no");
			   row0.createCell((short)5).setCellValue("url");
			   row0.createCell((short)6).setCellValue("area_code_1");
			   row0.createCell((short)7).setCellValue("area_code_2");
			   row0.createCell((short)8).setCellValue("line_code");
			   row0.createCell((short)9).setCellValue("station_code");
			   row0.createCell((short)10).setCellValue("cate_code_1");
			   row0.createCell((short)11).setCellValue("cate_code_2");
			   
			   if(su!=0) {
					for(int i=0 ; i<su ; i++){
										
						ItemBean bean = (ItemBean)list.get(i);
								
						//sheet1.createRow(i+1).createCell((short)0).setCellValue(bean.getCol01());
						HSSFRow tmpRow = sheet1.createRow(i+1);
						
					   HSSFCell tmpCell1 = tmpRow.createCell((short) 0);					   
					   tmpCell1.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell1.setCellValue(bean.getCol01());
						//sheet1.createRow(i+1).createCell((short)1).setCellValue(bean.getCol02());
					   
					   HSSFCell tmpCell2 = tmpRow.createCell((short) 1);
					   tmpCell2.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell2.setCellType(HSSFCell.CELL_TYPE_STRING);
					   tmpCell2.setCellValue(bean.getCol02());
					   
					   
						//sheet1.createRow(i+1).createCell((short)2).setCellValue(bean.getCol03());
					   					   
					   HSSFCell tmpCell3 = tmpRow.createCell((short) 2);
					   tmpCell3.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell3.setCellValue(bean.getCol03());					   
						//sheet1.createRow(i+1).createCell((short)3).setCellValue(bean.getCol04());
					   
					   HSSFCell tmpCell4 = tmpRow.createCell((short) 3);
					   tmpCell4.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell4.setCellValue(bean.getCol04());
					   
					   HSSFCell tmpCell5 = tmpRow.createCell((short) 4);
					   tmpCell5.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell5.setCellValue(bean.getCol05());
					   
					   HSSFCell tmpCell6 = tmpRow.createCell((short) 5);
					   tmpCell6.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell6.setCellValue(bean.getCol06());
					   
					   HSSFCell tmpCell7 = tmpRow.createCell((short) 6);
					   tmpCell7.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell7.setCellValue(bean.getCol07());
					   
					   HSSFCell tmpCell8 = tmpRow.createCell((short) 7);
					   tmpCell8.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell8.setCellValue(bean.getCol08());
					   
					   HSSFCell tmpCell9 = tmpRow.createCell((short) 8);
					   tmpCell9.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell9.setCellValue(bean.getCol09());
					   
					   HSSFCell tmpCell10 = tmpRow.createCell((short) 9);
					   tmpCell10.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell10.setCellValue(bean.getCol10());
					   
					   HSSFCell tmpCell11 = tmpRow.createCell((short) 10);
					   tmpCell11.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell11.setCellValue(bean.getCol11());
					   
					   HSSFCell tmpCell12 = tmpRow.createCell((short) 11);
					   tmpCell12.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell12.setCellValue(bean.getCol12());
					   
						//sheet1.createRow(i+1).createCell((short)4).setCellValue(bean.getCol05());
						

					}
			   }

		      fileOut = new FileOutputStream(BatchConstant.STORE_INFO_WRITEOUT_FILE);
		      wb.write(fileOut);
		      
			   
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
			   fileOut.close();
			   
		   }
	      return true;
	   }

	/**
	 * DBのCateFormをEXCELで書く命令
	 * 
	 * @return list
	 */
	public ArrayList<ItemBean> getItemList() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		ArrayList<ItemBean> list = new ArrayList<ItemBean>();

		String query = "";
		try {
			conn = pool.getConnection();
			st = conn.createStatement();
			query = "select * from store_info";

			rs = st.executeQuery(query);

			while (rs.next()) {
				ItemBean bean = new ItemBean();
				//bean.setCol01(rs.getString("mail_id"));
				bean.setCol01(rs.getString("user_id"));
				//bean.setCol02(EnDecoding.decoding(rs.getString("store_name_k")));
				//bean.setCol03(EnDecoding.decoding(rs.getString("store_name_j")));
				bean.setCol02(EnDecoding.decoding(rs.getString("store_name_k")));
				bean.setCol03(EnDecoding.decoding(rs.getString("store_name_j")));				
				bean.setCol04(rs.getString("tel_no_1"));
				bean.setCol05(rs.getString("fax_no"));
				bean.setCol06(rs.getString("url"));
				bean.setCol07(rs.getString("area_code_1"));
				bean.setCol08(rs.getString("area_code_2"));
				bean.setCol09(rs.getString("line_code"));
				bean.setCol10(rs.getString("station_code"));
				bean.setCol11(rs.getString("cate_code_1"));
				bean.setCol12(rs.getString("cate_code_2"));
				
				
				list.add(bean);
			}
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}	

}
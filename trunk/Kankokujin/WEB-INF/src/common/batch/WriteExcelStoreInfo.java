package common.batch;

import item.bean.ItemBean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import common.constant.Const;
import common.database.DBConnectionMgr;
import common.exception.SysException;
import common.util.EnDecoding;

/**
 * カテゴリ情報作成
 * 
 * @author user
 * 
 */
public class WriteExcelStoreInfo{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WriteExcelStoreInfo writeExcelData = new WriteExcelStoreInfo(); 
		boolean result = false;
		try {
			result = writeExcelData.exec();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("result =" + result);

	}
	
	public boolean exec() throws SysException {
		   FileOutputStream fileOut = null;
		   HSSFWorkbook wb = new HSSFWorkbook();
		   try {
			   ArrayList list = getItemList();
			   int su = list.size();
			   HSSFSheet sheet1 = wb.createSheet("store_info");
		   
			   HSSFRow row0 = sheet1.createRow(0);
			   
			   
			   row0.createCell((short)0).setCellValue("user_id");
			   row0.createCell((short)1).setCellValue("store_name_k");
			   row0.createCell((short)2).setCellValue("tel_no1_1");
			   row0.createCell((short)3).setCellValue("tel_no1_2");
			   row0.createCell((short)4).setCellValue("tel_no1_3");
			   row0.createCell((short)5).setCellValue("tel_no2_1");
			   row0.createCell((short)6).setCellValue("tel_no2_2");
			   row0.createCell((short)7).setCellValue("tel_no2_3");
			   row0.createCell((short)8).setCellValue("fax_no_1");
			   row0.createCell((short)9).setCellValue("fax_no_2");
			   row0.createCell((short)10).setCellValue("fax_no_3");
			   
			   row0.createCell((short)11).setCellValue("email");
			   row0.createCell((short)12).setCellValue("url");
			   row0.createCell((short)13).setCellValue("photo_name1");
			   row0.createCell((short)14).setCellValue("photo_name2");
			   row0.createCell((short)15).setCellValue("photo_name3");
			   row0.createCell((short)16).setCellValue("photo_name4");
			   row0.createCell((short)17).setCellValue("photo_name5");
			   row0.createCell((short)18).setCellValue("area_code_1");
			   row0.createCell((short)19).setCellValue("area_code_2");
			   row0.createCell((short)20).setCellValue("area_code_3");
			   row0.createCell((short)21).setCellValue("line_code");
			   row0.createCell((short)22).setCellValue("station_code");
			   row0.createCell((short)23).setCellValue("area_fast");
			   row0.createCell((short)24).setCellValue("cate_code_1");
			   row0.createCell((short)25).setCellValue("cate_code_2");
			   row0.createCell((short)26).setCellValue("main_area");
			   row0.createCell((short)27).setCellValue("regist_date");
			   row0.createCell((short)28).setCellValue("update_date");
			   
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
					   
					   HSSFCell tmpCell13 = tmpRow.createCell((short) 12);
					   tmpCell13.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell13.setCellValue(bean.getCol13());
					   
					   HSSFCell tmpCell14 = tmpRow.createCell((short) 13);
					   tmpCell14.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell14.setCellValue(bean.getCol14());
					   
					   HSSFCell tmpCell15 = tmpRow.createCell((short) 14);
					   tmpCell15.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell15.setCellValue(bean.getCol15());
					   
					   HSSFCell tmpCell16 = tmpRow.createCell((short) 15);
					   tmpCell16.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell16.setCellValue(bean.getCol16());
					   
					   HSSFCell tmpCell17 = tmpRow.createCell((short) 16);
					   tmpCell17.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell17.setCellValue(bean.getCol17());
					   
					   HSSFCell tmpCell18 = tmpRow.createCell((short) 17);
					   tmpCell18.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell18.setCellValue(bean.getCol18());
					   
					   HSSFCell tmpCell19 = tmpRow.createCell((short) 18);
					   tmpCell19.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell19.setCellValue(bean.getCol19());					   
					   
					   HSSFCell tmpCell20 = tmpRow.createCell((short) 19);
					   tmpCell20.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell20.setCellValue(bean.getCol20());
					   
					   HSSFCell tmpCell21 = tmpRow.createCell((short) 20);
					   tmpCell21.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell21.setCellValue(bean.getCol21());
					   
					   HSSFCell tmpCell22 = tmpRow.createCell((short) 21);
					   tmpCell22.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell22.setCellValue(bean.getCol22());

					   HSSFCell tmpCell23 = tmpRow.createCell((short) 22);
					   tmpCell23.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell23.setCellValue(bean.getCol23());
					   
					   HSSFCell tmpCell24 = tmpRow.createCell((short) 23);
					   tmpCell24.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell24.setCellValue(bean.getCol24());
					   
					   HSSFCell tmpCell25 = tmpRow.createCell((short) 24);
					   tmpCell25.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell25.setCellValue(bean.getCol25());
					   
					   HSSFCell tmpCell26 = tmpRow.createCell((short) 25);
					   tmpCell26.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell26.setCellValue(bean.getCol26());
					   
					   HSSFCell tmpCell27 = tmpRow.createCell((short) 26);
					   tmpCell27.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell27.setCellValue(bean.getCol27());
					   
					   HSSFCell tmpCell28 = tmpRow.createCell((short) 27);
					   tmpCell28.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell28.setCellValue(bean.getCol28());
					   
					   HSSFCell tmpCell29 = tmpRow.createCell((short) 28);
					   tmpCell29.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell29.setCellValue(bean.getCol29());
						//sheet1.createRow(i+1).createCell((short)4).setCellValue(bean.getCol05());
					}
			   }

			  fileOut = new FileOutputStream(Const.EXCEL_PATH + Const.TABLE_NAME_STORE_INFO + Const.EXCEL_KAKUTYOUSI);
		      wb.write(fileOut);
		      
			   
		   } catch (Exception e) {
			   throw new SysException("SYE0015", e);
		   } finally {
			   try {
				if(fileOut !=null){
					fileOut.close();
				}
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
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
				bean.setCol01(rs.getString("user_id"));
				bean.setCol02(EnDecoding.decoding(rs.getString("store_name_k")));
				//bean.setCol03(EnDecoding.decoding(rs.getString("store_name_j")));				
				bean.setCol03(rs.getString("tel_no1_1"));
				bean.setCol04(rs.getString("tel_no1_2"));
				bean.setCol05(rs.getString("tel_no1_3"));
				bean.setCol06(rs.getString("tel_no2_1"));
				bean.setCol07(rs.getString("tel_no2_2"));
				bean.setCol08(rs.getString("tel_no2_3"));				
				bean.setCol09(rs.getString("fax_no_1"));
				bean.setCol10(rs.getString("fax_no_2"));
				bean.setCol11(rs.getString("fax_no_3"));
				bean.setCol12(rs.getString("email"));
				bean.setCol13(rs.getString("url"));
				bean.setCol14(rs.getString("photo_name1"));
				bean.setCol15(rs.getString("photo_name2"));
				bean.setCol16(rs.getString("photo_name3"));
				bean.setCol17(rs.getString("photo_name4"));
				bean.setCol18(rs.getString("photo_name5"));
				bean.setCol19(rs.getString("area_code_1"));
				bean.setCol20(rs.getString("area_code_2"));
				bean.setCol21(rs.getString("area_code_3"));
				bean.setCol22(rs.getString("line_code"));
				bean.setCol23(rs.getString("station_code"));
				bean.setCol24(rs.getString("area_fast"));
				bean.setCol25(rs.getString("cate_code_1"));
				bean.setCol26(rs.getString("cate_code_2"));
				bean.setCol27(rs.getString("main_area"));
				bean.setCol28(rs.getString("regist_date"));
				bean.setCol29(rs.getString("update_date"));
				
				
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
package common.batch;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
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
public class WriteExcelCategory{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WriteExcelCategory writeExcelData = new WriteExcelCategory(); 
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
			   HSSFSheet sheet1 = wb.createSheet("category");
		   
			   HSSFRow row0 = sheet1.createRow(0);
			   
			   
			   row0.createCell((short)0).setCellValue("category_code_1");
			   row0.createCell((short)1).setCellValue("category_code_2");
			   row0.createCell((short)2).setCellValue("category_name_1");
			   row0.createCell((short)3).setCellValue("category_name_2");

			   		
			   
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
					   tmpCell2.setCellValue(bean.getCol02());
						//sheet1.createRow(i+1).createCell((short)2).setCellValue(bean.getCol03());
					   					   
					   HSSFCell tmpCell3 = tmpRow.createCell((short) 2);
					   tmpCell3.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell3.setCellValue(bean.getCol03());					   
						//sheet1.createRow(i+1).createCell((short)3).setCellValue(bean.getCol04());
					   
					   HSSFCell tmpCell4 = tmpRow.createCell((short) 3);
					   tmpCell4.setEncoding(HSSFCell.ENCODING_UTF_16);
					   tmpCell4.setCellValue(bean.getCol04());
					   
						//sheet1.createRow(i+1).createCell((short)4).setCellValue(bean.getCol05());
						

					}
			   }

		      fileOut = new FileOutputStream(BatchConstant.CATEGORY_TABLE_WRITEOUT_FILE);
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
			query = "select * from t_store_category";

			rs = st.executeQuery(query);

			while (rs.next()) {
				ItemBean bean = new ItemBean();
				//bean.setCol01(rs.getString("mail_id"));
				bean.setCol01(rs.getString("category_code_1"));
				bean.setCol02(rs.getString("category_code_2"));
				bean.setCol03(EnDecoding.decoding(rs.getString("category_name_1")));
				bean.setCol04(EnDecoding.decoding(rs.getString("category_name_2")));
				//bean.setCol05(rs.getString("to_mail"));	
				
//				bean.setCol01(EnDecoding.decoding(rs.getString("cate_code")));
//				bean.setCol02(EnDecoding.decoding(rs.getString("cate_name")));
//				bean.setCol03(EnDecoding.decoding(rs.getString("view_sort")));		
				
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
//
//	public ActionForward execute(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		WriteExeclTCategory category = new WriteExeclTCategory();
//		boolean writeExeclTCategoryResult = category.exec();
//		
//		KankokujinLogger.debug("writeExeclTCategoryResult=" + writeExeclTCategoryResult);
//		
//		if (writeExeclTCategoryResult) {
//			return mapping.findForward("success");
//		} else {
//			return mapping.findForward("fail");
//		}
//	}
}
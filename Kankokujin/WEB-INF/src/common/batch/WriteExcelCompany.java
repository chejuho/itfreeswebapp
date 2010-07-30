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
 * �J�e�S�����쐬
 * 
 * @author user
 * 
 */
public class WriteExcelCompany{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WriteExcelCompany writeExcelData = new WriteExcelCompany(); 
		boolean result = false;
		try {
			result = writeExcelData.exec();
		} catch (Exception e) {
			// TODO �����������ꂽ catch �u���b�N
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
			   HSSFSheet sheet1 = wb.createSheet("sheet1");
		   
			   HSSFRow row0 = sheet1.createRow(0);
			   
			   
			   row0.createCell((short)0).setCellValue("company");
			   row0.createCell((short)1).setCellValue("part_name");
			   row0.createCell((short)2).setCellValue("view_to_name");
			   row0.createCell((short)3).setCellValue("to_name");
			   row0.createCell((short)4).setCellValue("to_mail");

			   		
			   
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
					   
						sheet1.createRow(i+1).createCell((short)4).setCellValue(bean.getCol05());
						

					}
			   }

		      fileOut = new FileOutputStream(BatchConstant.COMPANY_TABLE_WRITEOUT_FILE);
		      wb.write(fileOut);
		      
			   
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
			   fileOut.close();
			   
		   }
	      return true;
	   }
	/**
	 * DB��CateForm��EXCEL�ŏ�������
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
			query = "select * from email_list";

			rs = st.executeQuery(query);

			while (rs.next()) {
				ItemBean bean = new ItemBean();
				//bean.setCol01(rs.getString("mail_id"));
				bean.setCol01(EnDecoding.decoding(rs.getString("company")));
				bean.setCol02(EnDecoding.decoding(rs.getString("part_name")));
				bean.setCol03(EnDecoding.decoding(rs.getString("view_to_name")));
				bean.setCol04(EnDecoding.decoding(rs.getString("to_name")));
				bean.setCol05(rs.getString("to_mail"));	
				
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
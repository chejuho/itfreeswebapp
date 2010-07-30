package common.batch.insertdata;

import item.bean.ItemBean;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import common.constant.Const;
import common.database.DBConnectionMgr;
import common.util.EnDecoding;


/**
 * カテゴリ情報追加
 * 
 * @author user
 * 
 */
public class InsertAreaXmlData{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InsertAreaXmlData insertAreaXmlData = new InsertAreaXmlData(); 
		try {
			Properties prop1 = insertAreaXmlData.createProperties("Const.AREA_1_XML");
			Properties prop2 = insertAreaXmlData.createProperties("Const.AREA_2_XML");
			SortedMap sortedMap = Collections.synchronizedSortedMap(new TreeMap(prop2)); 
			Set set2 = sortedMap.keySet();
			Iterator it2 = set2.iterator();
			
			while(it2.hasNext()){
				ItemBean itemBean = new ItemBean();
				String cate_code_2= (String)it2.next();
				String cate_code_1= cate_code_2.substring(0, 2);
				itemBean.setCol01(cate_code_1);
				itemBean.setCol02(cate_code_2);
				itemBean.setCol03(EnDecoding.encoding(prop1.getProperty(cate_code_1)));
				itemBean.setCol04(EnDecoding.encoding(prop2.getProperty(cate_code_2)));
				insertAreaXmlData.insertItem(itemBean);
				System.out.println("success");
			}
		} catch (InvalidPropertiesFormatException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			System.out.println("finished");	
		}

	}
	public Properties createProperties(String filePath) throws InvalidPropertiesFormatException, IOException {
		
		Properties prop = new Properties();
		
		InputStream stream;
			stream = new BufferedInputStream(new FileInputStream(filePath));
			prop.loadFromXML(stream);

		return prop;
	}
	public void insertItem(ItemBean itemForm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnectionMgr pool = DBConnectionMgr.getInstance();

		try {
			conn = pool.getConnection();
			pstmt = conn
					.prepareStatement("insert into t_area " +
					"(area_code_1, area_code_2, area_name_1, area_name_2)" +		
					"values (?,?,?,?)");
			pstmt.setString(1, itemForm.getCol01());
			pstmt.setString(2, itemForm.getCol02());
			pstmt.setString(3, itemForm.getCol03());
			pstmt.setString(4, itemForm.getCol04());
			
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
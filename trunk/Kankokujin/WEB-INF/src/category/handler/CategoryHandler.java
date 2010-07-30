package category.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import category.bean.CategoryBean;

import common.database.DBConnectionMgr;
import common.util.EnDecoding;

public class CategoryHandler {

	public String getCateTag(String cate_code, String code) {
		Map map = getCategoryMap(code);
		int kubun = 0;

		String product_code = "";
		String nowPage = "";
		String user_id = "";
		String changCateListToTag = changCateListToTag(cate_code, map, kubun, product_code, nowPage, user_id);
		System.out.println(changCateListToTag);

		return changCateListToTag;
	}

	public Map getCategoryMap(String code) {

		Statement stmt = null;
		ResultSet rs = null;
		String result = "";
		Map map = new TreeMap();
		Connection con = null;
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			
			String sql = "";
			if ("1".equals(code)) {
				sql = "SELECT cate_code, cate_name, view_sort from t_code1_category";
			} else if ("2".equals(code)) {
				sql = "SELECT cate_code, cate_name, view_sort from t_code2_category";	
			} else if ("3".equals(code)) {
				sql = "SELECT cate_code, cate_name, view_sort from t_code3_category";					
			} else {
				sql = "SELECT cate_code, cate_name, view_sort from t_code4_category";
			}
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CategoryBean cateForm = new CategoryBean();
				String cate_code = rs.getString(1);
				cateForm.setCate_code(cate_code);
				cateForm.setCate_name(EnDecoding.decoding(rs.getString(2)));
				cateForm.setView_sort(rs.getString(3));
				map.put(cate_code, cateForm);
			}

		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return map;
	}

	/**
	 * 
	 * @param cate_code
	 * @param map
	 * @param kubun
	 *            0; category, 1: ProductList, 2: display, 3: CateInput, 
	 *            4: ProductList, 5: myProductList, 6: MyProductOpenUpdate
	 *            7; ProductOpenUpdate, 8; ProductOpenInput, 9: MyProductOpenInput
	 *            10: productInfoDetail 11: CateUpdate
	 * @return
	 */
	public String changCateListToTag(String cate_code, Map map, int kubun, String product_code, String nowPage, String user_id) {
		Set set = map.keySet();
		Iterator it = set.iterator();
		StringBuffer sb = new StringBuffer();
		int count = 1;

		int a = count * 4;
		List list1 = getCategoryLengthList(a, map);
		Iterator it1 = list1.iterator();

		sb.append("<tr>");
		sb.append("<td>");
		sb.append("<select name=cateSelect");
		sb.append(count);
		sb.append(" onChange=\"");
		if (kubun == 1) {
			sb.append("loadPage(searchForm.cateSelect");
		} else if (kubun == 5){
			sb.append("loadPage(myProductForm.cateSelect");
		} else if (kubun == 6){
			sb.append("loadPage(myProduct.cateSelect");
		} else if (kubun == 7){
			sb.append("loadPage(productUpdateForm.cateSelect");
		} else if (kubun == 8){
			sb.append("loadPage(searchForm.cateSelect");
		} else if (kubun == 9){
			sb.append("loadPage(searchForm.cateSelect");
		} else if (kubun == 10){
			sb.append("loadPage(productInfoForm.cateSelect");
		} else if (kubun == 11){
			sb.append("loadPage(categoryForm.cateSelect");
		} else if(kubun == 12){
			sb.append("loadPage(fileForm.cateSelect");
		}else if (kubun == 13){
			sb.append("loadPage(fileForm.cateSelect");
		}else if (kubun == 14){
			sb.append("loadPage(listForm.cateSelect");			
		}else {
			sb.append("loadPage(categoryForm.cateSelect");
		}
		sb.append(count);
		sb.append(")");
		sb.append("\">");
		sb.append("\r\n");
		if (kubun == 0) {
			sb.append("<option value=CategoryList selected>カテゴリ");
		} else if (kubun == 1) {
			sb.append("<option value=ProductList.do selected>カテゴリ");
		} else if (kubun == 2) {
			sb.append("<option value=DisplayList.do selected>カテゴリ");
		} else if (kubun == 3) {
			sb.append("<option value=CategoryRegistOpen selected>カテゴリ");
		} else if (kubun == 5) {
			sb.append("<option value=MyProductList.do selected>カテゴリ");
		} else if (kubun == 6) {
			sb.append("<option value=MyProductOpenUpdate.do selected>カテゴリ");
		} else if (kubun == 7) {
			sb.append("<option value=ProductOpenUpdate.do?product_code=");
			sb.append(product_code);
			sb.append("&nowPage=");
			sb.append(nowPage);
			sb.append(" selected>カテゴリ");
		} else if (kubun == 8) {
			sb.append("<option value=ProductOpenInput.do selected>カテゴリ");
		} else if (kubun == 9) {
			sb.append("<option value=MyProductOpenInput.do selected>カテゴリ");
		} else if (kubun == 10) {
			sb.append("<option value=DisplayList.do selected>カテゴリ");
		} else if (kubun == 11) {
			sb.append("<option value=CategoryUpdateDeleteOpen selected>カテゴリ");
		}else if (kubun == 12) {
			sb.append("<option value=FileList.do selected>カテゴリ");
		}else if (kubun == 13) {
			sb.append("<option value=FileInput.do selected>カテゴリ");
		}else if (kubun == 14) {
			sb.append("<option value=ItemList selected>カテゴリ");			
		}
		sb.append("</option>");
		sb.append("\r\n");
		String cate_code1 = "";
		while (it1.hasNext()) {

			CategoryBean cateForm = (CategoryBean) it1.next();
			cate_code1 = cateForm.getCate_code();
			String cate_name = cateForm.getCate_name();
			if (kubun == 0) {
				sb.append("<option value=CategoryList?cate_code=");
			} else if (kubun == 1) {
				sb.append("<option value=ProductList.do?cate_code=");
			} else if (kubun == 2) {
				sb.append("<option value=DisplayList.do?cate_code=");
			} else if (kubun == 3) {
				sb.append("<option value=CategoryRegistOpen?cate_code=");
			} else if (kubun == 5) {
				sb.append("<option value=MyProductList.do?user_id=");
			} else if (kubun == 6) {
				sb.append("<option value=MyProductOpenUpdate.do?product_code=");
				sb.append(product_code);
				sb.append("&nowPage=");
				sb.append(nowPage);
				sb.append("&cate_code=");
			} else if (kubun == 7) {
				sb.append("<option value=ProductOpenUpdate.do?product_code=");
				sb.append(product_code);
				sb.append("&nowPage=");
				sb.append(nowPage);
				sb.append("&cate_code=");
			} else if (kubun == 8) {
				sb.append("<option value=ProductOpenInput.do?product_code=");
				sb.append(product_code);
				sb.append("&nowPage=");
				sb.append(nowPage);
				sb.append("&cate_code=");
			} else if (kubun == 9) {
				sb.append("<option value=MyProductOpenInput.do?product_code=");
				sb.append(product_code);
				sb.append("&nowPage=");
				sb.append(nowPage);
				sb.append("&cate_code=");
			} else if (kubun == 10) {
				sb.append("<option value=DisplayList.do?product_code=");
				sb.append(product_code);
				sb.append("&nowPage=");
				sb.append(nowPage);
				sb.append("&cate_code=");
			} else if (kubun == 10) {
				sb.append("<option value=CategoryUpdateDeleteOpen?product_code=");
			}else if (kubun == 12) {
				sb.append("<option value=FileList.do?cate_code=");
			} else if (kubun == 13) {
				sb.append("<option value=FileInput.do?file_code=");
				sb.append(cate_code);
				sb.append("&nowPage=");
				sb.append(nowPage);
				sb.append("&cate_code=");
			} else if (kubun == 14) {
				sb.append("<option value=ItemList?cate_code=");
				sb.append(cate_code1);
				sb.append("&nowPage=");
				sb.append(nowPage);
				if (user_id != null && !"".equals(user_id)) {
					sb.append("&user_id=");
					sb.append(user_id);
				}
				//sb.append("&cate_code=");				
			}
			
			if (kubun == 5 ){
				sb.append(user_id);
				sb.append("&cate_code=");
				sb.append(cate_code1);
			} else if (kubun != 14 ){
				sb.append(cate_code1);				
			} 
			
			sb.append(">");
			sb.append(cate_name);
			sb.append("</option>");
			sb.append("\r\n");
		}

		sb.append("</select></td>");
		sb.append("\r\n");

		if (kubun == 0) {
			// if ("9".equals(user_level)) {
			sb.append("<td><a href=");
			sb.append("CategoryRegistOpen");
			sb.append(">");
			sb.append("[　カテゴリー入力　]</a></td>");
			sb.append("\r\n");


			// }
		}

		sb.append("</tr>");
		sb.append("\r\n"); // -------カテゴリレベル1

		return sb.toString();
	}
	
	/**
	 * 
	 * @param cate_code
	 * @param map
	 * @param kubun
	 *            0; category, 1: ProductList, 2: display, 3: CateInput, 4: ProductList, 5: myProductList, 6: MyProductOpenUpdate
	 *            7; ProductOpenUpdate, 8; ItemInputOpen, 10: productInfoDetail
	 * @return
	 */
	public String getChildCateTag(String allCateCode, String fatherCateCode,
			Map map, int kubun, String item_code, String nowPage, String user_id) {
		Set set = map.keySet();
		Iterator it = set.iterator();
		int conut = fatherCateCode.length() / 4 + 1;
		StringBuffer sb = new StringBuffer();
		List list2 = getChildCategoryList(fatherCateCode, map);
		Iterator it2 = list2.iterator();

		boolean result = searchChildCate(fatherCateCode, map);
		if (result) {

			sb.append("<td>");
			sb.append("<select name=cateSelect");
			sb.append(conut);
			sb.append(" onChange=\"");
			if (kubun == 1) {
				sb.append("loadPage(searchForm.cateSelect");
			} else if (kubun == 5){
				sb.append("loadPage(myProductForm.cateSelect");
			} else if (kubun == 6){
				sb.append("loadPage(myProduct.cateSelect");
			} else if (kubun == 7){
				sb.append("loadPage(productUpdateForm.cateSelect");
			//ItemInputOpen
			} else if (kubun == 8){
				sb.append("loadPage(inputForm.cateSelect");
			} else if (kubun == 9){
				sb.append("loadPage(searchForm.cateSelect");
			} else if (kubun == 10){
				sb.append("loadPage(productInfoForm.cateSelect");
			} else if (kubun == 11){
				sb.append("loadPage(categoryForm.cateSelect");
			} else if (kubun == 12){
				sb.append("loadPage(fileForm.cateSelect");
			} else if (kubun == 13){
				sb.append("loadPage(fileForm.cateSelect");
			} else if (kubun == 14){
				sb.append("loadPage(listForm.cateSelect");				
			}else {
				sb.append("loadPage(categoryForm.cateSelect");
			}
			sb.append(conut);
			sb.append(")");
			sb.append("\">");
			sb.append("\r\n");
			if (kubun == 0) {
				sb.append("<option value=CategoryList?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 1) {
				sb.append("<option value=ProductList.do?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 2) {
				sb.append("<option value=DisplayList.do?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 3) {
				sb.append("<option value=CategoryRegistOpen?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 4) {
				sb.append("<option value=ProductList.do?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 5) {
				sb.append("<option value=MyProductList.do?user_id=");
				sb.append(user_id);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 6) {
				sb.append("<option value=MyProductOpenUpdate.do?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 7) {
				sb.append("<option value=ProductOpenUpdate.do?item_code=");
				sb.append(item_code);
				sb.append("&nowPage=");
				sb.append(nowPage);
				sb.append("&cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 8) {
				sb.append("<option value=ItemInputOpen.do?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 9) {
				sb.append("<option value=MyProductOpenInput.do?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 10) {
				sb.append("<option value=DisplayList.do?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			} else if (kubun == 11) {
				sb.append("<option value=CategoryUpdateDeleteOpen?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			}else if (kubun == 12) {
				sb.append("<option value=FileList.do?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			}else if (kubun == 13) {
				sb.append("<option value=FileInput.do?cate_code=");
				sb.append(fatherCateCode);
				sb.append(" selected>カテゴリ");
			}else if (kubun == 14) {
				sb.append("<option value=ItemList?cate_code=");
				sb.append(fatherCateCode);
				if (user_id != null && !"".equals(user_id)) {
					sb.append("&user_id=");
					sb.append(user_id);
				}
				sb.append(" selected>カテゴリ");				
			} 
			sb.append("</option>");
			sb.append("\r\n");
			String cate_code = "";
			String cate_code2 = "";
			while (it2.hasNext()) {
				CategoryBean cateForm = (CategoryBean) it2.next();
				cate_code = cateForm.getCate_code();
				String cate_name = cateForm.getCate_name();

				boolean selected = isSelected(allCateCode, cate_code);

				if (kubun == 0) {
					sb.append("<option value=CategoryList?cate_code=");
				} else if (kubun == 1) {
					sb.append("<option value=ProductList.do?cate_code=");
				} else if (kubun == 2) {
					sb.append("<option value=DisplayList.do?cate_code=");
				} else if (kubun == 3) {
					sb.append("<option value=CategoryRegistOpen?cate_code=");
				} else if (kubun == 4) {
					sb.append("<option value=ProductList.do?cate_code=");
				} else if (kubun == 5) {
					sb.append("<option value=MyProductList.do?user_id=");
				} else if (kubun == 6) {
					sb.append("<option value=MyProductOpenUpdate.do?product_code=");
					sb.append(item_code);
					sb.append("&nowPage=");
					sb.append(nowPage);
					sb.append("&cate_code=");
				} else if (kubun == 7) {
					sb.append("<option value=ProductOpenUpdate.do?product_code=");
					sb.append(item_code);
					sb.append("&nowPage=");
					sb.append(nowPage);
					sb.append("&cate_code=");
				} else if (kubun == 8) {
					sb.append("<option value=ItemInputOpen.do?item_code=");
					sb.append(item_code);
					sb.append("&nowPage=");
					sb.append(nowPage);
					sb.append("&cate_code=");
				} else if (kubun == 9) {
					sb.append("<option value=MyProductOpenInput.do?product_code=");
					sb.append(item_code);
					sb.append("&nowPage=");
					sb.append(nowPage);
					sb.append("&cate_code=");
				} else if (kubun == 10) {
					sb.append("<option value=DisplayList.do?product_code=");
					sb.append(item_code);
					sb.append("&nowPage=");
					sb.append(nowPage);
					sb.append("&cate_code=");
				} else if (kubun == 11) {
					sb.append("<option value=CategoryUpdateDeleteOpen?cate_code=");

				}else if (kubun == 12) {
					sb.append("<option value=FileList.do?cate_code=");
				}else if (kubun == 13) {
					sb.append("<option value=FileInput.do?");
					sb.append("&nowPage=");
					sb.append(nowPage);
					sb.append("&cate_code=");
				}else if (kubun == 14) {
					sb.append("<option value=ItemList?");
					sb.append("nowPage=");
					sb.append(nowPage);
					if (user_id != null && !"".equals(user_id)) {
						sb.append("&user_id=");
						sb.append(user_id);
					}
					sb.append("&cate_code=");					
				}
				if (kubun == 5 ){
					sb.append(user_id);
					sb.append("&cate_code=");
					sb.append(cate_code);
				} else {
					sb.append(cate_code);
				}

				if (selected == true) {
					cate_code2 = cateForm.getCate_code();
					sb.append(" selected");
				}

				sb.append(">");
				sb.append(cate_name);
				sb.append("</option>");
				sb.append("\r\n");
			}
			sb.append("</select>");

			sb.append("</td>");
		}
		if (allCateCode.length() > fatherCateCode.length()) {

			// sb.append("<td>");
			// if (allCateCode.equals(fatherCateCode)) {
			// sb.append("&nbsp;");
			// } else {
			// sb.append(">>");
			// }
			// sb.append("</td>");

		}
		sb.append("\r\n");

		if (kubun == 0) {
			if (!(fatherCateCode.equals("null"))) {
				if (allCateCode.length() == fatherCateCode.length()) {

					sb.append("<td><a href=");
					sb.append("CategoryRegistOpen");
					sb.append("?cate_code=");
					sb.append(fatherCateCode);
					sb.append(">");
					sb.append("[  カテゴリー入力　]</a></td>");
					sb.append("\r\n");
					sb.append("<td><a href=");
					sb.append("CategoryUpdateDeleteOpen?cate_code=");
					sb.append(fatherCateCode);
					sb.append(">");
					sb.append("[　カテゴリー修正、削除　]</a></td>");
				}
			}
		} else if (kubun == 4) {
			/*
			 * if (allCateCode.length() == fatherCateCode.length()) {
			 * sb.append("<td><a href="); sb.append("/ProductList.do");
			 * sb.append("?cate_code="); sb.append(fatherCateCode);
			 * sb.append(">"); sb.append("[ 商品登録 ]</a></td>");
			 * sb.append("\r\n"); }
			 */
		}

		sb.append("\r\n");

		return sb.toString();
	}

	public String getSearchChildCateTag(String allCateCode,
			String fatherCateCode, Map map) {

		StringBuffer sb = new StringBuffer();
		List list2 = getChildCategoryList(fatherCateCode, map);
		Iterator it2 = list2.iterator();

		boolean result = searchChildCate(fatherCateCode, map);
		if (result) {

			sb.append("<td>");
			String cate_code = "";
			String cate_code2 = "";
			while (it2.hasNext()) {
				CategoryBean cateForm = (CategoryBean) it2.next();
				cate_code = cateForm.getCate_code();
				String cate_name = cateForm.getCate_name();

				boolean selected = isSelected(allCateCode, cate_code);

				if (selected == true) {
					cate_code2 = cateForm.getCate_code();
					sb.append(cate_name);
				}
			}
			sb.append("</td>");
		}
		sb.append("\r\n");

		return sb.toString();
	}

	public String getAllViewTag(String cateCode, Map map, int kubun, String product_code, String nowPage, String user_id) {
		int count = cateCode.length() / 4;
		StringBuffer cateSelect = new StringBuffer();
		if (kubun == 4) {
			cateSelect.append("<a href=\"CategoryList?cate_code=");
		} 
		/*else {
			cateSelect.append("<a href=\"ProductList.do?cate_code=");
		}*/
		if (kubun == 4) {
		cateSelect.append(cateCode);
		cateSelect.append("\">");
		}
		for (int i = 0; i <= count; i++) {
			if (i > 0 && searchChildCate(cateCode.substring(
					0, 4 * i), map)) {
				cateSelect.append("<td>");
				cateSelect.append("&nbsp;>&nbsp;");
				cateSelect.append("</td>");
			}
			if (kubun == 4) {
				cateSelect.append(getSearchChildCateTag(cateCode, cateCode
						.substring(0, 4 * i), map));
			} else {
				cateSelect.append(getChildCateTag(cateCode, cateCode.substring(
						0, 4 * i), map, kubun, product_code, nowPage, user_id));
			}

		}
		cateSelect.append("</a>");
		return cateSelect.toString();
	}

	public boolean isSelected(String originalCode, String cateCode) {
		int cateCodeLength = cateCode.length();
		int originalCodeLength = originalCode.length();
		if (originalCodeLength >= cateCodeLength) {
			String oreginal = originalCode.substring(0, cateCodeLength);
			if (oreginal.equals(cateCode)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}

	}

	public String isCateCode(String originalCode, String cateCode) {
		int cateCodeLength = cateCode.length();
		int originalCodeLength = originalCode.length();
		if (originalCodeLength >= cateCodeLength) {
			String oreginal = originalCode.substring(0, cateCodeLength);
			if (oreginal.equals(cateCode)) {
				return oreginal;
			} else {
				return null;
			}

		} else {
			return null;
		}

	}

	public List getCategoryLengthList(int length, Map map) {
		Set set = map.keySet();
		Iterator it = set.iterator();
		List list = new ArrayList();
		while (it.hasNext()) {
			String cate_code1 = (String) it.next();
			if (cate_code1.length() == length) {

				CategoryBean cateForm = (CategoryBean) map.get(cate_code1);
				list.add(cateForm);
			}
		}
		return list;
	}

	public boolean searchChildCate(String cateCode, Map map) {
		int cateCodeLength = cateCode.length();
		int nextchildlength = cateCodeLength + 4;
		boolean result = false;
		Set set = map.keySet();
		Iterator it = set.iterator();
		List list2 = getChildCategoryList(cateCode, map);
		Iterator it2 = list2.iterator();
		while (it2.hasNext()) {
			CategoryBean cateForm = (CategoryBean) it2.next();
			String cateChildCode = cateForm.getCate_code();
			int cateChileCodeLength = cateChildCode.length();

			if (nextchildlength == cateChileCodeLength
					|| cateCode.equals(cateChildCode.substring(0,
							cateCodeLength))) {

				result = true;
				break;
			}
		}
		return result;
	}

	public List getChildCategoryList(String fatherCateCode, Map map) {
		Set set = map.keySet();
		Iterator it = set.iterator();
		List list = new ArrayList();
		int a = fatherCateCode.length() + 4;
		int b = fatherCateCode.length();
		while (it.hasNext()) {
			String cate_code1 = (String) it.next();

			if (cate_code1.length() == a
					&& fatherCateCode.equals(cate_code1.substring(0, b))) {

				CategoryBean cateForm = (CategoryBean) map.get(cate_code1);

				list.add(cateForm);
			}
		}
		return list;
	}

	public boolean categoryDelete(String cate_code, String code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuffer query = new StringBuffer();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			query.append("delete from t_code");
			query.append(code);
			query.append("_category where cate_code=?");
			pstmt = con
					.prepareStatement(query.toString());
			pstmt.setString(1, cate_code);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("categoryDelete Success");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con);
		} finally {
			
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				DBConnectionMgr.getInstance().freeConnection(con);
		}
		return false;

	}

	public boolean categoryUpdate(String cate_code, String cate_code1,
			String cate_name1, String code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			System.out.println("");
			System.out.println("--categoryUpdate start --");
			
			StringBuffer query = new StringBuffer();
			query.append("update t_code");
			query.append(code);
			query.append("_category set cate_code=?,cate_name=? where cate_code='"
					+ cate_code + "'");

			con = DBConnectionMgr.getInstance().getConnection();
			pstmt = con.prepareStatement(query.toString());

			pstmt.setString(1, cate_code1);
			pstmt.setString(2, cate_name1);

			int count = pstmt.executeUpdate();

			if (count == 1) {
				result = true;
				System.out.println("categoryUpdate success");
			}
		} catch (Exception e) {
			System.out.println("categoryUpdate error:" + e);
			DBConnectionMgr.getInstance().freeConnection(con);
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return result;
	}

	public boolean categoryInput(String cate_code, String cate_name, String code) {
		// method

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		try {
			sql.append("insert into ");
			if("1".equals(code)){
				sql.append("t_code1_category ");
			}else if (code.equals("2")){
				sql.append("t_code2_category ");
			}else if (code.equals("3")){
				sql.append("t_code3_category ");
			}else{
				sql.append("t_code4_category ");
			}
			sql.append("(cate_code,cate_name, view_sort) values (?, ?, ?)");

			con = DBConnectionMgr.getInstance().getConnection();

			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, cate_code);
			pstmt.setString(2, cate_name);
			pstmt.setString(3, code);

			int cnt = pstmt.executeUpdate();

			if (cnt == 1) {
				result = true;
				System.out.println("categoryInput success");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DBConnectionMgr.getInstance().freeConnection(con);
			if (con != null) {
				DBConnectionMgr.getInstance().freeConnection(con);
			}
		}

		return result;
	}

	public String categoryMax(String fatherCate_code, Map map) {

		Set set = map.keySet();
		Iterator it = set.iterator();
		String cateCodeMax = fatherCate_code + "0000";
		String cateCodeMaxUp = "";
		int fatherCate_codeLength = fatherCate_code.length();

		int cateCateLength = fatherCate_codeLength + 4;
		if ("".equals(fatherCate_codeLength) && map.size() == 0) {
			cateCodeMaxUp = "0001";
		} else {
			while (it.hasNext()) {

				String cate_code1 = (String) it.next();

				if (cate_code1.length() > fatherCate_code.length()) {
					String cate = cate_code1
							.substring(0, fatherCate_codeLength);
					if (cate_code1.length() == cateCateLength
							&& cate.equals(fatherCate_code)) {

						if ("".equals(cateCodeMax)) {
							cateCodeMax = cate_code1;
						} else if (0 < cate_code1.compareTo(cateCodeMax)) {

							cateCodeMax = cate_code1;
						}
					}
				}

			}

			String cate2 = cateCodeMax.substring(fatherCate_codeLength,
					cateCateLength);
			if (cate2 != null) {

				int cateMax = Integer.parseInt(cate2);
				int cateMaxUp = cateMax + 1;

				if (cateMaxUp < 10) {

					cateCodeMaxUp = "000" + cateMaxUp;
				} else if (cateMaxUp < 100) {
					cateCodeMaxUp = "00" + cateMaxUp;
				} else if (cateMaxUp < 1000) {
					cateCodeMaxUp = "0" + cateMaxUp;
				}
			} else {
				cateCodeMaxUp = "0001";
			}
		}
		return fatherCate_code + cateCodeMaxUp;
	}

	public String getCateName(String cate_code, String code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			
			con = DBConnectionMgr.getInstance().getConnection();
			StringBuffer query = new StringBuffer();
			query.append("select cate_name from t_code");
			query.append(code);
			query.append("_category where cate_code='"
					+ cate_code + "'");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query.toString());
			if (rs.next()) {
				String cate_name = rs.getString("cate_name");

				return cate_name;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return null;
	}

	public String AllSiteMapToTag(Map map) {
		Set set = map.keySet();
		Iterator it = set.iterator();
		StringBuffer sb = new StringBuffer();
		int conut = 1;

		int a = conut * 4;
		List list1 = getCategoryLengthList(a, map);
		Iterator it1 = list1.iterator();

		String cate_code1 = "";
		while (it1.hasNext()) {

			CategoryBean cateForm = (CategoryBean) it1.next();
			cate_code1 = cateForm.getCate_code();
			String cate_name = cateForm.getCate_name();
			sb.append("<tr><td>");
			sb.append(cate_name);
			sb.append("</td></tr>");
			sb.append("\r\n");
		}
		return sb.toString();
	}

	public String getChildSiteMapTag(String allCateCode, String cate_code,
			Map map) {
		Set set = map.keySet();
		Iterator it = set.iterator();
		int conut = cate_code.length() / 4 + 1;
		StringBuffer sb = new StringBuffer();
		List list2 = getChildCategoryList(cate_code, map);
		Iterator it2 = list2.iterator();

		String cate_code1 = "";
		String cate_code2 = "";
		while (it2.hasNext()) {
			CategoryBean cateForm = (CategoryBean) it2.next();
			cate_code1 = cateForm.getCate_code();
			String cate_name = cateForm.getCate_name();

			boolean selected = isSelected(allCateCode, cate_code1);

			sb.append("<tr><td>");
			sb.append(cate_name);

			if (selected == true) {
				cate_code2 = cateForm.getCate_code();
				sb.append(" selected");
			}
			sb.append("</td></tr>");
			sb.append("\r\n");
		}
		return sb.toString();
	}

	public String getAllMapTag(String fathercateCode, Map map) {
		Set set = map.keySet();
		Iterator it = set.iterator();
		StringBuffer sb = new StringBuffer();

		while (it.hasNext()) {
			String cateCode = (String) it.next();
			// String cate_code1 = map.
			// String cate_name = cateForm.getCate_name();
			sb.append("<p>");
			String cate = cateCode.substring(0, fathercateCode.length());
			if (cateCode.length() == fathercateCode.length() + 4
					&& cate.equals(fathercateCode)) {
				// String ChildTag = getChildTag(cateCode,map,sb);
				String ChildTag = "childtag";
				if (ChildTag != null) {
					sb.append(ChildTag);
					sb.append("<br>");
				}
			}
			sb.append("<tr><td>");
			// sb.append(cate_name);
			sb.append("</td></tr>");
			sb.append("\r\n");
		}
		return sb.toString();
	}

	public String getChildTag(String fathercateCode, Map map, StringBuffer sb) {
		Set set = map.keySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {

			String cateCode = (String) it.next();
			CategoryBean cateForm = (CategoryBean) map.get(cateCode);
			String cateName = cateForm.getCate_name();
			if (cateCode.length() > fathercateCode.length()) {
				String fatherLengthCate = cateCode.substring(0, fathercateCode
						.length());
				if (cateCode.length() == fathercateCode.length() + 4
						&& fatherLengthCate.equals(fathercateCode)) {
					if (!("".equals(fathercateCode))) {
						addString(fathercateCode, sb);
					}
					sb.append("<a href=\"");
					sb.append("/ProductList.do");
					sb.append("?cate_code=");
					sb.append(cateCode);
					sb.append("\">");
					sb.append(cateName);
					sb.append("</a>");

					/*
					 * sb.append("<a href=\"/ProductList.do?cate_code=");
					 * sb.append(cateCode); sb.append("\">"); sb.append("
					 * ここに商品登録"); sb.append("</a>");
					 */

					sb.append("<br>");
					sb.append("\r\n");

					getChildTag(cateCode, map, sb);

				}
			}
		}
		return sb.toString();
	}

	private void addString(String cateCode, StringBuffer sb) {
		if (cateCode != null && cateCode.length() != 0) {
			for (int i = 0; i < cateCode.length() / 4; i++) {
				sb.append("--");
			}
		}

	}


	// menu
	public String getCategoryMenuList(String category1, String category2) {

		Statement stmt = null;
		ResultSet rs = null;
		String result = "";
		Connection con = null;
		Map map = new TreeMap();
		try {
			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();

			StringBuffer sbSql = new StringBuffer();
			sbSql
					.append("SELECT cate_code, cate_name from t_category where cate_code like '"
							+ category1 + "%'");
			rs = stmt.executeQuery(sbSql.toString());
			while (rs.next()) {
				CategoryBean bean = new CategoryBean();
				String cate_code = rs.getString(1);
				bean.setCate_code(cate_code);
				bean.setCate_name(EnDecoding.decoding(rs.getString(2)));
				map.put(cate_code, bean);
			}
			result = editCetegoryMenuList(category1, category2, map);
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return result;
	}

	public ArrayList getSearchCategory(String searchCategory,
			String searchSelect) {

		ArrayList searchlist = new ArrayList();
		StringTokenizer searchTokenizer = null;
		int kubun = 0;// (0 : 一般 １：and 検索 ２：or 検索 )
		// and 検索
		if (searchCategory.indexOf("+") != -1) {
			kubun = 1;
			searchTokenizer = new StringTokenizer(searchCategory, "+");
			// or 検索
		} else if (searchCategory.indexOf(" ") != -1) {
			kubun = 2;
			searchTokenizer = new StringTokenizer(searchCategory, " ");
		} 
		if (searchTokenizer != null) {
			while (searchTokenizer.hasMoreTokens()) {
				String nextToken = searchTokenizer.nextToken();
				searchlist.add(nextToken.trim());
			}
		} else {
			searchlist.add(searchCategory);
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();
		StringBuffer sb = new StringBuffer();
		try {
			
			sb.append("select cate_code from t_category  ");			

			Iterator it = searchlist.iterator();
			if (it.hasNext()) {
				
				sb.append("where cate_name like '%");
				sb.append((String) it.next());
				sb.append("%'");
			}

			while (it.hasNext()) {
				String search = (String) it.next();

				if (kubun == 1) {
					sb.append(" and");
				} else if (kubun == 2) {
					sb.append(" or");
				}
				sb.append(" cate_name like '%");
				sb.append(search);
				sb.append("%'");
			}

			con = DBConnectionMgr.getInstance().getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sb.toString());

			System.out.println(sb.toString());
			while (rs.next()) {
	
				CategoryBean cateForm = new CategoryBean();
				String cateCode = rs.getString(1);
				cateForm.setCate_code(cateCode);
				list.add(cateForm);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;

	}

	public int searchString(String searchProduct, String search) {
		int aa = searchProduct.indexOf(search);
		return aa;
	}

	public int searchLastString(String searchProduct, String search) {
		int aa = searchProduct.lastIndexOf(search);
		return aa;
	}

	/**
	 * 大カテゴリ情報を取得する
	 * 
	 * @return List（大カテゴリ名のリスト）
	 * 
	 */
	public List getCategory1Info() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();

		try {
			con = DBConnectionMgr.getInstance().getConnection();
			String sql = "select * from t_category where cate_2=0000 order by cate_1 asc";

			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CategoryBean bean = new CategoryBean();
				// bean.setCate_1(rs.getString("cate_1"));
				// bean.setCate_name1(EnDecoding.decoding(rs
				// .getString("cate_name1")));

				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;
	}

	public List getCategory2Info(String cate_1) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		String sql = "";
		try {
			con = DBConnectionMgr.getInstance().getConnection();

			sql = "select * from t_category where cate_1=" + cate_1
					+ " and cate_2!=0000 and cate_3 = 0000";

			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CategoryBean bean = new CategoryBean();
				// bean.setCate_2(EnDecoding.decoding(rs.getString("cate_2")));
				// bean.setCate_name2(EnDecoding.decoding(rs
				// .getString("cate_name2")));

				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;
	}

	public List getCategory3Info(String cate_1, String cate_2) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		String sql = "";
		try {
			con = DBConnectionMgr.getInstance().getConnection();

			sql = "select * from t_category where cate_1=" + cate_1
					+ " and cate_2=" + cate_2 + " and cate_3 != 0000";

			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CategoryBean bean = new CategoryBean();
				// bean.setCate_3(EnDecoding.decoding(rs.getString("cate_3")));
				// bean.setCate_name3(EnDecoding.decoding(rs
				// .getString("cate_name3")));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		} finally {
			DBConnectionMgr.getInstance().freeConnection(con, stmt, rs);
		}
		return list;
	}

	/**
	 * 大カテゴリ情報を取得する
	 * 
	 * @return List（大カテゴリ名のリスト）
	 * 
	 */
	public String getCategory1InfoToTag(List list) {
		Iterator it = list.iterator();
		StringBuffer sb = new StringBuffer();
		final String STR_TR_S = "<TR>";
		final String STR_TR_E = "</TR>";
		final String STR_TD_S = "<TD>";
		final String STR_TD_E = "</TD>";
		sb.append(STR_TR_S);
		while (it.hasNext()) {
			String categoryName = (String) it.next();
			sb.append(STR_TD_S);
			sb
					.append("<a href='main/jjtop.jsp' onclick='javascript:board('testcategorycode');'>");
			sb.append(categoryName);
			sb.append("</a>");
			sb.append(STR_TD_E);
			sb.append("\r\n");
		}
		sb.append(STR_TR_E);
		return sb.toString();

	}

	public String editCetegoryMenuList(String category1, String category2,
			Map map) {
		Set set = map.keySet();
		Iterator it = set.iterator();
		StringBuffer sb = new StringBuffer();
		int count = 0;
		// while (it.hasNext()) {
		// String codeNo = (String)it.next();
		// String category1 = codeNo.substring(0, 4);
		// String category2 = codeNo.substring(4, 8);
		// if ("0000".equals(category2)) {
		// combineList(sb, category1, map, count++);
		// } else {
		// combineList(sb, category1 + category2, map, count++);
		// }
		// }
		// combineList(sb, category1, category2, map, count++);
		// System.out.println(sb.toString());
		return sb.toString();
	}

	public String getMenuTag(String code, String cateCode, Map map) {
		String fatherCateCode = "";
		if (cateCode != null && !"".equals(cateCode)) {
			int cateLength = cateCode.length();
			if (cateLength >= 8) {
				fatherCateCode = cateCode.substring(0, cateLength-4);
			}	
		}
		if (cateCode != null && !"".equals(cateCode)) {
//			boolean result = searchChildCate(cateCode, map);
//			if (!result) {
//				cateCode = fatherCateCode;
//				if (fatherCateCode.length() >= 4) {
//					fatherCateCode = fatherCateCode.substring(0, fatherCateCode.length() - 4);	
//				} else {
//					fatherCateCode = "";
//				}
//				
//			}

		} else {
			cateCode = "";
			fatherCateCode = "";
		}
		return combineList(code, new StringBuffer(), fatherCateCode, cateCode, map, 0)
				.toString();
	}

	public StringBuffer combineList(String code, StringBuffer sb, String fatherCateCode, String cateCode, 
			Map map, int count) {
		// CateForm bean = (CateForm) map.get(cateCode + "00000000");
		if (fatherCateCode == null || "null".equals(fatherCateCode)) {
			fatherCateCode = "";
		}
		Set set = map.keySet();
		Iterator it = set.iterator();
		boolean isFirst = true;
		boolean isExist = false;
		boolean isWrite = false;
		boolean existChild = false;
		boolean existImage = false;
		// addSiteUrlToMap(map);
		String brotherCode = "";

		CategoryBean fatherBean = (CategoryBean) map.get(fatherCateCode);
		int fatherLength = fatherCateCode.length();
		if (fatherLength >= 4 && fatherBean != null) {
			sb.append("		<a href='");
			sb.append("ItemList?cate_code="
					//+ fatherCateCode.substring(0, fatherLength - 4));					
					+ fatherCateCode);
			sb.append("'>");
			sb.append(fatherBean.getCate_name());
			sb.append("</a>");
			sb.append("\r\n");
		}

		sb.append("<table border='0' Xwidth='100%' id=ttable>");

		while (it.hasNext()) {
			String tempCodeNo = (String) it.next();
			int fatherCodeLength = fatherCateCode.length();
			CategoryBean tempBean = (CategoryBean) map.get(tempCodeNo);
			if ((tempCodeNo.length() == fatherCodeLength + 4)
					&& fatherCateCode.equals(tempCodeNo.substring(0,
							fatherCodeLength))) {
				isExist = true;

				brotherCode = tempCodeNo;
				if (isFirst) {

					isFirst = false;
				} else if (existChild || !isFirst) {
					sb.append("</td></tr>");
					existChild = false;
					isFirst = false;
				} else {
					isFirst = false;
				}

				sb.append("<tr>");
				sb.append("\r\n");
				existImage = searchChildCate(tempCodeNo, map);
				if (existImage) {
					sb
					.append("		<td width='9' onclick='openClose("
							+ (++count)
							+ ");'><img src='jsp/images/menu/menu_minus.gif' width=9 height=9 alt='' border='0'></td>");					
				} else {
					sb
					.append("		<td width='9'></td>");	
				}

				sb.append("\r\n");
				//sb.append("<H2>");
				sb.append("		<td>");
				sb.append("\r\n");
				sb.append("<a href='ItemList?");

				sb.append("cate_code=");
				sb.append(tempCodeNo);
				sb.append("'");
				//sb.append("' onclick=menuClicked('");
				
				//sb.append(tempCodeNo);
				//sb.append("');>");
				sb.append(">");
				
				
				sb.append(tempBean.getCate_name());
				sb.append("</a>");
				sb.append("\r\n");
				sb.append("		</td>");
				//sb.append("</H2>");
				sb.append("\r\n");
				sb.append("	</tr>");
				sb.append("\r\n");
				sb.append("	<tr>");				
				sb.append("\r\n");
				sb.append("		<td width='9'></td>");
				sb.append("\r\n");
				// sb.append("<H1 id='myid'>");
				sb.append("		<td>");
				sb.append("\r\n");
				sb.append("\r\n");

			} else if ((tempCodeNo.length() == fatherCodeLength + 8)
					&& brotherCode.equals(tempCodeNo.substring(0, brotherCode
							.length())) && !isFirst) {
				existChild = true;
				sb.append("	-- <a href='");
				sb.append("ItemList?cate_code=" + tempCodeNo);
				sb.append("'>");
//				sb.append("' onclick=menuClicked('" + tempCodeNo
//						+ "');>");
				sb.append("&nbsp;&nbsp;" + tempBean.getCate_name());
				if (searchChildCate(tempCodeNo, map)) {
					
					sb.append("(<img src='jsp/images/menu/menu_plus.gif' width=9 height=9 alt='' border='0'>)");
				}				
				if (existImage) {
					sb.append("</a>");
				}
				

				sb.append("<br>");
				sb.append("\r\n");
				// } else if (isExist && tempCodeNo.length() == fatherCodeLength
				// && !fatherCateCode.equals(tempCodeNo)) {
				// sb.append(" </td>");
				// sb.append("\r\n");
				// sb.append(" </tr>");
				// sb.append("\r\n");
				// sb.append("<br>");
				// isWrite = true;
				// isFirst = true;

			}
		}
		if (!isWrite) {
			sb.append("		</td>");
			sb.append("\r\n");
			sb.append("		</tr>");
			sb.append("\r\n");
		}
		sb.append("</table>");
		return sb;
	}

	public void addChildTag(StringBuffer sb, String fatherCode, Map map) {
		Set set = map.keySet();

	}
}
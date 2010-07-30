package item.action;

import item.bean.ItemBean;
import item.handler.ItemHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.bean.CategoryBean;
import category.handler.CategoryHandler;

public class ItemUpdateOpenAction extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {	
		//product情報
		String itemCode = request.getParameter("itemCode");
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		if (itemCode == null ) {
			itemCode = (String) request.getAttribute("itemCode");
		}
		ItemHandler handler = new ItemHandler();		
		ItemBean itemInfo = null;
		try {
			itemInfo = handler.getItemInfo(itemCode);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.setAttribute("itemInfo",itemInfo);
		
		
		//カテゴリ
		String cate_code = request.getParameter("cate_code");
		if (cate_code == null){
			cate_code  = (String) request.getAttribute("cate_code");
			
		}	
		if (cate_code==null || "null".equals(cate_code)){
			cate_code ="";
		}
		CategoryHandler category = new CategoryHandler();
		
		Map map = (Map)session.getAttribute("categoryMap");
		
		String categorySelect = "";
		
		String nowPage = "";
		nowPage = request.getParameter("nowPage");
		if (nowPage == null ) {
			nowPage = (String) request.getAttribute("nowPage");
		}
		
		String user_id = "";
		user_id = request.getParameter("user_id");
		if (user_id == null ) {
			user_id = (String) request.getAttribute("user_id");
		}
		
		if("".equals(cate_code)) {
			categorySelect = category.changCateListToTag(null,map, 14, itemCode, nowPage, user_id);
		} else {
			categorySelect = category.getAllViewTag(cate_code,map, 14, itemCode, nowPage, user_id);
		}
		
		request.setAttribute("CategorySelect", categorySelect);
		request.setAttribute("cate_code", cate_code);
		request.setAttribute("nowPage", nowPage);
		
		CategoryBean cateForm= (CategoryBean)map.get(cate_code);
		String viewSort = "";
		if (cateForm == null) {
			viewSort = "1";
		} else {			
			viewSort = cateForm.getView_sort();
		}
		
		String foward = "success";
		if (viewSort != null && !"".equals(viewSort)) {
			foward = viewSort;
		} 
		this.getServletContext().getRequestDispatcher("/jsp/item/itemList.jsp").forward(request, response);
	}
}
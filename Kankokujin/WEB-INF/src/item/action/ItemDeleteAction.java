package item.action;

import item.handler.ItemHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.handler.CategoryHandler;

public class ItemDeleteAction extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		
		String user_id = request.getParameter("user_id");
		if (user_id == null) {
			user_id = "";		
		}
		HttpSession session = request.getSession();
		Map map = (Map)session.getAttribute("categoryMap");	
		String itemCode = request.getParameter("itemCode");
		String cateCode = request.getParameter("cate_code");
		ItemHandler handler = new ItemHandler();
		String foward = "fail";
		try {
			if (handler.deleteItem(itemCode)) {
				foward = "success";
			}
		} catch (SQLException e) {
			// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
			e.printStackTrace();
		}
		String nowPage = "";
		String categorySelect = "";
		CategoryHandler category = new CategoryHandler();
		if("".equals(cateCode)) {
			categorySelect = category.changCateListToTag(null,map, 14, itemCode, nowPage, user_id);
		} else {
			categorySelect = category.getAllViewTag(cateCode,map, 14, itemCode, nowPage, user_id);
		}
		request.setAttribute("cate_code", cateCode);
		request.setAttribute("CategorySelect", categorySelect);
		request.setAttribute("user_id", user_id);
		this.getServletContext().getRequestDispatcher(
		"/jsp/item/itemList.jsp").forward(request, response);
	}
}
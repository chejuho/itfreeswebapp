package category.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.util.EnDecoding;

import category.handler.CategoryHandler;


public class CategoryUpdateDeleteOpenAction extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)	throws IOException, ServletException {
		
		String cate_code = request.getParameter("cate_code");
		HttpSession session = request.getSession();
		
		if (cate_code == null || "null".equals(cate_code)){
			cate_code ="";
		}

		CategoryHandler category = new CategoryHandler();
		String code = (String)session.getAttribute("code");
		Map map = (Map)session.getAttribute("categoryMap");
		if (map == null) {
			map = category.getCategoryMap(code);
			session.setAttribute("categoryMap", map);
		}
		
		String categorySelect = "";
		
		String user_id = "";
		user_id = request.getParameter("user_id");
		
		if(cate_code == null) {
			
			categorySelect = category.changCateListToTag(null, map, 11, "", "", user_id);
		
		} else {
			
			categorySelect = category.getAllViewTag(cate_code, map, 11, "", "", user_id);
		
		}
		
		CategoryHandler categoryhandler = new CategoryHandler();
		String cate_name = EnDecoding.decoding(categoryhandler.getCateName(cate_code, code));
		request.setAttribute("CategorySelect", categorySelect);
		request.setAttribute("cate_name", cate_name);
		request.setAttribute("cate_code", cate_code);
		this.getServletContext().getRequestDispatcher("/jsp/category/categoryUpdateDelete.jsp").forward(request, response);
		//return mapping.findForward("CategoryUpdateDelete");

	}
}

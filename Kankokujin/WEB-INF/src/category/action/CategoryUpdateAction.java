package category.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.util.Util;

import category.handler.CategoryHandler;

public class CategoryUpdateAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (Util.hasPrivilege(request)) {
			String cate_code = request.getParameter("cate_code");
			String cate_code1 = request.getParameter("cate_code1");
			String cate_name = request.getParameter("cate_name");
			String cate_name1 = request.getParameter("cate_name1");
			HttpSession session = request.getSession();
			String code = (String) session.getAttribute("code");
			CategoryHandler category = new CategoryHandler();

			boolean b1 = category.categoryUpdate(cate_code, cate_code1,
					cate_name1, code);

			if (b1 == true) {
				String user_id = "";
				user_id = request.getParameter("user_id");

				Map map = category.getCategoryMap(code);
				String categoryList = category.changCateListToTag(cate_code,
						map, 0, "", "", user_id);
				request.setAttribute("CategoryList", categoryList);
				this.getServletContext().getRequestDispatcher("/CategoryList")
						.forward(request, response);
			} else {
				request.setAttribute("cate_code", cate_code);
				request.setAttribute("cate_name", cate_name);
				this.getServletContext().getRequestDispatcher(
						"/CategoryUpdateDeleteOpen").forward(request, response);
			}
		} else {
			this.getServletContext().getRequestDispatcher("/").forward(request,
					response);
		}
	}
}
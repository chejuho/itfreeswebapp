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

public class CategoryRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (Util.hasPrivilege(request)) {
			String cate_code = request.getParameter("cate_code");
			HttpSession session = request.getSession();
			String code = (String) session.getAttribute("code");
			String cate_code1 = (String) request.getAttribute("cate_code");
			if (cate_code == null || "null".equals(cate_code)) {
				cate_code = "";
			}

			CategoryHandler category = new CategoryHandler();

			Map map = category.getCategoryMap(code);

			String categorySelect = "";

			String user_id = "";
			user_id = request.getParameter("user_id");

			if ("".equals(cate_code)) {

				categorySelect = category.changCateListToTag(null, map, 3, "",
						"", user_id);

			} else {

				categorySelect = category.getAllViewTag(cate_code, map, 3, "",
						"", user_id);

			}

			if (cate_code1 != null) {

				categorySelect = category.getAllViewTag(cate_code1, map, 3, "",
						"", user_id);
			}

			request.setAttribute("CategorySelect", categorySelect);

			request.setAttribute("cate_code", cate_code);
			this.getServletContext().getRequestDispatcher(
					"/jsp/category/categoryRegist.jsp").forward(request,
					response);
		} else {
			this.getServletContext().getRequestDispatcher("/").forward(request,
					response);
		}

	}
}
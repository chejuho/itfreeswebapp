package item.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

import category.handler.CategoryHandler;

public class ItemRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String foward = "/jsp/item/itemRegist.jsp";
		try {

			// ÉJÉeÉSÉä
			String cate_code = request.getParameter("cate_code");

			if (cate_code == "") {
				foward = "/jsp/item/itemList.jsp";
			}

			if (cate_code == null) {
				cate_code = (String) request.getAttribute("cate_code");

			}
			if (cate_code == null || "null".equals(cate_code)) {
				cate_code = "";
			}
			CategoryHandler category = new CategoryHandler();

			HttpSession session = request.getSession();
			String code = (String)session.getAttribute("sort_code");
			if (Util.isEmpty(code)) {
				code = "1";
			}
			Map map = category.getCategoryMap(code);

			String categorySelect = "";

			String nowPage = "";
			nowPage = request.getParameter("nowPage");

			String user_id = "";
			user_id = request.getParameter("user_id");

			String product_code = "";

			if ("".equals(cate_code)) {
				categorySelect = category.changCateListToTag(null, map, 8,
						product_code, nowPage, "");
			} else {
				categorySelect = category.getAllViewTag(cate_code, map, 8,
						product_code, nowPage, "");
			}

			request.setAttribute("CategorySelect", categorySelect);
			request.setAttribute("cate_code", cate_code);
//		} catch (AppException e) {
//			throw new KankokujinException("ItemRegistOpenAction", e);
		} catch (Exception e) {
			throw new KankokujinException("ItemRegistOpenAction", e);
		} finally {
			KankokujinLogger.getInstance().debug("ItemRegistOpenAction.end");
		}
		this.getServletContext().getRequestDispatcher(foward).forward(request,
				response);

	}
}
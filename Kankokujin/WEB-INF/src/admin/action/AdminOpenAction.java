package admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util.Util;

public class AdminOpenAction extends HttpServlet {
	/**
	 * InteroretList���J��
	 * 
	 * @param request
	 *            response
	 * @return BuySellBean�ABuySellSortBean�APageBean�ABuySellBeanList�̏��𑗂�
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// �����`�F�b�N
		if (Util.hasPrivilege(request)) {
			this.getServletContext().getRequestDispatcher(
					"/jsp/admin/admin_index.jsp").forward(request, response);

		} else {
			request.setAttribute("Message", "Message");
			this.getServletContext().getRequestDispatcher("/AdminLoginOpen")
					.forward(request, response);
		}

	}

}
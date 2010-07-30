package aflashcard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.bean.MemberBean;

public class AFlashcardMemberRegistOpenAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String errorMsg = (String) session.getAttribute("Msg");
		MemberBean memberBean = (MemberBean) session.getAttribute("tempMemberBean");
		session.removeAttribute("Msg");
		session.removeAttribute("tempMemberBean");
		if (errorMsg != null) {
			request.setAttribute("Msg", errorMsg);
			request.setAttribute("tempMemberBean", memberBean);
		}
		this.getServletContext().getRequestDispatcher("/jsp/aflashcard/aflashcardMemRegist.jsp").forward(request, response);

	}

}

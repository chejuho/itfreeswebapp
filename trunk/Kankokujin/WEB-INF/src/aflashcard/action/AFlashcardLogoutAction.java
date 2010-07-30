package aflashcard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aflashcard.handle.AFlashcardUtil;
public class AFlashcardLogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		boolean mobileSign = false;
		String userId = (String) session.getAttribute("userId");
		mobileSign = AFlashcardUtil.getMobileSign(request);
		session.invalidate();
		HttpSession newSession = request.getSession(true);
		if (mobileSign) {
			newSession.setAttribute("m", "t");
		}
		String actionName = "list?userId=" + userId;
		response.sendRedirect(actionName);
	}
}

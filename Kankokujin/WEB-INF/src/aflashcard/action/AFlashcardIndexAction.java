package aflashcard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AFlashcardIndexAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String localuserId = request.getParameter("localUserId");
		if (localuserId == null) {
			localuserId = "";
		}
		if (uri.indexOf("mflashcard") >= 0) {
			if (uri.endsWith("/")) {
				response.sendRedirect(uri.replaceAll("mflashcard", "list") + "?m=t&localuserId" + localuserId);
			} else {
				response.sendRedirect(uri.replaceAll("mflashcard", "list") + "?m=t&localuserId" + localuserId);
			}
		} else {
			if (uri.endsWith("/")) {
				response.sendRedirect(uri + "list");
			} else {
				System.out.println(uri.replaceAll("flashcard", "list"));
				response.sendRedirect(uri.replaceAll("flashcard", "list") + "?localuserId" + localuserId);
			}
		}
	}
}

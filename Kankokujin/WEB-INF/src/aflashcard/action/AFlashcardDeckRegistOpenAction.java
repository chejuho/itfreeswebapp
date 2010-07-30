package aflashcard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;

public class AFlashcardDeckRegistOpenAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String contentType = request.getContentType();
		
		String userId = "";
		String categoryCode = "";
		String title = "";
		String user_name = ""; 
		if (contentType.indexOf("multipart") >= 0) {
			String saveFolder = Const.UPLOAD_FOLDER_PATH;
			int maxSize = 10 * 1024 * 1024;
			MultipartRequest multi = new MultipartRequest(request, saveFolder, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			userId = multi.getParameter("userId");
			categoryCode = multi.getParameter("categoryCode");
			
			title = multi.getParameter("title");
			user_name = multi.getParameter("user_name");
			
		} else {
			//Connection con = null;
			userId = request.getParameter("userId");
			categoryCode = request.getParameter("categoryCode");
			
			
			HttpSession session = request.getSession();
			
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("categoryCode", categoryCode);
		request.setAttribute("title", title);
		request.setAttribute("user_name", user_name);
		this.getServletContext().getRequestDispatcher("/jsp/aflashcard/aflashcardDeckRegist.jsp").forward(request, response);
	}
}
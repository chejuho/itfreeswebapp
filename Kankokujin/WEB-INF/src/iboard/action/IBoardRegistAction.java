package iboard.action;

import iboard.bean.IBoardBean;
import iboard.handler.IBoardRegistHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.constant.Const;
import common.exception.AppException;
import common.exception.KankokujinException;
import common.logger.KankokujinLogger;
import common.util.Util;

public class IBoardRegistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean result = false;
		IBoardBean bean = requestToIBoardBean(request);
		IBoardRegistHandler registHandler = IBoardRegistHandler.getInstance();
		try {
			result = registHandler.insert(bean);
		} catch (AppException e) {
			e.printStackTrace();
			throw new KankokujinException("IBoardRegistAction", e);
			
		} finally {
			KankokujinLogger.getInstance().debug("IBoardRegistAction.end");
		}
		if (result) {
			response.sendRedirect("IBoardList?board_id=" + bean.getBoardId());
		} else {
			this.getServletContext().getRequestDispatcher("/jsp/iboard/iboardRegist.jsp").forward(request, response);
		}
		
	}

	private IBoardBean requestToIBoardBean(HttpServletRequest request) throws IOException {
		
		IBoardBean bean = new IBoardBean();
		//Loginする場合
		//HttpSession session = request.getSession();
		//MemberBean memberBean = (MemberBean) session.getAttribute("memberInfo");
		String saveFolder = Const.UPLOAD_IBOARD_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(
				request, saveFolder, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		bean.setTitle(Util.changeNullStr(multi.getParameter("title")));
		bean.setContent(Util.changeNullStr(multi.getParameter("content")));
		bean.setFilename1(multi.getFilesystemName("file_name1"));
		bean.setFilename2(multi.getFilesystemName("file_name2"));
		bean.setFilename3(multi.getFilesystemName("file_name3"));
		bean.setBoardId(Util.changeNullStr(multi.getParameter("board_id")));
		bean.setUser_name(multi.getParameter("user_name"));
		bean.setPassword(multi.getParameter("pass_word"));
		//bean.setUser_id(memberBean.getUserid());
		return bean;
		
	}
	
}
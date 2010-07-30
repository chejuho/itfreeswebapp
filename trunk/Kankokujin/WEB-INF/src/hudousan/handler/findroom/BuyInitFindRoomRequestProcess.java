package hudousan.handler.findroom;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hudousan.handler.RequestProcess;

public class BuyInitFindRoomRequestProcess extends RequestProcess {



	@Override
	public String execute(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("leaseSign", "0");
		
		return "/jsp/hudousan/roomFind.jsp";
	}

}

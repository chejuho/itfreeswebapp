package housefind.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.HouseFindInfo;
import common.bean.MemberBean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.constant.Const;
import common.util.Util;

public class HouseFindOpenWriteAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberBean memberBean = (MemberBean)request.getSession().getAttribute("memberInfo");
		//権限チェック
		if(!Util.hasPrivilege(request)){
			this.getServletContext().getRequestDispatcher("/").forward(request,response);
		} else {
			
		}
		String saveFolder = Const.UPLOAD_FOLDER_PATH;
//		String encType = "UTF-8";
//		String checked = "checked";
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest multi = null;

		HouseFindInfo houseFindInfo = new HouseFindInfo();
		if (request.getContentType() != null) {
			multi = new MultipartRequest(request, saveFolder, maxSize,
			"UTF-8", new DefaultFileRenamePolicy());
			houseFindInfo.setArea_code_1(Util.changeNullStr(multi.getParameter("area_1")));
			houseFindInfo.setArea_code_2(Util.changeNullStr(multi.getParameter("area_2")));
			houseFindInfo.setMain_area(Util.changeNullStr(multi.getParameter("main_area")));
			houseFindInfo.setLine_code(Util.changeNullStr(multi.getParameter("line_code")));
			houseFindInfo.setStation_code(Util.changeNullStr(multi.getParameter("station_code")));
			houseFindInfo.setTitle(Util.changeNullStr(multi.getParameter("title")));
			houseFindInfo.setDetail_info(Util.changeNullStr(multi.getParameter("detail_info")));
			houseFindInfo.setEmail(Util.changeNullStr(multi.getParameter("email")));
			houseFindInfo.setHouse_fee_from(Util.changeNullStr(multi.getParameter("house_fee_from")));
			houseFindInfo.setHouse_fee_to(Util.changeNullStr(multi.getParameter("house_fee_to")));
			houseFindInfo.setTelephone(Util.changeNullStr(multi.getParameter("telephone")));
			houseFindInfo.setDimension_from(Util.changeNullStr(multi.getParameter("dimension_from")));
			houseFindInfo.setDimension_to(Util.changeNullStr(multi.getParameter("dimension_to")));
			houseFindInfo.setUser_id(Util.changeNullStr(multi.getParameter("user_id")));
			houseFindInfo.setWalk_time(Util.changeNullStr(multi.getParameter("walk_time")));
			
			String[] house_sort={"","","","","","","","",""};
			if (!Util.isEmpty(multi.getParameter("house_sort_0"))) {
				house_sort[0] = multi.getParameter("house_sort_0");			
			}
			if (!Util.isEmpty(multi.getParameter("house_sort_1"))) {
				house_sort[1] = multi.getParameter("house_sort_1");			
			}
			if (!Util.isEmpty(multi.getParameter("house_sort_2"))) {
				house_sort[2] = multi.getParameter("house_sort_2");			
			}
			if (!Util.isEmpty(multi.getParameter("house_sort_3"))) {
				house_sort[3] = multi.getParameter("house_sort_3");			
			}
			if (!Util.isEmpty(multi.getParameter("house_sort_4"))) {
				house_sort[4] = multi.getParameter("house_sort_4");			
			}
			if (!Util.isEmpty(multi.getParameter("house_sort_5"))) {
				house_sort[5] = multi.getParameter("house_sort_5");			
			}
			if (!Util.isEmpty(multi.getParameter("house_sort_6"))) {
				house_sort[6] = multi.getParameter("house_sort_6");			
			}
			if (!Util.isEmpty(multi.getParameter("house_sort_7"))) {
				house_sort[7] = multi.getParameter("house_sort_7");			
			}
			if (!Util.isEmpty(multi.getParameter("house_sort_8"))) {
				house_sort[8] = multi.getParameter("house_sort_8");			
			}
			houseFindInfo.setHouse_sort(house_sort);
			
			String[] madori={"","","","","","","","","","","",""};
			if (!Util.isEmpty(multi.getParameter("madori_0"))) {
				madori[0] = multi.getParameter("madori_0");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_1"))) {
				madori[1] = multi.getParameter("madori_1");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_2"))) {
				madori[2] = multi.getParameter("madori_2");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_3"))) {
				madori[3] = multi.getParameter("madori_3");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_4"))) {
				madori[4] = multi.getParameter("madori_4");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_5"))) {
				madori[5] = multi.getParameter("madori_5");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_6"))) {
				madori[6] = multi.getParameter("madori_6");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_7"))) {
				madori[7] = multi.getParameter("madori_7");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_8"))) {
				madori[8] = multi.getParameter("madori_8");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_9"))) {
				madori[9] = multi.getParameter("madori_9");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_10"))) {
				madori[10] = multi.getParameter("madori_10");			
			}
			if (!Util.isEmpty(multi.getParameter("madori_11"))) {
				madori[11] = multi.getParameter("madori_11");			
			}	
			houseFindInfo.setMadori(madori);
			houseFindInfo.setArea_fast(Util.changeNullStr(multi.getParameter("area_fast")));
			houseFindInfo.setCome_dock(Util.changeNullStr(multi.getParameter("come_dock")));
			houseFindInfo.setCome_dock_year(Util.changeNullStr(multi.getParameter("come_dock_year")));
			houseFindInfo.setCome_dock_month(Util.changeNullStr(multi.getParameter("come_dock_month")));

		} else {
			houseFindInfo.setArea_code_1("00");
			houseFindInfo.setArea_code_2("00");
			houseFindInfo.setLine_code("00");
			houseFindInfo.setStation_code("0000");
			houseFindInfo.setUser_id(memberBean.getUserid());
			houseFindInfo.setEmail(memberBean.getEmail1() + "@" + memberBean.getEmail2());
			houseFindInfo.setMain_area("1");

		}
		request.setAttribute("HouseFindInfo", houseFindInfo);
		this.getServletContext().getRequestDispatcher(
				"/jsp/housefind/houseFindWrite.jsp").forward(request, response);

	}

}
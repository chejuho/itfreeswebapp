package housefind.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.HouseFindInfo;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.constant.Const;
import common.util.Util;
import housefind.handler.HouseFindHandler;

public class HouseFindRegistAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String saveFolder = Const.UPLOAD_FOLDER_PATH;
		int maxSize = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveFolder,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		HouseFindInfo bean = new HouseFindInfo();
		//requestèÓïÒÇBeanÉNÉâÉXäiî[Ç∑ÇÈ
		setBeanInfo(multi, bean);
		
		HouseFindHandler houseFindHandler = new HouseFindHandler();
		//èÓïÒÇêVãKìoò^Ç∑ÇÈ
		boolean result = houseFindHandler.insertHouseFindInfo(bean);
		//ìoò^åãâ Ç…ÇÊÇ¡ÇƒâÊñ ï™äÚÇ∑ÇÈ
		if (result) {
			this.getServletContext().getRequestDispatcher("/HouseFindList")
					.forward(request, response);

		} else {
			this.getServletContext().getRequestDispatcher("/HouseFindOpenWrite")
					.forward(request, response);

		}
	}
	
	private void setBeanInfo(MultipartRequest multi, HouseFindInfo bean) {
		
		
		if (!Util.isEmpty(multi.getParameter("title"))) {
			bean.setTitle(multi.getParameter("title"));
		}
		if (!Util.isEmpty(multi.getParameter("detail_info"))) {
			bean.setDetail_info(multi.getParameter("detail_info"));
		}
		if (!Util.isEmpty(multi.getParameter("email"))) {
			bean.setEmail(multi.getParameter("email"));
		}
		if (!Util.isEmpty(multi.getParameter("user_id"))) {
			bean.setUser_id(multi.getParameter("user_id"));
		}
		if (!Util.isEmpty(multi.getParameter("come_dock"))) {
			bean.setCome_dock(multi.getParameter("come_dock"));
		}

		if (!Util.isEmpty(multi.getParameter("come_dock_year"))) {
			bean.setCome_dock_year(multi.getParameter("come_dock_year"));
		}
		
		if (!Util.isEmpty(multi.getParameter("come_dock_month"))) {
			bean.setCome_dock_month(multi.getParameter("come_dock_month"));
		}
		
		if (!Util.isEmpty(multi.getParameter("telephone"))) {
			bean.setTelephone(multi.getParameter("telephone"));
		}
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
		bean.setHouse_sort(house_sort);
		
		String[] madori={"","","","","","","","","","","",""};
		if (!Util.isEmpty(multi.getParameter("madori_1"))) {
			madori[0] = multi.getParameter("madori_1");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_2"))) {
			madori[1] = multi.getParameter("madori_2");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_3"))) {
			madori[2] = multi.getParameter("madori_3");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_4"))) {
			madori[3] = multi.getParameter("madori_4");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_5"))) {
			madori[4] = multi.getParameter("madori_5");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_6"))) {
			madori[5] = multi.getParameter("madori_6");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_7"))) {
			madori[6] = multi.getParameter("madori_7");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_8"))) {
			madori[7] = multi.getParameter("madori_8");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_9"))) {
			madori[8] = multi.getParameter("madori_9");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_10"))) {
			madori[9] = multi.getParameter("madori_10");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_11"))) {
			madori[10] = multi.getParameter("madori_11");			
		}
		if (!Util.isEmpty(multi.getParameter("madori_12"))) {
			madori[11] = multi.getParameter("madori_12");			
		}		
		
		bean.setMadori(madori);
		if (!Util.isEmpty(multi.getParameter("main_area"))) {
			bean.setMain_area(multi.getParameter("main_area"));
		}
		if (!Util.isEmpty(multi.getParameter("walk_time"))) {
			bean.setWalk_time(multi.getParameter("walk_time"));
		}
		if (!Util.isEmpty(multi.getParameter("dimension"))) {
			bean.setDimension_from(multi.getParameter("dimension"));
		}
		
		if (!Util.isEmpty(multi.getParameter("house_fee"))) {
			bean.setHouse_fee_from(multi.getParameter("house_fee"));
		}
		if (!Util.isEmpty(multi.getParameter("area_fast"))) {
			bean.setArea_fast(multi.getParameter("area_fast"));
		}
		if (!Util.isEmpty(multi.getParameter("line_code"))) {
			bean.setLine_code(multi.getParameter("line_code"));
		}
		if (!Util.isEmpty(multi.getParameter("station_code"))) {
			bean.setStation_code(multi.getParameter("station_code"));
		}
		if (!Util.isEmpty(multi.getParameter("area_1"))) {
			bean.setArea_code_1(multi.getParameter("area_1"));
		}
		if (!Util.isEmpty(multi.getParameter("area_2"))) {
			bean.setArea_code_2(multi.getParameter("area_2"));
		}
		
	}
}

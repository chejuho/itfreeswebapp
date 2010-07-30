package menu.handler;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.util.Util;
import menu.bean.MenuBean;
import common.bean.MemberBean;
import common.constant.Const;

public class MenuCommonHandler {
	
	private final static String SPACE = " ";
	private final static String COMMA = ",";
	String SAVEFOLDER = Const.UPLOAD_FOLDER_PATH;
	int MAXSIZE = 10 * 1024 * 1024;
	private final static String USERBEAN = "memberInfo";
	
	private static MenuCommonHandler instance = null;
	
	 public static MenuCommonHandler getInstance() {
	        if (instance == null) {
	            synchronized (MenuCommonHandler.class) {
	                if (instance == null) {
	                    instance = new MenuCommonHandler();
	                }
	            }
	        }

	        return instance;
	    }	
	
	/**
	 * 
	 * @param path
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public MenuBean changeRequestToMenuBean(HttpServletRequest request) throws IOException {
		
		MenuBean menuBean = new MenuBean();
		MultipartRequest multi = null;
		Enumeration enumeration = null;
		if(Util.isEmpty(request.getParameter("f"))){
			multi = new MultipartRequest(request, SAVEFOLDER,
					MAXSIZE, "UTF-8", new DefaultFileRenamePolicy());
			enumeration = multi.getParameterNames();

		}  else {
			enumeration = request.getParameterNames();
		}
		
	   while(enumeration.hasMoreElements()) {
	        String name = (String)enumeration.nextElement();
	        menuBean.put(name, request.getParameter(name));
	     }
	   HttpSession session = request.getSession();
	   MemberBean memberBean= (MemberBean) session.getAttribute(USERBEAN);
	   menuBean.put("user_id", memberBean.getUserid());
	   menuBean.put("email", memberBean.getEmail1() + "@" + memberBean.getEmail2());
	   menuBean.put("tel_no1_1", memberBean.getTelephone1());
	   menuBean.put("tel_no1_2", memberBean.getTelephone2());
	   menuBean.put("tel_no1_3", memberBean.getTelephone3());
	   menuBean.put("tel_no2_1", memberBean.getMobile1());
	   menuBean.put("tel_no2_2", memberBean.getMobile2());
	   menuBean.put("tel_no2_3", memberBean.getMobile3());
		
		return menuBean;
	}
	/**
	 * 
	 * @param path
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public MenuBean editMenuBean(MenuBean menuBean) throws IOException {
		
		MenuBean editMenuBean = new MenuBean();
		String key = (String) menuBean.get("topmenuNo");
		
		if ("Menu01".equals(key)) {
			editMenuBean.put("id", menuBean.get("id"));
			editMenuBean.put("varchar_01", menuBean.get("varchar_01"));
			
			
			
		} else if ("Menu02".equals(key)) {
			
		} 
			
		return menuBean;
	}
}

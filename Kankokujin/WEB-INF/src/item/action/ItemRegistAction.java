package item.action;

import item.bean.ItemBean;
import item.handler.ItemHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.handler.CategoryHandler;


public class ItemRegistAction extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute("code");
		Map map = (Map)session.getAttribute("categoryMap");
		String categorySelect = "";
		ItemHandler handler = new ItemHandler();
		ItemBean itemform = new ItemBean();
		
		//FileUploadRequestWrapper requestWrap = new FileUploadRequestWrapper(
		//		request, -1, -1, "C:\\");

		//FileItem fileItem1 = requestWrap.getFileItem("file1");
//		if (fileItem1.getSize() != 0) {
//			System.out.println("fileItem1...>> " + fileItem1);
//			fileItem1.getName();
//
//			int idx = fileItem1.getName().lastIndexOf("\\");
//			if (idx == -1) {
//				idx = fileItem1.getName().lastIndexOf("/");
//			}
//			String fileName = requestWrap.getParameter("file_name") + ".jpg";
//			System.out.println("fileName......" + fileName);
//			System.out.println("fileName......" + fileItem1.getName());
//			System.out.println("fileItem1.getSize()......"
//					+ fileItem1.getSize());
//			itemform.setFile(fileName);
//			try {
//				File uploadedFile = new File("..\\eclipse\\image", fileName);
//				//fileItem1.write(uploadedFile);
//				//Jpeg jpeg = new Jpeg();
//				System.out.println("fileName = " + fileName);
//				//jpeg.resize(500, uploadedFile.getPath());
//
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		} else {  //ŠG‚ð“ü—Í‚µ‚È‚¢Žž
////			String fileName = "0"+ ".jpg";
////			System.out.println("fileName......" + fileName);
////			System.out.println("fileItem1.getSize()......"
////					+ fileItem1.getSize());
////			itemform.setFile(fileName);
//		}
//		
		String cate_code = request.getParameter("cate_code");
//		System.out.println("test cate_code ##^^## : "
//				+ requestWrap.getParameter("cate_code"));
//		itemform.setCate_code(cate_code);
//		Member member = (Member)session.getAttribute("userInfo");
//		itemform.setCode(code);
//		itemform.setContents(requestWrap.getParameter("contents"));
//		itemform.setUser_id(member.getUser_id());
//		if (code.equals("3")){
//			itemform.setCol01(String.valueOf(fileItem1.getSize()));
//		} else { 
//			itemform.setCol01(requestWrap.getParameter("col01"));
//		}
//		itemform.setCol02(requestWrap.getParameter("col02"));
//		itemform.setCol03(requestWrap.getParameter("col03"));
//		itemform.setCol04(requestWrap.getParameter("col04"));
//		itemform.setCol05(requestWrap.getParameter("col05"));
//		itemform.setCol06(requestWrap.getParameter("col06"));
//		itemform.setCol07(requestWrap.getParameter("col07"));
//		itemform.setCol08(requestWrap.getParameter("col08"));
//		itemform.setCol09(requestWrap.getParameter("col09"));
//		itemform.setCol10(requestWrap.getParameter("col10"));
//		
//		
////		itemform.setProduct_name(requestWrap.getParameter("product_name"));
////		itemform.setCompany(requestWrap.getParameter("company"));
////		itemform.setNation(requestWrap.getParameter("nation"));
//		System.out.println("contents = "+requestWrap.getParameter("contents"));
//		itemform.setContents(requestWrap.getParameter("contents"));
//		if (requestWrap.getParameter("contents").equals("<P>&nbsp;</P>") || requestWrap.getParameter("contents").equals("")) {
//			CategoryHandler category = new CategoryHandler();
//
//			String user_id = "";
//			user_id = request.getParameter("user_id");
//
//			categorySelect  = category.getAllViewTag(cate_code,map, 1, "", "", user_id);
//
//			request.setAttribute("CategorySelect", categorySelect);
//			request.setAttribute("cate_code", cate_code);
//
//			this.getServletContext().getRequestDispatcher("/jsp/item/itemList.jsp").forward(request, response);
//		}
////		itemform.setPrice(requestWrap.getParameter("price"));
////		itemform.setUserId(requestWrap.getParameter("user_id"));
////		itemform.setPermission(requestWrap.getParameter("permission"));
//		
//		boolean insertresult = handler.insertItem(itemform);
//		System.out.println("check~~~~~ : " + insertresult);

		if (true) {
			CategoryHandler category = new CategoryHandler();

			String user_id = "";
			user_id = request.getParameter("user_id");
			
			categorySelect  = category.getAllViewTag(cate_code,map, 1, "", "", user_id);

			request.setAttribute("CategorySelect", categorySelect);
			request.setAttribute("cate_code", cate_code);
			
			ArrayList itemList = null;//handler.getMyItem(user_id,cate_code);

			request.setAttribute("itemList", itemList);
			this.getServletContext().getRequestDispatcher("/jsp/item/itemList.jsp").forward(request, response);

		} else {
			CategoryHandler category = new CategoryHandler();

			String user_id = "";
			user_id = request.getParameter("user_id");

			categorySelect  = category.getAllViewTag(cate_code,map, 1, "", "", user_id);

			request.setAttribute("CategorySelect", categorySelect);
			request.setAttribute("cate_code", cate_code);

			this.getServletContext().getRequestDispatcher("/jsp/item/itemList.jsp").forward(request, response);

		}

	}
}
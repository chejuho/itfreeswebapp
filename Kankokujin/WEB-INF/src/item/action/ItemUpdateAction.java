package item.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ItemUpdateAction extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
//		HttpSession session = request.getSession();
//		Map map = (Map) session.getAttribute("categoryMap");
//		ItemHandler handler = new ItemHandler();
//		ItemForm itemForm = new ItemForm();
//		String code = (String) session.getAttribute("code");
//		FileUploadRequestWrapper requestWrap = new FileUploadRequestWrapper(
//				request, -1, -1, "C:\\");
//
//		FileItem fileItem1 = requestWrap.getFileItem("file1");
//		if (fileItem1.getSize() != 0) {
//			if (!(fileItem1.getName().equals(""))) {
//				System.out.println("fileItem1...>> " + fileItem1);
//				fileItem1.getName();
//
//				int idx = fileItem1.getName().lastIndexOf("\\");
//				if (idx == -1) {
//					idx = fileItem1.getName().lastIndexOf("/");
//				}
//				String fileName = requestWrap.getParameter("fileName") + ".jpg";
//				System.out.println("fileName......" + fileName);
//				System.out.println("fileItem1.getSize()......"
//						+ fileItem1.getSize());
//				itemForm.setFile(fileName);
//				try {
//					File uploadedFile = new File("..\\eclipse\\image", fileName);
//					fileItem1.write(uploadedFile);
//					Jpeg jpeg = new Jpeg();
//					System.out.println("fileName = " + fileName);
//					jpeg.resize(500, uploadedFile.getPath());
//
//				} catch (IOException ex) {
//					ex.printStackTrace();
//				}
//			} else {
//				String fileName = requestWrap.getParameter("file_name");
//				System.out.println("fileName......" + fileName);
//				itemForm.setFile(fileName);
//			}
//
//		} else {
//			String fileName = requestWrap.getParameter("file_name");
//			if (fileName.equals("0.jpg")) {
//
//			}
//			System.out.println("fileName......" + fileName);
//			itemForm.setFile(fileName);
//		}
//
//		String cate_code = "";
//		cate_code = requestWrap.getParameter("cate_code");
//
//		String nowPage = "";
//		nowPage = requestWrap.getParameter("nowPage");
//
//		String user_id = requestWrap.getParameter("user_id");
//		System.out.println("test cate_code ##^^## : "
//				+ requestWrap.getParameter("cate_code"));
//		itemForm.setCate_code(cate_code);
//		if (code.equals("3")) {
//			itemForm.setCol01(String.valueOf(fileItem1.getSize()));
//		} else {
//			itemForm.setCol01(requestWrap.getParameter("col01"));
//		}
//		itemForm.setCol02((String) requestWrap.getParameter("col02"));
//		itemForm.setCol03((String) requestWrap.getParameter("col03"));
//		itemForm.setItem_code((String) requestWrap.getParameter("item_code"));
//		itemForm.setCode(code);
//		// viewForm.setCol04((String)requestWrap.getParameter("col04"));
//
//		itemForm.setContents((String) requestWrap.getParameter("contents"));
//		System.out.println("productForm.getContents():"
//				+ itemForm.getContents());
//		if (requestWrap.getParameter("contents").equals("<P>&nbsp;</P>")
//				|| requestWrap.getParameter("contents").equals("")) {
//			CategoryHandler category = new CategoryHandler();
//
//			String categorySelect = "";
//
//			categorySelect = category.getAllViewTag(cate_code, map, 1, "", "",
//					user_id);
//
//			request.setAttribute("CategorySelect", categorySelect);
//			request.setAttribute("cate_code", cate_code);
//			request.setAttribute("itemCode", requestWrap
//					.getParameter("itemCode"));
//			request.setAttribute("nowPage", nowPage);
//			request.setAttribute("user_id", user_id);
//
//			return mapping.findForward("fail");
//		}
//
//		boolean updateResult = handler.changeItem(itemForm);
//		System.out.println("check~~~~~ : " + updateResult);
//		updateResult = true;
//		if (updateResult) {
//			CategoryHandler category = new CategoryHandler();
//
//			String categorySelect = "";
//
//			categorySelect = category.getAllViewTag(cate_code, map, 1, "", "",
//					user_id);
//
//			request.setAttribute("CategorySelect", categorySelect);
//			request.setAttribute("cate_code", cate_code);
//
//			ArrayList viewList = handler.getItemList(code, cate_code, user_id);
//
//			request.setAttribute("user_id", user_id);
//			request.setAttribute("viewList", viewList);
//			return mapping.findForward("success");
//
//		} else {
//			CategoryHandler category = new CategoryHandler();
//
//			String categorySelect = "";
//
//			categorySelect = category.getAllViewTag(cate_code, map, 1, "", "",
//					user_id);
//
//			request.setAttribute("CategorySelect", categorySelect);
//			request.setAttribute("cate_code", cate_code);
//			request.setAttribute("error", "è§ïiìoò^Ç™é∏îsÇµÇ‹ÇµÇΩÅB");
//			request.setAttribute("product_code", requestWrap
//					.getParameter("product_code"));
//			request
//					.setAttribute("nowPage", requestWrap
//							.getParameter("nowPage"));
//			request.setAttribute("user_id", user_id);
//
//			return mapping.findForward("fail");
//
//		}

	}
}
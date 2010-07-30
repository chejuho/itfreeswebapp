package common.page;

import java.io.IOException;
import common.bean.PageBean;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PageHandleTag extends SimpleTagSupport {

	private String path = null;
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void doTag() throws JspException, IOException {

		
		String pageBeanName = (String) getJspContext().findAttribute("PageBeanName");
		
		if (pageBeanName == null) {
			pageBeanName = "PageBean";
		}
		
		PageBean pageBean = (PageBean) getJspContext().findAttribute(pageBeanName);
		//���݃y�[�W
		int currentPage = pageBean.getCurrentPage();
			
		int pageSize = pageBean.getPageSize();
		
		int startPage = pageBean.getStartPage();
		int endPage = pageBean.getEndPage();
		
		//������
		int maxCount = pageBean.getMaxCount();

		int allPage = maxCount / pageSize; //���y�[�W��
		if (maxCount%pageSize !=0 || maxCount ==0 ){
			allPage += 1;
		}		
		boolean bprevPageSign = pageBean.isBprevSign();
		boolean sprevPageSign = pageBean.isSprevSign();
		boolean snextPageSign = pageBean.isSnextSign();
		boolean bnextPageSign = pageBean.isBnextSign();

		StringBuffer tagWriter = new StringBuffer();
		/** Paging */
		if (maxCount!=0) {

			/** Prev Button */
			if (bprevPageSign) {
				tagWriter.append("<a href='javascript:reloadPage(");
				tagWriter.append("\"bprev\");'>");
				tagWriter.append("<img src='jsp/images/new/board_first_b.gif' align='absmiddle' class='pageIcon'  border='0'></a> ");
				}
			if (sprevPageSign){
				tagWriter.append("<a href='javascript:reloadPage(");
				tagWriter.append("\"sprev\");'>");
				tagWriter.append("<img src='jsp/images/new/board_prev_b.gif' align='absmiddle' class='pageIcon'  border='0'></a> ");
			}
	
			/** PageNum Button */
			for (int i = startPage; i <= endPage; i++) {
				tagWriter.append("<a href='javascript:reloadPage(");
				tagWriter.append(String.valueOf(i));
				tagWriter.append(");' class='page-style'>&nbsp;&nbsp;");

				if (currentPage == i) {
	
					tagWriter.append("<span class='red-text-w'><strong>");
					tagWriter.append(String.valueOf(i));
					tagWriter.append("</strong></span>");
					tagWriter.append("&nbsp;&nbsp;</a>");
					
				} else {
					tagWriter.append(String.valueOf(i));
					tagWriter.append("&nbsp;&nbsp;</a>");
				}
			}	
			/** next Button */
	
			/** Prev Button */
			if (snextPageSign) {
				tagWriter.append("<a href='javascript:reloadPage(");
				tagWriter.append("\"snext\");'>");
				tagWriter.append("<img src='jsp/images/new/board_next_b.gif' align='absmiddle' class='pageIcon'  border='0'></a> ");
				}
			
			if (bnextPageSign){	
				tagWriter.append("<a href='javascript:reloadPage(");
				tagWriter.append("\"bnext\");'>");
				tagWriter.append("<img src='jsp/images/new/board_last_b.gif' align='absmiddle' class='pageIcon'  border='0'></a> ");
			}
			
			getJspContext().getOut().print(tagWriter.toString());

		}

	}
	
	/**
	 * 
	 * List��ޕʂ�link
	 * @return String link �l
	 */

	private String pageLinkCheck(String RHCheck) {
//		String RHPath = "";
//		if("RoomSellList".equals(RHCheck)){
//			RHPath = "<a href='RoomSellList?";
//		}else if("HouseSellList".equals(RHCheck)){
//			//RHPath = "<a href='HouseSellList?";
//			RHPath = "<a href='javascript:reloadPage(";		
//		}else if("houseSellInterestList".equals(RHCheck)){
//			RHPath = "<a href='HouseSellInterestList?";
//		}else if("InterpretList".equals(RHCheck)){
//			RHPath = "<a href='InterpretList?";
//		}else if("StoreList".equals(RHCheck)){
//			//RHPath = "<a href='StoreList?cate_code_1="+cate_code_1+"&cate_code_2="+cate_code_2+"&";
//			RHPath = "<a href='javascript:reloadPage(";	
//		}else if("StoreSearch".equals(RHCheck)){
//			RHPath = "<a href='javascript:reloadPage(";			
//		}else if("StoreMyList".equals(RHCheck)){
//			RHPath = "<a href='StoreMyList?user_id="+cate_code_2+"&";			
//		}else if("BuySellList".equals(RHCheck)){
//			RHPath = "<a href='javascript:reloadPage(";	
//		}else if("EngMgnList".equals(RHCheck)){
//			RHPath = "<a href='EngMgnList?";
//		}else{
//			RHPath = "<a href='javascript:reloadPage(";		
//		}
		
		return "<a href='javascript:reloadPage(";
	}

}
package common.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.bean.PageBean;
import common.util.Util;
public class PageUtil {
	
	private static PageUtil instance = new PageUtil();
	
	public static PageUtil getInstance() {
		
		return instance;
	}
	
	public void init(PageBean pageBean, int maxCount) {
		
//		PageBean.setCurrentPage(INITPAGE);
		
		int pageCount = pageBean.getPageCount(); //�y�[�W���O�����̕\����		
		int pageSize = pageBean.getPageSize(); //�f�[�^�\����
		int allPage = maxCount / pageSize; //���y�[�W��	
		int pageNum = pageBean.getPageNum();
		if(pageNum==0){
			pageNum=1;
		}
		
		if (maxCount%pageSize !=0 || maxCount ==0 ){
			allPage += 1;
		}		
		int currentPage = pageBean.getCurrentPage(); //���݃y�[�W
		
		int startPage = ((currentPage -1)/pageCount)*pageCount+1;
		int endPage = startPage+pageCount-1;
		if (endPage > allPage){
			endPage = allPage;
			}
		
		int startCount = pageBean.getStartCount();
		int endCount = startCount + pageSize;
		if (endCount > maxCount){
			endCount = maxCount;
			}
		pageBean.setEndCount(endCount);

		boolean bPrevSign = false;
		boolean sPrevSign = false;
		boolean sNextSign = false;
		boolean bNextSign = false;

		if (pageCount < pageNum) {
			
			bPrevSign = true;
			
		}		
		if (1 < pageNum) {
			
			sPrevSign = true;
			
		}		
		if (allPage > pageNum) {
			
			sNextSign = true;
			
		}		
		if (allPage-pageCount >= pageNum) {
			
			bNextSign = true;
			
		}
		pageBean.setMaxCount(maxCount);
		
		pageBean.setStartPage(startPage);
		pageBean.setEndPage(allPage);
		
		pageBean.setStartCount(startPage);
		pageBean.setEndPage(endPage);
		
		pageBean.setCurrentPage(startPage);
		pageBean.setBprevSign(bPrevSign);
		pageBean.setSprevSign(sPrevSign);
		pageBean.setSnextSign(sNextSign);
		pageBean.setBnextSign(bNextSign);
		String cPage = pageBean.getCurrentPage() + "";
		pageBean.setPagingSign(cPage);		
		
	}
	
	public void nextPage(PageBean pageBean, int maxCount) {
		if ("init".equals(pageBean.getPagingSign())) {
			init(pageBean, maxCount);
		} else if ("sprev".equals(pageBean.getPagingSign())) {
			sprev(pageBean, maxCount);
		} else if ("bprev".equals(pageBean.getPagingSign())) {
			bprev(pageBean, maxCount);
		} else if ("snext".equals(pageBean.getPagingSign())) {
			snext(pageBean, maxCount);
		} else if ("bnext".equals(pageBean.getPagingSign())) {
			bnext(pageBean, maxCount);
		} else if (!Util.isEmpty(pageBean.getPagingSign())) {
			jump(pageBean, Integer.parseInt(pageBean.getPagingSign()), maxCount);
		} 
		
	}
	
	public void bprev(PageBean pageBean, int maxCount) {
		
		int pageCount = pageBean.getPageCount();		
		int pageSize = pageBean.getPageSize();
		int allPage = maxCount / pageSize; //���y�[�W��	
		if (maxCount%pageSize !=0 || maxCount ==0 ){
			allPage += 1;
		}		
		int currentPage = pageBean.getCurrentPage();
		int pageNum = currentPage-pageCount;
		int startCount = pageBean.getStartCount();
		
		startCount = startCount - pageCount * pageSize;
		pageBean.setStartCount(startCount);
		pageBean.setEndCount(startCount + pageSize - 1);
		pageBean.setCurrentPage(currentPage-pageCount);

		int startPage = ((pageNum-1)/pageCount)*pageCount+1;
		int endPage = startPage+pageCount-1;
		if (endPage > allPage){
			endPage = allPage;
			}
		
		boolean bPrevSign = false;
		boolean sPrevSign = false;
		boolean sNextSign = false;
		boolean bNextSign = false;
		
		if (pageCount < pageNum) {
			
			bPrevSign = true;
			
		}		
		if (1 < pageNum) {
			
			sPrevSign = true;
			
		}		
		if (allPage > pageNum) {
			
			sNextSign = true;
			
		}		
		if (allPage-pageCount >= pageNum) {
			
			bNextSign = true;
			
		}	
		pageBean.setMaxCount(maxCount);
		pageBean.setStartPage(startPage);
		pageBean.setEndPage(endPage);
		
		pageBean.setBprevSign(bPrevSign);
		pageBean.setSprevSign(sPrevSign);
		pageBean.setSnextSign(sNextSign);
		pageBean.setBnextSign(bNextSign);	
		String cPage = pageBean.getCurrentPage() + "";
		pageBean.setPagingSign(cPage);	
	}
	
	public void sprev(PageBean pageBean, int maxCount) {
	
		int pageCount = pageBean.getPageCount();		
		int pageSize = pageBean.getPageSize();
		int allPage = maxCount / pageSize; //���y�[�W��	
		if (maxCount%pageSize !=0 || maxCount ==0 ){
			allPage += 1;
		}		
		int currentPage = pageBean.getCurrentPage();
		int pageNum = currentPage-1;
		int startCount = pageBean.getStartCount();
		int movePage = -1;
		
		startCount = startCount + movePage * pageSize;
		pageBean.setStartCount(startCount);
		pageBean.setEndCount(startCount + pageSize - 1);
		pageBean.setCurrentPage(currentPage+movePage);

		int startPage = ((pageNum-1)/pageCount)*pageCount+1;
		int endPage = startPage+pageCount-1;
		if (endPage > allPage){
			endPage = allPage;
			}
		
		boolean bPrevSign = false;
		boolean sPrevSign = false;
		boolean sNextSign = false;
		boolean bNextSign = false;
		
		if (pageCount < pageNum) {
			
			bPrevSign = true;
			
		}		
		if (1 < pageNum) {
			
			sPrevSign = true;
			
		}		
		if (allPage > pageNum) {
			
			sNextSign = true;
			
		}		
		if (allPage-pageCount >= pageNum) {
			
			bNextSign = true;
			
		}	
		pageBean.setMaxCount(maxCount);
		pageBean.setStartPage(startPage);
		pageBean.setEndPage(endPage);
		
		pageBean.setBprevSign(bPrevSign);
		pageBean.setSprevSign(sPrevSign);
		pageBean.setSnextSign(sNextSign);
		pageBean.setBnextSign(bNextSign);
		
		String cPage = pageBean.getCurrentPage() + "";
		pageBean.setPagingSign(cPage);	
	}
	
	public void snext(PageBean pageBean, int maxCount) {
		
		int pageCount = pageBean.getPageCount();		
		int pageSize = pageBean.getPageSize();
		int allPage = maxCount / pageSize; //���y�[�W��	
		if (maxCount%pageSize !=0 || maxCount ==0 ){
			allPage += 1;
		}		
		int currentPage = pageBean.getCurrentPage();
		int pageNum = currentPage+1;
		int startCount = pageBean.getStartCount();
		int endCount  = pageBean.getEndCount();
		int movePage = 1;
		
		startCount = startCount + movePage * pageSize;
		pageBean.setStartCount(startCount);
		endCount = startCount + pageSize-1;
		if (endCount > maxCount){
			endCount = maxCount;
			}
		pageBean.setEndCount(endCount);
		pageBean.setCurrentPage(currentPage+movePage);
		
		int startPage = ((pageNum-1)/pageCount)*pageCount+1;
		int endPage = startPage+pageCount-1;
		
		
		if (endPage > allPage){
			endPage = allPage;
		}
		
		boolean bPrevSign = false;
		boolean sPrevSign = false;
		boolean sNextSign = false;
		boolean bNextSign = false;
		
		if (pageCount < pageNum) {
			
			bPrevSign = true;
			
		}		
		if (1 < pageNum) {
			
			sPrevSign = true;
			
		}		
		if (allPage > pageNum) {
			
			sNextSign = true;
			
		}		
		if (allPage-pageCount >= pageNum) {
			
			bNextSign = true;
			
		}	
		pageBean.setMaxCount(maxCount);
		pageBean.setStartPage(startPage);
		pageBean.setEndPage(endPage);
		
		pageBean.setBprevSign(bPrevSign);
		pageBean.setSprevSign(sPrevSign);
		pageBean.setSnextSign(sNextSign);
		pageBean.setBnextSign(bNextSign);
		
		String cPage = pageBean.getCurrentPage() + "";
		pageBean.setPagingSign(cPage);	
		
	}
	
	public void bnext(PageBean pageBean, int maxCount) {	
		
		int pageCount = pageBean.getPageCount();		
		int pageSize = pageBean.getPageSize();
		int allPage = maxCount / pageSize; //���y�[�W��	
		if (maxCount%pageSize !=0 || maxCount ==0 ){
			allPage += 1;
		}		
		int currentPage = pageBean.getCurrentPage();
		int pageNum = currentPage+pageCount;
		int startCount = pageBean.getStartCount();
		int endCount  = pageBean.getEndCount();
		
		startCount = startCount + pageCount * pageSize;
		endCount = startCount + pageSize - 1;
		if (endCount > maxCount){
			endCount = maxCount;
		}
		pageBean.setStartCount(startCount);
		pageBean.setEndCount(endCount);
		pageBean.setCurrentPage(currentPage+pageCount);
		
		int startPage = ((pageNum-1)/pageCount)*pageCount+1;
		int endPage = startPage+pageCount-1;
		if (endPage > allPage){
			endPage = allPage;
			}
		
		boolean bPrevSign = false;
		boolean sPrevSign = false;
		boolean sNextSign = false;
		boolean bNextSign = false;
		
		if (pageCount < pageNum) {
			
			bPrevSign = true;
			
		}		
		if (1 < pageNum) {
			
			sPrevSign = true;
			
		}		
		if (allPage > pageNum) {
			
			sNextSign = true;
			
		}		
		if (allPage-pageCount >= pageNum) {
			
			bNextSign = true;
			
		}	
		pageBean.setMaxCount(maxCount);
		pageBean.setStartPage(startPage);
		pageBean.setEndPage(endPage);
		
		pageBean.setBprevSign(bPrevSign);
		pageBean.setSprevSign(sPrevSign);
		pageBean.setSnextSign(sNextSign);
		pageBean.setBnextSign(bNextSign);
		
		String cPage = pageBean.getCurrentPage() + "";
		pageBean.setPagingSign(cPage);	
}
	
	public void jump(PageBean pageBean, int pageNum, int maxCount) {
		
		int pageCount = pageBean.getPageCount(); //�y�[�W���O�����̕\����
		int pageSize = pageBean.getPageSize(); //�f�[�^�\����		
		int startCount = pageBean.getStartCount();
		int endCount  = pageBean.getEndCount();
		int allPage = maxCount / (pageSize); //���y�[�W��		
		if (maxCount%pageSize !=0 || maxCount ==0 )
			allPage += 1;
		int currentPage = pageBean.getCurrentPage();
		int startPage = ((pageNum -1)/pageCount)*pageCount+1;
		int endPage = startPage+pageCount-1;
		if (endPage > allPage){
			endPage = allPage;
			}
		
		if (pageNum >= currentPage) {
			
			int movePage = pageNum - currentPage;
			startCount = startCount + movePage * pageSize;
			pageBean.setStartCount(startCount);
			endCount = startCount + pageSize-1;
			if (endCount > maxCount){
				endCount = maxCount;
				}
			pageBean.setEndCount(endCount);	
			} else {
				int movePage = currentPage - pageNum;
					startCount = startCount - movePage * pageSize;
					pageBean.setStartCount(startCount);
					pageBean.setEndCount(startCount + pageSize - 1);				
			}
		boolean bPrevSign = false;
		boolean sPrevSign = false;
		boolean sNextSign = false;
		boolean bNextSign = false;
		
		if (pageCount < pageNum) {
			
			bPrevSign = true;
			
		}		
		if (1 < pageNum) {
			
			sPrevSign = true;
			
		}		
		if (allPage > pageNum) {
			
			sNextSign = true;
			
		}		
		if (allPage-pageCount >= pageNum) {
			
			bNextSign = true;
			
		}
		pageBean.setMaxCount(maxCount);
		pageBean.setStartPage(startPage);
		pageBean.setEndPage(endPage);
		pageBean.setCurrentPage(pageNum);
		pageBean.setBprevSign(bPrevSign);
		pageBean.setSprevSign(sPrevSign);
		pageBean.setSnextSign(sNextSign);
		pageBean.setBnextSign(bNextSign);
		
		String cPage = pageBean.getCurrentPage() + "";
		pageBean.setPagingSign(cPage);	
	}
	public PageBean pagingProcess(HttpServletRequest request, String pageSize) {
		
		return pagingProcess(request, pageSize, "PageBean");
	}
	
	public PageBean pagingProcess(HttpServletRequest request, String pageSize, String attrName) {
		
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) session.getAttribute(attrName);
		
		//OK
		if ("ok".equals(request.getParameter("modoru"))) {
			if (pageBean == null) {
				pageBean = getPageInit();
			} else {
				pageBean.setPagingSign("");
			}
			
		//PAGENUM
		} else if (!Util.isEmpty(request.getParameter("searchGo"))) {
			pageBean = getPageInit();
		} else if (!Util.isEmpty(request.getParameter("pageNum"))) {
			String pageNumStr = Util.changeNullStr(request.getParameter("pageNum"));
			pageBean.setPagingSign(pageNumStr);
		}  else {
			pageBean = getPageInit();
		}
		if (Util.isNumber(pageSize)) {
			pageBean.setPageSize(Integer.parseInt(pageSize));
		} else {
			pageBean.setPageSize(10);
		}
	
		return pageBean;
	}
	
	
	
	private PageBean getPageInit() {
		PageBean pageBean = new PageBean();
		pageBean.setPagingSign("init");
		return pageBean;
	}

}

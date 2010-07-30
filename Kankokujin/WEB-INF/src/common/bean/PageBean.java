package common.bean;

public class PageBean {
	
	int pageNum = 1;
	int currentPage;   //現在ページ
	int pageCount = 10; //ページング数字の表示数
	int pageSize = 10;  //データ表示数
	int startPage;
	int endPage;
	int startCount;    //???
	int endCount;
	int maxCount;      //???
	String pageType="1";      //???
	String pagingSort = "";  //???
	String pagingSign = "";  //???
	boolean bprevSign = false;
	boolean bnextSign = false;
	boolean sprevSign = false;
	boolean snextSign = false;
	String cate_code_1 = "";
	String cate_code_2 = "";
	
	public int getPageCount() {
		return pageCount;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}

	public boolean isBprevSign() {
		return bprevSign;
	}

	public void setBprevSign(boolean bprevSign) {
		this.bprevSign = bprevSign;
	}

	public boolean isBnextSign() {
		return bnextSign;
	}

	public void setBnextSign(boolean bnextSign) {
		this.bnextSign = bnextSign;
	}

	public boolean isSprevSign() {
		return sprevSign;
	}

	public void setSprevSign(boolean sprevSign) {
		this.sprevSign = sprevSign;
	}

	public boolean isSnextSign() {
		return snextSign;
	}

	public void setSnextSign(boolean snextSign) {
		this.snextSign = snextSign;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public String getPagingSort() {
		return pagingSort;
	}

	public void setPagingSort(String pagingSort) {
		this.pagingSort = pagingSort;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getPagingSign() {
		return pagingSign;
	}

	public void setPagingSign(String pagingSign) {
		this.pagingSign = pagingSign;
	}
	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getCate_code_1() {
		return cate_code_1;
	}

	public void setCate_code_1(String cate_code_1) {
		this.cate_code_1 = cate_code_1;
	}

	public String getCate_code_2() {
		return cate_code_2;
	}

	public void setCate_code_2(String cate_code_2) {
		this.cate_code_2 = cate_code_2;
	}
	}
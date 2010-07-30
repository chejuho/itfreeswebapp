/*
 * Created on 2006. 6. 5.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package board;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestResultBean {
	
	private String percent = "";
	private String totalCount = "";
	private String okCount = "";
	private String noCount = "";
	private String testDate = "";
	
	/**
	 * @return Returns the percent.
	 */
	public String getPercent() {
		return percent;
	}
	/**
	 * @param percent The percent to set.
	 */
	public void setPercent(String percent) {
		this.percent = percent;
	}
	/**
	 * @return Returns the testDate.
	 */
	public String getTestDate() {
		return testDate;
	}
	/**
	 * @param testDate The testDate to set.
	 */
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	/**
	 * @return Returns the noCount.
	 */
	public String getNoCount() {
		return noCount;
	}
	/**
	 * @param noCount The noCount to set.
	 */
	public void setNoCount(String noCount) {
		this.noCount = noCount;
	}
	/**
	 * @return Returns the okCount.
	 */
	public String getOkCount() {
		return okCount;
	}
	/**
	 * @param okCount The okCount to set.
	 */
	public void setOkCount(String okCount) {
		this.okCount = okCount;
	}
	/**
	 * @return Returns the totalCount.
	 */
	public String getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount The totalCount to set.
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

}


package bean;
public class StockBean {
	private String code = "";
	private String endPrice = "";
	private String compareYest = "";
	private String sell = "";
	private String buy = "";
	private String startPrice = "";
	private String highPrice = "";
	private String lowPrice = "";
	private String stockDate = "";
	private String average = "";
	/**
	 * @return Returns the average.
	 */
	public String getAverage() {
		return average;
	}
	/**
	 * @param average The average to set.
	 */
	public void setAverage(String average) {
		this.average = average;
	}

	/**
	 * @return Returns the stockDate.
	 */
	public String getStockDate() {
		return stockDate;
	}
	/**
	 * @param stockDate The stockDate to set.
	 */
	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}

	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	public String getCompareYest() {
		return compareYest;
	}
	public void setCompareYest(String compareYest) {
		this.compareYest = compareYest;
	}
	public String getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(String endPrice) {
		this.endPrice = endPrice;
	}
	public String getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}
	public String getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getSell() {
		return sell;
	}
	public void setSell(String sell) {
		this.sell = sell;
	}
	public String getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(String startPrice) {
		this.startPrice = startPrice;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}

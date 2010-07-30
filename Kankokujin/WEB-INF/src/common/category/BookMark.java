package common.category;


public class BookMark {
	
	private String id_ = null;
	private String title_ = null;
	private String url_ = null;;
	private String detail_ = null;;
	
	
	public BookMark(String id, String title, String url, String detail) {
		this.id_ = id;
		this.title_ = title;
		this.url_ = url;
		this.detail_ = detail;
	}
	public BookMark(String title, String url) {
		this.title_ = title;
		this.url_ = url;
	}
	
	public String getId() {
		return id_;
	}
	public String getTitle() {
		return title_;
	}
	public String getDetail() {
		return detail_;
	}
	public String getUrl() {
		return url_;
	}
	public boolean isOpen() {
		return false;
	}
	public void setDetail(String detail) {
		this.detail_ = detail;
	}
	public void setTitle(String title) {
		this.title_ = title;
	}
	public void setUrl(String url) {
		this.url_ = url;
	}
}

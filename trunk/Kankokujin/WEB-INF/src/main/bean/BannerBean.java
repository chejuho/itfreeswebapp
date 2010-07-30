package main.bean;


public class BannerBean {
	
	private String title;
	private String link;
	private String sort;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBannerTag() {
		StringBuffer tag = new StringBuffer();
		tag.append("<a href='");
		tag.append(getLink());
		tag.append("'>");
		tag.append(getTitle());
		tag.append("</a>");
		
		return tag.toString();
	}
}

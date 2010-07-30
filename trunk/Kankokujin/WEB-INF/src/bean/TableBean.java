package bean;

import java.util.ArrayList;
import java.util.List;

public class TableBean {
	private String tableName = "";
	private String englishTableName = "";
	private List<ColumnBean> columnBeanList = new ArrayList<ColumnBean>();
	public List<ColumnBean> getColumnBeanList() {
		return columnBeanList;
	}
	public void setColumnBeanList(List<ColumnBean> columnBeanList) {
		this.columnBeanList = columnBeanList;
	}
	public String getEnglishTableName() {
		return englishTableName;
	}
	public void setEnglishTableName(String englishTableName) {
		this.englishTableName = englishTableName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}

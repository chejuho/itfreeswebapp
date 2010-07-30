package bean;

public class ColumnBean {
	private String columnName = "";
	private String englishColumnName = "";
	private Boolean primaryKey = Boolean.FALSE;
	private Boolean notNullKey = Boolean.FALSE;
	private String columnComment = "";
	private String columnType = "";
	private Integer ketaNum = new Integer(0);
	private Integer shousuten = new Integer(0);
	private String defaultValue = "";
	public String getColumnComment() {
		return columnComment;
	}
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getEnglishColumnName() {
		return englishColumnName;
	}
	public void setEnglishColumnName(String englishColumnName) {
		this.englishColumnName = englishColumnName;
	}
	public Integer getKetaNum() {
		return ketaNum;
	}
	public void setKetaNum(Integer ketaNum) {
		this.ketaNum = ketaNum;
	}
	public Boolean getNotNullKey() {
		return notNullKey;
	}
	public void setNotNullKey(Boolean notNullKey) {
		this.notNullKey = notNullKey;
	}
	public Boolean getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	public Integer getShousuten() {
		return shousuten;
	}
	public void setShousuten(Integer shousuten) {
		this.shousuten = shousuten;
	}	
}

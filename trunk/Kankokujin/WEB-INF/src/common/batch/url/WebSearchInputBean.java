package common.batch.url;

public class WebSearchInputBean {
	
	private String key = null;
	private String startKey = null;
	private String endKey = null;
	private int startOffset = 0;
	private int endOffset = 0;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getStartKey() {
		return startKey;
	}
	public void setStartKey(String startKey) {
		this.startKey = startKey;
	}
	public String getEndKey() {
		return endKey;
	}
	public void setEndKey(String endKey) {
		this.endKey = endKey;
	}
	public int getStartOffset() {
		return startOffset;
	}
	public void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}
	public int getEndOffset() {
		return endOffset;
	}
	public void setEndOffset(int endOffset) {
		this.endOffset = endOffset;
	}
}

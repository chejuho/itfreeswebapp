package iboard.bean;

import java.sql.Timestamp;

import common.util.Util;


public class IBoardBean  {
	
	private String id = null;
	private String title = null;
	private String content = null;
	private String filename1 = null;
	private String filename2 = null;
	private String filename3 = null;
	private String boardId = null;
	private String user_name = null;
	
	private String password = null;
	
	private String read_count = null;
	private Timestamp update_date = null;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilename1() {
		return filename1;
	}
	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}
	public String getDownFile1Url() {
		return "/upload/memorizer/" + filename1;
	}
	public String getFilename2() {
		return filename2;
	}
	public String getDownFile2Url() {
		return "/upload/memorizer/" + filename2;
	}
	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}
	public String getFilename3() {
		return filename3;
	}
	public String getDownFile3Url() {
		return "/upload/memorizer/" + filename3;
	}
	public void setFilename3(String filename3) {
		this.filename3 = filename3;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	
	public Timestamp getUpdate_dateTime() {
		return update_date;
	}
	public void setUpdate_dateTime(Timestamp updateDate) {
		update_date = updateDate;
	}
	
	public String getUpdate_date() {
		return Util.getUpdateDate(update_date);
	}	
	public String getRead_count() {
		return read_count;
	}
	public void setRead_count(String readCount) {
		read_count = readCount;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

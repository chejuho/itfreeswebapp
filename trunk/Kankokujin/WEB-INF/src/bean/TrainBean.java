package bean;

import common.util.Util;

public class TrainBean  implements Comparable {
	private String station_code = "";
	private String station_kanji = "";
	private String station_kana = "";
	private String line_code = "";
	private String line_kanji = "";
	private String line_kana = "";
	public String getLine_code() {
		return line_code;
	}
	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}
	public String getLine_kana() {
		return line_kana;
	}
	public void setLine_kana(String line_kana) {
		this.line_kana = line_kana;
	}
	public String getLine_kanji() {
		return line_kanji;
	}
	public void setLine_kanji(String line_kanji) {
		this.line_kanji = line_kanji;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public String getStation_kana() {
		return station_kana;
	}
	public void setStation_kana(String station_kana) {
		this.station_kana = station_kana;
	}
	public String getStation_kanji() {
		return station_kanji;
	}
	public void setStation_kanji(String station_kanji) {
		this.station_kanji = station_kanji;
	}
	public int compareTo(Object o) {
		
	TrainBean bean = (TrainBean) o;
		
		if (0 < line_code.compareTo(bean.getLine_code())) {
			return 1;
		}
		
		if (Util.isEmpty(line_code)) {
			if (0 < station_code.compareTo(bean.getStation_code())) {
				return 1;
			}
		}
		
		return 0;
	}
	
}

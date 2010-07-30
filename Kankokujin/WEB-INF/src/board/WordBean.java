
package board;


public class WordBean {
	int word_idx;
	String chinese_kanji = "";
	String chinese_yomi1 = "";
	String chinese_yomi2 = "";
	String chinese_sentence = "";
	String japanese_kanji = "";
	String japanese_yomi1 = "";
	String japanese_yomi2 = "";
	String japanese_sentence = "";
	String english = "";
	String korean = "";
	String english_sentence = "";
	int level = 1;
	//default 0, correct 1, not correct 2
	int isCorectFlg = 0;
	/**
	 * @return Returns the isCorectFlg.
	 */
	public int getIsCorectFlg() {
		return isCorectFlg;
	}
	/**
	 * @param isCorectFlg The isCorectFlg to set.
	 */
	public void setIsCorectFlg(int isCorectFlg) {
		this.isCorectFlg = isCorectFlg;
	}



	/**
	 * @return Returns the korean.
	 */
	public String getKorean() {
		return korean;
	}
	/**
	 * @param korean The korean to set.
	 */
	public void setKorean(String korean) {
		this.korean = korean;
	}

	
	/**
	 * @return Returns the chinese_kanji.
	 */
	public String getChinese_kanji() {
		return chinese_kanji;
	}
	/**
	 * @param chinese_kanji The chinese_kanji to set.
	 */
	public void setChinese_kanji(String chinese_kanji) {
		this.chinese_kanji = chinese_kanji;
	}
	/**
	 * @return Returns the chinese_sentence.
	 */
	public String getChinese_sentence() {
		return chinese_sentence;
	}
	/**
	 * @param chinese_sentence The chinese_sentence to set.
	 */
	public void setChinese_sentence(String chinese_sentence) {
		this.chinese_sentence = chinese_sentence;
	}
	/**
	 * @return Returns the chinese_yomi1.
	 */
	public String getChinese_yomi1() {
		return chinese_yomi1;
	}
	/**
	 * @param chinese_yomi1 The chinese_yomi1 to set.
	 */
	public void setChinese_yomi1(String chinese_yomi1) {
		this.chinese_yomi1 = chinese_yomi1;
	}
	/**
	 * @return Returns the chinese_yomi2.
	 */
	public String getChinese_yomi2() {
		return chinese_yomi2;
	}
	/**
	 * @param chinese_yomi2 The chinese_yomi2 to set.
	 */
	public void setChinese_yomi2(String chinese_yomi2) {
		this.chinese_yomi2 = chinese_yomi2;
	}
	/**
	 * @return Returns the english.
	 */
	public String getEnglish() {
		return english;
	}
	/**
	 * @param english The english to set.
	 */
	public void setEnglish(String english) {
		this.english = english;
	}
	/**
	 * @return Returns the english_sentence.
	 */
	public String getEnglish_sentence() {
		return english_sentence;
	}
	/**
	 * @param english_sentence The english_sentence to set.
	 */
	public void setEnglish_sentence(String english_sentence) {
		this.english_sentence = english_sentence;
	}
	/**
	 * @return Returns the japanese_kanji.
	 */
	public String getJapanese_kanji() {
		return japanese_kanji;
	}
	/**
	 * @param japanese_kanji The japanese_kanji to set.
	 */
	public void setJapanese_kanji(String japanese_kanji) {
		this.japanese_kanji = japanese_kanji;
	}
	/**
	 * @return Returns the japanese_sentence.
	 */
	public String getJapanese_sentence() {
		return japanese_sentence;
	}
	/**
	 * @param japanese_sentence The japanese_sentence to set.
	 */
	public void setJapanese_sentence(String japanese_sentence) {
		this.japanese_sentence = japanese_sentence;
	}
	/**
	 * @return Returns the japanese_yomi1.
	 */
	public String getJapanese_yomi1() {
		return japanese_yomi1;
	}
	/**
	 * @param japanese_yomi1 The japanese_yomi1 to set.
	 */
	public void setJapanese_yomi1(String japanese_yomi1) {
		this.japanese_yomi1 = japanese_yomi1;
	}
	/**
	 * @return Returns the japanese_yomi2.
	 */
	public String getJapanese_yomi2() {
		return japanese_yomi2;
	}
	/**
	 * @param japanese_yomi2 The japanese_yomi2 to set.
	 */
	public void setJapanese_yomi2(String japanese_yomi2) {
		this.japanese_yomi2 = japanese_yomi2;
	}
	/**
	 * @return Returns the level.
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level The level to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return Returns the word_idx.
	 */
	public int getWord_idx() {
		return word_idx;
	}
	/**
	 * @param word_idx The word_idx to set.
	 */
	public void setWord_idx(int word_idx) {
		this.word_idx = word_idx;
	}

}

package engmgn.bean;

public class EngMgnBean {

	private String eng_id;

	private String eng_type;

	private String eng_initial;

	private String eng_name1;

	private String eng_name2;

	private String eng_age;

	private String eng_sex;

	private String eng_career;

	private String eng_nation;

	private String eng_nation_etc;

	private String eng_skilllicense;

	private String eng_japlicense;

	private String eng_os;

	private String eng_os_etc;

	private String eng_db;

	private String eng_db_etc;

	private String eng_language;

	private String eng_language_etc;

	private String eng_process;

	private String eng_possibledate;

	private String eng_japanese;

	private String eng_ment;

	private String eng_salary;

	private String eng_state;

	private String eng_filename;

	private String eng_id_position="���jIT�t���[�Y";

	private String eng_resumepath;

	private String eng_updatedate;
	
	private String viewflg;

	private String page_size = "";

	public String getPage_size() {
		return page_size;
	}

	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}

	public String getEng_resumepath() {
		return eng_resumepath;
	}

	public void setEng_resumepath(String eng_resumepath) {
		this.eng_resumepath = eng_resumepath;
	}

	public String getEng_age() {
		return eng_age;
	}

	public void setEng_age(String eng_age) {
		this.eng_age = eng_age;
	}

	public String getEng_career() {
		return eng_career;
	}

	public void setEng_career(String eng_career) {
		this.eng_career = eng_career;
	}

	public String getEng_db() {
		return eng_db;
	}

	public void setEng_db(String eng_db) {
		this.eng_db = eng_db;
	}

	public String getEng_filename() {
		return eng_filename;
	}

	public void setEng_filename(String eng_filename) {
		this.eng_filename = eng_filename;
	}

	public String getEng_id() {
		return eng_id;
	}

	public void setEng_id(String eng_id) {
		this.eng_id = eng_id;
	}

	public String getEng_id_position() {
		return eng_id_position;
	}

	public void setEng_id_position(String eng_id_position) {
		this.eng_id_position = eng_id_position;
	}

	public String getEng_initial() {
		return eng_initial;
	}

	public void setEng_initial(String eng_initial) {
		this.eng_initial = eng_initial;
	}

	public String getEng_japanese() {
		return eng_japanese;
	}

	public void setEng_japanese(String eng_japanese) {
		this.eng_japanese = eng_japanese;
	}

	public String getEng_japlicense() {
		return eng_japlicense;
	}

	public void setEng_japlicense(String eng_japlicense) {
		this.eng_japlicense = eng_japlicense;
	}

	public String getEng_language() {
		return eng_language;
	}

	public void setEng_language(String eng_language) {
		this.eng_language = eng_language;
	}

	public String getEng_ment() {
		return eng_ment;
	}

	public void setEng_ment(String eng_ment) {
		this.eng_ment = eng_ment;
	}

	public String getEng_name1() {
		return eng_name1;
	}

	public void setEng_name1(String eng_name1) {
		this.eng_name1 = eng_name1;
	}

	public String getEng_name2() {
		return eng_name2;
	}

	public void setEng_name2(String eng_name2) {
		this.eng_name2 = eng_name2;
	}

	public String getEng_nation() {
		return eng_nation;
	}

	public void setEng_nation(String eng_nation) {
		this.eng_nation = eng_nation;
	}

	public String getEng_os() {
		return eng_os;
	}

	public void setEng_os(String eng_os) {
		this.eng_os = eng_os;
	}

	public String getEng_possibledate() {
		return eng_possibledate;
	}

	public void setEng_possibledate(String eng_possibledate) {
		this.eng_possibledate = eng_possibledate;
	}

	public String getEng_process() {
		return eng_process;
	}

	public void setEng_process(String eng_process) {
		this.eng_process = eng_process;
	}

	public String getEng_salary() {
		return eng_salary;
	}

	public void setEng_salary(String eng_salary) {
		this.eng_salary = eng_salary;
	}

	public String getEng_skilllicense() {
		return eng_skilllicense;
	}

	public void setEng_skilllicense(String eng_skilllicense) {
		this.eng_skilllicense = eng_skilllicense;
	}

	public String getEng_state() {
		return eng_state;
	}

	public void setEng_state(String eng_state) {
		this.eng_state = eng_state;
	}

	public String getEng_type() {
		return eng_type;
	}

	public void setEng_type(String eng_type) {
		this.eng_type = eng_type;
	}

	public String getEng_db_etc() {
		return eng_db_etc;
	}

	public void setEng_db_etc(String eng_db_etc) {
		this.eng_db_etc = eng_db_etc;
	}

	public String getEng_language_etc() {
		return eng_language_etc;
	}

	public void setEng_language_etc(String eng_language_etc) {
		this.eng_language_etc = eng_language_etc;
	}

	public String getEng_nation_etc() {
		return eng_nation_etc;
	}

	public void setEng_nation_etc(String eng_nation_etc) {
		this.eng_nation_etc = eng_nation_etc;
	}

	public String getEng_os_etc() {
		return eng_os_etc;
	}

	public void setEng_os_etc(String eng_os_etc) {
		this.eng_os_etc = eng_os_etc;
	}

	public String getEng_sex() {
		return eng_sex;
	}

	public void setEng_sex(String eng_sex) {
		this.eng_sex = eng_sex;
	}

	public String getEng_sexname() {
		String eng_sexname = "";
		if ("0".equals(eng_sex)) {
			eng_sexname = "�j";
		} else if ("1".equals(eng_sex)) {
			eng_sexname = "��";
		}
		return eng_sexname;
	}

	public String getEng_Nationality() {
		String nation = eng_nation;
		if ("1".equals(nation)) {
			nation = "�؍�";
		} else if ("2".equals(nation)) {
			nation = "��{";
		} else if ("9".equals(nation)) {
			nation = eng_nation_etc;
		}
		return nation;
	}

	public String getEng_TypeName() {
		String type = eng_type;
		if ("1".equals(type)) {
			type = "���Ј�";
		} else if ("2".equals(type)) {
			type = "�_��Ј�";
		} else if ("3".equals(type)) {
			type = "�t���[";
		} else if ("4".equals(type)) {
			type = "���͎Ј�";
		}
		return type;
	}

	public String getProCessName() {
		StringBuffer sbprocess = new StringBuffer();
		StringBuffer protemp = new StringBuffer();
		sbprocess.append(eng_process);
		String protStr = sbprocess.toString();
		for (int x = 0; x < protStr.length(); x++) {
			if (protStr.charAt(x) == '1') {
				protemp.append("�v����`");
			} else if (protStr.charAt(x) == '2') {
				protemp.append("��{�݌v");
			} else if (protStr.charAt(x) == '3') {
				protemp.append("�ڍא݌v");
			} else if (protStr.charAt(x) == '4') {
				protemp.append("����");
			} else if (protStr.charAt(x) == '5') {
				protemp.append("�P�̃e�X�g");
			} else if (protStr.charAt(x) == '6') {
				protemp.append("�����e�X�g");
			} else if (protStr.charAt(x) == '7') {
				protemp.append("�V�X�e���e�X�g");
			}
			if (x < protStr.length() - 1) {
				protemp.append(", ");
			}

		}
		return protemp.toString();
	}

	public String getPossibledate() {
		String possibledate = "";
		if (eng_possibledate.equals("now")) {
		//	possibledate = "���\";
		} else {
			possibledate = eng_possibledate.substring(0, 4) + "/"
					+ eng_possibledate.substring(4);
		}
		return possibledate;
	}

	public String getJapGrade() {
		String grade = "";
		if ("1".equals(eng_japanese)) {
			grade = "����";
		} else if ("2".equals(eng_japanese)) {
			grade = "��";
		} else if ("3".equals(eng_japanese)) {
			grade = "��";
		} else if ("4".equals(eng_japanese)) {
			grade = "��";
		}
		return grade;
	}

	public String getOsType() {
		StringBuffer sbprocess = new StringBuffer();
		StringBuffer os = new StringBuffer();
		sbprocess.append(eng_os);
		String osStr = sbprocess.toString();
		for (int x = 0; x < osStr.length(); x++) {
			if (osStr.charAt(x) == '1') {
				os.append("Linux ");
			}
			if (osStr.charAt(x) == '2') {
				os.append("Unix ");
			}
			if (osStr.charAt(x) == '3') {
				os.append("Windows ");
			}
			if (osStr.charAt(x) == '4') {
				os.append("����");
			}
			if (osStr.charAt(x) == '9') {
				os.append(eng_os_etc);
			}
			if (x < osStr.length() - 1) {
				os.append(", ");
			}

		}
		return os.toString();
	}

	public String getDbType() {
		StringBuffer sbprocess = new StringBuffer();
		StringBuffer os = new StringBuffer();
		sbprocess.append(eng_os);
		String osStr = sbprocess.toString();
		for (int x = 0; x < osStr.length(); x++) {
			if (osStr.charAt(x) == '1') {
				os.append("MySQL  ");
			}
			if (osStr.charAt(x) == '2') {
				os.append("MsSQL  ");
			}
			if (osStr.charAt(x) == '3') {
				os.append("Oracle  ");
			}
			if (osStr.charAt(x) == '9') {
				os.append(eng_db_etc);
			}
			if (x < osStr.length() - 1) {
				os.append(", ");
			}
		}
		return os.toString();
	}

	public String getLanguage() {
		StringBuffer sblang = new StringBuffer();
		StringBuffer language = new StringBuffer();
		sblang.append(eng_language);
		String lang = sblang.toString();
		for (int x = 0; x < lang.length(); x++) {
			if (lang.charAt(x) == '1') {
				language.append("JAVA");
			}
			if (lang.charAt(x) == '2') {
				language.append("C");
			}
			if (lang.charAt(x) == '3') {
				language.append("C#");
			}
			if (lang.charAt(x) == '4') {
				language.append("VB");
			}
			if (lang.charAt(x) == '5') {
				language.append(".NET");
			}
			if (lang.charAt(x) == '9') {
				language.append(eng_language_etc);
			}
			if (x < lang.length() - 1) {
				language.append(", ");
			}
		}
		return language.toString();
	}

	public String[] getNation_checked() {
		String[] Nation = { "", "", "" };
		if ("1".equals(eng_nation)) {
			Nation[0] = " checked";
		} else if ("2".equals(eng_nation)) {
			Nation[1] = " checked";
		} else if ("9".equals(eng_nation)) {
			Nation[2] = " checked";
		}
		return Nation;
	}

	public String[] getSex_checked() {
		String[] sex = { "", "" };
		if ("0".equals(eng_sex)) {
			sex[0] = " checked";
		} else if ("1".equals(eng_sex)) {
			sex[1] = " checked";
		}
		return sex;
	}

	public String[] getEngType_checked() {
		String[] engType = { "", "", "", "" };
		if ("1".equals(eng_type)) {
			engType[0] = " checked";
		} else if ("2".equals(eng_type)) {
			engType[1] = " checked";
		} else if ("3".equals(eng_type)) {
			engType[2] = " checked";
		} else if ("4".equals(eng_type)) {
			engType[3] = " checked";
		}
		return engType;
	}

	public String[] getOsType_checked() {
		int size = eng_os.length();

		String[] osType = { "", "", "", "" };
		for (int i = 0; i < size; i++) {
			String os = eng_os.substring(i, i + 1);
			if ("1".equals(os)) {
				osType[0] = " checked";
			} else if ("2".equals(os)) {
				osType[1] = " checked";
			} else if ("3".equals(os)) {
				osType[2] = " checked";
			} else if ("9".equals(os)) {
				osType[3] = " checked";
			}
		}
		return osType;
	}

	public String[] getDbType_checked() {
		int size = eng_db.length();
		String[] dbType = { "", "", "", "" };
		for (int i = 0; i < size; i++) {
			String db = eng_os.substring(i, i + 1);
			if ("1".equals(db)) {
				dbType[0] = " checked";
			} else if ("2".equals(db)) {
				dbType[1] = " checked";
			} else if ("3".equals(db)) {
				dbType[2] = " checked";
			} else if ("9".equals(db)) {
				dbType[3] = " checked";
			}
		}
		return dbType;
	}

	public String[] getLanguage_checked() {
		int size = eng_language.length();
		String[] languageType = { "", "", "", "", "", "" };
		for (int i = 0; i < size; i++) {
			String language = eng_language.substring(i, i + 1);
			if ("1".equals(language)) {
				languageType[0] = " checked";
			} else if ("2".equals(language)) {
				languageType[1] = " checked";
			} else if ("3".equals(language)) {
				languageType[2] = " checked";
			} else if ("4".equals(language)) {
				languageType[3] = " checked";
			} else if ("5".equals(language)) {
				languageType[4] = " checked";
			} else if ("9".equals(language)) {
				languageType[5] = " checked";
			}
		}
		return languageType;
	}

	public String[] getProcess_checked() {
		int size = eng_process.length();
		String[] processType = { "", "", "", "", "", "", "" };
		for (int i = 0; i < size; i++) {
			String process = eng_process.substring(i, i + 1);
			if ("1".equals(process)) {
				processType[0] = " checked";
			} else if ("2".equals(process)) {
				processType[1] = " checked";
			} else if ("3".equals(process)) {
				processType[2] = " checked";
			} else if ("4".equals(process)) {
				processType[3] = " checked";
			} else if ("5".equals(process)) {
				processType[4] = " checked";
			} else if ("6".equals(process)) {
				processType[5] = " checked";
			} else if ("7".equals(process)) {
				processType[6] = " checked";
			}
		}
		return processType;
	}

	public String[] getJap_checked() {
		String[] Nation = { "", "", "", "" };
		if ("1".equals(eng_japanese)) {
			Nation[0] = " checked";
		} else if ("2".equals(eng_japanese)) {
			Nation[1] = " checked";
		} else if ("3".equals(eng_japanese)) {
			Nation[2] = " checked";
		} else if ("4".equals(eng_japanese)) {
			Nation[3] = " checked";
		}
		return Nation;
	}

	public String getEng_updatedate() {
		return eng_updatedate;
	}

	public void setEng_updatedate(String eng_updatedate) {
		this.eng_updatedate = eng_updatedate;
	}

	public String getViewflg() {
		return viewflg;
	}

	public void setViewflg(String viewflg) {
		this.viewflg = viewflg;
	}
}
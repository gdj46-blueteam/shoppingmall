package vo;

public class Language {
	//기본생성자
		public Language() {}
	// 필드생성
	private int languageNo;
	private String language;
	
	// toString() : 필드값을 문자열로 출력
	@Override
	public String toString() {
		return "Language [languageNo=" + languageNo + ", language=" + language + "]";
	}
	// getter & setter
	public int getLanguageNo() {
		return languageNo;
	}

	public void setLanguageNo(int languageNo) {
		this.languageNo = languageNo;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}

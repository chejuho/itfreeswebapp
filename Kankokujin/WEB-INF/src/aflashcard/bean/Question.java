package aflashcard.bean;

public class Question {
	
	private String question = "";
	private String answer = "";
	private String memorySign = "";
	private String quizSign = "";
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getMemorySign() {
		return memorySign;
	}
	public void setMemorySign(String memorySign) {
		this.memorySign = memorySign;
	}
	public String getQuizSign() {
		return quizSign;
	}
	public void setQuizSign(String quizSign) {
		this.quizSign = quizSign;
	}
	
	public void setValue(int i, String value, boolean displayOption) {
		switch (i) {
		case 0 : 
			this.setMemorySign(value);
			break;
		case 1 : 
			this.setQuizSign(value);
			break;
		case 2 : 
			if (displayOption) {
				setQuestion(value);
			} else {
				setAnswer(value);
			}
			break;
		case 3 : 
			if (displayOption) {
				setAnswer(value);
			} else {
				setQuestion(value);
			}
			
			break;

		}	
	}
	
	

}

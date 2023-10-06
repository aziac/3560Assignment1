import java.util.List;

public interface Question {
	public String getQuestion();
	public List<String> getAnswerChoices();
	public boolean isAnswerCorrect(List<String> studentAnswer);
    public <T> T getCorrectAnswer();
}

import java.util.List;

public class MultipleChoice implements Question {
    private String question;
    private List<String> answerChoices;
    private List<String> correctAnswers;

    public MultipleChoice(String question, List<String> answerChoices, List<String> correctAnswers) {
        this.question = question;
        this.answerChoices = answerChoices;
        this.correctAnswers = correctAnswers;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    @Override
    public boolean isAnswerCorrect(List<String> studentAnswer) {
    	return studentAnswer.containsAll(correctAnswers) && correctAnswers.containsAll(studentAnswer);    
    }

    public List<String> getCorrectAnswer(){
    	return this.correctAnswers;
    }
}

import java.util.List;

public class SingleChoice implements Question {
    private String question;
    private List<String> answerChoices;
    private String correctAnswer;

    public SingleChoice(String question, List<String> answerChoices, String correctAnswer) {
        this.question = question;
        this.answerChoices = answerChoices;
        this.correctAnswer = correctAnswer;
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
        return studentAnswer.get(studentAnswer.size()-1).equals(correctAnswer);
    }
    
    public String getCorrectAnswer(){
    	return this.correctAnswer;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VotingService {
    private Question currentQuestion;
    private Map<String, Integer> answerCounts;
    private List<String> smartyPants;

    public VotingService(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
        this.answerCounts = new HashMap<>();
        this.smartyPants = new ArrayList<>();
        initializeAnswerCounts();
    }

    private void initializeAnswerCounts() {
        for (String choice : currentQuestion.getAnswerChoices()) {
            answerCounts.put(choice, 0);
        }
    }

    public void acceptSubmission(Student student) {
        List<String> selectedAnswers = student.getSelectedAnswers();
        if (currentQuestion.isAnswerCorrect(selectedAnswers)) {
            smartyPants.add(student.getId());
        }
        // Checks if the question is single choice or multiple choice to add to answer count
        if (currentQuestion.getCorrectAnswer() instanceof String) {
    		answerCounts.put(selectedAnswers.get(selectedAnswers.size()-1), answerCounts.get(selectedAnswers.get(selectedAnswers.size()-1)) + 1);
        }
        else {
        	for (String answer : selectedAnswers) {
        		answerCounts.put(answer, answerCounts.get(answer) + 1);
        	}
        }
        
    }

    public void generateStatistics() {
        System.out.println(currentQuestion.getQuestion() + " Question Results:");
        for (Map.Entry<String, Integer> entry : answerCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Correct Answer: " + currentQuestion.getCorrectAnswer());
        System.out.print("Correct Students: ");
        // in case there are no correct students
        if(smartyPants.isEmpty()) {
        	System.out.println();
        	}
        
        for (String id : smartyPants) {
        	if(id != smartyPants.get(smartyPants.size()-1)) {
            	System.out.print(id + ", ");
        	}
        	else System.out.println(id);
        }
    }

	public Question getCurrentQuestion() {
		// TODO Auto-generated method stub
		return this.currentQuestion;
	}
}

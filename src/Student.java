import java.util.ArrayList;
import java.util.List;

public class Student {
	private String id;
	private List<String> selectedAnswers;
	
	
	public Student(String id) {
		this.id = id;
        this.selectedAnswers = new ArrayList<>(); 
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public List<String> getSelectedAnswers() {
		return selectedAnswers;
	}
	
	public void addAnswer(String answer) {
		this.selectedAnswers.add(answer);
	}

	public void setSelectedAnswers(List<String> selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}

	
	
	
}

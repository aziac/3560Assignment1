import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {
        List<String> choices = Arrays.asList("A", "B", "C", "D");
        List<String> trueOrFalse = Arrays.asList("True", "False");

        Question multipleChoiceQuestion = new MultipleChoice("Multiple Choice", choices, Arrays.asList("A", "C"));

        Question singleChoiceQuestion = new SingleChoice("Single Choice", trueOrFalse, "True");

        VotingService votingService1 = new VotingService(multipleChoiceQuestion);
        VotingService votingService2 = new VotingService(singleChoiceQuestion);

        // Simulate student submissions
        simulateStudentSubmissions(votingService1, 10);
        simulateStudentSubmissions(votingService2, 10);

        // Statistics
        votingService1.generateStatistics();

        votingService2.generateStatistics();
    }

    private static void simulateStudentSubmissions(VotingService votingService, int numberOfStudents) {
        Random random = new Random();
        List<String> choices = votingService.getCurrentQuestion().getAnswerChoices();

        for (int i = 0; i < numberOfStudents; i++) {
            String studentId = "Student" + (i + 1);
            Student student = new Student(studentId);
            // Random number of times for a student to submit an answer
            int randomLoop = random.nextInt(votingService.getCurrentQuestion().getAnswerChoices().size()) + 1;
            for (int j = 1; j <= randomLoop; j++) {
                String randomChoice = choices.get(random.nextInt(choices.size()));
                student.addAnswer(randomChoice);
            }
            votingService.acceptSubmission(student);
        }
    }
}

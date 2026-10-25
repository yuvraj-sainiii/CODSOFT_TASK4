import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "1. Which language is used for Android development?",
            "2. Which of the following is not a programming language?",
            "3. Which keyword is used to create an object in Java?",
            "4. Which data type stores true or false?",
            "5. Which method is the starting point of a Java program?"
        };

        String[][] options = {
            {"A. Java", "B. HTML", "C. CSS", "D. SQL"},
            {"A. Java", "B. Python", "C. HTML", "D. C++"},
            {"A. class", "B. new", "C. static", "D. void"},
            {"A. int", "B. char", "C. boolean", "D. double"},
            {"A. start()", "B. run()", "C. main()", "D. print()"}
        };

        char[] answers = {'A', 'C', 'B', 'C', 'C'};
        int score = 0;
        int timeLimit = 10;

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You have " + timeLimit + " seconds to answer each question.");
        System.out.println("Enter A, B, C, or D.");
        System.out.println();

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();

            System.out.print("Your answer: ");
            String input = sc.nextLine().trim().toUpperCase();

            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000;

            if (timeTaken > timeLimit) {
                System.out.println("Time is up! No marks for this question.");
            } else if (input.length() == 1 && input.charAt(0) == answers[i]) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Incorrect answer. Correct answer: " + answers[i]);
            }

            System.out.println();
        }

        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.length);

        double percentage = (score * 100.0) / questions.length;
        System.out.printf("Percentage: %.2f%%%n", percentage);

        sc.close();
    }
}

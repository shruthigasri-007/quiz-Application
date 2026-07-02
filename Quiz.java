package QuizApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private String studentName;
    private ArrayList<Question> questions;
    private ArrayList<Integer> userAnswers;
    private int score;

    private long startTime;
    private long endTime;

    public Quiz(String studentName) {
        this.studentName = studentName;
        questions = new ArrayList<>();
        userAnswers = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {

        questions.add(new Question("Which language is used for web styling?",
                new String[]{"HTML", "CSS", "Java", "Python"}, 2));

        questions.add(new Question("Who developed Java?",
                new String[]{"Microsoft", "Sun Microsystems", "Google", "Apple"}, 2));

        questions.add(new Question("Which keyword creates object?",
                new String[]{"this", "class", "new", "object"}, 3));

        questions.add(new Question("Which loop runs at least once?",
                new String[]{"for", "while", "do while", "foreach"}, 3));

        questions.add(new Question("Which stores duplicates?",
                new String[]{"Set", "Map", "ArrayList", "TreeSet"}, 3));

        questions.add(new Question("Java owned by?",
                new String[]{"IBM", "Oracle", "Google", "Meta"}, 2));

        questions.add(new Question("Statement terminator?",
                new String[]{".", ";", ":", ","}, 2));

        questions.add(new Question("Main method?",
                new String[]{"start()", "run()", "main()", "execute()"}, 3));

        questions.add(new Question("Java is?",
                new String[]{"Procedural", "OOP", "Assembly", "Machine"}, 2));

        questions.add(new Question("Scanner package?",
                new String[]{"java.io", "java.util", "java.lang", "java.net"}, 2));

    }

    public void startQuiz() {

        Scanner sc = new Scanner(System.in);
        startTime = System.currentTimeMillis();

        for (int i = 0; i < questions.size(); i++) {

            Question q = questions.get(i);

            System.out.println("\n-------------------------------------------------");
            System.out.println("Question " + (i + 1));
            System.out.println(q.getQuestion());

            String[] options = q.getOptions();

            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            LiveTimer timer = new LiveTimer();
            timer.start();

            System.out.print("Enter answer (1-4): ");

            int answer;

            try {
                answer = sc.nextInt();
            } catch (Exception e) {
                sc.next();
                answer = 0;
            }

            timer.stopTimer();

            if (timer.timeLeft < 0) {
                answer = 0; // auto skip
            }

            userAnswers.add(answer);

            if (answer == q.getCorrectAnswer()) {
                score++;
            }
        }

        endTime = System.currentTimeMillis();

        Result.showResult(studentName, score, questions.size(),
                questions, userAnswers, startTime, endTime);
    }
}

package QuizApplication;



import java.util.ArrayList;



public class Result {



    public static void showResult(String name, int score, int total,

                                  ArrayList<Question> questions,

                                  ArrayList<Integer> userAnswers,

                                  long startTime, long endTime) {



        int wrong = total - score;

        double percentage = ((double) score / total) * 100;



        String grade;



        if (percentage >= 80) grade = "A";

        else if (percentage >= 60) grade = "B";

        else if (percentage >= 40) grade = "C";

        else if (percentage >= 20) grade = "D";

        else grade = "F";



        long timeTaken = (endTime - startTime) / 1000;

        long min = timeTaken / 60;

        long sec = timeTaken % 60;



        System.out.println("\n====================================================");

        System.out.println("               QUIZ REPORT");

        System.out.println("====================================================");



        System.out.println("Candidate Name  : " + name);

        System.out.println("Total Questions : " + total);

        System.out.println("Correct         : " + score);

        System.out.println("Wrong           : " + wrong);

        System.out.println("Score           : " + score + " / " + total);

        System.out.printf("Percentage      : %.2f%%\n", percentage);

        System.out.println("Grade           : " + grade);

        System.out.println("Time Taken      : " + min + " min " + sec + " sec");



        System.out.println("\n====================================================");

        System.out.println("              ANSWER REVIEW");

        System.out.println("======================================================");



        for (int i = 0; i < questions.size(); i++) {



            Question q = questions.get(i);



            int user = userAnswers.get(i);

            int correct = q.getCorrectAnswer();



            System.out.println("\nQuestion " + (i + 1));

            System.out.println(q.getQuestion());



            System.out.println("Your Answer   : " +

                    (user >= 1 ? q.getOptions()[user - 1] : "Skipped"));



            System.out.println("Correct Answer: " +

                    q.getOptions()[correct - 1]);



            System.out.println("Result        : " +

                    (user == correct ? "✅ Correct" : "❌ Incorrect"));



            System.out.println("-----------------------------------------------------");

        }



        System.out.println("\n====================================================");

    }

}


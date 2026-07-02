package QuizApplication;



import java.util.Scanner;



public class Main {



    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);



        while (true) {



            System.out.println("\n===============================================");

            System.out.println("             QUIZ APPLICATION");

            System.out.println("=================================================");

            System.out.println("1. Start Quiz");

            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");



            int choice;



            try {

                choice = sc.nextInt();

            } catch (Exception e) {

                sc.next();

                choice = 0;

            }



            switch (choice) {



                case 1:



                    System.out.print("Enter your name: ");

                    sc.nextLine(); // buffer clear

                    String name = sc.nextLine();



                    Quiz quiz = new Quiz(name);

                    quiz.startQuiz();

                    break;



                case 2:

                    System.out.println("Thank you!");

                    System.exit(0);

                    break;



                default:

                    System.out.println("Invalid Choice!");

            }



            System.out.print("\nPlay again? (Y/N): ");

            String again = sc.next();



            if (!again.equalsIgnoreCase("Y")) {

                break;

            }

        }



        sc.close();

    }

}




import java.util.Scanner;

public class calculateGrades {
    public static void main(String[] args) {
        double quiz, midterm, lastterm;
        double percentageQuiz, percentageMid;
        double passingGrade;
        double average1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the passing grade: ");
        passingGrade = scan.nextInt();


        System.out.println("Enter the quiz grade: ");
        quiz = getValidDouble(scan);

        System.out.println("Please enter decimal number between 0 and 1 (like 0.2).");
        System.out.println("Enter the effect of the quiz grade on the percentage: ");
        percentageQuiz = getValidPercentage(scan);

        System.out.println("Enter the midterm grade: ");
        midterm = getValidDouble(scan);

        System.out.println("Enter the effect of the midterm grade on the percentage: ");
        percentageMid = getValidPercentage(scan);


        average1 = (quiz * percentageQuiz) + (midterm * percentageMid);
        System.out.println("Your average is:" + average1);

        lastterm = (passingGrade - (quiz * percentageQuiz) - (midterm * percentageMid))
                / (1 - (percentageMid + percentageQuiz));

        passingGrade = (quiz * percentageQuiz) + (midterm * percentageMid)
                + (lastterm * (1 - (percentageMid + percentageQuiz)));

        lastterm = (int) lastterm;

        if (average1 < 50) {
            System.out.println("You need to get " + lastterm + " for pass.");
        } else {
            System.out.println("You are already passed.");
        }

        scan.close();
    }

    //Input validation function to get a valid decimal number from the user

    public static double getValidDouble(Scanner scan) {
        while (true) {
            if (scan.hasNextDouble()) {
                return scan.nextDouble();
            } else {
                System.out.println("Invalid input, please enter a valid decimal number.");
                scan.next(); //Clear incorrect entry
            }
        }
    }

    // Input validation function to get a valid percentage value from the user

    public static double getValidPercentage(Scanner scan) {
        while (true) {
            double percentage = getValidDouble(scan);
            if (percentage > 0 && percentage < 1) {
                return percentage;
            } else {
                System.out.println("invalid input, please enter a decimal number between 0 and 1.");
            }
        }
    }
}

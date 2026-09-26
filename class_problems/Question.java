import java.util.*;

abstract class Question {
    protected String question;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String question, String correctAnswer,
             String studentAnswer, double points) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {
    MCQ(String question, String correctAnswer,
        String studentAnswer, double points) {
        super(question, correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TF extends Question {
    TF(String question, String correctAnswer,
       String studentAnswer, double points) {
        super(question, correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String question, String correctAnswer,
          String studentAnswer, double points) {
        super(question, correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String question = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String[] last = parts[6].trim().split("\\s+");
            double points = Double.parseDouble(last[0]);

            Question q;

            if (type.equals("MCQ")) {
                q = new MCQ(
                    question,
                    correctAnswer,
                    studentAnswer,
                    points
                );
            } else if (type.equals("TF")) {
                q = new TF(
                    question,
                    correctAnswer,
                    studentAnswer,
                    points
                );
            } else {
                q = new Essay(
                    question,
                    correctAnswer,
                    studentAnswer,
                    points
                );
            }

            double score = q.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}

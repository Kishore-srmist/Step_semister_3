class Scorecard {
    private boolean[] answers;
    private int count;

    Scorecard(int questions) {
        answers = new boolean[questions];
    }

    void recordAnswer(boolean result) {
        if (count < answers.length)
            answers[count++] = result;
    }

    int getScore() {
        int score = 0;

        for (boolean a : answers)
            if (a) score++;

        return score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}

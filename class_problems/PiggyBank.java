class PiggyBank {
    private int savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    void deposit(int amount) {
        savings += amount;
    }

    void withdraw(int amount) {
        if (amount <= savings)
            savings -= amount;
    }

    int getSavings() {
        return savings;
    }
}

public class Main {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println(pb.getSavings());
    }
}

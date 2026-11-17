
import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);
    double getFee();
    String getName();
}

class CashPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }

    public double getFee() {
        return 0;
    }

    public String getName() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    double amount;

    public double processPayment(double amount) {
        this.amount = amount;
        return amount * 1.02;
    }

    public double getFee() {
        return amount * 0.02;
    }

    public String getName() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }

    public double getFee() {
        return 0;
    }

    public String getName() {
        return "UPI";
    }
}

public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double amount = sc.nextDouble();

            amounts[i] = amount;

            if (mode.equalsIgnoreCase("Cash"))
                payments[i] = new CashPayment();
            else if (mode.equalsIgnoreCase("Card"))
                payments[i] = new CardPayment();
            else
                payments[i] = new UpiPayment();
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            double processed =
                    payments[i].processPayment(amounts[i]);

            System.out.println(payments[i].getName()
                    + ": amount " + amounts[i]
                    + ", fee " + payments[i].getFee()
                    + ", processed " + processed);

            total += processed;
        }

        System.out.println("Total Amount Processed: " + total);
        sc.close();
    }
}

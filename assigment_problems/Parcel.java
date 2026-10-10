
import java.util.*;

interface Insurable {
    double insurance(double value);
}

abstract class Parcel {
    double weight, value;

    Parcel(double w, double v) {
        weight = w;
        value = v;
    }

    abstract double charge();

    double insurance() {
        if (this instanceof Insurable)
            return ((Insurable) this).insurance(value);
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance(double v) {
        return v * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance(double v) {
        return v * 0.02;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            Parcel p;

            if (type.equals("STANDARD"))
                p = new Standard(w, v);
            else if (type.equals("EXPRESS"))
                p = new Express(w, v);
            else
                p = new Fragile(w, v);

            double c = p.charge();
            double ins = p.insurance();
            double t = c + ins;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, c, ins, t);
            grand += t;
        }

        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}

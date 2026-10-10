
import java.util.*;

interface NightService {
    double nightFare(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    double fare() {
        return Math.max(100, km * rate());
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    public double nightFare(double f) {
        return f * 1.2;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    public double nightFare(double f) {
        return f * 1.2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab c;

            if (type.equals("MINI"))
                c = new Mini(km);
            else if (type.equals("SEDAN"))
                c = new Sedan(km);
            else
                c = new SUV(km);

            if (time.equals("NIGHT") && !(c instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double f = c.fare();

            if (time.equals("NIGHT"))
                f = ((NightService) c).nightFare(f);

            System.out.printf("%s: %.2f%n", type, f);
            total += f;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}


import java.util.*;

interface SaverMode {
    double reduceUnits(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double h) {
        hours = h;
    }

    abstract double power();

    double units() {
        return power() * hours / 1000;
    }

    double cost(double u) {
        return u * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double power() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double power() {
        return 1500;
    }

    public double reduceUnits(double u) {
        return u * 0.75;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double power() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double power() {
        return 500;
    }

    public double reduceUnits(double u) {
        return u * 0.75;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] a = sc.nextLine().trim().split("\\s+");
            String type = a[0];
            double hours = Double.parseDouble(a[1]);
            boolean saver = a.length > 2 && a[2].equals("SAVER");

            Appliance ap;

            switch (type) {
                case "FRIDGE":
                    ap = new Fridge(hours);
                    break;
                case "AC":
                    ap = new AC(hours);
                    break;
                case "TV":
                    ap = new TV(hours);
                    break;
                default:
                    ap = new Washer(hours);
            }

            if (saver && !(ap instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double u = ap.units();

            if (saver)
                u = ((SaverMode) ap).reduceUnits(u);

            double c = ap.cost(u);
            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n", type, u, c);
            total += c;
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}

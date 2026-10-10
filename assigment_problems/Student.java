
import java.util.*;

interface BusUser {
    double transportFee();
}

abstract class Student {
    String name;

    Student(String n) {
        name = n;
    }

    abstract double fee();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String n) {
        super(n);
    }

    public double transportFee() {
        return 12000;
    }

    double fee() {
        return 40000 + transportFee();
    }
}

class Hosteller extends Student {
    Hosteller(String n) {
        super(n);
    }

    double fee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String n) {
        super(n);
    }

    public double transportFee() {
        return 12000;
    }

    double fee() {
        return 20000 + transportFee();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double f = s.fee();
            System.out.printf("%s: %.2f%n", name, f);
            total += f;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}

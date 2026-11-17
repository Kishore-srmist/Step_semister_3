
import java.util.Scanner;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    String getType() {
        return "Staff";
    }

    double getTotal() {
        return baseSalary + getBonus();
    }

    void display() {
        System.out.println(name + " (" + getType() + "): base "
                + baseSalary + ", bonus " + getBonus()
                + ", total " + getTotal());
    }
}

class Teacher extends Staff {
    Teacher(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return 5000;
    }

    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return 2000;
    }

    String getType() {
        return "LabAssistant";
    }
}

public class CampusStaffSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equalsIgnoreCase("Teacher"))
                staff[i] = new Teacher(name, salary);
            else if (type.equalsIgnoreCase("LabAssistant"))
                staff[i] = new LabAssistant(name, salary);
            else
                staff[i] = new Staff(name, salary);
        }

        double grandTotal = 0;

        for (Staff s : staff) {
            s.display();
            grandTotal += s.getTotal();
        }

        System.out.println("Grand Total Salary: " + grandTotal);
        sc.close();
    }
}

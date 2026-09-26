import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;
    protected LocalDate currentDate;

    LibraryItem(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    abstract int getBorrowDays();

    LocalDate getDueDate() {
        return currentDate.plusDays(getBorrowDays());
    }
}

class Book extends LibraryItem {
    Book(String title, LocalDate date) {
        super(title, date);
    }

    int getBorrowDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title, LocalDate date) {
        super(title, date);
    }

    int getBorrowDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, LocalDate date) {
        super(title, date);
    }

    int getBorrowDays() {
        return 3;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);

            String title = line.substring(firstSpace + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title, currentDate);
            } else if (type.equals("DVD")) {
                item = new DVD(title, currentDate);
            } else {
                item = new Magazine(title, currentDate);
            }

            System.out.println(
                item.title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}

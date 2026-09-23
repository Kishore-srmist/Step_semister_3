class AttendanceSheet {
    private String[] students;
    private int count;

    AttendanceSheet(int size) {
        students = new String[size];
    }

    void markPresent(String name) {
        if (!isPresent(name) && count < students.length)
            students[count++] = name;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++)
            if (students[i].equals(name))
                return true;

        return false;
    }

    int getPresentCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}

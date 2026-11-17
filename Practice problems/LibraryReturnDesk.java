
import java.util.Scanner;

public class LibraryReturnDesk {
    static String[] pile = new String[3];
    static int top = -1;

    static String[] queue = new String[3];
    static int front = 0, rear = -1, size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] commands = input.split(",");

        for (String cmd : commands) {
            cmd = cmd.trim();

            if (cmd.startsWith("RETURN")) {
                String book = cmd.substring(7).trim();

                if (top == 2)
                    System.out.println(book + " rejected: pile is full");
                else {
                    pile[++top] = book;
                    System.out.println(book + " placed on pile");
                }
            }

            else if (cmd.equals("SHELVE")) {
                if (top == -1)
                    System.out.println("pile is empty");
                else
                    System.out.println("shelved " + pile[top--]);
            }

            else if (cmd.startsWith("WAIT")) {
                String student = cmd.substring(4).trim();

                if (size == 3)
                    System.out.println("line is full");
                else {
                    rear = (rear + 1) % 3;
                    queue[rear] = student;
                    size++;
                    System.out.println(student + " joined the line");
                }
            }

            else if (cmd.equals("SERVE")) {
                if (size == 0)
                    System.out.println("no one waiting");
                else {
                    System.out.println("served " + queue[front]);
                    front = (front + 1) % 3;
                    size--;
                }
            }
        }

        sc.close();
    }
}

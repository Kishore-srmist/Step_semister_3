
import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class LateComersInTheLine {

    static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    static Node addLast(Node head, String name) {
        Node newNode = new Node(name);

        if (head == null)
            return newNode;

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null;

        // Create starting line
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            head = addLast(head, name);
        }

        int operations = sc.nextInt();

        // Apply operations
        for (int i = 0; i < operations; i++) {
            String operation = sc.next();
            String name = sc.next();

            if (operation.equals("addFirst"))
                head = addFirst(head, name);
            else if (operation.equals("addLast"))
                head = addLast(head, name);
        }

        display(head);
        sc.close();
    }
}

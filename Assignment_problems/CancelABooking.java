
import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class CancelABooking {

    static Node removeFirst(Node head, String booking) {

        if (head == null)
            return head;

        // If booking is at the head
        if (head.data.equals(booking)) {
            return head.next;
        }

        Node temp = head;

        // Search for booking
        while (temp.next != null &&
               !temp.next.data.equals(booking)) {
            temp = temp.next;
        }

        // If booking is found
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println(booking + " not found");
        }

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
        Node tail = null;

        // Create linked list
        for (int i = 0; i < n; i++) {
            String booking = sc.next();

            Node newNode = new Node(booking);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String cancel = sc.next();

        head = removeFirst(head, cancel);

        display(head);

        sc.close();
    }
}

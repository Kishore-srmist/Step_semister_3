
import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class PlateStack {
    Node top = null;
    int size = 0;

    void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("push " + plate +
                " -> top " + top.data + ", size " + size);
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return;
        }

        String plate = top.data;
        top = top.next;
        size--;

        System.out.println("pop -> " + plate + ", size " + size);
    }

    void peek() {
        if (isEmpty())
            System.out.println("peek -> stack is empty");
        else
            System.out.println("peek -> " + top.data);
    }

    boolean isEmpty() {
        return top == null;
    }

    void checkEmpty() {
        System.out.println("isEmpty -> " + isEmpty());
    }
}

public class PlateStackOnAChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlateStack stack = new PlateStack();

        String input = sc.nextLine();
        String[] operations = input.split(",");

        for (String operation : operations) {
            operation = operation.trim();

            if (operation.startsWith("push")) {
                String plate = operation.substring(
                        operation.indexOf('(') + 1,
                        operation.indexOf(')')
                );

                stack.push(plate);
            }
            else if (operation.equals("pop()")) {
                stack.pop();
            }
            else if (operation.equals("peek()")) {
                stack.peek();
            }
            else if (operation.equals("isEmpty()")) {
                stack.checkEmpty();
            }
        }

        sc.close();
    }
}

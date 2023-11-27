class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private Node head;

    // Add a node to the end of the circular linked list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point back to itself to create a circular list
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    // Display the circular linked list
    public void display() {
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Reverse the circular linked list
    public void reverse() {
        if (head == null || head.next == head) {
            return; // List is empty or has only one element, no need to reverse
        }
    
        Node current = head;
        Node prev = null;
        Node nextNode = null;
    
        do {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        } while (current != head);
    
        // Update circular connections to maintain the circular structure
        head.next = prev;
        head = prev; // Update the head to the new last element
    }
    

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Append elements to the circular linked list
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Original Circular Linked List:");
        list.display();

        list.reverse();

        System.out.println("Reversed Circular Linked List:");
        list.display();
    }
}

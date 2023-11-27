class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Append an element to the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Prepend an element to the beginning of the list
    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Delete an element from the list
    public void delete(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    // Display the elements of the list from head to tail
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Display the elements of the list from tail to head
    public void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();

        // Append elements to the list
        myList.append(1);
        myList.append(2);
        myList.append(3);

        // Prepend an element to the list
        myList.prepend(0);

        // Display the list from head to tail
        myList.displayForward(); // Output: 0 <-> 1 <-> 2 <-> 3 <-> null

        // Display the list from tail to head
        myList.displayBackward(); // Output: 3 <-> 2 <-> 1 <-> 0 <-> null

        // Delete an element from the list
        myList.delete(2);

        // Display the updated list
        myList.displayForward(); // Output: 0 <-> 1 <-> 3 <-> null
    }
}

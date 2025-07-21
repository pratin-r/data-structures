class Node {
    int val;
    Node next;

    public Node() {
    };

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    public void insertFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insert(int val, int index) {
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 2; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        size++;
    }

    public Node getReferenceOfNode(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int deleteFirst() {
        int deletedVal = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        System.out.println("Deleted value: " + deletedVal);
        return deletedVal;
    }

    public int deleteLast() {
        Node temp = new Node();
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        tail = temp;
        int deletedVal = temp.next.val;
        temp.next = null;
        size--;
        System.out.println("Deleted Value: " + deletedVal);
        return deletedVal;
    }

    public int deleteInParticular(int index) {
        if (index == 1) {
            deleteFirst();
            return 0;
        } else if (index == size) {
            deleteLast();
            return 0;
        }
        Node temp = getReferenceOfNode(index - 1);
        int deletedVal = temp.next.val;
        temp.next = temp.next.next;
        System.out.println("Deleted Value: " + deletedVal);
        return deletedVal;
    }

    public void displayList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        return;
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertFirst(2);
        l1.insertFirst(1);
        l1.displayList();
    }
}

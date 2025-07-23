package datastructure.LinkedListCode.DoublyLinkedList;

class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public void insertFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertLast(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            insertFirst(val);
            return;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Node getReferenceOfNode(int index) {
        Node desiredNode = head;
        for (int i = 0; i < index - 1; i++) {
            desiredNode = desiredNode.next;
        }
        return desiredNode;
    }

    public void insertMiddle(int val, int index) {
        Node newNode = new Node(val);
        if (index == 1) {
            insertFirst(val);
            return;
        } else if (index - 1 == size) {
            insertLast(val);
            return;
        } else {
            Node currPointer = getReferenceOfNode(index);
            newNode.next = currPointer;
            newNode.prev = currPointer.prev;
            Node prevPointer = currPointer.prev;
            currPointer.prev = newNode;
            prevPointer.next = newNode;
            size++;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size -= 1;
            return;
        } else {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
    }

    public void deleteLast() {
        if (tail == null) {
            System.out.println("List Empty");
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size -= 1;
            return;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
    }

    public void deleteMiddle(int index) {
        if (tail == null) {
            System.out.println("List Empty");
            return;
        } else if (index == 1) {
            head = null;
            tail = null;
            size--;
            return;
        } else {
            Node pointer = getReferenceOfNode(index);
            Node tempHolder = pointer.prev;
            pointer.prev = pointer.next;
            tempHolder.next = pointer.next;
            return;
        }
    }

    public void displayLinkedList() {
        Node pointer = head;
        while (pointer != null) {
            if (pointer.next == null) {
                System.out.println(pointer.val);
                pointer = pointer.next;
                break;
            }
            System.out.print(pointer.val + " -> ");
            pointer = pointer.next;
        }
    }
}

public class DoublyLL {
    public static void main(String[] args) {
        DoublyLinkedList obj1 = new DoublyLinkedList();
        obj1.insertFirst(2);
        obj1.insertFirst(1);
        obj1.insertLast(4);
        obj1.insertMiddle(3, 3);
        // obj1.deleteLast();
        obj1.deleteMiddle(2);
        obj1.displayLinkedList();
    }
}

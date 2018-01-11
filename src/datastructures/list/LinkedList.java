package datastructures.list;

/**
 * Created by peo_rboliveira on 08/02/16.
 */
public class LinkedList<T> {

    private Node head;
    private int counter = 0;

    class Node {
        private T element;
        private Node next;
    }

    public int size() {
        return counter;
    }

    public LinkedList<T> add(T element) {
        Node temp = new Node();
        temp.element = element;

        if (head == null) {
            head = temp;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = temp;
        }

        counter++;

        return this;
    }

    public T get(int index) {
        Node current = head;
        T element = null;
        for (int i = 0; i < index; i++) {
            element = current.element;
            current = current.next;
        }

        return element;
    }

    public boolean remove(int index) {
        Node prev = null;
        Node curr = head;

        if (index == 0) {
            if (counter > 1) {
                head = head.next;
            } else {
                head = null;
            }
            counter--;
            return true;
        }

        for (int i = 1; i <= index; i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        counter--;
        return true;
    }

    public boolean isPalindrome() {
        if (head == null || counter == 1) return true;

        Node current = head;
        Node last = new Node();
        last.element = head.element;
        last.next = null;

        while (current.next != null) {
            Node temp = new Node();
            temp.element = current.next.element;
            temp.next = last;

            last = temp;
            current = current.next;
        }

        Node head2 = last;
        current = head;

        while (current.next != null) {
            if (current.next.element != head2.next.element) {
                return false;
            }
            current = current.next;
            head2 = head2.next;
        }
        return true;
    }

    public String toString() {
        Node current = head;
        StringBuilder builder = new StringBuilder();
        while(current != null) {
            builder.append(current.element).append(", ");
            current = current.next;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.add(1).add(2).add(8).add(10);

        linked.remove(2);
        System.out.println(linked.get(3));

        for (int i = 0; i <= 0; i++) {
            System.out.println(linked);
        }
    }
}

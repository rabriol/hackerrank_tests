package datastructures.queue;

/**
 * Created by peo_rboliveira on 07/02/16.
 */
public class QueueLinkedList<T> {

    private Node first, last;
    private int size = 0;

    private class Node {
        private T e;
        private Node next;
    }

    public QueueLinkedList(){}

    public QueueLinkedList<T> enqueue(T e) {

        Node current = last;

        last = new Node();
        last.e = e;

        if (size++ == 0) {
            first = last;
        } else {
            current.next = last;
        }

        return this;
    }

    public T dequeue() {
        T element = first.e;
        first = first.next;

        if (size-- == 0) {
            return null;
        }

        return element;
    }

    public String toString() {

        Node tmp = first;
        StringBuilder st = new StringBuilder();
        while (tmp != null) {
            st.append(tmp.e).append(", ");
            tmp = tmp.next;
        }

        return st.toString();
    }
}

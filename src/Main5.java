/**
 * Created by peo_rboliveira on 07/02/16.
 */
public class Main5 {

    public static void main(String[] args) {
        QueueLinkedList<Integer> t = new QueueLinkedList<>();

        t.enqueue(2);
        t.enqueue(12);
        t.enqueue(23);
        t.enqueue(34);
        t.dequeue();

        System.out.println(t);
    }
}

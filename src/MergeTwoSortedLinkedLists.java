/**
 * Created by peo_rboliveira on 29/12/16.
 */
public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        Node n1 = new Node(15, null);
        Node n2 = new Node(12, null);
        System.out.println(MergeLists(n1, n2));
    }

    public static Node MergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if (headA == null && headB == null) {
            return null;
        } else if (headA == null) {
            headB.next = MergeLists(headA, headB.next);
            return headB;
        } else if (headB == null) {
            headA.next = MergeLists(headA.next, headB);
            return headA;
        } else if (headB.data < headA.data) {
            headB.next = MergeLists(headA, headB.next);
            return headB;
        } else {
            headA.next = MergeLists(headA.next, headB);
            return headA;
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("data=").append(data);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}



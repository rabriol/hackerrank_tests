/**
 * Created by peo_rboliveira on 28/12/16.
 */
public class CompareTwoLinkedLists {
    public static void main(String[] args) {

    }

    public static int CompareLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if (headA == null && headB == null) {
            return 1;
        } else if (headA == null || headB == null) {
            return 0;
        } else {
            if (headA.data == headB.data) {
                return CompareLists(headA.next, headB.next);
            } else {
                return 0;
            }
        }

    }

    /*
      Compare two linked lists A and B
      Return 1 if they are identical and 0 if they are not.
      Node is defined as
    */
    class Node {
        int data;
        Node next;
    }
}
/**
 * Created by peo_rboliveira on 08/02/16.
 */
public class PalindromeDetectorV2 {

    public static void main(String[] args) {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("A").add("R").add("A").add("R").add("A");
        System.out.println(linked.isPalindrome());
    }
}

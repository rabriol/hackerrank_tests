/**
 * Created by peo_rboliveira on 19/09/16.
 */
public class BTS {

    public static void main(String[] args) {

        Node one = new Node(1, null, null);

        Node four = new Node(4, null, null);
        Node seven = new Node(7, null, null);
        Node six = new Node(6, four, seven);

        Node three = new Node(3, one, six);

        Node thirteen = new Node(13, null, null);
        Node fourteen = new Node(14, thirteen, null);
        Node ten = new Node(10, null, fourteen);
        Node eigth = new Node(8, three, ten);

        System.out.println(checkBTS(eigth));
    }

    public static boolean checkBTS(Node node) {
        return checkSubBTS(node.getValue(), node.getValue(), node);
    }

    public static boolean checkSubBTS(int min, int max, Node node) {
        if (node == null) return true;

        if (min > node.getValue() || node.getValue() > max) return false;
        return checkSubBTS(node.getValue(), max, node.getLeft()) && checkSubBTS(min, node.getValue(), node.getRight());
    }

}

class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(int value, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}

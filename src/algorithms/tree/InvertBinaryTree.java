package algorithms.tree;

public class InvertBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(4,
                new Node(2, new Node(1, null, null), new Node(3, null, null)),
                new Node(7, new Node(6, null, null), new Node(9, null, null)));
        Node result = invertBT(node);
        System.out.println(result);
    }

    private static Node invertBT(Node node) {
        if (node == null) return null;

        return new Node(node.getValue(), invertBT(node.getRight()), invertBT(node.getLeft()));
    }
}

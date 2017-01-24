package algorithms.tree;

import algorithms.tree.Node;

/**
 * Created by peo_rboliveira on 27/09/16.
 */
public class BTSInOrder {

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

        BTSInOrder(eigth);
    }

    public static void BTSInOrder(Node node) {
        if (node == null) return;

        BTSInOrder(node.getLeft());
        System.out.println(node.getValue());
        BTSInOrder(node.getRight());
    }
}

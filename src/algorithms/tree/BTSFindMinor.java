package algorithms.tree;

/**
 * Created by peo_rboliveira on 27/09/16.
 */
public class BTSFindMinor {

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

        System.out.println(BTSfindMinor(eigth, 1, false));
    }

    public static Integer BTSfindMinor(Node node, int value, boolean hasFound) {
        if (node == null) {
            return null;
        } else {
            BTSfindMinor(node.getLeft(), value, hasFound);
            if (hasFound) {
                System.out.println("Menor valor = " + node.getValue());
                return node.getValue();
            }

            if (value == node.getValue()) {
                System.out.println("Valor encontrado = " + node.getValue());
                hasFound = true;
            }
            BTSfindMinor(node.getRight(), value, hasFound);
        }
        return null;
    }
}

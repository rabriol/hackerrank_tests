/**
 * Created by brito on 9/25/16.
 */
public class BTSSecondMinor {

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

        System.out.println(BTSSM(eigth, 4, false));
    }

    //in-order
    public static int BTSSM(Node node, int value, boolean hasFound) {
        if (node == null) {
            return -1;
        }else if (hasFound) {
            int left = BTSSM(node.getLeft(), value, hasFound);
            if (left != -1) {
                return left;
            }
            return node.getValue();
        } else {
            int left = BTSSM(node.getLeft(), value, hasFound);
            if (left == value) {
                return node.getValue();
            } else if(left != -1) {
                return left;
            }

            if (node.getValue() == value) {
                hasFound = true;
                if (node.getRight() == null && node.getLeft() == null) return node.getValue();
            }

            int right = BTSSM(node.getRight(), value, hasFound);
            if (right != -1) {
                return right;
            }
            return -1;
        }
    }
}
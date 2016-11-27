/**
 * Created by brito on 9/18/16.
 */
public class BinarySearchTree {

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
            return checkSubBTS(Integer.MIN_VALUE, Integer.MAX_VALUE, node);
        }

        public static boolean checkSubBTS(int min, int max, Node node) {
            if (node == null) return true;
            if (max < node.getValue() || min > node.getValue()) return false;
            return checkSubBTS(min, node.getValue(), node.getLeft()) && checkSubBTS(node.getValue(), max, node.getRight());
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


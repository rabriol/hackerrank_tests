/**
 * Created by brito on 9/18/16.
 */
public class BinarySearchTree {

        public static void main(String[] args) {

            Node1 one = new Node1(1, null, null);

            Node1 four = new Node1(4, null, null);
            Node1 seven = new Node1(7, null, null);
            Node1 six = new Node1(6, four, seven);

            Node1 three = new Node1(3, one, six);

            Node1 thirteen = new Node1(13, null, null);
            Node1 fourteen = new Node1(14, thirteen, null);
            Node1 ten = new Node1(10, null, fourteen);
            Node1 eigth = new Node1(8, three, ten);

            System.out.println(checkBTS(eigth));
        }

        public static boolean checkBTS(Node1 Node1) {
            return checkSubBTS(Integer.MIN_VALUE, Integer.MAX_VALUE, Node1);
        }

        public static boolean checkSubBTS(int min, int max, Node1 Node1) {
            if (Node1 == null) return true;
            if (max < Node1.getValue() || min > Node1.getValue()) return false;
            return checkSubBTS(min, Node1.getValue(), Node1.getLeft()) && checkSubBTS(Node1.getValue(), max, Node1.getRight());
        }

    }

    class Node1 {
        private Node1 left;
        private Node1 right;
        private int value;

        public Node1(int value, Node1 left, Node1 right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node1 getLeft() {
            return left;
        }

        public Node1 getRight() {
            return right;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node1{");
            sb.append("value=").append(value);
            sb.append('}');
            return sb.toString();
        }
    }


package others;

import java.util.Objects;

/**
 * Created by peo_rboliveira on 26/01/17.
 */
public class TestHashCode {

    public static void main(String[] args) {
        System.out.println("B".hashCode());
        System.out.println("B".hashCode());

        Node n1 = new Node("ab", null);
        Node n2 = new Node("ab", null);

        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());
    }
}

class Node {

    String value;
    Node node;

    public Node(String value, Node node) {
        this.value = value;
        this.node = node;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node1 = (Node) o;
        return value == node1.value &&
                Objects.equals(node, node1.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, node);
    }
}

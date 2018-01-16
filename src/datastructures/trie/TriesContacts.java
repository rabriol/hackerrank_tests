package datastructures.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rabriol on 7/23/17.
 */
public class TriesContacts {

    private Node root = new Node();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        TriesContacts t = new TriesContacts();

        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if ("add".equalsIgnoreCase(op)) {
                t.add(contact);
            } else {
                System.out.println(t.find(contact));
            }
        }
    }

    public void add(String word) {
        Node aux = root;
        for (int i=0; i<word.length(); i++) {
            if (!aux.getChildren().containsKey(word.charAt(i))) {
                aux.getChildren().put(word.charAt(i), new Node());
            }

            aux = aux.getChildren().get(word.charAt(i));
            aux.setCountElements(aux.getCountElements()+1);
        }

    }

    public int find(String word) {
        Node aux = root;
        for (int i=0; i<word.length(); i++) {
            if (!aux.getChildren().containsKey(word.charAt(i))) {
                return 0;
            }

            if (i == word.length()-1) {
                return aux.getChildren().get(word.charAt(i)).getCountElements();
            }

            aux = aux.getChildren().get(word.charAt(i));
        }
        return 0;
    }
}

class Node {
    private int countElements = 0;
    private Map<Character, Node> children = new HashMap<>();

    public int getCountElements() {
        return countElements;
    }

    public void setCountElements(int countElements) {
        this.countElements = countElements;
    }

    public Map<Character, Node> getChildren() {
        return children;
    }
}

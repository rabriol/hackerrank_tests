import java.util.Scanner;

/**
 * Created by peo_rboliveira on 16/10/16.
 */
public class BracketDetector {

    public static boolean isBalanced(String expression) {
        if (expression == null) return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < expression.length(); i++) {
            if ('{' == expression.charAt(i) || '[' == expression.charAt(i) || '(' == expression.charAt(i)) {
                stack.push(expression.charAt(i));
            } else if ('}' == expression.charAt(i)) {
                if (stack.size == 0) return false;
                Character bracket = stack.pop();
                if ('{' != bracket) return false;
            } else if (']' == expression.charAt(i)) {
                if (stack.size == 0) return false;
                Character bracket = stack.pop();
                if ('[' != bracket) return false;
            } else if (')' == expression.charAt(i)) {
                if (stack.size == 0) return false;
                Character bracket = stack.pop();
                if ('(' != bracket) return false;
            }
        }

        return stack.size == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if(answer)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

class Stack<T> {
    public class Node {
        Node next;
        T data;
        public Node(T data) {
            this.data = data;
        }
    }

    Node top;
    int size = 0;

    public T peek() {
        if (top == null) return null;
        return top.data;
    }

    public void push(T data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (top == null) return null;
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public int size() {
        return size;
    }
}

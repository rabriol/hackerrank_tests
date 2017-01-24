package techniquesconcepts;

import java.util.LinkedList;

/**
 * Created by peo_rboliveira on 07/02/16.
 */
public class ParseExpression {

    //Code a math expression parser (subtraction and   multiplication), any language, consider parentesis.

    public static void main(String[] args) throws Exception {
        System.out.println(parseExpression("9*9 / (1*6) * (3*2)"));
    }

    private static Double parseExpression(String s) throws Exception {
        LinkedList<String> expression = new LinkedList<>();

        boolean operatorFound = false;
        boolean parentesisFound = false;

        for (Character element : s.toCharArray()) {
            if (Character.isWhitespace(element)) {
                continue;
            }

            if (operatorFound && Character.isDigit(element) && !parentesisFound) {
                if (expression.getLast().equals("*")) {
                    expression.removeLast();

                    expression.add(multiply(expression.removeLast(), element.toString()));
                } else if (expression.getLast().equals("/")) {
                    expression.removeLast();

                    expression.add(subtract(expression.removeLast(), element.toString()));
                }
                operatorFound = false;
                continue;
            }

            if (Character.isDigit(element)) {
                expression.add(element.toString());
            }

            if (element.equals(Character.valueOf('('))) {
                parentesisFound = true;
                expression.add(element.toString());
            }

            if (element.equals(Character.valueOf('*')) || element.equals(Character.valueOf('/'))) {
                operatorFound = true;
                expression.add(element.toString());
            }

            if (element.equals(Character.valueOf(')'))) {
                evalParentesisExpression(expression);
                parentesisFound = false;
            }
        }

        if (expression != null && expression.size() > 1) {
            String auxElement = expression.removeLast();
            if (expression.getLast().equals("*")) {
                expression.removeLast();

                expression.add(multiply(expression.removeLast(), auxElement));
            } else if (expression.getLast().equals("/")) {
                expression.removeLast();

                expression.add(subtract(expression.removeLast(), auxElement));
            }
        }

        return new Double(expression.getFirst());
    }

    private static void evalParentesisExpression(LinkedList<String> expression) {
        String auxElement = expression.removeLast();

        for(;;) {
            if (expression.getLast().equals("(")) {
                expression.removeLast();
                expression.add(auxElement);
                break;
            } else if (expression.getLast().equals("*")) {
                expression.removeLast();
                auxElement = multiply(auxElement, expression.removeLast());
            } else if (expression.getLast().equals("/")) {
                expression.removeLast();
                auxElement = subtract(auxElement, expression.removeLast());
            }
        }
    }

    private static String multiply(String a1, String a2) {
        Double result = Double.valueOf(a1) * Double.valueOf(a2);

        return result.toString();
    }

    private static String subtract(String a1, String a2) {
        Double result = Double.valueOf(a1) / Double.valueOf(a2);

        return result.toString();
    }
}

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peo_rboliveira on 08/02/16.
 */
public class ConvertDigitToWord {

    static Map<Integer, String> words = null;

    static {
        words = new HashMap<>();
        words.put(1, "one");
        words.put(2, "two");
        words.put(3, "three");
        words.put(4, "four");
        words.put(5, "five");
        words.put(6, "six");
        words.put(8, "eigth");
        words.put(9, "nine");
        words.put(10, "ten");
        words.put(11, "eleven");
        words.put(13, "thirteen");
        words.put(14, "fourteen");
        words.put(15, "fifteen");
        words.put(16, "sixteen");
        words.put(17, "seventeen");
        words.put(18, "eigthteen");
        words.put(19, "nineteen");
        words.put(20, "twenty");
        words.put(30, "thirty");
        words.put(40, "fourty");
        words.put(50, "fifty");
        words.put(60, "sixty");
        words.put(70, "seventy");
        words.put(80, "eighty");
        words.put(90, "ninety");
    }

    public static void main(String[] args) throws OperationNotSupportedException {
        System.out.println(toText("20,000,000"));
        System.out.println(toText("52"));
        System.out.println(toText("554"));

        System.out.println(toText("22,052,000"));
        System.out.println(toText("22,052,120"));
        System.out.println(toText("52,000"));
        System.out.println(toText("801"));
    }

    private static String toText(String s) throws OperationNotSupportedException {
        Integer number = Integer.valueOf(s.replaceAll(",", ""));

        if (number == 0) return "";

        if (number > 999_999_999) {
            throw new OperationNotSupportedException("");

        } else if (number >= 1_000_000) {
            String[] houses = s.split(",");
            return toText(houses[0]) + " million " + toText(houses[1] + "," + houses[2]);

        } else if (number >= 1_000) {
            String[] houses = s.split(",");
            return toText(houses[0]) + " thousand " + toText(houses[1]);

        } else if (number >= 100) {
            return toText(s.substring(0, 1)) + " hundred " + toText(s.substring(1,3));

        } else if (number >= 20) {
            String noZero = Integer.valueOf(s).toString();
            Integer aux = Integer.valueOf(noZero.substring(1));
            if (aux != 0) {
                return words.get(Integer.valueOf(noZero.substring(0,1) + "0")) + "-" + toText(noZero.substring(1));
            } else {
                return words.get(Integer.valueOf(noZero.substring(0,1) + "0"));
            }

        } else {
            return words.get(number);
        }
    }
}

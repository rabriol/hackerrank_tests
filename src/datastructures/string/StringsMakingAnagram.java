package datastructures.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class StringsMakingAnagram {
    public static int numberNeeded(String first, String second) {
        Map<Character, AtomicInteger> letters = new HashMap<>();
        int equalCounter = 0;

        for (int i = 0; i < first.length() ; i++) {
            if (letters.get(first.charAt(i)) == null) {
                letters.put(first.charAt(i), new AtomicInteger());
            }
            letters.get(first.charAt(i)).getAndIncrement();
        }

        for (int i = 0; i < second.length() ; i++) {
            if (letters.get(second.charAt(i)) != null) {
                equalCounter++;
                letters.get(second.charAt(i)).getAndDecrement();
                if (letters.get(second.charAt(i)).get() == 0) {
                    letters.remove(second.charAt(i));
                }
            }
        }

        return (first.length() + second.length()) - (equalCounter*2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();
        System.out.println(numberNeeded(first, second));
    }
}

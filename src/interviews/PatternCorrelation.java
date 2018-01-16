package interviews;

import java.util.*;

/*
EPAM Barclays

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "abc", str = "dog dog dog" should return false
*/


class PatternCorrelation {
    public static void main (String[] args) {
        System.out.println(solve("abba", "dog cat cat dog")); // true
        System.out.println(solve("abba", "dog cat cat fish")); // false
        System.out.println(solve("abc", "dog dog dog")); // false
        System.out.println(solve("abch", "dog rabbit bird bird")); // false
    }


    public static boolean solve(String pattern, String str) {
        String[] words = str.split(" ");

        Map<Character, String> letters = new HashMap<>();
        Set<String> wordInserted = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (letters.containsKey(pattern.charAt(i)) &&
                    !letters.get(pattern.charAt(i)).equals( words[i])) {
                return false;
            } else {
                if (wordInserted.contains(words[i]) && !letters.containsKey(pattern.charAt(i))) {
                    return false;
                }

                letters.put(pattern.charAt(i), words[i]);
                wordInserted.add(words[i]);
            }

        }

        return true;

    }
}

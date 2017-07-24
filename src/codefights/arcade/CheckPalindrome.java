package codefights.arcade;

/**
 * Created by peo_rboliveira on 20/04/17.
 */
public class CheckPalindrome {
    /**
     * Given the string, check if it is a palindrome.

       Example

       For inputString = "aabaa", the output should be
       checkPalindrome(inputString) = true;

       For inputString = "abac", the output should be
       checkPalindrome(inputString) = false;

       For inputString = "a", the output should be
       checkPalindrome(inputString) = true.
     */

    public static void main(String[] args) {
        System.out.println(checkPalidrome("TASET"));
    }

    public static boolean checkPalidrome(String word) {
        int last = word.length()-1;

        for (int first = 0; first < word.length() / 2; first++) {
            if (word.charAt(first) != word.charAt(last)) {
                return false;
            }
            last--;
        }

        return true;
    }
}

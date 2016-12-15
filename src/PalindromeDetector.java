/**
 * Created by peo_rboliveira on 07/02/16.
 */
public class PalindromeDetector {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Animallootsfoliateddetailofstoollamina"));
    }

    private static boolean isPalindrome(String word) {
        if (word == null || word.length() == 1) return true;

        int start_index = 0;
        int middle_index = word.length() / 2;
        String[] letters =  word.split("");
        int end_index = word.length()-1;

        for (; start_index < middle_index; start_index++) {
            if (!letters[start_index].equalsIgnoreCase(letters[end_index--])) {
                return false;
            }
        }

        return true;
    }
}

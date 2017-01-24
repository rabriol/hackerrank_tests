package techniquesconcepts;

/**
 * Created by peo_rboliveira on 23/03/16.
 */
public class MinimumRemoval {

    public static void main(String[] args) {
        System.out.println(minimumRemovals("A", "A"));
    }

    public static int minimumRemovals(String s1, String s2) {
        if (s1.length() == s2.length()) {
            if (s1.equals(s2)) {
                return 0;
            }
        }

        int lenght1 = s1.length();
        int lenght2 = s2.length();

        int index1 = 0;
        int index2 = 0;

        int minimum = 0;

        while(true) {
            if (index1 == lenght1 && index2 == lenght2) {
                return minimum != 0 ? minimum : -1;
            }

            if (index1 == lenght1 && index2 != lenght2) {
                if (s2.charAt(index2-1) == s2.charAt(index2)) {
                    index2++;
                    minimum++;
                    continue;
                }
            }

            if (index2 == lenght2 && index1 != lenght1) {
                if (s1.charAt(index1-1) == s1.charAt(index1)) {
                    index1++;
                    minimum++;
                    continue;
                }
            }

            if (s1.charAt(index1) == s2.charAt(index2)) {
                index1++;
                index2++;
                continue;
            }

            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (s1.charAt(index1-1) == s1.charAt(index1)) {
                    index1++;
                    minimum++;
                    continue;
                }
                if (s2.charAt(index2-1) == s2.charAt(index2)) {
                    index2++;
                    minimum++;
                    continue;
                }
            }
            index1++;
            index2++;
        }
    }
}

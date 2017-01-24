package datastructures.string;

/**
 * Created by peo_rboliveira on 08/02/16.
 */
public class UpperCase {

    public static void main(String[] args) {
        System.out.println(upper(new Integer[]{0,2,5}, "i ém like stackoverflow-python"));
    }

    private static String upper(Integer[] indexes, String word) {
        StringBuilder st = new StringBuilder(word);

        for (Integer index : indexes) {
            char c = st.charAt(index);
            char newChar = Character.toUpperCase(c);
            st.setCharAt(index, newChar);
        }

        return st.toString();
    }

    public static String titleCase(String str){
        String[] strar = str.split(" ");
        StringBuilder strbldr = new StringBuilder();

        for (String a : strar) {
            char [] charArray = a.toCharArray();
            charArray[0] = (char)(charArray[0] - ('a' - 'A'));
            strbldr.append(charArray);
            strbldr.append(' ');
        }

        return strbldr.toString().trim();
    }
}

/**
 * Created by peo_rboliveira on 09/02/16.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] v = rotate(new int[]{1,2,3,4,5,6,7}, 2);
        System.out.println(v);
    }

    private static int[] rotate(int[] a, int n) {

        int[] copy = a.clone();
        int counter = n;
        for (int i = 0; i  < a.length; i++) {
            if (n+i < a.length) {
                copy[i] = a[n+i];

                if (counter > 0) {
                    copy[(a.length) - counter--] = a[i];
                }
            }
        }

        return copy;
    }
}

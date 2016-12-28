/**
 * Created by peo_rboliveira on 15/12/16.
 */
public class BitManipulation {

    public static int getUnique(int[] numbers) {
        int x = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            x = x ^ numbers[i];
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(getUnique(new int[]{1,2,1,3,3,6}));
    }
}

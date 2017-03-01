package others;

import java.util.Arrays;

/**
 * Created by peo_rboliveira on 26/01/17.
 */
public class SortAnArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(order(new int[]{5,2,1,3,4,8})));
    }

    public static int[] order(int[] numbers) {
        for (int i = 0 ; i < numbers.length; i++) {
            for (int j = 0 ; j < numbers.length-1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int number = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = number;
                }
            }
        }

        return numbers;
    }
}

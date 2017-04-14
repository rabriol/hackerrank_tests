package others;

import java.util.Arrays;

/**
 * Created by peo_rboliveira on 31/03/17.
 */
public class FindUniqueRemoval {

    // [1, 2, 3, 99, 5, 6]
    public static void main(String[] args) {
        System.out.println(checkUniqueRemoval(new int[]{10, 1, 2, 3}));
        System.out.println(checkUniqueRemoval(new int[]{1, 2, 3, 99, 5, 6}));
        System.out.println(checkUniqueRemoval(new int[]{1, 2, 8, 10, 5, 6, 7}));
        System.out.println(checkUniqueRemoval(new int[]{7, 5, 6, 1}));
        System.out.println(checkUniqueRemoval(new int[]{1,2,1,2}));
    }

    public static boolean checkUniqueRemoval(int[] numbers) {
        if (numbers == null) return false;
        if (numbers.length <= 2) return true;

        int prev = numbers[0];
        int suspect = numbers[1];

        int removals = 0;

        for (int i = 1; i < numbers.length ; i++) {
            // for the scenarios where the biggest element is in the beginning
            if (i == 1) {
                if (prev > suspect && prev > numbers[i++]) {
                    removals++;
                    prev = suspect;
                    suspect = numbers[i];
                }
            // for the scenarios where the biggest element is in the middle
            } else if (prev >= suspect || suspect >= numbers[i]) {
                removals++;
                suspect = numbers[i];
            // for the scenarios where there is no removal
            } else {
                prev = suspect;
                suspect = numbers[i];
            }

            if (removals > 1) return false;
        }

        return removals == 1;
    }
}

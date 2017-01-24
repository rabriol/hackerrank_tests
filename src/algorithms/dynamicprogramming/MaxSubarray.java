package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * Created by peo_rboliveira on 09/02/16.
 */
public class MaxSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubarray(new int[]{-1, 2, 5, -1, 3, -2, 1}));
        maxSubarrayIndex(new int[]{-1, 2, 5, -1, 3, -2, 1});

        System.out.println(Arrays.equals(new int[]{1,0,0,1,0,0,1,0,0}, new int[]{1,0,0,1,0,0,1,0,0}));

        System.out.println("RESULTADO: " + (2 & (10-1)));
    }

    private static int maxSubarray(int[] ints) {
        int maxSoFar = 0;
        int maxEndHere = 0;

        for (int n : ints) {
            maxEndHere = max(0, maxEndHere + n);
            maxSoFar = max(maxSoFar, maxEndHere);
        }

        return maxSoFar;
    }

    private static int max(int a1, int a2) {
        return a1 > a2 ? a1 : a2;
    }

    private static void maxSubarrayIndex(int[] ints) {
        int bestValueNow = 0;
        int bestValue = 0;

        int bestIndexStart = -1;
        int bestIndexEnd = -1;
        int bestIndexNow = -1;

        for (int i = 0; i < ints.length; i++) {
            int value = bestValueNow + ints[i];
            if (value > 0) {
                if (bestValueNow == 0) {
                    bestIndexNow = i;
                }
                bestValueNow = value;
            } else {
                bestValueNow = 0;
            }

            if (bestValueNow > bestValue) {
                bestIndexEnd = i;
                bestIndexStart = bestIndexNow;
                bestValue = bestValueNow;
            }
        }

        System.out.println("Melhor subarray é de: " + bestIndexStart + " e " + bestIndexEnd);
    }
}

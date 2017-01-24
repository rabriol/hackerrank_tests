package algorithms.sort;

import java.util.Scanner;

/**
 * Created by peo_rboliveira on 15/12/16.
 */
public class SortingBubbleSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        bubbleSort(a);
    }

    public static void bubbleSort(int[] numbers) {
        int n = numbers.length;
        int totalNumberOfSwaps = 0;

        for (int i = 0; i < n; i++) {
            int numberOfSwaps = 0;

            for (int j = 0; j < n-1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int number = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = number;
                    numberOfSwaps++;
                }
            }

            totalNumberOfSwaps += numberOfSwaps;

            if (numberOfSwaps == 0) {
                break;
            }
        }

        System.out.println("Array is sorted in " + totalNumberOfSwaps +" swaps.");
        System.out.println("First Element: " + numbers[0]);
        System.out.println("Last Element: " + numbers[numbers.length-1]);
    }

}

/**
 * Created by brito on 10/1/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        int n = 5;
        int k = 5;
        int a[] = new int[]{1,2,3,4,5};

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();
    }

    public static int[] arrayLeftRotation(int[]a, int n, int k) {
        int[] result = new int[n];

        for (int i = 0, j = k; j < n; j++,i++) {
            result[i] = a[j];
        }
        for (int i = 0, j = n-k; i < k; j++,i++) {
            result[j] = a[i];
        }

        return result;
    }
}


package others;

/**
 * Created by peo_rboliveira on 06/02/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindingTheRunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            if (a_i == 0) {
                System.out.println(String.format("%.1f", new Integer(a[a_i]).floatValue()));
            } else if (a_i % 2 == 1) {
                int index = a_i / 2;

                float x = Float.valueOf(new Integer(a[index]).floatValue());
                float y = Float.valueOf(new Integer(a[index+1]).floatValue());

                System.out.println(String.format("%.1f", (x+y)/2));
            } else {
                int index = a_i / 2;
                System.out.println(String.format("%.1f", new Integer(a[index]).floatValue()));
            }
        }
    }
}


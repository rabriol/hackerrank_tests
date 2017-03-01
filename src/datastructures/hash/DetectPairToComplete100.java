package datastructures.hash;

import java.util.*;

/**
 * Created by rabriol on 1/25/17.
 * Test made for EPAM interview process
 */
public class DetectPairToComplete100 {
    public static void main(String[] args) {
        System.out.println(writePairs(new int[]{1,45,67,23,55, 99}, 100));
    }

    public static List<int[]> writePairs(int[] arr, int sum) {
        Set<Integer> numbers = new HashSet<>();

        List<int[]> l = new ArrayList<>();

        for (int a : arr) {
            if (numbers.contains(sum-a)) {
                int[] pair = new int[2];
                pair[0] = a;
                pair[1] = sum-a;
                l.add(pair);
            } else {
                numbers.add(a);
            }
        }

        return l;
    }

    /**
     * [1/27/17, 10:00:06 AM] Pavlo Ieromin: public void writePairs(int[] arr, int sum) {

     )
     [1/27/17, 10:00:27 AM] Pavlo Ieromin: {1,45,67,23,55, 99} , 100
     [1/27/17, 10:01:04 AM] Pavlo Ieromin: 1+ 99
     45 + 55
     */
}

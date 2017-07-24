package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by peo_rboliveira on 24/04/17.
 */
public class FindKComplement {

    public static void main(String[] args) {
        System.out.println(findComplement(new Integer[]{2, 3, 1, 3, 2, 6, -1}, 6));
        System.out.println(findComplement(new Integer[]{7, 1, 5, 6, 9, 3, 11, -1}, 10));
    }

    public static List<List<Integer>> findComplement(Integer[] elements, Integer k) {
        Set<Integer> keys = new HashSet<>();
        List<List<Integer>> pairs = new ArrayList<>();

        for (Integer element : elements) {
            if (keys.contains(k - element)) {
                pairs.add(Arrays.asList(element, k - element));
            }
            keys.add(element);
        }

        return pairs;
    }
}

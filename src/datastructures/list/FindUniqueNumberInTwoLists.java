package datastructures.list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by peo_rboliveira on 26/01/17.
 */
public class FindUniqueNumberInTwoLists {

    public static void main(String[] args) throws Exception {
        System.out.println(findUnique(Arrays.asList(1,2,3,4), Arrays.asList(1,2,3,4,5)));
    }

    public static int findUnique(List<Integer> firstList, List<Integer> secondList) throws Exception {
        Set<Integer> uniques = new HashSet<>();

        for (Integer first : firstList) {
            uniques.add(first);
        }

        for (Integer second : secondList) {
            if (!uniques.add(second)) {
                uniques.remove(second);
            }
        }

        Optional<Integer> unique = uniques.stream().findFirst();

        if (unique.isPresent()) return unique.get();

        throw new Exception("Unique number not found");
    }
}

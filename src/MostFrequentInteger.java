/**
 * Created by peo_rboliveira on 07/02/16.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MostFrequentInteger {
    public static int findMostFrequent(List<Integer> integers) {
        Map<Integer, Integer> intToCountMap = new HashMap<Integer, Integer>();

        for (int n : integers) {
            if (!intToCountMap.containsKey(n)) intToCountMap.put(n, 1);
            else {
                int currentCount = intToCountMap.get(n);
                intToCountMap.put(n, ++currentCount);
            }
        }

        int maxCount = -1;

        int integerWithMaxCount = 0;

        for (Map.Entry<Integer, Integer> entry : intToCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                integerWithMaxCount = entry.getKey();
            }
        }

        return integerWithMaxCount;
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(2);
        integers.add(2);
        integers.add(3);

        int n = findMostFrequent(integers); System.out.println(n); } }
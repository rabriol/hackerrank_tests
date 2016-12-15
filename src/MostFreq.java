import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by peo_rboliveira on 07/02/16.
 */
public class MostFreq {
    //Coding challenge: given a list of integers, return the most   frequently appearing integer.
    public static void main(String[] args) {
        System.out.println(getMostFreq(new Integer[]{1, 2, 3, 4, 5, 6, 1, 2, 1 ,3, 4, 3, 4, 4, 4}));
    }

    public static Integer getMostFreq(Integer[] integers) {

        LinkedHashMap<Integer, Integer> max = new LinkedHashMap<>();

        for (Integer key : integers) {
            Integer value = max.get(key);
            max.put(key, value == null ? 1 : ++value);
        }

        Integer maxValue = null;
        Integer maxIndex = null;


        for (Map.Entry<Integer, Integer> entry: max.entrySet()) {
            if (maxValue == null || maxValue < entry.getValue()) {
                maxValue = entry.getValue();
                maxIndex = entry.getKey();
            }
        }

        return maxIndex;
    }
}



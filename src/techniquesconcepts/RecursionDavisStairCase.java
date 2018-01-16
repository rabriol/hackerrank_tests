package techniquesconcepts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rabriol on 3/5/17.
 */
public class RecursionDavisStairCase {

    private static Map<Integer, Integer> memoization = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getClimbWayAmount(7));
    }

    public static Integer getClimbWayAmount(int stairHeight) {
        if (stairHeight < 0) {
            return 0;
        }

        if (stairHeight == 0) {
            return 1;
        }

        Integer count = memoization.get(Integer.valueOf(stairHeight));
        if (count == null) {
            count = getClimbWayAmount(stairHeight - 1)
                    + getClimbWayAmount(stairHeight - 2)
                    + getClimbWayAmount(stairHeight - 3);
            memoization.put(stairHeight, count);
        }
        return count;
    }
}

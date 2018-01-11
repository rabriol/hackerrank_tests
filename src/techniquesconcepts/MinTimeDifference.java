package techniquesconcepts;

/**
 * Created by peo_rboliveira on 27/01/16.
 */
public class MinTimeDifference {
    public static void main(String[] args) {
        System.out.println(getMinTimeDifference(new String[]{"19:20", "06:45", "00:12", "23:50", "04:22"}));
    }

    public static int getMinTimeDifference(String[] times) {
        int size = times.length;
        int minValue = Integer.MAX_VALUE;

        for (int currentFirstIndex = 0; currentFirstIndex < size-1; currentFirstIndex++) {
            for (int currentSecondIndex = currentFirstIndex+1; currentSecondIndex < size; currentSecondIndex++) {

                String[] first_hour = times[currentFirstIndex].split(":");
                String[] second_hour = times[currentSecondIndex].split(":");

                int firstMinutes = (Integer.valueOf(first_hour[0]) * 60) + Integer.valueOf(first_hour[1]);
                int secondMinutes = (Integer.valueOf(second_hour[0]) * 60) + Integer.valueOf(second_hour[1]);

                int normal = getMin(firstMinutes, secondMinutes);
                int reversal = getMin(secondMinutes, firstMinutes);

                int minutes = normal > reversal ? reversal : normal;

                if (minutes < minValue) {
                    minValue = minutes;
                }
            }
        }

        return minValue;
    }

    private static int getMin(int first, int second) {
        if (first <= second) {
            return second - first;
        } else {
            return ((24 * 60) - first) + second;
        }
    }
}
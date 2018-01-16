package others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by peo_rboliveira on 12/07/17.
 */
public class FindRepeatedNumberinSlidingWindow {

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1,2,1,1,3,1};

        findDuplicateNumbersBySlidingWindow(numbers, 3);
    }

    private static void findDuplicateNumbersBySlidingWindow(Integer[] numbers, int windowSize) {
        LinkedList<Integer> stream = new LinkedList<>();
        Map<Integer, AtomicInteger> elementsCount = new HashMap<>();

        for (int index = 0; index < numbers.length; index++) {
            if (elementsCount.containsKey(numbers[index])) {
                elementsCount.get(numbers[index]).getAndIncrement();
            } else {
                elementsCount.put(numbers[index], new AtomicInteger(1));
            }

            stream.add(numbers[index]);

            if (index >= windowSize) {
                Integer element = stream.getFirst();

                if (elementsCount.get(element).get() > 1) {
                    System.out.println(element);
                    elementsCount.get(element).getAndDecrement();
                } else {
                    elementsCount.remove(element);
                }

                stream.removeFirst();
            }
        }
    }
}

package datastructures.linkedhashmap;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rabriol on 7/11/17.
 */
public class FindDuplicateInSlidingWindow {

    static Integer[] numbers1 = new Integer[]{1,2,3,2,1,1,1};
    static Integer[] numbers2 = new Integer[]{3,2,3,3,2};

    public static void main(String[] args) {
        findDuplicateInSlidingWindow(numbers1, 4);
        System.out.println("---");
        findDuplicateInSlidingWindow(numbers2, 3);
    }

    private static void findDuplicateInSlidingWindow(Integer[] numbers, int windowSize) {
        if (numbers == null || numbers.length < windowSize) {
            return;
        }

        LinkedList<Integer> stream = new LinkedList<>();
        Map<Integer, AtomicInteger> window = new HashMap<>();
        int elementsInWindow = 0;

        for (Integer number : numbers) {
            if (elementsInWindow >= windowSize) {
                Integer element = stream.pollFirst();
                if (window.get(element).get() > 1) {
                    window.get(element).getAndDecrement();
                } else {
                    window.remove(element);
                }
            }

            elementsInWindow++;

            if (window.containsKey(number)) {
                window.get(number).getAndIncrement();
                System.out.println(number);
            } else {
                window.put(number, new AtomicInteger(1));
            }

            stream.add(number);
        }
    }
}

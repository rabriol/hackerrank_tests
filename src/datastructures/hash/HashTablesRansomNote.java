package datastructures.hash; /**
 * Created by brito on 10/10/16.
 */

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HashTablesRansomNote {
    Map<String, AtomicInteger> magazineMap = new HashMap<>();
    String[] noteArray;

    public HashTablesRansomNote(String magazine, String note) {
        String[] magazineWords = magazine.split(" ");
        for (String magazineWord : magazineWords) {
            if (!magazineMap.containsKey(magazineWord)) {
                magazineMap.put(magazineWord, new AtomicInteger());
            }
            magazineMap.get(magazineWord).getAndIncrement();
        }

        noteArray = note.split(" ");
    }

    public boolean solve() {
        for (String noteWord : noteArray) {
            if (!magazineMap.containsKey(noteWord)) {
                return false;
            }

            magazineMap.get(noteWord).getAndDecrement();

            if (magazineMap.get(noteWord).get() == 0) {
                magazineMap.remove(noteWord);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        HashTablesRansomNote s = new HashTablesRansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}

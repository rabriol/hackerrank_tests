package others;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by peo_rboliveira on 01/05/17.
 */
public class TopPhrases {

    public static final String SEPARATE_BY_PIPE = "\\|";
    public static final int ONE = 1;

    /**
     * Candy | Olympics 2012 | PGA | CNET |
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println(getTopPhrases(2, "/tmp/test.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Example: Candy | Olympics 2012 | PGA | CNET |
     *
     * The complexity here is: Time O(2n) Space O(n)
     *
     * @param sizeOfTopNumbers delimit the amount of top numbers returned
     * @param fileName indicates where to locate the file
     * @return
     * @throws Exception
     */
    public static Map<String, AtomicInteger> getTopPhrases(int sizeOfTopNumbers, String fileName) throws Exception {
        Map<String, AtomicInteger> topPhrases = new LinkedHashMap<>();

        //Bufferead don't store the whole file in memory, instead of it he keeps only the line.
        //So there wont be a problem because the test constraint is: There are only 50 phrases per line
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] phrases = line.split(SEPARATE_BY_PIPE);

                for (String phrase : phrases) {

                    phrase = phrase.trim();

                    if (topPhrases.containsKey(phrase)) {
                        topPhrases.get(phrase).getAndIncrement();
                    } else {
                        topPhrases.put(phrase, new AtomicInteger(ONE));
                    }
                }
            }
        }

        return topPhrases
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((AtomicInteger a1, AtomicInteger a2) -> a2.get() - a1.get())) //to sort in descend mode
                .limit(sizeOfTopNumbers)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k1, k2) -> k1, LinkedHashMap::new));
    }
}

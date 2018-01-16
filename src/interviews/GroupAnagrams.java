package interviews;

import java.util.*;

/*
EPAM - Barclays

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat", "tan"],
  ["bat"]
]
*/

class GroupAnagrams {
    public static void main (String[] args) {
        groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"})
                .forEach(list -> {
                    list.forEach(item -> System.out.print(item + "  "));
                    System.out.println();
                });
    }



    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> anagrams = new ArrayList<>();

        Set<String> s = new HashSet<>();
        Map<String, List<String>> m = new HashMap<>();

        for (String word : strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            if (!s.add(newWord)) {
                m.get(newWord).add(word);
            } else {
                m.put(newWord, new ArrayList<>());
                m.get(newWord).add(word);
            }

        }

        for (List<String> elements : m.values()) {
            anagrams.add(elements);
        }


        return anagrams;

    }


}

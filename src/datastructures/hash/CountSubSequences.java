package datastructures.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountSubSequences {

    public static void main(String[] args) {
        String sequence = "badbbadba";
        Set<String> repteadSubSequences = findSubSequences(sequence, 1);

        System.out.println(repteadSubSequences);
    }

    private static Set<String> findSubSequences(String sequence, int window) {
        Set<String> subsequences = new HashSet<>();
        Set<String> repeatedSubsequences = new HashSet<>();

        for (int i = 0; i < sequence.length()-window; i++) {
            if (!subsequences.add(sequence.substring(i, i+window))) {
                repeatedSubsequences.add(sequence.substring(i, i+window));
            }
        }

        return repeatedSubsequences;
    }


}

package org.example.Practice;

import java.util.*;

/**
 * asked in Amazon
 */
public class TransformWords {

    public static void main(String[] args) {
        new TransformWords().transform("cat", "dog");
    }

    public void transform(String a, String b) {
        if (a.length() != b.length()) return;
        if (a.equals(b)) return;

        String[] dictArr = {"dot", "cot", "die", "cat", "cry", "dog", "abs", "bid"};
        Set<String> dict = new HashSet<>(List.of(dictArr));
        //create graph
        Map<String, List<String>> dictGraph = new HashMap<>();
        for (String word : dict) {
            List<String> connectedWords = new ArrayList<>();
            for (String target : dict) {
                if (!word.equals(target) && isEditDistance1(word, target)) {
                    connectedWords.add(target);
                }
            }
            dictGraph.put(word, connectedWords);
        }
        transformInternal(a, b, new LinkedHashSet<>(Collections.singleton(a)), dictGraph);
    }


    private boolean transformInternal(String a, String b, LinkedHashSet<String> words, Map<String, List<String>> dictGraph) {
        if (a.equals(b)) {
            words.stream().forEach(word -> System.out.println(word));
            return true;
        }

        boolean solved;
        for (String word : dictGraph.get(a)) {
            if (!words.contains(word)) {
                words.add(word);
                solved = transformInternal(word, b, words, dictGraph);
                if (!solved) words.remove(word);
                else return true;
            }
        }
        return false;
    }

    private boolean isEditDistance1(String word, String target) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                cnt++;
                if (cnt > 1) return false;
            }
        }
        return true;
    }

}

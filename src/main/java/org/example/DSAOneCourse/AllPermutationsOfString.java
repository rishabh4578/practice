package org.example.DSAOneCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllPermutationsOfString {
    public static void main(String[] args) {
        String s = "abc";
        List<String> permutations = getAllPermutations(s);
        System.out.println(permutations.stream().map(str -> "\"" + str + "\"").collect(Collectors.joining(", ")));
    }

    private static List<String> getAllPermutations(String s) {
        List<String> result = new ArrayList<>();
        getAllPermutationsInternal(s, "", result);
        return result;
    }

    private static void getAllPermutationsInternal(String s, String cur, List<String> result) {
        if (s.isEmpty()) {
            result.add(cur);
            return;
        }
        for (int i = 0; i < s.length(); i++)
            getAllPermutationsInternal(s.substring(0, i) + s.substring(i + 1), cur + s.charAt(i), result);
    }
}

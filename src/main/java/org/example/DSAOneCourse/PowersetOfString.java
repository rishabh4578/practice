package org.example.DSAOneCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PowersetOfString {

    public static void main(String[] args) {
        String s = "abc";
        List<String> powerset = getPowerset(s);
        System.out.println(powerset.stream().map(str -> "\"" + str + "\"").collect(Collectors.joining(", ")));
    }

    private static List<String> getPowerset(String s) {
        List<String> result = new ArrayList<>();
        getPowersetInternal(s.toCharArray(), 0, s.length(), "", result);
        return result;
    }

    private static void getPowersetInternal(char[] chars, int i, int length, String cur, List<String> result) {
        if (i == length) {
            result.add(cur);
            return;
        }
        getPowersetInternal(chars, i + 1, length, cur, result);
        getPowersetInternal(chars, i + 1, length, cur + chars[i], result);
    }

}

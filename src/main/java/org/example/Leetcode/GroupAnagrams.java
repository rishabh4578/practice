package org.example.Leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/submissions/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            String code = getCode(s);
            List<String> anagrams = map.containsKey(code) ? map.get(code) : new ArrayList<>();
            anagrams.add(s);
            map.put(code, anagrams);
        }
        return new ArrayList<>(map.values());
    }

    private String getCode(String s){
        int[] aux = new int[26];

        for(int i = 0; i < s.length(); i++){
            aux[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(aux[i] != 0)
                sb.append((char)(i + 'a')).append(aux[i]);
        }
        return sb.toString();
    }
}

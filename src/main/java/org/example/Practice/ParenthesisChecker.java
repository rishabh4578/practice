package org.example.Practice;

import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
 * asked in Amazon
 */
public class ParenthesisChecker {
    static boolean ispar(String x)
    {
        // add your code here
        Map<Character, Character> lookup = new HashMap<>();
        lookup.put('}', '{');
        lookup.put(']', '[');
        lookup.put(')', '(');
        Stack<Character> stk = new Stack<>();

        for(char c : x.toCharArray()){
            if(!lookup.containsKey(c)){
                stk.push(c);
            } else {
                if(stk.isEmpty()) return false;
                char top = stk.pop();
                if(top != lookup.get(c)) return false;
            }
        }
        return stk.isEmpty();
    }
}

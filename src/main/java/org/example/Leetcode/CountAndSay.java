package org.example.Leetcode;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }

    public String countAndSay(int n) {
        return casi(n, n);
    }

    private String casi(int currLevel, int n){
        if(currLevel == 1) return "1";

        String ns = casi(currLevel - 1, n);
        String s = "";
        System.out.println("currLevel: " + currLevel + ", ns: " + ns);
        char digit = ns.charAt(ns.length() - 1);
        int cnt = 0;
        for(int i = ns.length() - 1; i >= 0; i--){
            char curDigit = ns.charAt(i);
            if(curDigit == digit) cnt++;
            else{
                s = cnt + digit + s;
                cnt = 1;
                digit = curDigit;
            }
        }
        //for leftmost digit
        return cnt + digit + s;
    }
}

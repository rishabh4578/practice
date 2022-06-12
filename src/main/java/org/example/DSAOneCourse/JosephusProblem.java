package org.example.DSAOneCourse;

//https://www.youtube.com/watch?v=46zD5d9y9b4&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=9
public class JosephusProblem {

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        System.out.println(String.format("lastStandingId(%s, %s) = %s", n, k, lastStandingId(n, k)));
    }

    private static int lastStandingId(int n, int k) {
        if (n == 1)
            return 0;
        return (lastStandingId(n - 1, k) + k) % n;
    }

}

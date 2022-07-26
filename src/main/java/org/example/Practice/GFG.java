package org.example.Practice;


// JAVA program to Count
// minimum swap to make
// string palindrome
import java.util.*;
import java.io.*;

class GFG {

    // Function to Count minimum swap
    static int countSwap(String str)
    {

        // Length of string
        int n = str.length();

        // it will convert string to
        // char array
        char[] s = str.toCharArray();

        // Counter to count minimum
        // swap
        int count = 0;

        // A loop which run in half
        // string from starting
        for (int i = 0; i < n / 2; i++) {

            // Left pointer
            int left = i;

            // Right pointer
            int right = n - left - 1;

            // A loop which run from
            // right pointer to left
            // pointer
            while (left < right) {

                // if both char same
                // then break the loop
                // if not same then we
                // have to move right
                // pointer to one step
                // left
                if (s[left] == s[right]) {
                    break;
                }
                else {
                    right--;
                }
            }

            // it denotes both pointer at
            // same position and we don't
            // have sufficient char to make
            // palindrome string
            if (left == right) {
                return -1;
            }
            else {
                for (int j = right; j < n - left - 1; j++) {
                    char t = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = t;
                    count++;
                }
            }
        }

        return count;
    }
    //reverse character array
    static void reverse(char a[])
    {
        int n=a.length;
        char[] b = new char[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        String s = "acabb";

        // Function calling
        int ans1 = countSwap(s);

        char[] charArray = s.toCharArray();
        reverse(charArray);
        s = new String(charArray);

        int ans2 = countSwap(s);

        if (ans1 > ans2)
            System.out.println(ans1);
        else
            System.out.println(ans2);
    }
}
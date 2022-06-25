package org.example.Practice;

/**
 * https://practice.geeksforgeeks.org/problems/check-if-subtree/1#
 * asked in Amazon
 */
public class CheckIfSubtree {
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if (T == null && S == null) return true;
        if (T == null || S == null) return false;
        if (T.data == S.data) {
            boolean result = isSubtree(T.left, S.left) && isSubtree(T.right, S.right);
            if (result)
                return true;
        }
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }
}
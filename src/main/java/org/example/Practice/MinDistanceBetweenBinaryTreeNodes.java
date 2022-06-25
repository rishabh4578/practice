package org.example.Practice;

/**
 * https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1
 * asked in Amazon
 */
public class MinDistanceBetweenBinaryTreeNodes {
    int findDist(Node root, int a, int b) {
        // Your code here
        if (root == null) return -1;
        if (a == b) return 0;
        Node lca = lca(root, a, b);
        dist(lca, a, b, 0);
        return (lca.data == a || lca.data == b) ? Math.abs(levelA - levelB) : levelA + levelB;
    }

    private Node lca(Node node, int a, int b) {
        if (node == null) return node;

        if (node.data == a || node.data == b) return node;

        Node leftLca = lca(node.left, a, b);
        Node rightLca = lca(node.right, a, b);

        if (leftLca != null && rightLca != null) return node;

        if (leftLca == null) return rightLca;
        else return leftLca;
    }

    int levelA = -1;
    int levelB = -1;

    private void dist(Node node, int a, int b, int level) {
        if (node == null) return;

        if (levelA != -1 && levelB != -1) return;

        if (node.data == a) levelA = level;
        if (node.data == b) levelB = level;

        dist(node.left, a, b, level + 1);
        dist(node.right, a, b, level + 1);
    }

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}

package org.example.Practice;

public class BTLowestCommonAncestor {
    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right = new BTNode(3);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        BTNode lca = btLCA(root, 4, 5);
        System.out.println(lca.data);
    }

    private static BTNode btLCA(BTNode node, int n1, int n2) {
        if (node == null) return null;
        if (node.data == n1 || node.data == n2) return node;

        BTNode leftLCA = btLCA(node.left, n1, n2);
        BTNode rightLCA = btLCA(node.right, n1, n2);

        if (leftLCA != null && rightLCA != null) return node;
        else if (leftLCA != null) return leftLCA;
        else if (rightLCA != null) return rightLCA;
        else return null;
    }


    static class BTNode {
        int data;
        BTNode left;
        BTNode right;

        BTNode(int data) {
            this.data = data;
        }
    }
}

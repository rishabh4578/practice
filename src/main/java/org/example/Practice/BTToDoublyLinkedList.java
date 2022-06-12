package org.example.Practice;

public class BTToDoublyLinkedList {
    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right = new BTNode(3);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        DLLNode head = btToDLL(root);
        printDLL(head);
    }

    private static void printDLL(DLLNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static DLLNode btToDLL(BTNode root) {
        DLL dll = new DLL();
        btToDDLInternal(root, dll);
        return dll.head;
    }

    private static void btToDDLInternal(BTNode node, DLL dll) {
        if (node == null) return;
        btToDDLInternal(node.left, dll);
        dll.addNode(node.data);
        btToDDLInternal(node.right, dll);
    }

    static class BTNode {
        int data;
        BTNode left;
        BTNode right;

        BTNode(int data) {
            this.data = data;
        }
    }

    static class DLLNode {
        int data;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int data) {
            this.data = data;
        }
    }

    static class DLL {
        DLLNode head;
        DLLNode tail;

        void addNode(int data) {
            DLLNode node = new DLLNode(data);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
    }
}

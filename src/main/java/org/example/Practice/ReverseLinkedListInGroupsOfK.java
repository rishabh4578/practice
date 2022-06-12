package org.example.Practice;

public class ReverseLinkedListInGroupsOfK {

    private static Node nextGrpStart = null;
    private static Node reversedLLHead = null;
    private static Node prevTail = null;

    public static void main(String[] args) {
        Node head = new Node(1);
        head.link(2).link(3).link(4).link(5).link(6).link(7).link(8);
        int k = 3;
        printLL(head);
        Node reverseLLHead = reverseGrouped(head, k);
        printLL(reverseLLHead);
    }

    private static void printLL(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    private static Node reverseGrouped(Node head, int k) {
        nextGrpStart = head;
        while (nextGrpStart != null) {
            prevTail = rgInternal(nextGrpStart, k, 0);
            prevTail.next = null;
        }
        return reversedLLHead;
    }

    private static Node rgInternal(Node node, int k, int grpSz) {
        if (node == null || grpSz == k) {
            nextGrpStart = node;
            return null;
        }
        Node nextNode = rgInternal(node.next, k, grpSz + 1);
        if (nextNode == null) {
            if (prevTail != null) prevTail.next = node;
            if (reversedLLHead == null) reversedLLHead = node;
        } else {
            nextNode.next = node;
        }
        return node;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node link(int data) {
            Node nextNode = new Node(data);
            this.next = nextNode;
            return nextNode;
        }

    }

}

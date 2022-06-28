package org.example.Leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
 */
public class RemoveDuplicatesFromSortedLL {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode prev = head;
        ListNode node = head.next;

        while (node != null && node.val == prev.val) { //head has duplicates
            int headVal = head.val;
            while (prev.val == headVal) {
                if (node == null) return null; //LL only contains same repeated element
                prev = node;
                node = node.next;
            }

            head = prev; //head updated
            node = head.next;
        }

        while (node != null) {

            boolean foundDuplicates = false;

            //delete all repeating next
            while (node.next != null && node.val == node.next.val) {
                foundDuplicates = true;
                node.next = node.next.next;
            }

            //delete current
            if (foundDuplicates) {
                prev.next = node.next;
            } else {
                prev = node;
            }

            node = node.next;
        }
        return head;
    }


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

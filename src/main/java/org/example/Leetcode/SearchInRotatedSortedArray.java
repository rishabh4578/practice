package org.example.Leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
 * asked in LinkedIn
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return searchInternal(nums, 0, nums.length - 1, target);
    }

    private int searchInternal(int[] nums, int l, int r, int target) {
        if (l > r) return -1;
        if (l == r) {
            if (nums[l] == target) return l;
            else return -1;
        }

        int mid = (l + r) / 2;
        if (target == nums[mid]) return mid;

        if (nums[l] > nums[mid]) { //bp is on left
            if (target < nums[mid]) {
                return searchInternal(nums, l, mid - 1, target);
            } else {
                if (target == nums[r]) return r;
                else if (target > nums[r]) //search in left
                    return searchInternal(nums, l, mid - 1, target);
                else
                    return searchInternal(nums, mid + 1, r, target); //search in right
            }
        } else if (nums[r] < nums[mid]) { //bp is on right
            if (target > nums[mid]) {
                return searchInternal(nums, mid + 1, r, target);
            } else {
                if (target == nums[l]) return l;
                else if (target < nums[l]) //search in right
                    return searchInternal(nums, mid + 1, r, target);
                else
                    return searchInternal(nums, l, mid - 1, target); //search in left
            }
        } else {
            if (target < nums[mid])
                return searchInternal(nums, l, mid - 1, target);
            else
                return searchInternal(nums, mid + 1, r, target);
        }
    }
}

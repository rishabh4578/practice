package org.example.Leetcode;

public class FirstAndLastPositionInSortedArr {

    public static void main(String[] args) {
        int[] result = new FirstAndLastPositionInSortedArr().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(String.format("first: %s, last: %s", result[0], result[1]));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] rslt = {-1, -1};
        if (nums == null || nums.length == 0) return rslt;
        return sri(nums, rslt, 0, nums.length - 1, target);
    }

    private int[] sri(int[] nums, int[] rslt, int l, int r, int target) {
        if (l > r) return rslt;

        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            if (mid - 1 == -1 || nums[mid - 1] != target) { // mid is start
                rslt[0] = mid;
            } else {
                //traverse left half
                rslt = sri(nums, rslt, l, mid - 1, target);
            }

            if (rslt[0] != -1 && rslt[1] != -1) return rslt; //found both positions

            if (mid + 1 == nums.length || nums[mid + 1] != target) {// mid is end
                rslt[1] = mid;
            } else {
                //traverse right
                rslt = sri(nums, rslt, mid + 1, r, target);
            }
            return rslt;
        } else if (target < nums[mid]) {
            return sri(nums, rslt, l, mid - 1, target);
        } else {
            return sri(nums, rslt, mid + 1, r, target);
        }

    }
}

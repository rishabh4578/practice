package org.example.Leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/submissions/
 * asked in Google
 */
public class SearchInSortedArrayII {
    public boolean search(int[] nums, int target) {
        return searchInternal(nums, 0, nums.length - 1, target);
    }

    private boolean searchInternal(int[] nums, int l, int r, int target){
        if(l > r) return false;
        if(l == r && nums[l] == target) return true;

        int mid = (l + r)/2;
        if(nums[mid] == target) return true;

        if(target < nums[mid]){
            if((nums[l] < nums[mid] && (nums[mid] < nums[r] || nums[mid] == nums[r])) ||
                    (nums[r] > nums[mid] && (nums[mid] > nums[l] || nums[mid] == nums[l]))){//no pivot
                return searchInternal(nums, l, mid - 1, target);
            }else if(nums[l] == nums[r] || nums[l] > nums[mid] || nums[r] < nums[mid]){//can be any side
                boolean found = searchInternal(nums, mid + 1, r, target);
                return found ? true : searchInternal(nums, l, mid - 1, target);
            }
        }else{
            if((nums[l] < nums[mid] && (nums[mid] < nums[r] || nums[mid] == nums[r])) ||
                    (nums[r] > nums[mid] && (nums[mid] > nums[l] || nums[mid] == nums[l]))){//no pivot
                return searchInternal(nums, mid + 1, r, target);
            }else if(nums[l] == nums[r] || nums[l] > nums[mid] || nums[r] < nums[mid]){//can be any side
                boolean found = searchInternal(nums, mid + 1, r, target);
                return found ? true : searchInternal(nums, l, mid - 1, target);
            }
        }
        return false;
    }
}

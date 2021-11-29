package Sorting;

import Util.Swap;

public class QuickSelect {
    public static int quickSelect(int [] nums, int k, int start, int end){
        if(start >= end){
            return nums[k];
        }
        int mid = nums[(start + end) / 2];
        int left = start;
        int right = end;
        while(left <= right){
            while(left <= right && nums[left] < mid){
                left += 1;
            }
            while(left <= right && nums[right] > mid){
                right -= 1;
            }
            if(left <= right){
                Swap.swap(nums, left, right);
                left += 1;
                right -= 1;
            }
        }
        if(right  >= k){
            return quickSelect(nums, k, start, right);
        }
        else if (left <= k){
            return quickSelect(nums, k , left, end);
        }
        return nums[k];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(quickSelect(nums,nums.length - k, 0, nums.length - 1));
    }
}

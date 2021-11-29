package Sorting;

import java.util.Arrays;

import static Util.Swap.swap;

public class QuickSort {
    public static void quickSort(int [] nums, int start, int end){
        if (start >= end){
            return;
        }
        int mid = nums[(start + end) / 2];
        int left = start;
        int right = end;
        while (left <= right){
            while(left <= right && nums[left] < mid){
                left += 1;
            }
            while(left <= right && nums[right] > mid){
                right -= 1;
            }
            if(left <= right){
                swap(nums, left, right);
                left += 1;
                right -= 1;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    public static void main(String[] args) {
        int [] nums = {
                5,1,1,2,0,0};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}

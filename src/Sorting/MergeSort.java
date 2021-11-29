package Sorting;

import Util.Swap;

public class MergeSort {
    public static int [] mergeSort(int [] nums){
        if (nums.length == 1){
            return nums;
        }
        if(nums.length == 2){
            if(nums[1] < nums[0]){
                Swap.swap(nums,0,1);
            }
            return nums;
        }
        int mid = nums.length / 2;
        int [] left = new int [mid];
        int [] right = new int [nums.length - mid];
        for(int i  =0; i <mid; i ++){
            left[i] = nums[i];
        }
        for(int i = mid; i < nums.length; i ++){
            right[i-mid] = nums[i];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < mid && p2 < nums.length - mid){
            if(left[p1] < right[p2]){
                nums[p3] = left[p1];
                p1 += 1;
            }
            else{
                nums[p3] = right[p2];
                p2 += 1;
            }
            p3 += 1;
        }
        while (p1 < mid){
            nums[p3] = left[p1];
            p1 += 1;
            p3 += 1;
        }
        while(p2 < nums.length - mid){
            nums[p3] = right[p2];
            p2 += 1;
            p3 += 1;
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}

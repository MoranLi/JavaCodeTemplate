package Heap;

import java.util.Arrays;

import static Util.Swap.swap;

public class Heap {
    //min heap
    private static void minHeapify(int [] nums, int size, int i){
        int smallest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if(left < size && nums[left] < nums[smallest]){
            smallest = left;
        }
        if(right < size && nums[right] < nums[smallest]){
            smallest = right;
        }
        if(smallest != i){
            swap(nums,smallest,i);
            minHeapify(nums, size,smallest);
        }
    }

    //max heap
    private static void maxHeapify(int [] nums, int size, int i){
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if(left < size && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < size && nums[right] > nums[largest]){
            largest = right;
        }
        if(largest != i){
            swap(nums,largest,i);
            maxHeapify(nums, size,largest);
        }
    }

    public static void minHeapify(int [] nums){
        for(int i = nums.length / 2; i >= 0; i --){
            minHeapify(nums, nums.length, i);
        }
    }


    public static void heapSort(int [] nums){
        for(int i = nums.length / 2; i >= 0; i --){
            maxHeapify(nums, nums.length, i);
        }
        for(int i = nums.length - 1; i >= 0; i --){
            swap(nums, i, 0);
            maxHeapify(nums, i, 0);
        }
    }

    public static void main(String[] args) {
        int [] input = {1,1,2,2,3,3,4,3};
        System.out.println(Arrays.toString(input));
    }

}

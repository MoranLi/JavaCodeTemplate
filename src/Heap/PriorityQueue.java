package Heap;

import Util.Swap;

public class PriorityQueue {

    private int [] nums;
    private int size;

    public PriorityQueue() {
        nums = new int[100];
        size = 0;
    }

    public void add(int n){
        if(size == 100){
            return;
        }
        nums[size] = n;
        shiftUp(size);
        size ++;
    }

    public int poll(){
        int ans = nums[0];
        nums[0] = nums[size - 1];
        nums[size - 1] = 0;
        size --;
        if(size > 0){
            shiftDown(0);
        }
        return ans;
    }

    public int peek(){
        return nums[0];
    }


    private void shiftUp(int n){
        if(n > 0) {
            if (n % 2 == 0) {
                int parent = (n - 2) / 2;
                if (nums[n] < nums[parent]) {
                    Swap.swap(nums, n, parent);
                    shiftUp(parent);
                }
            }
            else {
                int parent = (n - 1) / 2;
                if (nums[n] < nums[parent]) {
                    Swap.swap(nums, n, parent);
                    shiftUp(parent);
                }
            }
        }
    }

    private void shiftDown(int n){
        int left = n * 2 + 1;
        int right = n * 2 + 2;
        int smallest = n;
        if(left < 100 && nums[left] < nums[smallest]){
            smallest = left;
        }
        if(right < 100 && nums[right] < nums[smallest]){
            smallest = right;
        }
        if(smallest != n){
            Swap.swap(nums, n, smallest);
            shiftDown(smallest);
        }
    }


}

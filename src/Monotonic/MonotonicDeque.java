package Monotonic;

import java.util.Deque;
import java.util.LinkedList;

public class MonotonicDeque {
    public int[] SlidingWindowMaximum(int[] nums, int k) {
        Deque<Integer> window = new LinkedList<>();
        int [] ans = new int [nums.length - k + 1];
        int startindex = -k + 1;
        for(int i = 0; i < nums.length; i ++){
            while(window.size() > 0 && i - window.getFirst() >= k) window.removeFirst();
            while(window.size() > 0 && nums[window.getLast()] < nums[i]) window.removeLast();
            window.addLast(i);
            if(startindex >= 0) ans[startindex] = nums[window.getFirst()];
            startindex ++;
        }
        return ans;
    }
}

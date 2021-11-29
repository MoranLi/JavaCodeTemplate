package Monotonic;

import java.util.HashMap;
import java.util.Stack;

/*
the key is to find do we need a increasing / decreasing subsequence of data
the use stack to carry the data
 */

public class MonotonicStack {
    public int[] NextGreaterElementI(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> h = new HashMap<>();
        nextgreater(nums2, h);
        int [] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i ++){
            ans[i] = h.get(nums1[i]);
        }
        return ans;
    }
    public void nextgreater(int [] nums, HashMap<Integer, Integer> ans){
        Stack<Integer> stack = new Stack();
        for(int i = nums.length -1; i > -1; i --){
            while(stack.size() > 0 && stack.peek() < nums[i]){
                stack.pop();
            }
            ans.put(nums[i], stack.size() > 0 ? stack.peek() : -1);
            stack.add(nums[i]);
        }
    }
}

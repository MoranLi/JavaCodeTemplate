package TwoPointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KSum {
    public List<List<Integer>> twoSum(int [] nums, int k, int target){
        int start = k;
        int end = nums.length - 1;
        List<List<Integer>> ans = new LinkedList<>();
        while(start < end){
            if (nums[start] + nums[end] > target || (end < nums.length -1 && nums[end] == nums[end + 1])){
                end -= 1;
            }
            else if  (nums[start] + nums[end] < target || (start > k && nums[start] == nums[start-1])){
                start += 1;
            }
            else{
                List<Integer> t = new LinkedList<>();
                t.add(nums[start]);
                t.add(nums[end]);
                start ++;
                end --;
                ans.add(t);
            }
        }
        return ans;
    }
    public List<List<Integer>> ksum(int [] nums, int start, int target, int k){
        List<List<Integer>> ans = new LinkedList<>();
        if (start == nums.length){
            return ans;
        }
        int avg = target / k;
        if(avg < nums[start] || avg > nums[nums.length-1]){
            return ans;
        }
        if(k == 2){
            return twoSum(nums, start, target);
        }
        for(int i = start; i < nums.length;i ++){
            if(i == start || nums[i-1] != nums[i]){
                for(List<Integer> res : ksum(nums, i + 1, target - nums[i], k - 1)){
                    res.add(0, nums[i]);
                    ans.add(res);
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return ksum(nums, 0, target, 4);
    }
    public static void main(String[] args) {
        KSum s = new KSum();
        int [] nums = {-2,-1,-1,1,1,2,2};
        List<List<Integer>> k = s.fourSum(nums, 0);
        for(List ks : k){
            for(Object n : ks){
                System.out.print(n);
                System.out.println(" ");
            }
            System.out.println();
        }
    }
}

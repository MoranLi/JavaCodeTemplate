package DFS;
import java.util.*;
public class Backtrack {

    /*
    常见4把刀减枝方法
    sort倒序，task先做大的这样可以累积时间先达到终止条件
    global的result, 如果我们是求最小值，当过程中结果已经大于res的时候我们就直接停止
    跳过重复的元素，类似permutation里面
    改变搜索思路，单向遍历较多的task可以大幅提升速度。一般大的数据部分pointer单向递增，小数据的部分可以增加backtracking的遍历，比如i为task, backtrack每次for loop为session见最后一题。比如1434题帽子比人多，就单向帽子

     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(ans, new LinkedList<>(), nums, 0);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int [] nums, int p){
        ans.add(new LinkedList<>(curr));
        for(int i = p; i < nums.length; i ++){
            curr.add(nums[i]);
            backtrack(ans, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}

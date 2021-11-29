package ScanLine;

import java.util.*;

public class Skyline {
    // example of combine 1 & 2
    // combine l;ine to point, but sort then
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int []> list = new LinkedList<>();
        for(int i = 0; i < buildings.length; i ++){
            list.add(new int []{buildings[i][0], -buildings[i][2]});
            list.add(new int []{buildings[i][1], buildings[i][2]});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        pq.offer(0);
        int premax = 0;
        List<List<Integer>> ans = new LinkedList<>();
        for(int [] p: list){
            if(p[1] < 0) pq.add(-p[1]);
            else pq.remove(p[1]);
            int max = pq.peek();
            if(max != premax){
                ans.add(List.of(p[0], max));
                premax = max;
            }
        }
        return ans;
    }
}

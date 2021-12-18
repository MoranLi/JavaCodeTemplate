import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> connect = new HashMap<>();
        for(int [] edge : edges){
            HashSet<Integer> set1 = connect.getOrDefault(edge[0], new HashSet<Integer>());
            set1.add(edge[1]);
            connect.put(edge[0], set1);
            HashSet<Integer> set2 =connect.getOrDefault(edge[1], new HashSet<Integer>());
            set2.add(edge[0]);
            connect.put(edge[1], set2);
        }
        List<Integer> leaves = new LinkedList<>();
        for(Integer key: connect.keySet()){
            if(connect.get(key).size() == 1){
                leaves.add(key);
            }
        }
        int remains = n;
        while(remains > 2){
            List<Integer> newLeaves = new LinkedList<>();
            for(Integer leaf: leaves){
                connect.remove(leaf);
                remains --;
                for(Integer key: connect.keySet()){
                    if(connect.get(key).contains(leaf)){
                        connect.get(key).remove(leaf);
                        if(connect.get(key).size() == 1){
                            newLeaves.add(key);
                        }
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] edges = {{1,0},{1,2},{1,3}};
        System.out.println(s.findMinHeightTrees(4,edges));
    }
}
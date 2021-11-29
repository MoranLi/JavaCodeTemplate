package BFS;

import java.util.*;

public class CourseSchedule {
    // topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> depend = new HashMap<>();
        for(int i = 0; i < numCourses; i ++){
            depend.put(i, new HashSet<>());
        }
        for(int [] prereq : prerequisites){
            depend.get(prereq[0]).add(prereq[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++){
            if(depend.get(i).size() == 0){
                q.offer(i);
                depend.remove(i);
            }
        }
        int removed = 0;
        while(q.size() > 0){
            Integer c = q.poll();
            depend.remove(c);
            removed ++;
            for(Integer k : depend.keySet()){
                if(depend.get(k).contains(c)){
                    depend.get(k).remove(c);
                    if(depend.get(k).size() == 0){
                        q.offer(k);
                    }
                }
            }
        }
        return removed == numCourses;
    }
}

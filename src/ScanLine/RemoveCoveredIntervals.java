package ScanLine;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    // template 2, we sort all interval base on some log, then go through
    // 1 by 1, and check base on condition
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        if(intervals.length == 0){
            return 0;
        }
        int c = 0, e = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.length; i ++){
            if(e < intervals[i][1]){
                e = intervals[i][1];
                c ++;
            }
        }
        return c;
    }
}

package ScanLine;
import java.util.*;
public class MinMeetingZoom {
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    // template 1, check if problem cna transfer to merge interval,
    // if yes transfer it to point and go though points
    public int minMeetingRooms(List<Interval> intervals) {
        List<Point> points = new LinkedList<>();
        for(Interval i: intervals){
            // if start should after end, use this, else switch
            points.add(new Point(i.start, 1));
            points.add(new Point(i.end, -1));
        }
        Collections.sort(points, (p1, p2) -> {
            if(p1.time == p2.time){
                return p1.type - p2.type;
            }
            return p1.time - p2.time;
        });
        int c = 0;
        int ans = 0;
        for(Point p : points){
            if(p.type == 1) c ++;
            else c --;
            ans = Math.max(ans, c);
        }
        return ans;
    }
}

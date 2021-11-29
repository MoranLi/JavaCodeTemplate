package ScanLine;

public class Point implements Comparable<Point>{
    int time;
    int type;
    public Point(int time, int type){
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Point o) {
        if(this.time == o.time){
            return type - o.type;
        }
        return time - o.time;
    }
}

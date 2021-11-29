package Graph;

import java.util.HashSet;

public class Node implements Comparable<Node>{
    int val;
    int distance;
    HashSet<Node> connected;

    public Node(int val) {
        this.val = val;
        this.distance = 0;
        connected = new HashSet<>();
    }

    public Node(int val, int distance) {
        this.val = val;
        this.distance = distance;
        connected = new HashSet<>();
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return distance - o.distance;
    }
}

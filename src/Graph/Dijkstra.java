package Graph;

import java.util.PriorityQueue;

public class Dijkstra {
    /*
    * assume structure of path input is
    * [
    * [0,5,2],
    * [5,0,1],
    * [2,1,0]
    * ]
    * array[i][j] means a undirected edge between i and j and with weight array[i][j]
     */
    public int dijkstra(int [][] connected, int start, int end){
        PriorityQueue<Node> q = new PriorityQueue();
        Node startNode = new Node(start, 0);
        q.add(startNode);
        Node [] visited = new Node[connected.length];
        // distance of start is 0
        visited[start] = startNode;
        while (q.size() > 0){
            Node n = q.poll();
            if(n.distance > visited[n.val].distance){
                continue;
            }
            for(int i  = 0; i < connected[n.val].length; i ++){
                // skip itself
                if(connected[n.val][i] != -1) {
                    if (i == n.val) {
                        continue;
                    }
                    if (visited[i] == null) {
                        Node newNode = new Node(i, visited[n.val].distance + connected[n.val][i]);
                        visited[i] = newNode;
                        q.offer(newNode);
                    } else {
                        int newDistance = visited[n.val].distance + connected[n.val][i];
                        if(newDistance < visited[i].distance){
                            visited[i].setDistance(newDistance);
                            q.add(new Node(i, newDistance));
                        }
                        //visited[i] = Math.min(visited[i], visited[n] + connected[n][i]);
                    }
                }
            }
        }
        return visited[end].distance;
    }
}

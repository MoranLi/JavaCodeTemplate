import java.util.LinkedList;
import java.util.Queue;

public class StreamChecker {
    class Node{
        Character c;
        boolean end;
        Node [] child;

        public Node(Character c){
            this.c = c;
            end = false;
            child = new Node[26];
        }
    }

    Node root;
    Queue<Node> pts;

    private void insert(String s){
        Node p = root;
        int index = 0;
        while(index < s.length()){
            if(p.child[s.charAt(index) - 'a'] == null){
                p.child[s.charAt(index) - 'a'] = new Node(s.charAt(index));
            }
            p = p.child[s.charAt(index) - 'a'];
            index ++;
        }
        p.end = true;
    }

    public StreamChecker(String[] words) {
        root = new Node(null);
        for(String s: words){
            insert(s);
        }
        pts = new LinkedList<>();
    }

    public boolean query(char letter) {
        Queue<Node> remain = new LinkedList<>();
        boolean ans = false;
        while(!pts.isEmpty()){
            Node pt = pts.poll();
            if(pt.child[letter - 'a'] != null){
                pt = pt.child[letter - 'a'];
                ans = ans || pt.end;
                remain.add(pt);
            }
        }
        if(root.child[letter - 'a'] != null){
            remain.add(root.child[letter - 'a']);
            ans = ans || root.child[letter - 'a'].end;
        }
        pts = remain;
        return ans;
    }

    public static void main(String[] args) {
        String [] test = {"ab","ba","aaab","abab","baa"};
        Character [] cs = {'a','a','a','a','a','b','a','b','a','b','b','b','a','b','a','b','b','b','b','a','b','a','b','a','a','a','b','a','a','a'};
        StreamChecker sc = new StreamChecker(test);
        for(Character c : cs){
            System.out.println(sc.query(c));
        }
    }

}

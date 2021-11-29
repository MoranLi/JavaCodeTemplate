package Trie;
class Trie {

    class Node{
        Character c;
        boolean end;
        Node [] child;
        public Node(Character c) {
            this.c = c;
            end = false;
            child = new Node[26];
        }
    }
    Node root;

    public Trie() {
        root = new Node(null);
    }

    public void insert(String s) {
        Node n = root;
        int index = 0;
        while(index < s.length()){
            if(n.child[s.charAt(index) - 'a'] == null){
                n.child[s.charAt(index) - 'a'] = new Node(s.charAt(index));
            }
            n = n.child[s.charAt(index) - 'a'];
            index ++;
        }
        n.end = true;
    }

    private Node searchHelper(String s){
        Node n = root;
        int index = 0;
        while(index < s.length()){
            if(n.child[s.charAt(index)- 'a'] == null) {
                return null;
            }
            n = n.child[s.charAt(index)- 'a'];
            index ++;
        }
        return n;
    }

    public boolean search(String s) {
        Node n = searchHelper(s);
        return n != null && n.end;
    }

    public boolean startsWith(String s) {
        Node n = searchHelper(s);
        return n != null;
    }
}
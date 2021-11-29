package Trie;

public class BitWiseTree {
    class Node{
        // use boolean to save memory
        // false = 0, true = 1
        Boolean bit;
        int val;
        // left for 0, right for 1
        Node left;
        Node right;
        public Node(Integer n) {
            this.bit = n == null ? null : n == 1;
            val = 0;
            left = null;
            right = null;
        }
    }
    Node root;
    String [] binary;

    private String toBinary(int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }

    public BitWiseTree(int [] nums) {
        root = new Node(null);
        binary = new String [nums.length];
        int length = 0;
        for(int i = 0; i < nums.length; i ++){
            binary[i] = toBinary(nums[i]);
            length = Math.max(length, binary[i].length());
        }
        for(int i = 0; i < nums.length; i ++){
            while(binary[i].length() < length){
                binary[i] = "0" + binary[i];
            }
            insert(binary[i], nums[i]);
        }
    }

    public void insert(String num, int nint){
        Node n = root;
        int k = 0;
        while(k < num.length()){
            Node c = null;
            if(num.charAt(k) == '0'){
                if(n.left == null){
                    n.left = new Node(0);
                }
                n = n.left;
            }
            else{
                if(n.right == null){
                    n.right = new Node(1);
                }
                n = n.right;
            }
            k += 1;
        }
        n.val = nint;
    }

    private int search(int i){
        String num = binary[i];
        Node n = root;
        int k = 0;
        while(k < num.length() && (n.left != null || n.right != null)){
            if(num.charAt(k) == '0'){
                if(n.right == null){
                     n = n.left;
                }
                else {
                    n = n.right;
                }
            }
            else{
                if(n.left == null){
                    n = n.right;
                }
                else {
                    n = n.left;
                }
            }
            k += 1;
        }
        return n.val;
    }

}

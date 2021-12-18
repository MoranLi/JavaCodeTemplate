import java.util.Stack;

public class Tree {
    class Node {
        public int iData;
        public double dData;
        public Node leftNode;
        public Node rightNode;
    }
    Node root;
    public Node find(int key){
        Node n = root;
        while(n != null && n.iData != key){
            if(n.iData > key){
                n = n.leftNode;
            }
            else{
                n = n.rightNode;
            }
        }
        return n;
    }

    public void insert(int id, double dd){
        Node t = new Node();
        t.iData = id;
        t.dData = dd;
        Node n = root;
        while(n != null){
            if(n.iData > id){
                if(n.leftNode == null){
                    n.leftNode = t;
                    break;
                }
                else{
                    n = n.leftNode;
                }
            }
            else{
                if(n.rightNode == null){
                    n.rightNode = t;
                    break;
                }
                else{
                    n = n.rightNode;
                }
            }
        }
        if(root == null){
            root = t;
        }
    }

    public boolean delete(int key){
        Node header = new Node();
        header.leftNode = root;
        Node curr = root, parent = header;
        while(curr != null && curr.iData != key){
            parent = curr;
            if(curr.iData > key){
                curr = curr.leftNode;
            }
            else{
                curr = curr.rightNode;
            }
        }
        if(curr == null){
            return false;
        }
        Node next = curr.rightNode, nextParent = curr;
        while(next != null && next.leftNode != null){
            nextParent = next;
            next = next.leftNode;
        }
        if (next == null){
            if(curr == parent.leftNode){
                parent.leftNode = curr.leftNode;
            }
            else{
                parent.rightNode = curr.leftNode;
            }
            return true;
        }
        else{
            curr.iData = next.iData;
            curr.dData = next.dData;
            nextParent.leftNode = null;
            return true;
        }
    }

    class pair{
        public boolean is = true;
        public int leftLeast;
        public int leftMost;
        public int rightMost;
        public int rightLeast;
    }

    public boolean isBST(Tree t){
        return isBSTHelper(t.root);
    }

    private boolean isBSTHelper(Node n){
        Stack<Node> stack = new Stack<>();
        int prev = Integer.MIN_VALUE;
        while(true){
            if(n != null){
                stack.add(n);
                n = n.leftNode;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                n = stack.pop();
                if(n.iData <= prev){
                    return false;
                }
                prev = n.iData;
                n = n.rightNode;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(1,1.1);
        t.insert(3,3.3);
        t.insert(5,5.5);
        t.insert(2,2.2);
        t.insert(4,4.4);
        t.insert(6,6.6);
        System.out.println(t.find(1).dData);
        System.out.println(t.find(5).dData);
        System.out.println(t.find(6).dData);
        t.delete(6);
        t.delete(3);
        t.delete(1);
    }

}
